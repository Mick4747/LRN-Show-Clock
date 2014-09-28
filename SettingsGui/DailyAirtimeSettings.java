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

package SettingsGui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;

/**
 *
 * @author Colin
 */
public class DailyAirtimeSettings extends javax.swing.JDialog {

    /**
     * Creates new form DailyAirtimeSettings
     */
    
    /*sun-sat booleans are passed in from the previous frame, based on what days
    were checked by user */
    public DailyAirtimeSettings(java.awt.Frame parent, boolean modal, boolean sun,
            boolean mon, boolean tue, boolean wed, boolean thu, boolean fri, boolean sat) {
        super(parent, modal);
        this.setIconImage(new ImageIcon(getClass().getResource(
                "ShowClockWindowLogo.png")).getImage());
        /*
         * daily_selections.txt saves the values selected the last time the Daily
         *Airtime Settings dialog was opened.
        */
        File f = new File("daily_selections.txt");
        //check if the values for daily airtimes settings have previously been set by user
        if(f.exists()) {
            //get the values from daily_selections.txt and set them in our variables
            try {
                try (Scanner scan = new Scanner(new File("daily_selections.txt"))) {
                    sunStartHour = Integer.parseInt(scan.nextLine());
                    sunEndHour = Integer.parseInt(scan.nextLine());
                    sunStartMinute = Integer.parseInt(scan.nextLine());
                    sunEndMinute = Integer.parseInt(scan.nextLine());
                    sunStartValue1 = scan.nextLine();
                    sunStartValue2 = scan.nextLine();
                    sunEndValue1 = scan.nextLine();
                    sunEndValue2 = scan.nextLine();
                    monStartHour = Integer.parseInt(scan.nextLine());
                    monEndHour = Integer.parseInt(scan.nextLine());
                    monStartMinute = Integer.parseInt(scan.nextLine());
                    monEndMinute = Integer.parseInt(scan.nextLine());
                    monStartValue1 = scan.nextLine();
                    monStartValue2 = scan.nextLine();
                    monEndValue1 = scan.nextLine();
                    monEndValue2 = scan.nextLine();
                    tueStartHour = Integer.parseInt(scan.nextLine());
                    tueEndHour = Integer.parseInt(scan.nextLine());
                    tueStartMinute = Integer.parseInt(scan.nextLine());
                    tueEndMinute = Integer.parseInt(scan.nextLine());
                    tueStartValue1 = scan.nextLine();
                    tueStartValue2 = scan.nextLine();
                    tueEndValue1 = scan.nextLine();
                    tueEndValue2 = scan.nextLine();
                    wedStartHour = Integer.parseInt(scan.nextLine());
                    wedEndHour = Integer.parseInt(scan.nextLine());
                    wedStartMinute = Integer.parseInt(scan.nextLine());
                    wedEndMinute = Integer.parseInt(scan.nextLine());
                    wedStartValue1 = scan.nextLine();
                    wedStartValue2 = scan.nextLine();
                    wedEndValue1 = scan.nextLine();
                    wedEndValue2 = scan.nextLine();
                    thuStartHour = Integer.parseInt(scan.nextLine());
                    thuEndHour = Integer.parseInt(scan.nextLine());
                    thuStartMinute = Integer.parseInt(scan.nextLine());
                    thuEndMinute = Integer.parseInt(scan.nextLine());
                    thuStartValue1 = scan.nextLine();
                    thuStartValue2 = scan.nextLine();
                    thuEndValue1 = scan.nextLine();
                    thuEndValue2 = scan.nextLine();
                    friStartHour = Integer.parseInt(scan.nextLine());
                    friEndHour = Integer.parseInt(scan.nextLine());
                    friStartMinute = Integer.parseInt(scan.nextLine());
                    friEndMinute = Integer.parseInt(scan.nextLine());
                    friStartValue1 = scan.nextLine();
                    friStartValue2 = scan.nextLine();
                    friEndValue1 = scan.nextLine();
                    friEndValue2 = scan.nextLine();
                    satStartHour = Integer.parseInt(scan.nextLine());
                    satEndHour = Integer.parseInt(scan.nextLine());
                    satStartMinute = Integer.parseInt(scan.nextLine());
                    satEndMinute = Integer.parseInt(scan.nextLine());
                    satStartValue1 = scan.nextLine();
                    satStartValue2 = scan.nextLine();
                    satEndValue1 = scan.nextLine();
                    satEndValue2 = scan.nextLine();
                }
            }catch (IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        initComponents();
        this.sun = sun;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        
        //enable showtime setting options for each day that was selected
        if(sun) {
            sunEndAmPm.setEnabled(true);
            sunEndColon.setEnabled(true);
            sunEndHourSpinner.setEnabled(true);
            sunEndLabel.setEnabled(true);
            sunEndMinuteSpinner.setEnabled(true);
            sunStartAmPm.setEnabled(true);
            sunStartColon.setEnabled(true);
            sunStartHourSpinner.setEnabled(true);
            sunStartLabel.setEnabled(true);
            sunStartMinuteSpinner.setEnabled(true);
            sundayLabel.setEnabled(true);
        }
        if(mon) {
            monEndAmPm.setEnabled(true);
            monEndColon.setEnabled(true);
            monEndHourSpinner.setEnabled(true);
            monEndLabel.setEnabled(true);
            monEndMinuteSpinner.setEnabled(true);
            monStartAmPm.setEnabled(true);
            monStartColon.setEnabled(true);
            monStartHourSpinner.setEnabled(true);
            monStartLabel.setEnabled(true);
            monStartMinuteSpinner.setEnabled(true);
            mondayLabel.setEnabled(true);
        }
        if(tue) {
            tueEndAmPm.setEnabled(true);
            tueEndColon.setEnabled(true);
            tueEndHourSpinner.setEnabled(true);
            tueEndLabel.setEnabled(true);
            tueEndMinuteSpinner.setEnabled(true);
            tueStartAmPm.setEnabled(true);
            tueStartColon.setEnabled(true);
            tueStartHourSpinner.setEnabled(true);
            tueStartLabel.setEnabled(true);
            tueStartMinuteSpinner.setEnabled(true);
            tuesdayLabel.setEnabled(true);
        }
         if(wed) {
            wedEndAmPm.setEnabled(true);
            wedEndColon.setEnabled(true);
            wedEndHourSpinner.setEnabled(true);
            wedEndLabel.setEnabled(true);
            wedEndMinuteSpinner.setEnabled(true);
            wedStartAmPm.setEnabled(true);
            wedStartColon.setEnabled(true);
            wedStartHourSpinner.setEnabled(true);
            wedStartLabel.setEnabled(true);
            wedStartMinuteSpinner.setEnabled(true);
            wednesdayLabel.setEnabled(true);
        }
        if(thu) {
            thuEndAmPm.setEnabled(true);
            thuEndColon.setEnabled(true);
            thuEndHourSpinner.setEnabled(true);
            thuEndLabel.setEnabled(true);
            thuEndMinuteSpinner.setEnabled(true);
            thuStartAmPm.setEnabled(true);
            thuStartColon.setEnabled(true);
            thuStartHourSpinner.setEnabled(true);
            thuStartLabel.setEnabled(true);
            thuStartMinuteSpinner.setEnabled(true);
            thursdayLabel.setEnabled(true);
        }
        if(fri) {
            friEndAmPm.setEnabled(true);
            friEndColon.setEnabled(true);
            friEndHourSpinner.setEnabled(true);
            friEndLabel.setEnabled(true);
            friEndMinuteSpinner.setEnabled(true);
            friStartAmPm.setEnabled(true);
            friStartColon.setEnabled(true);
            friStartHourSpinner.setEnabled(true);
            friStartLabel.setEnabled(true);
            friStartMinuteSpinner.setEnabled(true);
            fridayLabel.setEnabled(true);
        }
        if(sat) {
            satEndAmPm.setEnabled(true);
            satEndColon.setEnabled(true);
            satEndHourSpinner.setEnabled(true);
            satEndLabel.setEnabled(true);
            satEndMinuteSpinner.setEnabled(true);
            satStartAmPm.setEnabled(true);
            satStartColon.setEnabled(true);
            satStartHourSpinner.setEnabled(true);
            satStartLabel.setEnabled(true);
            satStartMinuteSpinner.setEnabled(true);
            saturdayLabel.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dailyAirtimesPanel = new javax.swing.JPanel();
        dailyAirtimesHeader = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sundayLabel = new javax.swing.JLabel();
        mondayLabel = new javax.swing.JLabel();
        tuesdayLabel = new javax.swing.JLabel();
        wednesdayLabel = new javax.swing.JLabel();
        thursdayLabel = new javax.swing.JLabel();
        fridayLabel = new javax.swing.JLabel();
        saturdayLabel = new javax.swing.JLabel();
        sunStartHourSpinner = new javax.swing.JSpinner();
        sunStartLabel = new javax.swing.JLabel();
        monStartLabel = new javax.swing.JLabel();
        tueStartLabel = new javax.swing.JLabel();
        wedStartLabel = new javax.swing.JLabel();
        thuStartLabel = new javax.swing.JLabel();
        friStartLabel = new javax.swing.JLabel();
        satStartLabel = new javax.swing.JLabel();
        monStartHourSpinner = new javax.swing.JSpinner();
        tueStartHourSpinner = new javax.swing.JSpinner();
        wedStartHourSpinner = new javax.swing.JSpinner();
        thuStartHourSpinner = new javax.swing.JSpinner();
        friStartHourSpinner = new javax.swing.JSpinner();
        satStartHourSpinner = new javax.swing.JSpinner();
        sunStartColon = new javax.swing.JLabel();
        monStartColon = new javax.swing.JLabel();
        tueStartColon = new javax.swing.JLabel();
        wedStartColon = new javax.swing.JLabel();
        thuStartColon = new javax.swing.JLabel();
        friStartColon = new javax.swing.JLabel();
        satStartColon = new javax.swing.JLabel();
        sunStartMinuteSpinner = new javax.swing.JSpinner();
        monStartMinuteSpinner = new javax.swing.JSpinner();
        tueStartMinuteSpinner = new javax.swing.JSpinner();
        wedStartMinuteSpinner = new javax.swing.JSpinner();
        thuStartMinuteSpinner = new javax.swing.JSpinner();
        friStartMinuteSpinner = new javax.swing.JSpinner();
        satStartMinuteSpinner = new javax.swing.JSpinner();
        sunStartAmPm = new javax.swing.JSpinner();
        monStartAmPm = new javax.swing.JSpinner();
        tueStartAmPm = new javax.swing.JSpinner();
        wedStartAmPm = new javax.swing.JSpinner();
        thuStartAmPm = new javax.swing.JSpinner();
        friStartAmPm = new javax.swing.JSpinner();
        satStartAmPm = new javax.swing.JSpinner();
        sunEndLabel = new javax.swing.JLabel();
        monEndLabel = new javax.swing.JLabel();
        tueEndLabel = new javax.swing.JLabel();
        wedEndLabel = new javax.swing.JLabel();
        thuEndLabel = new javax.swing.JLabel();
        friEndLabel = new javax.swing.JLabel();
        satEndLabel = new javax.swing.JLabel();
        sunEndHourSpinner = new javax.swing.JSpinner();
        monEndHourSpinner = new javax.swing.JSpinner();
        tueEndHourSpinner = new javax.swing.JSpinner();
        wedEndHourSpinner = new javax.swing.JSpinner();
        thuEndHourSpinner = new javax.swing.JSpinner();
        friEndHourSpinner = new javax.swing.JSpinner();
        satEndHourSpinner = new javax.swing.JSpinner();
        sunEndColon = new javax.swing.JLabel();
        monEndColon = new javax.swing.JLabel();
        tueEndColon = new javax.swing.JLabel();
        wedEndColon = new javax.swing.JLabel();
        thuEndColon = new javax.swing.JLabel();
        friEndColon = new javax.swing.JLabel();
        satEndColon = new javax.swing.JLabel();
        sunEndMinuteSpinner = new javax.swing.JSpinner();
        monEndMinuteSpinner = new javax.swing.JSpinner();
        tueEndMinuteSpinner = new javax.swing.JSpinner();
        wedEndMinuteSpinner = new javax.swing.JSpinner();
        thuEndMinuteSpinner = new javax.swing.JSpinner();
        friEndMinuteSpinner = new javax.swing.JSpinner();
        satEndMinuteSpinner = new javax.swing.JSpinner();
        sunEndAmPm = new javax.swing.JSpinner();
        monEndAmPm = new javax.swing.JSpinner();
        tueEndAmPm = new javax.swing.JSpinner();
        wedEndAmPm = new javax.swing.JSpinner();
        thuEndAmPm = new javax.swing.JSpinner();
        friEndAmPm = new javax.swing.JSpinner();
        satEndAmPm = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daily Airtimes");
        setResizable(false);

        dailyAirtimesPanel.setBackground(new java.awt.Color(255, 255, 255));

        dailyAirtimesHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dailyAirtimesHeader.setText("Set Daily Airtimes");

        sundayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sundayLabel.setText("Sunday");
        sundayLabel.setEnabled(false);

        mondayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mondayLabel.setText("Monday");
        mondayLabel.setEnabled(false);

        tuesdayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tuesdayLabel.setText("Tuesday");
        tuesdayLabel.setEnabled(false);

        wednesdayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        wednesdayLabel.setText("Wednesday");
        wednesdayLabel.setEnabled(false);

        thursdayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        thursdayLabel.setText("Thursday");
        thursdayLabel.setEnabled(false);

        fridayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fridayLabel.setText("Friday");
        fridayLabel.setEnabled(false);

        saturdayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saturdayLabel.setText("Saturday");
        saturdayLabel.setEnabled(false);

        sunStartHourSpinner.setModel(new CyclingSpinnerNumberModel(sunStartHour,1,12,1));
        sunStartHourSpinner.setEnabled(false);
        sunStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sunStartHourSpinnerStateChanged(evt);
            }
        });

        sunStartLabel.setText("Start");
        sunStartLabel.setEnabled(false);

        monStartLabel.setText("Start");
        monStartLabel.setEnabled(false);

        tueStartLabel.setText("Start");
        tueStartLabel.setEnabled(false);

        wedStartLabel.setText("Start");
        wedStartLabel.setEnabled(false);

        thuStartLabel.setText("Start");
        thuStartLabel.setEnabled(false);

        friStartLabel.setText("Start");
        friStartLabel.setEnabled(false);

        satStartLabel.setText("Start");
        satStartLabel.setEnabled(false);

        monStartHourSpinner.setModel(new CyclingSpinnerNumberModel(monStartHour,1,12,1));
        monStartHourSpinner.setEnabled(false);
        monStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monStartHourSpinnerStateChanged(evt);
            }
        });

        tueStartHourSpinner.setModel(new CyclingSpinnerNumberModel(tueStartHour,1,12,1));
        tueStartHourSpinner.setEnabled(false);
        tueStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tueStartHourSpinnerStateChanged(evt);
            }
        });

        wedStartHourSpinner.setModel(new CyclingSpinnerNumberModel(wedStartHour,1,12,1));
        wedStartHourSpinner.setEnabled(false);
        wedStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wedStartHourSpinnerStateChanged(evt);
            }
        });

        thuStartHourSpinner.setModel(new CyclingSpinnerNumberModel(thuStartHour,1,12,1));
        thuStartHourSpinner.setEnabled(false);
        thuStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thuStartHourSpinnerStateChanged(evt);
            }
        });

        friStartHourSpinner.setModel(new CyclingSpinnerNumberModel(friStartHour,1,12,1));
        friStartHourSpinner.setEnabled(false);
        friStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                friStartHourSpinnerStateChanged(evt);
            }
        });

        satStartHourSpinner.setModel(new CyclingSpinnerNumberModel(satStartHour,1,12,1));
        satStartHourSpinner.setEnabled(false);
        satStartHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                satStartHourSpinnerStateChanged(evt);
            }
        });

        sunStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sunStartColon.setText(":");
        sunStartColon.setEnabled(false);

        monStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        monStartColon.setText(":");
        monStartColon.setEnabled(false);

        tueStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tueStartColon.setText(":");
        tueStartColon.setEnabled(false);

        wedStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        wedStartColon.setText(":");
        wedStartColon.setEnabled(false);

        thuStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        thuStartColon.setText(":");
        thuStartColon.setEnabled(false);

        friStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        friStartColon.setText(":");
        friStartColon.setEnabled(false);

        satStartColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        satStartColon.setText(":");
        satStartColon.setEnabled(false);

        sunStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(sunStartMinute,0,59,1));
        sunStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(sunStartMinuteSpinner, "00"));
        sunStartMinuteSpinner.setEnabled(false);
        sunStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sunStartMinuteSpinnerStateChanged(evt);
            }
        });

        monStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(monStartMinute,0,59,1));
        monStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(monStartMinuteSpinner, "00"));
        monStartMinuteSpinner.setEnabled(false);
        monStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monStartMinuteSpinnerStateChanged(evt);
            }
        });

        tueStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(tueStartMinute,0,59,1));
        tueStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(tueStartMinuteSpinner, "00"));
        tueStartMinuteSpinner.setEnabled(false);
        tueStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tueStartMinuteSpinnerStateChanged(evt);
            }
        });

        wedStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(wedStartMinute,0,59,1));
        wedStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(wedStartMinuteSpinner, "00"));
        wedStartMinuteSpinner.setEnabled(false);
        wedStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wedStartMinuteSpinnerStateChanged(evt);
            }
        });

        thuStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(thuStartMinute,0,59,1));
        thuStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(thuStartMinuteSpinner, "00"));
        thuStartMinuteSpinner.setEnabled(false);
        thuStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thuStartMinuteSpinnerStateChanged(evt);
            }
        });

        friStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(friStartMinute,0,59,1));
        friStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(friStartMinuteSpinner, "00"));
        friStartMinuteSpinner.setEnabled(false);
        friStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                friStartMinuteSpinnerStateChanged(evt);
            }
        });

        satStartMinuteSpinner.setModel(new CyclingSpinnerNumberModel(satStartMinute,0,59,1));
        satStartMinuteSpinner.setEditor(new JSpinner.NumberEditor(satStartMinuteSpinner, "00"));
        satStartMinuteSpinner.setEnabled(false);
        satStartMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                satStartMinuteSpinnerStateChanged(evt);
            }
        });

        sunStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {sunStartValue1, sunStartValue2}));
        sunStartAmPm.setEnabled(false);
        sunStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sunStartAmPmStateChanged(evt);
            }
        });

        monStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {monStartValue1, monStartValue2}));
        monStartAmPm.setEnabled(false);
        monStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monStartAmPmStateChanged(evt);
            }
        });

        tueStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {tueStartValue1, tueStartValue2}));
        tueStartAmPm.setEnabled(false);
        tueStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tueStartAmPmStateChanged(evt);
            }
        });

        wedStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {wedStartValue1, wedStartValue2}));
        wedStartAmPm.setEnabled(false);
        wedStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wedStartAmPmStateChanged(evt);
            }
        });

        thuStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {thuStartValue1, thuStartValue2}));
        thuStartAmPm.setEnabled(false);
        thuStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thuStartAmPmStateChanged(evt);
            }
        });

        friStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {friStartValue1, friStartValue2}));
        friStartAmPm.setEnabled(false);
        friStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                friStartAmPmStateChanged(evt);
            }
        });

        satStartAmPm.setModel(new CyclingSpinnerListModel(new String[] {satStartValue1, satStartValue2}));
        satStartAmPm.setEnabled(false);
        satStartAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                satStartAmPmStateChanged(evt);
            }
        });

        sunEndLabel.setText("End");
        sunEndLabel.setEnabled(false);

        monEndLabel.setText("End");
        monEndLabel.setEnabled(false);

        tueEndLabel.setText("End");
        tueEndLabel.setEnabled(false);

        wedEndLabel.setText("End");
        wedEndLabel.setEnabled(false);

        thuEndLabel.setText("End");
        thuEndLabel.setEnabled(false);

        friEndLabel.setText("End");
        friEndLabel.setEnabled(false);

        satEndLabel.setText("End");
        satEndLabel.setEnabled(false);

        sunEndHourSpinner.setModel(new CyclingSpinnerNumberModel(sunEndHour,1,12,1));
        sunEndHourSpinner.setEnabled(false);
        sunEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sunEndHourSpinnerStateChanged(evt);
            }
        });

        monEndHourSpinner.setModel(new CyclingSpinnerNumberModel(monEndHour,1,12,1));
        monEndHourSpinner.setEnabled(false);
        monEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monEndHourSpinnerStateChanged(evt);
            }
        });

        tueEndHourSpinner.setModel(new CyclingSpinnerNumberModel(tueEndHour,1,12,1));
        tueEndHourSpinner.setEnabled(false);
        tueEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tueEndHourSpinnerStateChanged(evt);
            }
        });

        wedEndHourSpinner.setModel(new CyclingSpinnerNumberModel(wedEndHour,1,12,1));
        wedEndHourSpinner.setEnabled(false);
        wedEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wedEndHourSpinnerStateChanged(evt);
            }
        });

        thuEndHourSpinner.setModel(new CyclingSpinnerNumberModel(thuEndHour,1,12,1));
        thuEndHourSpinner.setEnabled(false);
        thuEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thuEndHourSpinnerStateChanged(evt);
            }
        });

        friEndHourSpinner.setModel(new CyclingSpinnerNumberModel(friEndHour,1,12,1));
        friEndHourSpinner.setEnabled(false);
        friEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                friEndHourSpinnerStateChanged(evt);
            }
        });

        satEndHourSpinner.setModel(new CyclingSpinnerNumberModel(satEndHour,1,12,1));
        satEndHourSpinner.setEnabled(false);
        satEndHourSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                satEndHourSpinnerStateChanged(evt);
            }
        });

        sunEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sunEndColon.setText(":");
        sunEndColon.setEnabled(false);

        monEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        monEndColon.setText(":");
        monEndColon.setEnabled(false);

        tueEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tueEndColon.setText(":");
        tueEndColon.setEnabled(false);

        wedEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        wedEndColon.setText(":");
        wedEndColon.setEnabled(false);

        thuEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        thuEndColon.setText(":");
        thuEndColon.setEnabled(false);

        friEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        friEndColon.setText(":");
        friEndColon.setEnabled(false);

        satEndColon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        satEndColon.setText(":");
        satEndColon.setEnabled(false);

        sunEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(sunEndMinute,0,59,1));
        sunEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(sunEndMinuteSpinner, "00"));
        sunEndMinuteSpinner.setEnabled(false);
        sunEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sunEndMinuteSpinnerStateChanged(evt);
            }
        });

        monEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(monEndMinute,0,59,1));
        monEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(monEndMinuteSpinner, "00"));
        monEndMinuteSpinner.setEnabled(false);
        monEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monEndMinuteSpinnerStateChanged(evt);
            }
        });

        tueEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(tueEndMinute,0,59,1));
        tueEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(tueEndMinuteSpinner, "00"));
        tueEndMinuteSpinner.setEnabled(false);
        tueEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tueEndMinuteSpinnerStateChanged(evt);
            }
        });

        wedEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(wedEndMinute,0,59,1));
        wedEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(wedEndMinuteSpinner, "00"));
        wedEndMinuteSpinner.setEnabled(false);
        wedEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wedEndMinuteSpinnerStateChanged(evt);
            }
        });

        thuEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(thuEndMinute,0,59,1));
        thuEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(thuEndMinuteSpinner, "00"));
        thuEndMinuteSpinner.setEnabled(false);
        thuEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thuEndMinuteSpinnerStateChanged(evt);
            }
        });

        friEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(friEndMinute,0,59,1));
        friEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(friEndMinuteSpinner, "00"));
        friEndMinuteSpinner.setEnabled(false);
        friEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                friEndMinuteSpinnerStateChanged(evt);
            }
        });

        satEndMinuteSpinner.setModel(new CyclingSpinnerNumberModel(satEndMinute,0,59,1));
        satEndMinuteSpinner.setEditor(new JSpinner.NumberEditor(satEndMinuteSpinner, "00"));
        satEndMinuteSpinner.setEnabled(false);
        satEndMinuteSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                satEndMinuteSpinnerStateChanged(evt);
            }
        });

        sunEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {sunEndValue1, sunEndValue2}));
        sunEndAmPm.setEnabled(false);
        sunEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sunEndAmPmStateChanged(evt);
            }
        });

        monEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {monEndValue1, monEndValue2}));
        monEndAmPm.setEnabled(false);
        monEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monEndAmPmStateChanged(evt);
            }
        });

        tueEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {tueEndValue1, tueEndValue2}));
        tueEndAmPm.setEnabled(false);
        tueEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tueEndAmPmStateChanged(evt);
            }
        });

        wedEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {wedEndValue1, wedEndValue2}));
        wedEndAmPm.setEnabled(false);
        wedEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wedEndAmPmStateChanged(evt);
            }
        });

        thuEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {thuEndValue1, thuEndValue2}));
        thuEndAmPm.setEnabled(false);
        thuEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thuEndAmPmStateChanged(evt);
            }
        });

        friEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {friEndValue1, friEndValue2}));
        friEndAmPm.setEnabled(false);
        friEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                friEndAmPmStateChanged(evt);
            }
        });

        satEndAmPm.setModel(new CyclingSpinnerListModel(new String[] {satEndValue1, satEndValue2}));
        satEndAmPm.setEnabled(false);
        satEndAmPm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                satEndAmPmStateChanged(evt);
            }
        });

        applyButton.setText("Apply");
        applyButton.setEnabled(false);
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dailyAirtimesPanelLayout = new javax.swing.GroupLayout(dailyAirtimesPanel);
        dailyAirtimesPanel.setLayout(dailyAirtimesPanelLayout);
        dailyAirtimesPanelLayout.setHorizontalGroup(
            dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thursdayLabel)
                            .addComponent(fridayLabel)
                            .addComponent(saturdayLabel)
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tuesdayLabel)
                                    .addComponent(wednesdayLabel))
                                .addGap(27, 27, 27)
                                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wedStartLabel)
                                    .addComponent(tueStartLabel)
                                    .addComponent(thuStartLabel)
                                    .addComponent(friStartLabel)
                                    .addComponent(satStartLabel)))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mondayLabel)
                                    .addComponent(sundayLabel))
                                .addGap(46, 46, 46)
                                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sunStartLabel)
                                    .addComponent(monStartLabel))))
                        .addGap(27, 27, 27)
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(satStartHourSpinner)
                            .addComponent(tueStartHourSpinner)
                            .addComponent(sunStartHourSpinner)
                            .addComponent(monStartHourSpinner)
                            .addComponent(wedStartHourSpinner)
                            .addComponent(thuStartHourSpinner)
                            .addComponent(friStartHourSpinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(satStartColon)
                            .addComponent(friStartColon)
                            .addComponent(thuStartColon)
                            .addComponent(wedStartColon)
                            .addComponent(tueStartColon)
                            .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sunStartColon, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(monStartColon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(satStartMinuteSpinner)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(satStartAmPm))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(friStartMinuteSpinner)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(friStartAmPm))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(thuStartMinuteSpinner)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thuStartAmPm))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(wedStartMinuteSpinner)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(wedStartAmPm))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(tueStartMinuteSpinner)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tueStartAmPm))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monStartMinuteSpinner)
                                    .addComponent(sunStartMinuteSpinner, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sunStartAmPm)
                                    .addComponent(monStartAmPm))))
                        .addGap(18, 18, 18)
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(sunEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sunEndHourSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(monEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monEndHourSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(tueEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tueEndHourSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(wedEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(wedEndHourSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(thuEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thuEndHourSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(friEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(friEndHourSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(satEndLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(satEndHourSpinner)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(sunEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sunEndMinuteSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(monEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monEndMinuteSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(tueEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tueEndMinuteSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(wedEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wedEndMinuteSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(thuEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thuEndMinuteSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(friEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friEndMinuteSpinner))
                            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                                .addComponent(satEndColon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(satEndMinuteSpinner)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(satEndAmPm)
                            .addComponent(friEndAmPm)
                            .addComponent(thuEndAmPm)
                            .addComponent(wedEndAmPm)
                            .addComponent(tueEndAmPm)
                            .addComponent(sunEndAmPm)
                            .addComponent(monEndAmPm)))
                    .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(dailyAirtimesHeader)))
                .addGap(239, 239, 239))
            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dailyAirtimesPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addGap(224, 224, 224))
        );

        dailyAirtimesPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {satStartHourSpinner, sunStartHourSpinner, thuStartHourSpinner, tueStartHourSpinner, wedStartHourSpinner});

        dailyAirtimesPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {applyButton, cancelButton, okButton});

        dailyAirtimesPanelLayout.setVerticalGroup(
            dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dailyAirtimesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dailyAirtimesHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sundayLabel)
                    .addComponent(sunStartLabel)
                    .addComponent(sunStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunStartColon)
                    .addComponent(sunStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunEndLabel)
                    .addComponent(sunEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunEndColon)
                    .addComponent(sunEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mondayLabel)
                    .addComponent(monStartLabel)
                    .addComponent(monStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monStartColon)
                    .addComponent(monStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monEndLabel)
                    .addComponent(monEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monEndColon)
                    .addComponent(monEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tuesdayLabel)
                    .addComponent(tueStartLabel)
                    .addComponent(tueStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tueStartColon)
                    .addComponent(tueStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tueStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tueEndLabel)
                    .addComponent(tueEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tueEndColon)
                    .addComponent(tueEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tueEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wednesdayLabel)
                    .addComponent(wedStartLabel)
                    .addComponent(wedStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wedStartColon)
                    .addComponent(wedStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wedStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wedEndLabel)
                    .addComponent(wedEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wedEndColon)
                    .addComponent(wedEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wedEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thursdayLabel)
                    .addComponent(thuStartLabel)
                    .addComponent(thuStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thuStartColon)
                    .addComponent(thuStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thuStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thuEndLabel)
                    .addComponent(thuEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thuEndColon)
                    .addComponent(thuEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thuEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fridayLabel)
                    .addComponent(friStartLabel)
                    .addComponent(friStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friStartColon)
                    .addComponent(friStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friEndLabel)
                    .addComponent(friEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friEndColon)
                    .addComponent(friEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saturdayLabel)
                    .addComponent(satStartLabel)
                    .addComponent(satStartHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satStartColon)
                    .addComponent(satStartMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satStartAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satEndLabel)
                    .addComponent(satEndHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satEndColon)
                    .addComponent(satEndMinuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satEndAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dailyAirtimesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dailyAirtimesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dailyAirtimesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-610)/2, (screenSize.height-434)/2, 610, 434);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void sunStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sunStartHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunStartHourSpinnerStateChanged

    private void monStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monStartHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monStartHourSpinnerStateChanged

    private void tueStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tueStartHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueStartHourSpinnerStateChanged

    private void wedStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wedStartHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedStartHourSpinnerStateChanged

    private void thuStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thuStartHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuStartHourSpinnerStateChanged

    private void friStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_friStartHourSpinnerStateChanged
       applyButton.setEnabled(true);
    }//GEN-LAST:event_friStartHourSpinnerStateChanged

    private void satStartHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_satStartHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satStartHourSpinnerStateChanged

    private void sunStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sunStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunStartMinuteSpinnerStateChanged

    private void monStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monStartMinuteSpinnerStateChanged

    private void tueStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tueStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueStartMinuteSpinnerStateChanged

    private void wedStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wedStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedStartMinuteSpinnerStateChanged

    private void thuStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thuStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuStartMinuteSpinnerStateChanged

    private void friStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_friStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_friStartMinuteSpinnerStateChanged

    private void satStartMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_satStartMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satStartMinuteSpinnerStateChanged

    private void sunStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sunStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunStartAmPmStateChanged

    private void monStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monStartAmPmStateChanged

    private void tueStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tueStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueStartAmPmStateChanged

    private void wedStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wedStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedStartAmPmStateChanged

    private void thuStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thuStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuStartAmPmStateChanged

    private void friStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_friStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_friStartAmPmStateChanged

    private void satStartAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_satStartAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satStartAmPmStateChanged

    private void sunEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sunEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunEndHourSpinnerStateChanged

    private void monEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monEndHourSpinnerStateChanged

    private void tueEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tueEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueEndHourSpinnerStateChanged

    private void wedEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wedEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedEndHourSpinnerStateChanged

    private void thuEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thuEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuEndHourSpinnerStateChanged

    private void friEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_friEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_friEndHourSpinnerStateChanged

    private void satEndHourSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_satEndHourSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satEndHourSpinnerStateChanged

    private void sunEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sunEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunEndMinuteSpinnerStateChanged

    private void monEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monEndMinuteSpinnerStateChanged

    private void tueEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tueEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueEndMinuteSpinnerStateChanged

    private void wedEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wedEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedEndMinuteSpinnerStateChanged

    private void thuEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thuEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuEndMinuteSpinnerStateChanged

    private void friEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_friEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_friEndMinuteSpinnerStateChanged

    private void satEndMinuteSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_satEndMinuteSpinnerStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satEndMinuteSpinnerStateChanged

    private void sunEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sunEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_sunEndAmPmStateChanged

    private void monEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_monEndAmPmStateChanged

    private void tueEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tueEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_tueEndAmPmStateChanged

    private void wedEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wedEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_wedEndAmPmStateChanged

    private void thuEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thuEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_thuEndAmPmStateChanged

    private void friEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_friEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_friEndAmPmStateChanged

    private void satEndAmPmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_satEndAmPmStateChanged
        applyButton.setEnabled(true);
    }//GEN-LAST:event_satEndAmPmStateChanged

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        applyButton.setEnabled(false);
        /*get the showtime values for each day selected and pass them to 
         * setAirtimes method. Else statements reset any unchecked days to their
         * default values for the next time.
         */
        try {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("showtimes.txt")))) {
                
                if(sun) {
                    sunStartHour = (Integer) sunStartHourSpinner.getValue();
                    sunEndHour = (Integer) sunEndHourSpinner.getValue();
                    sunStartMinute = (Integer) sunStartMinuteSpinner.getValue();
                    sunEndMinute = (Integer) sunEndMinuteSpinner.getValue();
                    sunStartValue1 = (String) sunStartAmPm.getValue();
                    if(sunStartValue1.equals("AM")) { sunStartValue2 = "PM"; }
                    sunEndValue1 = (String) sunEndAmPm.getValue();
                    if(sunEndValue1.equals("AM")) { sunEndValue2 = "PM"; }
                    setAirtimes(out, 1, sunStartHour, sunEndHour, sunStartMinute,
                            sunEndMinute, sunStartValue1, sunEndValue1);
                }
                else {
                    sunStartHour = 12;
                    sunEndHour = 12;
                    sunStartMinute = 0;
                    sunEndMinute = 0;
                    sunStartValue1 = "PM";
                    sunStartValue2 = "AM";
                    sunEndValue1 = "PM";
                    sunEndValue2 = "AM";
                }
                if(mon) {
                    monStartHour = (Integer) monStartHourSpinner.getValue();
                    monEndHour = (Integer) monEndHourSpinner.getValue();
                    monStartMinute = (Integer) monStartMinuteSpinner.getValue();
                    monEndMinute = (Integer) monEndMinuteSpinner.getValue();
                    monStartValue1 = (String) monStartAmPm.getValue();
                    if(monStartValue1.equals("AM")) { monStartValue2 = "PM"; }
                    monEndValue1 = (String) monEndAmPm.getValue();
                    if(monEndValue1.equals("AM")) { monEndValue2 = "PM"; }
                    setAirtimes(out, 2, monStartHour, monEndHour, monStartMinute,
                            monEndMinute, monStartValue1, monEndValue1);
                }
                else {
                    monStartHour = 12;
                    monEndHour = 12;
                    monStartMinute = 0;
                    monEndMinute = 0;
                    monStartValue1 = "PM";
                    monStartValue2 = "AM";
                    monEndValue1 = "PM";
                    monEndValue2 = "AM";
                }
                if(tue) {
                    tueStartHour = (Integer) tueStartHourSpinner.getValue();
                    tueEndHour = (Integer) tueEndHourSpinner.getValue();
                    tueStartMinute = (Integer) tueStartMinuteSpinner.getValue();
                    tueEndMinute = (Integer) tueEndMinuteSpinner.getValue();
                    tueStartValue1 = (String) tueStartAmPm.getValue();
                    if(tueStartValue1.equals("AM")) { tueStartValue2 = "PM"; }
                    tueEndValue1 = (String) tueEndAmPm.getValue();
                    if(tueEndValue1.equals("AM")) { tueEndValue2 = "PM"; }
                    setAirtimes(out, 3, tueStartHour, tueEndHour, tueStartMinute,
                            tueEndMinute, tueStartValue1, tueEndValue1);
                }
                else {
                    tueStartHour = 12;
                    tueEndHour = 12;
                    tueStartMinute = 0;
                    tueEndMinute = 0;
                    tueStartValue1 = "PM";
                    tueStartValue2 = "AM";
                    tueEndValue1 = "PM";
                    tueEndValue2 = "AM";
                }
                if(wed) {
                    wedStartHour = (Integer) wedStartHourSpinner.getValue();
                    wedEndHour = (Integer) wedEndHourSpinner.getValue();
                    wedStartMinute = (Integer) wedStartMinuteSpinner.getValue();
                    wedEndMinute = (Integer) wedEndMinuteSpinner.getValue();
                    wedStartValue1 = (String) wedStartAmPm.getValue();
                    if(wedStartValue1.equals("AM")) { wedStartValue2 = "PM"; }
                    wedEndValue1 = (String) wedEndAmPm.getValue();
                    if(wedEndValue1.equals("AM")) { wedEndValue2 = "PM"; }
                    setAirtimes(out, 4, wedStartHour, wedEndHour, wedStartMinute,
                            wedEndMinute, wedStartValue1, wedEndValue1);
                }
                else {
                    wedStartHour = 12;
                    wedEndHour = 12;
                    wedStartMinute = 0;
                    wedEndMinute = 0;
                    wedStartValue1 = "PM";
                    wedStartValue2 = "AM";
                    wedEndValue1 = "PM";
                    wedEndValue2 = "AM";
                }
                if(thu) {
                    thuStartHour = (Integer) thuStartHourSpinner.getValue();
                    thuEndHour = (Integer) thuEndHourSpinner.getValue();
                    thuStartMinute = (Integer) thuStartMinuteSpinner.getValue();
                    thuEndMinute = (Integer) thuEndMinuteSpinner.getValue();
                    thuStartValue1 = (String) thuStartAmPm.getValue();
                    if(thuStartValue1.equals("AM")) { thuStartValue2 = "PM"; }
                    thuEndValue1 = (String) thuEndAmPm.getValue();
                    if(thuEndValue1.equals("AM")) { thuEndValue2 = "PM"; }
                    setAirtimes(out, 5, thuStartHour, thuEndHour, thuStartMinute,
                            thuEndMinute, thuStartValue1, thuEndValue1);
                }
                else {
                    thuStartHour = 12;
                    thuEndHour = 12;
                    thuStartMinute = 0;
                    thuEndMinute = 0;
                    thuStartValue1 = "PM";
                    thuStartValue2 = "AM";
                    thuEndValue1 = "PM";
                    thuEndValue2 = "AM";
                }
                if(fri) {
                    friStartHour = (Integer) friStartHourSpinner.getValue();
                    friEndHour = (Integer) friEndHourSpinner.getValue();
                    friStartMinute = (Integer) friStartMinuteSpinner.getValue();
                    friEndMinute = (Integer) friEndMinuteSpinner.getValue();
                    friStartValue1 = (String) friStartAmPm.getValue();
                    if(friStartValue1.equals("AM")) { friStartValue2 = "PM"; }
                    friEndValue1 = (String) friEndAmPm.getValue();
                    if(friEndValue1.equals("AM")) { friEndValue2 = "PM"; }
                    setAirtimes(out, 6, friStartHour, friEndHour, friStartMinute,
                            friEndMinute, friStartValue1, friEndValue1);
                }
                else {
                    friStartHour = 12;
                    friEndHour = 12;
                    friStartMinute = 0;
                    friEndMinute = 0;
                    friStartValue1 = "PM";
                    friStartValue2 = "AM";
                    friEndValue1 = "PM";
                    friEndValue2 = "AM";
                }
                if(sat) {
                    satStartHour = (Integer) satStartHourSpinner.getValue();
                    satEndHour = (Integer) satEndHourSpinner.getValue();
                    satStartMinute = (Integer) satStartMinuteSpinner.getValue();
                    satEndMinute = (Integer) satEndMinuteSpinner.getValue();
                    satStartValue1 = (String) satStartAmPm.getValue();
                    if(satStartValue1.equals("AM")) { satStartValue2 = "PM"; }
                    satEndValue1 = (String) satEndAmPm.getValue();
                    if(satEndValue1.equals("AM")) { satEndValue2 = "PM"; }
                    setAirtimes(out, 7, satStartHour, satEndHour, satStartMinute,
                            satEndMinute, satStartValue1, satEndValue1);
                }
                else {
                    satStartHour = 12;
                    satEndHour = 12;
                    satStartMinute = 0;
                    satEndMinute = 0;
                    satStartValue1 = "PM";
                    satStartValue2 = "AM";
                    satEndValue1 = "PM";
                    satEndValue2 = "AM";
                }
                
            }
        } catch (IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Save showtime selection values to daily_selections.txt
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("daily_selections.txt")))) {
                out.println(sunStartHour);
                out.println(sunEndHour);
                out.println(sunStartMinute);
                out.println(sunEndMinute);
                out.println(sunStartValue1);
                out.println(sunStartValue2);
                out.println(sunEndValue1);
                out.println(sunEndValue2);
                out.println(monStartHour);
                out.println(monEndHour);
                out.println(monStartMinute);
                out.println(monEndMinute);
                out.println(monStartValue1);
                out.println(monStartValue2);
                out.println(monEndValue1);
                out.println(monEndValue2);
                out.println(tueStartHour);
                out.println(tueEndHour);
                out.println(tueStartMinute);
                out.println(tueEndMinute);
                out.println(tueStartValue1);
                out.println(tueStartValue2);
                out.println(tueEndValue1);
                out.println(tueEndValue2);
                out.println(wedStartHour);
                out.println(wedEndHour);
                out.println(wedStartMinute);
                out.println(wedEndMinute);
                out.println(wedStartValue1);
                out.println(wedStartValue2);
                out.println(wedEndValue1);
                out.println(wedEndValue2);
                out.println(thuStartHour);
                out.println(thuEndHour);
                out.println(thuStartMinute);
                out.println(thuEndMinute);
                out.println(thuStartValue1);
                out.println(thuStartValue2);
                out.println(thuEndValue1);
                out.println(thuEndValue2);
                out.println(friStartHour);
                out.println(friEndHour);
                out.println(friStartMinute);
                out.println(friEndMinute);
                out.println(friStartValue1);
                out.println(friStartValue2);
                out.println(friEndValue1);
                out.println(friEndValue2);
                out.println(satStartHour);
                out.println(satEndHour);
                out.println(satStartMinute);
                out.println(satEndMinute);
                out.println(satStartValue1);
                out.println(satStartValue2);
                out.println(satEndValue1);
                out.println(satEndValue2);
            }
        } catch (IOException ex) {
                    Logger.getLogger(ShowtimeSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_applyButtonActionPerformed
    private void setAirtimes(PrintWriter out, int day, int startHour, int endHour, int startMinute,
            int endMinute, String startValue, String endValue) {
                
                //convert from 12 hour to 24 hour format
                if (startValue.equals("PM") && startHour != 12) {
                    startHour += 12;
                }
                if (startValue.equals("AM") && startHour == 12) {
                    startHour = 0;
                }
                if (endValue.equals("PM") && endHour != 12) {
                    endHour += 12;
                }
                if (endValue.equals("AM") && endHour == 12) {
                    endHour = 0;
                }
                int mins = 0;     //show's runtime in minutes
                if(endHour >= startHour) {
                    mins = ((endHour - startHour) * 60 + endMinute) - startMinute;
                }
                else if(endHour == 0){
                    mins = (24 - startHour) * 60 + (endMinute - startMinute);
                }
                else {  //show runs past midnight
                    mins = endHour * 60 + endMinute + (24- startHour) * 60 - startMinute;
                }
                
                out.println(mins);
                out.println("* " + startMinute + " " + startHour + " ? * " + day);  
        }
        
    
   private boolean sun;
   private boolean mon;
   private boolean tue;
   private boolean wed;
   private boolean thu;
   private boolean fri;
   private boolean sat;
   //declared values are defaults for if no daily_settings.txt file exists
   private int sunStartHour = 12;
   private int sunEndHour = 12;
   private int sunStartMinute = 0;
   private int sunEndMinute = 0;
   private String sunStartValue1 = "PM";
   private String sunStartValue2 = "AM";
   private String sunEndValue1 = "PM";
   private String sunEndValue2 = "AM";
   private int monStartHour = 12;
   private int monEndHour = 12;
   private int monStartMinute = 0;
   private int monEndMinute = 0;
   private String monStartValue1 = "PM";
   private String monStartValue2 = "AM";
   private String monEndValue1 = "PM";
   private String monEndValue2 = "AM";
   private int tueStartHour = 12;
   private int tueEndHour = 12;
   private int tueStartMinute = 0;
   private int tueEndMinute = 0;
   private String tueStartValue1 = "PM";
   private String tueStartValue2 = "AM";
   private String tueEndValue1 = "PM";
   private String tueEndValue2 = "AM";
   private int wedStartHour = 12;
   private int wedEndHour = 12;
   private int wedStartMinute = 0;
   private int wedEndMinute = 0;
   private String wedStartValue1 = "PM";
   private String wedStartValue2 = "AM";
   private String wedEndValue1 = "PM";
   private String wedEndValue2 = "AM";
   private int thuStartHour = 12;
   private int thuEndHour = 12;
   private int thuStartMinute = 0;
   private int thuEndMinute = 0;
   private String thuStartValue1 = "PM";
   private String thuStartValue2 = "AM";
   private String thuEndValue1 = "PM";
   private String thuEndValue2 = "AM";
   private int friStartHour = 12;
   private int friEndHour = 12;
   private int friStartMinute = 0;
   private int friEndMinute = 0;
   private String friStartValue1 = "PM";
   private String friStartValue2 = "AM";
   private String friEndValue1 = "PM";
   private String friEndValue2 = "AM";
   private int satStartHour = 12;
   private int satEndHour = 12;
   private int satStartMinute = 0;
   private int satEndMinute = 0;
   private String satStartValue1 = "PM";
   private String satStartValue2 = "AM";
   private String satEndValue1 = "PM";
   private String satEndValue2 = "AM";
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dailyAirtimesHeader;
    private javax.swing.JPanel dailyAirtimesPanel;
    private javax.swing.JSpinner friEndAmPm;
    private javax.swing.JLabel friEndColon;
    private javax.swing.JSpinner friEndHourSpinner;
    private javax.swing.JLabel friEndLabel;
    private javax.swing.JSpinner friEndMinuteSpinner;
    private javax.swing.JSpinner friStartAmPm;
    private javax.swing.JLabel friStartColon;
    private javax.swing.JSpinner friStartHourSpinner;
    private javax.swing.JLabel friStartLabel;
    private javax.swing.JSpinner friStartMinuteSpinner;
    private javax.swing.JLabel fridayLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner monEndAmPm;
    private javax.swing.JLabel monEndColon;
    private javax.swing.JSpinner monEndHourSpinner;
    private javax.swing.JLabel monEndLabel;
    private javax.swing.JSpinner monEndMinuteSpinner;
    private javax.swing.JSpinner monStartAmPm;
    private javax.swing.JLabel monStartColon;
    private javax.swing.JSpinner monStartHourSpinner;
    private javax.swing.JLabel monStartLabel;
    private javax.swing.JSpinner monStartMinuteSpinner;
    private javax.swing.JLabel mondayLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JSpinner satEndAmPm;
    private javax.swing.JLabel satEndColon;
    private javax.swing.JSpinner satEndHourSpinner;
    private javax.swing.JLabel satEndLabel;
    private javax.swing.JSpinner satEndMinuteSpinner;
    private javax.swing.JSpinner satStartAmPm;
    private javax.swing.JLabel satStartColon;
    private javax.swing.JSpinner satStartHourSpinner;
    private javax.swing.JLabel satStartLabel;
    private javax.swing.JSpinner satStartMinuteSpinner;
    private javax.swing.JLabel saturdayLabel;
    private javax.swing.JSpinner sunEndAmPm;
    private javax.swing.JLabel sunEndColon;
    private javax.swing.JSpinner sunEndHourSpinner;
    private javax.swing.JLabel sunEndLabel;
    private javax.swing.JSpinner sunEndMinuteSpinner;
    private javax.swing.JSpinner sunStartAmPm;
    private javax.swing.JLabel sunStartColon;
    private javax.swing.JSpinner sunStartHourSpinner;
    private javax.swing.JLabel sunStartLabel;
    private javax.swing.JSpinner sunStartMinuteSpinner;
    private javax.swing.JLabel sundayLabel;
    private javax.swing.JSpinner thuEndAmPm;
    private javax.swing.JLabel thuEndColon;
    private javax.swing.JSpinner thuEndHourSpinner;
    private javax.swing.JLabel thuEndLabel;
    private javax.swing.JSpinner thuEndMinuteSpinner;
    private javax.swing.JSpinner thuStartAmPm;
    private javax.swing.JLabel thuStartColon;
    private javax.swing.JSpinner thuStartHourSpinner;
    private javax.swing.JLabel thuStartLabel;
    private javax.swing.JSpinner thuStartMinuteSpinner;
    private javax.swing.JLabel thursdayLabel;
    private javax.swing.JSpinner tueEndAmPm;
    private javax.swing.JLabel tueEndColon;
    private javax.swing.JSpinner tueEndHourSpinner;
    private javax.swing.JLabel tueEndLabel;
    private javax.swing.JSpinner tueEndMinuteSpinner;
    private javax.swing.JSpinner tueStartAmPm;
    private javax.swing.JLabel tueStartColon;
    private javax.swing.JSpinner tueStartHourSpinner;
    private javax.swing.JLabel tueStartLabel;
    private javax.swing.JSpinner tueStartMinuteSpinner;
    private javax.swing.JLabel tuesdayLabel;
    private javax.swing.JSpinner wedEndAmPm;
    private javax.swing.JLabel wedEndColon;
    private javax.swing.JSpinner wedEndHourSpinner;
    private javax.swing.JLabel wedEndLabel;
    private javax.swing.JSpinner wedEndMinuteSpinner;
    private javax.swing.JSpinner wedStartAmPm;
    private javax.swing.JLabel wedStartColon;
    private javax.swing.JSpinner wedStartHourSpinner;
    private javax.swing.JLabel wedStartLabel;
    private javax.swing.JSpinner wedStartMinuteSpinner;
    private javax.swing.JLabel wednesdayLabel;
    // End of variables declaration//GEN-END:variables
}
