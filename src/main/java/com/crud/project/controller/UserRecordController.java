package com.crud.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.crud.project.entity.User_table;
import com.crud.project.model.UserModel;
import com.crud.project.service.UserRecordService;

/*
@Controller
Controller는 사용자의 요청을 진입하는 지점이며,
요청에 따라 어떤 처리를 할지 결정하는 구간이다. (실질적인 처리는 서비스에서 담당)
사용자에게 View로 응답을 보내준다.
*/
@Controller

/*
@RequestMapping
특정 uri로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지를 정의한다.
이때 들어온 요청 특정 메서드와 매핑하기 위해 사용하는 것이다.
*/
@RequestMapping("")
public class UserRecordController {
	
/*
@Autowired
의존성 종속으로써, 클래스간의 의존관계를
스프링 컨테이너가 자동으로 연결해주는 것이다.

*/
	@Autowired
	UserRecordService userRcordService;
	
	//홈으로가기 를 위한 Mapping
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	
/*
R : List 조회 부분
모델을 만들어서, list에 추가하고
해당 리스트를 userList.jsp로 보내준다.
*/
	@GetMapping("/list")
	public String doStudyList(Model model) {
		System.out.println("list");
		List<User_table> list = userRcordService.doSelectAll();
//		for(User_table record : list) {
//			System.out.println(record.getMEMBER_ID());
//			System.out.println(record.getLOGIN_ID());
//			System.out.println(record.getPASSWORD());
//			System.out.println(record.getNAME());
//			System.out.println(record.getReg_day());
//		}
		model.addAttribute("list",list);
		return "userList";
	}
	
	
	@RequestMapping("/insert")
	public String doInsert(@ModelAttribute UserModel insertModel) {
		System.out.println("insert");
		return "userInsert";
	}
	
	@RequestMapping("/insert_exe")
	public String doInsert_exe(@ModelAttribute UserModel insertModel) {
		
		System.out.println("insert_exe");
//		System.out.println("아이디 : " + insertModel.getUserId());
//		System.out.println("패스워드 : " + insertModel.getUserPw());
//		System.out.println("이름 : " + insertModel.getUserName());
		User_table user_table = User_table.builder()
				.loginID(insertModel.getUserId())
				.password(Integer.toString(insertModel.getUserPw()))
				.name(insertModel.getUserName())
				.reg_day(LocalDateTime.now())
				.build();
		userRcordService.doInsert(user_table);
		return "userInsertOk";
	}
	


	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute UserModel deleteModel) {
		return "userUpdate";
	}
	
	@RequestMapping("/update_exe")
	public String doUpdate_exe(@ModelAttribute UserModel updateModel) {
		System.out.println("Update 진행");
		
		User_table user_table = userRcordService.doSelectOne(updateModel.getMemberId());
		System.out.println("user_Table이란: " + user_table);
		user_table.setLoginID(updateModel.getUserId());
		user_table.setPassword(Integer.toString(updateModel.getUserPw()));
		user_table.setName(updateModel.getUserName());
		userRcordService.doUpdate(user_table);
		return "userUpdateOk";
	}	
	
	@RequestMapping("/delete")
	public String doDelete(@ModelAttribute UserModel deleteModel) {
		return "userDelete";
	}
	
	@RequestMapping("/delete_exe")
	public String doDelete_exe(@ModelAttribute UserModel deleteModel) {
		System.out.println("Delete 진행");
		userRcordService.doDelete(deleteModel.getMemberId());
		return "userDeleteOk";
	}
	
	/*  중복검사 하다가 실패.. 잘모르겠음
	@GetMapping("/delete_exe/check")
	public ResponseEntity<?> checkIdDuplication(@RequestParam(value = "memberId") String memberId) throws BadRequestException {
	    System.out.println(memberId);

	    if (userRcordService.existsByMemberId(memberId) == true) {
	    	throw new BadRequestException("이미 사용중인 아이디 입니다.");
	    } else {
	        return ResponseEntity.ok("사용 가능한 아이디 입니다.");
	    }
	}
	
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
	public class BadRequestException extends RuntimeException {
	    public BadRequestException(String message) {
	        super(message);
	    }
	}
	*/
}