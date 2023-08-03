package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class GameServiceImplMockitoTest {
    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private GameServiceImpl gameService;

    @BeforeEach
    void setUp() {


    }

}
