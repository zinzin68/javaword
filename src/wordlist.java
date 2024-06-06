package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class wordlist {
	
    static String[][] word;
    static String[][] mean;
    static int selec;

	public static void main(String args[]){
        String dir_path = "./wordlist"; 
        int cnt = 0;

        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
        for (int j=0 ; j<cnt ; j++)  System.out.println(list[j]);

        System.out.println("number of list " + cnt);
        
        selec = SelecList();

		File wordlist = new File(dir_path+"/"+selec+".txt");
        String[] splitedStr = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(wordlist),"UTF-8"))){
            String line = null;
            splitedStr = null;
            int linecnt =0;

            BufferedReader fileline = new BufferedReader(new InputStreamReader(new FileInputStream(wordlist),"UTF-8"));
            while(fileline.readLine()!=null) linecnt++;
            fileline.close();
           
            word= new String[cnt][linecnt];
            mean = new String[cnt][linecnt];
            //example = new String[cnt][linecnt];

            int j =0;

            while ((line = reader.readLine())!=null){
                splitedStr = null;
                splitedStr = line.split("\t"); 

                for (int i=0; i<splitedStr.length ; i++){
                    splitedStr[i] = splitedStr[i].trim();
                }
                word[selec][j] = splitedStr[0];
                System.out.println("word["+selec+"]["+(j +1)+"] : " + word[selec][j]);
                mean[selec][j] = splitedStr[1];
                System.out.println("mean : "+mean[selec][j]);
                //example[selec][j] = splitedStr[2];
                //System.out.println("example : "+example[selec][j]);
                j++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        for (int i=0 ; i< word.length ; i++){
            System.out.println("word[" +selec+ "]["+(i+1)+"] : " + word[selec][i]);}
	}
}

public int SelecList(){
    int num;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Select word file");
    num = sc.nextInt();
    sc.close();

    return num;
}
