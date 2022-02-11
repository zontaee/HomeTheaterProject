package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.SeatandTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class IT_DaoImpl implements IT_Dao {
    @Autowired
    private SqlSession session;


    @Override
    public Movie findMovie(int mo_number) {
        Movie findMovie = null;
        log.info("resvervation(Dao) findMovie start mo_number -> " + mo_number);
        try {
            findMovie = session.selectOne("It_MoviSelFind", mo_number);
        } catch (Exception e) {
            log.info("resvervation(Dao) Exception -> " + e.getMessage());
        }
        log.info("resvervation(Dao) findMovie End findMovie-> " + findMovie);
        return findMovie;
    }

    @Override
    public List<SeatandTime> findDate(int mo_number) {
        List<SeatandTime> findDate = null;
        log.info("resvervation(Dao) findDate start mo_number -> " + mo_number);
        try {
            findDate = session.selectList("It_SeatSelFindDate", mo_number);
        } catch (Exception e) {
            log.info("resvervation(Dao) Exception -> " + e.getMessage());
        }
        log.info("resvervation(Dao) findMovie End findDate size-> " + findDate.size());
        return findDate;
    }

    @Override
    public List<SeatandTime> findTime(int mo_number) {
        List<SeatandTime> findTime = null;
        log.info("resvervation(Dao) findTime start mo_number -> " + mo_number);
        try {
            findTime = session.selectList("It_SeatSelFindTime", mo_number);
        } catch (Exception e) {
            log.info("resvervation(Dao) Exception -> " + e.getMessage());
        }
        log.info("resvervation(Dao) findMovie End findTime size-> " + findTime.size());
        return findTime;
    }

    @Override
    public List<SeatandTime> findSeatData(SeatandTime seatandTime) {
        List<SeatandTime> seatInfo = null;
        log.info("findSeatData(Dao)start");
        try {
            seatInfo = session.selectList("It_SeatSelFindSeat", seatandTime);
        } catch (Exception e) {
            log.info("findSeatData(Dao) Exception -> " + e.getMessage());
        }
        log.info("findSeatData(Dao) seat size-> " + seatInfo.size());
        return seatInfo;
    }

    @Override
    public int reservationSave(SeatandTime seatandTime) {
        int result = 0;
        log.info("reservationSave(DAO) start");
        result = session.insert("It_ReservationSave", seatandTime);
        return result;
    }

    @Override
    public Member memberInfo(String m_id) {
        Member memberInfo = null;
        log.info("memberInfo(DAO) start");
        try {
            memberInfo = session.selectOne("It_memberInfo", m_id);
        } catch (Exception e) {
            log.info("memberInfo(DAO) start -> " + e.getMessage());
        }

        return memberInfo;
    }

    @Override
    public int SeatandTimeUpdate(SeatandTime seatandTime) {
        int resultUpdate = 0;
        try {
            log.info("SeatandTimeUpdate(DAO) start");
            resultUpdate = session.update("It_SeatInfoUpdate", seatandTime);
        } catch (Exception e) {
            log.info("SeatandTimeUpdate(DAO) start -> " + e.getMessage());
        }
        return resultUpdate;
    }

    @Override
    public int memberPointUpdate(SeatandTime seatandTime) {
        int resultUpdate = 0;
        try {
            log.info("memberPointUpdate(DAO) start");
            resultUpdate = session.update("It_MemberPointUpdate", seatandTime);
        } catch (Exception e) {
            log.info("memberPointUpdate(DAO) start -> " + e.getMessage());
        }
        return resultUpdate;
    }

    @Override
    public int deleteReservation(String re_number) {
        int deleteReservation = 0;
        try {
            log.info("deleteReservation(Dao) start");
            deleteReservation = session.delete("It_DeleteReservation", re_number);
        } catch (Exception e) {
            log.info("deleteReservation(DAO) start -> " + e.getMessage());
        }
        return deleteReservation;


    }

    @Override
    public List<SeatandTime> serchTime(SeatandTime seatandTime) {
        List<SeatandTime> findTime = null;
        log.info("serchTime(Dao)start");
        try {
            findTime = session.selectList("It_SeatFindTime", seatandTime);
        } catch (Exception e) {
            log.info("serchTime(Dao) Exception -> " + e.getMessage());
        }
        log.info("serchTime(Dao) seat size-> " + findTime.size());
        return findTime;
    }


}