
package UI.source;

import java.io.*;
import java.util.Random;
public class importMap {

    public static BufferedReader reader;

    public importMap(int i){
        String url = "";
        switch (i){
            case 1 :
                url = "/MapEasy.txt";
                break;
            case 2 :
                url = "/MapNormal.txt";
                break;
            case 3 :
                url = "/MapHard.txt";
                break;
            default:
                break;
        }
        InputStream inputStream = getClass().getResourceAsStream(url);
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public static int[][] readMatrix() throws IOException {
        int[][] matrix = new int[9][9];
        Random rd = new Random();
        int n = rd.nextInt(300);
        String line = "";
        for(int i = 1; i <= n*10; i++){
            reader.readLine();
        }
        for(int i = 0;i<9;i++){
            line = reader.readLine();
            for(int j = 0; j<9; j++){
                matrix[i][j] = Integer.parseInt(line.split(",")[j]);
            }
        }
        return matrix;
    }

}