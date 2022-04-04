package ch03;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JavaTableExample1{

	JFrame fr;
	JTable jt;
	JScrollPane jsp;
	
	
	public JavaTableExample1() {
		initData();
		setInitLayout();
	}
	
	public void initData() {
		fr = new JFrame();
		fr.setTitle("JTable Sample");
		fr.setSize(500, 200);
		
		
		String[][] d = {
				{ "Sam", "29" ," Twinkle House" },
				{ "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" },
				};
		
		String[] cn =  { "Name", "Age", "House Address" };
		
		jt = new JTable(d, cn);
		jt.setBounds(30, 40, 200, 300);
		
		jsp = new JScrollPane(jt);
		
		
	}
	
	public void setInitLayout() {
		fr.setVisible(true);
		fr.add(jsp);
	}
	
	public static void main(String[] args) {
		new JavaTableExample1();
	}
	
	
}