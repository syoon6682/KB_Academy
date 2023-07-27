package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading{
	public void readFile(String filename) {
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
			System.out.println("1. 파일을 잘 찾았습니다.");
			
		} catch(FileNotFoundException e) {
			System.out.println("1. 파일을 찾을 수가 없어요");
		} catch(IOException e) {
			System.out.println("1. 파일을 찾을 수가 없어요");
		} finally {
//			reader.close();
			
			try {
				reader.close();
			} catch (IOException e2) {
			}
			
			
		}
		System.out.println("2. FileReader API..");
		
	}
}

public class CompileTest2 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		fr.readFile("C:\\KB_EDU\\doc\\CatchAMouse3.png");
		
		System.out.println("3. readFile() calling");
	}

}
