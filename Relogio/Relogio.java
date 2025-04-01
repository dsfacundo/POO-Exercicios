import java.util.*;

class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;



    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    } // todo

    public void setHour(int hour){
        if (hour < 0 || hour > 24)
            System.out.println("fail: hora invalida");
        else if (hour == 24)
            this.hour = 0;
        else
            this.hour = hour;
    } // todo

    public void setMinute(int minute){
        if (minute < 0 || minute > 60)
            System.out.println("fail: minuto invalido");
        else if (minute == 60) {
            this.minute = 0;
            setHour(getHour() + 1);
        }else
            this.minute = minute;
    } // todo

    public void setSecond(int second){
        if (second < 0 || second > 60)
            System.out.println("fail: segundo invalido");
        else if (second == 60){
            this.second = 0;
            setMinute(getMinute() + 1);
        }
        else
            this.second = second;
    } // todo

    public int getHour(){
        return this.hour;
    } // todo

    public int getMinute(){
        return this.minute;
    } // todo

    public int getSecond(){
        return this.second;
    } // todo

    //avança o tempo em um segundo
    public void nextSecond(){
        setSecond(getSecond() + 1);
    } // todo

    public String toString() {
        return String.format("%02d", hour) + ":" +
                String.format("%02d", minute) + ":" +
                String.format("%02d", second);
    }
}


class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time(0, 0, 0);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] ui = line.split(" ");
            String cmd = ui[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("set")) {
                time.setHour(Integer.parseInt(ui[1]));
                time.setMinute(Integer.parseInt(ui[2]));
                time.setSecond(Integer.parseInt(ui[3]));
            } else if (cmd.equals("show")) {
                System.out.println(time);
            } else if (cmd.equals("next")) {
                time.nextSecond();
            } else {
                System.out.println("fail: comando inválido");
            }
        }

        scanner.close();
    }
}