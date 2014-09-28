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
 
/* Countdown extends JDialog. A Countdown instance is a clear, undecorated JDialog
 * containing a NumberPane. Countdown class includes static method runCountdown,
 * which is called by the two countdown jobs to create a countdown animation.
 */

package Countdowns;

import java.awt.Color;
import java.awt.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;


public class Countdown extends JDialog {
    
    NumberPane np;
    
    public Countdown(int i) {
                setUndecorated(true);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                np = new NumberPane(i);
                add(np);
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        
    
    //Makes the rest of the JDialog transparent while leaving the NumberPane visible
     public static void setOpaque(Window window, boolean opaque) {

        String version = System.getProperty("java.runtime.version");
        if (version.startsWith("1.7")) {
            window.setBackground(new Color(0, 0, 0, 0));
        } else {
            try {
                Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
                if (awtUtilsClass != null) {

                    Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
                    method.invoke(null, window, opaque);

                }
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException exp) {
            }
        }
    }
     
     /*Creates a countdown animation by generating a series of Countdown dialogs
      * with descending ints, generating a new dialog and disposing the last every
      * one second
      */
     public static void runCountdown(final int FIRST) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
             @SuppressWarnings("SleepWhileInLoop")
            public void run() {
                int count = FIRST;
                while(count > 0) {
                    Countdown countdown = new Countdown(count);
                    setOpaque(countdown, false);
                    long ms = System.currentTimeMillis();
                    try {
                        Thread.sleep(1000 - ms % 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Countdown.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    countdown.dispose();
                    count--;
                } 
            } 
         });
     }
}
