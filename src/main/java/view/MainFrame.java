package view;

import static constant.CommonConstants.APPLICATION_NAME;
import static constant.CommonConstants.DEFAULT_FRAME_HEIGHT;
import static constant.CommonConstants.DEFAULT_FRAME_WIDTH;
import static constant.FrameConstraints.SIGN_IN_PAGE;

import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        super(APPLICATION_NAME);
        final var cardLayout = new CardLayout();
        setLayout(cardLayout);

        final var signInPage = new SignInPage();
        add(signInPage, SIGN_IN_PAGE);

        setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
