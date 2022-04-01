package ch02;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {

	private BorderLayout borderLayout;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<String> titles = new ArrayList<String>(Arrays.asList("북", "센터", "남", "동", "서"));
	ArrayList<String> directions = new ArrayList<String>(Arrays.asList(BorderLayout.NORTH, BorderLayout.CENTER, BorderLayout.SOUTH, BorderLayout.EAST,
			BorderLayout.WEST ));


	public MyFrame2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Test");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(borderLayout);
		
		for (int i = 0; i < titles.size(); i++) {
			buttons.add(new JButton(titles.get(i)));
			add(buttons.get(i), directions.get(i));
		}
	}

	public static void main(String[] args) {
		new MyFrame2();
	}
}
