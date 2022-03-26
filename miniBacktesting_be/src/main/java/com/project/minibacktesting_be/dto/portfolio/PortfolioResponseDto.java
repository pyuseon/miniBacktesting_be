package com.project.minibacktesting_be.dto.portfolio;

import com.project.minibacktesting_be.dto.backtesting.BacktestingResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PortfolioResponseDto {

    private Long portId;
    private boolean myBest;
    private BacktestingResponseDto portBacktestingCal;

//    @JsonSerialize(using =  YearMonthSerializer.class)
//    @JsonDeserialize(using = YearMonthDeserializer.class)
//    private YearMonth startDate; // 시작 일자 (주식을 산 날짜)
//
//    @JsonSerialize(using =  YearMonthSerializer.class)
//    @JsonDeserialize(using = YearMonthDeserializer.class)
//    private YearMonth endDate; // 종료 일자 (주식을 파는 날짜)
//
//    @JsonSerialize(using =  YearMonthSerializer.class)
//    @JsonDeserialize(using = YearMonthDeserializer.class)
//    private YearMonth bestMonth; // 최고의 수익금을 기록한 달
//
//    private Double bestMoney; // 최고의 수익금
//
//    @JsonSerialize(using =  YearMonthSerializer.class)
//    @JsonDeserialize(using = YearMonthDeserializer.class)
//    private YearMonth worstMonth; // 최악의 수익금을 기록한달
//    private Double worstMoney; // 최악의 수익금
//    private Long seedMoney; // 초기 자본
//
//    private List<String> stockNames; // 투자 주식 명
//    private List<String> stockCodes; // 투자 주식 코드
//    private List<Double> buyMoney; // 주식을 구매한 비용
//
//    // 수익률 : (현재 - 이전) /이전
//    private Double finalMoney; // 마지막 수익금
//    private Double yieldMoney; // 마지막 수익금 - 수익률
//    private Double finalYield; // 마지막 수익률 (초기 자본 대비)
//
//    private List<String> months; // 투자기간 월 리스트
//    private List<Double> monthYield; // 월 수익률
//    private List<Double> monthYieldMoney; // 월 수익금
//
//
//    private List<Double> kospiYield; // kospi 투자시 수익률
//    private List<Double> kospiYieldMoney; // kospi 투자시 수익금
//    private List<Double> kosdaqYield; // kosdaq 투자시 수익률
//    private List<Double> kosdaqYieldMoney; // kosdaq 투자시 수익금
//
//    private List<List<Double>> stockYieldMoneys; // 주식별 수익금
//    private List<List<Double>> stockYields;
}
