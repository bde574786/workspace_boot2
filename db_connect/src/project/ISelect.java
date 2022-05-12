package project;

import java.util.ArrayList;


public interface ISelect {

	//모든 영화 리스트 출력
	ArrayList<MovieInfoDto> selectAll();
	// 영화에대한 정보리스트 출력 OK
//	ArrayList<MovieListSelectDto> movieList(String movieName);
//	// 영화티켓 금액 출력 OK
//	ArrayList<MovieTicketPriceDto> movieTicketPrice(String movieName);
//	//모든 배우 리스트 출력
//	ArrayList<AllactorListDto> AllActorInfo();
//	// 배우에대한 정보리스트 출력 OK
//	ArrayList<ActorInfoSelectDto> actorInfo(String actorName);
//	// 배우가 찍은 영화 리스트 출력 OK
//	ArrayList<ActorMovieListSelect> actorMovieList(String actorName);
//	
//	// 
	
	// 영화제목으로 출력
	ArrayList<MovieInfoDto> selectByMovieName(String movieName);
	
	// 개봉일로 출력
	ArrayList<MovieInfoDto> selectByReleasedYear(String releasedYear);
}
