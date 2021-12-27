package com.kang.housrutils.controller;

import com.kang.housrutils.constants.ActionType;
import com.kang.housrutils.policy.BrokeragePolicy;
import com.kang.housrutils.policy.BrokeragePolicyFactory;
import com.kang.housrutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author kang
 *
 * 중계수수료가 얼마인지 조회하는 컨트롤러러 */
@RestController
@AllArgsConstructor
public class BrokerageQueryController {
    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(@PathVariable Long apartmentId,
                                           @RequestParam ActionType actionType) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }
}
