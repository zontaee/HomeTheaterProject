package com.oracle.HomeTheater.service;

import com.oracle.HomeTheater.dao.ReservationDao;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.Reservation;
import com.oracle.HomeTheater.model.SeatandTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;


    @Override
    public Movie findMovie(int mo_number) {

        log.info("resvervation(service) findMovie start mo_number -> " + mo_number);
        Movie findMovie = reservationDao.findMovie(mo_number);
        return findMovie;
    }

    @Override
    public List<SeatandTime> findDate(int mo_number) {
        log.info("resvervation(service) findDate start mo_number -> " + mo_number);
        List<SeatandTime> findDate = reservationDao.findDate(mo_number);
        return findDate;
    }

    @Override
    public List<SeatandTime> findTime(int mo_number) {
        log.info("resvervation(service) findTime start mo_number -> " + mo_number);
        List<SeatandTime> findTime = reservationDao.findTime(mo_number);
        return findTime;
    }

    @Override
    public List<SeatandTime> findSeatData(SeatandTime seatandTime) {
        log.info("reservationtimedata(Service) findseat start");
        List<SeatandTime> seatInfo = reservationDao.findSeatData(seatandTime);
        return seatInfo;
    }

    @Override
    public int reservationSave(SeatandTime seatandTime) {
        log.info("reservationSave(service) start");
        int result = reservationDao.reservationSave(seatandTime);
        return result;
    }

    @Override
    public Member memberInfo(String m_id) {
        log.info("memberInfo(service) start");
        Member memberInfo = reservationDao.memberInfo(m_id);
        return memberInfo;
    }

    @Override
    public int SeatandTimeUpdate(SeatandTime seatandTime) {
        log.info("SeatandTimeUpdate(service) start");
        int resultUpdate = reservationDao.SeatandTimeUpdate(seatandTime);
        return resultUpdate;
    }

    @Override
    public int memberPointUpdate(SeatandTime seatandTime) {
        log.info("memberPointUpdate(service) start");
        int resultUpdate = reservationDao.memberPointUpdate(seatandTime);
        return resultUpdate;
    }

    @Override
    public int deleteReservation(String re_number) {
        log.info("deleteReservation(service) start");
        int deleteReservation = reservationDao.deleteReservation(re_number);
        return deleteReservation;
    }

    @Override
    public List<SeatandTime> serchTime(SeatandTime seatandTime) {
        log.info("serchTime(service) start");
        List<SeatandTime> findtime = reservationDao.serchTime(seatandTime);
            return findtime;

    }

    @Override
    public Reservation reservationInfo(String re_number) {
        log.info("reservationInfo(service) start");
        Reservation reservation = reservationDao.reservationInfo(re_number);

        return reservation;
    }

    @Override
    public List<Movie> findMovieInfoDate(int mo_number) {
        log.info("reservationInfo(service) start");
        List<Movie> findMovieInfoDate = reservationDao.findMovieInfoDate(mo_number);
        return findMovieInfoDate;
    }


}
