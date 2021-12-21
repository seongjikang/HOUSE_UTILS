package com.kang.housrutils.policy;

/**
 * @author kang
 */
public interface BrokeragePolicy {

    BrokerageRule createBrokerageRule(Long price);

    default Long calculate(Long price) {
        // TODO: 가격을 받아와서 중계수수료 계산
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }
}
