package cn.com.gogo;

import java.io.File;

import org.junit.Test;


public class FileUse {
	
	 @Test
	 public void testFile() {
		  File file=new File("d:/hello");
		  if(!file.exists()) {
			  file.mkdirs();
		  }
		  System.out.println(file.exists());
		  System.out.println(file.isFile()+" "+file.isDirectory());
		  if(file.isFile()) {
			  file.delete();
		  }
	 }
}
