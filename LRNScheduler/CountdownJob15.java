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

/*A job for our scheduler that calls the static method runCountdown 
 * from the Countdown class, passing in 15 as the int argument.
 * Creates and displays a 15 second countdown animation.
 */
package LRNScheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Colin
 */
public class CountdownJob15 implements Job {
    
    public CountdownJob15() { }
    
    @Override
        public void execute(JobExecutionContext context)
            throws JobExecutionException {
            Countdowns.Countdown.runCountdown(15);  
        }
    
}
