package socket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/* 
 * ws://___________________/socket/conn.do 
 * 
 */
public class ReceiveController extends TextWebSocketHandler {
	// �������� �̿��ؼ� ����������
	public void sendMessage(String m) {
		try {
			for (int i = 0; i < slist.size(); i++) {
				// session.sendMessage(new TextMessage("all#" + m));
				slist.get(i).sendMessage(new TextMessage("all#" + m));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	List<WebSocketSession> slist;

	@PostConstruct
	public void init() {
		slist = new ArrayList<>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// super.afterConnectionEstablished(session);
		System.out.println("���� �߻�");
		slist.add(session);
	}

	// ������ �ǰ� �ִ� ���¿��� ������ �ְ� �ޱ�
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// super.handleMessage(session, message);
		String m = (String) message.getPayload();
		// System.out.println("�޼��� ����..!"+ m);
		for (int i = 0; i < slist.size(); i++) {
			// session.sendMessage(new TextMessage("all#" + m));
			slist.get(i).sendMessage(new TextMessage("all#" + m));
		}
	}

	// ������ ���� ����
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// super.afterConnectionClosed(session,status);
		System.out.println("���� ����");
		slist.remove(session);

	}
}
