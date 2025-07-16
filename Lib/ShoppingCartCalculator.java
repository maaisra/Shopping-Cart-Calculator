import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * ฟังก์ชันระบบ E-commerce เพื่อคำนวณราคาสุทธิของสินค้าในตะกร้า โดยใน 1 ตะกร้าจะสามารถมีหลายสินค้าและ 1 ชิ้นจะมีรหัสประกอบด้วยรหัสการซื้อ
     * ชื่อสินค้า ราคาต่อชิ้น จำนวนที่ซื้อ โดยมีกฎส่วนลด
     * - กฎส่วนลด BOGO คือการซื้อ 1 แถม 1
     * - กฎส่วนลด BULK คือการซื้อมากกว่า 6 ชิ้นลด 10% ของราคาทั้งหมด
     * - เมื่อ items เป็น null จะทำการรีเทิร์นค่า 0.0 (จะไม่คิดราคาใด ๆ)
     * @param totalPrice double สำหรับเก็บราคารวมของสินค้าทั้งหมด
     * @param items ArrayList สำหรับการเก็บสินค้าไว้ในตะกร้า
     * @return แสดงผลราคาสินค้าหลังจากคำนวณตามเงื่อนไขต่าง ๆ
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double totalPrice = 0.0 ;
        if (items == null) {
            return totalPrice;
        } else for (CartItem cartItem : items) {
            if (cartItem.sku() == "NORMAL") {
                totalPrice += (cartItem.quantity()*cartItem.price());
            } else if (cartItem.sku() == "BOGO") {
                if (cartItem.quantity()%2 == 0) { // คัดกรณีที่เป็นซื้อของเป็นจำนวนคู่
                    totalPrice += (cartItem.quantity()/2 * cartItem.price());
                } else totalPrice += ((cartItem.quantity()+1)/2 * cartItem.price()); // คัดกรณีที่เป็นซื้อของเป็นจำนวนคี่
            } else if (cartItem.sku() == "BULK") {
                if (cartItem.quantity() > 6) {
                    totalPrice += ( (cartItem.quantity()*cartItem.price()) * 0.9 );   
                } else totalPrice += (cartItem.quantity()*cartItem.price()); // คิดราคาปกติ
            }
        }
        return totalPrice;
    }
}