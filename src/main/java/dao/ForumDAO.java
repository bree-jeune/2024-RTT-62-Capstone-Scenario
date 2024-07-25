package dao;

import models.Forum;
import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ForumDAO {

    public void addForum(Forum forum) {
        String query = "INSERT INTO Forums (title, created_by, created_at, updated_by, updated_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, forum.getTitle());
            preparedStatement.setInt(2, forum.getCreatedBy());
            preparedStatement.setTimestamp(3, forum.getCreatedAt());
            preparedStatement.setInt(4, forum.getUpdatedBy());
            preparedStatement.setTimestamp(5, forum.getUpdatedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Forum> getAllForums() {
        List<Forum> forums = new ArrayList<>();
        String query = "SELECT * FROM Forums";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Forum forum = new Forum();
                forum.setForumId(resultSet.getInt("forum_id"));
                forum.setTitle(resultSet.getString("title"));
                forum.setCreatedBy(resultSet.getInt("created_by"));
                forum.setCreatedAt(resultSet.getTimestamp("created_at"));
                forum.setUpdatedBy(resultSet.getInt("updated_by"));
                forum.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                forums.add(forum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forums;
    }

    public Forum getForumById(int forumId) {
        Forum forum = null;
        String query = "SELECT * FROM Forums WHERE forum_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, forumId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    forum = new Forum();
                    forum.setForumId(resultSet.getInt("forum_id"));
                    forum.setTitle(resultSet.getString("title"));
                    forum.setCreatedBy(resultSet.getInt("created_by"));
                    forum.setCreatedAt(resultSet.getTimestamp("created_at"));
                    forum.setUpdatedBy(resultSet.getInt("updated_by"));
                    forum.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forum;
    }

    public void updateForum(Forum forum) {
        String query = "UPDATE Forums SET title = ?, created_by = ?, created_at = ?, updated_by = ?, updated_at = ? WHERE forum_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, forum.getTitle());
            preparedStatement.setInt(2, forum.getCreatedBy());
            preparedStatement.setTimestamp(3, forum.getCreatedAt());
            preparedStatement.setInt(4, forum.getUpdatedBy());
            preparedStatement.setTimestamp(5, forum.getUpdatedAt());
            preparedStatement.setInt(6, forum.getForumId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteForum(int forumId) {
        String query = "DELETE FROM Forums WHERE forum_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, forumId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
