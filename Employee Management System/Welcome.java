import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Welcome extends JFrame
{
Container c;
JLabel Title;
JButton btnContinue;

Welcome(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.BLACK);

Title=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
Title.setBounds(80,5,800,40);
Title.setFont(new Font("Arila", Font.BOLD, 35));
Title.setForeground(Color.GREEN);
c.add(Title);

ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("icons/8.png"));
JLabel image=new JLabel(i1);
image.setBounds(23, 50, 740,370);
c.add(image);


btnContinue=new JButton("Click Here To Continue");
btnContinue.setBounds(205,400,350,35);
btnContinue.setFont(new Font("Arial", Font.BOLD, 20));
btnContinue.setForeground(Color.BLUE);
btnContinue.setBackground(Color.WHITE);
c.add(btnContinue);

ActionListener a = (ae) -> {
dispose();
Login l=new Login();
};
btnContinue.addActionListener(a);

setSize(800,500);
setLocationRelativeTo(null);
setTitle("welcome page...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String argsp[])
{
Welcome w=new Welcome();
}
}