import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.awt.geom.AreaOp;

import javax.swing.*;
import javax.xml.crypto.Data;
import javax.xml.soap.Text;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class alarm {
    public static void main(String [] args) throws IOException {
        Frame1 f = new Frame1();
        f.GetClock();



    }
}
class Frame1 extends Frame{
    TextField tf = new TextField();
    TextField remain = new TextField();
    Panel p = new Panel(new GridLayout(5,1));
    Panel hour = new Panel();
    Panel minute = new Panel();
    Panel second = new Panel();
    String[] s1={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
    String[] s2={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
    String[] s3={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
    String remainTime;
    JComboBox combo1 = new JComboBox(s1);
    JComboBox combo2 = new JComboBox(s2);
    JComboBox combo3 = new JComboBox(s3);

    int year1;
    int month1;
    int day1;
    int hour1;
    int minute1;
    int second1;

    Button b = new Button("Start_Alarm");
    Frame1(){
        Label l1 = new Label("hour");
        Label l2 = new Label("minute");
        Label l3 = new Label("second");
        setBounds(300,300,500,500);
//        setLayout(new FlowLayout());
        tf.setBounds(0,0,250,30);
        hour.add(l1);
        hour.add(combo1);
        minute.add(l2);
        minute.add(combo2);
        second.add(l3);
        second.add(combo3);

        p.add(hour);
        p.add(minute);
        p.add(second);
        p.add(b);
        p.add(remain);
        add(p);

        add(tf,"North");

        monitor m =new monitor();
        b.addActionListener(m);
//        pack();
        setVisible(true);
        Timer timer = new Timer();
        timer.schedule(new UpdateTime(),1000,1000 );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
    public void GetClock(){
        Date d= null;
        Calendar c = Calendar.getInstance();
        year1 = c.get(Calendar.YEAR);
        month1 = c.get(Calendar.MONTH);
        day1 = c.get(Calendar.DATE);
        hour1 = c.get(Calendar.HOUR_OF_DAY);
        minute1 = c.get(Calendar.MINUTE);
        second1 = c.get(Calendar.SECOND);
        String time = year1+"年"+month1+"月"+day1+"日"+hour1+"时"+minute1+"分"+second1+"秒";
        tf.setText(time);
    }

    class monitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo1.setEnabled(false);
            combo2.setEnabled(false);
            combo3.setEnabled(false);

        }
    }

    public void getRemainTime() throws IOException {
        int h1= combo1.getSelectedIndex();
        int hour=Integer.parseInt(s1[h1]);
        int m1= combo2.getSelectedIndex();
        int minute=Integer.parseInt(s2[m1]);
        int sc1= combo3.getSelectedIndex();
        int second=Integer.parseInt(s1[sc1]);
        remainTime = (hour-hour1)+"hour"+(minute-minute1)+"minute"+(second-second1)+"second";
        remain.setText(remainTime);
        if(hour==hour1&&minute==minute1&&second==second1)
        {
            System.out.println("time ok");
            combo1.setEnabled(true);
            combo2.setEnabled(true);
            combo3.setEnabled(true);
            remain.setText("time ok");
            JOptionPane.showMessageDialog(null," Time's up","alert",JOptionPane.ERROR_MESSAGE);
            InputStream in = new FileInputStream("src/ALARM.WAV");
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start();
        }
    }


    class UpdateTime extends TimerTask{

        @Override
        public void run() {
            GetClock();
            try {
                getRemainTime();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


