package ru.ybogdanov.bbparser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ybogdanov.bbparser.interfaces.ParserService;
import ru.ybogdanov.bbparser.repository.MoneyDataRepository;
import ru.ybogdanov.bbparser.service.parser.CbParserServiceImpl;

@SpringBootTest
class BbParserServiceImplTest {
    @Qualifier("bbParserServiceImpl")
    @Autowired
    private ParserService parserService;

    @Autowired
    private MoneyDataRepository moneyDataRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void bBParse() {
        parserService.parse();
    }

    @Test
    void cBParse() {
        parserService = new CbParserServiceImpl(moneyDataRepository);
        parserService.parse();
    }
}