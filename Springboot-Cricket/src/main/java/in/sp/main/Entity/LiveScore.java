package in.sp.main.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveScore {

    @JsonProperty("matchInfo")
    private MatchInfo matchInfo;

    @Data
    public static class MatchInfo {
        private String match;
        private String team1;
        private String team2;
        private String score;
        private String status;
    }
}
