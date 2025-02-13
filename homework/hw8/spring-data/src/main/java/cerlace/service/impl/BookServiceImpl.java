package cerlace.service.impl;

import cerlace.model.Book;
import cerlace.repository.BookRepository;
import cerlace.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    @Transactional
    public boolean checkUniqueAndSave(Book book) {
        if (repository.existsByIsbn(book.getIsbn())) {
            return false;
        } else {
            repository.save(book);
            return true;
        }
    }

    @Override
    public List<Book> findByTitleContaining(String title) {
        return repository.findByTitleContaining(title);
    }
}
