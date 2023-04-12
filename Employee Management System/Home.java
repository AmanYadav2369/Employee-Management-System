import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Home extends JFrame
{
Container c;
JLabel head;
JButton btnAdd, btnView, btnUpdate, btnRemove, btnLogout;

Home(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.BLACK);

head=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
head.setBounds(120,5,700,40);
head.setFont(new Font("Arial", Font.BOLD, 35));
head.setForeground(Color.GREEN);
c.add(head);

ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("icons/10.jpg"));
JLabel image=new JLabel(i1);
image.setBounds(0, 50, 888,498);
c.add(image);

btnAdd=new JButton("Add Employees");
btnAdd.setBounds(207,110,220,40);
btnAdd.setFont(new Font("Arial", Font.BOLD, 25));
btnAdd.setForeground(Color.GREEN);
btnAdd.setBackground(Color.BLACK);
image.add(btnAdd);

btnView=new JButton("View Employees");
btnView.setBounds(450,110,240,40);
btnView.setFont(new Font("Arial", Font.BOLD, 25));
btnView.setForeground(Color.GREEN);
btnView.setBackground(Color.BLACK);
image.add(btnView);

btnUpdate=new JButton("Update Employees");
btnUpdate.setBounds(330,170,260,40);
btnUpdate.setFont(new Font("Arial", Font.BOLD, 25));
btnUpdate.setForeground(Color.GREEN);
btnUpdate.setBackground(Color.BLACK);
image.add(btnUpdate);

btnRemove=new JButton("Remove Employees");
btnRemove.setBounds(320,230,280,40);
btnRemove.setFont(new Font("Arial", Font.BOLD, 25));
btnRemove.setForeground(Color.GREEN);
btnRemove.setBackground(Color.BLACK);
image.add(btnRemove);

btnLogout=new JButton("Logout..");
btnLogout.setBounds(360,447,196,30);
btnLogout.setFont(new Font("Arial", Font.BOLD, 20));
btnLogout.setForeground(Color.GREEN);
btnLogout.setBackground(Color.BLACK);
image.add(btnLogout);

ActionListener a = (ae) -> { dispose(); };
btnLogout.addActionListener(a);

ActionListener a1 = (ae) -> { 
dispose();
Add A=new Add();
 };
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> { 
dispose();
View v=new View();
 };
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> { 
dispose();
View v=new View();
 };
btnUpdate.addActionListener(a3);

ActionListener a4 = (ae) -> { 
dispose();
View v=new View();
 };
btnRemove.addActionListener(a4);


setSize(888,565);
setLocationRelativeTo(null);
setTitle("home page....");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
Home h=new Home();
}
}