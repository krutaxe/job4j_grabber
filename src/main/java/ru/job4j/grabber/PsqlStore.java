package ru.job4j.grabber;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
            cnn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw  new IllegalStateException(e);
        }
    }

    public Post getResultSet(ResultSet resultSet) {
        Post post = null;
        try {
             post = new Post(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("text"),
                    resultSet.getString("link"),
                    resultSet.getTimestamp("created").toLocalDateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    @Override
    public void save(Post post) {
        Timestamp created = Timestamp.valueOf(post.getCreated());
        try (PreparedStatement statement = cnn.prepareStatement(
                "insert into post (name, text, link, created)"
                        + "values (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, post.getTitle());
                statement.setString(2, post.getDescription());
                statement.setString(3, post.getLink());
                statement.setTimestamp(4, created);
                statement.execute();
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        post.setId(resultSet.getInt(1));
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> postList = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement(
                "select * from post;")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    postList.add(getResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement statement = cnn.prepareStatement(
                "select * from post where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                   post = getResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Post post1 = new Post("Системный аналитик",
                "Мы - Центр Корпоративных Решений, "
               + "трайб корпоративного блока Сбербанка, отвечающий за все виды удаленного "
               + "практики Agile и DevOps.",
                "https://career.habr.com/vacancies/1000083302",
                localDateTime);

        Post post2 = new Post("Senior Java Developer",
                "Мы ищем профессионалов, способных мыслить глобально и создавать тренды "
                        + "Сейчас нам требуется Java разработчик, способный быстро погрузиться "
                        + "в новые задачи и усилить нашу команду.",
                "https://career.habr.com/vacancies/1000100723",
                localDateTime);

        try (InputStream in = PsqlStore.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties cfg = new Properties();
            cfg.load(in);
            PsqlStore psqlStore = new PsqlStore(cfg);
            psqlStore.save(post1);
            psqlStore.save(post2);
            System.out.println(psqlStore.getAll());
            System.out.println(psqlStore.findById(280));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
