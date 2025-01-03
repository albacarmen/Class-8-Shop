package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.interfaces.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{

    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String allCatQuery = "SELECT * FROM categories";

        try (Connection connection = getConnection();
             PreparedStatement allStatement = connection.prepareStatement(allCatQuery);
             ResultSet results = allStatement.executeQuery()) {

            while (results.next()) {
                categories.add(mapRow(results));
            }
        }catch(SQLException e){e.printStackTrace();}

        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        Category category = null;
        String getByIdQuery = "SELECT * FROM categories WHERE category_id = ?";

        try(Connection connection = getConnection();
            PreparedStatement getByIdStatement = connection.prepareStatement(getByIdQuery)){
            getByIdStatement.setInt(1, categoryId);

            try(ResultSet results = getByIdStatement.executeQuery()){
                if(results.next()){
                    int categoryIdFromDb = results.getInt("category_id");
                    String name = results.getString("name");
                    String desc = results.getString("description");

                    category = new Category(categoryIdFromDb, name, desc);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return category;
    }

    @Override
    public Category create(Category category) {
        String addQuery = "INSERT INTO categories (name, description) Values (?, ?)";

        try(Connection connection = getConnection();
            PreparedStatement addStatement = connection.prepareStatement(addQuery, PreparedStatement.RETURN_GENERATED_KEYS)){

            addStatement.setString(1, category.getName());
            addStatement.setString(2, category.getDescription());

            int affectedRows = addStatement.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Problem Creating Statement");
            }

            try(ResultSet generatedKeys = addStatement.getGeneratedKeys()){
                if(generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    category.setCategoryId(generatedId);
                }else{
                    throw new SQLException("Problem Generating ID");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();}

        return category;
    }

    @Override
    public void update(int categoryId, Category category) {
        String updateQuery = "UPDATE categories SET name = ?, description = ? WHERE category_id = ?";

        try(Connection connection = getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){

            updateStatement.setString(1, category.getName());
            updateStatement.setString(2, category.getDescription());
            updateStatement.setInt(3, categoryId);

            int affectedRows = updateStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No category found with the given ID to update.");
            }
        }catch(SQLException e){
            e.printStackTrace();}
    }

    @Override
    public void delete(int categoryId) {
        String deleteQuery = "DELETE FROM categories WHERE category_id = ?";

        try(Connection connection = getConnection();
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)){

            deleteStatement.setInt(1, categoryId);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("No category found with ID: " + categoryId);
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error while deleting category with ID: " + categoryId, e);
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
