package com.oracle.HomeTheater.controller;


import com.oracle.HomeTheater.dao.IT_Dao;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.IT_Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@Slf4j
@RequiredArgsConstructor
public class It_RestController {

    private final IT_Service ITService;
    private final IT_Dao it_dao;

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
    public List<SeatandTime> findTime(SeatandTime seatandTime) {
        log.info("seatandTIme = " + seatandTime);
        log.info("findTime(controller) start");
        List<SeatandTime> findTime = ITService.serchTime(seatandTime);
        return findTime;
    }

    @PostMapping("Payment")
    public String finalReservation(SeatandTime seatandTime, Model model) {
        //예약번호를 uuid로 지정
        String uuid = UUID.randomUUID().toString().substring(0, 13);
        String re_number = uuid;
        seatandTime.setRe_number(uuid);

        log.info(seatandTime.getRe_number());
        log.info("seatandTable ->" + seatandTime);

        //좌석 정보 업데이트
        log.info("SeatandTimeUpdate(controller) start");
        int resultUpdateSeat = ITService.SeatandTimeUpdate(seatandTime);
        log.info("updatenumber" + resultUpdateSeat);

        //예약정보 삽입
        log.info("reservationSave(controller) start");
        int resultSave = ITService.reservationSave(seatandTime);
        if (resultSave == 1) {
            log.info("reservation insert 성공");
        } else {
            log.info("insert 실패");
        }
        //맴버 포인트 업데이트
        log.info("memberPointUpdate(controller) start");
        int resultUpdatePoint = ITService.memberPointUpdate(seatandTime);
        return re_number;
    }
    @GetMapping("identify")
    public List<Movie> asd(int monumber) {
        List<Movie> movieInfoDate = it_dao.findMovieInfoDate(monumber);
        return movieInfoDate;
    }

}
