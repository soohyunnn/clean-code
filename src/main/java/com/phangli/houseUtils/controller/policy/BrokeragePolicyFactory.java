package com.phangli.houseUtils.controller.policy;

import com.phangli.houseUtils.constants.ActionType;
import com.phangli.houseUtils.exception.ErrorCode;
import com.phangli.houseUtils.exception.HouseUtilsException;


public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 ActionType에 대한 정책이 존재하지 않습니다.");
        }
    }

}
