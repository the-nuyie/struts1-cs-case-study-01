package com.casestudy.cs.service.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SimpleGreetingJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(SimpleGreetingJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String jobId = (String) jobDataMap.get("jobID");
        String firstName = (String) jobDataMap.get("firstname");
        logger.info("Job Started-"+jobId+" at:"+new Date());
        logger.info("  Hi "+firstName+"!!\n");

        System.out.println("stdout - Job Started-"+jobId+" at:"+new Date());
        System.out.println("stdout -   Hi "+firstName+"!!\n");
    }
}
