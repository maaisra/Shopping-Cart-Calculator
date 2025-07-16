import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณแบบ BOGO (ซื้อ 1 แถม 1)
        ArrayList<CartItem> simpleCart1 = new ArrayList<>();
        simpleCart1.add(new CartItem("BOGO", "Cereal", 10, 3)); // 20
        double total4 = ShoppingCartCalculator.calculateTotalPrice(simpleCart1);
        if (total4 == 20.0) {
            System.out.println("PASSED: Simple cart total is correct (20.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 20.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณแบบ BULK (ส่วนลดเมื่อซื้อเยอะ)
        ArrayList<CartItem> simpleCart2 = new ArrayList<>();
        simpleCart2.add(new CartItem("BULK", "Sticker", 5.0, 10)); // 45
        double total5 = ShoppingCartCalculator.calculateTotalPrice(simpleCart2);
        if (total5 == 45.0) {
            System.out.println("PASSED: Simple cart total is correct (45.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 45.0 but got " + total5);
            failedCount++;
        }

        // Test 6: คำนวณแบบ BOGO (ซื้อ 1 แถม 1 & ซื้อปกติ)
        ArrayList<CartItem> simpleCart3 = new ArrayList<>();
        simpleCart3.add(new CartItem("BOGO", "Cereal", 10, 3)); // 20
        simpleCart3.add(new CartItem("NORMAL", "Milk", 15.0, 1)); // 15
        double total6 = ShoppingCartCalculator.calculateTotalPrice(simpleCart3);
        if (total6 == 35.0) {
            System.out.println("PASSED: Simple cart total is correct (35.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 35.0 but got " + total6);
            failedCount++;
        }

        // Test 7: คำนวณแบบ BULK (ส่วนลดเมื่อซื้อเยอะ & ซื้อของปกติ)
        ArrayList<CartItem> simpleCart4 = new ArrayList<>();
        simpleCart4.add(new CartItem("BULK", "Sticker", 5.0, 10)); // 45
        simpleCart4.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        double total7 = ShoppingCartCalculator.calculateTotalPrice(simpleCart4);
        if (total7 == 95.0) {
            System.out.println("PASSED: Simple cart total is correct (95.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 95.0 but got " + total7);
            failedCount++;
        }
        
        // Test 8: คำนวณแบบ BOGO & BULK (ใช้ด้วยกันร่วมกัน)
        ArrayList<CartItem> simpleCart5 = new ArrayList<>();
        simpleCart5.add(new CartItem("BULK", "Sticker", 5.0, 10)); // 45
        simpleCart5.add(new CartItem("BOGO", "Cereal", 10, 3)); // 20
        double total8 = ShoppingCartCalculator.calculateTotalPrice(simpleCart5);
        if (total8 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total8);
            failedCount++;
        }

        // Test 9: คำนวณแบบ BOGO โดยที่ยอดไม่ถึงเป้ากำหนด (ต้องได้ราคาเดิม)
        ArrayList<CartItem> simpleCart6 = new ArrayList<>();
        simpleCart6.add(new CartItem("BOGO", "Paper", 7.5, 5)); // 22.5
        double total9 = ShoppingCartCalculator.calculateTotalPrice(simpleCart6);
        if (total9 == 22.5) {
            System.out.println("PASSED: Simple cart total is correct (22.5)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 22.5 but got " + total9);
            failedCount++;
        }

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}