import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// هذا هو الكلاس الرئيسي لتشغيل النظام
public class LibrarySystem {
    // إنشاء قوائم لحفظ الكتب والمستعيرين
    private static List<Book> books = new ArrayList<>();
    private static List<Borrower> borrowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // لاستقبال مدخلات المستخدم

        boolean running = true;

        // حلقة لإظهار القائمة بشكل مستمر حتى يختار المستخدم الخروج
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
            scanner.nextLine(); // لقراءة السطر بعد الرقم

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addBorrower(scanner);
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    listBorrowedBooks(scanner);
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

    // دالة لإضافة كتاب
    private static void addBook(Scanner scanner) {
        System.out.print("أدخل عنوان الكتاب: ");
        String title = scanner.nextLine();
        System.out.print("أدخل مؤلف الكتاب: ");
        String author = scanner.nextLine();
        System.out.print("أدخل رقم ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("أدخل نوع الكتاب (ورقي/إلكتروني): ");
        String type = scanner.nextLine();

        Book book = new Book(title, author, isbn, type);
        books.add(book);

        System.out.println("تمت إضافة الكتاب بنجاح!");
    }

    // دالة لإضافة مستعير
    private static void addBorrower(Scanner scanner) {
        System.out.print("أدخل اسم المستعير: ");
        String name = scanner.nextLine();
        System.out.print("أدخل الرقم الجامعي: ");
        String studentId = scanner.nextLine();

        Borrower borrower = new Borrower(name, studentId);
        borrowers.add(borrower);

        System.out.println("تمت إضافة المستعير بنجاح!");
    }

    // دالة لإعارة كتاب
    private static void borrowBook(Scanner scanner) {
        System.out.print("أدخل الرقم الجامعي للمستعير: ");
        String studentId = scanner.nextLine();
        Borrower borrower = findBorrower(studentId);

        if (borrower != null) {
            System.out.print("أدخل رقم ISBN للكتاب: ");
            String isbn = scanner.nextLine();
            Book book = findBook(isbn);

            if (book != null) {
                borrower.borrowBook(book);
            } else {
                System.out.println("الكتاب غير موجود.");
            }
        } else {
            System.out.println("المستعير غير موجود.");
        }
    }

    // دالة لاسترجاع كتاب
    private static void returnBook(Scanner scanner) {
        System.out.print("أدخل الرقم الجامعي للمستعير: ");
        String studentId = scanner.nextLine();
        Borrower borrower = findBorrower(studentId);

        if (borrower != null) {
            System.out.print("أدخل رقم ISBN للكتاب: ");
            String isbn = scanner.nextLine();
            Book book = findBook(isbn);

            if (book != null) {
                borrower.returnBook(book);
            } else {
                System.out.println("الكتاب غير موجود.");
            }
        } else {
            System.out.println("المستعير غير موجود.");
        }
    }

    // دالة لعرض الكتب المستعارة لمستعير
    private static void listBorrowedBooks(Scanner scanner) {
        System.out.print("أدخل الرقم الجامعي للمستعير: ");
        String studentId = scanner.nextLine();
        Borrower borrower = findBorrower(studentId);

        if (borrower != null) {
            borrower.listBorrowedBooks();
        } else {
            System.out.println("المستعير غير موجود.");
        }
    }

    // دالة لمساعدتنا للبحث عن مستعير بالرقم الجامعي
    private static Borrower findBorrower(String studentId) {
        for (Borrower b : borrowers) {
            if (b.getStudentId().equals(studentId)) {
                return b;
            }
        }
        return null;
    }

    // دالة لمساعدتنا للبحث عن كتاب برقم ISBN
    private static Book findBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
}
