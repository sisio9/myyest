package or.kosta.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ��� ��û�� ���� ��鿡�� ���ܰ� �߻� ���� �� ����� ����
// ���ܸ� �ϳ��� �����ϴ� ���
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String myHandlerException(Exception e){
		// ModelAndView�� ����� ������!
		String returnval ="exception";
		if(e instanceof ArrayIndexOutOfBoundsException){
			 returnval ="arrayException";
		}
		System.out.println("���ܰ� �߻��Ͽ����ϴ�.!");
		e.printStackTrace();
		return returnval;
	}
}