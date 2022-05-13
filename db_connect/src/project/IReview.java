package project;

import java.util.ArrayList;

public interface IReview {

	// 모든 리뷰 리스트 출력
	ArrayList<ReviewDto> selectAll();
	
	// 영화제목으로 리뷰 출력
	ArrayList<ReviewDto> selectByMovieName(String movieName);
	
	// 번호로 출력
	ArrayList<ReviewDto> selectByReviewNumber(String reviewNumber);
}
