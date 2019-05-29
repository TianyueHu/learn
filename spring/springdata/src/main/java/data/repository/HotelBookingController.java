package data.repository;

import data.repository.repositoryImp.SpringHotelBookingRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelBookingController {

    private SpringHotelBookingRepository hotelBookingRepository;


    public HotelBookingController(SpringHotelBookingRepository hotelBookingRepository){
        this.hotelBookingRepository = hotelBookingRepository;

    }


}
