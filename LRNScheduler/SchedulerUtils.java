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

/*Contains two static methods for use with the Quartz scheduler. setWeeklyCalendar
 * creates a Quartz WeeklyCalendar and sets the calendar's excluded days using values
 * from a saved .txt file. startScheduler instantiates a Quartz scheduler, adds 
 * the required job and triggers based on saved user data, and starts the scheduler. 
 */
package LRNScheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.JobBuilder.*;
import org.quartz.JobDetail;
import static org.quartz.JobKey.*;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.WeeklyCalendar;


public class SchedulerUtils {
    
    public static void setWeeklyCalendar(WeeklyCalendar cal){
        //get excluded days from file created by settings GUI
        try {
            try (Scanner scan = new Scanner(new File("excludedDays.txt"))) {
                int[] days = { java.util.Calendar.SUNDAY, java.util.Calendar.MONDAY, 
                    java.util.Calendar.TUESDAY, java.util.Calendar.WEDNESDAY,
                    java.util.Calendar.THURSDAY, java.util.Calendar.FRIDAY,
                    java.util.Calendar.SATURDAY };
                //set excluded days in our WeeklyCalendar
                for(int day : days) {
                    cal.setDayExcluded(day, Boolean.valueOf(scan.next()));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SchedulerUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Scheduler startScheduler() throws SchedulerException {
        
        SchedulerFactory schedFact = new StdSchedulerFactory("Configuration/quartz.properties");
        
        Scheduler sched = schedFact.getScheduler();
        
        sched.start();
       
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();
        
        //get showtimes and length of show from file created by settings GUI
        try {
            try (Scanner scan = new Scanner(new File("showtimes.txt"))) {
                while(scan.hasNext()){
                    //add show length and showtime to our ArrayLists
                    mins.add(Integer.parseInt(scan.nextLine()));
                    times.add(scan.nextLine());
                }
                
                    WeeklyCalendar weekly = new WeeklyCalendar();
                    //setWeeklyCalendar gets excluded days and sets them in calendar
                    setWeeklyCalendar(weekly);
                    sched.addCalendar("weekly", weekly, true, true);
                    //check for and delete any jobs already on the scheduler
                    for(int i = 0; i < 7; i++) {
                        if(sched.checkExists(jobKey("showClock" + i, "ShowClockGroup"))) {
                        sched.deleteJob(jobKey("showClock" + i, "ShowClockGroup"));
                    }
                    }
                    //instantiate our jobs and triggers
                    for(int i = 0; i < mins.size(); i++) {
                    JobDetail showClock = newJob(ShowClockJob.class)
                            .withIdentity("showClock" + i, "ShowClockGroup")
                            //pass in show's length to be used by ShowClockJob
                            .usingJobData("min", mins.get(i))
                            .build();
                        
                    Trigger showTrigger = newTrigger()
                            .withIdentity("showTrigger" + i, "ShowClockGroup")
                            .withSchedule(cronSchedule(times.get(i))
                                .withMisfireHandlingInstructionFireAndProceed())
                            .modifiedByCalendar("weekly")
                            .build();
                    //schedule job with trigger
                    sched.scheduleJob(showClock, showTrigger); 
                }
            
        }
                
        } catch (SchedulerException | FileNotFoundException ex) {
            Logger.getLogger(SchedulerUtils.class.getName()).log(Level.SEVERE, null, ex);
        }  
        //return the scheduler for use in our main class
        return sched;
    }
}
