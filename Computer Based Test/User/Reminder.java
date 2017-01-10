package User;

import java.util.*;

public class Reminder {
    Timer timer;
    static int flag=0;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
           
            timer.cancel(); 
            flag=1;
        }
    }               
    public static int getTimerFlag(){
        return flag;
    }
}
