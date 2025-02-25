package chap8.degreeworks;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class TermsActionPanel extends ActionPanel {

    // GUI components we need to access at various times
    protected JTextField nameField;
    protected JTextField yearField;
    protected JButton addButton;
    protected JButton submitButton;
    protected JButton cancelButton;
    protected JButton updateButton;        
    protected JButton deleteButton;

    public TermsActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }
    
    @Override
    protected JPanel setupGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        northPanel.add(new JLabel("TERMS ACTION PANEL"), BorderLayout.NORTH);
        panel.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameField = new JTextField(20);
        centerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("Year:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        yearField = new JTextField(20);
        centerPanel.add(yearField, gbc);

        // Now let's add a panel for all the actions buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add New Term");
        submitButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        updateButton = new JButton("Update Selected Term");        
        deleteButton = new JButton("Delete Selected Term");
        deleteButton.setForeground(Color.RED); // Sets text color to red
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        buttonPanel.add(addButton);
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // now add all the listeners for the buttons
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField.setText("");
                yearField.setText("");
                addButton.setVisible(false);
                updateButton.setVisible(false);
                deleteButton.setVisible(false);
                submitButton.setVisible(true);
                cancelButton.setVisible(true);
            }
        });
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = nameField.getText();
                String year = yearField.getText();
                Term t = new Term(name, year);
                allterms.add(t);
                main.catalogPanel.setSelectedTerm(t);
                main.catalogPanel.updateAllLists();
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Term t = main.catalogPanel.getSelectedTerm();
                if (t != null) {
                    loadTerm(main.catalogPanel.getSelectedTerm());
                } else if (allterms.size() > 0) {
                    main.catalogPanel.setSelectedTerm(allterms.get(0));
                    loadTerm(allterms.get(0));
                } else {
                    addButton.setVisible(true);
                    submitButton.setVisible(false);
                    cancelButton.setVisible(false);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(false);
                }
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Term t = main.catalogPanel.getSelectedTerm();
                t.setName(nameField.getText());
                t.setYear(yearField.getText());
                main.catalogPanel.updateAllLists();
                loadTerm(t);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Term t = main.catalogPanel.getSelectedTerm();
                if (JOptionPane.showConfirmDialog(buttonPanel, "Are you sure you want to delete this term?" + t, "Confirmation", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    allterms.remove(t);
                    main.catalogPanel.updateAllLists();
                    nameField.setText("");
                    yearField.setText("");
                    addButton.setVisible(false);
                    submitButton.setVisible(true);
                    cancelButton.setVisible(true);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(false);
                }
            }
        });

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    public void loadTerm(Term t) {
        addButton.setVisible(true);
        submitButton.setVisible(false);
        cancelButton.setVisible(false);
        updateButton.setVisible(true);
        deleteButton.setVisible(true);
        this.nameField.setText(t.getName());
        this.yearField.setText(t.getYear());
    }

}
