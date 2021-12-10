package com.kang.housrutils.policy;

/**
 * 매매일 때 중계수수료를 계산해주는 클래스
 */
public class PurchaseBrokeragePolicy implements BrokeragePolicy{
    //인터페이스니 제거
//    public Long calculate(Long price) {
//        // TODO: 가격을 받아와서 중계수수료 계산
//        //아래로직은 생성과 계산이 같이 있음 ..
////        BrokerageRule rule;
////        if(price < 50_000_000) {
////            rule = new BrokerageRule(0.6, 250_000L);
////        } else if (price < 200_000_000) {
////            rule = new BrokerageRule(0.5, 800_000L);
////        } else if (price < 600_000_000) {
////            rule = new BrokerageRule(0.4, null);
////        } else if(price < 900_000_000){
////            rule = new BrokerageRule(0.5, null);
////        } else {
////            rule = new BrokerageRule(0.9, null);
////        }
//        BrokerageRule rule = createBrokerageRule(price);
//        return rule.calcMaxBrokerage(price);
//
//    }

    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price < 50_000_000) {
            rule = new BrokerageRule(0.6, 250_000L);
        } else if (price < 200_000_000) {
            rule = new BrokerageRule(0.5, 800_000L);
        } else if (price < 600_000_000) {
            rule = new BrokerageRule(0.4, null);
        } else if(price < 900_000_000){
            rule = new BrokerageRule(0.5, null);
        } else {
            rule = new BrokerageRule(0.9, null);
        }
        return rule;
    }
}
