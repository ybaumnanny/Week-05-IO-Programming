package com.example.basicproblems.readandprintcsv;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class ReadCSV {
    public static void main(String[]args){
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\Student.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isHeader = true;

            while((line = br.readLine())!= null){
                if (isHeader){
                    isHeader = false;
                    continue;
                }
                String[] vlaues = line.split(",");
                System.out.println("ID: " +vlaues[0] +"|"+ "Name: " +vlaues[1] +"."+ "|"+  " Age: " +vlaues[2] +"."+ "|"+ " Marks " +vlaues[3]+".");
            }


        }
        catch (IOException e){
            System.err.println("Error reading this file: " +e.getMessage());
        }

    }

}
