package ch04;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventListenerEx4 extends JFrame implements MouseListener{

	private JLabel label1;
	
	public EventListenerEx4() {
		initData();
		setInitData();
		addEventListener();
	}
	
	private void initData() {
		setTitle("마우스 이벤트 확인");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 영역안에 글자가 넘쳐 화이트 스페이스
		label1 = new JLabel("hello java ~~~~~~~~");
	
	}
	
	private void setInitData() {
		setVisible(true);
		setLayout(null);
		add(label1);
		label1.setSize(100, 100);
		label1.setLocation(100, 100);
	}
	
	private void addEventListener() {
		 this.addMouseListener(this);
	}
	
	
	// 마우스가 클릭 되었을 때 호출
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("X 좌표 값 :" + e.getX());
		System.out.println("Y 좌표 값 :" + e.getY());
		
		System.out.println(label1.getBounds());
		System.out.println(" label width : " + label1.getBounds().width);
		System.out.println(" label heith : " + label1.getBounds().height);
		// 문제 현재 간격을 최소화 만들어서 정확성을 높여 보자

		// 수정해서 만들어 보자
		System.out.println("getHeight() : " + getHeight());
		label1.setLocation(e.getX()-100, e.getY()-82);
	}

	// 마우스가 눌러 졌을 때 호출
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// 마우스가 떨어졌을 때 호출
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// 마우스가 어떤 영역 안으로 들어왔을 때 호출
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// 마우스가 어떤 영역 밖으로 나갔을 때 호출
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// 메인 함수
	public static void main(String[] args) {
		new EventListenerEx4();
	} // end of main

	
}
