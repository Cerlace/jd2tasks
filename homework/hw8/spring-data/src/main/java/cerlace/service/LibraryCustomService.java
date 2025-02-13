package cerlace.service;

import cerlace.model.Reader;

import java.util.List;

public interface LibraryCustomService {
    List<Reader> findReadersByAuthorName(String authorName);
}
