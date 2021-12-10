package com.kang.housrutils.policy;

import lombok.AllArgsConstructor;

/**
 * 가격이 특정 범위일때 상한효율과 상한금액을 가지는 클래스
 */
@AllArgsConstructor
public class BrokerageRule {
    private Double brokeragePercent;
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        if (limitAmount == null) {
//            Double amount = Math.floor(brokeragePercent / 100 * price);
//            long l = amount.longValue();
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
//        Double amount = Math.floor(brokeragePercent / 100 * price);
//        return amount.longValue();
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
