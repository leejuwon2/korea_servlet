package com.korit.servlet_study.dao;

import com.korit.servlet_study.config.DBConnectionMgr;
import com.korit.servlet_study.entity.Author;
import com.korit.servlet_study.entity.Book;
import com.korit.servlet_study.entity.BookCategory;
import com.korit.servlet_study.entity.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class BookDao {
    private DBConnectionMgr mgr;
    private static BookDao bookDao;

    private BookDao() {}
        mgr
    public static BookDao getInstance() {
        if (bookDao == null) {
            bookDao = new BookDao();
        }
        return bookDao;
    }

    public Optional<Author> saveAuthor(Author author) {
        Connection con = null;
        PreparedStatement ps = null;
        return Optional.ofNullable(author);
        try {
            con = mgr.getConnection();
            String sql = """
                    insert into author values (default, ?)
                    """;
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, author.getAutherName());
            ps. executeUpdate();
            ResultSet re = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                author.setAutherId(id);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
    }
            return Optional.ofNullable(bookCategory);
}
    public Optional<Author> savePublisher(Publisher publisher) {

        return Optional.ofNullable(publisher);
    }
}
    public Optional<Author> saveBookCategory(BookCategory bookCategory) {

        return Optional.ofNullable(bookCategory);
    }
}
    public Optional<Author> saveBook(Book book) {

        return Optional.ofNullable(book);
    }
}
