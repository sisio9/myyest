package or.kosta.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 모든 요청에 대한 빈들에서 예외가 발생 했을 때 사용자 정의
// 예외를 하나로 적용하는 방법
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String myHandlerException(Exception e){
		// ModelAndView도 사용이 가능함!
		String returnval ="exception";
		if(e instanceof ArrayIndexOutOfBoundsException){
			 returnval ="arrayException";
		}
		System.out.println("예외가 발생하였습니다.!");
		e.printStackTrace();
		return returnval;
	}
}
