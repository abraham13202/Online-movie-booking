import java.sql.*;
import javax.swing.*;
public class LOGIN extends javax.swing.JFRAME {                          
public LOGIN () {
        initComponents ();  }
//LOGIN
private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {
int c = 0;
String Email = tf1.getText();
String Password = new String (pf1.getPassword());
if(Email.trim().isEmpty()||Password.trim().isEmpty())  {
       JOptionPane.showMessageDialog(this, "Please enter both fields properly.");
       tf1.setText("");
       pf1.setText("");   }
else  {
       try  {
           Class.forName("java.sql.DriverManager");
           Connection con = (Connection)
           DriverManager.getConnection("jdbc:mysql://localhost:3306/bys","root","123");
           Statement stmt = (Statement) con.createStatement();
           String query = "Select Email,Password from contact where Email = '"+Email+"' and Password =
           '"+Password+"';";
           ResultSet res = stmt.executeQuery(query);
           if(res.next())
           c++;
           if(c>0)  {
                JOptionPane.showMessageDialog(this, "Login Successful.");
                tf1.setText("");
                pf1.setText("");
                new MOVIES(Email).setVisible(true);
                this.setVisible(false);   }
           else  {
                JOptionPane.showMessageDialog(this, "Login Unsuccessful.");
                tf1.setText("");
                pf1.setText("");  }   }
       catch(Exception e)  {
           JOptionPane.showMessageDialog(this, e.getMessage());  } } }

//CLEAR
private void CLEARActionPerformed(java.awt.event.ActionEvent evt)  {
tf1.setText("");
pf1.setText("");  }

//SIGNUP
private void SIGNUPActionPerformed(java.awt.event.ActionEvent evt)  {
new SignUp().setVisible(true);
this.setVisible(false);  }  }

public  class  SignUp extends javax.swing.JFrame  {
    public SignUp() {
       initComponents();   }
// SUBMIT
private void SUBMITActionPerformed(java.awt.event.ActionEvent evt)  {
String Name = tf1.getText();
String Email = tf2.getText();
String Password = new String(pf1.getPassword());
if(Password.trim().length()<8)   {
     JOptionPane.showMessageDialog(this, "Password Should contain at least 8 characters");
     pf1.setText("");    }
else if(Name.trim().isEmpty()||Email.trim().isEmpty())    {
     JOptionPane.showMessageDialog(this, "Please enter all the required fields properly.");
     pf1.setText("");     }
else   {
     try    {
           Class.forName("java.sql.DriverManager");
           Connection con = (Connection) 
           DriverManager.getConnection("jdbc:mysql://localhost:3306/bys","root","123");
           Statement stmt = (Statement) con.createStatement();
           String query = "Insert into contact values('"+Name+"','"+Email+"','"+Password+"');";
           String q = "Select Email from contact where Email = '"+Email+"';";
           ResultSet res = stmt.executeQuery(q);
           if(res.next())    {
                 JOptionPane.showMessageDialog(this, "An account with this Email already exists.\n Please try again.");
                 tf1.setText("");
                 tf2.setText("");
                 pf1.setText("");    }
           else   {
                 stmt.executeUpdate(query);
                 JOptionPane.showMessageDialog(this, "Sign Up Successful");
                 tf1.setText("");
                 tf2.setText("");
                 pf1.setText("");
                 new LOGIN().setVisible(true);
                 this.setVisible(false);   }  } 
     catch(Exception e)   {
           JOptionPane.showMessageDialog(this, e.getMessage());  }  }  }

// CLEAR
private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {
tf1.setText("");
tf2.setText("");
pf1.setText("");  }

// BACK
private void BACKActionPerformed(java.awt.event.ActionEvent evt) {
new LOGIN().setVisible(true);
this.setVisible(false); }  }

public class MOVIES extends javax.swing.JFrame {
    public MOVIES() {
            initComponents();   }
        String Email, Time, Theatre, Movie;
        public MOVIES(String a)    {
            initComponents();
            this.Email = a;  }
    
    // b1
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {
    String Date = tf1.getText();
    if(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected())  {
           if(cb1.isSelected())
           Movie = "Avengers: Endgame";
           else if(cb2.isSelected())
           Movie = "John Wick: Chapter 3";
           else if(cb3.isSelected())
           Movie = "Student Of The Year 2";
           else if(cb4.isSelected())
           Movie = "The Tashkent Files";
           if(Date.trim().isEmpty())
           JOptionPane.showMessageDialog(null, "Enter the Date on which you want to watch the movie.");
           else   {
                  Time = "08:00 AM";
                  Theatre = "PVR, Kumar Pacific Mall,Pune";
                  new Seats(Email, Movie, Date, Time, Theatre).setVisible(true);
                  this.setVisible(false);   }  }
    else
    JOptionPane.showMessageDialog(null, "Select the movie you want to watch.");  }
    
    // b2
    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {
    String Date = tf1.getText();
    if(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected())  {
           if(cb1.isSelected())
           Movie = "Avengers: Endgame";
           else if(cb2.isSelected())
           Movie = "John Wick: Chapter 3";
           else if(cb3.isSelected())
           Movie = "Student Of The Year 2";
           else if(cb4.isSelected())
           Movie = "The Tashkent Files";
           if(Date.trim().isEmpty())
           JOptionPane.showMessageDialog(null, "Enter the Date on which you want to watch the movie.");
           else  {
                  Time = "09:00 PM";
                  Theatre = "PVR, Kumar Pacific Mall,Pune";
                  new Seats(Email, Movie, Date, Time, Theatre).setVisible(true);
                  this.setVisible(false);   }  }
           else
           JOptionPane.showMessageDialog (null, "Select the movie you want to watch.");  }
    
    // b3
    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {
    String Date = tf1.getText();
    if(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected())  {
           if(cb1.isSelected())
           Movie = "Avengers: Endgame";
           else if(cb2.isSelected())
           Movie = "John Wick: Chapter 3";
           else if(cb3.isSelected())
           Movie = "Student Of The Year 2";
           else if(cb4.isSelected())
           Movie = "The Tashkent Files";
           if(Date.trim().isEmpty())
           JOptionPane.showMessageDialog(null, "Enter the Date on which you want to watch the movie.");
           else  {
                  Time = "08:30 AM";
                  Theatre = "Cinepolis, Seasons Mall,Pune";
                  new Seats(Email, Movie, Date, Time, Theatre).setVisible(true);
                  this.setVisible(false);   }  }
           else
           JOptionPane.showMessageDialog (null, "Select the movie you want to watch.");  }
    
    // b4
    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {
    String Date = tf1.getText();
    if(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected())
    {
           if(cb1.isSelected())
           Movie = "Avengers: Endgame";
           else if(cb2.isSelected())
           Movie = "John Wick: Chapter 3";
           else if(cb3.isSelected())
           Movie = "Student Of The Year 2";
           else if(cb4.isSelected())
           Movie = "The Tashkent Files";
           if(Date.trim().isEmpty())
           JOptionPane.showMessageDialog(null, "Enter the Date on which you want to watch the movie.");
           else
           {
                  Time = "12:00 PM";
                  Theatre = "Cinepolis, Seasons Mall,Pune";
                  new Seats(Email, Movie, Date, Time, Theatre).setVisible(true);
                  this.setVisible(false);
           }
    }
    else
    JOptionPane.showMessageDialog(null, "Select the movie you want to watch.");  }  }
    