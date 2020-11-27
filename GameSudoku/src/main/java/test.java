import java.io.FileOutputStream;
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
        catch (Exception e){
            System.out.print(e);// In lỗi ra màn hình
        }
        finally {
            file.close();//Nếu chương trình lỗi thì đóng file lại
        }    
    }
    public static void main(String[] args) throws IOException {
        importMap easyMap = new importMap(1);
        int[][] matrix = easyMap.readMatrix();
        creatFile("C:\\Users\\DELL\\Documents\\ProjectI\\DataMap", "test", matrix);
    }
}
