/***************************************************************************
*   LRN Show Clock. Flashes a countdown on screen to warn user of          *
*   beginning and end of commercial break, for radio programs. Runs        *
*   during user configured showtimes, with breaks based on Liberty         *
*   Radio Network schedule.                                                *
*                                                                          *
*   Copyright (C) 2014  Colin Michael McCoy                                *
*                                                                          *
*   This program is free software: you can redistribute it and/or modify   *
*   it under the terms of the GNU General Public License as published by   *
*   the Free Software Foundation, either version 3 of the License, or      *   
*   (at your option) any later version.                                    *
*                                                                          *
*   This program is distributed in the hope that it will be useful,        *
*   but WITHOUT ANY WARRANTY; without even the implied warranty of         *
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the          *
*   GNU General Public License for more details.                           *
*                                                                          *
*   You should have received a copy of the GNU General Public License      *
*   along with this program.  If not, see <http://www.gnu.org/licenses/>.  *
*                                                                          *
*   To contact the author, write to mick4747@gmail.com.                    *
*                                                                          *
***************************************************************************/

/*ShowClockJob is an implementation of the quartz Job class that instantiates 
 * two other quartz jobs, CountdownJob15 and CountdownJob60, and creates and
 * registers triggers for them. The show's runtime is passed in through the job's 
 * DataMap, then converted to milliseconds. After setting up the countdown jobs,
 * ShowClockJob sleeps for the length of the showtime, then removes the countdown
 * jobs from the scheduler.
 */
package LRNScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.quartz.CronScheduleBuilder.*;
import org.quartz.Job;
import static org.quartz.JobBuilder.*;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import static org.quartz.JobKey.*;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.*;


public class ShowClockJob implements Job {
    
    public ShowClockJob() {}
    
    @Override
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        JobDataMap dm = context.getJobDetail().getJobDataMap();
        int min = dm.getInt("min");  //show's runtime in minutes
        int ms = min * 60000;  //convert the runtime in minutes to millisec
        Scheduler sched = context.getScheduler();  //get the scheduler from the current context
        
        //create countdown jobs and triggers
        JobDetail countdown15 = newJob(CountdownJob15.class)
                .withIdentity("countdown15", "countdownGroup")
                .build();
        
        JobDetail countdown60 = newJob(CountdownJob60.class)
                .withIdentity("countdown60", "countdownGroup")
                .build();
        
        Trigger countdown15Trigger1 = newTrigger()
                .withIdentity("countdown15Trigger1", "countdownGroup")
                .withSchedule(cronSchedule("45 5 * * * ?")
                    .withMisfireHandlingInstructionDoNothing())
                .forJob("countdown15", "countdownGroup")
                .build();
        
        Trigger countdown15Trigger2 = newTrigger()
                .withIdentity("countdown15Trigger2", "countdownGroup")
                .withSchedule(cronSchedule("55 19,32,46 * * * ?")
                    .withMisfireHandlingInstructionDoNothing())
                .forJob(jobKey("countdown15", "countdownGroup"))
                .build();
        
        Trigger countdown60Trigger1 = newTrigger()
                .withIdentity("countdown60Trigger1", "countdownGroup")
                .withSchedule(cronSchedule("0 17,29,44 * * * ?")
                    .withMisfireHandlingInstructionDoNothing())
                .forJob(jobKey("countdown60", "countdownGroup"))
                .build();
        
        Trigger countdown60Trigger2 = newTrigger()
                .withIdentity("countdown60Trigger2", "countdownGroup")
                .withSchedule(cronSchedule("50 57 * * * ?")
                    .withMisfireHandlingInstructionDoNothing())
                .forJob("countdown60", "countdownGroup")
                .build();
        //add the jobs and triggers to scheduler
        try {
            sched.scheduleJob(countdown15, countdown15Trigger1);
            sched.scheduleJob(countdown15Trigger2);
            sched.scheduleJob(countdown60, countdown60Trigger1);
            sched.scheduleJob(countdown60Trigger2);
            
            Thread.sleep(ms);  //sleep for the length of the showtime, 
        
            //...then remove the countdown jobs from the scheduler
            sched.deleteJob(jobKey("countdown15","countdownGroup"));
            sched.deleteJob(jobKey("countdown60","countdownGroup"));
        } catch (SchedulerException | InterruptedException ex) {
            Logger.getLogger(ShowClockJob.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }   
}
