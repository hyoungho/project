package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailAuthController {
	@RequestMapping("/member/auth.do")
	public String goAuth(){
		return "t:auth";
	}
	
	@RequestMapping("/member/authAjax.do")
	@ResponseBody
	public String authResolve(String email) {
		// ���� ������ �Ѱܼ�.. int ���� ���� 
		// ���� ��Ȱ��..
		// ��Ʈ�ѷ��� �Ѱ��ִ� email �ּҿ� ������ �߼�.
		// �߼��� �Ҷ� UUID Ŭ������ �̿��ؼ� substring(0, 8) ���� �ؼ�
		// ����Ű�� ����..�ش� ����Ű���� ����� id���� DATABASE�� �����صδ°�
		
		// ����� �������ְ�..
		int r = 1;
		if(r==1)
			return "YYYYY";
		else
			return "NNNNN";
		
	}
	
	@RequestMapping("/member/authProcess.do")
	public String authResolve(String email, String key) {
		// �̰� ���񽺴����� �Ѱܼ�..
		// ������ ������ѵ� ���̶� ��ġ�� �Ǵ��� Ȯ��(�α����̶� ���������)
		int r = 1;
		return null;
	}
}




