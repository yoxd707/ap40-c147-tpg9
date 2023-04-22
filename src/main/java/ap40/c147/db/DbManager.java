package ap40.c147.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NonNull
public class DbManager {

    private final String database;
    private final String username;
    private final String password;


    public Connection connect() {
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, username, password);
		}
        catch (Exception e) { }

        return conexion;
	}


    public void setup() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", username, password);
			Statement statement = conexion.createStatement();

            String sql1 = "DROP DATABASE IF EXISTS " + database + ";";
            String sql2 = "CREATE DATABASE " + database + ";";

            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);

			statement.close();
			conexion.close();
            createSchema();
		}
        catch (Exception e) {
            e.printStackTrace();
        }
	}


    private void createSchema() {
        try {
			Connection conexion = connect();
			Statement statement = conexion.createStatement();

            String sql1 = "CREATE TABLE participante(" +
                "id int NOT NULL AUTO_INCREMENT," +
                "nombre varchar(50) NOT NULL," +
                "PRIMARY KEY (id)" +
            ");";

            String sql2 = "CREATE TABLE pronostico(" +
                "id int NOT NULL AUTO_INCREMENT," +
                "participante int NOT NULL," +
                "partido int NOT NULL," +
                "gana1 boolean NOT NULL," +
                "empata boolean NOT NULL," +
                "gana2 boolean NOT NULL," +
                "PRIMARY KEY (id)" +
            ");";

            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);

			statement.close();
			conexion.close();
		}
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
