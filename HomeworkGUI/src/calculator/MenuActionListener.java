package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener implements ActionListener {
    private JFrame frame;
    private LookAndFeel laf;

    public MenuActionListener(JFrame frame, LookAndFeel laf) {
        this.frame = frame;
        this.laf = laf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException c) {
            c.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
}

