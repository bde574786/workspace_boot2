package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import lombok.Data;

@Data
public class Review extends JFrame {

	MovieInfoDao dao;
	
	private JTextArea textArea;
	private JTextField starRatingField;
	private JTextField movieField;
	private JTextField nickNameField;
	private JPanel jPanel;
	private JLabel movieLabel;
	private JLabel starRatingLabel;
	private JLabel reviewLabel;
	private JLabel nickNameLabel;
	private JButton btn;

	
	// 영화 조회
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	
	// 영화 테이블
	String schema[] = { "번호", "이름", "개봉년도", "관객수",  "평점" };

	public Review() {
		
		dao = new MovieInfoDao();
		
		setTitle("평점/리뷰 작성 페이지 입니다");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 960);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
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
		
		SelectAll();
		
		jPanel = new JPanel();
		setContentPane(jPanel);
		
		nickNameLabel = new JLabel("닉네임");
		nickNameField = new JTextField(5);
		
		movieLabel = new JLabel("영화");
		movieField = new JTextField(20);
		
		starRatingLabel = new JLabel("평점");
		starRatingField = new JTextField(" /10", 5);
		
		reviewLabel = new JLabel("영화리뷰");
		textArea = new JTextArea("영화리뷰를 남겨주세요", 25, 40);
		btn = new JButton("저장");

		setVisible(true);
		
		jPanel.add(scrollPane);
		jPanel.add(nickNameLabel);
		jPanel.add(nickNameField);
		jPanel.add(movieLabel);
		jPanel.add(movieField);
		jPanel.add(starRatingLabel);
		jPanel.add(starRatingField);
		jPanel.add(reviewLabel);
		jPanel.add(textArea);
		jPanel.add(btn);
		


		setEventListener();
	}

	private void SelectAll() {
		for (int i = 0; i < dao.selectAll().size(); i++) {
			model.addRow(new Object[] { dao.selectAll().get(i).getMovieNumber(), dao.selectAll().get(i).getMovieName(),
			dao.selectAll().get(i).getReleasedDate(), dao.selectAll().get(i).getAudience(), dao.selectAll().get(i).getStarRating() });
		}
	}

	
	private void setEventListener() {
		btn.addActionListener(new ActionListener() {

			// 저장 버튼 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("평점 / 리뷰 저장완료");
				ReviewDao rd = new ReviewDao();
				ReviewList reviewList = new ReviewList();
			
				String movieName = movieField.getText();
				
				findMovie(movieName);
				
			}
		
		
		});
	}

	
	public Object findMovie(String movieName) {
		
		Object movieNumber = "";
		
		if((movieName != null) && (movieName.length() > 0)) {
			for(int j = 0; j < model.getRowCount(); j++) {
				for(int i = 0; i < model.getColumnCount(); i++) {
					if(model.getValueAt(j, i).equals(movieName)) {
						movieNumber = model.getValueAt(j, 0);
						System.out.println(movieNumber);
					}
				}
			}
			
		}
		return movieNumber;
	}
	
	
	
	public static void main(String[] args) {
		new Review();
	}
	
	
	
	
	
}