package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class wordlist {
	
    private static String[] word;
    private static String[] mean;
    private static int cnt;
    private static String dir_path = "./words";

    public static void getFile (int selec){
        cnt = 0;

        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
        
		File words = new File(dir_path+"/"+selec+".txt");

        String[] splitedStr = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(words),"UTF-8"))){
            String line = null;
            splitedStr = null;
            int linecnt =0;

            BufferedReader fileline = new BufferedReader(new InputStreamReader(new FileInputStream(words),"UTF-8"));
            while(fileline.readLine()!=null) linecnt++;
            fileline.close();
           
            word= new String[linecnt];
            mean = new String[linecnt];
            int j =0;

            while ((line = reader.readLine())!=null){
                splitedStr = null;
                splitedStr = line.split("\t"); 

                for (int i=0; i<splitedStr.length ; i++){
                    splitedStr[i] = splitedStr[i].trim();
                }
                word[j] = splitedStr[0];
                mean[j] = splitedStr[1];
                j++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
	public static void main(String[] args){
	} 

    public static void print(){
        for(int i = 0; i<word.length; i++){
            System.out.println(word[i]);
            System.out.println(mean[i]);}
    }   

    public static int totalList(){
        return cnt;
    }

    public static String[] wordView(){
        return word;
    }

    public static String[] meanView(){
        return mean;
    }
}
