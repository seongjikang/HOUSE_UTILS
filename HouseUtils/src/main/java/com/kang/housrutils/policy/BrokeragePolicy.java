package com.kang.housrutils.policy;

import com.kang.housrutils.exception.ErrorCode;
import com.kang.housrutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author kang
 */
public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price) {
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThen())
                .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));

        return brokerageRule.calcMaxBrokerage(price);
    }
}
