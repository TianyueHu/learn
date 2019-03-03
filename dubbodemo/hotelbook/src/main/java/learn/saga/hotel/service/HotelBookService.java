package learn.saga.hotel.service;
import org.apache.servicecomb.saga.omega.transaction.annotations.Compensable;
import org.springframework.stereotype.Service;

import learn.saga.api.HotelService;
import learn.saga.service.AccountService;

@Service
public class HotelBookService implements HotelService {

    @Compensable(compensationMethod = "cancel")
    public double bookHotel(String user) throws Throwable{
        double fee = 1000.0;
        try {
            AccountService.transfer(fee, "HOTEL");
            //System.out.println("dear  " + user + ", you hotel has been booked successfully, the fee is " + fee);
            return fee;
        }
        catch (Throwable th) {
            //th.printStackTrace();
            throw th;
        }
    }

    public void cancel(String user) throws Throwable{
        try {
            AccountService.transfer(-1000.0, "HOTEL");
            //System.out.println("cancel is called....");
        }
        catch (Throwable th) {
            //th.printStackTrace();
            System.out.println("Hotel booking cancel failed");
            throw th;
        }
    }

}
