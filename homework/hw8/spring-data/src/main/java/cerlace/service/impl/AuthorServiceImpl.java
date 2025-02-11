package cerlace.service.impl;

import cerlace.model.Author;
import cerlace.repository.AuthorRepository;
import cerlace.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public void save(Author author) {
        repository.save(author);
    }
    public List<Author> findByNationality(String nationality) {
        return repository.findByNationality(nationality);
    }
}
