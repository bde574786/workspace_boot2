package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Data;

@Data
public class MovieInfoDao implements ISelect{

	private static final String TABLE_NAME = "영화정보";
	private DBClient client;
	private Connection connection;
	private ResultSet rs = null;
	
	private ArrayList<MovieInfoDto> movieInfo;
	
//	private MovieInfo info = new MovieInfo();
	
	public MovieInfoDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}
	
	
	public ArrayList<MovieInfoDto> selectAll(){
		
		 movieInfo = new ArrayList<MovieInfoDto>();
		
		 ArrayList<MovieInfoDto> dtoAll = new ArrayList<MovieInfoDto>();
		 
		try {
			String query = "select * from movieTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			
			while(rs.next()) {
				
				MovieInfoDto dto = new MovieInfoDto();
				
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setScreen(rs.getInt("screen"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				dtoAll.add(dto);
				
				
//				movieInfo.add(dto);
				
//				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
//						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
//						rs.getInt("screen"), rs.getFloat("starRating")});
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtoAll;
		
	}
	
	
	@Override
	public ArrayList<MovieInfoDto> selectByMovieName(String movieName) {
		
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "SELECT * FROM movietbl\r\n"
					+ "WHERE movieName LIKE ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			String name = '%' + movieName + '%';
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();
			
			
			while(rs.next()){
				MovieInfoDto dto = new MovieInfoDto();
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setScreen(rs.getInt("screen"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				dtoAll.add(dto);
				
				
//				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
//						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
//						rs.getInt("screen"), rs.getFloat("starRating")});
//				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtoAll;
		
	}
	
	
	
	@Override
	public ArrayList<MovieInfoDto> selectByReleasedYear(String releasedYear) {
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "SELECT * FROM movietbl\r\n"
					+ "WHERE releasedDate LIKE ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			String year = '%' + releasedYear + '%';
			preparedStatement.setString(1, year);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				MovieInfoDto dto = new MovieInfoDto();
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setScreen(rs.getInt("screen"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				dtoAll.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtoAll;
		
	}
	

	
	
}
