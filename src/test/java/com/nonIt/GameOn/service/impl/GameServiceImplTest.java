package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.repository.*;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.createdto.GameDto;
import com.nonIt.GameOn.service.mapper.CommentMapper;
import com.nonIt.GameOn.service.mapper.GameMapper;
import com.nonIt.GameOn.service.mapper.RatingMapper;
import com.nonIt.GameOn.service.restdto.GameRestDto;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class GameServiceImplTest {
    @Mock
    private GameRepository gameRepository;
//    private  DeveloperRepository developerRepository;
//    private  PublisherRepository publisherRepository;
//    private  RatingRepository ratingRepository;
//    private  GameMapper gameMapper;
//    private  RatingMapper ratingMapper;
//    private  CommentMapper commentMapper;
//    private  GameCodeRepository gameCodeRepository;
//    private  UserRepository userRepository;

    @InjectMocks
    private GameServiceImpl gameService;
    @BeforeEach
    void setUp() {
        LocalDate releasedDate = LocalDate.parse("2023-06-25");
        LocalDate establishedDate = LocalDate.parse("2023-06-21");

        Publisher publisher = Publisher.builder()
                .coverPhoto("https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/40425349/c263d17394502cedbf90373599eb2706ca84074d.png")
                .description("PlayStation Studios is home to the development of Sony Interactive Entertainment’s own outstanding and immersive games, including some of the most popular and critically acclaimed titles in entertainment history.")
                .establishedDate(establishedDate)
                .name("Sony Interactive Entertainment")
                .thumbnail("https://avatars.cloudflare.steamstatic.com/40a85b52747a78b26e393e3f9e58f319194b1b33_full.jpg")
                .build();

        Developer developer = Developer.builder()
                .coverPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnDTkdA38Qi_7RLtj2283fRSJxLHxvX6FdZg&usqp=CAU")
                .description("Ubisoft is a creator of worlds, committed to enriching players' lives with original and memorable gaming experiences.")
                .establishedDate(establishedDate)
                .name("Ubisoft")
                .thumbnail("https://avatars.cloudflare.steamstatic.com/2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg")
                .build();

        Game game = Game.builder()
                .developer(developer)
                .publisher(publisher)
                .description("His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.")
                .name("God of War (2018)")
                .price(19.99D)
                .trailer("https://www.youtube.com/watch?v=76O5KaJHEA0")
                .releasedDate(releasedDate)
                .thumbnail("https://cdn.cloudflare.steamstatic.com/steam/apps/1151640/header.jpg?t=1667297464")
                .build();
        List<Game> games = new ArrayList<>();
        games.add(game);
        Mockito.when(gameRepository.findAll()).thenReturn(games);
    }
    @Test
    void whenGetAll_thenReturnGameList(){

        System.out.println(gameService.getAll());

    }
//    @BeforeAll
//    public static void setUpDeveloperAndPublished(){
//        LocalDate establishedDate = LocalDate.parse("2023-06-21");
//
//        Publisher publisher = Publisher.builder()
//                .coverPhoto("https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/40425349/c263d17394502cedbf90373599eb2706ca84074d.png")
//                .description("PlayStation Studios is home to the development of Sony Interactive Entertainment’s own outstanding and immersive games, including some of the most popular and critically acclaimed titles in entertainment history.")
//                .establishedDate(establishedDate)
//                .name("Sony Interactive Entertainment")
//                .thumbnail("https://avatars.cloudflare.steamstatic.com/40a85b52747a78b26e393e3f9e58f319194b1b33_full.jpg")
//                .build();
//
//        Developer developer = Developer.builder()
//                .coverPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnDTkdA38Qi_7RLtj2283fRSJxLHxvX6FdZg&usqp=CAU")
//                .description("Ubisoft is a creator of worlds, committed to enriching players' lives with original and memorable gaming experiences.")
//                .establishedDate(establishedDate)
//                .name("Ubisoft")
//                .thumbnail("https://avatars.cloudflare.steamstatic.com/2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg")
//                .build();
//    }
//    @Test
//    void createGame() {
//        LocalDate releasedDate = LocalDate.parse("2023-06-25");
//        GameDto gameDto = GameDto.builder()
//                .developerId(1)
//                .publisherId(1)
//                .description("His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.")
//                .name("God of War (2018)")
//                .price(19.99D)
//                .trailer("https://www.youtube.com/watch?v=76O5KaJHEA0")
//                .releasedDate(releasedDate)
//                .thumbnail("https://cdn.cloudflare.steamstatic.com/steam/apps/1151640/header.jpg?t=1667297464")
//                .build();
//
//        GameRestDto gameRestDto = gameService.createGame(gameDto);
//
//        assertEquals(gameRestDto.getName(), gameDto.getName());
//    }
//    @Test
//    void whenGetAll_ShouldReturnList(){
//        assertTrue(gameService.getAll().size() > 0);
//    }
}