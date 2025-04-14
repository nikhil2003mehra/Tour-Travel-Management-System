
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BookHotel extends JFrame implements  ActionListener
{
    private JPanel contentPane;
    JTextField tfUsername, tfPersons, tfDays, tfId, tfNumber, tfPhone;
    Choice cHotel, cAc, cFood;
    JLabel lblTotalPrice;

    public BookHotel(String username)
    {
        setBounds(420, 220, 1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("BOOK HOTEL");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(118, 11, 300, 53);
        contentPane.add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(35, 70, 100, 24);
        contentPane.add(lblUsername);

        tfUsername = new JTextField(username);
        tfUsername.setBounds(271, 70, 200, 20);
        contentPane.add(tfUsername);

        JLabel lblHotel = new JLabel("Select Hotel:");
        lblHotel.setBounds(35, 110, 200, 14);
        contentPane.add(lblHotel);

        cHotel = new Choice();
        cHotel.add("");
        cHotel.add("The Taj Hotel");
        cHotel.add("Hotel Merryot");
        cHotel.add("Hotel Indore");
        cHotel.add("Hotel Mombai");
        cHotel.add("Hotel Amrat");
        cHotel.add("Hotel Veshanav");
        cHotel.setBounds(271, 110, 150, 30);
        contentPane.add(cHotel);

        JLabel lblPersons = new JLabel("Total Persons:");
        lblPersons.setBounds(35, 150, 200, 14);
        contentPane.add(lblPersons);

        tfPersons = new JTextField("0");
        tfPersons.setBounds(271, 150, 150, 20);
        contentPane.add(tfPersons);

        JLabel lblDays = new JLabel("Number of Days:");
        lblDays.setBounds(35, 190, 200, 14);
        contentPane.add(lblDays);

        tfDays = new JTextField("0");
        tfDays.setBounds(271, 190, 150, 20);
        contentPane.add(tfDays);

        JLabel lblAc = new JLabel("AC / Non-AC:");
        lblAc.setBounds(35, 230, 200, 14);
        contentPane.add(lblAc);

        cAc = new Choice();
        cAc.add("AC");
        cAc.add("Non-AC");
        cAc.setBounds(271, 230, 150, 30);
        contentPane.add(cAc);

        JLabel lblFood = new JLabel("Food Included:");
        lblFood.setBounds(35, 270, 200, 14);
        contentPane.add(lblFood);

        cFood = new Choice();
        cFood.add("Yes");
        cFood.add("No");
        cFood.setBounds(271, 270, 150, 30);
        contentPane.add(cFood);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(35, 310, 200, 14);
        contentPane.add(lblId);

        tfId = new JTextField();
        tfId.setBounds(271, 310, 150, 20);
        contentPane.add(tfId);

        JLabel lblNumber = new JLabel("Number:");
        lblNumber.setBounds(35, 350, 200, 14);
        contentPane.add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(271, 350, 150, 20);
        contentPane.add(tfNumber);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(35, 390, 200, 14);
        contentPane.add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(271, 390, 150, 20);
        contentPane.add(tfPhone);

        JLabel lblPrice = new JLabel("Total Price:");
        lblPrice.setBounds(35, 430, 200, 14);
        contentPane.add(lblPrice);

        lblTotalPrice = new JLabel();
        lblTotalPrice.setBounds(271, 430, 200, 14);
        lblTotalPrice.setForeground(Color.RED);
        contentPane.add(lblTotalPrice);

        JButton btnCheckPrice = new JButton("Check Price");
        btnCheckPrice.setBounds(50, 470, 120, 30);
        btnCheckPrice.setBackground(Color.BLACK);
        btnCheckPrice.setForeground(Color.WHITE);
        contentPane.add(btnCheckPrice);

        btnCheckPrice.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try {
                    Conn c = new Conn();
                    String hotel = cHotel.getSelectedItem();
                    String query = "select * from hotels where name = '" + hotel + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        int costPerDay = Integer.parseInt(rs.getString("cost_per_day"));
                        int foodCharges = Integer.parseInt(rs.getString("food_charges"));
                        int acCharges = Integer.parseInt(rs.getString("ac_charges"));

                        int persons = Integer.parseInt(tfPersons.getText());
                        int days = Integer.parseInt(tfDays.getText());

                        String acSelected = cAc.getSelectedItem();
                        String foodSelected = cFood.getSelectedItem();

                        if (persons > 0 && days > 0) {
                            int total = costPerDay;
                            total += acSelected.equals("AC") ? acCharges : 0;
                            total += foodSelected.equals("Yes") ? foodCharges : 0;
                            total *= persons * days;

                            lblTotalPrice.setText("Rs " + total);
                        } else {
                            lblTotalPrice.setText("Enter valid numbers");
                        }
                    }
                } catch (Exception ex) {
                    lblTotalPrice.setText("Error: " + ex.getMessage());
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(350, 470, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> setVisible(false));

        // Hotel Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        imgLabel.setBounds(550, 100, 500, 300);
        contentPane.add(imgLabel);


        setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new BookHotel("").setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        new BookHotel("");
        try
        {

            new BookHotel("");
        }
        catch (Exception ae)
        {
            ae.printStackTrace();
        }
    }
}

