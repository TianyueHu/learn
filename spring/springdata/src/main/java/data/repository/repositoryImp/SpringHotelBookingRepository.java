package data.repository.repositoryImp;

import data.repository.bean.HotelBooking;
import data.repository.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public class SpringHotelBookingRepository {

    HotelBookingRepository hotelBookingRepository;

    public SpringHotelBookingRepository(HotelBookingRepository hotelBookingRepository){
        this.hotelBookingRepository = hotelBookingRepository;
    }

    public void save(HotelBooking hotelBooking){
        hotelBookingRepository.save(hotelBooking);
    }

    public Optional<HotelBooking> findByIdOrderByFromDateAsc(long id){
        return hotelBookingRepository.findByIdOrderByFromDateAsc(id);
    }
    public Optional<HotelBooking> findByBookerIdOrderByFromDateAsc(long bookerId){
        return hotelBookingRepository.findByBookerIdOrderByFromDateAsc(bookerId);
    }
    public Optional<HotelBooking> findByBookerIdAndFromDateGreaterThanEqualAndFromDateLessThanEqual(
            long bookerId, Date date1, Date date2){
        return hotelBookingRepository.findByBookerIdAndFromDateGreaterThanEqualAndFromDateLessThanEqual(bookerId, date1, date2);
    }


}
