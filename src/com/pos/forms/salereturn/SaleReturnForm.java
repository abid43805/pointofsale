/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.salereturn;

import com.pos.beans.SaleDetail;
import com.pos.forms.pointofsale.service.PointOfSaleService;
import com.pos.forms.stocks.stocksservice.StocksService;
import com.pos.utils.TableCellListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbidAli
 */
public class SaleReturnForm extends javax.swing.JFrame {

    /**
     * Creates new form SaleReturnForm
     */
    public SaleReturnForm() {
        initComponents();
        registerEventonCellEditor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_SaleReturn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Transaction = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SaleReturn = new javax.swing.JTable();
        btn_SaleReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_SaleReturn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sale Return", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), java.awt.Color.blue)); // NOI18N

        jLabel1.setText("Transaction ID :");

        txt_Transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TransactionActionPerformed(evt);
            }
        });

        btn_Search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        tbl_SaleReturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Product Name", "Price", "Quantity", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_SaleReturn);

        btn_SaleReturn.setBackground(new java.awt.Color(255, 255, 255));
        btn_SaleReturn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_SaleReturn.setBorder(new javax.swing.border.MatteBorder(null));
        btn_SaleReturn.setLabel("Return");
        btn_SaleReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaleReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_SaleReturnLayout = new javax.swing.GroupLayout(pnl_SaleReturn);
        pnl_SaleReturn.setLayout(pnl_SaleReturnLayout);
        pnl_SaleReturnLayout.setHorizontalGroup(
            pnl_SaleReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_SaleReturnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnl_SaleReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_SaleReturnLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_SaleReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_SaleReturnLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_SaleReturnLayout.setVerticalGroup(
            pnl_SaleReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_SaleReturnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_SaleReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Transaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_SaleReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_SaleReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_SaleReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_SaleReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TransactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TransactionActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        
        if(txt_Transaction.getText()!=null || txt_Transaction.getText()!="")
        {
            PointOfSaleService posService = new PointOfSaleService();
            List<SaleDetail> listSaleDetail = posService.fetchSaleDetails(txt_Transaction.getText());
            if(listSaleDetail!=null && listSaleDetail.size()>0){
                showSaleDetailInTable(listSaleDetail);
            }
            
        }
        
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_SaleReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaleReturnActionPerformed
        ArrayList<String> jTableUpdatedValues = new ArrayList<String>(); 
        Vector tableData = ((DefaultTableModel)tbl_SaleReturn.getModel()).getDataVector();
        System.out.println(tableData);
        List<SaleDetail> listToBeReturned = makeListToBeReturned(tableData);
        PointOfSaleService service = new PointOfSaleService();
        boolean saleReturned = service.updateSaleReturns(listToBeReturned);
        if (saleReturned) {
            JOptionPane.showMessageDialog(pnl_SaleReturn, "Product(s) returned successfully.");
        } else {
            JOptionPane.showMessageDialog(pnl_SaleReturn, "Some problem occurred while returning product(s).");
        }
         
//        for (int count = 0; count <= tbl_SaleReturn.getModel().getRowCount(); count++) {
//            jTableUpdatedValues.add(tbl_SaleReturn.getModel().getValueAt(count, 0).toString());
//        }
//        System.out.println(jTableUpdatedValues);

        
        
    }//GEN-LAST:event_btn_SaleReturnActionPerformed
private void showSaleDetailInTable(List<SaleDetail> listSaleDetail)
    {
        DefaultTableModel model = (DefaultTableModel)tbl_SaleReturn.getModel();
        // clear jtable content
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i = 0; i < listSaleDetail.size(); i++)
        {
            row[0] = listSaleDetail.get(i).getSale();
            row[1] = listSaleDetail.get(i).getProductName();
            row[2] = listSaleDetail.get(i).getProductPrice();
            row[3] = listSaleDetail.get(i).getQuantity();
            row[4] = listSaleDetail.get(i).getSubTotal();
            
            
            
            model.addRow(row);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(SaleReturnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleReturnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleReturnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleReturnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleReturnForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SaleReturn;
    private javax.swing.JButton btn_Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_SaleReturn;
    private javax.swing.JTable tbl_SaleReturn;
    private javax.swing.JTextField txt_Transaction;
    // End of variables declaration//GEN-END:variables

    private void registerEventonCellEditor() {
        
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                TableCellListener tcl = (TableCellListener) e.getSource();
                DefaultTableModel defaultTableModel = (DefaultTableModel)tbl_SaleReturn.getModel();
                System.out.println("Row   : " + tcl.getRow());
                System.out.println("Column: " + tcl.getColumn());
                System.out.println("Old   : " + tcl.getOldValue());
                System.out.println("New   : " + tcl.getNewValue());
                if(Long.parseLong(tcl.getNewValue().toString())>Long.parseLong(tcl.getOldValue().toString())){
                    JOptionPane.showMessageDialog(pnl_SaleReturn,"Quantity returned can not be greater than old quantity.");
                    tbl_SaleReturn.getModel().setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
                    return;
                }   
                Vector dataVector = defaultTableModel.getDataVector();
                String price = dataVector.get(tcl.getRow()).toString().split(",")[2];
                String newSubTotal;  //new quantity * price
                newSubTotal = "" + Long.parseLong(tcl.getNewValue().toString())*Double.parseDouble(price);
                System.out.println(dataVector.get(tcl.getRow()) + " 2nd element in vector" + price);
                System.out.println("newSubTotal : " + newSubTotal);
                //assign new subtotal to relevant column in table
                tbl_SaleReturn.getModel().setValueAt(newSubTotal, tcl.getRow(), 4);
            }
        };
        TableCellListener tcl = new TableCellListener(tbl_SaleReturn, action);
        
        
    }

    private List<SaleDetail> makeListToBeReturned(Vector tableData) {
            List<SaleDetail> list =  new ArrayList<SaleDetail>();
            SaleDetail saleDetail;
            String[] tableDataArray = tableData.toString().split(",");
            for(int i = 0; i < tableData.size(); i++){
                saleDetail = new SaleDetail();
                saleDetail.setProduct((tableData.get(i)));
                
            }
        return null;
    }
}
