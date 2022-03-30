package ch09;

import java.util.Scanner;

public class BookClient implements BookDao{


	@Override
	public void insertUserInfo(Book book) {
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("제목 : " + book.getTitle());
	}
	@Override
	public void updateUserInfo(Book book) {
		System.out.println("저자 수정 : " + book.getAuthor());
		System.out.println("제목 수정 : " + book.getTitle());
	}
	
	@Override
	public void deleteUserInfo(Book book) {
		System.out.println("책 삭제 : " + book.getAuthor());
	}
	
	public void printUserInfo(Book book) {
		System.out.println("====조회====");
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("제목 : " + book.getTitle());
		System.out.println("===========");
	}

	
	
	// 스캐너 사용
	// 생성
	// 수정
	// 삭제
	// 출력	
	
}
	

