package ch09;

public class MainTest2 {

	public static void main(String[] args) {

		// StringBuilder, StringBuffer 개념을 이해해 보자.
		// 문자열을 여러 번 연결하거나 변경할 때 사용하면 유옹하다.
		// StringBuffer (멀티 쓰레드에서 동기화를 보장하기 때문에 유용하다)
		// StringBuilder 단일 쓰레드에서 권장사항이다.
		
		String java = new String("java");
		String android = new String("android");
		
		System.out.println(java + android);
		
		StringBuilder sb = new StringBuilder(java);
		System.out.println(System.identityHashCode(sb));
		sb.append(android);
		System.out.println(System.identityHashCode(sb));
		// StringBuilder 사용시 하나의 메모리에서 연산이 되게 때문에
		// new로 힙에 생성하는것보다 메모리 낭비가 적다
		
		System.out.println(sb);
		java = sb.toString();
		// java = sb는 타입 미스매치
		// 
		// String <- StringBuilder ( toString 사용 )
		
		
		
		
	}

}
