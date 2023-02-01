package sg.edu.nus.pafworkshop21.workshop21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.pafworkshop21.workshop21.models.Game;
import sg.edu.nus.pafworkshop21.workshop21.repositories.GameRepository;

@Service
public class BGGService {
    
    @Autowired
    private GameRepository gameRepo;

    public List<Game> findGameByName(String name) {
        return gameRepo.findGamesByName("%%%s%%".formatted(name)); //first 2 % is to escape the %
    }
}
