package classwork.day17;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DbConnect {
    private static Properties prop = getProperties();

    public static void main(String[] args) {
        //первый запрос
        //prop.forEach((k,v) -> System.out.println(v.toString()));

        //второй запрос
        /*String query = "SHOW TABLES";
        execStatement(query);*/

        //третий запрос
        /*String query = "SELECT * FROM Categories WHERE CategoryID = ?";
        execPreparedStatement(query, 2);*/

        //String query = "SELECT * FROM Categories";
        loadCategories();


    }

    private static Properties getProperties() {

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("src/test/resources/db.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return prop;
    }

    private static MysqlDataSource getDataSource(Properties prop) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("PORT")));
        dataSource.setUser(prop.getProperty("USER"));
        dataSource.setPassword(prop.getProperty("PWD"));
        dataSource.setDatabaseName(prop.getProperty("DBNAME"));
        return dataSource;
    }

    private static void execStatement(String query) {
        try (Connection connection = getDataSource(prop).getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        /*} catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        }
    }

    private static void execPreparedStatement(String query, int id) {
        try (Connection connection = getDataSource(prop).getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadCategories() {
        String query = "SELECT * FROM Categories";
        List<Category> categories = new ArrayList<>();

        try (Connection connection = getDataSource(prop).getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        categories.forEach(category -> System.out.println(category.toString()));
    }
}


