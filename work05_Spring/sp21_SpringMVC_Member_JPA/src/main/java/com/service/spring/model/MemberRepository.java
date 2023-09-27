package com.service.spring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.spring.domain.Member;


/*
 * JpaRepository 제공하는 CRUD 기능들
 * 
 * C, U : save()    --- registerMember, updateMember
 * D, 	: delete()  --- deleteMember()
 * R	: count()   --- count()
 * R	: findAll() --- showAll()
 * 
 * --------------------------------------------------
 * 추가적으로 우리가 작성해야 하는 로직들
 * login(id, password)
 * findById()
 * String idExist(String id)
 * 
 */
public interface MemberRepository extends JpaRepository<Member, String>{
	@Query(value = "select id from member where id=?", nativeQuery = true)
	String idExist(String id);
	
	
	@Query(value = "select id, password, name, address from member where id=?", nativeQuery = true)
	Member findByIdMember(String id);
	
	//jpql 기법
	@Query("select m from Member m where m.id=:#{#member.id} AND m.password=:#{#member.password}")
	Member login(Member member);
}
