import java.util.*;

class LibraryItem {
    int itemId;
    int titleCode;
    boolean available;

    LibraryItem(int itemId, int titleCode, boolean available) {
        this.itemId = itemId;
        this.titleCode = titleCode;
        this.available = available;
    }
}

class Book extends LibraryItem {
    Book(int itemId, int titleCode, boolean available) {
        super(itemId, titleCode, available);
    }

    void displayDetails() {
        System.out.println("Book ID: " + itemId);
        System.out.println("Title Code: " + titleCode);
        System.out.println("Available: " + available);
    }

    void checkout() {
        if (available) {
            available = false;
            System.out.println("Book Checked Out Successfully.");
        } else {
            System.out.println("Already checked out.");
        }
    }

    void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Book Returned Successfully.");
        } else {
            System.out.println("Already available.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book ID: ");
        int itemId = sc.nextInt();

        System.out.print("Enter Title Code: ");
        int titleCode = sc.nextInt();

        System.out.print("Enter Availability (1 for available, 0 for not available): ");
        int avail = sc.nextInt();
        boolean available = (avail == 1);

        Book book = new Book(itemId, titleCode, available);

        System.out.println("Enter operations (1-Checkout, 2-Return, 3-Display). Press Ctrl+D (or Ctrl+Z in Windows) to stop:");
        while (sc.hasNextInt()) {
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    book.checkout();
                    break;
                case 2:
                    book.returnBook();
                    break;
                case 3:
                    book.displayDetails();
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }
        sc.close();
    }
}
