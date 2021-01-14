package com.appjavatest.apptest.servise;


import com.appjavatest.apptest.model.CurrencyMinfinBank;
import com.appjavatest.apptest.model.CurrencyMonoBank;
import com.appjavatest.apptest.model.CurrencyPrivatBank;
import com.appjavatest.apptest.repository.CurrencyMinfinBankRepository;
import com.appjavatest.apptest.repository.CurrencyMonoBankRepository;
import com.appjavatest.apptest.repository.CurrencyPrivatBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Service
public class CronJobService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyPrivatBankRepository currencyPrivatBankRepository;

    @Autowired
    private CurrencyMonoBankRepository currencyMonoBankRepository;

    @Autowired
    private CurrencyMinfinBankRepository currencyMinfinBankRepository;

    @Scheduled(fixedRate = 86400000)
    public void getTablejson() {

        String urlprivat = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        CurrencyPrivatBank[] currencyPrivatBank = restTemplate.getForObject(urlprivat, CurrencyPrivatBank[].class);

//        String urlminfin = "https://api.minfin.com.ua/mb/latest/e7c1397b85b0c84d4832a293495f62b1d39d5c0c/?currency=[currency-code]";
//        CurrencyMinfinBank[] currencyMinfinBanks = restTemplate.getForObject(urlminfin, CurrencyMinfinBank[].class);

        String urlmono = "https://api.monobank.ua/bank/currency";
        CurrencyMonoBank[] currencyMonoBank = restTemplate.getForObject(urlmono, CurrencyMonoBank[].class);

        if (currencyPrivatBank.length != 0) {
            for (int i = 0; i < 3; i++) {

                currencyPrivatBank[i].setDate(LocalDate.now());

                currencyPrivatBank[i].setBank("PrivatBank");

                currencyPrivatBank[i].setAverage_value((currencyPrivatBank[i].getBuy() + currencyPrivatBank[i].getSale()) / 2);

                createTableCurrencyPrivatBank(currencyPrivatBank[i]);

            }
        }

        if (currencyMonoBank.length != 0) {
            for (int i = 0; i < 3; i++) {

                currencyMonoBank[i].setDate(LocalDate.now());

                currencyMonoBank[i].setBank("MonoBank");

                if
                (i == 0) {
                    currencyMonoBank[i].setCurrencyCodeB("USD");
                } else if
                (i == 1) {
                    currencyMonoBank[i].setCurrencyCodeB("EUR");
                } else if
                (i == 2) {
                    currencyMonoBank[i].setCurrencyCodeB("RUR");
                }

                currencyMonoBank[i].setAverage_value((currencyMonoBank[i].getRateBuy() + currencyMonoBank[i].getRateSell()) / 2);

                createTableCurrencyMonoBank(currencyMonoBank[i]);

            }
        }

//        if (currencyMinfinBanks.length != 0) {
//            for (int i = 0; i < 3; i++) {
//
//                currencyMinfinBanks[i].setDate(LocalDate.now());
//
//                  currencyMinfinBanks[i].setBank("MinfinBank");
//
//                currencyMinfinBanks[i].setAverage_value((currencyMinfinBanks[i].getBid() + currencyMinfinBanks[i].getAsk()) / 2);
//
//                createTableCurrencyMinfinBank(currencyMinfinBanks[i]);
//
//            }
//        }

        System.out.println(Arrays.asList(currencyPrivatBank));
        System.out.println(Arrays.asList(currencyMonoBank));
//        System.out.println(Arrays.asList(currencyMinfinBanks));


    }

    public CurrencyPrivatBank createTableCurrencyPrivatBank(CurrencyPrivatBank currencyPrivatBank) {
        return this.currencyPrivatBankRepository.save(currencyPrivatBank);
    }

    public CurrencyMinfinBank createTableCurrencyMinfinBank(CurrencyMinfinBank currencyMinfinBank) {
        return this.currencyMinfinBankRepository.save(currencyMinfinBank);
    }

    public CurrencyMonoBank createTableCurrencyMonoBank(CurrencyMonoBank currencyMonoBank) {
        return this.currencyMonoBankRepository.save(currencyMonoBank);
    }

}