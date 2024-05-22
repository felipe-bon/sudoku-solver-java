
package View;

import Model.Board;
import Model.Local;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SudokuPanel extends JPanel implements ActionListener{

    int boxsize = 80;
    Color corPrimaria = Color.white;
    Color corSecundaria = Color.BLACK;
    Color corFixos = Color.red;
    Board b;
    int[][] board;
    int[][] zerado;
    boolean running = false;
    int clickX, clickY;
    Timer t;
    JButton solveButton;
    JButton novoJogo;
    JButton resetar;
    ArrayList fixos = new ArrayList<Local>();
    boolean resolvido = false;
    
    public SudokuPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(900,900));
        this.setBackground(this.corPrimaria);
        this.setFocusable(true);
        this.addMouseListener(new myMouseAdapter());
        
        this.novoJogo = new JButton("novo jogo");
        this.add(this.novoJogo);
        this.novoJogo.setBounds(250, 830, 150, 30);
        this.novoJogo.addActionListener(this);
        this.novoJogo.setVisible(true);

        this.resetar = new JButton("resetar");
        this.resetar.setBounds(100, 830, 150, 30);
        this.resetar.setVisible(false);
        this.resetar.addActionListener(this);
        this.add(this.resetar);
        
        this.solveButton = new JButton("Resolver");
        this.solveButton.setBounds(490, 830, 150, 30);
        this.solveButton.setVisible(true);
        this.solveButton.addActionListener(this);
        this.add(this.solveButton);
        
        b = new Board();
        this.fixos = b.getFixos();
        this.board = b.getBoard();
        this.zerado = this.board;
        //b.solve(board);
//        for(int i = 0; i < 9; i++){
//            for(int j = 0; j < 9; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println("");
//        }
//         System.out.println("\n\n");
        
        startGame();
    }
    
    public void startGame(){
        running = true;
        t = new Timer(2,this);
        t.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void insere(){
        // qualcula o quadrado onde será inserido o numero
        // baseado no valor de clickX e clickY
    }
    
    public void draw(Graphics g){
        
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
               g.setColor(this.corSecundaria);
               g.fillRect(i*boxsize*3+90, j*boxsize*3+90, boxsize*3, boxsize*3);
               g.setColor(this.corPrimaria);
               g.fillRect(i*boxsize*3+90+3, j*boxsize*3+90+3, boxsize*3-6, boxsize*3-6);
               g.setColor(this.corSecundaria);
            }
        }
        
        for(int i = 0; i <= 9; i++){
            g.drawLine(i*boxsize+90, 90, i*boxsize+90, 810);
            g.drawLine(90, i*boxsize+90, 810, i*boxsize+90);
        }
        
        g.setFont(new Font("", Font.BOLD,40));
        
        System.out.println("desenha");
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(b.getBoard()[i][j]!=0)
                    g.drawString(""+b.getBoard()[i][j], i*boxsize+115, j*80+150);
                System.out.print(board[j][i]);
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        
        g.setColor(this.corFixos);
        Local l;
        for (int i = 0; i < fixos.size(); i++){
            l = (Local) fixos.get(i);
            g.drawString(""+board[l.getLinha()][l.getColuna()], l.getLinha()*boxsize+115, l.getColuna()*80+150);
        }
    }
    
    public class myMouseAdapter extends MouseAdapter{
        public void click(MouseEvent e){
//            if(e.isShiftDown())
//                //b.solve(board);
                
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(running){
            
            if(ae.getSource() == this.solveButton){
                resolvido = true;
                System.out.println(b.solve(board));
                board = b.getBoard();
                repaint();
            }
            
            if(ae.getSource() == this.novoJogo){
                resolvido = false;
                b =  new Board();
                fixos = b.getFixos();
                board = b.getBoard();
                zerado = b.getBoard();
                repaint();
            }
            
            if(ae.getSource() == this.resetar && resolvido){
                b = new Board(zerado);
                repaint();
            }
        }
    }
}
