package com.example.finalproject.quartz;

import com.example.finalproject.service.ScheduleService;
import org.springframework.context.ApplicationContext;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CreateSchedule extends QuartzJobBean {

    private ScheduleService scheduleService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if(scheduleService == null) {
            ApplicationContext appCtx = (ApplicationContext)context.getJobDetail()
                    .getJobDataMap().get("appContext");
            scheduleService = appCtx.getBean(ScheduleService.class);

            try {
                if (scheduleService.createDailySchedule()) {
                    System.out.println("배차 생성 완료.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
