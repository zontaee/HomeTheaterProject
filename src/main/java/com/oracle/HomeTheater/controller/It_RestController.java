package com.oracle.HomeTheater.controller;


import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.IT_Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
public class It_RestController {

    private final IT_Service ITService;

    @PostMapping("Cancel")
    public String finalReservation(SeatandTime seatandTime) {
        String result;
        String re_number = seatandTime.getRe_number();
        seatandTime.setSe_identify("F");
        //예약정보 삭제
        log.info("deleteReservation(controller) start");
        int deleteReservation = ITService.deleteReservation(re_number);
        log.info("result deleteReservation =" + deleteReservation);
        log.info("find reservation");
        log.info("seatandTime = " + seatandTime);
        //좌석정보 업데이트
        log.info("SeatandTimeUpdate(controller) start");
        int resultUpdateSeat = ITService.SeatandTimeUpdate(seatandTime);
        log.info("updatenumber" + resultUpdateSeat);
        //좌석정보와 예약정보 둘다 성공시 result 반환
        if (deleteReservation == 1 && resultUpdateSeat == 1) {
            result = "1";
            return result;
        } else {
            result = "2";
            return result;
        }

    }


    @PostMapping("findTime")
    public List<SeatandTime> findTime(SeatandTime seatandTime){
        log.info("seatandTIme = " + seatandTime);
        log.info("findTime(controller) start");
        List<SeatandTime> findTime = ITService.serchTime(seatandTime);
        return findTime;
    }
}
