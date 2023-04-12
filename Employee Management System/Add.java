import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Add extends JFrame
{
Container c;
JLabel head, id, name, age, mobile, gender, salary, address;
JTextField txtid, txtname, txtage, txtmobile, txtsalary, txtaddress; 
JRadioButton male, female;
JButton btnsubmit, btnback;

Add(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.BLACK);

head=new JLabel("Employee Details");
head.setBounds(80,5,400,40);
head.setFont(new Font("Arial", Font.BOLD, 32));
head.setForeground(Color.GREEN);
c.add(head);

id=new JLabel("Id :");
id.setBounds(50,70,200,30);
id.setFont(new Font("Arial", Font.BOLD, 25));
id.setForeground(Color.BLUE);
c.add(id);

txtid=new JTextField(20);
txtid.setBounds(150,70,200,30);
txtid.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtid);

name=new JLabel("Name :");
name.setBounds(50,120,200,30);
name.setFont(new Font("Arial", Font.BOLD, 25));
name.setForeground(Color.BLUE);
c.add(name);

txtname=new JTextField(20);
txtname.setBounds(150,120,200,30);
txtname.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtname);

age=new JLabel("Age :");
age.setBounds(50,170,200,30);
age.setFont(new Font("Arial", Font.BOLD, 25));
age.setForeground(Color.BLUE);
c.add(age);

txtage=new JTextField(20);
txtage.setBounds(150,170,200,30);
txtage.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtage);

mobile=new JLabel("Mobile :");
mobile.setBounds(50,220,200,30);
mobile.setFont(new Font("Arial", Font.BOLD, 25));
mobile.setForeground(Color.BLUE);
c.add(mobile);

txtmobile=new JTextField(20);
txtmobile.setBounds(150,220,200,30);
txtmobile.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtmobile);

gender=new JLabel("Gender :");
gender.setBounds(50,270,200,30);
gender.setFont(new Font("Arial", Font.BOLD, 25));
gender.setForeground(Color.BLUE);
c.add(gender);

male=new JRadioButton("Male", true);
male.setBounds(160,270,80,30);
male.setFont(new Font("Arial", Font.BOLD, 25));
male.setForeground(Color.BLUE);
male.setBackground(Color.BLACK);
c.add(male);

female=new JRadioButton("Female");
female.setBounds(250,270,150,30);
female.setFont(new Font("Arial", Font.BOLD, 25));
female.setForeground(Color.BLUE);
female.setBackground(Color.BLACK);
c.add(female);

ButtonGroup bg=new ButtonGroup();
bg.add(male);
bg.add(female);

salary=new JLabel("Salary :");
salary.setBounds(50,320,200,30);
salary.setFont(new Font("Arial", Font.BOLD, 25));
salary.setForeground(Color.BLUE);
c.add(salary);

txtsalary=new JTextField(20);
txtsalary.setBounds(150,320,200,30);
txtsalary.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtsalary);

address=new JLabel("Address :");
address.setBounds(50,370,200,30);
address.setFont(new Font("Arial", Font.BOLD, 25));
address.setForeground(Color.BLUE);
c.add(address);

txtaddress=new JTextField(50);
txtaddress.setBounds(170,370,240,30);
txtaddress.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtaddress);

btnsubmit=new JButton("Submit");
btnsubmit.setBounds(100,440,200,30);
btnsubmit.setFont(new Font("Arial", Font.BOLD, 25));
btnsubmit.setForeground(Color.BLUE);
c.add(btnsubmit);

btnback=new JButton("Back");
btnback.setBounds(135,490,130,27);
btnback.setFont(new Font("Arial", Font.BOLD, 20));
btnback.setForeground(Color.BLUE);
c.add(btnback);

ActionListener a1 = (ae) -> { 
dispose();
Home h=new Home();
 };
btnback.addActionListener(a1);

ActionListener a2 = (ae) -> { 
int Id=Integer.parseInt(txtid.getText());
String Name=txtname.getText();
int Age=Integer.parseInt(txtage.getText());
String Mobile=txtmobile.getText();
String Gender="";
if(male.isSelected())		Gender="Male";
else if(female.isSelected())	Gender="Female";
String Salary=txtsalary.getText();
String Address=txtaddress.getText();

try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/employee";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);
String sql="insert into Emp_info values(?,?,?,?,?,?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1, Id);
pst.setString(2, Name);
pst.setInt(3, Age);
pst.setString(4, Mobile);
pst.setString(5, Gender);
pst.setString(6, Salary);
pst.setString(7,Address);
pst.executeUpdate();
JOptionPane.showMessageDialog(c,"Record Inserted Successfully...");
con.close();
dispose();
Home h=new Home();
}catch(SQLException e){
System.out.println("issue"+e);
}
 };
btnsubmit.addActionListener(a2);


setSize(450,600);
setLocationRelativeTo(null);
setTitle("add page...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
Add A=new Add();
}
}