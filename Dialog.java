import java.awt.*;
import java.awt.event.*;
 class Dialog extends Frame implements ActionListener
{
    Label l1;
    Button b1,b2,b3,b4,b5,b6;
    Image img;
    Toolkit tk;
    Dialog()
    {
        setSize(600,400);
        setLayout(null);
        setVisible(true);

        tk=Toolkit.getDefaultToolkit();
        img=tk.getImage("hm.png");

        l1=new Label("NAVIGATOR BAR");
        l1.setBounds(20,50,170,25);
        Font myFont=new Font("Serif",Font.BOLD,20);
        l1.setFont(myFont);
        l1.setForeground(Color.blue);
        add(l1);

        b1=new Button("Manage Room");
        b1.setBounds(20,100,150,25);
        add(b1);
        b1.addActionListener(this);

        b2=new Button("New Students");
        b2.setBounds(20,140,150,25);
        add(b2);
        b2.addActionListener(this);

        b3=new Button("Update and Delete students");
        b3.setBounds(20,180,150,25);
        add(b3);
        b3.addActionListener(this);

        b4=new Button("Student Fees");
        b4.setBounds(20,220,150,25);
        add(b4);
        b4.addActionListener(this);

        b5=new Button("Log Out");
        b5.setBounds(450,50,60,25);
        add(b5);
        b5.addActionListener(this);

        b6=new Button("Exit");
        b6.setBounds(520,50,60,25);
        add(b6);
        b6.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
{  
    if(e.getSource()==b1)
    {
        new Manageroom();
    }
    else if(e.getSource()==b2)
    {
        new Newstudent();
    }
    else if(e.getSource()==b3)
    {
        new Deletestudent();
    }
    else if(e.getSource()==b5)
    {
        dispose();
        new Hostelmanagement();
    }
    else if(e.getSource()==b4)
    {
        new Studentfees();
    }
    else if(e.getSource()==b6)
    {
        dispose();
    }
}
public void paint(Graphics g)
{
 g.drawImage(img,0,0,this);
}
public static void main(String args[])
{
     new Dialog();
}
}

