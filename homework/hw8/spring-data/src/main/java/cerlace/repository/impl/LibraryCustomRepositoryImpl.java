package cerlace.repository.impl;

import cerlace.model.Reader;
import cerlace.repository.LibraryCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LibraryCustomRepositoryImpl implements LibraryCustomRepository {
    public static final String FIND_READERS_BY_AUTHOR_QUERY =
            "SELECT DISTINCT r FROM Reader r JOIN r.books b WHERE b.author.name = :authorName";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reader> findReadersByAuthorName(String authorName) {
        return entityManager
                .createQuery(FIND_READERS_BY_AUTHOR_QUERY, Reader.class)
                .setParameter("authorName", authorName)
                .getResultList();
    }
}