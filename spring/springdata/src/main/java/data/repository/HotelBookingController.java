package data.repository;

import data.repository.bean.Hotel;

import data.repository.repositoryImp.SpringHotelBookingRepository;
import data.repository.repositoryImp.SpringHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class HotelBookingController {

    private SpringHotelBookingRepository hotelBookingRepository;


    public HotelBookingController(SpringHotelBookingRepository hotelBookingRepository){
        this.hotelBookingRepository = hotelBookingRepository;

    }


}
