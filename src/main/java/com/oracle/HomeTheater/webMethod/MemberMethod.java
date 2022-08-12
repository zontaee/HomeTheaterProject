package com.oracle.HomeTheater.webMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MemberMethod {
    public void MemberNullCheck(String LoginMemberId) {
        try{
            if(LoginMemberId.isBlank()) {
                throw new NullPointerException("LoginMemberId == null");
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}

