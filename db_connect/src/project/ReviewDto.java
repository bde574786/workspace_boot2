package project;

import lombok.Data;

@Data
public class ReviewDto extends MovieInfoDto {

	private int reviewNumber;
	private String nickname;
	private String review;
}
