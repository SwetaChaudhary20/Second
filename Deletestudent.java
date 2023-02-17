import java.awt.*;
import java.awt.event.*; 
 import java.sql.*;
 class Deletestudent extends Frame implements ActionListener
 {
    Button b1,b2,b3,b4;
    Label l1,l2;
    TextField tf1,tf2;
    Connection con=null;
    Statement st=null;
    Deletestudent()
    {
       setSize(400,400);
       setVisible(true);
       setLayout(null);
       setBackground(Color.CYAN);
     
       b1=new Button("Delete");
       b1.setBounds(100,50,75,25);
       add(b1);
       b1.addActionListener(this);

       l1=new Label("Aadhar no:");
       l1.setBounds(175,80,75,25);

       l2=new Label("Deleted!");
       l2.setBounds(200,137,100,20);

       tf1=new TextField();
       tf1.setBounds(257,80,75,25);

       b4=new Button("Done");
       b4.setBounds(230,110,75,25);
       b4.addActionListener(this);


       b2=new Button("Update");
       b2.setBounds(100,150,75,25);
       add(b2);
       b2.addActionListener(this);

       b3=new Button("Back");
       b3.setBounds(100,250,75,25);
       add(b3);
       b3.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e) 
{
if(e.getSource()==b1)
{
   add(l1);
   add(tf1);
   add(b4);
}
else if(e.getSource()==b4)
{
   try
        {
            int aadhar_no=0;
    
            aadhar_no=Integer.parseInt(tf1.getText());
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
            st=con.createStatement();
            st.executeUpdate("delete from newstudent where aadhar='"+aadhar_no+"'");
            add(l2);
           // dispose();

        }
        catch(Exception exe)
        {
            System.out.println(exe);
        }
}
else if(e.getSource()==b3)
{
   dispose();
   new Dialog();
}
}
}
