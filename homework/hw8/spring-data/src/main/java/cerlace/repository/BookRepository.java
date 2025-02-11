package cerlace.repository;

import cerlace.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
    List<Book> findByTitleContaining(String title);
}
