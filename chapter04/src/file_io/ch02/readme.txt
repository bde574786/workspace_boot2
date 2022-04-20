
바이트 단위 입력 스트림

*** InputStream ***

-- 바이트 단위에서 입력 스트림, 최상위 클래스
-- 많은 추상 메서드가 선언되어 있고 하위 스트림이 상속 받아 구현되어있다.

-- 주요 하위 클래스
FileInputStream : 파일에서 바이트 단위로 자료를 읽어들인다.
ByteArrayInputStream : byte 배열 메모리에서 바이트 단위로 자료를 읽는다.


-- 주요 메서드
int read() : 입력 스트림으로부터 한 바이트의 자료를 읽는다.
int read(byte b[]) : 입력 스트림으로부터 b[] 크기의 자료를 읽는다. (읽은 자료의 바이트 수를 반환)
int read(byte b[], int off, int len) : off 변수 위치부터 지정, len 길이 만큼 읽음, 바이트를 반환
void closed : 입력 스트림과 연결된 대상 리소스를 닫는다.


