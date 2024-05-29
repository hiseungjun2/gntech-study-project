package com.java.chap02;

import java.util.Scanner;

/**
 * 2장 연습문제 11번
 * 서기 년월일을 필드로 갖는 클래스를 만드세요. 생성자와 메서드를 정의하세요.
 */
public class ExQ11 {
	
	// 각 달의 일수
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	// 평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	// 윤년
	};
	
	// 서기 year년은 윤년인가? (윤년 : 1, 평년 : 0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	// 서기 y년 m월 d일의 그 해 경과 일 수를 구함
	static int dayOfYear(int y, int m, int d) {
		int day = d;		// 일 수
		
		for (int i = 1; i < m; i++) {		// 1월 ~ (m-1)월의 일 수를 더함
			day += mdays[isLeap(y)][i - 1];
		}
		
		return day;
	}
		
	static class YMD {
		int y;		// 년
		int m;		// 월 (1~12)
		int d;		// 일 (1~31)
		
		// 생성자
		YMD(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		};
		
		YMD after(int n) {
			YMD date = new YMD(this.y, this.m, this.d);
			
			date.d += n; //n일 이후 일단 더함

            while(date.d > mdays[isLeap(date.y)][date.m-1]){ //32일이 되면 안되므로 while문으로 조절해준다
                date.d -= mdays[isLeap(date.y)][date.m-1];
                if(date.m++ == 12){ //12월이 넘어가면 1년을 더해줌
                    date.y += 1;
                    date.m = 1;
                }
            }

            return date;	
		}
		
		YMD before(int n) {
			YMD date = new YMD(this.y, this.m, this.d);

            if(n < 0)
                return after(-n);

            date.d -= n; //n일 이전 일단 빼봄

            while(date.d < 1){ //-일이 되면 안되므로 while문으로 조절해준다
                if(date.m-- == 1){ //1월 전으로 가면 1년을 빼줌
                    date.y -= 1;
                    date.m = 12;
                }
                date.d += mdays[isLeap(date.y)][date.m-1]; //빼준거면 빼준 년도의 걸 더해줘야 하기 때문에 여기에 둠
            }

            return date;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

        System.out.println("그 해 경과 일수를 구합니다.");
        System.out.print("년 : "); int year = stdIn.nextInt();
        System.out.print("월 : "); int month = stdIn.nextInt();
        System.out.print("일 : "); int day = stdIn.nextInt();

        YMD date = new YMD(year, month, day);

        System.out.print("숫자 입력 : ");
        int n = stdIn.nextInt();

        YMD after = date.after(n);
        YMD before = date.before(n);
        System.out.println("n일 뒤의 날짜 = " + after.y + "년 " + after.m + "월 " + after.d + "일 ");
        System.out.println("n일 앞의 날짜 = " + before.y + "년 " + before.m + "월 " + before.d + "일 ");
	}

}
