package com.appjavatest.apptest.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "currency_mono_bank")
public class CurrencyMonoBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "name_bank")
    private String bank;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "ccy")
    private String ccy;

    @Column(name = "buy")
    private Double bay;

    @Column(name = "average_value")
    private Double average_value;

    @Column(name = "sale")
    private Double rateSell;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAverage_value() {
        return average_value;
    }

    public void setAverage_value(Double average_value) {
        this.average_value = average_value;
    }

    public String getCurrencyCodeB() {
        return ccy;
    }

    public void setCurrencyCodeB(String currencyCodeB) {
        this.ccy = currencyCodeB;
    }

    public Double getRateBuy() {
        return bay;
    }

    public void setRateBuy(Double rateBuy) {
        this.bay = rateBuy;
    }

    public Double getRateSell() {
        return rateSell;
    }

    public void setRateSell(Double rateSell) {
        this.rateSell = rateSell;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}

