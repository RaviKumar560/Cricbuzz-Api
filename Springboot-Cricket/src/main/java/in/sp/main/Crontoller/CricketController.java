package in.sp.main.Crontoller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import in.sp.main.Entity.LiveScore;
import in.sp.main.Service.CricketScoreService;

@RestController
@RequestMapping("/api/cricket")
@CrossOrigin(origins = "http://localhost:5173/") // Allow frontend to access backend
public class CricketController {

	private final CricketScoreService cricketScoreService;

    public CricketController(CricketScoreService cricketScoreService) {
        this.cricketScoreService = cricketScoreService;
    }

    @GetMapping("//live-score")
    public CompletableFuture<JsonNode> getLiveScore() {
        return cricketScoreService.getLiveScoreAsync();
    }
}
