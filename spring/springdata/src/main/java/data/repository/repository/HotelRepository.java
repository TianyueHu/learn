package data.repository.repository;

import data.repository.bean.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Optional<Hotel> findById(Long id);
    Optional<Hotel> findByName(String name);


}
