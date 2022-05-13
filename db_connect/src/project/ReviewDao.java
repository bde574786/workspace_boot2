package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDao implements IReview{

	private static final String TABLE_NAME = "평점/리뷰";
	private DBClient client;
	private Connection connection;
	private ResultSet rs = null;
	
	private ArrayList<ReviewDto> reviewInfo;
	
	private Review review = new Review();
	
	public ReviewDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}
	
	@Override
	public ArrayList<ReviewDto> selectAll(){
		
		reviewInfo = new ArrayList<ReviewDto>();
		
		MovieInfo info = new MovieInfo();
		
		try {
			String query = "select * from reviewTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ReviewDto dto = new ReviewDto();
				
				int reviewNumber = rs.getInt("reviewNumber");
				String nickname = rs.getString("nickname");
				int movieNumber = rs.getInt("movieNumber");
				String movieName = rs.getString("movieName");
				String releasedDate = rs.getString("releasedDate");
				int audience = rs.getInt("audience");
				float starRating = rs.getFloat("starRating");
				String review = rs.getString("review");
				
				dto.setReviewNumber(reviewNumber);
				dto.setNickname(nickname);
				dto.setMovieNumber(movieNumber);
				dto.setMovieName(movieName);
				dto.setReleasedDate(releasedDate);
				dto.setAudience(audience);
				dto.setStarRating(starRating);
				dto.setReview(review);
				
				reviewInfo.add(dto);
				
				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
						rs.getInt("screen"), rs.getFloat("starRating")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reviewInfo;
	}

	@Override
	public ArrayList<ReviewDto> selectByMovieName(String movieName) {
		return null;
	}

	@Override
	public ArrayList<ReviewDto> selectByReviewNumber(String reviewNumber) {
		return null;
	}
}
