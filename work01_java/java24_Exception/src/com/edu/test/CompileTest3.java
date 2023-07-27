package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading2{
	public void readFile(String filename) throws FileNotFoundException, IOException {
		FileReader reader = null;
		
		try {
			reader = new FileReader(filename);
			System.out.println("1. 파일을 잘 찾았습니다.");
		} finally {
			reader.close();
		}
		
		
		
			
		System.out.println("2. FileReader API..");
		
	}
}

public class CompileTest3 {
	// 여기서 푹탄을 넘기면 JVM으로 넘겨서 JVM이 해결함
	// 폭탄은 JVM이 해결했다고!
	public static void main(String[] args) throws Exception {
		FileReading2 fr = new FileReading2();

		
		fr.readFile("C:\\KB_EDU\\doc\\CatchAMouse2.png");
		
		
		
		System.out.println("3. readFile() calling");
	}

	// 그러나 이 코드의 문제는 close를 해결하지 못함
	// 그래서 실행 코드에서 close를 일일이 해주어야함
}
