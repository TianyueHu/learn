package data.repository.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "HotelBooking")
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long hotelId;
    private Date fromDate;
    private Date toDate;
    private int numberOfPeople;
    private long bookerId;

    public HotelBooking(){

    }

    public HotelBooking(long hotelId, Date fromDate, Date toDate,
                        int numberOfPeople, long bookerId){
        this.hotelId = hotelId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.numberOfPeople = numberOfPeople;
        this.bookerId = bookerId;
    }

    public Long id() {
        return id;
    }

    public long hotel() {
        return hotelId;
    }

    public Date fromDate() {
        return fromDate;
    }

    public Date toDate() {
        return toDate;
    }

    public int numberOfPeople() {
        return numberOfPeople;
    }

    public long bookerId() {
        return bookerId;
    }
}
