package data.repository.repository;

import data.repository.bean.HotelBooking;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface HotelBookingRepository extends CrudRepository<HotelBooking, Long> {

    Optional<HotelBooking> findByIdOrderByFromDateAsc(long id);
    Optional<HotelBooking> findByBookerIdOrderByFromDateAsc(long bookerId);
    Optional<HotelBooking> findByBookerIdAndFromDateGreaterThanEqualAndFromDateLessThanEqual(long bookerId, Date date1, Date date2);


}
