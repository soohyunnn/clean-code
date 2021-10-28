package com.phangli.houseUtils.controller;

import com.phangli.houseUtils.constants.ActionType;
import com.phangli.houseUtils.controller.policy.BrokeragePolicy;
import com.phangli.houseUtils.controller.policy.BrokeragePolicyFactory;
import com.phangli.houseUtils.controller.policy.PurchaseBrokeragePolicy;
import com.phangli.houseUtils.controller.policy.RentBrokeragePolicy;
import com.phangli.houseUtils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 중개수수료가 얼마인지 조회하는 컨트롤러
 */
@RestController
@AllArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType, @RequestParam Long price) {
        //타입 정의 - 매매 / 임대차

        //TODO: 중개수수료 계산하는 로직
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);

        //BrokeragePolicyFactory로 리팩토링
//        if (actionType == ActionType.PURCHASE) {
//            PurchaseBrokeragePolicy policy = new PurchaseBrokeragePolicy();
//            return policy.calculate(price);
//        }
//        if (actionType == ActionType.RENT) {
//            RentBrokeragePolicy policy = new RentBrokeragePolicy();
//            return policy.calculate(price);
//        }

    }

    @GetMapping("/api/calcu/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(@PathVariable Long apartmentId, @RequestParam ActionType actionType) {

        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        Long price = apartmentService.getPriceOrThrow(apartmentId);
        return policy.calculate(price);

    }


}
