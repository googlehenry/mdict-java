package test;

import java.io.BufferedReader;
import java.io.FileReader;

import com.knziha.plod.dictionaryBuilder.mdictBuilder;

import au.com.bytecode.opencsv.CSVParser;

public class Create360Dict {
	public static void main(String[] args) throws Exception {
		mdictBuilder mdxBD = new mdictBuilder("360万简易大辞典","口口制作","UTF-8");
    	
    	BufferedReader br = new BufferedReader(new FileReader("C:/Users/lyancang/Desktop/stardict/stardict.csv"));
    	CSVParser parser = new CSVParser(',');
    	int count = 0;
    	while(br.ready()){
    		String line = br.readLine().replace("\\n", "<br>");
    		//word,phonetic,definition,translation,pos,collins,oxford,tag,bnc,frq,exchange,detail,audio
    		String[] parts = parser.parseLine(line);
    		String marks = " ["+parts[1]+"]";
    		marks = marks.replace("[]", "");
    		
    		mdxBD.insert(parts[0], "<div>"+parts[0]+marks+"<br>"+parts[2]+"<br>"+parts[3]+"</div>");
    		count = count + 1;
    		if(count % 100000==0){
    			System.out.println(count);
    			//break;
    		}
    	}
    	
    	
    	br.close();
    	
    	mdxBD.write("C://temp/360万简易大辞典.mdx");
	}
}
