package view;

import static constant.CommonConstants.DEFAULT_COLUMN_LENGTH;
import static constant.CommonConstants.defaultButtonDimension;
import static java.awt.GridBagConstraints.NONE;
import static java.awt.GridBagConstraints.WEST;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import lombok.Getter;

public class SignInPage extends Panel {

    @Getter
    private final JTextField idField = new JTextField(DEFAULT_COLUMN_LENGTH);
    @Getter
    private final JPasswordField passwordField = new JPasswordField(DEFAULT_COLUMN_LENGTH);

    private final JButton signInButton = new JButton("sign in");

    public SignInPage() {
        final var idLabel = new JLabel("id");
        final var passwordLabel = new JLabel("password");

        signInButton.setPreferredSize(defaultButtonDimension);

        final var fieldsInset = new Insets(0, 0, 10, 0);
        final var buttonInset = new Insets(20, 0, 0, 0);

        setLayout(new GridBagLayout());
        final var gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = WEST;

        add(idLabel, gridBagConstraints);

        gridBagConstraints.gridy = 1;

        add(idField, gridBagConstraints);

        gridBagConstraints.gridy = 2;

        add(passwordLabel, gridBagConstraints);

        gridBagConstraints.gridy = 3;

        add(passwordField, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;
        add(signInButton, gridBagConstraints);
    }

    public void viewEmployees(ActionListener actionListener) {
//        final var password = new String(passwordField.getPassword());
//        System.out.println(password);
//        final var requestBody = new LoginRequest(idField.getText(), password);
//        final Pair<Integer, String> response = RestService.sendPostRequest("admin", toJson(requestBody));
//        if (response == null) {
//            System.out.println("something went wrong");
//            return;
//        }
//
//        final int responseStatusCode = response.getKey();
//        final String responseBody = response.getValue();
//        if (responseStatusCode == 200) {
//            signInButton.addActionListener(actionListener);
//        } else {
//            System.out.println("login or password was wrong");
//        }
        signInButton.addActionListener(actionListener);
    }
}
