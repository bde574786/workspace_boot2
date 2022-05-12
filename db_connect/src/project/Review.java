package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Review extends JFrame{

    private JTextArea textArea;
    private JTextField textField;
    private JTextField textField1;
    private JPanel jPanel;
    private JLabel jLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton btn;

    public Review() {
        setTitle("평점/리뷰 작성 페이지 입니다");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 530);
        setLocationRelativeTo(null);

        jPanel = new JPanel();
        jLabel = new JLabel("영화");
        textField1 = new JTextField(20);
        jLabel1 = new JLabel("평점");
        textField = new JTextField(" /10", 5);
        jLabel2 = new JLabel("영화리뷰");
        textArea = new JTextArea("영화리뷰를 남겨주세요", 25, 30);
        btn = new JButton("저장");

        setVisible(true);
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

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("평점 / 리뷰 저장완료");
            }
        });
    }

    public static void main(String[] args) {
        new Review();
    }
}