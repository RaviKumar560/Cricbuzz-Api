package in.sp.main.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CricketScoreService {

    private final String apiKey = "90ada9a07emshd3c7a3e8ac51e98p101174jsn26b37d052606"; // Replace with your API key
    private final String apiUrl = "https://cricbuzz-cricket.p.rapidapi.com/mcenter/v1/41881/comm";
    private final String apiHost = "cricbuzz-cricket.p.rapidapi.com";

    public CompletableFuture<JsonNode> getLiveScoreAsync() {
        AsyncHttpClient client = new DefaultAsyncHttpClient();

        return client.prepareGet(apiUrl)
                .setHeader("x-rapidapi-key", apiKey)
                .setHeader("x-rapidapi-host", apiHost)
                .execute()
                .toCompletableFuture()
                .thenApply(response -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        return objectMapper.readTree(response.getResponseBody());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    } finally {
                        try {
                            client.close();
                        } catch (Exception ignored) {
                        }
                    }
                });
    }
}
