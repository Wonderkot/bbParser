package ru.ybogdanov.bbparser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ybogdanov.bbparser.domain.MoneyData;
import ru.ybogdanov.bbparser.interfaces.MoneyDataService;
import ru.ybogdanov.bbparser.repository.MoneyDataRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BbServiceImpl implements MoneyDataService {
    private final MoneyDataRepository moneyDataRepository;
    private final BbParserServiceImpl bbParserService;
    @Override
    public List<MoneyData> getMoneyData() {
        return moneyDataRepository.findAll();
    }

    @Override
    public void refresh() {
        bbParserService.parse();
    }

    @Override
    public void add(MoneyData moneyData) {
        moneyDataRepository.save(moneyData);
    }
}
