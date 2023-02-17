import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Hostelmanagement extends JFrame implements ActionListener {
    Button b1, b2;
    Label l1, l2, l3, l4;
    TextField tf1, tf2, tf3;
    Image img;
    Toolkit tk;
    Connection con = null;
    Statement st = null;
    String name1 = null, pass1 = null;

    // ResultSet rs;
    Hostelmanagement() {
        setSize(1030, 500);
        setVisible(true);
        setLayout(null);

        tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("hms.png");

        l1 = new Label("LOGIN");
        l1.setBounds(210, 280, 55, 25);
        add(l1);

        l2 = new Label("Username:");
        l2.setBounds(150, 320, 65, 25);
        add(l2);

        l3 = new Label("Password:");
        l3.setBounds(150, 360, 65, 25);
        add(l3);

        tf1 = new TextField();
        tf1.setBounds(230, 320, 95, 25);
        add(tf1);

        tf2 = new TextField();
        tf2.setBounds(230, 360, 95, 25);
        add(tf2);

        b1 = new Button("Submit");
        b1.setBounds(180, 420, 55, 25);
        add(b1);
        b1.addActionListener(this);

        b2 = new Button("Close");
        b2.setBounds(250, 420, 55, 25);
        add(b2);
        b2.addActionListener(this);

        l4 = new Label("Wrong Password!");
        l4.setBounds(175, 390, 110, 25);
        Font myFont = new Font("Serif", Font.ITALIC, 12);
        l4.setFont(myFont);
        l4.setForeground(Color.red);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == b1) {
                int i = 0;
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "sweta");
                System.out.println("Database connected");
                st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from register");
                while (rs.next()) {
                    String n = tf1.getText();
                    String p = tf2.getText();
                    name1 = rs.getString(1);
                    pass1 = rs.getString(2);
                    if (name1.equals(n) && pass1.equals(p)) {
                        dispose();
                        new Dialog();
                        i++;
                    }

                }
                if (i == 0) {
                    add(l4);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        if (e.getSource() == b2) {
            dispose();
        }

    }

    public void paint(Graphics g) {
        g.drawImage(img, -10, 0, this);
    }

    public static void main(String args[]) {
        new Hostelmanagement();
    }
}