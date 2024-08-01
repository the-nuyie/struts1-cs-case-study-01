package com.casestudy.cs.action;

import com.casestudy.cs.form.LoginForm;
import com.casestudy.cs.service.quartz.job.SimpleGreetingJob;
import com.casestudy.cs.util.DateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ActivateJobAction extends Action {

    private final String DATE_FORMAT = "yyyyMMdd-HHmmss";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try{

            // Suffix
            String strDate = DateUtil.dateToString(new Date(),DATE_FORMAT);

            // Create Quartz Job
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            String triggerName = "SimpleGreetingIntervalEnd_"+strDate;
            String groupName = "SimpleGroup";
            Date startTime = new Date();
            int numberOfRepeat = 5;
            int intervalInSeconds = 10;

            String jobName = "SimpleGreetingJob_"+strDate;

            // Create Trigger
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, groupName)
                    .startAt(startTime)
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(intervalInSeconds)          // schedule once, it will perform task for one time, this value is useless.
                                    .withRepeatCount(numberOfRepeat))
                    .build();
            System.out.println("stdout - Trigger Created : "+triggerName+" at:"+new Date());

            // Create data of Job
            Map<String, String> jobDataHash = new HashMap<>();
            jobDataHash.put("jobID", "20240725001");
            jobDataHash.put("firstname", "Conte");
            JobDataMap dataMap = new JobDataMap(jobDataHash);
            System.out.println("stdout - Job Created : "+jobName+" at:"+new Date());

            // Create Job
            JobDetail jobInstance = JobBuilder.newJob(SimpleGreetingJob.class)
                    .withIdentity(jobName, groupName)
                    .usingJobData(dataMap)
                    .build();

            // Start Schedule
            scheduler.scheduleJob(jobInstance, trigger);
            scheduler.start();
            System.out.println("stdout - Scheduler started at:"+new Date());

            return mapping.findForward("success");
        }catch(Exception ex){
            return mapping.findForward("failure");
        }



    }
}
