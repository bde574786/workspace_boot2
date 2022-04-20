package ch01;

// 1. 인터페이스를 선언한다
/**
 * 
 * @author 
 * 콜백 메서드 만드는 연습
 */
public interface ICallBackBtnAction {

	public abstract void clickedAddBtn();
	// 추상 메서드 추가
	public abstract void clickedSubstractBtn();
	void passValue(int result);

}
