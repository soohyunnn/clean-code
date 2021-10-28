package com.phangli.houseUtils.service;


import com.phangli.houseUtils.exception.ErrorCode;
import com.phangli.houseUtils.exception.HouseUtilsException;
import com.phangli.houseUtils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId).orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND)).getPrice();
    }

}
