package test;

import java.io.BufferedReader;
import java.io.FileReader;


import com.knziha.plod.dictionaryBuilder.mdictBuilder;

import au.com.bytecode.opencsv.CSVParser;

public class CreateMdx {
	public static void main(String[] args) throws Exception {
		mdictBuilder mdxBD = new mdictBuilder("360万简易大辞典","口口制作","UTF-8");
    	
    	BufferedReader br = new BufferedReader(new FileReader("C:/Users/machenike/Desktop/stardict/stardict.csv"));
    	CSVParser parser = new CSVParser(',');
    	int count = 0;
    	while(br.ready()){
    		String line = br.readLine();
    		//word,phonetic,definition,translation,pos,collins,oxford,tag,bnc,frq,exchange,detail,audio
    		String[] parts = parser.parseLine(line);
    		
    		mdxBD.insert(parts[0], "<span>"+parts[1]+"<br>"+parts[2].replace("\n", "<br>")+"</span>");
    		count = count + 1;
    		if(count % 100000==0){
    			System.out.println(count);
    		}
    	}
    	
    	
    	br.close();
    	
    	mdxBD.write("D://360万简易大辞典.mdx");
	}
}
