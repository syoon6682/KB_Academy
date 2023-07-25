package com.edu.service;

import java.util.ArrayList;

import com.edu.domain.Employee;
import com.edu.domain.Person;
import com.edu.domain.Student;
import com.edu.domain.Teacher;



public class Manager {
	/*private Person[ ] p;
	private int index;
	*/
	
	private ArrayList<Person> list;
	
	public Manager(int size){
		list = new ArrayList<>();
	}
	public void getPersons(){
		for(Person p : list) {
			System.out.println(p);
		}
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 없을때만 추가되도록 작성
		if(!list.contains(person)) {
			list.add(person);
		}
		
	}
	
	public void deletePerson(int ssn){
		
		//삭제하려는 대상이 있을때에만 삭제가 되도록 작성
		for (Person p : list) {
			if(p.getSsn() == ssn) {
				list.remove(p);
			}
		}
	}

	public Person findPerson(int ssn){
		Person p = null;
		
		for (Person l : list) {
			if (l.getSsn() == ssn) {
				return l;
			}
		}
		
		return p;
	}//

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> p = new ArrayList<>();
		
		for (Person l : list) {
			if (l.getAddress().equals(addr)) {
				p.add(l);
			}
		}
		return p;
	}

	public void updatePerson(String name,int age, String addr, String str,int k){	
		
		//툭정한 위치에 있는 사람의 정보를 수정함
		//메소드의 인자값을 잘 활용해서 모든 객체의 정보가 수정될수 있도록 로직을 작성
		if (k >= list.size()) {
			return;
		} else {
			Person p = list.get(k);
			if (p instanceof Employee) {
				list.set(k, new Employee(k, name, age, addr, str));
			} else if (p instanceof Student) {
				list.set(k, new Student(k, name, age, addr, str));
			} else if (p instanceof Teacher) {
				list.set(k, new Teacher(k, name, age, addr, str));
			}
		}
	}
}
