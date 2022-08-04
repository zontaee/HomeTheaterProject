package com.oracle.HomeTheater.webMethod;

import com.oracle.HomeTheater.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BoardMethod {

    public void boardNullCheck(Board board) {
        try{
            if(board == null) {
                throw new NullPointerException("board == null");
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}
