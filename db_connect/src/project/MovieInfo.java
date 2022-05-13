package project;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import lombok.Data;

@Data
public class MovieInfo extends JFrame implements ItemListener {

	MovieInfoDao dao;

	// 카테고리 검색
	private JPanel searchPanel;
	private TitledBorder categoryBorder;

	// crud
	private JPanel crudPanel;
	private TitledBorder crudBorder;

	private JRadioButton movieName;
	private JRadioButton releaseDate;

	private JTextField MovieNameField;
	private JTextField releasedDateField;

	private JButton MovieNameButton;
	private JButton ReleasedDateButton;
	
//	private JComboBox comboBox;

	// 영화 조회
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel mainPanel;

	// 영화 테이블
	String schema[] = { "번호", "이름", "개봉년도", "수익", "관객수", "스크린 수", "평점" };

	public MovieInfo() {

		dao = new MovieInfoDao();

		setBounds(100, 100, 628, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 메인 패널
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(null);

		// 카테고리로 검색
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		categoryBorder = new TitledBorder("카테고리 검색");
		searchPanel.setBorder(categoryBorder);
		searchPanel.setBounds(10, 80, 592, 105);
		mainPanel.add(searchPanel);

		//
		crudPanel = new JPanel();
		crudPanel.setLayout(null);
		crudBorder = new TitledBorder("crud");
		crudPanel.setBorder(crudBorder);
		crudPanel.setBounds(10, 10, 592, 60);
		mainPanel.add(crudPanel);

		model = new DefaultTableModel(null, schema);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 200, 588,330);
		scrollPane.setViewportView(table);
		mainPanel.add(scrollPane);

		// 라디오 박스
		movieName = new JRadioButton("이름");
		movieName.setBounds(20, 27, 50, 12);
		searchPanel.add(movieName);

		releaseDate = new JRadioButton("개봉일");
		releaseDate.setBounds(20, 67, 70, 12);
		searchPanel.add(releaseDate);

		MovieNameField = new JTextField("명량");
		MovieNameField.setBounds(100, 20, 230, 26);
		searchPanel.add(MovieNameField);

		releasedDateField = new JTextField("2014");
		releasedDateField.setBounds(100, 62, 230, 26);
		searchPanel.add(releasedDateField);
		
		MovieNameButton = new JButton("검색");
		MovieNameButton.setBounds(340, 20, 65, 25);
		searchPanel.add(MovieNameButton);
		
		ReleasedDateButton = new JButton("검색");
		ReleasedDateButton.setBounds(340, 60, 65, 25);
		searchPanel.add(ReleasedDateButton);
//		searchButton.addActionListener(this);
//        releaseDate.addActionListener(this);

		movieName.addItemListener(this);
		releaseDate.addItemListener(this);

		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(defaultTableCellRenderer);
		}

		SelectAll();

//        comboBox = new JComboBox();
//        comboBox.setBounds(146, 40, 100, 20);
//        searchPanel.add(comboBox);
//        comboBox.addItem("번호 선택");
//        
//        comboBox.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getStateChange() == ItemEvent.SELECTED) {
//					
//				}
//				
//			}
//		});

		setVisible(true);

	}

	public void SelectAll() {
//		dao.selectAll();
		for (int i = 0; i < dao.selectAll().size(); i++) {
			model.addRow(new Object[] { dao.selectAll().get(i).getMovieNumber(), dao.selectAll().get(i).getMovieName(),
					dao.selectAll().get(i).getReleasedDate(), dao.selectAll().get(i).getRevenue(),
					dao.selectAll().get(i).getAudience(), dao.selectAll().get(i).getScreen(),
					dao.selectAll().get(i).getStarRating() });
		}
	}

	// 라디오 버튼
	@Override
	public void itemStateChanged(ItemEvent e1) {

		// 영화 제목 버튼 클릭됨
		if (e1.getSource() == movieName) {
			releaseDate.setEnabled(false);
			releasedDateField.setEnabled(false);
			ReleasedDateButton.setEnabled(false);
			// 영화 쿼리 뿌림

			MovieNameButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == MovieNameButton) {
						dao.selectByMovieName(MovieNameField.getText());

						if (model.getRowCount() > 0) {
							for (int i = model.getRowCount() - 1; i > -1; i--) {
								model.removeRow(i);
							}
						}

						for (int i = 0; i < dao.selectByMovieName(MovieNameField.getText()).size(); i++) {
							System.out.println("영화제목");
							model.addRow(
									new Object[] { dao.selectByMovieName(MovieNameField.getText()).get(i).getMovieNumber(),
											dao.selectByMovieName(MovieNameField.getText()).get(i).getMovieName(),
											dao.selectByMovieName(MovieNameField.getText()).get(i).getReleasedDate(),
											dao.selectByMovieName(MovieNameField.getText()).get(i).getRevenue(),
											dao.selectByMovieName(MovieNameField.getText()).get(i).getAudience(),
											dao.selectByMovieName(MovieNameField.getText()).get(i).getScreen(),
											dao.selectByMovieName(MovieNameField.getText()).get(i).getStarRating() });
						}
					}
				}
			});

			if (e1.getStateChange() == ItemEvent.DESELECTED) {
				releaseDate.setEnabled(true);
				releasedDateField.setEnabled(true);
				ReleasedDateButton.setEnabled(true);
			}
		} else if (e1.getSource() == releaseDate) {
			movieName.setEnabled(false);
			MovieNameField.setEnabled(false);
			MovieNameButton.setEnabled(false);
			
			ReleasedDateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == ReleasedDateButton) {
						dao.selectByReleasedYear(releasedDateField.getText());
						
						if (model.getRowCount() > 0) {
							for (int i = model.getRowCount() - 1; i > -1; i--) {
								model.removeRow(i);
							}
						}

						for (int i = 0; i < dao.selectByReleasedYear(releasedDateField.getText()).size(); i++) {
							System.out.println("개봉일");
							model.addRow(new Object[] {
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getMovieNumber(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getMovieName(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getReleasedDate(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getRevenue(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getAudience(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getScreen(),
									dao.selectByReleasedYear(releasedDateField.getText()).get(i).getStarRating()
							});
						}
					}
				}
			});

			if (e1.getStateChange() == ItemEvent.DESELECTED) {
				movieName.setEnabled(true);
				MovieNameField.setEnabled(true);
				MovieNameButton.setEnabled(true);
			}
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		if(e.getSource() == searchButton) {
//			MovieInfoDao dao = new MovieInfoDao();
//			dao.selectByMovieName(searchField.getText());
//		}
//	}

}
