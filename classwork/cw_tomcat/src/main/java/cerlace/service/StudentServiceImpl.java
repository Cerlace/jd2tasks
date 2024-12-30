package cerlace.service;

import cerlace.dto.StudentDTO;
import cerlace.entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private static final List<StudentEntity> studentRepository = List.of(
            StudentEntity.builder().id("1").name("Vasya").age("25")
                    .address("Minsk").mark("8").build(),
            StudentEntity.builder().id("2").name("Vasya").age("25")
                    .address("Paris").mark("4").build(),
            StudentEntity.builder().id("3").name("Petya").age("21")
                    .address("Minsk").mark("5").build(),
            StudentEntity.builder().id("4").name("Kolya").age("20")
                    .address("Paris").mark("9").build()
    );

    @Override
    public List<StudentDTO> findAll(String name, String age) {
        return studentRepository.stream()
                .filter(studentEntity -> studentEntity.getName().equals(name) &&
                        studentEntity.getAge().equals(age))
                .map(studentEntity -> StudentDTO.builder()
                        .id(studentEntity.getId())
                        .name(studentEntity.getName())
                        .age(studentEntity.getAge())
                        .address(studentEntity.getAddress())
                        .mark(studentEntity.getMark())
                        .build())
                .collect(Collectors.toList());
    }
}
