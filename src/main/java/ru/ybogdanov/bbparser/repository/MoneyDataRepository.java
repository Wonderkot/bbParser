package ru.ybogdanov.bbparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ybogdanov.bbparser.domain.MoneyData;

@Repository
public interface MoneyDataRepository extends JpaRepository<MoneyData, Long> {
}
