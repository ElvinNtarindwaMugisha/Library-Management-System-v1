package view;

import dao.BookDao;
import model.Book;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LibraryManagement extends javax.swing.JFrame {

    private BookDao dao = new BookDao();
    private boolean updateMode = false;   // true → UPDATE, false → CREATE
    private boolean deleteMode = false;

    public LibraryManagement() {
        initComponents();
        setEditableAll(true);               // start in CREATE mode
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // ---- generated code (unchanged) ----
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bookCodeTxt = new javax.swing.JTextField();
        bookNameTxt = new javax.swing.JTextField();
        authorNameTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        // NEW BUTTONS
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnViewAll = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Book Registration Form");

        jLabel2.setText("Book Code");
        jLabel3.setText("Book Name");
        jLabel4.setText("Author Name");
        jLabel5.setText("Price");

        saveBtn.setText("SAVE");
        saveBtn.addActionListener(evt -> saveBtnActionPerformed());

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(evt -> searchBtnActionPerformed());

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(evt -> updateBtnActionPerformed());

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(evt -> deleteBtnActionPerformed());

        btnViewAll.setText("VIEW ALL");
        btnViewAll.addActionListener(evt -> viewAllBtnActionPerformed());

        btnClear.setText("CLEAR");
        btnClear.addActionListener(evt -> clearFields());

        // ---------- LAYOUT ----------
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bookCodeTxt)
                                        .addComponent(bookNameTxt)
                                        .addComponent(authorNameTxt)
                                        .addComponent(priceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(saveBtn)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(btnViewAll))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(bookCodeTxt)
                                        .addComponent(btnSearch))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(bookNameTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(authorNameTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(priceTxt))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveBtn)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete)
                                        .addComponent(btnClear))
                                .addGap(18, 18, 18)
                                .addComponent(btnViewAll)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    // --------------------------------------------------------------------
    // -------------------------- ACTION HANDLERS -------------------------
    // --------------------------------------------------------------------

    private void saveBtnActionPerformed() {
        if (updateMode || deleteMode) return;               // safety
        Book b = buildBookFromFields();
        if (b == null) return;

        int rows = dao.createBook(b);
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Data Saved Successfully");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Data NOT Saved");
        }
    }

    private void searchBtnActionPerformed() {
        String code = bookCodeTxt.getText().trim();
        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Book Code to search");
            return;
        }

        Book found = dao.searchBookByCode(code);
        if (found == null) {
            JOptionPane.showMessageDialog(this, "Book does NOT exist");
            resetFormForCreate();
            return;
        }

        // fill fields
        bookNameTxt.setText(found.getBookName());
        authorNameTxt.setText(found.getAuthorName());
        priceTxt.setText(String.valueOf(found.getPrice()));

        // decide mode (both UPDATE & DELETE start from a search)
        int choice = JOptionPane.showOptionDialog(
                this,
                "Book found. Choose action:",
                "Search Result",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"UPDATE", "DELETE", "CANCEL"},
                "UPDATE");

        if (choice == 0) {               // UPDATE
            setUpdateMode(true);
        } else if (choice == 1) {        // DELETE
            setDeleteMode(true);
        } else {                         // CANCEL
            resetFormForCreate();
        }
    }

    private void updateBtnActionPerformed() {
        if (!updateMode) return;
        Book b = buildBookFromFields();
        if (b == null) return;

        int rows = dao.updateBook(b);
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Data Updated Successfully");
            resetFormForCreate();
        } else {
            JOptionPane.showMessageDialog(this, "Update failed");
        }
    }

    private void deleteBtnActionPerformed() {
        if (!deleteMode) return;

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this book?",
                "Confirm Delete",
                JOptionPane.OK_CANCEL_OPTION);

        if (confirm == JOptionPane.OK_OPTION) {
            String code = bookCodeTxt.getText().trim();
            int rows = dao.deleteBook(code);
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Book deleted");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed");
            }
        }
        resetFormForCreate();   // either OK or CANCEL → back to CREATE
    }

    private void viewAllBtnActionPerformed() {
        new AllBooksFrame(dao.retrieveAllBooks()).setVisible(true);
    }

    // --------------------------------------------------------------------
    // -------------------------- HELPERS ---------------------------------
    // --------------------------------------------------------------------

    private Book buildBookFromFields() {
        String code = bookCodeTxt.getText().trim();
        String name = bookNameTxt.getText().trim();
        String author = authorNameTxt.getText().trim();
        String priceStr = priceTxt.getText().trim();

        if (code.isEmpty() || name.isEmpty() || author.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return null;
        }
        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number");
            return null;
        }
        Book b = new Book();
        b.setBookCode(code);
        b.setBookName(name);
        b.setAuthorName(author);
        b.setPrice(price);
        return b;
    }

    private void clearFields() {
        bookCodeTxt.setText("");
        bookNameTxt.setText("");
        authorNameTxt.setText("");
        priceTxt.setText("");
    }

    private void setEditableAll(boolean editable) {
        bookCodeTxt.setEditable(editable);
        bookNameTxt.setEditable(editable);
        authorNameTxt.setEditable(editable);
        priceTxt.setEditable(editable);
    }

    private void setUpdateMode(boolean on) {
        updateMode = on;
        deleteMode = false;
        setEditableAll(on);                 // name, author, price editable
        bookCodeTxt.setEditable(false);     // lock code
        btnUpdate.setEnabled(on);
        btnDelete.setEnabled(false);
        saveBtn.setEnabled(!on);
    }

    private void setDeleteMode(boolean on) {
        deleteMode = on;
        updateMode = false;
        setEditableAll(false);              // read-only
        btnDelete.setEnabled(on);
        btnUpdate.setEnabled(false);
        saveBtn.setEnabled(false);
    }

    private void resetFormForCreate() {
        updateMode = false;
        deleteMode = false;
        setEditableAll(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        saveBtn.setEnabled(true);
        clearFields();
    }

    // --------------------------------------------------------------------
    // -------------------------- MAIN ------------------------------------
    // --------------------------------------------------------------------
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LibraryManagement().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JTextField authorNameTxt;
    private javax.swing.JTextField bookCodeTxt;
    private javax.swing.JTextField bookNameTxt;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}

/* --------------------------------------------------------------
   SECOND FRAME – shows all books in a JTable
   -------------------------------------------------------------- */
class AllBooksFrame extends JFrame {
    public AllBooksFrame(List<Book> books) {
        setTitle("All Books");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] cols = {"Book Code", "Book Name", "Author Name", "Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (Book b : books) {
            model.addRow(new Object[]{
                    b.getBookCode(),
                    b.getBookName(),
                    b.getAuthorName(),
                    b.getPrice()
            });
        }

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);
    }
}
