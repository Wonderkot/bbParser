package ru.ybogdanov.bbparser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ybogdanov.bbparser.interfaces.BbParserService;

@SpringBootTest
class BbParserServiceImplTest {
    @Autowired
    private BbParserService parserService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void parse() {
        parserService.parse();
    }
}