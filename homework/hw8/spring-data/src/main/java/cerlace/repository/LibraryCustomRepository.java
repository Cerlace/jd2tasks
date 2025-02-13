package cerlace.repository;

import cerlace.model.Reader;

import java.util.List;

public interface LibraryCustomRepository {
    List<Reader> findReadersByAuthorName(String authorName);
}
