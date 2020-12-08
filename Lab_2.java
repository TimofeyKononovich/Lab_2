import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class schet {
    private double sum = 0;

    schet() {
        System.out.println("Инициализирован счетчик суммы");
    }

    public void clear() {
        this.sum = 0;
    }

    public void plus(double sum) {
        this.sum += sum;
    }
}

class actioncalculate extends ActionEvent {
    actioncalculate(){
         super(JButton check, ,getActionCommand()){}
     }
}

public class Lab_2 {
    public static void main(String[] args) {
        schet one=new schet();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        JButton[] massive = new JButton[13];
        JButton.addActionListener(new ActionListener()){
            public void actionPerformed(actioncalculate e){
                one.clear();
            }
        }
        massive[0]=new JButton();
        frame.setVisible(true);
    }
}
