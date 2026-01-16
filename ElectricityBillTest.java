public class ElectricityBillTest {
    
    public static void main(String[] args) {
        System.out.println("=== Electricity Bill Calculator Test Cases ===\n");
        
        // Test case 1: Low usage (within first tier)
        testBillCalculation(100, "Low usage - First tier only");
        
        // Test case 2: Medium usage (crosses into second tier)
        testBillCalculation(250, "Medium usage - First and second tiers");
        
        // Test case 3: High usage (all three tiers)
        testBillCalculation(500, "High usage - All three tiers");
        
        // Test case 4: Boundary cases
        testBillCalculation(150, "Boundary case - Exactly 150 units");
        testBillCalculation(400, "Boundary case - Exactly 400 units");
        
        // Test case 5: Zero usage
        testBillCalculation(0, "Zero usage");
    }
    
    private static void testBillCalculation(double usage, String testCase) {
        System.out.println("--- " + testCase + " ---");
        System.out.printf("Usage: %.2f kWh%n", usage);
        
        double totalBill = ElectricityBillCalculator.calculateElectricityBill(usage);
        ElectricityBillCalculator.displayBillBreakdown(usage);
        
        System.out.printf("Service charge: 50.00 baht%n");
        System.out.println("------------------------");
        System.out.printf("Total bill: %.2f baht%n%n", totalBill);
    }
}