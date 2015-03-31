package problem2;

public class Time {
    private int hours;
    private int minutes; 
    private int seconds;
    private String day;
    private String month;
    private String year;
    
    public Time(String time, String date){
        String[] hms = time.split(":");
        hours = Integer.parseInt(hms[0]);
        minutes = Integer.parseInt(hms[1]);
        seconds = Integer.parseInt(hms[2]);
        
        String[] dmy = date.split("\\.");
        day = dmy[0];
        month = dmy[1];
        year = dmy[2];
        
    }
    
    @Override
    public String toString(){
        return String.format("%d:%d:%d %s.%s.%s\n", hours, minutes,seconds, day, month, year);
    }
    
    public void now(){
        
    }
    
    public static void main(String[] args) {
        Time t = new Time("12:56:23", "05.02.2015");
        System.out.println(t);
       // System.out.println(t.now());
    }
}