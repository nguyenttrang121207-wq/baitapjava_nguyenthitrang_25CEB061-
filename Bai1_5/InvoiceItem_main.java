package Bai1_5;

import Bai1_5.InvoiceItem;

public class InvoiceItem_main {
    public static void main(String[] args) {
        InvoiceItem item1 = new InvoiceItem("A101", "Pen Red", 888, 0.08);
        System.out.println(item1);
        item1.setQty(999);
        item1.setUnitPrice(0.99);
        System.out.println(item1);
        System.out.println("id is: " + item1.getId());
        System.out.println("desc is: " + item1.getDesc());
        System.out.println("qty is: " + item1.getQty());
        System.out.println("unitPrice is: " + item1.getUnitPrice());
        System.out.printf("The total is: %.2f%n", item1.getTotal());
    }
}
