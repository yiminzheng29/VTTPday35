package sg.edu.nus.pafworkshop21.workshop21.repositories;

public class Queries {
    
    public static String SQL_SELECT_GAME_BY_NAME = """
            select * from game where name like ?
            """;
}
