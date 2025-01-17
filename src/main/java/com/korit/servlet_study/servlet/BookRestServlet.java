package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.entity.Author;
import com.korit.servlet_study.entity.Book;
import com.korit.servlet_study.entity.BookCategory;
import com.korit.servlet_study.entity.Publisher;
import com.korit.servlet_study.server_flow.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.io.IOException;
import java.util.Locale;

@WebServlet
public class BookRestServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Author author = new Author(1, "이주원");
        Publisher publisher = new Publisher(1, "코리아아카데미");
        BookCategory bookCategory = new BookCategory(1,"소설");

        Book book = Book.builder()
                .bookId(123)
                .bookName("오렌지나무")
                .bookImgUrl("test@naver.com")
                .build();

        String jsonBook = objectMapper.writeValueAsString(book);
        System.out.println(jsonBook);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "Get, Post, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "true");

        response.setContentType("application/json");
        response.getWriter().println(jsonBook);

    }
}
