import java.util.Scanner;
// هذا الكلاس يحتوي فقط على main لتشغيل النظام
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem(); // إنشاء نسخة من نظام المكتبة

        boolean running = true;

        while (running) {
            System.out.println("\n==== نظام إدارة مكتبة بسيط ====");
            System.out.println("1. إضافة كتاب جديد");
            System.out.println("2. إضافة مستعير جديد");
            System.out.println("3. إعارة كتاب");
            System.out.println("4. استرجاع كتاب");
            System.out.println("5. عرض الكتب المستعارة لمستعير");
            System.out.println("6. الخروج");
            System.out.print("اختر خياراً: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // تنظيف السطر

            switch (choice) {
                case 1:
                    System.out.print("أدخل عنوان الكتاب: ");
                    String title = scanner.nextLine();
                    System.out.print("أدخل مؤلف الكتاب: ");
                    String author = scanner.nextLine();
                    System.out.print("أدخل رقم ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("أدخل نوع الكتاب (ورقي/إلكتروني): ");
                    String type = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn, type));
                    break;

                case 2:
                    System.out.print("أدخل اسم المستعير: ");
                    String name = scanner.nextLine();
                    System.out.print("أدخل الرقم الجامعي: ");
                    String studentId = scanner.nextLine();
                    library.addBorrower(new Borrower(name, studentId));
                    break;

                case 3:
                    System.out.print("أدخل الرقم الجامعي للمستعير: ");
                    String borrowerId = scanner.nextLine();
                    System.out.print("أدخل رقم ISBN للكتاب: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowerId, borrowIsbn);
                    break;

                case 4:
                    System.out.print("أدخل الرقم الجامعي للمستعير: ");
                    String returnBorrowerId = scanner.nextLine();
                    System.out.print("أدخل رقم ISBN للكتاب: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnBorrowerId, returnIsbn);
                    break;

                case 5:
                    System.out.print("أدخل الرقم الجامعي للمستعير: ");
                    String listId = scanner.nextLine();
                    library.listBorrowedBooks(listId);
                    break;

                case 6:
                    running = false;
                    System.out.println("تم إنهاء البرنامج. شكراً لاستخدامك النظام!");
                    break;

                default:
                    System.out.println("خيار غير صالح. حاول مرة أخرى.");
            }
        }

        scanner.close();
    }
}
