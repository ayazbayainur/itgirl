package ru.itgirl;

public enum Weekdays {
    MONDAY("ПОНЕДЕЛЬНИК"),
    TUESDAY("ВТОРНИК"),
    WEDNESDAY("СРЕДА"),
    THIRSDAY("ЧЕТВЕРГ"),
    FRIDAY("ПЯТНИЦА"),
    SATURDAY("СУББОТА"),
    SUNDAY("ВОСКРЕСЕНЬЕ");

    private String title;
    Weekdays(String title){
        this.title = title;
    }

    public String toString(){
        return title;
    }
}
