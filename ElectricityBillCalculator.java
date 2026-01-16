import java.util.Scanner;

public class ElectricityBillCalculator {
    
    // Rate constants
    private static final double RATE_FIRST_TIER = 3.50;    // 0-150 units: 3.50 baht/unit
    private static final double RATE_SECOND_TIER = 4.20;   // 151-400 units: 4.20 baht/unit
    private static final double RATE_THIRD_TIER = 5.00;    // 401+ units: 5.00 baht/unit
    private static final double SERVICE_CHARGE = 50.00;    // Fixed service charge
    
    // Tier boundaries
    private static final int FIRST_TIER_LIMIT = 150;
    private static final int SECOND_TIER_LIMIT = 400;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Electricity Bill Calculator ===");
        System.out.println("Electricity rates:");
        System.out.printf("• 0-%d units: %.2f baht/unit%n", FIRST_TIER_LIMIT, RATE_FIRST_TIER);
        System.out.printf("• %d-%d units: %.2f baht/unit%n", FIRST_TIER_LIMIT + 1, SECOND_TIER_LIMIT, RATE_SECOND_TIER);
        System.out.printf("• %d+ units: %.2f baht/unit%n", SECOND_TIER_LIMIT + 1, RATE_THIRD_TIER);
        System.out.printf("Service charge: %.2f baht (fixed)%n%n", SERVICE_CHARGE);
        
        // Get user input
        System.out.print("Enter electricity usage (kWh): ");
        double usage = scanner.nextDouble();
        
        // Validate input
        if (usage < 0) {
            System.out.println("Error: Usage cannot be negative!");
            return;
        }
        
        // Calculate bill
        double totalBill = calculateElectricityBill(usage);
        
        // Display results
        System.out.println("\n=== Bill Calculation Details ===");
        System.out.printf("Electricity usage: %.2f kWh%n", usage);
        displayBillBreakdown(usage);
        System.out.printf("Service charge: %.2f baht%n", SERVICE_CHARGE);
        System.out.println("------------------------");
        System.out.printf("Total bill: %.2f baht%n", totalBill);
        
        scanner.close();
    }
    
    /**
     * Calculates the total electricity bill based on usage
     * @param usage Electricity usage in kWh
     * @return Total bill amount including service charge
     */
    public static double calculateElectricityBill(double usage) {
        double electricityCost = 0.0;
        
        if (usage <= FIRST_TIER_LIMIT) {
            // Only first tier applies
            electricityCost = usage * RATE_FIRST_TIER;
        } else if (usage <= SECOND_TIER_LIMIT) {
            // First tier + partial second tier
            electricityCost = (FIRST_TIER_LIMIT * RATE_FIRST_TIER) + 
                             ((usage - FIRST_TIER_LIMIT) * RATE_SECOND_TIER);
        } else {
            // All three tiers apply
            electricityCost = (FIRST_TIER_LIMIT * RATE_FIRST_TIER) +
                             ((SECOND_TIER_LIMIT - FIRST_TIER_LIMIT) * RATE_SECOND_TIER) +
                             ((usage - SECOND_TIER_LIMIT) * RATE_THIRD_TIER);
        }
        
        // Add fixed service charge
        return electricityCost + SERVICE_CHARGE;
    }
    
    /**
     * Displays detailed breakdown of the bill calculation
     * @param usage Electricity usage in kWh
     */
    public static void displayBillBreakdown(double usage) {
        System.out.println("Calculation breakdown:");
        
        if (usage <= FIRST_TIER_LIMIT) {
            // Only first tier
            System.out.printf("  0-%.0f units × %.2f = %.2f baht%n", 
                            usage, RATE_FIRST_TIER, usage * RATE_FIRST_TIER);
        } else if (usage <= SECOND_TIER_LIMIT) {
            // First tier + partial second tier
            double firstTierCost = FIRST_TIER_LIMIT * RATE_FIRST_TIER;
            double secondTierUnits = usage - FIRST_TIER_LIMIT;
            double secondTierCost = secondTierUnits * RATE_SECOND_TIER;
            
            System.out.printf("  0-%d units × %.2f = %.2f baht%n", 
                            FIRST_TIER_LIMIT, RATE_FIRST_TIER, firstTierCost);
            System.out.printf("  %d-%.0f units × %.2f = %.2f baht%n", 
                            FIRST_TIER_LIMIT + 1, usage, RATE_SECOND_TIER, secondTierCost);
            System.out.printf("Electricity cost subtotal: %.2f baht%n", firstTierCost + secondTierCost);
        } else {
            // All three tiers
            double firstTierCost = FIRST_TIER_LIMIT * RATE_FIRST_TIER;
            double secondTierCost = (SECOND_TIER_LIMIT - FIRST_TIER_LIMIT) * RATE_SECOND_TIER;
            double thirdTierUnits = usage - SECOND_TIER_LIMIT;
            double thirdTierCost = thirdTierUnits * RATE_THIRD_TIER;
            
            System.out.printf("  0-%d units × %.2f = %.2f baht%n", 
                            FIRST_TIER_LIMIT, RATE_FIRST_TIER, firstTierCost);
            System.out.printf("  %d-%d units × %.2f = %.2f baht%n", 
                            FIRST_TIER_LIMIT + 1, SECOND_TIER_LIMIT, RATE_SECOND_TIER, secondTierCost);
            System.out.printf("  %d-%.0f units × %.2f = %.2f baht%n", 
                            SECOND_TIER_LIMIT + 1, usage, RATE_THIRD_TIER, thirdTierCost);
            System.out.printf("Electricity cost subtotal: %.2f baht%n", 
                            firstTierCost + secondTierCost + thirdTierCost);
        }
    }
}