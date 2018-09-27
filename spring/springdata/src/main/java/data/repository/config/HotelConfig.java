package data.repository.config;

import data.repository.HotelBookingController;
import data.repository.HotelController;
import data.repository.repository.HotelBookingRepository;
import data.repository.repository.HotelRepository;
import data.repository.repositoryImp.SpringHotelBookingRepository;
import data.repository.repositoryImp.SpringHotelRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "data.repository")
public class HotelConfig {

    @Bean
    public SpringHotelRepository springHotelRepository(HotelRepository hotelRepository){
        return new SpringHotelRepository(hotelRepository);
    }

    @Bean
    public SpringHotelBookingRepository springHotelBookingRepository(HotelBookingRepository hotelBookingRepository){
        return new SpringHotelBookingRepository(hotelBookingRepository);
    }

    @Bean
    public HotelBookingController hotelBookingController(SpringHotelBookingRepository hotelBookingRepository){
        return new HotelBookingController(hotelBookingRepository);
    }

    @Bean
    public HotelController hotelController(SpringHotelRepository hotelRepository){
        return new HotelController(hotelRepository);
    }
}
