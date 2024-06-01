import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class wordlist {
	
	public static void main(String args[]){
        String dir_path = "./wordlist"; 
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
;
        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
        System.out.println(list[0]);
        System.out.println(list[1]);

        String[][] word;
        String[][] mean;
        String[][] example;

        System.out.println("number of list " + cnt);
        System.out.println("Select word file");
        int selec = sc.nextInt();

		File wordlist = new File(dir_path+"/"+selec+".txt");
        String[] splitedStr = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(wordlist),"UTF-8"))){
            String line = null;
            splitedStr = null;

            while ((line = reader.readLine())!=null){
                splitedStr = null;
                splitedStr = line.split("\t"); 
                int num = splitedStr.length;

                word= new String[cnt][num];
                mean = new String[cnt][num];
                example = new String[cnt][num];

                for (int i=0; i<splitedStr.length ; i++){
                    if (i%4 == 0) word[selec][i] = splitedStr[i].trim(); System.out.print(word[selec][i]+" ");
                    if (i%4 == 1) mean[selec][i] = splitedStr[i].trim(); System.out.print(mean[selec][i]+" ");
                    if (i%4 == 2) example[selec][i] = splitedStr[i].trim(); System.out.print(example[selec][i]+" ");
                    if (i%4==3) System.out.println();
                }
                for (int i=0; i<splitedStr.length ; i++){
                    System.out.println(word[selec][i]);     
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        
	}

}
