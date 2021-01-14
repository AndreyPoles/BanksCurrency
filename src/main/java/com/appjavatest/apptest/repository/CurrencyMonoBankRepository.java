package com.appjavatest.apptest.repository;

import com.appjavatest.apptest.model.CurrencyMonoBank;
import com.appjavatest.apptest.model.CurrencyPrivatBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
    public interface CurrencyMonoBankRepository extends JpaRepository<CurrencyMonoBank, Long> {

    List<CurrencyMonoBank> findAllByDateBetween(
            LocalDate dateStart,
            LocalDate dateEnd);

    List<Object> findTop3ByOrderByIdDesc();

    }
