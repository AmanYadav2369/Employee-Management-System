import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class View extends JFrame
{
Container c;
JLabel head;
TextArea toData;
JButton btnUpdate, btnRemove, btnBack;

View(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.BLACK);

head=new JLabel("Employee Records...");
head.setBounds(260,0,600,40);
head.setFont(new Font("Arial", Font.BOLD, 35));
head.setForeground(Color.GREEN);
c.add(head);

btnUpdate=new JButton("Update Employees.");
btnUpdate.setBounds(100,74,195,25);
btnUpdate.setFont(new Font("Arial", Font.PLAIN, 17));
btnUpdate.setForeground(Color.BLUE);
btnUpdate.setBackground(Color.WHITE);
c.add(btnUpdate);


btnRemove=new JButton("Remove Employees.");
btnRemove.setBounds(310,74,195,25);
btnRemove.setFont(new Font("Arial", Font.PLAIN, 17));
btnRemove.setForeground(Color.BLUE);
btnRemove.setBackground(Color.WHITE);
c.add(btnRemove);

toData=new TextArea(8,5);
toData.setBounds(22, 100 , 840, 380);
toData.setFont(new Font("Arial", Font.PLAIN, 16));
c.add(toData);

btnBack=new JButton("<<Back>>");
btnBack.setBounds(300,520,200,30);
btnBack.setFont(new Font("Arial", Font.BOLD, 25));
btnBack.setForeground(Color.BLUE);
btnBack.setBackground(Color.WHITE);
c.add(btnBack);

ActionListener a1 = (ae) -> { 
dispose();
Home h=new Home();
 };
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> { 
dispose();
Update u=new Update();
 };
btnUpdate.addActionListener(a2);

ActionListener a3 = (ae) -> { 
dispose();
Remove r=new Remove();
 };
btnRemove.addActionListener(a3);


String data="";
try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/employee";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);
String sql="select*from Emp_info";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
data=data+"Id="+rs.getInt(1)+"   "+"Name="+rs.getString(2)+"          "+"Age="+rs.getInt(3)+"   "+ "Mobile="+rs.getString(4)+"     "+"Gender="+rs.getString(5)+"     "+"Salary="+rs.getString(6)+"     "+"Address="+rs.getString(7)+ "\n" ;
toData.setText(data);
rs.close();
con.close();
}catch(SQLException e){
JOptionPane.showMessageDialog(c, "issue"+e);
}

setSize(900,600);
setLocationRelativeTo(null);
setTitle("view page...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
View v=new View();
}
}