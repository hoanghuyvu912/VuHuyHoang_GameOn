package com.nonIt.GameOn.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class GenreRepositoryTest {
    @Autowired
    private GenreRepository genreRepository;
    @Test
    void WhenGetAll_ThenReturnGenreList() {
        System.out.println(genreRepository.findAll());
    }
}