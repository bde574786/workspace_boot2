package ch01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 호출자(콜리) : 멤버 변수로 징검다리 역할을 하는 인터페이스를 멤버 변수로 먼저 선언한다.
public class SubActivity extends JFrame {

	JButton button1;
	JButton button2;
	JButton button3;
	// 마이너스 버튼 + 1
	// 값을 전달 하는 버튼 + 1;
	int result = 999;

	ICallBackBtnAction callBackBtnAction;

	// 콜리는 콜백 받는 객체의 주소값을 알고 있어야 메서드가 호출되었다고 알릴 수 있다.
	public SubActivity(ICallBackBtnAction iCallBackBtnAction) {

		this.callBackBtnAction = iCallBackBtnAction;

		setSize(300, 300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		button1 = new JButton("더하기 버튼 + ");
		button2 = new JButton("빼기 버튼 -");
		button3 = new JButton("값을 전달하는 버튼");

		add(button1);
		add(button2);
		add(button3);

		button1.addActionListener(new ActionListener() {

			// 익명 구현 객체
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("더하기 버튼 클릭 !!!");
				// 하지만 (new X)
				callBackBtnAction.clickedAddBtn();

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("빼기 버튼 클릭 !!!");
				callBackBtnAction.clickedSubstractBtn();
			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("값을 전달하는 버튼 클릭 !!!");
				callBackBtnAction.passValue(result);
			}
		});

	}

}
