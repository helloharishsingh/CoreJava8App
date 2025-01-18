package com.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadWriteDemo {

	public static void main(String[] args) throws IOException {
		Path path=Paths.get("C:\\Users\\61087903\\OneDrive - LTIMindtree\\Desktop\\Harish WorkSpace\\Eclipse WorkSpace\\CoreJavaApp\\src\\main\\resources\\TestInputFile.txt");
		String content=Files.readString(path);
		System.out.println("content==="+content);
		String newFileContent=content.replace("11", "17");
		Path newFilePath=Paths.get("C:\\Users\\61087903\\OneDrive - LTIMindtree\\Desktop\\Harish WorkSpace\\Eclipse WorkSpace\\CoreJavaApp\\src\\main\\resources\\TestOutFile.txt");
		Files.writeString(newFilePath,newFileContent);
	}

}
