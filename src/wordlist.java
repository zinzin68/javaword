package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class wordlist {
	
    static String[] word;
    static String[] mean;
    static int selec;

    public static void getFile (int selec){
        String dir_path = "./words"; 
        int cnt = 0;

        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
        for (int j=0 ; j<cnt ; j++)  System.out.println(list[j]);
        
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
        print();
    }

    public static int SelecList(){
        int num;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Select word file");
        num = sc.nextInt();
        sc.close();
    
        return num;
    }

	public static void main(String args[]){
        /*String dir_path = "./words"; 
        int cnt = 0;

        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
        for (int j=0 ; j<cnt ; j++)  System.out.println(list[j]);

        System.out.println("number of list " + cnt);
        
        int selec = SelecList();
        int n = SelecList();
		File words = getFile(n);
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
        print();*/
	} 
    public static void print(){
        for(int i = 0; i<word.length; i++){
            System.out.println(word[i]);
            System.out.println(mean[i]);}
    }   

    public String[] wordView(){
        return word;
    }

    public String[] meanView(){
        return mean;
    }
}
