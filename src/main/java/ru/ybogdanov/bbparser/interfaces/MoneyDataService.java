package ru.ybogdanov.bbparser.interfaces;

import ru.ybogdanov.bbparser.domain.MoneyData;

import java.util.List;

public interface MoneyDataService {
    List<MoneyData> getMoneyData();
    void refresh();
    void add(MoneyData moneyData);
}
