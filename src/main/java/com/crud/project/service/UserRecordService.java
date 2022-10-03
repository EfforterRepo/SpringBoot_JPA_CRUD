package com.crud.project.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entity.User_table;
import com.crud.project.repo.UserRecordRepo;

/*
@Service
해당 클래스가 비즈니스 로직을 담은 Service 클래스임을 명시한다.
@Component 어노테이션을 사용해도 상관 없지만,
@Sevice 어노테이션에 @Component 어노테이션의 기능이 포함되어 있으며,
@Service를 사용함으로써 해당 클래스가 Service의 역할을 하는 것을 명확하게 알 수 있다.
*/
@Service
public class UserRecordService {

/*
@Autowired
UserRecordRepo userRecordRepo를 함으로써
-------------------------------------
Jpa의 save(), findOne(), findAll(), count(), delete()를 사용할 수 있다.
findBy로 시작 :  쿼리를 요청하는 메서드 임을 알림
countBy로 시작 :  쿼리 결과 레코드 수를 요청하는 메서드 임을 알림

1. save() : 레코드 저장 (insert, update)
2. findOne() : primary key로 레코드 한건 찾기
3. findAll() : 전체 레코드 불러오기. 정렬(sort), 페이징(pageable) 가능
4. count() : 레코드 갯수
5. delete() : 레코드 삭제

https://docs.spring.io/spring-data/jpa/docs/1.10.1.RELEASE/reference/html/#jpa.sample-app.finders.strategies
 */
	
	@Autowired
	UserRecordRepo userRecordRepo;

// findAll()	
	public List<User_table> doSelectAll(){
		return userRecordRepo.findAll();
	}
	
//	findById()
	public User_table doSelectOne(int memberID){
		return userRecordRepo.findById(memberID).get();
	}
	
//	save()
	public void doInsert(User_table user_table) {
		
		userRecordRepo.save(user_table);
	}
	
//	save()
	public void doUpdate(User_table user_table) {
		userRecordRepo.save(user_table);
	}
	
//	delete()
	public void doDelete(int key_id) {
		userRecordRepo.deleteById(key_id);
	}
	
/*  중복검사 하다가 실패.. 잘모르겠음
	@Transactional
	public boolean existsByMemberId(String loginID){
	    return userRecordRepo.existsByloginID(loginID);
	}
*/
	
	@Transactional
	public boolean existsByMemberId(String loginID){
	    return userRecordRepo.existsByloginID(loginID);
	}
}
