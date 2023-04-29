import org.hsqldb.server.Server;

public class DbServerApplication {
    public static void main(String[] args) {
        Server.main(
                new String[] {
                    "--database.0", "mem:csc330",
                    "--dbname.0", "csc330",
                    "daemon", "true"
                });
    }
}
