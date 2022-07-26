package com.oracle.HomeTheater.controller;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.Reservation;
import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.IT_Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        model.addAttribute("findMovie", findMovie);
        model.addAttribute("findDate", findDate);
        return "reservation/TimeInfo";
    }

    //예매 페이지 - 좌석 선택
    @PostMapping("/reservationtimedata")
    public String reservationTimeData(SeatandTime seatandTime, Model model) {
        log.info("reservationtimedata(controller) start");
        //좌성정보(좌석) 조회
        List<SeatandTime> seatInfo = ITService.findSeatData(seatandTime);
        model.addAttribute("seatandTime", seatandTime);
        model.addAttribute("seatInfo", seatInfo);
        return "reservation/SeatInfo";
    }

    //예매 페이지 - 결제 페이지로 이동
    @PostMapping("/reservationpayment")
    public String reservationPayment(SeatandTime seatandTime, HttpSession session, Model model) {
        //좌석 정보 reservation 정보 삽입
        String m_id = (String) session.getAttribute("sessionId");
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

    @GetMapping("PaymentResult")
    public String finalReservation(@RequestParam("re_number") String re_number, Model model) {
        log.info("re_number = " + re_number);
        log.info("reservationInfo(Controller)start");
        Reservation reservation = ITService.reservationInfo(re_number);
        //맴버 정보가져오기
        Member memberInfo = ITService.memberInfo(reservation.getM_id());
        log.info("memberInfo -> " + memberInfo);
        //영화정보가져오기
        Movie movieInfo = ITService.findMovie(reservation.getMo_number());
        log.info("movieInfo ->" + movieInfo);
        model.addAttribute("seatandTime", reservation);
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("movieInfo", movieInfo);
        return "reservation/Complete";
    }

}
