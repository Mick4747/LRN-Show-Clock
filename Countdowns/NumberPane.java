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

/*NumberPane extends Jpanel. Creates a transparent JPanel with an opaque JLabel
 * that displays the int argument in a digital clock style font with a color 
 * of either green or red, depending on the int argument
 */

package Countdowns;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class NumberPane extends JPanel {
    
    int count;
    JLabel label;
    
    public NumberPane(int count) {
            Font digital;
            //get our font
        try {
            InputStream is = getClass().getResourceAsStream("Crysta.ttf");
            digital = Font.createFont(Font.TRUETYPE_FONT, is);
            digital = digital.deriveFont(Font.BOLD,125);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(digital);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(NumberPane.class.getName()).log(Level.SEVERE, null, ex);
            digital = new java.awt.Font("Arial", Font.BOLD,125);
        }
            
            
            setOpaque(false);
            setLayout(new BorderLayout());
            label = new JLabel("" + count);
            label.setFont(digital);
            //label color is green if count is over 5, red if 5 or under
            if(count > 5) {
                label.setForeground(new java.awt.Color(45,245,5));
            }
            else {
                label.setForeground(new java.awt.Color(255,0,0));
            }
            add(label);
        }
}
