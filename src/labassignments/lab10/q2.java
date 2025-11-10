package labassignments.lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class q2 extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JButton add, sub, mul, div;

    q2() {
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");

        add(add); add(sub); add(mul); add(div);

        JPanel p = new JPanel();
        p.add(new JLabel("Num 1:"));
        p.add(t1);
        p.add(new JLabel("Num 2:"));
        p.add(t2);
        p.add(new JLabel("Result:"));
        p.add(t3);
        p.add(add);
        p.add(sub);
        p.add(mul);
        p.add(div);

        add(p);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double res = 0;

        if (e.getSource() == add)
            res = a + b;
        else if (e.getSource() == sub)
            res = a - b;
        else if (e.getSource() == mul)
            res = a * b;
        else if (e.getSource() == div)
            res = a / b;

        t3.setText(String.valueOf(res));
    }

    public static void main(String[] args) {
        new q2();
    }
}