
package Model;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    int[][] board;
    int[][] boardPlayer;
    int largura;
    Random r;
    ArrayList fixos;
    
    public Board(int[][] inicio){
        this.largura = 9; 
        this.board = this.boardPlayer = inicio;
        fixos = new ArrayList<Local>();
        setFixos();
    }
    
    public Board(){
        this.largura = 9;
        
        this.board = createBoard();
        this.boardPlayer = this.board;
        fixos = new ArrayList<Local>();
        setFixos();
        System.out.println("construtor");
        print(board);

    }
    
    private void setFixos(){
        for(int i = 0; i < largura; i++){
            for(int j = 0; j < largura; j++){
                if(board[i][j] != 0)
                    this.fixos.add(new Local(i,j));
            }
        }
    }
    
    public ArrayList getFixos(){
        return this.fixos;
    }
    
    public int[][] createBoard(){
        
        int valor, linha, coluna;
        int[][] b = new int[9][9];
        this.r = new Random();

        for(int i = 0; i < largura; i++){
            for(int j = 0; j < largura; j++){
                b[i][j] = 0;
            }
        }
        
        for(int i = 0; i < largura; i++){
            for(int j = 0; j < 3; j++){
                coluna = r.nextInt(0,9);
                valor = r.nextInt(1,10);
                if(verificaInsercao(b,valor,i,coluna)){
                    b[i][coluna] = valor;
                }
            }
        }
      
        return b;
    }
    
    public int[][] getBoard(){
        return board;
    }
    
    
    
    public boolean verificaLinha(int[][] board, int valor, int linha){
        
        for(int j = 0; j < largura; j++)
            if(board[linha][j] == valor)
                return false;
        return true;
    }
    
    public boolean verificaColuna(int[][] board, int valor, int coluna){
        
        for(int linha = 0; linha < largura; linha++)
            if(board[linha][coluna] == valor)
                return false;
        
        return true;
    }
    
    public boolean verificaSubGrid(int[][] board, int valor, int subLinha, int subColuna){
        
        for(int i = 0; i < 3; i++){
            for(int j =0; j < 3; j++){
                if(board[subLinha+i][subColuna+j] == valor)
                    return false;
            }
        }

        return true;
    }
    
    public boolean verificaInsercao(int[][] board, int valor, int linha, int coluna){
        
        return (verificaLinha(board,valor,linha)   && 
                verificaColuna(board,valor,coluna) &&
                verificaSubGrid(board, valor, linha-linha%3, coluna-coluna%3));
    }
    
    public void print(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    
    public boolean verificaVazios(int[][] board, Local l){
        
        for(int i = 0; i < largura; i++){
            for(int j = 0; j < largura; j++){
                if(board[i][j] == 0){
                    l.setColuna(j);
                    l.setLinha(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean solve(int[][] board){
        
        Local l = new Local(0,0);
        
        if (!verificaVazios(board, l))
            return true;
        
        for(int valor = 1; valor <= 9; valor++){
            
            if(verificaInsercao(board, valor, l.getLinha(), l.getColuna())){
                board[l.getLinha()][l.getColuna()] = valor;
            
                if(solve(board))
                    return true;
                
                board[l.getLinha()][l.getColuna()] = 0;
            }
        }
        return false;
    }
    
    public void inserir(int valor, int linha, int coluna){
        if(valor >-1 && valor < 10)
            this.boardPlayer[linha][coluna] = valor;
    }
}
