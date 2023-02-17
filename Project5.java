import java.awt.*;
import java.util.*;
import java.sql.*;

import javax.lang.model.util.ElementScanner6;
import java.awt.event.*;
public class Project5 extends Frame implements ActionListener
{
    Button b1,b2,b3;
    Label l;

    
    public Project5()
    {
        setSize(600,600);
        setLayout(null);
        setVisible(true);
        setBackground(Color.lightGray);
       

        b1=new Button("Register");
        b1.setBounds(200,300,55,35);
        add(b1);
        b1.addActionListener(this);

        b2=new Button("Login");
        b2.setBounds(200,350,55,35);
        add(b2);
        b2.addActionListener(this);

        b3=new Button("Close");
        b3.setBounds(200,400,55,35);
        add(b3);
        b3.addActionListener(this);

        l=new Label();
        l.setText("DATA STUCTURE STUDY");
        l.setBounds(150,100,500,200);
        Font myFont=new Font("Serif",Font.BOLD,20);
        l.setFont(myFont);
        l.setForeground(Color.blue);
        add(l);

    }
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==b1)
        {
            dispose();
            new MyDialog();
        }
        else if(e.getSource()==b2)
        {
            dispose();
        new MyDialog3();
        }
        else
        {
            dispose();
        }
    }

public static void main(String ar[])
{
    new Project5();
}
}
 class MyDialog extends Frame implements ActionListener
{
    Connection con=null;
    Statement st=null;
    Label l1,l2,l3,l4,l5,l6;
    Button register,close;
    TextField tf1,tf2,tf3,tf4;
    Choice c;
    int i=0;
    String s="",p="";
    String name,password,email;
    int mobile;
    public MyDialog()
    {
        setSize(600,600);
        setLayout(null);
        setVisible(true);
        setBackground(Color.cyan);

        l1=new Label();
        l1.setText("Register");
        l1.setBounds(300,50,100,50);
        Font font=new Font("Serif",Font.BOLD,16);
        l1.setFont(font);
        add(l1);

        l2=new Label();
        l2.setText("Name:");
        l2.setBounds(50,100,75,50);
        add(l2);

        l3=new Label();
        l3.setText("Email id:");
        l3.setBounds(50,200,75,50);
        add(l3);

        l4=new Label();
        l4.setText("Mobile no.:");
        l4.setBounds(50,300,75,50);
        add(l4);

        l5=new Label();
        l5.setText("Qualification:");
        l5.setBounds(50,400,75,50);
        add(l5);

        l6=new Label();
        l6.setText("Password:");
        l6.setBounds(50,450,75,50);
        add(l6);

        register=new Button("Register");
        register.setBounds(250,550,55,35);
        add(register);
        register.addActionListener(this);

        close=new Button("Close");
        close.setBounds(350,550,55,35);
        add(close);
        close.addActionListener(this);

        tf1=new TextField();
        tf1.setBounds(200,100,100,35);
        add(tf1);


        tf2=new TextField();
        tf2.setBounds(200,200,100,35);
        add(tf2);

        tf3=new TextField();
        tf3.setBounds(200,300,100,35);
        add(tf3);

        tf4=new TextField();
        tf4.setBounds(200,450,100,35);
        add(tf4);

        c=new Choice();
        c.setBounds(200,400,100,35);
        c.add("BCA");
        c.add("MCA");
        c.add("BBA");
        c.add("MBA");
        add(c);
    }
    public void actionPerformed(ActionEvent e)
    {
    
        try{
    
        
        if(e.getSource()==close)
        {
            dispose();
        }
        else
       
        {
    
            dispose();
            name=tf1.getText();
        email=tf2.getText();
        mobile=Integer.parseInt(tf3.getText());
        password=tf4.getText();
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
            st=con.createStatement();
        i=st.executeUpdate("insert into register values('"+name+"','"+password+"','"+email+"','"+mobile+"')");
       
             new MyDialog2(name,password);
            
        }
        
    }
    catch(Exception ex)
    {
        System.out.println(ex);
    }
    }

}
class MyDialog2 extends Frame implements ActionListener
{
    Label l6,l7,l8,l9;
    Button close,home;
    MyDialog2(String name,String password)
    {
        setSize(400,400);
        setLayout(null);
        setVisible(true);

        l6=new Label();
        l6.setText("you are sucessfully registerd Miss/Master");
        l6.setBounds(50,150,228,100);
        add(l6);

        l7=new Label();
        l7.setText(name);
        l7.setBounds(280,150,300,100);
        Font myFont=new Font("Serif",Font.BOLD,14);
        l7.setFont(myFont);
        l7.setForeground(Color.blue);
        add(l7);

        l9=new Label();
        l9.setText("your password is:");
        l9.setBounds(50,70,150,55);
        add(l9);


        l8=new Label();
        l8.setText(password);
        l8.setBounds(200,70,150,50);
        add(l8);


        
        close=new Button("Close");
        close.setBounds(150,250,55,35);
        add(close);
        close.addActionListener(this);

        home=new Button("home page");
        home.setBounds(150,300,70,35);
        add(home);
        home.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==close)
        {
        dispose();
        }
        else
        {  
            dispose();
            new Project5();
        }
    }
}
class MyDialog3 extends Frame implements ActionListener
{
    Button submit,exit;
    Label name,password,label,l5;
    TextField n_tf,p_tf;
    Connection con=null;
    Statement st=null;
    String name1=null,pass1=null;
   MyDialog3()
   {

    submit=new Button("submit");
        exit=new Button("exit");
        name=new Label();
        label=new Label();
        password=new Label();
        n_tf=new TextField();
        p_tf=new TextField();
        setSize(600,600);
        setLayout(null);
        setVisible(true);
        name.setText("NAME");
        password.setText("PASSWORD");
        add(submit);
        add(exit);
        add(name);
        add(password);
        add(n_tf);
        add(p_tf);
        p_tf.setEchoChar('*');
        submit.setBounds(200,300,55,35);
        exit.setBounds(260,300,75,35);
        name.setBounds(20,100,80,30);
        password.setBounds(20,150,100,50);
        label.setBounds(200,160,330,100);
        n_tf.setBounds(100,100,80,30);
        p_tf.setBounds(120,150,80,30);
        submit.addActionListener(this);
        exit.addActionListener(this);
        

   }
   public void actionPerformed(ActionEvent e)
   {
    try{
        
    if(e.getSource()==submit)
    {
        dispose();
       
        Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
            st=con.createStatement();
            ResultSet rs=st.executeQuery("select*from register");
            while(rs.next())
            {
                String n=n_tf.getText();
                String p=p_tf.getText();
                name1=rs.getString(1);
                pass1=rs.getString(2);
                if(name1.equals(n)&&pass1.equals(p))
                {
        
                    new MyMenu2();
    
                }
                else
                {
                    l5=new Label();
                    l5.setBounds(200,250,100,35);
                    l5.setText("wrong name or password");
                    add(l5);
                }
            }
            
    }
     else
     {
        dispose();
     }
   }
   catch(Exception ex)
    {
        System.out.println(ex);
    }
}
}

 class MyMenu2 extends Frame implements ActionListener
{
    Menu menu,menu2,menu3,menu4,menu5;
    MenuBar mb;
    MenuItem mi,mi2,mi3,mi4,mi5;
    Label label1,label2;
    public MyMenu2()
    {
        setSize(600,600);
        setLayout(null);
        setVisible(true);
        setBackground(Color.pink);
        label1=new Label();
        label2=new Label();
        label1.setText("DESIGN AND ANALYSIS OF ALGORITHM");
        label2.setText("DEVELOPED BY:SWETA");
        label1.setBounds(100,100,500,300);
        label2.setBounds(300,300,400,300);
        Font myFont=new Font("Serif",Font.BOLD,20);
        label1.setFont(myFont);
        label1.setForeground(Color.red);
        add(label1);
        add(label2);

        menu=new Menu("SORTING");
        menu2=new Menu("SEARCHING");
        menu3=new Menu("LINKED LIST");
        menu4=new Menu("STACK");
        menu5=new Menu("QUEUE");
        mb=new MenuBar();
        setMenuBar(mb);

        mb.add(menu);
        mb.add(menu2);
        mb.add(menu3);
        mb.add(menu4);
        mb.add(menu5);

        mi=new MenuItem("SELECTION");
        mi2= new MenuItem("BUBBLE SORT");
        mi3=new MenuItem("Close");

        mi4=new MenuItem("Linear");
        mi5=new MenuItem("Binary");

        menu2.add(mi4);
        menu2.add(mi5);

        menu.add(mi);
        menu.add(mi2);
        menu.add(mi3);

        mi.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==mi2)
        {
            new MyDialog4();

            dispose();
        }else
        if(e.getSource()==mi)
        {
            new MyDialog4();

        }
        else 
        if(e.getSource()==mi3)
        {
            dispose();
        }
else
    {
        new MyDialog5();
    }
    
    
    }
}
 class MyDialog4 extends Frame implements ActionListener
{
  Label l1;
  TextField tf;
  Button b1,b2;
   MyDialog4()
  {
    setSize(600,600);
    setVisible(true);
    setLayout(null);

    l1=new Label();
    l1.setBounds(150,100,100,30);
    l1.setText("Enter Number:");
    add(l1);

    tf=new TextField();
    tf.setBounds(250,100,100,50);
    add(tf);
    
    
    b1=new Button("sort");
    b1.setBounds(270,250,55,35);
    add(b1);
    b1.addActionListener(this);

    b2=new Button("close");
    b2.setBounds(270,280,55,35);
    add(b2);
    b2.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    String s1=tf.getText();
    if(e.getSource()==b1)
    {

    String [] words=s1.split("\\s");
    String s2[]=new String[words.length];
		int Bubble[]=new int[s2.length];
         
		
		for(int i=0;i<words.length;i++)
        {
            s2[i]=words[i];
            Bubble[i]=Integer.parseInt(s2[i]);
        }
		int temp=0;
		
		for(int i=0;i<s2.length-1;i++)
		{
			for(int j=i+1; j<s2.length;j++)
			{
				if(Bubble[i]>Bubble[j])
				{
					temp=Bubble[i];
				    Bubble[i]=Bubble[j];
					Bubble[j]=temp;
				}
			}
		}	
		
		
		
		Label w[]=new Label[Bubble.length];

        int x=160;
        for (int i = 0; i < Bubble.length; i++)
			{
				w[i]=new Label();
                w[i].setBounds(x,180,20,35);
                x+=35;
                w[i].setText(" "+Bubble[i]);
                add(w[i]);

            }
		}
        else
        {
            dispose();
        }
    }
}
class MyDialog5 extends Frame implements ActionListener
{ 
    Label l1,l2;
    Button b1,b2;
    TextField tf1;
    int a[]={5,6,7,8,9};
    int temp=0;
    MyDialog5()
    {
        setSize(600,600);
        setVisible(true);
        setLayout(null);
        l1=new Label();
        l1.setBounds(150,100,150,30);
        l1.setText("Enter Number to search:");
        add(l1);
    
        tf1=new TextField();
        tf1.setBounds(350,100,100,50);
        add(tf1);
    
        l2=new Label();
        l2.setBounds(350,150,100,50);
        add(l2);
        
        
        b1=new Button("search");
        b1.setBounds(270,200,55,35);
        add(b1);
        b1.addActionListener(this);
    
        b2=new Button("close");
        b2.setBounds(270,250,55,35);
        add(b2);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            int num=Integer.parseInt(tf1.getText());
           for(int i=0;i<a.length;i++)
           {
            if(num==a[i])
            {
                l2.setText("Number Found");
                temp++;
            }
    
           }
           if(temp==0)
           {
            l2.setText("Number not found");
           }
        }
        else{
            dispose();
        }
    }

    }  


	




	


  

  
  










