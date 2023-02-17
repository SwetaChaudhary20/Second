 import java.awt.*;
 import java.awt.event.*;
 import java.sql.*;
 import javax.swing.*;
 class Manageroom extends Frame implements ActionListener
 {
    Label l1,l2,l3;
    Button b1,b2,b3,b4,b5,b6;
    TextField tf1,tf2,tf3;
    TextArea ta;
    int i=0;
    Connection con=null;
    Statement st=null;
   
    Manageroom()
    {
        setSize(500,400);
        setVisible(true);
        setLayout(null);
        setBackground(Color.PINK);

       b1=new Button("Add Room");
       b1.setBounds(50,50,85,25);
       add(b1);
       b1.addActionListener(this);

       b2=new Button("Delete Room");
       b2.setBounds(50,150,85,25);
       add(b2);
       b2.addActionListener(this);

       b3=new Button("All Rooms");
       b3.setBounds(50,210,85,25);
       add(b3);
       b3.addActionListener(this);

       b4=new Button("Add");
       b4.setBounds(200,120,85,25);
       b4.addActionListener(this);

       b5=new Button("Delete");
       b5.setBounds(290,180,85,25);
       b5.addActionListener(this);

       b6=new Button("Back");
       b6.setBounds(390,50,85,25);
       b6.addActionListener(this);
       add(b6);

      l1=new Label("Room No:");
      l1.setBounds(120,80,80,25);

      l2=new Label("Booked:");
      l2.setBounds(300,80,70,25);

      l3=new Label("Room No:");
      l3.setBounds(120,180,80,25);

      tf3=new TextField();
      tf3.setBounds(210,180,50,25);


      tf1=new TextField();
      tf1.setBounds(210,80,50,25);

      tf2=new TextField();
      tf2.setBounds(370,80,50,25);

      ta=new TextArea();
      ta.setBounds(100,250,200,150);

    }
    public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b1)
    {
        add(l1);
        add(l2);
        add(tf1);
        add(tf2);
        add(b4);
    }
    else if(e.getSource()==b6)
    {
        dispose();
        new Dialog();
    }
    else if(e.getSource()==b2)
    {
        add(l3);
        add(tf3);
        add(b5);
    }
    else if(e.getSource()==b3)
    {
      //new Table();
    //  JFrame frame = new Table();
    JFrame frame=new Table();
    frame.setTitle("Swing Example");
   frame.setSize(500, 300);
   frame.setLocationRelativeTo(null);
   frame.setVisible(true);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    else if(e.getSource()==b5)
    {
        try
        {
            int room_no=0;
    
            room_no=Integer.parseInt(tf3.getText());
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
            st=con.createStatement();
            st.executeUpdate("delete from addroom where room_no='"+room_no+"'");
            dispose();

        }
        catch(Exception exe)
        {
            System.out.println(exe);
        }
    }
    else if(e.getSource()==b4)
    {
        try
        {
            String booked="";
            int room_no=0;
    
     room_no=Integer.parseInt(tf1.getText());
     booked=tf2.getText();
     System.out.println(room_no);
     Class.forName("oracle.jdbc.OracleDriver");
     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
     st=con.createStatement();
     st.executeUpdate("insert into addroom values('"+room_no+"','"+booked+"')");
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
