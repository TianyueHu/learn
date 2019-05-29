package data.repository;

import data.repository.bean.Hotel;
import data.repository.repositoryImp.SpringHotelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class HotelController {

    private SpringHotelRepository hotelRepository;


    public HotelController(SpringHotelRepository hotelRepsitory){
        this.hotelRepository = hotelRepsitory;

    }

    @GetMapping(value = "/getAllHotels")
    public ResponseEntity<Collection<Hotel>> getAllHotels(){
        List<Hotel> hotels = new ArrayList<>();
        hotelRepository.findAll().forEach(h ->{
            hotels.add(h);
        });
        return ResponseEntity.ok(hotels);
    }

    @PostMapping(value = "/getHotelsByName")
    public ResponseEntity<Optional<Hotel>> getHotelsByName(String name){
        return ResponseEntity.ok(hotelRepository.findByName(name));
    }

    @PostMapping(value = "/addHotels")
    public String addHotels(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return "success";
    }


}
