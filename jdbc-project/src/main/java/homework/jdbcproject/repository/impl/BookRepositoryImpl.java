package homework.jdbcproject.repository.impl;

import homework.jdbcproject.entity.Book;
import homework.jdbcproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    private DataSource dataSource;

    public BookRepositoryImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> findAllBooks (){
        List<Book> result = new ArrayList<>();
        String SQL_findAllBooks = "select * from books";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_findAllBooks)){
            while(resultSet.next()){
                Book book = convertRowToBook(resultSet);
                result.add(book);
            }
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
        return result;
    }

    public Book getBookById(Long id){
        String SQL_getBookById = "select * from books";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_getBookById)){
            while(resultSet.next()){
                Book book = convertRowToBook(resultSet);
                if(book.getId() == id){
                    return book;
                }
            }
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
        return null;
    }

    private Book convertRowToBook(ResultSet resultSet)throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Book(id, name);

    }
}
