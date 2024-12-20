package cerlace.service;

import cerlace.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll(String name, String age);
}
