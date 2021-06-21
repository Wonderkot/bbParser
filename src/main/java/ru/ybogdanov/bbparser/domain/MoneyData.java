package ru.ybogdanov.bbparser.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ybogdanov.bbparser.enums.Bank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "MoneyData")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class MoneyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal currency;
    private LocalDateTime date;
    private Bank bank;
}
