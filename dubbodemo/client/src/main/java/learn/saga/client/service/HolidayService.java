package com.learn.saga.client.service;

//import org.apache.servicecomb.saga.omega.context.annotations.SagaStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.saga.api.FlightService;
import learn.saga.api.HotelService;
import learn.saga.api.PaymentService;

@Service
public class HolidayService {
    @Autowired
    private FlightService flight;

    @Autowired
    private HotelService hotel;

    @Autowired
    private PaymentService payment;

    //@SagaStart(timeout = 20)
    public String holidayPlan(String user) throws Throwable{

        double fee = flight.bookFlight(user);
        fee += hotel.bookHotel(user);
        payment.pay(fee, user);
        return "you total fee is " + fee;
    }
}
