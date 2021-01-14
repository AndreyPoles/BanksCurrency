package com.appjavatest.apptest.controller;

import com.appjavatest.apptest.model.CurrencyBankGet;
import com.appjavatest.apptest.model.CurrencyMinfinBank;
import com.appjavatest.apptest.model.CurrencyMonoBank;
import com.appjavatest.apptest.model.CurrencyPrivatBank;
import com.appjavatest.apptest.repository.CurrencyMinfinBankRepository;
import com.appjavatest.apptest.repository.CurrencyMonoBankRepository;
import com.appjavatest.apptest.repository.CurrencyPrivatBankRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "Banks API")
public class CurrencyController {

    @Autowired
    private CurrencyPrivatBankRepository currencyPrivatBankRepository;

    @Autowired
    private CurrencyMonoBankRepository currencyMonoBankRepository;

    @Autowired
    private CurrencyMinfinBankRepository currencyMinfinBankRepository;

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "Get currents")
    @Cacheable("banks")
    @GetMapping("/tablejson")
    public List<Object> getTablejson() {

        List<Object> currencyPrivatBankList1 = currencyPrivatBankRepository.findTop3ByOrderByIdDesc();
        List<Object> currencyMonoBanksList1 = currencyMonoBankRepository.findTop3ByOrderByIdDesc();
        List<Object> currencyMinfinBankList1 = currencyMinfinBankRepository.findTop3ByOrderByIdDesc();

        List<Object> lists = new ArrayList<>();

        for (int i = 0; i < currencyPrivatBankList1.size(); i++) {
            lists.add(currencyPrivatBankList1.get(i));
        }

        for (int i = 0; i < currencyMonoBanksList1.size(); i++) {
            lists.add(currencyMonoBanksList1.get(i));
        }

        for (int i = 0; i < currencyMinfinBankList1.size(); i++) {
            lists.add(currencyMinfinBankList1.get(i));
        }

        return lists;
    }

    @ApiOperation(value = "Get currents between dates")
    @Cacheable("banks")
    @GetMapping("/tablejsons/{dataStartYear}-{dataStartMounth}-{dataStartDay}/between/{dataEndYear}-{dataEndMounth}-{dataEndDay}")
    public List<Object> getTablejsonPost(@PathVariable(value = "dataStartYear") Integer dataStartYear,
                                         @PathVariable(value = "dataStartMounth") Integer dataStartMounth,
                                         @PathVariable(value = "dataStartDay") Integer dataStartDay,
                                         @PathVariable(value = "dataEndYear") Integer dataEndYear,
                                         @PathVariable(value = "dataEndMounth") Integer dataEndMounth,
                                         @PathVariable(value = "dataEndDay") Integer dataEndDay) {

        List<CurrencyPrivatBank> currencyPrivatBankList = currencyPrivatBankRepository.findAllByDateBetween(LocalDate.of(dataStartYear, dataStartMounth, dataStartDay), LocalDate.of(dataEndYear, dataEndMounth, dataEndDay));
        List<CurrencyMonoBank> currencyMonoBankList = currencyMonoBankRepository.findAllByDateBetween(LocalDate.of(dataStartYear, dataStartMounth, dataStartDay), LocalDate.of(dataEndYear, dataEndMounth, dataEndDay));
        List<CurrencyMinfinBank> currencyMinfinBankList = currencyMinfinBankRepository.findAllByDateBetween(LocalDate.of(dataStartYear, dataStartMounth, dataStartDay), LocalDate.of(dataEndYear, dataEndMounth, dataEndDay));

        List<Object> lists = new ArrayList<>();


        for (int i = 0; i < currencyPrivatBankList.size(); i++) {
            if (currencyPrivatBankList.size() != 0) {
                CurrencyBankGet currencyBankGet = new CurrencyBankGet();
                currencyBankGet.setBank_name(currencyPrivatBankList.get(i).getBank());
                currencyBankGet.setCurrency(currencyPrivatBankList.get(i).getCcy());
                currencyBankGet.setDate(currencyPrivatBankList.get(i).getDate());
                currencyBankGet.setAverage_value(currencyPrivatBankList.get(i).getAverage_value());
                lists.add(currencyBankGet);
            }
            if (currencyMinfinBankList.size() != 0) {
                CurrencyBankGet currencyBankGet = new CurrencyBankGet();
                currencyBankGet.setBank_name(currencyMinfinBankList.get(i).getBank());
                currencyBankGet.setCurrency(currencyMinfinBankList.get(i).getCurrency());
                currencyBankGet.setDate(currencyMinfinBankList.get(i).getDate());
                currencyBankGet.setAverage_value(currencyMinfinBankList.get(i).getAverage_value());
                lists.add(currencyBankGet);
            }
            if (currencyMonoBankList.size() != 0) {
                CurrencyBankGet currencyBankGet = new CurrencyBankGet();
                currencyBankGet.setBank_name(currencyMonoBankList.get(i).getBank());
                currencyBankGet.setCurrency(currencyMonoBankList.get(i).getCurrencyCodeB());
                currencyBankGet.setDate(currencyMonoBankList.get(i).getDate());
                currencyBankGet.setAverage_value(currencyMonoBankList.get(i).getAverage_value());
                lists.add(currencyBankGet);
            }
        }

        return lists;
    }

}
