package data.repository.repositoryImp;

import data.repository.bean.Hotel;
import data.repository.repository.HotelRepository;

import java.util.Optional;

public class SpringHotelRepository {
    private HotelRepository hotelRepository;

    public SpringHotelRepository(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public void save(Hotel hotel){
        hotelRepository.save(hotel);
    }
    public Iterable<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public Optional<Hotel> findById(long id){
        return hotelRepository.findById(id);
    }
    public Optional<Hotel> findByName(String name){
        return hotelRepository.findByName(name);
    }
}
