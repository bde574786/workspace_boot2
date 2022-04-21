package file_io.ch04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.JTextField;

// 메인
public class Caller extends BaseProgram {

	
	ICaller iCaller = new ICaller() {
	
		@Override
		public void saveBtn() {
			System.out.println("저장되었습니다.");
		}
	};


	public Caller(String name) {
		super(name);
	}

	@Override
	protected void initData() {
		super.initData();
	}
	
	@Override
	protected void setInitLayout() {
		super.setInitLayout();
	}
	
}
