package sg.edu.nus.pafworkshop21.workshop21.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.pafworkshop21.workshop21.models.Game;
import static sg.edu.nus.pafworkshop21.workshop21.repositories.Queries.*;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate template;

    public List<Game> findGamesByName(String name) {

        List<Game> games = new LinkedList<>();

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_BY_NAME, name);

        while (rs.next()) {
            games.add(Game.create(rs));
        }
        return games;
    }
}
