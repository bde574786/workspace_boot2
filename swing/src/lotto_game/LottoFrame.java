package lotto_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoFrame extends JFrame implements ActionListener {

	private JPanel panel1;
	private JLabel label1;
	private JButton startButton;
	private int[] lottoNumbers = new int[6];

	public LottoFrame() {
		setSize(800, 400);
		setBackground(Color.gray);
		setVisible(true);
		startButton = new JButton("로또");
		add(startButton, BorderLayout.NORTH);
		startButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lottoNumbers = getLotto();
		// 그림을 다시 그려라
		// paint 다시 실행
		repaint();
		
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		Font font = new Font("궁서체", Font.BOLD, 20);
		g.setFont(font);

		if (lottoNumbers[0] == 0) {
			g.drawString("로또 버튼을 클릭하세요", 50, 100);
			return;
		}

		// lottoNumber[0] 값이 있다면 ( 6개 번호를 생성 한 후 )
		// 여기서 번호를 그려 봅니다.
		
		for (int i = 0; i < lottoNumbers.length; i++) {
			g.drawString(lottoNumbers[i] + "", ( 50 * i ), 100);
		}
		
		
	}

	public static void main(String[] args) {
		new LottoFrame();
	}

	public int[] getLotto() {

		int[] lotto = new int[6];
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			int j = random.nextInt(45) + 1;
			lotto[i] = j;
			// 같은 숫자가 있는지 확인
			for(int e = 0; e < i; e++) {
				if(lotto[i] == lotto[e]) {
					i = i - 1;
					break;
				}
			}
			
			
			
		}
		
		Arrays.sort(lotto);
		for (int i : lotto) {
			System.out.println(i);
		}

		
		return lotto;
	}

}
