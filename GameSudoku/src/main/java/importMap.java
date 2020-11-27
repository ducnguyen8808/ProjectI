import java.io.*;
import java.util.Random;

public class importMap {

    private final static String FILE_URL = "C:\\Users\\DELL\\Documents\\ProjectI\\DataMap\\";

    public static BufferedReader reader;

    public importMap(int i){
        File file = null;
        switch (i){
            case 1 :
                file = new File(FILE_URL+"MapEasy.txt");
                break;
            case 2 :
                file = new File(FILE_URL+"MapNormal.txt");
                break;
            case 3 :
                file = new File(FILE_URL+"MapHard.txt");
                break;
            default:
                break;
        }
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int[][] readMatrix() throws IOException {
        int[][] matrix = new int[9][9];
        Random rd = new Random();
        int n = rd.nextInt(500);
        String line = "";
        for(int i = 1; i <= n*10; i++){
            reader.readLine();
        }
        for(int i = 0;i<9;i++){
            line = reader.readLine();
            for(int j = 0; j<9; j++){
                matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }
        return matrix;
    }

}