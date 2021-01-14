package com.appjavatest.apptest.repository;

import com.appjavatest.apptest.model.CurrencyPrivatBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CurrencyPrivatBankRepository extends JpaRepository<CurrencyPrivatBank, Long> {

        List<CurrencyPrivatBank> findAllByDateBetween(
                LocalDate dateStart,
                LocalDate dateEnd);

        List<Object> findTop3ByOrderByIdDesc();

}
