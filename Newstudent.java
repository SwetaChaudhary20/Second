 import java.awt.*;
 import java.awt.event.*;
 import java.sql.*;
 class Newstudent extends Frame implements ActionListener
   {
    Label l1,l2,l3,l4,l5,l6,l7;
    TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    Button b1,b2;
    Connection con=null;
    Statement st=null;
    String name="",f_name="",m_name="",address="";
    int room_no=0,mobile=0,aadhar=0;

    Newstudent()
    {
       setSize(500,500);
       setLayout(null);
       setVisible(true);
       setBackground(Color.PINK);

       l1=new Label("Name:");
       l1.setBounds(100,100,75,25);
       add(l1);

       tf1=new TextField();
       tf1.setBounds(200,100,150,25);
       add(tf1);

       l2=new Label("Father's name:");
       l2.setBounds(100,150,85,25);
       add(l2);

       tf2=new TextField();
       tf2.setBounds(200,150,150,25);
       add(tf2);

       l3=new Label("Mother's Name:");
       l3.setBounds(100,200,85,25);
       add(l3);

       tf3=new TextField();
       tf3.setBounds(200,200,150,25);
       add(tf3);

       l4=new Label("Mobile no:");
       l4.setBounds(100,250,85,25);
       add(l4);

       tf4=new TextField();
       tf4.setBounds(200,250,150,25);
       add(tf4);

       l5=new Label("Room_no:");
       l5.setBounds(100,300,75,25);
       add(l5);

       tf5=new TextField();
       tf5.setBounds(200,300,150,25);
       add(tf5);

       l6=new Label("Aadhar no:");
       l6.setBounds(100,350,85,25);
       add(l6);

       tf6=new TextField();
       tf6.setBounds(200,350,150,25);
       add(tf6);

       l7=new Label("Address:");
       l7.setBounds(100,400,75,25);
       add(l7);

       tf7=new TextField();
       tf7.setBounds(200,400,150,25);
       add(tf7);

       b1=new Button("Save");
       b1.setBounds(150,440,55,25);
       add(b1);
       b1.addActionListener(this);

       b2=new Button("Close");
       b2.setBounds(220,440,55,25);
       add(b2);
       b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
   dispose();
}
else if(e.getSource()==b1)
{
   try{
    
room_no=Integer.parseInt(tf5.getText());
mobile=Integer.parseInt(tf4.getText());
aadhar=Integer.parseInt(tf6.getText());
name=tf1.getText();
f_name=tf2.getText();
m_name=tf3.getText();
address=tf7.getText();
System.out.println(room_no);
Class.forName("oracle.jdbc.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
st=con.createStatement();
st.executeUpdate("insert into newstudent values('"+name+"','"+f_name+"','"+m_name+"','"+mobile+"','"+room_no+"','"+aadhar+"','"+address+"')");
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
