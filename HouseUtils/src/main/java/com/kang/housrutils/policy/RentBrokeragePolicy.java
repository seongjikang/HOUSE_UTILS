package com.kang.housrutils.policy;

public class RentBrokeragePolicy implements BrokeragePolicy{

    //인터페이스 구현하니 제거
    //    public Long calculate(Long price) {
//        // TODO: 가격을 받아와서 중계수수료 계산
//        BrokerageRule rule = createBrokerageRule(price);
//        return rule.calcMaxBrokerage(price);
//    }

    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price < 50_000_000) {
            rule = new BrokerageRule(0.5, 200_000L);
        } else if (price < 100_000_000) {
            rule = new BrokerageRule(0.4, 300_000L);
        } else if (price < 300_000_000) {
            rule = new BrokerageRule(0.3, null);
        } else if(price < 600_000_000){
            rule = new BrokerageRule(0.4, null);
        } else {
            rule = new BrokerageRule(0.8, null);
        }
        return rule;
    }
}
