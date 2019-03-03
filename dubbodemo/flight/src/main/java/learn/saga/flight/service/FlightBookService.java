package learn.saga.flight.service;

import org.apache.servicecomb.saga.omega.transaction.annotations.Compensable;

import learn.saga.api.FlightService;
import learn.saga.service.AccountService;

public class FlightBookService {


    @Compensable(compensationMethod = "cancel")
    public double bookFlight(String user) throws Throwable{
        double fee = 1000.0;
        try {
            AccountService.transfer(fee, "FLIGHT");
            //System.out.println("dear  " + user + ", you flight has been booked successfully, the fee is " + fee);
            return fee;
        }
        catch (Throwable th) {
            //th.printStackTrace();
            throw th;
        }
    }

    public void cancel(String user) throws Throwable{
        try {
            AccountService.transfer(-1000.0, "FLIGHT");
            //System.out.println("cancel called...");
        }
        catch (Throwable th) {
            System.out.println("Flignt booking cancel failed");
            //th.printStackTrace();
            throw th;
        }
    }
}
