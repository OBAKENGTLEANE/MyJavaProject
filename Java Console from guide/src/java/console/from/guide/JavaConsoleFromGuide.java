/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java.console.from.guide;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class JavaConsoleFromGuide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //Inserting scanner
    Scanner scanner = new Scanner (System.in);
    
    //Prompt user for agent name and property price
    System.out.println("Enter the current estate agent name: ");
    String name = scanner.nextLine();
    System.out.println("Enter the property price: ");
    double propertyPrice = scanner.nextDouble();
    
    //Creating instance for Estate Agent
    EstateAgentSales agentSales = new EstateAgentSales(name,propertyPrice);
    
    //Estate Report
    System.out.println(System.lineSeparator()+ "ESTATE AGENT REPORT");
    System.out.println("******************** ");
    System.out.println("ESTATE AGENT NAME: "+agentSales.getName());
    System.out.println("PROPERTY PRICE: "+agentSales.getPropertyPrice());
    System.out.println("AGENT COMMISSION: "+agentSales.getAgentCommission());
    
    //Closing scanner
    scanner.close();
    }
    
}
