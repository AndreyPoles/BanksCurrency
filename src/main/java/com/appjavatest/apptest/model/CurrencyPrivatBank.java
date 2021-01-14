package com.appjavatest.apptest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "currency_privat_bank")
public class CurrencyPrivatBank{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "name_bank")
    private String bank;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "ccy")
    private String ccy;

    @Column(name = "base_ccy")
    private String base_ccy;

    @Column(name = "buy")
    private Double buy;

    @Column(name = "average_value")
    private Double average_value;

    @Column(name = "sale")
    private Double sale;

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getAverage_value() {
        return average_value;
    }

    public void setAverage_value(Double average_value) {
        this.average_value = average_value;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "CurrencyPrivatBank{" +
                "date=" + date +
                ", ccy='" + ccy + '\'' +
                ", average_value=" + average_value +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
