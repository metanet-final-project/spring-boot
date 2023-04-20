package com.example.finalproject.quartz;

import com.example.finalproject.service.AgeService;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.function.Function;

@Configuration
public class QuartzConfig implements WebMvcConfigurer {

    private Scheduler scheduler;
    private ApplicationContext applicationContext;

    public static String APPLICATION_NAME = "appContext";

    public QuartzConfig(Scheduler scheduler, ApplicationContext applicationContext) {
        this.scheduler = scheduler;
        this.applicationContext = applicationContext;
    }

    //스케줄 트리거 등록
    @PostConstruct
    public void schInit() throws SchedulerException {
        final Function<String, Trigger> trigger = (exp) -> TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(exp)).build();

        JobDataMap ctx = new JobDataMap();
        ctx.put(APPLICATION_NAME, applicationContext);

        JobDetail timeOverBooking = JobBuilder.newJob(TimeOverBooking.class)
                .setJobData(ctx)
                .build();

        JobDetail createSchedule = JobBuilder.newJob(CreateSchedule.class)
                .setJobData(ctx)
                .build();

        JobDetail testSchedule = JobBuilder.newJob(TestSchedule.class)
                .setJobData(ctx)
                .build();

        // timeOverBooking // 기간만료로 booking 테이블의 상태 변경
        scheduler.scheduleJob(timeOverBooking, trigger.apply("0 0 0 1/1 * ? *")); // 하루마다 실행

        // 스케줄러 크론 표현식으로 주기적 실행
        scheduler.scheduleJob(createSchedule, trigger.apply("0 0 23 * * ?")); // 매일 정각 23시에 실행

        // 기존 더미데이터 추가 후 한번만 실행하고 주석 처리(이틀치 배차 생성)
        //scheduler.scheduleJob(testSchedule, trigger.apply("0 0/1 0/1 1/1 * ? *")); // 1분 후 한번 실행

        //scheduler.scheduleJob(createSchedule, trigger.apply("* * * * * * ?")); // 1분마다 실행
        //scheduler.scheduleJob(createSchedule, trigger.apply("0 0 0 * * * ?")); // 하루마다 실행
    }
}
