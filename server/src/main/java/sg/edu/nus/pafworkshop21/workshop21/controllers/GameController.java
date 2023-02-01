package sg.edu.nus.pafworkshop21.workshop21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import sg.edu.nus.pafworkshop21.workshop21.models.Game;
import sg.edu.nus.pafworkshop21.workshop21.services.BGGService;

@Controller
@RequestMapping(path="/api")
//@CrossOrigin(origins="*") // Add CORS header to the response
public class GameController {
    
    @Autowired
    private BGGService bggSvc;

    // GET /api/games?name=train
    @GetMapping(value="/games", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody 
    public ResponseEntity<String> getGames(@RequestParam String name) {
        System.out.printf(">>> qs: name=%s\n", name);

        List<Game> games = bggSvc.findGameByName(name);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        games.stream().forEach(x -> {
            arrBuilder.add(x.toJson());
        });
        return ResponseEntity.ok(arrBuilder.build().toString());
    }
}
