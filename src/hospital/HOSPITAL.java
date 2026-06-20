package hospital;
import java.awt.*;
import java.awt.event.*;
public class HOSPITAL extends Frame implements ActionListener {

Image bgImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\01100\\Documents\\NetBeansProjects\\HOSPITAL\\src\\hospital\\a1.jpg ");
@Override
public void paint(Graphics g) {
   
    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(),this); 
    super.paint(g);}

    Frame loginFrame = this;
    
    Label loginError = new Label("Invalid username or password.", Label.CENTER);
    TextField usernameField = new TextField();
    TextField passwordField = new TextField();
    Button loginButton = new Button("Login");
    Button exitButton = new Button("Exit");
    public HOSPITAL() {
        setTitle("Hospital login");
        setupLoginFrame();
    }

    private void setupLoginFrame() {
        loginFrame.setLayout(null);

        Label userLabel = new Label("Username:");
        userLabel.setBounds(50, 100, 80, 30);
        loginFrame.add(userLabel);

        usernameField.setBounds(150, 100, 200, 30);
        loginFrame.add(usernameField);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50, 150, 80, 30);
        loginFrame.add(passLabel);

        passwordField.setBounds(150, 150, 200, 30);
        passwordField.setEchoChar('*');
        loginFrame.add(passwordField);

        loginButton.setBounds(80, 220, 100, 40);
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.WHITE);
        loginFrame.add(loginButton);

        exitButton.setBounds(220, 220, 100, 40);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        loginFrame.add(exitButton);

        loginError.setForeground(Color.RED);
        loginError.setBounds(50, 50, 300, 300);
        loginError.setVisible(false);
        loginFrame.add(loginError);

        loginFrame.setSize(400, 400);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public static void main(String[] args) {
        CONICTAION.ConnectToSQL();
        new HOSPITAL();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = usernameField.getText();
            String pass = passwordField.getText();

            if ("amr".equals(user) && "asd".equals(pass)) {
                loginError.setVisible(false);
                loginFrame.setVisible(false);
                
                role r = new role();
                r.setVisible(true);
                this.dispose();
            } else {
                loginError.setVisible(true);
                usernameField.setText("");
                passwordField.setText("");
            }
        }
        if (e.getSource() == exitButton) {
            loginFrame.dispose();
        }
    }
}
