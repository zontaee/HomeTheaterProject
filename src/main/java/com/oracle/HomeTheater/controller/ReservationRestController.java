package com.oracle.HomeTheater.controller;


import com.oracle.HomeTheater.dao.ReservationDao;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.ReservationService;
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
public class ReservationRestController {

    private final ReservationService reservationService;
    private final ReservationDao reservationdao;

    @PostMapping("Cancel")
    public String finalReservation(SeatandTime seatandTime) {
        log.info("finalReservation(controller) start");
        String result;
        String re_number = seatandTime.getRe_number();
        seatandTime.setSe_identify("F");
        //예약정보 삭제
        int deleteReservation = reservationService.deleteReservation(re_number);

        //좌석정보 업데이트
        int resultUpdateSeat = reservationService.SeatandTimeUpdate(seatandTime);
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
        log.info("findTime(controller) start");
        List<SeatandTime> findTime = reservationService.serchTime(seatandTime);
        return findTime;
    }

    @PostMapping("Payment")
    public String finalReservation(SeatandTime seatandTime, Model model) {
        log.info("finalReservation(controller) start");
        //예약번호를 uuid로 지정
        String uuid = UUID.randomUUID().toString().substring(0, 13);
        String re_number = uuid;
        seatandTime.setRe_number(uuid);

        //좌석 정보 업데이트
        int resultUpdateSeat = reservationService.SeatandTimeUpdate(seatandTime);
        log.info("updatenumber" + resultUpdateSeat);

        //예약정보 삽입
        int resultSave = reservationService.reservationSave(seatandTime);
        if (resultSave == 1) {
            log.info("reservation insert 성공");
        } else {
            log.info("insert 실패");
        }
        //맴버 포인트 업데이트
        int resultUpdatePoint = reservationService.memberPointUpdate(seatandTime);
        return re_number;
    }
    /**
     * 영화의 정보 좌석정보 API
     * @param moNumber
     * @return
     */
    @GetMapping("movieSeatAndTimeInfo")
    public List<Movie> movieSeatAndTimeInfo(int moNumber) {
        List<Movie> movieInfoDate = reservationService.findMovieInfoDate(moNumber);

        return movieInfoDate;
    }

}
