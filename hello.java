import java.io.*;
import java.text.NumberFormat;

public class hello {
    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\dnwls\\OneDrive\\바탕 화면\\4-1\\javaprogramming\\project\\wordlist.txt");
            FileReader filereader = new FileReader(file);
            int singleCh =0;
            while ((singleCh = filereader.read()) != -1){
                System.out.print((char)singleCh);
            }
            filereader.close();
        }catch (FileNotFoundException e){

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
