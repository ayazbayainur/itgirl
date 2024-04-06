package itgirl.firstspringproject.model;

public enum Weekdays {
   MONDAY("ПОНЕДЕЛЬНИК"),
    TUESDAY("ВТОРНИК"),
    WEDNESDAY("СРЕДА"),
    THURSDAY("ЧЕТВЕРГ"),
    FRIDAY("ПЯТНИЦА"),
    SATURDAY("СУББОТА"),
    SUNDAY("ВОСКРЕСЕНЬЕ");
   private String title;
   Weekdays(String title){
        this.title = title;
    }

    @Override
    public String toString(){
       return title;
    }


}
