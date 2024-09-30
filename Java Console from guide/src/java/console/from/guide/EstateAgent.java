/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.console.from.guide;

/**
 *
 * @author lab_services_student
 */
public abstract class EstateAgent implements iEstateAgent {
    private String name;
    private double propertyPrice;
    
    
    //Constructer to intialize name and property price
    public EstateAgent(String name, double propertyPrice) {
        this.name = name;
        this.propertyPrice = propertyPrice;
    }
    
    //Getter methods for name and property price
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getPropertyPrice() {
        return propertyPrice;
    }
    
    @Override
    public double getAgentCommission(){
    return propertyPrice * 0.20;
    }
    
    
    
    
    
}
