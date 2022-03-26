package com.project.minibacktesting_be.backtesting;

import com.project.minibacktesting_be.dto.backtesting.BacktestingDataDto;
import com.project.minibacktesting_be.model.Stock;
import com.project.minibacktesting_be.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EachStockCal {

    private final StockRepository stockRepository;

    public List<BacktestingDataDto> getStockCalResult(LocalDate startDate,
                              LocalDate endDate,
                              List<String> stockList,
                              List<YearMonth> yearMonthList,
                              List<Double> targetPrices,
                             List<String> stockCodes,
                             List<Double> buyMoney) {
        List<BacktestingDataDto> backtestingDataDtos= new ArrayList<>();
        for(String targetStockName : stockList){

            // 타겟 주식이 몇번째 값?
            int Idx = stockList.indexOf(targetStockName);

            // 타겟 주식의 정보 가져오기
            List<Stock> stocks =
                    stockRepository.findByStockNameAndCloseDateBetweenOrderByCloseDate(
                            targetStockName, startDate, endDate);

            // 주식 코드 가져오기
            stockCodes.add(stocks.get(0).getStockCode());

            // 주식 목표 금액
            Double targetPrice = targetPrices.get(Idx);
            buyMoney.add(targetPrice);

            // 주식 목표 금액에 맞추기 위해 필요한 주식 수
            Long firstMonthPrice = stocks.get(0).getClose();
            Double stockNum = targetPrice / firstMonthPrice;


            // 스트림을 활용해서 stock의 종가만 얻어냄
            List<Long> stockPrices =  stocks.
                    stream().
                    map(Stock::getClose).
                    collect(Collectors.toList());


            // 스트림 : 날짜만 뽑아내기 (yearMonth로 변환)
            List<YearMonth> months = stocks.
                    stream().
                    map(Stock::getCloseDate).
                    map(d -> YearMonth.from(d)).
                    collect(Collectors.toList());


            // 리스트 갯수를 맞춰야 한다. (데이터 수가 다 같지 않으므로)
            Double[] yieldMoneys = new Double[yearMonthList.size()];

            for(int i = 0; i < yearMonthList.size(); i++){

                YearMonth targetYearMonth = yearMonthList.get(i);
                if(months.contains(targetYearMonth)){
                    yieldMoneys[i] =
                            stockPrices.get(months.indexOf(targetYearMonth))*stockNum;
                }else{
                    yieldMoneys[i] =stockPrices.get(0)*stockNum;
                }
            }

            // 스트림 : 날짜만 뽑아내기 (yearMonth로 변환)
            List<Double> yields = stocks.
                    stream().
                    map(Stock::getYieldPct).
                    collect(Collectors.toList());


            // 해당 종목의 backtest 내용 저장하기
            BacktestingDataDto backtestingDataDto =
                    new BacktestingDataDto(targetStockName, targetPrice,
                            stockNum, months, stockPrices,
                            Arrays.asList(yieldMoneys), yields);

            backtestingDataDtos.add(backtestingDataDto);

        }
        return backtestingDataDtos;
    }
}
