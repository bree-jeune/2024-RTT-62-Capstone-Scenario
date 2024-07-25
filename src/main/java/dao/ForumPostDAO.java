package dao;

import models.ForumPost;
import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ForumPostDAO {

    // Method to add a forum post
    public void addForumPost(ForumPost forumPost) {
        String query = "INSERT INTO ForumPosts (forum_id, user_id, content, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, forumPost.getForumId());
            preparedStatement.setInt(2, forumPost.getUserId());
            preparedStatement.setString(3, forumPost.getContent());
            preparedStatement.setTimestamp(4, forumPost.getCreatedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all forum posts
    public List<ForumPost> getAllForumPosts() {
        List<ForumPost> forumPosts = new ArrayList<>();
        String query = "SELECT * FROM ForumPosts";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ForumPost forumPost = new ForumPost();
                forumPost.setPostId(resultSet.getInt("post_id"));
                forumPost.setForumId(resultSet.getInt("forum_id"));
                forumPost.setUserId(resultSet.getInt("user_id"));
                forumPost.setContent(resultSet.getString("content"));
                forumPost.setCreatedAt(resultSet.getTimestamp("created_at"));
                forumPosts.add(forumPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forumPosts;
    }

    // Method to retrieve a forum post by ID
    public ForumPost getForumPostById(int postId) {
        ForumPost forumPost = null;
        String query = "SELECT * FROM ForumPosts WHERE post_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, postId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    forumPost = new ForumPost();
                    forumPost.setPostId(resultSet.getInt("post_id"));
                    forumPost.setForumId(resultSet.getInt("forum_id"));
                    forumPost.setUserId(resultSet.getInt("user_id"));
                    forumPost.setContent(resultSet.getString("content"));
                    forumPost.setCreatedAt(resultSet.getTimestamp("created_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forumPost;
    }

    // Method to update a forum post
    public void updateForumPost(ForumPost forumPost) {
        String query = "UPDATE ForumPosts SET forum_id = ?, user_id = ?, content = ?, created_at = ? WHERE post_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, forumPost.getForumId());
            preparedStatement.setInt(2, forumPost.getUserId());
            preparedStatement.setString(3, forumPost.getContent());
            preparedStatement.setTimestamp(4, forumPost.getCreatedAt());
            preparedStatement.setInt(5, forumPost.getPostId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a forum post
    public void deleteForumPost(int postId) {
        String query = "DELETE FROM ForumPosts WHERE post_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, postId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
