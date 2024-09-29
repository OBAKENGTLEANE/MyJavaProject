package reprt.from.guide;

/**
 *
 * @author lab_services_student
 */
public class ReprtFromGuide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Defining arrays
        String manufacturer[] = {"CANON", "SONY", "NIKON"};
        int prices[][] =
        {{10500, 8500},
        {9500, 7200},
        {12000, 8000}};
        int[] differences = new int[manufacturer.length];
        
        // Declaration
        String manufacturerWithMaxDifference = "";
        int maxDifference = 0;
        
        // Printing Report
        
        // Heading
        System.out.println("_______________________________________");
        System.out.println("CAMERA REPORT TECHNOLOGY:");
        System.out.println("_______________________________________");
        
        // Manufacturers and their prices
        System.out.printf("%-12s %10s %-4s" + System.lineSeparator(),"","Mirroless","DSLR");
        for (int i = 0; i < manufacturer.length; i++) {
            int mirrorlessPrice = prices[i][0];
            int dslrPrice = prices[i][1];
            
            // Calculating difference
            differences[i] = Math.abs(mirrorlessPrice - dslrPrice);
            
            // Finding manufacturer with the highest difference
            if (differences[i] > maxDifference) {
                maxDifference = differences[i];
                manufacturerWithMaxDifference = manufacturer[i];
            }
            
            // Displaying manufacturers and their prices
            System.out.printf("%-13s %-10d %-4d" + System.lineSeparator(), manufacturer[i], mirrorlessPrice, dslrPrice);
        }
        
        // Displaying differences and adding stars
        System.out.println("_______________________________________");
        System.out.println("PRICE DIFFERENCES");
        
        for (int i = 0; i < manufacturer.length; i++) {
            String stars = (differences[i] > 2500) ? "***" : "";
            System.out.printf("%-13s: %-10d %s" + System.lineSeparator(), manufacturer[i], differences[i], stars);
        }
        
        // Displaying max difference after the loop
        System.out.println("_______________________________________");
        System.out.println("The highest difference is from: " + manufacturerWithMaxDifference);
       
    }
}