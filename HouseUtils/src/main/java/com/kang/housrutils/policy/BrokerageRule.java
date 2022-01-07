package com.kang.housrutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * 가격이 특정 범위일때 상한효율과 상한금액을 가지는 클래스
 */
@AllArgsConstructor
@Getter
public class BrokerageRule {
    private Long lessThen;
    private Double brokeragePercent;
    private Long limitAmount;

    public BrokerageRule(Long lessThen, Double brokeragePercent) {
        this(lessThen, brokeragePercent, Long.MAX_VALUE);
    }

    public Long calcMaxBrokerage(Long price) {
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
//        Double amount = Math.floor(brokeragePercent / 100 * price);
//        return amount.longValue();
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
