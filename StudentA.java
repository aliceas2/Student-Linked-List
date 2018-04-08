package linkedlistumuc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

class StudentA implements Comparable <StudentA> {

 static java.util.Random rn = new java.util.Random ();
 static ArrayList <String> firstNames = new ArrayList <>();
 static ArrayList <String> lastNames = new ArrayList <>();
 static ArrayList <String> majors= new ArrayList <>();
 static SORTBY sortBy = SORTBY.LAST;
 static int nextUID = 1;

 

 String first, last, major;
 double gpa = 0,percentage=0;
 boolean pass=false;
 int credits = 0,semester=1;
 int uid = 0;
 
 

 

 public static void inputFile(String inputFile)
 {
     try {
                majors.add("Art and Design");
                majors.add("Psychology");
                majors.add("Electronics");
                majors.add("Sociology");
                majors.add("Spanish");
                @SuppressWarnings("resource")
				Scanner input=new Scanner(new File(inputFile));
                int n=input.nextInt();
                for(int i=0;i<n;i++)
                {
                    firstNames.add (input.next());
                    lastNames.add ( input.next());
                }
             } 
             catch (java.io.FileNotFoundException e) {
                 System.out.println (e);
             }
 }
 enum SORTBY {LAST,FIRST,CREDITS,GPA,MAJOR};

 public StudentA (String st) 
     {
         this (new Scanner (st));
     }

 

 public StudentA (Scanner sc) {
         uid = nextUID++; // REQ #1 : unique Identifier
         first = sc.next(); //REQ #2 : String
         last = sc.next(); //REQ #2 : String
         major=sc.next(); //REQ #2 : String
         semester=sc.nextInt(); //REQ #2 : Int
         credits = sc.nextInt(); //REQ #2 : Int
         gpa = sc.nextDouble(); //REQ #2 : Double
         percentage=gpa*9.5;
         if(gpa>=1.5)
         pass=true;
 } //  REQ #5 : end Scanner constructor

 

 public StudentA ()
 {uid = nextUID++;} // REQ #5 : no parameter constructor

 

 @Override
 public int compareTo (StudentA x) {
 switch (sortBy) {
 case LAST : return last.compareTo (x.last);
 case FIRST : return first.compareTo (x.first);
 case CREDITS: return credits - x.credits;
 case GPA : return (gpa > x.gpa)? 1 : -1;
 case MAJOR : return major.compareTo(x.major);
 } // end switch
 return 0;
 } // end compareTo for Comparable interface

 

 @Override
 public String toString () { // REQ #4  : toString
     String passed="";
     if(pass==true)
         passed="Pass";
     else
         passed="Fail";
 return String.format ("%d %15s, %10s: %10s %10d %10d %10.2f \t"+passed, uid, last, first,major,semester,credits, gpa);
 
 } // end method toString

 

 public static StudentA [] makeRandom (int m) { // REQ #3 : Random student array generator
 StudentA [] sa = new StudentA [m];
 for (int i = 0; i < sa.length; i++) {
 sa[i] = new StudentA ();
 sa[i].first = firstNames.get (rn.nextInt (firstNames.size()));
 sa[i].last = lastNames.get (rn.nextInt ( lastNames.size()));
 sa[i].major = majors.get(rn.nextInt(majors.size()));
 sa[i].credits =  rn.nextInt (120);
 sa[i].gpa = rn.nextDouble () * 4.0;
 sa[i].percentage=sa[i].gpa*9.5;
 sa[i].semester=rn.nextInt(8)+1;
 if(sa[i].gpa>=1.5)
     sa[i].pass=true;
 } // end for each student to instantiate
 return sa;
 } // end method makeRanom

 public static void writeOutput(StudentA [] s,String outFile)
 {
     try {
         BufferedWriter output=new BufferedWriter(new FileWriter(outFile));
         for(int i=0;i<s.length;i++)
         {
             output.write(s[i]+"\n");
         }
         output.close();
     } catch (Exception e) {
     }
 }
 
} // end class StudentA