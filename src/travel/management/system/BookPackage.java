
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JLabel labelUsername, labelId, labelNumber, labelPhone;
    JTextField tfPersons;
    JButton checkPrice, bookPackage, back;

    String username;

    BookPackage(String username) {
        this.username = username;
        setBounds(300, 150, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("BOOK PACKAGE");
        lblTitle.setBounds(100, 10, 300, 30);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblTitle);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(40, 70, 100, 30);
        add(lblUser);

        labelUsername = new JLabel(username);
        labelUsername.setBounds(250, 70, 200, 30);
        add(labelUsername);

        JLabel lblPackage = new JLabel("Select Package:");
        lblPackage.setBounds(40, 110, 150, 30);
        add(lblPackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 30);
        add(cpackage);

        JLabel lblPersons = new JLabel("Total Persons:");
        lblPersons.setBounds(40, 150, 150, 30);
        add(lblPersons);

        tfPersons = new JTextField("1");
        tfPersons.setBounds(250, 150, 200, 30);
        add(tfPersons);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(40, 190, 150, 30);
        add(lblId);

        labelId = new JLabel("ID1234");
        labelId.setBounds(250, 190, 200, 30);
        add(labelId);

        JLabel lblNumber = new JLabel("Number:");
        lblNumber.setBounds(40, 230, 150, 30);
        add(lblNumber);

        labelNumber = new JLabel("1234567890");
        labelNumber.setBounds(250, 230, 200, 30);
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(40, 270, 150, 30);
        add(lblPhone);

        labelPhone = new JLabel("9876543210");
        labelPhone.setBounds(250, 270, 200, 30);
        add(labelPhone);

        JLabel lblTotal = new JLabel("Total Price:");
        lblTotal.setBounds(40, 310, 150, 30);
        add(lblTotal);

        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(250, 310, 200, 30);
        labelPrice.setForeground(Color.RED);
        add(labelPrice);

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(60, 380, 120, 30);
        checkPrice.addActionListener(e -> {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) cost = 12000;
            else if (pack.equals("Silver Package")) cost = 25000;
            else if (pack.equals("Bronze Package")) cost = 32000;

            int persons = Integer.parseInt(tfPersons.getText());
            int total = cost * persons;

            labelPrice.setText("Rs " + total);
        });
        add(checkPrice);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(200, 380, 140, 30);
        bookPackage.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Package booked successfully!");
        });
        add(bookPackage);

        back = new JButton("Back");
        back.setBounds(360, 380, 100, 30);
        back.addActionListener(e -> setVisible(false));
        add(back);

        // Add right side image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblImg = new JLabel(i3);
        lblImg.setBounds(500, 100, 400, 300);
        add(lblImg);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Already handled via lambdas
    }

    public static void main(String[] args) {
        new BookPackage("demoUser");
    }
}
