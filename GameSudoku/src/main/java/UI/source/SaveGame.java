package UI.source;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class SaveGame {
    public static void creatFile(String url,String name,int[][] matrix) throws IOException {
        FileOutputStream file = null;
        String s = "";
        for(int i = 0;i<9;i++){
            for(int j = 0;j<8;j++){
                s += String.valueOf(matrix[i][j]) + ",";
            }
            
            s += String.valueOf(matrix[i][8]) + "\n";
        }
        byte[] a = s.getBytes(); //ep kieu String ve mang byte
        try{
            file = new FileOutputStream(url + "\\" +name+".txt");
            file.write(a); //ghi mang byte vao file
            System.out.print("Da ghi thanh cong!");
 
        }
        catch (IOException e){
            System.out.print(e);// In lỗi ra màn hình
        }
        finally {
            file.close();//Nếu chương trình lỗi thì đóng file lại
        }    
    }
    public static int[][] readFile(String url) throws IOException{
        int[][] matrix = new int[9][9];
        File file = new File(url);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        for(int i = 0;i<9;i++){
            String line = reader.readLine();
            for(int j = 0; j<9; j++){
                matrix[i][j] = Integer.parseInt(line.split(",")[j]);
            }
        }
        return matrix;
    }
//    public static void main(String[] args) throws IOException {
//        importMap easyMap = new importMap(1);
//        int[][] matrix = easyMap.readMatrix();
//        creatFile("C:\\Users\\DELL\\Documents\\ProjectI\\DataMap", "test1", matrix);
//        int[][] ma = readFile("C:\\Users\\DELL\\Documents\\ProjectI\\DataMap\\test.txt");
//        for(int i = 0;i<9;i++){
//            for(int j = 0; j<9; j++){ 
//                System.out.print(ma[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
//    }
}