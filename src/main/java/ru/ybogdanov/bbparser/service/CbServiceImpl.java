package ru.ybogdanov.bbparser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ybogdanov.bbparser.domain.MoneyData;
import ru.ybogdanov.bbparser.interfaces.MoneyDataService;
import ru.ybogdanov.bbparser.repository.MoneyDataRepository;
import ru.ybogdanov.bbparser.service.parser.CbParserServiceImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CbServiceImpl implements MoneyDataService {
    private final MoneyDataRepository moneyDataRepository;
    private final CbParserServiceImpl cbParserService;

    @Override
    public List<MoneyData> getMoneyData() {
        return moneyDataRepository.findAll();
    }

    @Override
    public void refresh() {
        cbParserService.parse();
    }

    @Override
    public void add(MoneyData moneyData) {
        moneyDataRepository.save(moneyData);
    }
}
