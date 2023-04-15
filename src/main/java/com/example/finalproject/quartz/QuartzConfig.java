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
        JobDetail annualCreateNewYearJob = JobBuilder.newJob(CreateSchedule.class)
                .setJobData(ctx)
                .build();

        // 스케줄러 크론 표현식으로 주기적 실행
        scheduler.scheduleJob(annualCreateNewYearJob, trigger.apply("0 * * * * ?")); // 1초마다 실행
        //scheduler.scheduleJob(annualCreateNewYearJob, trigger.apply("* * * * * * ?")); // 1분마다 실행
        //scheduler.scheduleJob(annualCreateNewYearJob, trigger.apply("0 0 0 * * * ?")); // 하루마다 실행
    }
}
