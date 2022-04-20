package ch02;

public class MainTest {

	public static void main(String[] args) {

		// 해커 뉴스 생성
		HackerNews hackerNews = new HackerNews();
		
		// 기사 작성
		MyArticle article = new MyArticle("오늘 날씨가 좋음 !!!!", hackerNews);
		
		article.complete();
		
	}

}
