package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TestDao {
    @Autowired
    private SqlSession session;
     public void testInitialization(){
         try{
             session.delete("deleteMember");
             session.delete("deleteBoard");
             session.delete("deleteMOVIE");
             session.delete("deleteCHOICEMOVIE");
             session.delete("deleteSEATANDTIME");
             session.delete("deleteRESERVATION");
             session.delete("deleteACTOR");
         }catch (Exception e){
                log.info(e.getMessage());
         }
     }
     public void insertBoard(Board board){
         try{
             session.insert("insertBoard",board);

         }catch (Exception e){
             log.info(e.getMessage());
         }
     }

}
