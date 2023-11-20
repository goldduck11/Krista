package providers;

public class Factory {
    public static SQLProvider create(String type){
        switch (type) {
            case "mongo" -> { return new MongoDBProvider();}
            case "postgre" -> { return new PostgreSQLProvider();}
            default -> {throw new IllegalArgumentException("Некорректные данные для создания provider");}
        }
    }
}
