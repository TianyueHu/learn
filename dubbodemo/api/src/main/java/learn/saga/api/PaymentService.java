package learn.saga.api;

public interface PaymentService {
    void pay(double fee, String user) throws Throwable;
}
