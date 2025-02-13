package cerlace.service;

import cerlace.model.Author;

import java.util.List;

public interface AuthorService {
    void save(Author author);
    List<Author> findByNationality(String nationality);
}
