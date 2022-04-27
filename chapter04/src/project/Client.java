
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;


public class Client extends ClientPanel implements ActionListener {


	private JList totalList;
	private JList roomList;
	
	boolean mainFlag;
	boolean threadFlag;

	private final String IP = "localhost";
	private int portNum;

	public Client() {
		inputPortNum();
		addListener();
	}

	private void addListener() {
		connectBtn.addActionListener(this);
		createRoomBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		joinBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connectBtn) {
			start();
			connectBtn.setEnabled(false);
		} else if (e.getSource() == createRoomBtn) {
			
		} else if (e.getSource() == sendBtn) {
//			sendMessageToServer("username/" + sendMessageTextField.getText());
			sendMessageToServer(sendMessageTextField.getText());
			
		} else if (e.getSource() == joinBtn) {

		} 
	}

	
	private void sendMessageToServer(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
			
//			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void start() {
		try {
			socket = new Socket(IP, portNum);
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			// 서버측과 클라이언트에 약속 (프로토콜) username@/"유저이름"

			

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ReadThread implements Runnable {
		@Override
		public void run() {
			threadFlag = true;
			while (threadFlag) {
				try {
					String msg = bufferedReader.readLine();
					System.out.println("서버로부터 메세지가 도착했습니다\n" + msg);
					chattingArea.append(msg +'\n');
					sendMessageTextField.setText(null);
//					inmessage(msg);
					
					
				} catch (IOException e) {
					e.printStackTrace();
					threadFlag = false;
				}
			}
		}

	}

	private void inputPortNum() {
		while (true) {
			try { 
				String msg = (String) JOptionPane.showInputDialog(null, "포트 번호를 입력하세요", "Server_Port",
						JOptionPane.OK_CANCEL_OPTION, null, null, "10000");
				String removeBlankMsg = msg.replace(" ", "");
				portNum = Integer.parseInt(removeBlankMsg);
				System.out.println(portNum);
				return;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
			} catch (Exception e2) {
				System.exit(0);
			}
		}
	}

	private void inmessage(String str) {
		Vector<String> userMsgList = new Vector<String>();
		Vector<String> roomList = new Vector<String>();
		String myRoomName;
		
		StringTokenizer st = new StringTokenizer(str, "/");

		String protocol = st.nextToken();
		String message = st.nextToken();
		
		sendMessageToServer("username/" + userIdTextField.getText());
		
		
//		if(protocol.equals("NewUser")) {
//			userMsgList.add(message);
//			totalList.setListData(userMsgList);
//		} else if(protocol.equals("OldUser")) {
//			userMsgList.add(message);
//			totalList.setListData(userMsgList);
//		} else if(protocol.equals("Note")) {
//			st = new StringTokenizer(message, "@");
//			String user = st.nextToken();
//			String note = st.nextToken();
//			JOptionPane.showMessageDialog(null, note, user + "로 부터 온 메세지", JOptionPane.CLOSED_OPTION);
//		} else if(protocol.equals("CreateRoom")) {
//			myRoomName = message;
//			joinBtn.setEnabled(false);
//			createRoomBtn.setEnabled(false);
//		} else if(protocol.equals("CreateRoomFail")) {
//			JOptionPane.showMessageDialog(null, "같은 방 이름이 존재합니다.");
//		} else if(protocol.equals("Chatting")) {
//			String msg = st.nextToken();
//			chattingArea.append(message + " : " + msg + "\n");
//		} 
//		
		
	
	}
	
	
	
	
	public static void main(String[] args) {
		new Client();
	}

}