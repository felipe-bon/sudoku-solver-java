
package Teste;

import Model.Valida;


public class MainTeste {
    
    public static void main(String a[]){
  
        Valida v = null;
        
        int[][] mat ={{0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {5, 5, 6, 0, 8, 0, 7, 0, 0},
                        {5, 0, 7, 2, 0, 0, 0, 0, 0},
                        {6, 0, 5, 0, 3, 0, 0, 0, 8},
                        {0, 7, 0, 4, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 6, 0},
                        {0, 4, 0, 0, 0, 0, 3, 0, 0},
                        {0, 0, 0, 5, 0, 1, 0, 8, 0},
                        {0, 0, 0, 0, 0, 7, 6, 0, 0}};
	
     
		
	System.out.println(v.isSolvableSudoku(mat));
        
    }
}
