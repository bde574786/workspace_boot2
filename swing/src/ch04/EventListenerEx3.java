package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListenerEx3 extends JFrame {

	private JButton button1;
	private JButton button2;
	
	public EventListenerEx3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		setTitle("익명 구현 객체의 이해");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("butotn2");
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
	}
	
	private void addEventListener() {
		// 익명 구현 객체 사용법 !!!
		// 변수가 없음
		// 버튼이 생길 때 마다 달아줘야함(익명 구현 객체)
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 클릭 됨");
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 2가 클릭 됨");
			}
		});
	}

	
	public static void main(String[] args) {
		
		// 익명 클래스
		new EventListenerEx3();
//		EventListenerEx3 listener3 = new EventListenerEx3();
	}
	
}
