package com.phangli.houseUtils.controller.policy;

/**
 * 중개수수료 정책 인터페이스
 */
public interface BrokeragePolicy {

    BrokerageRule createBrokerageRule(Long price);

    default Long calculate(Long price) {
        //TODO: 가격을 받아서 중개수수료를 계산한다.
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }
}

//PruchaseBrokerPolicy와 RentBrokeragePolicy에서 calculate를 동시에 같은 코드를 사용하고 있기 때문에 인터페이스로 빼줌.