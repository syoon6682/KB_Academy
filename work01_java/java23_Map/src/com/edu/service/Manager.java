package com.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.edu.domain.Person;



public class Manager {
	private static Manager manager = new Manager(100);
	
	
	private Map<Integer,Person> map;
	
	
	private Manager(int size){
		System.out.println("싱글톤 Pattern...");
		map = new HashMap<>();
	}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public void printAllPersonInfo(){
		Set<Integer> set = map.keySet();
		for (int ssn : set) {
			System.out.println(ssn + "PersonInfo : " + map.get(ssn));
		}
		
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 있을떄는 추가되지 않도록 작성
		if (map.containsKey(person.getSsn())) {
			System.out.println(person.getName() + " 님은 이미 회원입니다.");
			return;
		} else {
			map.put(person.getSsn(), person);
			System.out.println(person.getName() + "님이 등록~~");
			}
		}
		

	
	public void deletePerson(int ssn){
		// 삭제 대상이있을때만 삭제되도록
//		if(map.containsKey(ssn)) {
//			Person person = map.remove(ssn);
//		}
		
		Person p = map.remove(ssn);
		if (p==null) {
			System.out.println("삭제 대상이 존재하지 않아요~~");
		} else {
			System.out.println(p.getName() + " 님 삭제됨");
		}
	}
	
	public Person findPerson(int ssn){
		Person person = null;
		if(map.containsKey(ssn)) {
			person = map.get(ssn);
		}
		return person;
	}//

	public ArrayList<Person> findPerson(String addr){
		Set<Integer> set = new HashSet<>();
		ArrayList<Person> persons = new ArrayList<>();
		
		for (int ssn : set) {
			Person person = map.get(ssn);
			if (person.getAddress().equals(addr)) {
				persons.add(person);
			}
		}
		
		return persons;
	}
	
	
	// 맵에는 set 함수가 존재하지 않고 key에 해당하는 값을 다시 put
	public void updatePerson(Person p, int ssn){	
		//
		if(map.containsKey(ssn)) {
			map.put(ssn, p);
			System.out.println("Update OK");
		} else {
			System.out.println("Update Fail");
		}
		
		
	}
}











