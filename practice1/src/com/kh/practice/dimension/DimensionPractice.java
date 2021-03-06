package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {

	public void practice1() {
		
//		3행 3열짜리 문자열 배열을 선언 및 할당하고
//		인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
		
		int[][] arr = new int[3][3];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print("("+ i + ", ");
				System.out.print(j + ")");
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		
//		4행 4열짜리 정수형 배열을 선언 및 할당하고
//		1) 1 ~ 16까지 값을 차례대로 저장하세요.
//		2) 저장된 값들을 차례대로 출력하세요.
		
		int[][] arr = new int[4][4];
		
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = value;
				value++;
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice3() {
		
//		4행 4열짜리 정수형 배열을 선언 및 할당하고
//		1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
//		2) 저장된 값들을 차례대로 출력하세요.
		
		int[][] arr = new int[4][4];
		
		int value = 16;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = value;
				value--;
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		
//		4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
//		아래의 내용처럼 처리하세요.
		
		int[][] arr = new int[4][4];
		
		int lineSum = 0;
		int rowSum = 0;
		int lineRowSum = 0;
		
		for(int line = 0; line < arr.length; line++) {
			for(int row = 0; row < arr[line].length; row++) {
				
				int random = (int)(Math.random() * 10) + 1;
				
				// 3행 까지 숫자 구함. 각 행의 합
				if(line != arr.length-1 && row == arr.length-1) {
					arr[line][row] = lineSum;
					lineSum = 0;
				} else if(line != arr.length - 1 && row != arr.length -1) {
					arr[line][row] = random;
					lineSum += random;
				}
				
				// 마지막 행의 각 열의 합을 구해야함.
				// 마지막 행의 전 행이니까 arr.length-1
				if(line == arr.length-1 && row != arr.length-1) {
					for(int i = 0; i < arr.length-1; i++) {
						rowSum += arr[i][row];
					}
					arr[line][row] = rowSum;
					rowSum = 0;
					
				// 마지막 행의 합과 마지막 열의 합을 구해야함.
				} else if(line == arr.length-1 && row == arr.length-1) {
					for(int i = 0; i < arr.length-1; i++) {
						lineRowSum += arr[i][row];
						lineRowSum += arr[line][i];
					}
					arr[line][row] = lineRowSum;
				}
				System.out.printf("%3d",arr[line][row]);
			}
			System.out.println();
		}
	}
	
	public void practice4Kh() {
		
		// 4행 4열 2차원 배열을 생성하여
		int[][] arr = new int[4][4];
		
		// 0행 0열 부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr[i].length-1; j++) {
				arr[i][j] = (int)(Math.random() * 10) +1;
			}
		}
		
//		arr[0][3] = arr[0][0]
//				  + arr[0][1]
//				  + arr[0][2];
//		arr[1][3] = arr[1][0]
//				  + arr[1][1]	
//				  + arr[1][2];
//		arr[2][3] = arr[2][0]
//				  + arr[2][1]
//				  + arr[2][2];
//	
//		
//		
//		arr[3][0] = arr[0][0]
//				  + arr[1][0]
//				  + arr[2][0];
//		arr[3][1] = arr[0][1]
//				  + arr[1][1]
//				  + arr[2][1];
//		arr[3][2] = arr[0][2]
//				  + arr[1][2]
//				  + arr[2][2];
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr[i].length-1; j++) {
				arr[i][3] += arr[i][j];
				arr[3][i] += arr[j][i];
			}
		}
		
		for(int i = 0; i < arr.length-1; i++) {
			arr[3][3] += arr[i][3] + arr[3][i];
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice5() {
		
//		2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
//		“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
//		크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
//		(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 크기 : ");
		int line = sc.nextInt();
		System.out.print("열 크기 : ");
		int row = sc.nextInt();
		
		int[][] arr = new int[line][row];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr[i].length; j++) {
				int random = (int)(Math.random()* 26) + 65;
				arr[i][j] = random;
				System.out.printf("%-2c",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice6() {
		
//		String[][] strArr = new String[][] {{"이", "까", "왔", "앞", "힘"}, 
//		{"차", "지", "습", "으", "냅"}, {"원", "열", "니", "로", "시"},
//		{"배", "심", "다", "좀", "다"}, {"열", "히", "! ", "더", "!! "}};
		
//		위의 초기화되어 있는 배열을 가지고 아래의 ‘[그림] 실습문제4 흐름’과 같은 방식으로 출력하세요.
//		단, print()를 사용하고 값 사이에 띄어쓰기(“ “)가 존재하도록 출력하세요.
		
		String[][] strArr = new String[][] {{"이", "까", "왔", "앞", "힘"}, 
			{"차", "지", "습", "으", "냅"}, {"원", "열", "니", "로", "시"},
			{"배", "심", "다", "좀", "다"}, {"열", "히", "!", "더", "!!"}};
		
		for(int i = 0; i < strArr.length; i++) {
			for(int j = 0; j < strArr[i].length; j++) {
				System.out.print(strArr[j][i] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice7() {
		
//		사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
//		문자형 가변 배열을 선언 및 할당하세요.
//		그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int line = sc.nextInt();
		int[][] arr = new int[line][];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "행의 크기 : ");
			int row = sc.nextInt();
			arr[i] = new int[row];	
			if(row != 0) {
				continue;
			}
		}
		int a = 97;
		for(int i = 0; i < arr.length; i++) {
			for(int j =0; j <arr[i].length; j++) {
				arr[i][j] = a++;
//				a++;
				System.out.printf("%-2c",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice7Kh() {
		// 사용자에게 행의 크기를 받고
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		
		// 그 수만큼 반복을 통해 열의 크기도 받아 문자형 가변 배열을 선언 및 할당
		char[][] chArr = new char[row][];
		for(int i = 0; i < row; i++) {
			System.out.print(i + "행의 크기 : ");
			chArr[i] = new char[sc.nextInt()];
		}
		
		char data = 'a';
		for(int i = 0; i < chArr.length; i++) {
			for(int j = 0; j < chArr[i].length; j++) {
				chArr[i][j] = data++;
				System.out.print(chArr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		
//		1차원 배열에 12명의 학생들을 출석부 순으로 초기화 하고
//		2열 3행으로 2차원 배열 2개를 이용하여 분단을 나눠
//		1분단 왼쪽부터 오른쪽, 1행에서 아래 행 순으로 자리를 배치하세요.
//		<출석부>
//		1. 강건강 2. 남나나 3. 도대담 4. 류라라 5. 문미미 6. 박보배
//		7. 송성실 8. 윤예의 9. 진재주 10. 차천축 11. 피풍표 12. 홍하하
		
		// 1분단 다음 2분단
		String student[] = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
							"송성실", "윤예의 ", "진재주", "차천축", "피풍표", "홍하하"};
		
		String group1[][] = new String[3][2];
		String group2[][] = new String[3][2];
		
		int studentP = 0;
		System.out.println("== 1분단 ==");
		for(int i = 0; i < group1.length; i++) {
			for(int j = 0; j < group1[i].length; j++) {
				group1[i][j] = student[studentP];	
				studentP ++;
				System.out.printf("%-5s",group1[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("== 2분단 ==");
		for(int i = 0; i < group2.length; i++) {
			for(int j = 0; j < group2[i].length; j++) {
				group2[i][j] = student[studentP];	
				studentP ++;
				System.out.printf("%-5s",group2[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		
//		위 문제에서 자리 배리 배치한 것을 가지고 학생 이름을 검색하여
//		해당 학생이 어느 자리에 앉았는지 출력하세요.
		
		String student[] = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String group1[][] = new String[3][2];
		String group2[][] = new String[3][2];
		
		int studentP = 0;
		System.out.println("== 1분단 ==");
		for(int i = 0; i < group1.length; i++) {
			for(int j = 0; j < group1[i].length; j++) {
				group1[i][j] = student[studentP];	
				studentP ++;
				System.out.printf("%-5s",group1[i][j]);
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i = 0; i < group2.length; i++) {
			for(int j = 0; j < group2[i].length; j++) {
				group2[i][j] = student[studentP];	
				studentP ++;
				System.out.printf("%-5s",group2[i][j]);
			}
			System.out.println();
		}
		System.out.println("============================");
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String searchName = sc.nextLine();
		
		String dan = null;
		String rine = null;
		String rightLeft = null;
		
		for(int i = 0; i < group1.length; i++) {
			for(int j = 0; j < group1[i].length; j++) {
				if(group1[i][j].equals(searchName)) {
					dan = "1분단";
					switch(i) {
						case 0 : rine = "첫 번째 줄"; break;
						case 1 : rine = "두 번째 줄"; break;
						case 2 : rine = "세 번째 줄"; break;
					}
					switch(j) {
						case 0 : rightLeft = "왼쪽"; break;
						case 1 : rightLeft = "오른쪽"; break;
					}
				} else if(group2[i][j].equals(searchName)) {
					dan = "2분단";
					switch(i) {
						case 0 : rine = "첫 번째 줄"; break;
						case 1 : rine = "두 번째 줄"; break;
						case 2 : rine = "세 번째 줄"; break;
					}
					switch(j) {
						case 0 : rightLeft = "왼쪽"; break;
						case 1 : rightLeft = "오른쪽"; break;
					}
				}
			}
		}
		System.out.printf("검색하신 %s 학생은 %s %s %s 에 있습니다.", searchName, dan, rine, rightLeft);
	}
	
	public void practice9Kh() {
		// 1차원 배열에 12명의 학생들을 출석부 순으로 초기화 하고
		String[] student = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
							"송성실", "윤예의", "진재주", "차천축", "피퐁표", "홍하하"};
		
		// 2열 3행으로 2차원 배열 2개를 이용하여 분단을 나눠
		String[][] seat1 = new String[3][2];
		String[][] seat2 = new String[3][2];
		
		// 1분단 왼쪽부터 오른쪽, 1행에서 아래 행 순으로 자리 배치.
		int count = 0;
		// 학생 수를 새기 위해서, 이어서 넣을 수 있도록 변수를 지정 해준다.
		System.out.println("== 1분단 ==");
		for(int i = 0; i < seat1.length; i++) {
			for(int j = 0; j < seat1[i].length; j++) {
				seat1[i][j] = student[count];
				count++;
				System.out.print(seat1[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("== 2분단 ==");
		for(int i = 0; i < seat2.length; i++) {
			for(int j = 0; j < seat2[i].length; j++) {
				seat2[i][j] = student[count];
				count++;
				System.out.print(seat2[i][j] + " ");
			}
			System.out.println();
		}
		
		// 검색
		System.out.println("=============================");
		
		// 학생 이름을 검색하여 해당 학생이 어느 자리에 앉았는지 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		String partName = null; // 분단
		String rowName = null;	// 몇 번째 줄
		String colName = null;	// 왼쪽, 오른쪽
		
		for(int i = 0; i < seat1.length; i++) {
			for(int j = 0; j <seat1[i].length; j++) {
				if(seat1[i][j].equals(name)) {
					partName = "1분단";
					if(i == 0) {
						rowName = "첫 번째 줄";
					} else if(i == 1) {
						rowName = "두 번째 줄";
					} else {
						rowName = "세 번째 줄";
					}
					
					if(j == 0) {
						colName = "왼쪽";
					} else {
						colName = "오른쪽";
					}
					break;
				}
				if(seat2[i][j].equals(name)) {
					partName = "2분단";
					if(i == 0) {
						rowName = "첫 번째 줄";
					} else if(i == 1) {
						rowName = "두 번째 줄";
					} else {
						rowName = "세 번째 줄";
					}
					
					if(j == 0) {
						colName = "왼쪽";
					} else {
						colName = "오른쪽";
					}
					break;
				}
			}
		}
		System.out.println("검색하신 " + name + " 학생은" + partName + " " + rowName + " " + colName + "에 있습니다.");
 	}
}
