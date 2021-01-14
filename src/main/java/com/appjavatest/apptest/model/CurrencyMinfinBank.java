package com.appjavatest.apptest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "currency_minfin_bank")
public class CurrencyMinfinBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "name_bank")
    private String bank;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "ccy")
    private String currency;

    @Column(name = "buy")
    private Double bid;

    @Column(name = "average_value")
    private Double average_value;

    @Column(name = "sale")
    private Double ask;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "CurrencyMinfinBank{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", bid=" + bid +
                ", average_value=" + average_value +
                ", ask=" + ask +
                '}';
    }
}
