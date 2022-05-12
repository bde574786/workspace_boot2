package project.administor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Data;
import project.DBClient;

@Data
public class MovieInfoDao {

	private static final String TABLE_NAME = "영화정보";
	private DBClient client;
	private Connection connection;
	private ResultSet rs = null;
	
	
	public MovieInfoDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}
	
	
	public ArrayList<MovieInfoDto> select(){
		
		ArrayList<MovieInfoDto> movieInfo = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "select * from movieTbl";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			
			MovieInfo info = new MovieInfo();
			while(rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();
				
				int movieNumber = rs.getInt("movieNumber");
				String movieName = rs.getString("movieName");
				String releasedDate = rs.getString("releasedDate");
				long revenue = rs.getLong("revenue");
				long audience = rs.getLong("audience");
				int screen = rs.getInt("screen");
				float starRating = rs.getFloat("starRating");
				
				dto.setMovieNumber(movieNumber);
				dto.setMovieName(movieName);
				dto.setReleasedDate(releasedDate);
				dto.setRevenue(revenue);
				dto.setAudience(audience);
				dto.setScreen(screen);
				dto.setStarRating(starRating);
				
				movieInfo.add(dto);
				
				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
						rs.getInt("screen"), rs.getFloat("starRating")});
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieInfo;
		
	}
	
	
	
	
	
	
	
	
}
