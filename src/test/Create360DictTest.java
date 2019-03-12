package test;

import java.io.IOException;

import com.knziha.plod.dictionary.mdict;

public class Create360DictTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		mdict md =  new mdict("C:\\temp\\360万简易大辞典.mdx");//牛津高阶英汉双解词典.mdx
    	
    	String key = "best";
    	
	
		key = "cabrerite";
       
		long stst=System.currentTimeMillis();
        CMN.show("结果html contents of "+key+" ： "+md.getRecordAt(md.lookUp(key)));
        CMN.show("时耗 time used： "+(System.currentTimeMillis()-stst)+"ms"); 
	        
        //Thread.sleep(1000*1000);
	        
	}
	
}
