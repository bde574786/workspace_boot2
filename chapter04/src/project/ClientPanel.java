package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientPanel extends JFrame {

	JOptionPane optionPane;
	JPanel panel;
	JPanel userPanel;
	JTabbedPane tab;

	JLabel label;
	JLabel hostIpLabel;
	JLabel userIdLabel;
	JLabel userLabel;
	JLabel roomLabel;

	JTextField hostIpTextField;
	JTextField userIdTextField;
	JTextField sendMessageTextField;
	JTextArea roomTextArea;
	JTextArea chattingArea;
	JTextArea allUserArea;
	
	
	JButton messageBtn;

	Socket socket;
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;

	JButton connectBtn;
	JButton cancelBtn;
	JButton createRoomBtn;
	JButton sendBtn;
	JButton joinBtn;
	
	
	public ClientPanel(){
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		tab = new JTabbedPane(JTabbedPane.BOTTOM);
		setLayout(null);
		tab.setBounds(10, 10, 360, 240);
		add(tab);

		panel = new JPanel();
		panel.setSize(100, 100);
		tab.addTab("서버 연결", panel);
		panel.setLayout(null);

		hostIpLabel = new JLabel("HostIP");
		hostIpLabel.setBounds(80, -20, 200, 100);
		panel.add(hostIpLabel);

		hostIpTextField = new JTextField("127.0.0.1");
		hostIpTextField.setBounds(80, 50, 199, 25);
		panel.add(hostIpTextField);

		userIdLabel = new JLabel("UserId");
		userIdLabel.setBounds(80, 50, 200, 100);
		panel.add(userIdLabel);

		userIdTextField = new JTextField();
		userIdTextField.setBounds(80, 120, 199, 25);
		panel.add(userIdTextField);
		
		

		connectBtn = new JButton("서버 연결");
		connectBtn.setBounds(135, 165, 90, 20);
		panel.add(connectBtn);


		panel = new JPanel();
		panel.setLayout(null);
		createRoomBtn = new JButton("방 만들기");
		createRoomBtn.setBounds(260, 185, 85, 20);
		panel.add(createRoomBtn);

		sendBtn = new JButton("전송");
		sendBtn.setBounds(133, 185, 60, 19);
		panel.add(sendBtn);

		messageBtn = new JButton("쪽지");
		messageBtn.setBounds(195, 185, 60, 19);
		panel.add(messageBtn);
		
		
		sendMessageTextField = new JTextField();
		sendMessageTextField.setBounds(10, 185, 120, 20);
		panel.add(sendMessageTextField);

		chattingArea = new JTextArea();
		chattingArea.setBounds(10, 10, 240, 170);
		chattingArea.setEditable(false);
		panel.add(chattingArea);
		
		
		joinBtn = new JButton("참여");
		joinBtn.setBounds(260, 160, 85, 20);
		panel.add(joinBtn);
		tab.add("채팅", panel);

		roomTextArea = new JTextArea();
		roomTextArea.setBounds(260, 100, 85, 50);
		panel.add(roomTextArea);

		roomLabel = new JLabel("채팅방");
		roomLabel.setBounds(260, 80, 39, 15);
		panel.add(roomLabel);

		allUserArea = new JTextArea();
		allUserArea.setBounds(260, 25, 85, 50);
		panel.add(allUserArea);

		userLabel = new JLabel("전체 사용자");
		userLabel.setBounds(260, 8, 70, 15);
		panel.add(userLabel);

		

	}




}
