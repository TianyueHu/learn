package learn.saga.pay.service;

import org.apache.servicecomb.saga.omega.transaction.annotations.Compensable;

import learn.saga.api.PaymentService;
import learn.saga.service.AccountService;

public class PayService implements PaymentService {

    @Compensable(compensationMethod = "cancel")
    public void pay(double fee, String user) throws Throwable{
        try {
            AccountService.transfer(fee, "DEBT");
            //System.out.println("dear " + user + ", you total payment is " + fee + ", it's successfully payed.");
        }
        catch (Throwable th) {
            //th.printStackTrace();
            throw th;
        }

    }

    public void cancel(double fee, String user) throws Throwable{
        try {
            AccountService.transfer(-fee, "DEBT");
            //System.out.println("cancel called ....");
        }
        catch (Throwable th) {
            System.out.println("payment booking cancel failed");
            //th.printStackTrace();
            throw th;
        }
    }
}
