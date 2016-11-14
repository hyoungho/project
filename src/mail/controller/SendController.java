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
	JavaMailSender sender;		// bean ���� ��Ͻ��ѵ�,, JavaMailSenderImpl
	
	
	
	@RequestMapping("/mail/test02.do")
	public String sendResolve2() {
		try {
			// Ȯ���ϴ°� new MimeMessage X
			MimeMessage message = sender.createMimeMessage();
			// �����ؾ� �Ǵ°�.. �⺻������ �� ���
			// ������ , ������ �� , ����, ����
			// Address�� �Ű������� ������ �ؾߵǴ� ��찡 �ִµ�.
				// ���� ��ü�� InternetAddress 
			// �������� ���Ӹ޽����� ������ �ȴٸ�..
			Address[] targets = new Address[]{
					new InternetAddress("shizo@naver.com"),
					new InternetAddress("df4140@naver.com")
			};
			message.setRecipients(RecipientType.TO, "shizo@naver.com");
			
			message.setFrom(new InternetAddress("admin@group.kr"));
			
			message.setSubject("ȯ���մϴ�!");
			
			String text = "<h3>�������</h3>";
			text += "<b>��������</b>��, �湮���ּż� �����Ͽ�..<br/>";
			text += "�����ε� ��� ���̿����ּ���..<br/>";
			text += "<a href='http://192.168.10.1/index.do?key=assfdsfsfdsfs'>���񽺷�</a>";
			
			message.setText(text, "utf-8", "html");	// 
			
			
			
			sender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/mail/test01.do")
	public String sendResolve() {
		// �ܼ��� text����� ������ �����Ҳ���.. SimpleMailMessage ..
		// Html����� ������ �����Ҳ���, MimeMessage ..
		try {
			SimpleMailMessage message = new SimpleMailMessage();
				// �ʼ� ����.. �������.. ����.. ����
				// ������ ����� �����ϴ°͵� ������, smtp ��ȸ(gmail,naver,yahoo)
				// �� ����, ������ ������ �ȵ�
				message.setTo("shizo@naver.com");	// String, String[]
				message.setFrom("admin@group.kr");	// X
				message.setSubject("���� �׽�Ʈ");	// ����
				String text = "�ȳ��ϼ���\n�����׽�Ʈ���Դϴ�.<br/>";
				text += "������ ����� �޾Ҵ��� �׽�Ʈ !!";
				message.setText(text);
			sender.send(message);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		// send�� �߼� ... SimpleMailMessage / MimeMessage ���߿� �ϳ��� ���� 
		return null;
	}
	//==============================================================================
	// �̷��� ���� �߼۽�Ű�� ó���� ��Ʈ�ѷ��� ���� �ƴ�! �𵨷� �����ΰ�.. ��Ʈ�ѷ����� �ʿ��� �����Ѱܼ�
		// ���ʿ��� ������ ��Ű�� ����.
	
	
	
	
}




