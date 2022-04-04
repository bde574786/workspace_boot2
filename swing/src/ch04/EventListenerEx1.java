package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListenerEx1 extends JFrame implements ActionListener {

	private JButton button1;

	public EventListenerEx1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("이벤트 리스너 연습1");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
		add(button1);
	}

	private void addEventListener() {
		button1.addActionListener(this); // 이 타입은 나 자신이야.. 왜냐면 저 매개변수 타입이 ActionListener타입인데 다형성으로 내타입이기도 함
		// button1에다가 버튼클릭하는 이벤트가 일어나면 나(this)한테 알려줘 -> '이벤트를 등록했다'
		// 등록하다.
		
	}

	// 메서드 호출되어진다... is meaning ..버튼이 눌러지면 내한테 알려진다. --> call back!!!!!!!
	// callback 되어진다. -> is callback메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		// actionPerformed 메서드를 통해서 동작을 처리할꺼야.
		System.out.println(e.toString());
		System.out.println("버튼이 클릭되었습니다.");
		
	}
} // end of class
