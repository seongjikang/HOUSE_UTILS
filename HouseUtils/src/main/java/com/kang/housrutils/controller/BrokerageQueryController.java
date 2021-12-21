package com.kang.housrutils.controller;

import com.kang.housrutils.constants.ActionType;
import com.kang.housrutils.policy.BrokeragePolicy;
import com.kang.housrutils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author kang
 *
 * 중계수수료가 얼마인지 조회하는 컨트롤러러 */
@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {

        // TODO: 중계수수료 계산 로직
        //DIP 적용해서 수정이 필요함
//        if(actionType == ActionType.PURCHASE) {
//            PurchaseBrokeragePolicy policy = new PurchaseBrokeragePolicy();
//            return policy.calculate(price);
//        }
//
//        if(actionType == ActionType.RENT) {
//            RentBrokeragePolicy policy = new RentBrokeragePolicy();
//            return policy.calculate(price);
//        }
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
