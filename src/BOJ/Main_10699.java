package BOJ;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main_10699 {

	public static void main(String[] args) {
		/* 문제) 오늘 날짜
		 * 
		 */
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        // 포맷 적용        String formatedNow = now.format(formatter);
		
		System.out.println(today.format(formatter));

	}

}
