package com.oracle.HomeTheater.controller;

import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.Reservation;
import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.IT_Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class It_Controller {
    @Autowired
    private final IT_Service ITService;

    @GetMapping("/reservation")
    public String reservation(int mo_number, Model model) {
        log.info("resvervation(controller) findMovie start mo_number -> " + mo_number);
        Movie findMovie = ITService.findMovie(mo_number);
        log.info("resvervation(controller) findDate start mo_number -> " + mo_number);
        List<SeatandTime> findDate = ITService.findDate(mo_number);
        log.info("resvervation(controller) findTime start mo_number -> " + mo_number);
        List<SeatandTime> findTime = ITService.findTime(mo_number);
        model.addAttribute("findMovie",findMovie);
        model.addAttribute("findDate",findDate);
        model.addAttribute("findTime",findTime);
        return "reservation/reservationstart";
    }
    @PostMapping("/reservationtimedata")
    public String reservationTimeData(SeatandTime seatandTime,Movie movie , Model model){
        log.info("mo_number -> " +seatandTime.getMo_number());
        log.info("Date -> " +seatandTime.getSe_date());
        log.info("Time -> " +seatandTime.getSe_time());
        log.info("mo_number -> " + movie.getMo_number());
        log.info("mo_filename -> " +movie.getMo_fileName());
        log.info("mo_title-> " + movie.getMo_title());

        log.info("reservationtimedata(controller) findseat start");
        List<SeatandTime> seatInfo = ITService.findSeatData(seatandTime);
        model.addAttribute("seatandTime",seatandTime);
        model.addAttribute("seatInfo",seatInfo);
        model.addAttribute("movie",movie);
        return"reservation/reservationseat";
    }
    @PostMapping("/reservationpayment")
    public String reservationPayment(SeatandTime seatandTime , HttpServletRequest request){
       /* log.info("mo_number -> " +seatandTime.getMo_number());
        log.info("Date -> " +seatandTime.getSe_date());
        log.info("Time -> " +seatandTime.getSe_time());
        log.info("se_identify -> " + seatandTime.getSe_identify());
        log.info("Se_number -> " +seatandTime.getSe_number());*/
        log.info("SeatandTime ->" + seatandTime.toString());
        //log.info("m_number -> " + member.getM_number()); <-- sesstion 으로 받을예정
        //좌석 정보 reservation 정보 삽입
        log.info("reservationSave(controller) start");
        int result = ITService.reservationSave(seatandTime);
        if(result == 1){
            log.info("reservation insert 성공");
        }
        return "CH_view/CH_Payment";
    }
}
