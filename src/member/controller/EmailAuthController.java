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
		// 서비스 단으로 넘겨서.. int 값을 리턴 
		// 모델의 역활은..
		// 컨트롤러가 넘겨주는 email 주소에 메일을 발송.
		// 발송을 할때 UUID 클래스를 이용해서 substring(0, 8) 정도 해서
		// 인증키를 전송..해당 인증키값과 사용자 id값을 DATABASE에 저장해두는게
		
		// 결과를 리턴켜주고..
		int r = 1;
		if(r==1)
			return "YYYYY";
		else
			return "NNNNN";
		
	}
	
	@RequestMapping("/member/authProcess.do")
	public String authResolve(String email, String key) {
		// 이걸 서비스단으로 넘겨서..
		// 위에서 저장시켜둔 값이랑 매치가 되는지 확인(로그인이랑 비슷한형태)
		int r = 1;
		return null;
	}
}




