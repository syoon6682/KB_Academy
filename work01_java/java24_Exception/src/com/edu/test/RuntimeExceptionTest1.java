package com.edu.test;
/*
 * 컴파일시에는 에러가 없는데
 * 실행시점에서 에러가 발생
 * 컴파일러가 인지하지 못함
 * 
 * 명시적인 예외 처리하지 않고
 * 바로 코드를 수정하면 정상처리됨
 * ::
 * SQLException
 * 
 * 명시적인 예외처리 방법
 * try, catch, finally, throws, throw
 * 
 * try {
 * }
 */

public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str = {
				"Hello", 
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i = 0;
		while(i<=3) {
			try {
				System.out.println(str[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch1~");
			} catch(ArithmeticException e) {
				System.out.println("Nice Catch2~");
			} catch(Exception e) {
				System.out.println("Nice Catch3~");
			}finally {
				System.out.println("Always");
			}
			
			i++;
		}
		// 이때 나오는 문제는 Runtime 계열
		// 즐단위로 검사하고 Exception이 터짐
	}

}
