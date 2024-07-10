package WEEK_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_개인정보유효기간 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		List<Integer> ans = new ArrayList<>();
        
		// 오늘 날짜 변환
        String[] todays = today.split("[.]");
        int[] todayDate = new int[3];
        
        for(int i=0; i<todays.length; i++) {
            todayDate[i] = Integer.valueOf(todays[i]);
        }
        
        // 일수로 변환?
        int todayDays = (todayDate[0] * 12 *28) + (todayDate[1] * 28) + todayDate[2];
        
        for(int i=0; i<privacies.length; i++) {
            String[] one = privacies[i].split(" ");
            
            for(int j=0; j<terms.length; j++) {
                String[] term = terms[j].split(" ");
                int expire = Integer.valueOf(term[1]);
                
                if (one[1].equals(term[0])) {
                    String[] dates = one[0].split("[.]");
                    int[] date = new int[3];
                
                    
                    for(int d=0; d<dates.length; d++) {
                        date[d] = Integer.valueOf(dates[d]);
                    }
                    
                    System.out.println("date="+ Arrays.toString(date));
                    
                    int expireDays = (date[0]*12*28) + ((date[1]+expire)*28) + date[2]-1;
                    
                    if (todayDays > expireDays) {
                    	ans.add(i+1);
                    }
//                    
//                    
//                    int yearDiff = 0;
//                    int monDiff = 0;
//                    
//                    
//                    // 일 계산
//                    if (date[2]-1 == 0) {
//                        date[2] = 28;
//                        monDiff++;
//                    } else {
//                        date[2] -= 1;
//                    }
//                    
//                    
//                    // 월 계산
//                    if ((date[1]+expire-monDiff) > 12) {
//                        yearDiff = (date[1]+expire-monDiff) / 12;
//                    }
//                    if ((date[1]+expire-monDiff) % 12 == 0) {
//                        date[1] = 12;
//                    } else {
//                        date[1] = (date[1]+expire-monDiff) % 12;
//                    }
//                    
//                    // 연도 계산
//                    date[0] += yearDiff;
//                    
//                    // 오늘 날짜랑 비교
//                    // if (todayDate[0] < date[0]) {
//                    //     break;
//                    // }
//                    // if (todayDate[0] > date[0]) {
//                    //     ans.add(i);
//                    //     break;
//                    // }
//                    // else if (todayDate[0]==date[0] && todayDate[1] )
//                    
//                    String d1 = "";
//                    String d2 = "";
//                    for(int d=0; d<3; d++) {
//                        d1 += todayDate[d];
//                        d2 += date[d];
//                    }
//                    
//                    System.out.println("d1="+d1);
//                    
//                    int date1 = Integer.parseInt(d1);
//                    int date2 = Integer.parseInt(d2);
//                    
//                    System.out.println("date1 = "+date1);
//                    System.out.println("date2 = "+date2);
//                    
//                    if (date1 > date2) {
//                        ans.add(i+1);
//                    }
                }
                
                
            }
        }
        
        System.out.println(ans);

	}

}
