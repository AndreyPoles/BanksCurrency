package com.appjavatest.apptest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

public class CurrencyBankGet {

    private String bank_name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String currency;

    private Double average_value;


//    public CurrencyBankGet(long id, String bank_name, LocalDate date, String currency, Double buy, Double sale) {
//        this.id = id;
//        this.bank_name = bank_name;
//        this.date = date;
//        this.currency = currency;
//        this.buy = buy;
//        this.sale = sale;
//    }


    public Double getAverage_value() {
        return average_value;
    }

    public void setAverage_value(Double average_value) {
        this.average_value = average_value;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
