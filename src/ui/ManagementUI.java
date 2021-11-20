package ui;

import dto.Product;
import dto.Category;
import dao.ListUser;
import dao.ListProduct;
import dao.ListCategory;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ManagementUI extends javax.swing.JFrame {

    ListUser listUser = new ListUser();
    ListProduct listProduct = null;
    ListCategory listCategory = null;

    boolean addNewProduct = false;
    boolean addNewCategory = false;

    public void loadTableProduct() throws SQLException {
        clearAllProduct();
        listProduct = new ListProduct();
        tbProduct.setModel(listProduct.tableProduct());

        int indexItem[] = {0, 1, 2, 4, 3, 5};
        listProduct.setColumnOrder(indexItem, tbProduct.getColumnModel());

        String header[] = {"Product ID", "Product name", "Unit", "Quatity", "Price", "Category ID"};
        listProduct.setTitleOder(header, tbProduct);
    }

    public void loadTableCategory() throws SQLException {
        clearAllCategory();
        listCategory = new ListCategory();
        tbCategory.setModel(listCategory.tableCategory());

        int indexItem[] = {0, 1, 2};
        listCategory.setColumnOrder(indexItem, tbCategory.getColumnModel());

        String header[] = {"Category ID", "Category name", "Description"};
        listCategory.setTitleOder(header, tbCategory);
    }

    public void loadComboboxCategory() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String name, id;
        for (int i = 0; i < listCategory.getListCategory().size(); i++) {
            id = listCategory.getListCategory().get(i).getCategoryID();
            name = listCategory.getListCategory().get(i).getCategoryName();
            model.addElement(id + " - " + name);
        }

        cbxCategoryName.setModel(model);
        cbxCategoryName.setSelectedIndex(-1);
    }

    public int findIndexComboboxCategory(String id) {
        for (int i = 0; i < cbxCategoryName.getItemCount(); i++) {
            String combobox = cbxCategoryName.getItemAt(i);
            if (id.equals(combobox.substring(0, combobox.indexOf(" ")))) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkCategory() {
        if (tfCategoryID.getText().length() == 0 || tfCategoryID.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Category ID phải khác rỗng và không vượt quá 10 kí tự!");
            return false;
        }
        if (tfCategoryID.getText().matches("^[a-zA-Z0-9]{1,10}$") == false) {
            JOptionPane.showMessageDialog(null, "Category ID không chứa khoảng trắng và kí tự đặc biệt!");
            return false;
        }
        if (tfCategoryName.getText().length() == 0 || tfCategoryID.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Category name phải khác rỗng và không vượt quá 50 kí tự!");
            return false;
        }
        if (taDescription.getText().length() == 0 || tfCategoryID.getText().length() > 200) {
            JOptionPane.showMessageDialog(null, "Description phải khác rỗng và không vượt quá 200 kí tự!");
            return false;
        }
        return true;
    }

    public boolean checkProduct() {
        if (tfProductID.getText().length() == 0 || tfProductID.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Product ID phải khác rỗng và không vượt quá 10 kí tự!");
            return false;
        }
        if (tfProductID.getText().matches("^[a-zA-Z0-9]{1,10}$") == false) {
            JOptionPane.showMessageDialog(null, "Product ID không chứa khoảng trắng và kí tự đặc biệt!");
            return false;
        }
        if (tfProductName.getText().length() == 0 || tfProductName.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Product Name phải khác rỗng và không vượt quá 50 kí tự!");
            return false;
        }
        if (cbxCategoryName.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Category Name phải được chọn!");
            return false;
        }
        if (tfUnit.getText().length() == 0 || tfUnit.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Unit phải khác rỗng và không vượt quá 50 kí tự!");
            return false;
        }
        if (tfQuantity.getText().matches("\\d{1,10}") == false) {
            JOptionPane.showMessageDialog(null, "Quantity phải khác rỗng, là số nguyên và không vượt quá 10 kí tự!");
            return false;
        }
        if (tfPrice.getText().matches("\\d+.?\\d*") == false) {
            JOptionPane.showMessageDialog(null, "Price phải là số và khác rỗng!");
            return false;
        }
        return true;
    }

    public ManagementUI() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);

        try {
            listUser.CreateListUser();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối trong tạo List User!!");
        }

        tbProduct.setDefaultEditor(Object.class, null);
        loadTableProduct();

        tbCategory.setDefaultEditor(Object.class, null);
        loadTableCategory();

        loadComboboxCategory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfLoginUserID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        pfLoginPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategory = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfCategoryID = new javax.swing.JTextField();
        tfCategoryName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        btNewCategory = new javax.swing.JButton();
        btSaveCategory = new javax.swing.JButton();
        btDeleteCategory = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfProductID = new javax.swing.JTextField();
        tfProductName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxCategoryName = new javax.swing.JComboBox<>();
        tfUnit = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        btNewProduct = new javax.swing.JButton();
        btSaveProduct = new javax.swing.JButton();
        btDeleteProduct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Login Account");

        jLabel2.setText("User ID");

        jLabel3.setText("Password");

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(457, 457, 457)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfLoginUserID)
                    .addComponent(pfLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(404, 404, 404))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfLoginUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pfLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Main part"));

        tbCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCategory);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detailed part"));

        jLabel10.setText("Category ID:");

        jLabel11.setText("Category name:");

        jLabel12.setText("Description:");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        taDescription.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taDescription);

        btNewCategory.setText("New");
        btNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewCategoryActionPerformed(evt);
            }
        });

        btSaveCategory.setText("Save");
        btSaveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveCategoryActionPerformed(evt);
            }
        });

        btDeleteCategory.setText("Delete");
        btDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btNewCategory))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(btSaveCategory)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                            .addComponent(btDeleteCategory))
                        .addComponent(tfCategoryID)
                        .addComponent(tfCategoryName))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNewCategory)
                    .addComponent(btSaveCategory)
                    .addComponent(btDeleteCategory))
                .addGap(209, 209, 209))
        );

        jPanel3.add(jPanel6);

        jTabbedPane1.addTab("Category", jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Main part"));

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProduct);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Detailed part"));

        jLabel4.setText("Product ID:");

        jLabel5.setText("Product Name:");

        jLabel6.setText("Category name:");

        cbxCategoryName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Unit:");

        jLabel8.setText("Quantity:");

        jLabel9.setText("Price:");

        btNewProduct.setText("New");
        btNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewProductActionPerformed(evt);
            }
        });

        btSaveProduct.setText("Save");
        btSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveProductActionPerformed(evt);
            }
        });

        btDeleteProduct.setText("Delete");
        btDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfProductID)
                            .addComponent(tfProductName)
                            .addComponent(cbxCategoryName, 0, 264, Short.MAX_VALUE)
                            .addComponent(tfUnit)
                            .addComponent(tfQuantity)
                            .addComponent(tfPrice)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btNewProduct)
                        .addGap(104, 104, 104)
                        .addComponent(btSaveProduct)
                        .addGap(98, 98, 98)
                        .addComponent(btDeleteProduct)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNewProduct)
                    .addComponent(btSaveProduct)
                    .addComponent(btDeleteProduct))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        jTabbedPane1.addTab("Product", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        getContentPane().add(jPanel2, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        String id = tfLoginUserID.getText();
        String password = String.valueOf(pfLoginPassword.getPassword());
        if (listUser.checkLogin(id, password) == true) {
            JOptionPane.showMessageDialog(null, "Login thành công!!");
            CardLayout layout = (CardLayout) this.getContentPane().getLayout();
            layout.next(this.getContentPane());
        } else
            JOptionPane.showMessageDialog(null, "User ID or password invalid!!");
    }//GEN-LAST:event_btLoginActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        addNewProduct = false;
        clearMouseClickedProduct();
        int row = tbProduct.getSelectedRow();
        Product product = listProduct.getListProduct().get(row);
        tfProductID.setText(product.getProductID());
        tfProductName.setText(product.getProductName());
        cbxCategoryName.setSelectedIndex(findIndexComboboxCategory(product.getCategoryid()));
        tfUnit.setText(product.getUnit());
        tfQuantity.setText(String.valueOf(product.getQuantity()));
        tfPrice.setText(String.valueOf(product.getPrice()));
    }//GEN-LAST:event_tbProductMouseClicked

    private void tbCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoryMouseClicked
        addNewCategory = false;
        clearMouseClickedCategory();
        int row = tbCategory.getSelectedRow();
        Category category = listCategory.getListCategory().get(row);

        tfCategoryID.setText(category.getCategoryID());
        tfCategoryName.setText(category.getCategoryName());
        taDescription.setText(category.getDescription());
    }//GEN-LAST:event_tbCategoryMouseClicked

    private void btNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewCategoryActionPerformed
        addNewCategory = true;
        clearNewCategory();
    }//GEN-LAST:event_btNewCategoryActionPerformed

    private void btSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveCategoryActionPerformed
        if (checkCategory() == false) {
            return;
        }

        Category category = new Category(tfCategoryID.getText(), tfCategoryName.getText(), taDescription.getText());

        if (addNewCategory == true) {
            try {
                for (int i = 0; i < listCategory.getListCategory().size(); i++) {
                    if (tfCategoryID.getText().equals(listCategory.getListCategory().get(i).getCategoryID())) {
                        JOptionPane.showMessageDialog(null, "ID đã tồn tại!");
                        return;
                    }
                }
                if (listCategory.addCategory(category) == true) {
                    addNewCategory = false;
                    loadTableCategory();
                    clearAllCategory();
                    loadComboboxCategory();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (listCategory.updateCategory(category) == true) {
                    loadTableCategory();
                    tbCategory.updateUI();
                    clearAllCategory();
                    loadComboboxCategory();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSaveCategoryActionPerformed

    private void btDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteCategoryActionPerformed
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa Category này không?", "Lựa chọn của bạn", JOptionPane.YES_NO_CANCEL_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            try {
                int row = tbCategory.getSelectedRow();
                Category category = listCategory.getListCategory().get(row);
                for(int i=0; i<listProduct.getListProduct().size(); i++){
                    if(listProduct.getListProduct().get(i).getCategoryid().equals(category.getCategoryID())){
                        JOptionPane.showMessageDialog(null, "Category có product nên không thể xóa!");
                        return;
                    }
                }
                listCategory.deleteCategory(category);
                loadTableCategory();
                loadComboboxCategory();
                clearAllCategory();
            } catch (SQLException ex) {
                Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btDeleteCategoryActionPerformed

    private void btNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewProductActionPerformed
        addNewProduct = true;
        clearNewProduct();
    }//GEN-LAST:event_btNewProductActionPerformed

    private void btSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveProductActionPerformed
        if (checkProduct() == false) {
            return;
        }

        String combobox = String.valueOf(cbxCategoryName.getSelectedItem());
        String categoryID = combobox.substring(0, combobox.indexOf(" "));
        Product product = new Product(tfProductID.getText(), tfProductName.getText(), tfUnit.getText(),
                Float.parseFloat(tfPrice.getText()), Integer.parseInt(tfQuantity.getText()), categoryID);
        if (addNewProduct == true) {
            try {
                for (int i = 0; i < listProduct.getListProduct().size(); i++) {
                    if (tfProductID.getText().equals(listProduct.getListProduct().get(i).getProductID())) {
                        JOptionPane.showMessageDialog(null, "ID đã tồn tại!");
                        return;
                    }
                }
                if (listProduct.addProduct(product) == true) {
                    addNewProduct = false;
                    loadTableProduct();
                    clearAllProduct();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (listProduct.updateProduct(product) == true) {
                    loadTableProduct();
                    clearAllProduct();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSaveProductActionPerformed

    private void btDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteProductActionPerformed
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa Category này không?", "Lựa chọn của bạn", JOptionPane.YES_NO_CANCEL_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            try {
                int row = tbProduct.getSelectedRow();
                Product product = listProduct.getListProduct().get(row);
                listProduct.deleteProduct(product);
                loadTableProduct();
                clearAllProduct();
            } catch (SQLException ex) {
                Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btDeleteProductActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManagementUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManagementUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeleteCategory;
    private javax.swing.JButton btDeleteProduct;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btNewCategory;
    private javax.swing.JButton btNewProduct;
    private javax.swing.JButton btSaveCategory;
    private javax.swing.JButton btSaveProduct;
    private javax.swing.JComboBox<String> cbxCategoryName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField pfLoginPassword;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbCategory;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField tfCategoryID;
    private javax.swing.JTextField tfCategoryName;
    private javax.swing.JTextField tfLoginUserID;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfProductID;
    private javax.swing.JTextField tfProductName;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfUnit;
    // End of variables declaration//GEN-END:variables

    private void clearNewCategory() {
        tfCategoryID.setText("");
        tfCategoryID.setEnabled(true);
        tfCategoryName.setText("");
        tfCategoryName.setEnabled(true);
        taDescription.setText("");
        taDescription.setEnabled(true);

        btSaveCategory.setEnabled(true);
        btDeleteCategory.setEnabled(false);
    }

    private void clearAllCategory() {
        tfCategoryID.setText("");
        tfCategoryID.setEnabled(false);
        tfCategoryName.setText("");
        tfCategoryName.setEnabled(false);
        taDescription.setText("");
        taDescription.setEnabled(false);

        btSaveCategory.setEnabled(false);
        btDeleteCategory.setEnabled(false);
    }

    private void clearMouseClickedCategory() {
        tfCategoryID.setEnabled(false);
        tfCategoryName.setEnabled(true);
        taDescription.setEnabled(true);

        btSaveCategory.setEnabled(true);
        btDeleteCategory.setEnabled(true);
    }

    private void clearNewProduct() {
        tfProductID.setText("");
        tfProductID.setEnabled(true);
        tfProductName.setText("");
        tfProductName.setEnabled(true);
        cbxCategoryName.setSelectedIndex(-1);
        cbxCategoryName.setEnabled(true);
        tfUnit.setText("");
        tfUnit.setEnabled(true);
        tfQuantity.setText("");
        tfQuantity.setEnabled(true);
        tfPrice.setText("");
        tfPrice.setEnabled(true);

        btSaveProduct.setEnabled(true);
        btDeleteProduct.setEnabled(false);
    }

    private void clearAllProduct() {
        tfProductID.setText("");
        tfProductID.setEnabled(false);
        tfProductName.setText("");
        tfProductName.setEnabled(false);
        cbxCategoryName.setSelectedIndex(-1);
        cbxCategoryName.setEnabled(false);
        tfUnit.setText("");
        tfUnit.setEnabled(false);
        tfQuantity.setText("");
        tfQuantity.setEnabled(false);
        tfPrice.setText("");
        tfPrice.setEnabled(false);

        btSaveProduct.setEnabled(false);
        btDeleteProduct.setEnabled(false);
    }

    private void clearMouseClickedProduct() {
        tfProductID.setEnabled(false);
        tfProductName.setEnabled(true);
        cbxCategoryName.setEnabled(true);
        tfUnit.setEnabled(true);
        tfQuantity.setEnabled(true);
        tfPrice.setEnabled(true);

        btSaveProduct.setEnabled(true);
        btDeleteProduct.setEnabled(true);
    }
}
