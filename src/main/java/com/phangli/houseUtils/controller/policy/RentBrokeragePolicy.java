package com.phangli.houseUtils.controller.policy;

/**
 * 임대차일 때 중개수수료를 계산해주는 클래스
 */
public class RentBrokeragePolicy implements BrokeragePolicy{

    //가격을 Long으로 하는 이유는 Integer는 21억까지 밖에 안되는데 집 값이 21억이 넘을 수 있기 때문이다.
    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if (price < 50_000_000) {
            rule = new BrokerageRule(0.5, 200_000L);
        } else if (price < 100_000_000) {
            rule = new BrokerageRule(0.4, 300_000L);
        } else if (price < 300_000_000) {
            rule = new BrokerageRule(0.3, null);
        } else if (price < 600_000_000) {
            rule = new BrokerageRule(0.4, null);
        } else {
            rule = new BrokerageRule(0.8, null);
        }
        return rule;
    }

}


//메소드가 생성과 계산을 따로따로 해야한다.