package cerlace.service;

import cerlace.model.Reader;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ReaderService {
    void save(Reader reader);
    Reader findByEmail(String email);
    Page<Reader> findAllAndSortByRegistrationDate(int pageNo, int pageSize);
}
