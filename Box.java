import java.awt.*;
import java.awt.event.*;

class Box extends Frame implements ActionListener
{
    Label l1;
    Button b1;
    Box()
    {
        setSize(220,220);
        setLayout(null);
        setVisible(true);

        l1=new Label("Successfully added");
        l1.setBounds(20,70,150,25);
        add(l1);

        b1=new Button("OK");
        b1.setBounds(60,110,55,25);
        add(b1);
        b1.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e)
    {
       dispose();
    }
}