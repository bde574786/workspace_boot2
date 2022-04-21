package file_io.ch04;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Callee extends BaseProgram {

	JButton button;
	JTextField jTextField;
	JPanel panel;
	ICaller iCaller;
	String data;

	public void setiCaller(ICaller iCaller) {
		this.iCaller = iCaller;
	}

	public Callee(String name) {
		super(name);
		setInitLayout();
		addEventListener();
	}

	@Override
	protected void initData() {
		panel = new JPanel();
		button = new JButton("저장");
		jTextField = new JTextField();
	}

	@Override
	protected void setInitLayout() {
		setSize(300, 300);
		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
		add(button, BorderLayout.SOUTH);
		add(jTextField);
	}

	private void addEventListener() {
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				iCaller.saveBtn();

				String diary = "diary.txt";
				data = jTextField.getText();

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(diary, true))) {
					bw.write(data);
					bw.flush();
				} catch (Exception e2) {

				}

			}

		});

	}

}
