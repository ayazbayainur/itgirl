package itgirl.firstspringproject.controller;

import itgirl.firstspringproject.model.Weekdays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// homework
@RestController
public class WeekdaysController {
    private Weekdays weekdays;

    @GetMapping("today")
    public String today(@RequestParam(value = "name") String name){
        return String.format("Сегодня %s!", weekdays.valueOf(name));
    }
}
