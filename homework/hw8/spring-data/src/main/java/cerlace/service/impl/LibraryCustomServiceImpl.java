package cerlace.service.impl;

import cerlace.model.Reader;
import cerlace.repository.LibraryCustomRepository;
import cerlace.service.LibraryCustomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryCustomServiceImpl implements LibraryCustomService {

    private final LibraryCustomRepository repository;

    @Override
    public List<Reader> findReadersByAuthorName(String authorName) {
        return repository.findReadersByAuthorName(authorName);
    }
}
