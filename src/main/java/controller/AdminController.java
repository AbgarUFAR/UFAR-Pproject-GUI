package controller;

import static constant.FrameConstraints.EMPLOYEE_DETAILS;
import static utility.JsonUtility.fromJson;
import static utility.JsonUtility.toJson;

import dto.request.LoginRequest;
import dto.response.ErrorResponse;
import dto.response.LoginResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.RestService;
import utility.Pair;
import view.MainFrame;

public class AdminController {

    public static void signIn(MainFrame frame) {
        final var password = new String(frame.getSignInPage().getPasswordField().getPassword());
        System.out.println(password);
        final var requestBody = new LoginRequest(frame.getSignInPage().getIdField().getText(), password);
        final Pair<Integer, String> response = RestService.sendPostRequest("admin", toJson(requestBody));
        if (response == null) {
            System.out.println("something went wrong");
            return;
        }

        final int responseStatusCode = response.getKey();
        final String responseBody = response.getValue();
        if (responseStatusCode == 200) {
            final LoginResponse successResponse = fromJson(responseBody, LoginResponse.class);
            System.out.println(successResponse);
            System.out.println("Success");
            frame.getCardLayout().show(frame.getContentPane(), EMPLOYEE_DETAILS);
        } else {
            final ErrorResponse errorResponse = fromJson(responseBody, ErrorResponse.class);
            System.out.println(errorResponse);
            JOptionPane.showMessageDialog(
                new JFrame(), errorResponse.getErrorMessage(),
                errorResponse.getStatus().toString(),
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
