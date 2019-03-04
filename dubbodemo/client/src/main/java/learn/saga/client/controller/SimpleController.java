package com.learn.saga.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.saga.client.service.HolidayService;

@Controller
@RequestMapping("/holiday")
public class SimpleController {

    @Autowired
    HolidayService holiday;

    @RequestMapping("/plan")
    @ResponseBody
    public String plan() throws Throwable{
        String user = "Techie";
        String result = holiday.holidayPlan("Techie");
        return "good, dear " + user + ", " + result;
    }
}
