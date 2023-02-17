import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class Table extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
   
    public Table() {
        
       
       
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Room_no");
        model.addColumn("Active");
       
     
        try {
            Class.forName("oracle.jdbc.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sweta");
           Statement  st=con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM addroom");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
    public static void main(String args[])
    {
      
        JFrame frame=new Table();
         frame.setTitle("All Rooms list");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}