package com.bti.inventory.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bti.inventory.dto.UserSessionDto;


@FeignClient("user-module")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/validate")
    ResponseEntity<Boolean> validateSession(@RequestBody UserSessionDto dto);
    
}
