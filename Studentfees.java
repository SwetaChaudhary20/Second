import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Studentfees extends JFrame implements ActionListener
{
   Button b1,b2,b3;
   Label l1,l2,l3,l4,l5;
   TextField tf1,tf2,tf3,tf4,tf5;
   Connection con=null;
   Statement st=null;
   ResultSet rs;
   Studentfees()
   {
       setSize(400,400);
       setVisible(true);
       setLayout(null);
       setBackground(Color.CYAN);

       b1=new Button("Search");
       b1.setBounds(300,50,75,25);
       add(b1);
       b1.addActionListener(this);

       b2=new Button("Update");
       b2.setBounds(130,300,75,25);
       add(b2);
       b2.addActionListener(this);

       b3=new Button("Close");
       b3.setBounds(210,300,75,25);
       add(b3);
       b3.addActionListener(this);

       l1=new Label("Adhar no:");
       l1.setBounds(70,50,75,25);
       add(l1);

       l2=new Label("Name:");
       l2.setBounds(70,100,75,25);
       add(l2);

       l3=new Label("Total fees:");
       l3.setBounds(70,150,75,25);
       add(l3);

       l4=new Label("Paid Fees:");
       l4.setBounds(70,200,75,25);
       add(l4);

      l5=new Label("Due Fees:");
       l5.setBounds(70,250,75,25);
       add(l5);

       tf1=new TextField();
       tf1.setBounds(170,50,85,25);
       add(tf1);

       tf2=new TextField();
       tf2.setBounds(170,100,85,25);
       add(tf2);

       tf3=new TextField("6000");
       tf3.setBounds(170,150,85,25);
       add(tf3);

       tf4=new TextField();
       tf4.setBounds(170,200,85,25);
       add(tf4);

       tf5=new TextField();
       tf5.setBounds(170,250,85,25);
       add(tf5);


   }
  public void actionPerformed(ActionEvent e) 
  {
    if(e.getSource()==b3)
    {
        dispose();
    }
    else if(e.getSource()==b1)
    {
      try
      {

        int aadhar_no=0;
        String name;
       // String fees;
        aadhar_no=Integer.parseInt(tf1.getText());
        Class.forName("oracle.jdbc.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
        System.out.println("Database connected");
        st=con.createStatement();
       rs=st.executeQuery("select name from newstudent where aadhar='"+aadhar_no +"'");
        while(rs.next())
        {
           name=rs.getString(1);
          // fees=rs.getString(4);
          // System.out.println(name);
           tf2.setText(name);
          // tf5.setText(fees);
        }
      }
      catch(Exception ex)
      {
        System.out.println(ex);
      }

    }
    else if(e.getSource()==b2)
    {
      try
      {
        int aadhar=Integer.parseInt(tf1.getText());
        String name=tf2.getText();
        int paid=Integer.parseInt(tf4.getText());
        int due=Integer.parseInt(tf5.getText());
        Class.forName("oracle.jdbc.OracleDriver");
     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
      st=con.createStatement();
       st.executeUpdate("insert into studentfees values('"+aadhar+"','"+name+"','"+paid+"','"+due+"')");
      System.out.println("data inserted");
      dispose();
      new Box();

      }
      catch(Exception ex)
      {
        System.out.println(ex);
      }
    }

  }
}

