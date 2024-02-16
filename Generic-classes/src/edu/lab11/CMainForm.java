package edu.lab11;

import generic.CMyLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CMainForm extends javax.swing.JFrame{
    private JPanel mainPanel;
    private JTextField strIdField;
    private JTextField strTextField;
    private JButton strButton;
    private JButton strClear;
    private JList strList;
    private JTextField strFind;
    private JButton strFindId;
    private JButton strFindIndex;
    private JTextField intIdField;
    private JTextField intTextField;
    private JList intList;
    private JButton intButton;
    private JTextField personIdField;
    private JTextField personTextFname;
    private JTextField personTextName;
    private JComboBox personYear;
    private JButton personButton;
    private JList personList;
    private JTextField imgIdField;
    private JButton imgButton;
    private JList imgList;

    private void createUIComponents() {
        mainPanel = new JPanel();
    }
    private final DefaultListModel<Object> modelStr;
    private final DefaultListModel<Object> modelInt;
    private final CMyLinkedList<Integer, String> myListStr;
    private final CMyLinkedList<Byte,Integer> myListInt;
    private final DefaultListModel<Object> modelPerson;
    private final DefaultListModel<Object> modelImg;
    private final CMyLinkedList<Long, CPerson> myListPerson;
    private final CMyLinkedList<Integer, ImageIcon> myListImg;
    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        myListInt = new CMyLinkedList<>();
        myListStr = new CMyLinkedList<>();
        myListPerson = new CMyLinkedList<>();
        myListImg = new CMyLinkedList<>();


        modelInt = new DefaultListModel<>();
        modelStr = new DefaultListModel<>();
        modelPerson = new DefaultListModel<>();
        modelImg = new DefaultListModel<>();

        strList.setModel(modelStr);
        intList.setModel(modelInt);
        personList.setModel(modelPerson);
        imgList.setModel(modelImg);
        imgList.setCellRenderer(new CImgListRenderer(this.myListImg));

        strButton.addActionListener(e -> strButtonClick());
        strClear.addActionListener(e -> strButtonClearClick());
        strFindIndex.addActionListener(e -> strGetByIndexClick());
        strFindId.addActionListener(e -> strGetByIdClick());
        intButton.addActionListener(e -> intButtonClick());
        personButton.addActionListener(e -> personButtonClick());
        imgButton.addActionListener(e -> imageButtonClick());
    }
    private void strButtonClick(){
        try {
            Integer n = Integer.parseInt(strIdField.getText());
            String text = strTextField.getText().trim();
            if(text.compareTo("")!=0){
                myListStr.add(n, text);
            }
            myListStr.printToList(modelStr);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid value. message: "+e.getMessage());
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void strButtonClearClick(){
        myListStr.clear();
        myListStr.printToList(modelStr);
    }
    private void strGetByIndexClick(){
        try {
            int idx = Integer.parseInt(strFind.getText());
            String s = myListStr.getByIndex(idx-1);
            JOptionPane.showMessageDialog(this, "Return value: "+s);
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this,"Invalid range, message: " + e.getMessage());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Invalid format, message: " + e.getMessage());
        }

    }
    private void strGetByIdClick(){
        try {
            int id = Integer.parseInt(strFind.getText());
            String s = myListStr.getById(id);
            if(s != null){
                JOptionPane.showMessageDialog(this,"Return value: "+s);
            }else {
                JOptionPane.showMessageDialog(this, "Element id = " + id + " doesn't exist");
            }
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this,"Invalid range, message: " + e.getMessage());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Invalid format, message: " + e.getMessage());
        }

    }
    private void intButtonClick(){
        try {
            Byte d = Byte.parseByte(intIdField.getText());
            Integer v = Integer.parseInt(intTextField.getText());

            myListInt.add(d,v);
            myListInt.printToList(modelInt);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid value, message: " + e.getMessage());
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    private void personButtonClick(){
        try {
            Long n = Long.parseLong(personIdField.getText());
            CPerson person = new CPerson(
                    personTextFname.getText(),
                    personTextName.getText(),
                    Integer.parseInt(personYear.getItemAt(personYear.getSelectedIndex()).toString())
            );
            myListPerson.add(n,person);
            myListPerson.printToList(modelPerson);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid value. message: "+e.getMessage());
        }catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void imageButtonClick(){
        try {
            Integer n = Integer.parseInt(imgIdField.getText());
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            int returnVal = fc.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                myListImg.add(n, new ImageIcon(fc.getSelectedFile().getAbsolutePath()));
                myListImg.printToList(modelImg);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid value. message: "+e.getMessage());
        }catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }




}
