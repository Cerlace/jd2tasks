package cerlace.service.impl;

import cerlace.model.Reader;
import cerlace.model.Reader_;
import cerlace.repository.ReaderRepository;
import cerlace.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository repository;

    @Override
    public void save(Reader reader) {
        repository.save(reader);
    }

    @Override
    public Reader findByEmail(String email) {
        return repository
                .findByEmail(email)
                .orElse(null);
    }

    @Override
    public Page<Reader> findAllAndSortByRegistrationDate(int pageNo, int pageSize) {
        return repository.findAll(
                PageRequest.of(pageNo, pageSize, Sort.by(Reader_.REGISTRATION_DATE)));
    }
}
