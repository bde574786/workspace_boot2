package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListenerEx2 extends JFrame implements ActionListener {

	private JButton button1;
	private JButton button2;

	public EventListenerEx2() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("이벤트 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		button1 = new JButton("button1");
		button2 = new JButton("button2");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(button1);
		add(button2);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		//버튼 1, 2 구분하는 방법
//		//첫번째 방법
		System.out.println(e.toString());
////		System.out.println(button1.getText()); // button1출력
//		System.out.println(e.getActionCommand()+"버튼이 클릭되었습니다.");
//		if(e.getActionCommand().equals(button1.getText())) {
//			System.out.println("버튼1이 클릭되었습니다.");
//		}else {
//			System.out.println("버튼2가 클릭되었습니다.");
//		}
//		
		
		// 두번째 방법
		// object -> jButton
		JButton selectedBtn =(JButton) e.getSource();
		if(selectedBtn.getText().equals(this.button1.getText())) {
			System.out.println(button1.getText() + "가 클릭되었습니다.");
			
		}else {
			System.out.println(button2.getText() + "가 클릭되었습니다.");
		}
//		System.out.println(obj);
		
		
		
	}

} // end of class
