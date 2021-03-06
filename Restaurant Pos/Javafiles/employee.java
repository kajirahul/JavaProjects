
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pande
 */
public class employee extends javax.swing.JFrame {

    /**
     * Creates new form employee
     */
    public employee() throws SQLException
    {
        initComponents();
        Toolkit tk = getToolkit();
        Dimension sizes = tk.getScreenSize();
        setLocation(sizes.width/2 - getWidth()/2, sizes.height/2-getHeight()/2);
        show_employee();
    }
    
    public ArrayList<Employee_1> usersList()throws SQLException
    {
        ArrayList<Employee_1> usersList = new ArrayList<>();
        
           try{
            String url = "jdbc:mysql://127.0.0.1:3306/resturant";
            final String userr = "root";
            final String passw= "Thapakaji2020.";
            Connection con2 = DriverManager.getConnection(url, userr, passw);
            String queryy = "SELECT* FROM  employee"; 
            Statement stm = con2.createStatement();
            ResultSet rst = stm.executeQuery(queryy);
            
            Employee_1 emp;
            while(rst.next())
            {
                emp = new Employee_1(rst.getInt("Employee_ID"),
                     rst.getString("Employee_Name"),rst.getString("Position"),
                     rst.getInt("Manager_ID"));
               
                usersList.add(emp);
               }
           
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
           return usersList;
    }
     
    
    public void show_employee()  throws SQLException{
        
        ArrayList<Employee_1> emplist = usersList();
        DefaultTableModel mdl =(DefaultTableModel)Employee_Table.getModel();
        Object[] rw = new Object[4];
        for (int i=0; i<emplist.size(); i++)
        {
            rw[0] = emplist.get(i).geteid();
            rw[1] = emplist.get(i).getename();
            rw[2] = emplist.get(i).getposition();
            rw[3] = emplist.get(i).getmid();
            mdl.addRow(rw);
        
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Employee_Table = new javax.swing.JTable();
        ename = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        eid = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        eposition = new javax.swing.JLabel();
        position = new javax.swing.JTextField();
        emid = new javax.swing.JLabel();
        mid = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Employee_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Employee Position", "Manager ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Employee_Table);

        ename.setText("Name:");

        eid.setText("ID:");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        eposition.setText("Position: ");

        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });

        emid.setText("Manager ID:");

        mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midActionPerformed(evt);
            }
        });

        update.setText("Update Information:");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete Information:");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setText("Add Employee:");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(emid)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(mid))
                        .addComponent(update, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(add)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eposition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eid)
                            .addComponent(ename))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eid))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ename))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eposition)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emid))
                .addGap(88, 88, 88)
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionActionPerformed

    private void midActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try{
            String url = "jdbc:mysql://127.0.0.1:3306/resturant";
            final String userr = "root";
            final String passw= "Thapakaji2020.";
            Connection con2 = DriverManager.getConnection(url, userr, passw);
            int rw = Employee_Table.getSelectedRow();
            String vall=(Employee_Table.getModel().getValueAt(rw,0).toString());
            String queryy = "update employee set Employee_ID = ?,"
                    + " Employee_Name= ?,Position=?,Manager_ID=? where "
                    + "Employee_ID ="+vall;
            PreparedStatement pst = con2.prepareStatement(queryy);
            pst.setString(1, id.getText());
            pst.setString(2, name.getText());
            pst.setString(3, position.getText());
            pst.setString(4, mid.getText());
            
            pst.executeUpdate();
            DefaultTableModel mdl=(DefaultTableModel)Employee_Table.getModel();
            mdl.setRowCount(0);
            
            show_employee();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            
            
            
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
         try{
            String url = "jdbc:mysql://127.0.0.1:3306/resturant";
            final String userr = "root";
            final String passw= "Thapakaji2020.";
            Connection con2 = DriverManager.getConnection(url, userr, passw);
            
            int rw = Employee_Table.getSelectedRow();
            String vall=(Employee_Table.getModel().getValueAt(rw,0).toString());
            String queryy = "Delete from employee where Employee_ID="+vall;
            
            PreparedStatement pstt = con2.prepareStatement(queryy);
            pstt.executeUpdate();
            DefaultTableModel mdl =(DefaultTableModel)Employee_Table.getModel();
            mdl.setRowCount(0);
            show_employee();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
            
         }
         catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
          try{
            String url = "jdbc:mysql://127.0.0.1:3306/resturant";
            final String userr = "root";
            final String passw= "Thapakaji2020.";
            Connection con2 = DriverManager.getConnection(url, userr, passw);
            String queryy = "insert into employee(Employee_ID,Employee_Name,"
                    + "Position, Manager_ID) "
                    + "values(?,?,?,?)";
            PreparedStatement pst = con2.prepareStatement(queryy);
            pst.setString(1, id.getText());
            pst.setString(2, name.getText());
            pst.setString(3, position.getText());
            pst.setString(4, mid.getText());
            
            pst.executeUpdate();
            DefaultTableModel mdl=(DefaultTableModel)Employee_Table.getModel();
            mdl.setRowCount(0);
            
            show_employee();
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
          
          }
           catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        
        
    }//GEN-LAST:event_addActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        this.setTitle("Hamro Employees");
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new employee().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Employee_Table;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel eid;
    private javax.swing.JLabel emid;
    private javax.swing.JLabel ename;
    private javax.swing.JLabel eposition;
    private javax.swing.JTextField id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mid;
    private javax.swing.JTextField name;
    private javax.swing.JTextField position;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
