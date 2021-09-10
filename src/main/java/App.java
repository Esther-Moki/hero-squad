import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/hero", (request, response) -> "Hello Friend!");
    }
}
