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

    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    // Конструктор класса
    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());

        // Создать область с полями ввода для X Y Z
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();

        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

        // Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
        // labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        textFieldResult.setEditable(false);
        hboxResult.add(Box.createHorizontalGlue());
        // Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldY.getText());
                    Double result;
                    if (formulaId == 1)
                        result = Formula_1(x, y, z);
                    else
                        result = Formula_2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой",
                            "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        // Создание кнопку МС
        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                TEMP4.setText("0");
                textFieldResult.setText("0");
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
            }
        });

        // Создать кнопку М+
        JButton buttonM = new JButton("M+");
        buttonM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                double temp2 = 0;
                try {
                    String temp = textFieldResult.getText();
                    if (temp.isEmpty()) {
                        throw new IOException("incorrect format");
                    }
                    temp2 = Double.valueOf(temp);
                } catch (IOException e) {
                    System.out.println("Please enter numbers");
                }
                sum = sum + temp2;

                String temp3 = Double.toString(sum);
                TEMP4.setText(temp3);
            }
        });
        // coздание коробки для м-кнопок
        Box hboxMButtons = Box.createHorizontalBox();
        hboxMButtons.add(Box.createHorizontalGlue());
        hboxMButtons.add(buttonMC);
        hboxMButtons.add(Box.createHorizontalStrut(30));
        hboxMButtons.add(buttonM);
        hboxMButtons.add(Box.createHorizontalGlue());
        // создание вывода sum
        JLabel labelforsum = new JLabel("sum:");
        TEMP4 = new JTextField("0", 10);
        TEMP4.setMaximumSize(TEMP4.getPreferredSize());
        Box hboxTEMP = Box.createHorizontalBox();
        hboxTEMP.add(Box.createHorizontalGlue());
        hboxTEMP.add(labelforsum);
        hboxTEMP.add(Box.createHorizontalStrut(10));
        hboxTEMP.add(TEMP4);
        TEMP4.setEditable(false);
        hboxTEMP.add(Box.createHorizontalGlue());

        // Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(hboxMButtons);
        contentBox.add(hboxTEMP);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
}

public class Lab_2 {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
