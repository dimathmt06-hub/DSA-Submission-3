public class RabbitProblem {
    
    public static int rabbitPairsRecursive(int months) {
        if (months <= 1) {
            return 1;
        }
        return rabbitPairsRecursive(months - 1) + rabbitPairsRecursive(months - 2);
    }
    
    public static int rabbitPairsIterative(int months) {
        if (months <= 1) {
            return 1;
        }
        
        int previousMonth = 1;  
        int currentMonth = 1;   
        int total = 0;
        
        for (int i = 2; i <= months; i++) {
            total = previousMonth + currentMonth;  
            previousMonth = currentMonth;      
            currentMonth = total;
        }
        return total;
    }
    
    public static void showRabbitGrowth(int months) {
        System.out.println("Month | Pairs | Explanation");
        System.out.println("------|-------|------------");
        
        int previousMonth = 1;
        int currentMonth = 1;
        
        System.out.printf("%5d | %5d | Start with 1 baby pair%n", 0, 1);
        System.out.printf("%5d | %5d | Still babies%n", 1, 1);
        
        for (int i = 2; i <= months; i++) {
            int next = previousMonth + currentMonth;
            System.out.printf("%5d | %5d | %d mature pairs give birth%n", 
                              i, next, currentMonth);
            previousMonth = currentMonth;
            currentMonth = next;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Rabbit Problem (Fibonacci) ===\n");
        
        System.out.println("--- Month-by-Month Growth ---");
        showRabbitGrowth(10);
        
        System.out.println("\n--- Results Comparison ---");
        System.out.println("Months | Recursive | Iterative");
        System.out.println("-------|-----------|----------");
        
        for (int m = 0; m <= 10; m++) {
            int rec = rabbitPairsRecursive(m);
            int iter = rabbitPairsIterative(m);
            System.out.printf("%6d | %9d | %9d%n", m, rec, iter);
        }
        
        System.out.println("\n--- Large Number Test ---");
        System.out.println("After 30 months: " + rabbitPairsIterative(30) + " pairs");
        System.out.println("After 50 months: " + rabbitPairsIterative(50) + " pairs");
    }
}