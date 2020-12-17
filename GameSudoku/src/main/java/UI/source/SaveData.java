package UI.source;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveData {
    public static void createFile(String url, String name, int[][] matrix) throws Exception {
        String path = url + "\\" + name + ".dat";
        try {
            FileOutputStream file = new FileOutputStream(path);
            DataOutputStream dataOutputStream = new DataOutputStream(file);
            for (int i = 0; i < 9; i++) {
                for (int k = 0; k < 9; k++)
                    dataOutputStream.writeInt(matrix[i][k]);
            }
            System.out.println("Ghi dữ liệu thành công!");
            dataOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static int[][] readFile(String url) throws Exception {
        int[][] matrix = new int[9][9];
        int step = 0;
        int row = 0, col = 0;
        FileInputStream fileInputStream = new FileInputStream(url);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        while (dataInputStream.available() > 0) {
            int x = dataInputStream.readInt();
            if (col != 8) {
                matrix[row][col] = x;
                col++;
            } else {
                matrix[row][col] = x;
                col = 0;
                row++;
            }
        }
        return matrix;
    }
}
