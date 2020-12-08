import java.awt.*;
import java.math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

import static java.lang.Math.*;

@SuppressWarnings("serial")
// Главный класс приложения, он же класс фрейма
class MainFrame extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 250;
    // Текстовые поля для считывания значений переменных,
    // как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    // Текстовое поле для отображения результата,
    // как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    public double sum = 0;
    public JTextField TEMP4;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;

    // Формула 2 для расчета

    // Формула №1 для рассчѐта
    public Double Formula_1(double x, double y, double z) {
        if (y <= 0 || x == 0) {
            JOptionPane.showMessageDialog(MainFrame.this, "Под корнем отрицательное число ",
                    "Проверьте введенные данные", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        } else {
            return (pow(log(pow((1 + x), 2)) + cos(pow(z, 3) * PI), sin(y))
                    + pow(exp(pow(x, 2)) + cos(exp(z)) + sqrt(1 / y), 1 / x));
        }

    }

    public Double Formula_2(double x, double y, double z) {
        int u = (int) x;
        u %= 2;
        if (x == 1 && z == 1) {
            return pow(cos(pow(y, 2)), 3);
        }
        if (z == 0 || x == 0 || (u < 0 && z < 0)) {
            JOptionPane.showMessageDialog(MainFrame.this, "Под корнем отрицательное число ",
                    "Проверьте введенные данные", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        } else {
            return (x * pow(cos(pow(y, 2)), 3) / pow(z, 1 / x));
        }
    }
}

public class Lab_2 {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
