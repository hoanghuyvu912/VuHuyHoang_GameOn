package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;

import com.nonIt.GameOn.exception.ResponseException;
import com.nonIt.GameOn.repository.*;

import com.nonIt.GameOn.service.createdto.GameDto;

import com.nonIt.GameOn.service.restdto.GameRestDto;
import org.junit.jupiter.api.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class GameServiceImplTest {
    @Autowired
    private GameServiceImpl gameService;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private GameRepository gameRepository;

    public GameDto createGameDto(){
        LocalDate releasedDate = LocalDate.parse("2023-06-25");
        GameDto gameDto = GameDto.builder()
                .developerId(1)
                .publisherId(1)
                .description("His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.")
                .name("God of War (2018)")
                .price(19.99)
                .trailer("https://www.youtube.com/watch?v=76O5KaJHEA0")
                .releasedDate(releasedDate)
                .systemReq("MINIMUM:\n" +
                        "Requires a 64-bit processor and operating system\n" +
                        "OS: WINDOWS® 7, 8, 8.1, 10 (64-bit required)\n" +
                        "Processor: Intel® Core™ i5 4460 or Core™ i3 9100F or AMD FX™-6300 or Ryzen™ 3 3200G\n" +
                        "Memory: 8 GB RAM\n" +
                        "Graphics: NVIDIA®GeForce®GTX 760 or GTX1050 or AMD Radeon™ R7 260x or RX 560\n" +
                        "DirectX: Version 11\n" +
                        "Network: Broadband Internet connection\n" +
                        "Storage: 52 GB available space\n" +
                        "Sound Card: DirectSound (DirectX® 9.0c or later)\n" +
                        "Additional Notes: - These specs allow for the game to be played in 1080p/30fps with graphics settings at \"Low\". - 64-bit processor and operating system are required.")
                .thumbnail("https://cdn.cloudflare.steamstatic.com/steam/apps/1151640/header.jpg?t=1667297464")
                .build();

        return gameDto;
    }
    @Test
    void Should_ReturnGameList_When_GetAll(){

        assertTrue(gameService.getAll().size() > 0);

    }
    @Test
    @DisplayName("Test createGame Success")
    void When_CreateNewGame_Expect_GameListSizeIncrease1(){

        int gameListSizeBefore = gameService.getAll().size();

        GameDto newGameDto = createGameDto();

        GameRestDto newGameRestDto = gameService.createGame(newGameDto);

        int gameListSizeAfter = gameService.getAll().size();

        assertEquals(1, gameListSizeAfter - gameListSizeBefore);

    }

    @Test
    @DisplayName("Test createGame Throw Exception")
    void Should_ThrowException_When_GetInvalidDeveloperId() {
        LocalDate releasedDate = LocalDate.parse("2023-06-25");
        int invalidDeveloperId = gameService.getAll().size() + 1;

        GameDto newGame = GameDto.builder()
                .developerId(invalidDeveloperId)
                .publisherId(1)
                .description("His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.")
                .name("God of War (2018)")
                .price(19.99)
                .trailer("https://www.youtube.com/watch?v=76O5KaJHEA0")
                .releasedDate(releasedDate)
                .systemReq("MINIMUM:\n" +
                        "Requires a 64-bit processor and operating system\n" +
                        "OS: WINDOWS® 7, 8, 8.1, 10 (64-bit required)\n" +
                        "Processor: Intel® Core™ i5 4460 or Core™ i3 9100F or AMD FX™-6300 or Ryzen™ 3 3200G\n" +
                        "Memory: 8 GB RAM\n" +
                        "Graphics: NVIDIA®GeForce®GTX 760 or GTX1050 or AMD Radeon™ R7 260x or RX 560\n" +
                        "DirectX: Version 11\n" +
                        "Network: Broadband Internet connection\n" +
                        "Storage: 52 GB available space\n" +
                        "Sound Card: DirectSound (DirectX® 9.0c or later)\n" +
                        "Additional Notes: - These specs allow for the game to be played in 1080p/30fps with graphics settings at \"Low\". - 64-bit processor and operating system are required.")
                .thumbnail("https://cdn.cloudflare.steamstatic.com/steam/apps/1151640/header.jpg?t=1667297464")
                .build();

        ResponseException thrown = Assertions.assertThrows(ResponseException.class, () -> {
            gameService.createGame(newGame);
        });
    }
    @Test
    @DisplayName("Test updateGame Success")
    void Should_ReturnUpdatedGame_When_UpdateAGame(){
        Optional<Game> initialGame = gameRepository.findById(1);
        assertTrue(initialGame.isPresent());

        GameDto updateInitialGameDto = GameDto.builder()
                .name("Spiderman")
                .build();

        gameService.updateGame(1,updateInitialGameDto);

        Optional<Game> updatedGame = gameRepository.findById(1);
        assertTrue(updatedGame.isPresent());

        assertEquals(updateInitialGameDto.getName(),updatedGame.get().getName());
    }

    @Test
    @DisplayName("Test deleteGame Success")
    void Should_DeleteGame_When_GameIsDeleted() {
        //create new game
        GameDto newGameDto = createGameDto();
        gameService.createGame(newGameDto);

        //test
        int newGameId = gameRepository.findAll().size() - 1;
        gameService.deleteGame(newGameId);

        boolean gameExists = gameRepository.existsById(newGameId);

        assertFalse(gameExists,"Game should be deleted");
    }

}