package com.appjavatest.apptest.repository;

import com.appjavatest.apptest.model.CurrencyMinfinBank;
import com.appjavatest.apptest.model.CurrencyPrivatBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CurrencyMinfinBankRepository extends JpaRepository<CurrencyMinfinBank, Long> {

    List<CurrencyMinfinBank> findAllByDateBetween(
            LocalDate dateStart,
            LocalDate dateEnd);

    List<Object> findTop3ByOrderByIdDesc();

}

