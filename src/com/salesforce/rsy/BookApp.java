package com.salesforce.rsy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		BookDaoImpl dao = new BookDaoImpl();
		List<BookVo> list = new ArrayList<BookVo>();
//		int count = 0;
//		
//		BookVo vo1 = new BookVo(123,"칙촉", "맛있다", "2023-12-27", 1);
//		count = dao.insert(vo1);
//		System.out.println("입력됨" + count);
//		
//		count = dao.delete(35);
//		System.out.println("삭제됨" + count);
//		
//		BookVo vo2 = new BookVo(32,"오예스", "맛있다", "2023-12-27", 1);
//		count = dao.update(vo2);
//		System.out.println("수정됨" + count);
//		
//		list = dao.select();
//		for(BookVo vo3 : list) {
//			System.out.println(vo3);
//		}
//		System.out.println("데이터 건수" + list.size());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색키워드를입력하세요 : ");
		String ch =sc.nextLine();
		list = dao.search(ch);
		for(BookVo vo4 : list) {
			System.out.println(vo4.toString(0));
		}
		System.out.println("데이터 건수" + list.size());
		sc.close();
	}
}
