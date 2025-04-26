import java.time.LocalDate;

// هذا الصنف يمثل عملية إعارة كتاب من مستعير مع تواريخ الإعارة والاسترجاع
public class BorrowingProcess {
    private Book book;            // الكتاب المُعار
    private Borrower borrower;    // المستعير
    private LocalDate borrowDate; // تاريخ الإعارة
    private LocalDate returnDate; // تاريخ الاسترجاع

    // دالة البناء (Constructor) لإنشاء عملية إعارة جديدة
    public BorrowingProcess(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now(); // تعيين تاريخ الإعارة إلى اليوم الحالي
        this.returnDate = null;            // في البداية لم يتم الإرجاع
    }

    // دالة لإنهاء الإعارة (استرجاع الكتاب)
    public void completeReturn() {
        this.returnDate = LocalDate.now(); // تعيين تاريخ الاسترجاع إلى اليوم الحالي
        borrower.returnBook(book);         // استدعاء دالة استرجاع الكتاب من المستعير
        System.out.println("تم تسجيل استرجاع الكتاب: " + book.getTitle());
    }

    // Getters

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
