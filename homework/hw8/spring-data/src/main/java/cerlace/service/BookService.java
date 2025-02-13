package cerlace.service;

import cerlace.model.Book;

import java.util.List;

public interface BookService {
    boolean checkUniqueAndSave(Book book);
    List<Book> findByTitleContaining(String title);
}
