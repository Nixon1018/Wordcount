package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger ("InfoLogging");
    public static void main(String[] args) throws IOException {
        HashMap<String ,Integer> hash= new HashMap<String,Integer>();
        String read;
        int count=0;
        Queue<Map.Entry< String,Integer> >queu =new PriorityQueue<>((a,b)->{return b.getValue()-a.getValue();});
        FileReader fr=new FileReader("C:\\Users\\Tringapps-User7\\Desktop\\New Text Document.txt");
        BufferedReader br = new BufferedReader(fr);
        while((read=br.readLine())!=null)
        {
            String[] word= read.split(" ");
            count=count+word.length;
            for(String st:word)
            {
                if(hash.containsKey(st))
                {
                    hash.put(st,hash.get(st)+1);
                }
                else
                {
                    hash.put(st,1);
                }
            }
        }
        String x = "The total amount of words is:"+count;
        logger.info(x);
        String z="The hashmap is:"+hash.clone();
        logger.info(z);
        queu.addAll(hash.entrySet());
        for(Map.Entry<String,Integer> queu1: queu)
        {
            String v= queu1.getKey()+" - "+queu1.getValue();
            logger.info(v);
        }


    }
}