package or.kosta.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import or.kosta.vo.MemberVO;

@RestController
@RequestMapping("/members")
public class SpringRestController {

	// 문자열을 반환 하는 경우 
	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello Rest Ful";
	}
	

	//객체를 JSON으로 반환 하는 경우
	
	// 웹에서 요청시에 jackson-databind 라이브러리가 있어야 함.
	@RequestMapping("/respVO")
	public MemberVO respVO(){
		MemberVO v = new MemberVO();
		v.setId("xman");
		v.setName("김길동");
		v.setNum(8);
		v.setAddress("인천");
		v.setPassword("test00");
		return v;
	}
	
	
	
	
	
	
	// 컬랙션 타입의 객체를 반환하여 JSON-ARRAY로 반환하는 경우
	//@RequestMapping("/respListErrrorNot")
	@RequestMapping("/respList")
	public List<MemberVO> respList(){
	//public ResponseEntity<List<MemberVO>> respListNot(){	
		List<MemberVO> list = new ArrayList<>();
		for(int i=0; i<=12; i++){
			MemberVO v = new MemberVO();
			v.setId("bigman"+i);
			v.setName("김길동"+i);
			v.setNum(i);
			v.setAddress("인천"+i);
			v.setPassword("test0"+i);
			v.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			list.add(v);
		}
		return list;
		//return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		//return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
	}
	
	
	//http://localhost/springrest/members/respList2?code=1
	@RequestMapping("/respList2")
	public ResponseEntity<List<MemberVO>> respList(String code){	
		List<MemberVO> list = new ArrayList<>();
		 try{
			 if(code.equals("1")){
					for(int i=0; i<=12; i++){
						MemberVO v = new MemberVO();
						v.setId("xman"+i);
						v.setName("김길동"+i);
						v.setNum(i);
						v.setAddress("인천"+i);
						v.setPassword("test0"+i);
					
						list.add(v);
					}	
				}else{
					for(int i=0; i<=12; i++){
						MemberVO v = new MemberVO();
						v.setId("zman"+i);
						v.setName("김걸단"+i);
						v.setNum(i);
						v.setAddress("인천"+i);
						v.setPassword("xxoo"+i);
						list.add(v);
					}
				}
			 return new ResponseEntity<>(list,HttpStatus.OK);
		 }catch (Exception e) {
			 return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
		}
	}

	
}
