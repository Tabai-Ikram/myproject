import java.util.ArrayList;
import java.util.List;

// هذا الصنف يمثل مستعير في نظام المكتبة
public class Borrower {
    // خصائص المستعير
    private String name;      // اسم المستعير
    private String studentId; // الرقم الجامعي للمستعير
    private List<Book> borrowedBooks; // قائمة بالكتب المستعارة

    // دالة البناء (Constructor) لإنشاء مستعير جديد
    public Borrower(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>(); // في البداية لا توجد كتب مستعارة
    }

    // دالة لإعارة كتاب للمستعير
    public void borrowBook(Book book) {
        if (!book.isBorrowed()) { // تأكد أن الكتاب متاح
            borrowedBooks.add(book);
            book.borrowBook(); // استدعاء دالة إعارة الكتاب
            System.out.println(name + " استعار الكتاب: " + book.getTitle());
        } else {
            System.out.println("الكتاب غير متاح للإعارة: " + book.getTitle());
        }
    }

    // دالة لاسترجاع كتاب من المستعير
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook(); // استدعاء دالة استرجاع الكتاب
            System.out.println(name + " أعاد الكتاب: " + book.getTitle());
        } else {
            System.out.println("هذا الكتاب ليس في قائمة استعارات " + name);
        }
    }

    // دالة لعرض كل الكتب المستعارة من قبل المستعير
    public void listBorrowedBooks() {
        System.out.println("الكتب المستعارة بواسطة " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle() + " (" + book.getAuthor() + ")");
        }
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
