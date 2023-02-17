 import java.awt.*;
 import java.awt.event.*;
 class Box2 extends Frame implements ActionListener 
 {
    Label l1;
    Button b1;
    Box2()
    {
       setSize(200,200);
       setVisible(true);
       setLayout(null);

       l1=new Label("Wrong password!");
       l1.setBounds(50,70,150,25);
       add(l1);

       b1=new Button("OK");
       b1.setBounds(90,120,55,25);
       b1.addActionListener(this);
       add(b1);
    }
    public void actionPerformed(ActionEvent e)
    {
      dispose();
    }
}
