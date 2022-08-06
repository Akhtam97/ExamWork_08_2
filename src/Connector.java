import java.sql.*;
import java.util.Scanner;

public class Connector {
    private static final String url = "jdbc:postgresql://localhost:5432/examwork2";
    private static final String user = "postgres";
    private static final String password = "16091997";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password); //DriverManager.getConnection(url, user, password)
            System.out.println("Connected to the PostgresSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Ошибочка");
        }
        return conn;
    }

    //создания новой новости.
    public void createNews(News news) {
        String SQL = "INSERT INTO news (mainNews,text) VALUES (?,?);";
        try (Connection conn = connect();
             PreparedStatement stmt = connect().prepareStatement(SQL)) {
            stmt.setString(1, news.getMainNews());
            stmt.setString(2, news.getText());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //отображения новости (заголовок и текст)
    public void getNews() {
        try {
            String sql = "Select mainNews,text FROM news;";
            PreparedStatement statement = connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Заголовок : " + rs.getString("mainNews") + " \n" + "Новость : " + rs.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    --удаления новости по Id
    public void deleteNewsId(News news){
        String SQL = "DELETE FROM news WHERE id=?;";
        try (Connection conn = connect();
             PreparedStatement stmt = connect().prepareStatement(SQL)) {
            stmt.setInt(1,news.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //--изменения текста и заголовка новости, по Id

    public void updateNewsId(News news){
        String SQL = "update news set mainNews = ? , text = ? where id= ?;";
        try (Connection conn = connect();
             PreparedStatement stmt = connect().prepareStatement(SQL)) {
            stmt.setString(1,news.getMainNews());
            stmt.setString(2,news.getText());
            stmt.setInt(3,news.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

