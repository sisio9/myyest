package or.kosta.mvc.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmailController {
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "emailform")
	public String mail() {
		return "emailform";
	}

	@RequestMapping(value = "sendEmail")
	public ModelAndView sendEmail(String mailTo, String subject, String text)
			throws AddressException, MessagingException {
		ModelAndView mav = new ModelAndView("success");
		// mav.addObject("", attributeValue)
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		String from = "''";
		// InternetAddress()는 메일 주소 양식으로 변경
		mimeMessage.setFrom(new InternetAddress(from));
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(mailTo));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(text, "UTF-8", "html");
		mailSender.send(mimeMessage);
		return mav;
	}
	@RequestMapping(value = "sendMailAttach", method = RequestMethod.POST)
	 public String sendMailAttach(String mailTo, String subject, String text,MultipartFile mfile, HttpSession session) {
	  final MimeMessagePreparator preparator = new MimeMessagePreparator() {
	   @Override
	   public void prepare(MimeMessage mimeMessage) throws Exception {
	    final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	    String path = session.getServletContext().getRealPath("/resources/imgfile/");
	    StringBuffer paths = new StringBuffer();
	    paths.append(path);
	    System.out.println("sd"+path);
	    paths.append(mfile.getOriginalFilename());
	    System.out.println(paths.toString());
	    File f = new File(paths.toString());
	    String from = "''";
	    helper.setFrom(new InternetAddress(from));
	    helper.setTo(mailTo);
	    helper.setSubject(subject);
	    helper.setText(text, true);
	    FileSystemResource file = new FileSystemResource(f);
	    helper.addAttachment(mfile.getOriginalFilename(), file);
	   }
	  };
	  mailSender.send(preparator);
	  return "success";
	 }
}
