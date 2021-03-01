/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.utils;

import com.pos.beans.Products;
import com.pos.beans.SaleDetail;
import static com.pos.utils.Home.cm_to_pp;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author AbidAli
 */
public class BillPrintable extends JFrame implements Printable {

    List<SaleDetail> listOfSaleDetail = new ArrayList<SaleDetail>();
    List<Products> listOfProducts = new ArrayList<Products>();

    public String txttotalAmount;
    public String txtcash;
    public String txtbalance;
  
    
     //  String billNo="";
    Double totalAmount=0.0;
    Double cash=0.0;
    Double balance=0.0;
    Double bHeight=0.0;

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {
     
        int totalItemsSize = listOfSaleDetail.size();
        ImageIcon icon = new ImageIcon("G:\\NetBeansProjects\\pointofsale\\images\\hobby_hub_logo.ico");
        int result = NO_SUCH_PAGE;
        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;
            double width = pageFormat.getImageableWidth();
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
            try {
                int y = 20;
                int yShift = 10;
                int headerRectHeight = 15;
                // int headerRectHeighta=40;

                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);
                y += yShift + 30;
                g2d.drawString("-------------------------------------", 12, y);
                y += yShift;
                g2d.drawString("         HobbyHub.com        ", 12, y);
                y += yShift;
                g2d.drawString("   No 00000 Address Line One ", 12, y);
                y += yShift;
                g2d.drawString("   Address Line 02 LAHORE PAK ", 12, y);
                y += yShift;
                g2d.drawString("   www.facebook.com/abid43805 ", 12, y);
                y += yShift;
                g2d.drawString("        +923344033924      ", 12, y);
                y += yShift;
                g2d.drawString("-------------------------------------", 12, y);
                y += headerRectHeight;

                g2d.drawString(" Item Name                  Price   ", 10, y);
                y += yShift;
                g2d.drawString("-------------------------------------", 10, y);
                y += headerRectHeight;

                for (int i = 0; i < totalItemsSize; i++) {
                    Products product = new Products();
                    product.setProductId(listOfSaleDetail.get(i).getProduct());
                    g2d.drawString(" " + 
                            listOfProducts.get(listOfProducts.indexOf(product)).getProductName()
                             + "                            ", 10, y);
                    y += yShift;
                    g2d.drawString("      " + listOfSaleDetail.get(i).getQuantity()+ " * " + listOfSaleDetail.get(i).getProductPrice(), 10, y);
                    g2d.drawString(""+listOfSaleDetail.get(i).getSubTotal(), 160, y);
                    y += yShift;

                }

                g2d.drawString("-------------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Total amount:               " + txttotalAmount + "   ", 10, y);
                y += yShift;
                g2d.drawString("-------------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Cash      :                 " + txtcash + "   ", 10, y);
                y += yShift;
                g2d.drawString("-------------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Balance   :                 " + txtbalance+ "   ", 10, y);
                y += yShift;

                g2d.drawString("*************************************", 10, y);
                y += yShift;
                g2d.drawString("       THANK YOU COME AGAIN            ", 10, y);
                y += yShift;
                g2d.drawString("*************************************", 10, y);
                y += yShift;
                g2d.drawString("       SOFTWARE BY:HobbyHub          ", 10, y);
                y += yShift;
                g2d.drawString("   CONTACT: abid.ali2525@gmail.com       ", 10, y);
                y += yShift;

            } catch (Exception e) {
                e.printStackTrace();
            }

            result = PAGE_EXISTS;
        }
        return result;
    }

    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();
        double bodyHeight = Double.valueOf(listOfSaleDetail.size());
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }
  public List<SaleDetail> getListOfSaleDetail() {
        return listOfSaleDetail;
    }

    public void setListOfSaleDetail(List<SaleDetail> listOfSaleDetail) {
        this.listOfSaleDetail = listOfSaleDetail;
    }

    public List<Products> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Products> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
  
}
