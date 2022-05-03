
package ch05;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    @SerializedName("movie_count")
    @Expose
    private Integer movieCount;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("page_number")
    @Expose
    private Integer pageNumber;
    @SerializedName("movies")
    @Expose
    private List<Movie> movies = null;

    

}
