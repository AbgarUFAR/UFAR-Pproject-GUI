package view;

import static constant.CommonConstants.APPLICATION_NAME;
import static constant.CommonConstants.DEFAULT_FRAME_HEIGHT;
import static constant.CommonConstants.DEFAULT_FRAME_WIDTH;
import static constant.FrameConstraints.EMPLOYEE_DETAILS;
import static constant.FrameConstraints.SIGN_IN_PAGE;

import controller.AdminController;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import lombok.Getter;

@Getter
public class MainFrame extends JFrame {

    private final CardLayout cardLayout = new CardLayout();
    final SignInPage signInPage = new SignInPage();

    public MainFrame() throws HeadlessException {
        super(APPLICATION_NAME);
        setLayout(cardLayout);

        final var employeeDetails = new EmployeeDetails();
        add(signInPage, SIGN_IN_PAGE);
        add(employeeDetails, EMPLOYEE_DETAILS);

        signInPage.viewEmployees(event -> AdminController.signIn(this));

        setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
