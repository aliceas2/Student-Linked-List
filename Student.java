package linkedlistumuc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

/*
 * @author Alice Stanford
 */

public class Student extends JFrame {
	private static final long serialVersionUID = 4709828296331151263L;
	/**
     * Creates new form Student
     */
    BufferedWriter outWriter;
    StudentA students[];
    LinkedListUMUC<StudentA> studentList = new LinkedListUMUC<>();  
    public Student() {
        initComponents();   
    }

    private void initComponents() {

        inputFile = new javax.swing.JButton();
        saveOutput = new javax.swing.JButton();
        sortFName = new javax.swing.JButton();
        sortLName = new javax.swing.JButton();
        sortGPA = new javax.swing.JButton();
        peekHead = new javax.swing.JButton();
        peekTail = new javax.swing.JButton();
        peekElement = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        sortCredit = new javax.swing.JButton();
        sortMajor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        inputFile.setText("Import");
        inputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFileChooserActionPerformed(evt);
            }
        });

        saveOutput.setText("Save");
        saveOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileChooserActionPerformed(evt);
            }
        });

        sortFName.setText("Sort by First Name");
        sortFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortFirtsNameActionPerformed(evt);
            }
        });

        sortLName.setText("Sort by Last Name");
        sortLName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortLastNameActionPerformed(evt);
            }
        });

        sortGPA.setText("Sort by GPA");
        sortGPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortGPAActionPerformed(evt);
            }
        });
        
        peekHead.setText("Peek Head");
        peekHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peekHeadActionPerformed(evt);
            }
        });
        
        peekTail.setText("Peek Tail");
        peekTail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peekTailActionPerformed(evt);
            }
        });
        
        peekElement.setText("Peek Element");
        peekElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peekElementActionPerformed(evt);
            }
        });
        
        sortMajor.setText("Sort by Major");
        sortMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortMajorActionPerformed(evt);
            }
        });

        textArea.setColumns(75);
        textArea.setRows(40);
        jScrollPane3.setViewportView(textArea);

        sortCredit.setText("Sort By Credit");
        sortCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortCreditActionPerformed(evt);
            }
        });

        //REQ #7 : begin GUI Requirement
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel mainInnerPanel = makeMainInnerPanel();
        
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        finalPanel.add(inputFile);
        finalPanel.add(saveOutput);
        finalPanel.add(peekElement);
        
        JScrollPane scrollPane = new JScrollPane(mainInnerPanel);
        
        buttonPanel.add(scrollPane);
        add(buttonPanel, BorderLayout.NORTH);
        add(jScrollPane3, BorderLayout.CENTER);
        add(finalPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    	}
    
        private JPanel makeMainInnerPanel()
        {
            JPanel mainInnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            mainInnerPanel.add(sortGPA);
            mainInnerPanel.add(sortMajor);
            mainInnerPanel.add(sortLName);
            mainInnerPanel.add(sortFName);
            mainInnerPanel.add(sortCredit);
            mainInnerPanel.add(peekHead);
            mainInnerPanel.add(peekTail);
            return mainInnerPanel;
        }
        //REQ #7 : End GUI Requirement
        
    private void inputFileChooserActionPerformed(java.awt.event.ActionEvent evt) {

          File file=null;
          JFileChooser chooser = new JFileChooser();
           chooser.setDialogTitle("Load which file?");
           int result = chooser.showOpenDialog(null);
          if (result == JFileChooser.APPROVE_OPTION) {
           file = chooser.getSelectedFile();
      }
       String fileName=null;
     try{
         fileName = file.getCanonicalPath();
         StudentA.inputFile(fileName);
         students= StudentA.makeRandom(10);
         for (StudentA m: students)
          textArea.append(m+"\n");
         for (StudentA m: students){
             studentList.insertTail(m); 
             }
     }catch(IOException e)
     {
         System.out.println("Input ouput Exception ");
         System.exit(1);
     }
    }// REQ #6 : event_inputFileChooserActionPerformed

    private void sortFirtsNameActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("-------------------------- Sorted By First  Name -------------------------\n");
        StudentA.sortBy = StudentA.SORTBY.FIRST;
         java.util.Arrays.sort (students);
          for (StudentA m: students)
        	  studentList.insertHead(m);
          textArea.append(studentList.toString());
    }//event_sortFirtsNameActionPerformed

    private void sortLastNameActionPerformed(java.awt.event.ActionEvent evt) {
       textArea.append("------------------------ Sorted By Last Name --------------------------\n");
        StudentA.sortBy = StudentA.SORTBY.LAST;
         java.util.Arrays.sort (students);
          for (StudentA m: students){
        	  textArea.append(m+"\n");
          }
    }//event_sortLastNameActionPerformed

    private void sortGPAActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("------------------------ Sorted By GPA --------------------------\n");
        StudentA.sortBy = StudentA.SORTBY.GPA;
        java.util.Arrays.sort (students);
        for (StudentA m: students)
        textArea.append(m+"\n");
    }//event_sortGPAActionPerformed
    
    private void peekHeadActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("------------------------ Peek Head --------------------------\n");
        textArea.append(studentList.peekHead().toString()+"\n");
    }//event_peekHeadActionPerformed
    
    private void peekTailActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("------------------------ Peek Tail --------------------------\n");
        textArea.append(studentList.peekTail().toString()+"\n");
    }//event_peekTailActionPerformed
    
    private void peekElementActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("------------------------ Peek Element at 5 --------------------------\n");
        textArea.append(studentList.peekElementAt(5).toString()+"\n");
    }//event_peekElementActionPerformed
    
    private void sortMajorActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("------------------------ Sorted By Major --------------------------\n");
        StudentA.sortBy = StudentA.SORTBY.MAJOR;
        java.util.Arrays.sort (students);
        for (StudentA m: students)
        textArea.append(m+"\n");
    }//event_sortMajorActionPerformed

    private void sortCreditActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.append("------------------------ Sort By Credits --------------------------\n");
        StudentA.sortBy = StudentA.SORTBY.CREDITS;
        java.util.Arrays.sort (students);
        for (StudentA m: students)
        textArea.append(m+"\n");
    }//event_sortCreditActionPerformed

    private void outputFileChooserActionPerformed(java.awt.event.ActionEvent evt) {
         File file=null;
          JFileChooser c = new JFileChooser();
           c.setDialogTitle("Save Location");
           int result = c.showSaveDialog(null);
          if (result == JFileChooser.APPROVE_OPTION) {
           file = c.getSelectedFile();
      }
       String fileName=null;
     try{
         fileName = file.getCanonicalPath();
         outWriter=new BufferedWriter(new FileWriter(fileName));
     }catch(IOException e)
     {
         System.out.println("Input ouput Exception ");
         System.exit(1);
     }
    } //  REQ #6 : Output File creation

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
         try {
                     outWriter.write(textArea.getText());
                    outWriter.close(); 
        } catch (Exception e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton inputFile;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton saveOutput;
    private javax.swing.JButton sortCredit;
    private javax.swing.JButton sortFName;
    private javax.swing.JButton sortGPA;
    private javax.swing.JButton sortLName;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton sortMajor;
    private javax.swing.JButton peekHead;
    private javax.swing.JButton peekTail;
    private javax.swing.JButton peekElement;
    // End of variables declaration
}
