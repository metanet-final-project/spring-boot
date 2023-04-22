package com.example.finalproject.quartz;

import com.example.finalproject.service.BookingService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TimeOverBooking extends QuartzJobBean {

    private BookingService bookingService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if(bookingService == null) {
            ApplicationContext appCtx = (ApplicationContext)context.getJobDetail()
                    .getJobDataMap().get("appContext");
            bookingService = appCtx.getBean(BookingService.class);

            try {
                if (bookingService.timeOverBooking() == 1) {
                    System.out.println("기간 만료 수정 완료.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
