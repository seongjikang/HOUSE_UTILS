package com.kang.housrutils.service;

import com.kang.housrutils.exception.ErrorCode;
import com.kang.housrutils.exception.HouseUtilsException;
import com.kang.housrutils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository; // 생성자 주입으로 빈을 wiring

    public Long getPriceOrThrow(Long apartmentId) {
       return apartmentRepository.findById(apartmentId)
               .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
               .getPrice();
    }
}
