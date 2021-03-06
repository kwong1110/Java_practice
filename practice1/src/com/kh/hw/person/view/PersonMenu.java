package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;

public class PersonMenu {

	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();

	public void mainMenu() {
		do {
			// int[] arr = pc.personCount(); 변수명으로 지정하면 더 알아보기 쉽다.
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 " + pc.personCount()[0] + "명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 " + pc.personCount()[1] + "명입니다.");
			System.out.println();

			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt();
//			int menuNum = Integer.parseInt(sc.nextLine());
			// nextLine을 씀으로써 버퍼에 저장되있는 엔터를 다 잡아줌으로써 다음 코드에서 깔끔하다.
			
			switch(menuNum) {
			case 1: studentMenu(); break;
			case 2: employeeMenu(); break;
			case 9: System.out.println("종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
			if(menuNum == 9) {
				break;
			}
		}while(true);
	}
	public void studentMenu() {
		System.out.println();
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 보기");
		System.out.println("9. 메인으로");
		if(pc.personCount()[0] == 3) {
			System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더이상 활성화 되지 않습니다.");
		}
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		
		if(pc.personCount()[0] == 3 && menuNum == 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); studentMenu();
		}
		
		switch(menuNum) {
		case 1: insertStudent(); break;
		case 2: printStudent(); break;
		case 9: System.out.println("메인으로 돌아갑니다."); mainMenu(); break;
		default: System.out.println("잘못 입2력하셨습니다. 다시 입력해주세요."); studentMenu(); break;
		}
	}
	
	public void employeeMenu() {
		System.out.println();
		System.out.println("1. 사원 추가");
		System.out.println("2. 사원 보기");
		System.out.println("9. 메인으로");
		if(pc.personCount()[1] == 10) {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더이상 활성화 되지 않습니다.");
		}
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		
		if(pc.personCount()[1] == 10 && menuNum == 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); employeeMenu();
		}
		
		switch(menuNum) {
		case 1: insertEmployee(); break;
		case 2: printEmployee(); break;
		case 9: System.out.println("메인으로 돌아갑니다."); mainMenu(); break;
		default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); employeeMenu(); break;
		}
	}
	
	public void insertStudent() {
		sc.nextLine();
		do {
			System.out.println();
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			sc.nextLine();
			System.out.print("학생 전공 : ");
			String major = sc.nextLine();

			pc.insertStudent(name, age, height, weight, grade, major);

			if (pc.personCount()[0] != 3) {
				System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
				String go = sc.nextLine();
				if (go.equalsIgnoreCase("N")) {
					break;
				}
			} else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다");
				break;
			}
		} while (true);
		studentMenu();
	}
	public void printStudent() {
//		pc.printStudent();를 불러와야함.
//		Student[] s = pc.printStudent();
		for(int i = 0; i < pc.personCount()[0]; i++ ) {
			if(pc.printStudent()[i] != null) {			// null이 아닌 것들만 출력해라!
				System.out.println(pc.printStudent()[i].toString());
			}
		}
		studentMenu();
	}
	public void insertEmployee() {
		sc.nextLine();
		do {
			System.out.println();
			System.out.print("사원 이름 : ");
			String name = sc.nextLine();
			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			System.out.print("사원 키 : ");
			double height = sc.nextDouble();
			System.out.print("사원 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			sc.nextLine();
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			if(pc.personCount()[1] != 10) {
				System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
				String go = sc.nextLine();
				if(go.equalsIgnoreCase("N")) {
					break;
				}
			} else {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다");
				break;
			}
		}while(true);
		employeeMenu();
	}
	public void printEmployee() {
		for(int i = 0; i < pc.personCount()[1]; i++ ) {
			System.out.println(pc.printEmployee()[i].toString());
			}
		employeeMenu();
	}
}
