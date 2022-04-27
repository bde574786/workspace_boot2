package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerPanel extends JFrame {

	JFrame frame;
	JLabel label;
	JScrollPane scrollbar;
	JTextArea textArea;
	JTextField portTextField;
	JButton startBtn;
	JButton saveBtn;
	JPanel panel;
	
	public ServerPanel() {
		

//		frame = new JFrame();
//		frame.setLayout(null);
//		frame.setSize(40, 300);

		
	

		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		this.setBounds(0, 100, 290, 360);

		label = new JLabel("10000");
		label.setBounds(100, 100, 50, 50);
		panel.add(label);

		scrollbar = new JScrollPane(label);
		scrollbar.setBounds(0, 0, 160, 160);
		panel.add(scrollbar);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollbar.setBounds(10, 10, 250, 250);
		scrollbar.setViewportView(textArea);
		panel.add(scrollbar);

		portTextField = new JTextField();
		portTextField.setBounds(10, 269, 110, 37);
		// TODO 수정하기
		portTextField.setText("10000");
		panel.add(portTextField);

		startBtn = new JButton("실행");
		startBtn.setBounds(125, 270, 60, 35);
		panel.add(startBtn);

		saveBtn = new JButton("저장");
		saveBtn.setBounds(190, 270, 65, 35);
		panel.add(saveBtn);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
}
