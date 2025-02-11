package cerlace.repository;

import cerlace.model.Reader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends PagingAndSortingRepository<Reader, Long> {
    Optional<Reader> findByEmail(String email);
}