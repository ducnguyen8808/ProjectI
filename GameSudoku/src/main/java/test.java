
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class test {
    public static void main(String[] args) throws IOException {
        importMap m = new importMap(1);
        Slove s = new Slove();
        int[][] mt = new int[9][9];
        mt = m.readMatrix();
        s.TRY(mt, 0, 0);    
        s.returnSolution(mt);
        for(int i = 0;i<9;i++){
            for(int j = 0; j<9; j++){ 
                System.out.print(mt[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
