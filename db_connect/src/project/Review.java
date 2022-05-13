package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Review extends JFrame {

	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField3;
	private JPanel jPanel;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton btn;

	// 영화 조회
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	// 영화 테이블
	String schema[] = { "번호", "이름", "개봉년도", "관객수",  "평점" };

	public Review() {
		setTitle("평점/리뷰 작성 페이지 입니다");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 960);
		setLocationRelativeTo(null);

		model = new DefaultTableModel(null, schema);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 153, 588, 313);
		scrollPane.setViewportView(table);
		
		
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(defaultTableCellRenderer);
		}
				
		jPanel = new JPanel();
		jLabel3 = new JLabel("닉네임");
		textField3 = new JTextField(5);
		jLabel = new JLabel("영화");
		textField1 = new JTextField(20);
		jLabel1 = new JLabel("평점");
		textField = new JTextField(" /10", 5);
		jLabel2 = new JLabel("영화리뷰");
		textArea = new JTextArea("영화리뷰를 남겨주세요", 25, 40);
		btn = new JButton("저장");

		setVisible(true);
		jPanel.add(scrollPane);
		jPanel.add(jLabel3);
		jPanel.add(textField3);
		jPanel.add(jLabel);
		jPanel.add(textField1);
		jPanel.add(jLabel1);
		jPanel.add(textField);
		jPanel.add(jLabel2);
		jPanel.add(textArea);
		jPanel.add(btn);
		

		add(jPanel, FlowLayout.LEFT);

		setEventListener();
	}

	private void setEventListener() {
		btn.addActionListener(new ActionListener() {

			// 저장 버튼 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("평점 / 리뷰 저장완료");
				ReviewList reviewList = new ReviewList();
			}
		});
	}

	public static void main(String[] args) {
		new Review();
	}
}
