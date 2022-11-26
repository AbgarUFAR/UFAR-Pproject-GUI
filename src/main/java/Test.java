import static javax.swing.SwingUtilities.invokeLater;

import view.MainFrame;

public class Test {
    public static void main(String[] args) {
        invokeLater(MainFrame::new);
    }
}
