package ru.ybogdanov.bbparser.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ybogdanov.bbparser.domain.MoneyData;
import ru.ybogdanov.bbparser.interfaces.MoneyDataService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/money")
public class MoneyController {
    private final MoneyDataService moneyDataService;

    @GetMapping
    @RequestMapping("/refresh")
    public List<MoneyData> refresh() {
        moneyDataService.refresh();
        return moneyDataService.getMoneyData();
    }
}
