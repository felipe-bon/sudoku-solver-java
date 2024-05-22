
package View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SudokuFrame extends JFrame{
    
    SudokuPanel sp = new SudokuPanel();
    
    public SudokuFrame(){
        this.add(sp);
        this.setTitle("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(900, 900);
      
        this.setLocationRelativeTo(null);

        SudokuPanel sp = new SudokuPanel();
        this.add(sp);
      
        this.setVisible(true);
    }
}
