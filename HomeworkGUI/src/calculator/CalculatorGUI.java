package calculator;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private final int WIDTH = 396;
    private final int HEIGHT = 180;
    public final static String INPUT_NUM = "Введите число";

    private JPanel panelFields;
    private JPanel panelButtons;
    private JPanel panelResult;
    private JPanel panelSkin;
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField field1;
    private JTextField field2;
    private JTextField fieldResult;

    private JMenu menu;

    private JMenuItem skin1;
    private JMenuItem skin2;
    private JMenuItem skin3;
    private JMenuItem skin4;
    private JMenuItem skin5;
    private JMenuItem skin6;

    public CalculatorGUI() {
        try {
            UIManager.setLookAndFeel(new HiFiLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setDefaultLookAndFeelDecorated(true);
        setSize(WIDTH, HEIGHT);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        panelFields = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        createFields(10);
        panelFields.add(label1);
        panelFields.add(field1);
        panelFields.add(label2);
        panelFields.add(field2);
        getContentPane().add(panelFields, BorderLayout.NORTH);

        panelButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 15));
        createButton();
        panelButtons.add(addition);
        panelButtons.add(subtraction);
        panelButtons.add(multiplication);
        panelButtons.add(division);
        getContentPane().add(panelButtons, BorderLayout.CENTER);

        panelResult = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 15));
        createFields(15);
        panelResult.add(label3);
        panelResult.add(fieldResult);
        getContentPane().add(panelResult, BorderLayout.SOUTH);

        panelSkin = new JPanel();
        BoxLayout layout = new BoxLayout(panelSkin, BoxLayout.Y_AXIS);
        panelSkin.setLayout(layout);
        getContentPane().add(panelSkin, BorderLayout.EAST);

        createMenu();

        setVisible(true);
    }

    public void createButton() {
        MyActionListener listener = new MyActionListener(this, field1, field2);
        addition = new JButton("Сложение");
        addition.addActionListener(listener);
        subtraction = new JButton("Вычитание");
        subtraction.addActionListener(listener);
        multiplication = new JButton("Умножение");
        multiplication.addActionListener(listener);
        division = new JButton(" Деление ");
        division.addActionListener(listener);
    }

    public void createFields(int column) {
        Font font = new Font("ARIALUNI", 3, 10);
        label1 = new JLabel("Число1: ");
        field1 = new JTextField(INPUT_NUM, column);
        field1.setFont(font);
        field1.addFocusListener(new MyFocusListener(field1));
        label2 = new JLabel("Число2: ");
        field2 = new JTextField(INPUT_NUM, column);
        field2.setFont(font);
        field2.addFocusListener(new MyFocusListener(field2));

        label3 = new JLabel("Результат: ");
        fieldResult = new JTextField(column);
        fieldResult.setEditable(false);
        fieldResult.setFocusable(false);
    }

    public void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("Вид");
        skin1 = new JMenuItem("AeroLook");
        skin1.addActionListener(new MenuActionListener(this, new AeroLookAndFeel()));
        skin2 = new JMenuItem("GraphiteLook");
        skin2.addActionListener(new MenuActionListener(this, new GraphiteLookAndFeel()));
        skin3 = new JMenuItem("AcryLook");
        skin3.addActionListener(new MenuActionListener(this, new AcrylLookAndFeel()));
        skin4 = new JMenuItem("MintLook");
        skin4.addActionListener(new MenuActionListener(this, new MintLookAndFeel()));
        skin5 = new JMenuItem("NoireLook");
        skin5.addActionListener(new MenuActionListener(this, new NoireLookAndFeel()));
        skin6 = new JMenuItem("HiFiLook");
        skin6.addActionListener(new MenuActionListener(this, new HiFiLookAndFeel()));
        menu.add(skin1);
        menu.add(skin2);
        menu.addSeparator();
        menu.add(skin3);
        menu.add(skin4);
        menu.addSeparator();
        menu.add(skin5);
        menu.add(skin6);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void setFieldResult(String str) {
        fieldResult.setText(str);
    }
}
