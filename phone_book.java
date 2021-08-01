
import javax.swing.*;  
import java.awt.event.*;
import java.sql.*;

public class phone_book {
	JRadioButton rb1, rb2; 
    JButton btn; 
    JTextField txtName, txtSurname, txtPhoneNumber; 
    JLabel label1, label2, label3, label4, label5; 
    
    phone_book(){
        
        JFrame mainFrame = new JFrame("PHONE BOOK");
        
        label1 = new JLabel("Name: "); 
        label1.setBounds(70,40,100,30);
        mainFrame.add(label1);
        label1.setVisible(true);
        label2 = new JLabel("Surname: "); 
        label2.setBounds(50,70,100,30);
        mainFrame.add(label2);
        label2.setVisible(true);
        label3 = new JLabel("Phone Number: ");
        label3.setBounds(20,100,100,30);
        mainFrame.add(label3);
        label3.setVisible(true);
        label4 = new JLabel("City: ");
        label4.setBounds(83,130,100,30);
        mainFrame.add(label4);
        label4.setVisible(true);
        label5 = new JLabel("Gender: ");
        label5.setBounds(63,160,100,30);
        mainFrame.add(label5);
        label5.setVisible(true);
        
        txtName = new JTextField(); 
        txtName.setBounds(120,45,180,20);
        mainFrame.add(txtName);
        txtName.setVisible(true);
        
        txtSurname = new JTextField(); 
        txtSurname.setBounds(120,75,180,20);
        mainFrame.add(txtSurname);
        txtSurname.setVisible(true);
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(120,105,180,20);
        mainFrame.add(txtPhoneNumber);
        txtPhoneNumber.setVisible(true);
        
        String citylist[] = {"Ýstanbul","Ankara","Ýzmir","Eskiþehir"};
        JComboBox cb = new JComboBox(citylist);
        cb.setSelectedIndex(1);
        cb.setBounds(120,135,176,20);
        cb.setVisible(true);
        
        rb1 = new JRadioButton("Male");
        rb1.setBounds(130, 165, 60, 20);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(200, 165, 80, 20);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1); bg.add(rb2);
        
        btn = new JButton("Save");
        btn.setBounds(135,210,140,25);
        
        mainFrame.add(rb1); 
        mainFrame.add(rb2);  
        mainFrame.add(btn); 
        mainFrame.add(cb);
        
        mainFrame.setSize(360,380);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String s1 = txtName.getText();
                String s2 = txtSurname.getText();
                String s3 = txtPhoneNumber.getText();
                String s4 = " " + cb.getItemAt(cb.getSelectedIndex());
                
                String s5 = "Male";
            	if(rb2.isSelected()){
            		s5 = "Female";
            	} 
                
                String sql_sorgu = "INSERT INTO contacts(name,surname,phone_num,city,gender) VALUES('" +s1+ "','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
		
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","cancer98");
                    Statement myStat = conn.createStatement();
                    myStat.executeUpdate(sql_sorgu);
                    JOptionPane.showMessageDialog(mainFrame, "Saving succesfull.");
                }
                catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    
    }
    
    
    public static void main(String[] args) { 
        new phone_book();
    }
}
