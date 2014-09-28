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


package ProjectResources;

import LRNScheduler.SchedulerUtils;
import SettingsGui.ShowtimeSettings;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;




public class Main {
    
    public static void main(String args[]) throws SchedulerException {
        //start the scheduler
        final Scheduler sched = SchedulerUtils.startScheduler();
        //add an icon to the system tray
        TrayIcon icon = null;
        if(SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = new ImageIcon(Main.class.getResource(
                "ShowClockTrayLogo.png")).getImage();
            ActionListener settingsListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //bring up the settings GUI
                    ShowtimeSettings.showtimeSettings();
                }
            };
            ActionListener closeListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //shutdown scheduler
                        sched.shutdown();
                    } catch (SchedulerException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //close application
                    System.exit(0);
                }
            };
            //create popup menu for tray icon and add settings and close options
            PopupMenu popup = new PopupMenu();
            MenuItem settings = new MenuItem("Settings");
            settings.addActionListener(settingsListener);
            popup.add(settings);
            MenuItem close = new MenuItem("Close");
            close.addActionListener(closeListener);
            popup.add(close);
            icon = new TrayIcon(image, "ShowClock Settings", popup);
            icon.addActionListener(settingsListener);
            try {
                tray.add(icon);
            } catch (AWTException e) {
                System.err.println(e);
            }
        }
        
        
    }
    
}
