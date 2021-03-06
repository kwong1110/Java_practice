package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	
	private Member[] m = new Member[SIZE];
	public static int SIZE = 10;
	// 최대 등록수 10명을 설정.
	
	int currentMember = 0;
	public int existMemberNum() {
		// 밖에 선언해주면 안됬엇다..
//		int count = 0;
//		for(int i = 0; i < m.length; i++) {
//			if(m[i] != null) {
//				count++;
//			}
//		}
//		
//		return count;
		return currentMember;
	}
	public Boolean checkId(String inputId) {
		Boolean checkId = true; 
		if(m[0] != null) {
			for(int i = 0; i <= currentMember-1; i++) {
				if(!m[i].getId().equals(inputId)) {
					checkId = false;
				} else if(m[i].getId().equals(inputId)) {
					checkId = true;
					break;
				}
			}
		}
		if(currentMember == 0) {
			checkId = false;
		}
		return checkId;
		// 새 배열을 만들어서? 하면은..
		// 다시 새 배열과 inputId를 비교해주는 for문을 만들어줘야하니까.. 딴걸로 하면
//		String checkId[] = new String[SIZE];
//		for(int i = 0; i < SIZE; i++) {
//			checkId[i] = m[i].getId();
//		}
	}
	public void insertMember(String id, String name, String password,
							String email, String gender, int age) {
		// 삭제된 후 빈자리에 찾아 가려면? 
		// for문을 씌워줘서 빈자리를 찾아 가면 될거 같음.
		// 맞음.
		
//		int index = 0;
//		for(int i = 0; i < m.length; i++) {
//			if(m[i] == null) {
//				index = i;
//				break;
//			}
//		}
		
//		m[index] = new Member(id, name, password, email, gender, age);
		m[currentMember] = new Member(id, name, password, email, gender.charAt(0), age);

		currentMember += 1;
	}
	
	public String searchId(String id) {
		int idArr = 0;
		for(int i = 0; i <= currentMember-1; i++) {
			if(i == 0 && m[i].getId().equals(id)) {
				return m[idArr].inform();
			} else if(m[i].getId().equals(id)) {
				idArr = i;
				return m[idArr].inform();
			}
		}
		// else 값을 최대한 안쓰고 간결하게 할 수도 있는데..
//		for(int i = 0; i < m.length; i++) {
//			if(m[i] != null) {
//				if(m[i].getId().equals(id)) {
//					return m[i].inform();
//				}
//			}
//		}
//		
//		return null;
		return "검색 결과가 없습니다.";
		// 지금은 스트링을 저렇게 리턴 안하고 null로 리턴해줌.
		// 나아지긴 함.
	}
	public Member[] searchName(String name) {
		Member[] nameArr = new Member[currentMember];
		for(int i = 0; i < currentMember; i++) {
			if(!m[i].getName().equals(name)) {
				nameArr = null;
			} else if(m[i].getName().equals(name)) {
				nameArr[i] = m[i];
			}
		}
		return nameArr;
	}
	public Member[] searchEmail(String email) {
		Member[] emailArr = new Member[currentMember];
		for(int i = 0; i < currentMember; i++) {
			if(!m[i].getEmail().equals(email)) {
				emailArr = null;
			} else {
				emailArr[i] = m[i];
			}
		}
		return emailArr;
	}
	
	public Boolean updatePassword(String id, String password) {
		Boolean okId = true;
		if(m[0] != null) {
			for(int i = 0; i <= currentMember-1; i++) {
				if(!m[i].getId().equals(id)) {
					okId = false;
				} else if(m[i].getId().equals(id)) {
					okId = true;
					m[i].setPassword(password);
					break;
				}
			}
		}
		if(currentMember == 0) {
			okId = false;
		}
		return okId;
	}
	public Boolean updateName(String id, String name) {
		Boolean okId = true;
		if(m[0] != null) {
			for(int i = 0; i <= currentMember-1; i++) {
				if(!m[i].getId().equals(id)) {
					okId = false;
				} else if(m[i].getId().equals(id)) {
					okId = true;
					m[i].setName(name);
					break;
				}
			}
		}
		if(currentMember == 0) {
			okId = false;
		}
		return okId;
	}
	
	public Boolean updateEmail(String id, String email) {
		Boolean okId = true;
		if(m[0] != null) {
			for(int i = 0; i <= currentMember-1; i++) {
				if(!m[i].getId().equals(id)) {
					okId = false;
				} else if(m[i].getId().equals(id)) {
					okId = true;
					m[i].setEmail(email);
					break;
				}
			}
		}
		if(currentMember == 0) {
			okId = false;
		}
		return okId;
	}
	
	public Boolean delete(String id) {
		Boolean okId = true;
		if(m[0] != null) {
			for(int i = 0; i <= currentMember-1; i++) {
				if(!m[i].getId().equals(id)) {
					okId = false;
				} else if(m[i].getId().equals(id)) {
					okId = true;
					m[i] = null;
					currentMember -= 1;
					break;
				}
			}
		}
//		if(currentMember == 0) {
//			okId = false;
//		}
		return okId;
	}
	
	public void delete() {
		m = null;
		currentMember -= 1;
	}
	public Member[] printAll() {
		Member[] allArr = new Member[currentMember];
		if(currentMember == 0) {
			allArr = null;
		}
		for(int i = 0; i <= currentMember-1; i++) {
			if(m != null) {
				allArr[i] = m[i];
			}
		}
		return allArr;
	}
}
