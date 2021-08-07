package ru.ybogdanov.bbparser.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ybogdanov.bbparser.domain.MoneyData;
import ru.ybogdanov.bbparser.interfaces.MoneyDataService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/money")
public class MoneyController {
    private final List<MoneyDataService> moneyDataServices;

    @GetMapping
    @RequestMapping("/refresh")
    public List<MoneyData> refresh() {
        List<MoneyData> res = new ArrayList<>();
        moneyDataServices.forEach(s -> {
            s.refresh();
            res.addAll(s.getMoneyData());
        });

        return res;
    }
}
