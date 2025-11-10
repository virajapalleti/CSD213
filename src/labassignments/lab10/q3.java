package labassignments.lab10;
import javax.swing.*;
import java.awt.*;

public class q3 extends JFrame {
    q3() {
        setTitle("Checkerboard");
        setSize(400, 400);
        setLayout(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel box = new JPanel();
                if ((row + col) % 2 == 0)
                    box.setBackground(Color.white);
                else
                    box.setBackground(Color.black);
                add(box);
            }
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new q3();
    }
}
