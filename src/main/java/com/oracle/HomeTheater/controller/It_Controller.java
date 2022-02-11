package com.oracle.HomeTheater.controller;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.IT_Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLDataException;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class It_Controller {

    private final IT_Service ITService;

    //예매 페이지 - 날짜 시간 선택
    @GetMapping("/reservation")
    public String reservation(int mo_number, Model model) {
        log.info("resvervation(controller) findMovie start mo_number -> " + mo_number);
        Movie findMovie = ITService.findMovie(mo_number);
        log.info("resvervation(controller) findDate start mo_number -> " + mo_number);
        List<SeatandTime> findDate = ITService.findDate(mo_number);
       /* log.info("resvervation(controller) findTime start mo_number -> " + mo_number);
        List<SeatandTime> findTime = ITService.findTime(mo_number);*/
        model.addAttribute("findMovie", findMovie);
        model.addAttribute("findDate", findDate);
        return "reservation/TimeInfo";
    }//예매 페이지 - 좌석 선택

    @PostMapping("/reservationtimedata")
    public String reservationTimeData(SeatandTime seatandTime, Movie movie, Model model) {
        log.info("mo_number -> " + seatandTime.getMo_number());
        log.info("Date -> " + seatandTime.getSe_date());
        log.info("Time -> " + seatandTime.getSe_time());
        log.info("mo_number -> " + movie.getMo_number());
        log.info("mo_filename -> " + movie.getMo_fileName());
        log.info("mo_title-> " + movie.getMo_title());

        log.info("reservationtimedata(controller) findseat start");
        //좌성정보(좌석) 조회
        List<SeatandTime> seatInfo = ITService.findSeatData(seatandTime);
        model.addAttribute("seatandTime", seatandTime);
        model.addAttribute("seatInfo", seatInfo);
        model.addAttribute("movie", movie);
        return "reservation/SeatInfo";
    }

    //예매 페이지 - 결제 페이지로 이동
    @PostMapping("/reservationpayment")
    public String reservationPayment(SeatandTime seatandTime, HttpServletRequest request, Model model) {
        //log.info("m_number -> " + member.getM_number()); <-- sesstion 으로 받을예정
        //좌석 정보 reservation 정보 삽입
        String m_id = "test1";
        seatandTime.setM_id(m_id);
        log.info("SeatandTime ->" + seatandTime);

        //맴버포인트 정보 가져오기
        log.info("find memberinfo(controller) start");
        Member memberInfo = ITService.memberInfo(m_id);
        log.info("Member ->" + memberInfo.toString());

        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("seatandTime", seatandTime);
        return "reservation/PaymentInfo";
    }

    @PostMapping("Payment")
    public String finalReservation(SeatandTime seatandTime, Model model) {
        //예약번호를 uuid로 지정
        String uuid = UUID.randomUUID().toString().substring(0, 13);
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
        //맴버 정보가져오기
        Member memberInfo = ITService.memberInfo(seatandTime.getM_id());
        log.info("memberInfo -> " + memberInfo);
        //영화정보가져오기
        Movie movieInfo = ITService.findMovie(seatandTime.getMo_number());
        log.info("movieInfo ->" + movieInfo);
        model.addAttribute("seatandTime", seatandTime);
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("movieInfo", movieInfo);
        return "reservation/Complete";
    }

}
