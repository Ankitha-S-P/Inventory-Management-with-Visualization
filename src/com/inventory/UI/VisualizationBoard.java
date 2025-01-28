/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.inventory.UI;


import com.inventory.DAO.ProductDAO;
import com.inventory.DAO.CustomerDAO;
import com.inventory.DAO.SupplierDAO;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class VisualizationBoard extends javax.swing.JPanel {

    public VisualizationBoard() {
        initComponents();

        // Add a ComponentListener to reload charts when the panel is shown
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                reloadCharts(); // Reload charts when the panel becomes visible
            }
        });

        // Initial chart load
        reloadCharts();
    }

    private void reloadCharts() {
        // Clear and reload the Revenue Share chart
        panelRevenueShare.removeAll();
        addRevenueShareChart();

        // Clear and reload the Stock Levels chart
        panelStockLevels.removeAll();
        addStockLevelsChart();

        // Clear and reload the Customer Purchases chart
        panelCustomerPurchases.removeAll();
        addCustomerPurchasesChart();

        // Clear and reload the Supplies by Supplier chart
        panelSuppliesBySupplier.removeAll();
        addSuppliesBySupplierChart();

        // Revalidate and repaint the panels to reflect the new charts
        panelRevenueShare.revalidate();
        panelRevenueShare.repaint();
        panelStockLevels.revalidate();
        panelStockLevels.repaint();
        panelCustomerPurchases.revalidate();
        panelCustomerPurchases.repaint();
        panelSuppliesBySupplier.revalidate();
        panelSuppliesBySupplier.repaint();
    }

    private void addRevenueShareChart() {
        ProductDAO productDAO = new ProductDAO();
        Map<String, Double> revenueData = productDAO.getRevenueShareByProducts();

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : revenueData.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart chart = ChartFactory.createPieChart("Revenue Share by Products", dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(panelRevenueShare.getSize());
        panelRevenueShare.setLayout(new BorderLayout());
        panelRevenueShare.add(chartPanel, BorderLayout.CENTER);
        panelRevenueShare.validate();
    }

    private void addStockLevelsChart() {
        ProductDAO productDAO = new ProductDAO();
        Map<String, Integer> stockData = productDAO.getStockLevels();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : stockData.entrySet()) {
            dataset.addValue(entry.getValue(), "Stock Level", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart("Stock Levels", "Products", "Quantity", dataset);

        // Get the plot and the domain axis (X-axis)
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();

        // Rotate the X-axis labels
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);  // Tilts the X-axis title by 45 degrees
        domainAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(panelStockLevels.getSize());
        panelStockLevels.setLayout(new BorderLayout());
        panelStockLevels.add(chartPanel, BorderLayout.CENTER);
        panelStockLevels.validate();
    }


    private void addCustomerPurchasesChart() {
        CustomerDAO customerDAO = new CustomerDAO();
        Map<String, Integer> purchaseData = customerDAO.getCustomerPurchases();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : purchaseData.entrySet()) {
            dataset.addValue(entry.getValue(), "Purchases", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart("Customer Purchases", "Customers", "Number of Purchases", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(panelCustomerPurchases.getSize());
        panelCustomerPurchases.setLayout(new BorderLayout());
        panelCustomerPurchases.add(chartPanel, BorderLayout.CENTER);
        panelCustomerPurchases.validate();
    }

    private void addSuppliesBySupplierChart() {
        SupplierDAO supplierDAO = new SupplierDAO();
        Map<String, Integer> supplyData = supplierDAO.getSuppliesBySupplier();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : supplyData.entrySet()) {
            dataset.addValue(entry.getValue(), "Supplies", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart("Supplies by Supplier", "Suppliers", "Total Supplies", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(panelSuppliesBySupplier.getSize());
        panelSuppliesBySupplier.setLayout(new BorderLayout());
        panelSuppliesBySupplier.add(chartPanel, BorderLayout.CENTER);
        panelSuppliesBySupplier.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelRevenueShare = new javax.swing.JPanel();
        panelStockLevels = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelSuppliesBySupplier = new javax.swing.JPanel();
        panelCustomerPurchases = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(780, 516));
        setLayout(new java.awt.GridLayout(2, 2));

        panelRevenueShare.setBorder(javax.swing.BorderFactory.createTitledBorder("Revenue Share by Products "));
        panelRevenueShare.setPreferredSize(new java.awt.Dimension(397, 124));

        javax.swing.GroupLayout panelRevenueShareLayout = new javax.swing.GroupLayout(panelRevenueShare);
        panelRevenueShare.setLayout(panelRevenueShareLayout);
        panelRevenueShareLayout.setHorizontalGroup(
            panelRevenueShareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        panelRevenueShareLayout.setVerticalGroup(
            panelRevenueShareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        panelStockLevels.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Levels "));
        panelStockLevels.setPreferredSize(new java.awt.Dimension(397, 124));

        javax.swing.GroupLayout panelStockLevelsLayout = new javax.swing.GroupLayout(panelStockLevels);
        panelStockLevels.setLayout(panelStockLevelsLayout);
        panelStockLevelsLayout.setHorizontalGroup(
            panelStockLevelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        panelStockLevelsLayout.setVerticalGroup(
            panelStockLevelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRevenueShare, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStockLevels, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRevenueShare, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
            .addComponent(panelStockLevels, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        add(jPanel2);

        panelSuppliesBySupplier.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplies by Supplier "));
        panelSuppliesBySupplier.setPreferredSize(new java.awt.Dimension(397, 124));

        javax.swing.GroupLayout panelSuppliesBySupplierLayout = new javax.swing.GroupLayout(panelSuppliesBySupplier);
        panelSuppliesBySupplier.setLayout(panelSuppliesBySupplierLayout);
        panelSuppliesBySupplierLayout.setHorizontalGroup(
            panelSuppliesBySupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        panelSuppliesBySupplierLayout.setVerticalGroup(
            panelSuppliesBySupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        panelCustomerPurchases.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Purchases "));
        panelCustomerPurchases.setPreferredSize(new java.awt.Dimension(397, 124));

        javax.swing.GroupLayout panelCustomerPurchasesLayout = new javax.swing.GroupLayout(panelCustomerPurchases);
        panelCustomerPurchases.setLayout(panelCustomerPurchasesLayout);
        panelCustomerPurchasesLayout.setHorizontalGroup(
            panelCustomerPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        panelCustomerPurchasesLayout.setVerticalGroup(
            panelCustomerPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuppliesBySupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCustomerPurchases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuppliesBySupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
            .addComponent(panelCustomerPurchases, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelCustomerPurchases;
    private javax.swing.JPanel panelRevenueShare;
    private javax.swing.JPanel panelStockLevels;
    private javax.swing.JPanel panelSuppliesBySupplier;
    // End of variables declaration//GEN-END:variables
}
