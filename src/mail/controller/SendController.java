package mail.controller;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendController {
	@Autowired
	JavaMailSender sender;		// bean 으로 등록시켜둔,, JavaMailSenderImpl
	
	
	
	@RequestMapping("/mail/test02.do")
	public String sendResolve2() {
		try {
			// 확보하는게 new MimeMessage X
			MimeMessage message = sender.createMimeMessage();
			// 설정해야 되는건.. 기본적으로 다 비슷
			// 도착지 , 보내는 곳 , 제목, 내용
			// Address를 매개변수로 설정을 해야되는 경우가 있는데.
				// 하위 객체인 InternetAddress 
			// 여러명에게 마임메시지를 보내야 된다면..
			Address[] targets = new Address[]{
					new InternetAddress("shizo@naver.com"),
					new InternetAddress("df4140@naver.com")
			};
			message.setRecipients(RecipientType.TO, "shizo@naver.com");
			
			message.setFrom(new InternetAddress("admin@group.kr"));
			
			message.setSubject("환영합니다!");
			
			String text = "<h3>어서오세요</h3>";
			text += "<b>누구누구</b>님, 방문해주셔서 감사하오..<br/>";
			text += "앞으로도 계속 잘이용해주세요..<br/>";
			text += "<a href='http://192.168.10.1/index.do?key=assfdsfsfdsfs'>서비스로</a>";
			
			message.setText(text, "utf-8", "html");	// 
			
			
			
			sender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/mail/test01.do")
	public String sendResolve() {
		// 단순히 text기반의 메일을 구성할꺼면.. SimpleMailMessage ..
		// Html기반의 메일의 구성할꺼면, MimeMessage ..
		try {
			SimpleMailMessage message = new SimpleMailMessage();
				// 필수 설정.. 받을사람.. 제목.. 내용
				// 보내는 사람을 설정하는것도 하지만, smtp 우회(gmail,naver,yahoo)
				// 가 들어가면, 설정이 적용이 안됨
				message.setTo("shizo@naver.com");	// String, String[]
				message.setFrom("admin@group.kr");	// X
				message.setSubject("메일 테스트");	// 제목
				String text = "안녕하세요\n메일테스트중입니다.<br/>";
				text += "메일이 제대로 받았는지 테스트 !!";
				message.setText(text);
			sender.send(message);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		// send가 발송 ... SimpleMailMessage / MimeMessage 둘중에 하나를 선택 
		return null;
	}
	//==============================================================================
	// 이렇게 메일 발송시키는 처리는 컨트롤러의 몫이 아님! 모델로 만들어두고.. 컨트롤러에서 필요한 정보넘겨서
		// 그쪽에서 설정을 시키게 유도.
	
	
	
	
}




