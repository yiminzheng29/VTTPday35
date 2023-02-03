package sg.edu.nus.pafworkshop21.workshop21.repositories;

public class Queries {
    public static final String SQL_INSERT_CONTACT = """
            insert into contact(name, phone, email) values(?, ?, ?)
            """;
}
