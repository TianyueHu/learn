package spring.boot.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "hello world";
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getReadingList() {
        return "test successfully";
    }
}
