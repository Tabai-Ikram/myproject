import java.util.ArrayList;
import java.util.List;

// هذا الكلاس لإدارة المكتبة (الكتب والمستعيرين)
public class Library {
    private List<Book> books;
    private List<Borrower> borrowers;

    public LibrarySystem() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("تمت إضافة الكتاب بنجاح!");
    }

    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println("تمت إضافة المستعير بنجاح!");
    }

    public void borrowBook(String studentId, String isbn) {
        Borrower borrower = findBorrower(studentId);
        Book book = findBook(isbn);

        if (borrower != null && book != null) {
            borrower.borrowBook(book);
        } else {
            System.out.println("المستعير أو الكتاب غير موجود.");
        }
    }

    public void returnBook(String studentId, String isbn) {
        Borrower borrower = findBorrower(studentId);
        Book book = findBook(isbn);

        if (borrower != null && book != null) {
            borrower.returnBook(book);
        } else {
            System.out.println("المستعير أو الكتاب غير موجود.");
        }
    }

    public void listBorrowedBooks(String studentId) {
        Borrower borrower = findBorrower(studentId);
        if (borrower != null) {
            borrower.listBorrowedBooks();
        } else {
            System.out.println("المستعير غير موجود.");
        }
    }

    private Borrower findBorrower(String studentId) {
        for (Borrower b : borrowers) {
            if (b.getStudentId().equals(studentId)) {
                return b;
            }
        }
        return null;
    }

    private Book findBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
}
