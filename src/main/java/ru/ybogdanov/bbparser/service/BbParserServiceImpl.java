package ru.ybogdanov.bbparser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ybogdanov.bbparser.domain.MoneyData;
import ru.ybogdanov.bbparser.enums.Bank;
import ru.ybogdanov.bbparser.interfaces.BbParserService;
import ru.ybogdanov.bbparser.repository.MoneyDataRepository;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

import org.json.JSONObject;

@RequiredArgsConstructor
@Service
public class BbParserServiceImpl implements BbParserService {

    public static final String GET_URL = "https://www.bystrobank.ru/sitecurrency/data/CurrentExchangeRates_izhevsk.js";
    private final MoneyDataRepository moneyDataRepository;

    @Override
    public void parse() {
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(
                    URI.create(GET_URL))
                    .header("accept", "application/json")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());
            BigDecimal buy =  json.getJSONArray("banks").getJSONObject(0).getJSONObject("usd").getBigDecimal("buy");
            MoneyData moneyData = new MoneyData();
            moneyData.setCurrency(buy);
            moneyData.setDate(LocalDateTime.now());
            moneyData.setBank(Bank.BYSTRO_BANK);
            moneyDataRepository.save(moneyData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
