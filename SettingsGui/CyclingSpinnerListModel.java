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

/*CyclingSpinnerListModel is a subclass of the Swing SpinnerListModel class, 
 * with the getNextValue() and getPreviousValue() methods overwritten, to allow
 * the spinner to properly "spin" around after reaching the first or last value
 */
package SettingsGui;

import javax.swing.SpinnerListModel;


public class CyclingSpinnerListModel extends SpinnerListModel {
    Object firstValue, lastValue;
    
    public CyclingSpinnerListModel(Object[] values) {
        super(values);
        firstValue = values[0];
        lastValue = values[values.length - 1];
    }
    
    @Override
    public Object getNextValue() {
        Object value = super.getNextValue();
        if (value == null) {
            value = firstValue;
        }
        return value;
    }
    
    @Override
    public Object getPreviousValue() {
        Object value = super.getPreviousValue();
        if (value == null) {
            value = lastValue;
        }
        return value;
    }
    
}
