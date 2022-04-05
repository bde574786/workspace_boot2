package ch05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrame7 extends JFrame implements KeyListener {

	
	private JTextArea textArea;
	
	public MyFrame7() {
		initData();
		setInitLayout();
		addEventListener();
		
	}
	

	private void initData() {
		setTitle("키 이벤트 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea();
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(textArea);
	}
	
	private void addEventListener() {
		textArea.addKeyListener(this);
	}
	
	
	// 문자 키에만 반응합니다.
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	// 키보드를 눌렀을 때 반응
	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		int keyCode = e.getKeyCode();
		System.out.println("c : " + c);
		System.out.println("keyCode : " + keyCode);
		
		// 도전 과제
		// textArea 키코드 그리고 c 값을 보이게 코딩해 주세요
		textArea.append("\n" + "c : " + c + " : " + "keyCode : " + keyCode);
		// 콘솔창에 왼쪽 화살표, 오른쪽, 아래, 위
		
		if(keyCode == KeyEvent.VK_LEFT) {
			System.out.println("왼쪽");
		}else if(keyCode == KeyEvent.VK_UP) {
			System.out.println("위");
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			System.out.println("오른쪽");
		}else {
			System.out.println("아래");
		}
		
	}

	// 키보드를 눌렀다가 뗐을 때 반응
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new MyFrame7();
		
	}
	
	
}
