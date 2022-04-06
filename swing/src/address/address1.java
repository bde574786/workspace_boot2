package address;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class address1 extends JFrame {

	JTable jt;

	JPanel TopPanel;
	JPanel menuPanel;
	JPanel backgroundPanel;
	JPanel namePanel;

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;

	JButton topButton;
	JButton friendButton;
	JButton companyButton;
	JButton schoolButton;
	JButton familyButton;
	JButton addButton;

	private JScrollPane jsp;

	public address1() {

		setTitle("주소록 메인");
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initData();
		setInitLayout();

	}

	public void initData() {

		String[][] d = { { "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, { "Sam", "29", " Twinkle House" },
				{ "Anna Sam", " 27 ", "Happy Villa" }, { "Iza Norah", " 4 ", "Happy house" },
				{ "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, { "Sam", "29", " Twinkle House" },
				{ "Anna Sam", " 27 ", "Happy Villa" }, { "Iza Norah", " 4 ", "Happy house" },
				{ "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, { "Sam", "29", " Twinkle House" },
				{ "Anna Sam", " 27 ", "Happy Villa" }, { "Iza Norah", " 4 ", "Happy house" },
				{ "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, { "Sam", "29", " Twinkle House" },
				{ "Anna Sam", " 27 ", "Happy Villa" }, { "Iza Norah", " 4 ", "Happy house" },
				{ "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, { "Sam", "29", " Twinkle House" },
				{ "Anna Sam", " 27 ", "Happy Villa" }, { "Iza Norah", " 4 ", "Happy house" },
				{ "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" } };

		String[] cn = { "Name", "Age", "House Address" };

		jt = new JTable(d, cn);
		jt.setBounds(30, 40, 200, 300);

		jsp = new JScrollPane(jt);

		TopPanel = new JPanel();
		menuPanel = new JPanel();
		backgroundPanel = new JPanel();
		namePanel = new JPanel();

		topButton = new JButton("주소록 전체");
		friendButton = new JButton("친구");
		companyButton = new JButton("회사");
		schoolButton = new JButton("학교");
		familyButton = new JButton("가족");
		addButton = new JButton("추가");
	}

	public void setInitLayout() {
		topButton.setPreferredSize(new Dimension(400, 50));

		backgroundPanel.setLayout(new BorderLayout());
		TopPanel.setLayout(new GridLayout(2, 1));
		menuPanel.setLayout(new GridLayout(1, 4));
		namePanel.setLayout(new BorderLayout());

		menuPanel.add(friendButton);
		menuPanel.add(companyButton);
		menuPanel.add(schoolButton);
		menuPanel.add(familyButton);

		namePanel.add(jsp);

		TopPanel.add(topButton);
		TopPanel.add(menuPanel);

		this.add(TopPanel, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(addButton, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new address1();
	}

}
