package com.dh.user.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/user/detail/{id}")
    public Map<String, Object> detail(@PathVariable("id") Long idUser,
                                      @RequestHeader("user-request-header") String header) {
        Map<String, Object> response = new HashMap<>();
        response.put("id_user", idUser);
        response.put("custom_header_value", header);

        return response;
    }

}