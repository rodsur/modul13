/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgaver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rodsur
 */
public class menu {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        boolean running = true;
        Scanner reader;
        Scanner deleter;
        Scanner inserter;
        PrintWriter pw;
        ArrayList<String> fileContent;
        
        File workFile = new File("");
        
        while (running){
            System.out.println("1: read file by line");
            System.out.println("2: read file by commas");
            System.out.println("3: write static file");
            System.out.println("4: delete element");
            System.out.println("5: insert element");
            System.out.println("6: create/load file");
            System.out.println("10: exit");
            System.out.print("Enter choice:");
            Scanner menuScanner = new Scanner(System.in);
            System.out.println("");
            switch (menuScanner.nextLine()) {
                case "1":
                    reader = new Scanner(workFile);
                    while (reader.hasNext()) {
                        System.out.println(reader.nextLine());
                    }
                    break;
                case "2":
                    reader = new Scanner(workFile).useDelimiter(",");
                    while (reader.hasNext()) {
                        System.out.println(reader.next());
                    }
                    break;
                case "3":
                    pw = new PrintWriter(workFile);
                    pw.println("1,2,red,blue");
                    pw.close();
                    break;
                case "4":
                    //pw = new PrintWriter(workFile);
                    fileContent = new ArrayList();
                    reader = new Scanner(workFile).useDelimiter(",");
                    while (reader.hasNext()) {
                        fileContent.add(reader.next());
                    }
                    for (int i = 0; i<fileContent.size();i++){
                        System.out.println(i + ": " + fileContent.get(i));
                    }
                    System.out.print("choose element to delete: ");
                    deleter = new Scanner(System.in);
                    int choice = deleter.nextInt();
                    fileContent.remove(choice);
                    for (int i = 0; i<fileContent.size();i++){
                        System.out.println(i + ": " + fileContent.get(i));
                    }
                    pw = new PrintWriter(workFile);
                    for (int i = 0; i<fileContent.size();i++){
                        pw.print(fileContent.get(i));
                        if (i+1 < fileContent.size()) {
                            pw.print(",");
                        }
                    }
                    pw.close();
                    break;
                case "5":
                    //pw = new PrintWriter(workFile);
                    fileContent = new ArrayList();
                    reader = new Scanner(workFile).useDelimiter(",");
                    while (reader.hasNext()) {
                        fileContent.add(reader.next());
                    }
                    for (int i = 0; i<fileContent.size();i++){
                        System.out.println(i + ": " + fileContent.get(i));
                    }
                    System.out.print("choose where to insert: ");
                    inserter = new Scanner(System.in);
                    int inserterChoice = inserter.nextInt();
                    System.out.print("choose what to insert: ");
                    String inserterText = inserter.next();
                    fileContent.add(inserterChoice, inserterText);
                    for (int i = 0; i<fileContent.size();i++){
                        System.out.println(i + ": " + fileContent.get(i));
                    }
                    pw = new PrintWriter(workFile);
                    for (int i = 0; i<fileContent.size();i++){
                        pw.print(fileContent.get(i));
                        if (i+1 < fileContent.size()) {
                            pw.print(",");
                        }
                    }
                    pw.close();
                    break;
                case "6":
                    System.out.println("enter file name");
                    Scanner fileNameScanner = new Scanner(System.in);
                    workFile = new File(fileNameScanner.nextLine());
                    workFile.createNewFile();
                    System.out.println(workFile.canWrite());
                    break;
                case "10":
                    running = false;
                    break;
            }
        }
    }
    
}
