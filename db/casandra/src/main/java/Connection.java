import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Connection {

    public static void main(String[] args) {
        Cluster cluster = Cluster.builder()
                .addContactPoints("127.0.0.1")
                .build();

        Session session = cluster.connect("test");
//
//        session.execute("CREATE TABLE users (" +
//                " username varchar PRIMARY KEY," +
//                " password varchar " +
//                ");");
//
//        session.execute("INSERT INTO test.users (username, password) " +
//                "VALUES ('Bryzhatov', 'Password')");

        ResultSet resultSet = session.execute("SELECT * FROM test.users");

        for (Row row : resultSet) {
            System.out.println(row);
        }
    }
}
