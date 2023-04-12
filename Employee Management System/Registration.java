import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Registration extends JFrame
{
Container c;
JLabel Head, name, age, mobile,email, address, username, password;
JTextField txtname, txtage, txtmobile, txtemail, txtaddress, txtusername, txtpassword;
JButton btnSubmit, btnlogin;

Registration(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.BLACK);

Head=new JLabel("Registration Form");
Head.setBounds(56,10,600,40);
Head.setFont(new Font("Arial", Font.BOLD, 35));
Head.setForeground(Color.GREEN);
c.add(Head);

name=new JLabel("Name :");
name.setBounds(50,90,200,30);
name.setFont(new Font("Arial", Font.BOLD, 25));
name.setForeground(Color.BLUE);
c.add(name);

txtname=new JTextField(40);
txtname.setBounds(150,90,200,30);
txtname.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtname);

age=new JLabel("Age :");
age.setBounds(50,140,200,30);
age.setFont(new Font("Arial", Font.BOLD, 25));
age.setForeground(Color.BLUE);
c.add(age);

txtage=new JTextField(40);
txtage.setBounds(150,140,200,30);
txtage.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtage);

mobile=new JLabel("Mobile :");
mobile.setBounds(50,190,200,30);
mobile.setFont(new Font("Arial", Font.BOLD, 25));
mobile.setForeground(Color.BLUE);
c.add(mobile);

txtmobile=new JTextField(40);
txtmobile.setBounds(150,190,200,30);
txtmobile.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtmobile);

email=new JLabel("Email :");
email.setBounds(50,240,200,30);
email.setFont(new Font("Arial", Font.BOLD, 25));
email.setForeground(Color.BLUE);
c.add(email);

txtemail=new JTextField(40);
txtemail.setBounds(150,240,200,30);
txtemail.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtemail);

address=new JLabel("Address :");
address.setBounds(50,290,200,30);
address.setFont(new Font("Arial", Font.BOLD, 25));
address.setForeground(Color.BLUE);
c.add(address);

txtaddress=new JTextField(40);
txtaddress.setBounds(165,290,230,30);
txtaddress.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtaddress);

username=new JLabel("Username :");
username.setBounds(50,340,200,30);
username.setFont(new Font("Arial", Font.BOLD, 25));
username.setForeground(Color.BLUE);
c.add(username);

txtusername=new JTextField(40);
txtusername.setBounds(190,340,200,30);
txtusername.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtusername);

password=new JLabel("Password :");
password.setBounds(50,390,200,30);
password.setFont(new Font("Arial", Font.BOLD, 25));
password.setForeground(Color.BLUE);
c.add(password);

txtpassword=new JTextField(40);
txtpassword.setBounds(190,390,200,30);
txtpassword.setFont(new Font("Arial", Font.PLAIN,20));
c.add(txtpassword);

btnSubmit=new JButton("Submit");
btnSubmit.setBounds(100,450,200,30);
btnSubmit.setFont(new Font("Arial", Font.BOLD, 25));
btnSubmit.setForeground(Color.BLUE);
c.add(btnSubmit);

btnlogin=new JButton("click here to login...");
btnlogin.setBounds(50,490,300,30);
btnlogin.setFont(new Font("Arial", Font.BOLD, 20));
btnlogin.setForeground(Color.BLUE);
btnlogin.setBackground(Color.BLACK);
c.add(btnlogin);

ActionListener a = (ae) -> { 
dispose();
Login l=new Login();
 };
btnlogin.addActionListener(a);


ActionListener a1 = (ae) -> { 
String Name=txtname.getText();
int Age=Integer.parseInt(txtage.getText());
String Mobile=txtmobile.getText();
String Email=txtemail.getText();
String Address=txtaddress.getText();
String Username=txtusername.getText();
String Password=txtpassword.getText();

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/Employee";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);
String sql="insert into registration values(?,?,?,?,?,?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1, Name);
pst.setInt(2, Age);
pst.setString(3, Mobile);
pst.setString(4, Email);
pst.setString(5, Address);
pst.setString(6, Username);
pst.setString(7, Password);
pst.executeUpdate();
JOptionPane.showMessageDialog(c,"Registration Complete Successfully...");
con.close();

dispose();
Login l=new Login();

}catch(SQLException e){
System.out.println("issue"+e);
}
 };
btnSubmit.addActionListener(a1);



setSize(430,600);
setLocationRelativeTo(null);
setTitle("registration page...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
Registration r=new Registration();
}
}