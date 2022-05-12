package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.administor.MovieInfoDao;

public class StartPage extends JFrame {

    private JPanel mainPanel;
    private JLabel label1;
    private JButton button1;
    private JButton button2;

    public StartPage() {
        setBounds(100, 100, 628, 515);
        setTitle("영화 리뷰/평점 작성 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        setContentPane(mainPanel);
        label1 = new JLabel("환영합니다. 영화 리뷰/평점 작성 프로그램입니다.");
        button1 = new JButton("관리자 버튼");
        button2 = new JButton("사용자 시작 버튼");

        mainPanel.add(label1);
        mainPanel.add(button1);
        mainPanel.add(button2);

        label1.setBounds(200, 180, 300, 50);
        button1.setBounds(180, 400, 100, 30);
        button2.setBounds(330, 400, 130, 30);

        setVisible(true);
        addEventListener();
    }

    private void addEventListener() {

        // 익명 구현 객체
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new MovieInfoDao().select();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("사용자 시작");
            }
        });
    }

    public static void main(String[] args) {
        new StartPage();
    }
}