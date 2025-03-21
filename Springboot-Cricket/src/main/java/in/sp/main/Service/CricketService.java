package in.sp.main.Service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class CricketService {
	
	 public String getLiveScores() {
	        try {
	            // Connect to Cricbuzz mobile site (simpler HTML structure)
	            Document doc = Jsoup.connect("https://m.cricbuzz.com/").get();

	            // Select elements containing live scores
	            Elements scores = doc.select(".cb-lv-scrs-well"); // Adjust selector if needed

	            // Convert extracted elements to text
	            return scores.text();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error fetching scores";
	        }
	    }


}
