// هذا الصنف يمثل كتابًا داخل النظام
public class Book {
    // خصائص الكتاب (معلومات خاصة)
    private String title;     // عنوان الكتاب
    private String author;    // مؤلف الكتاب
    private String isbn;      // رقم ISBN للكتاب
    private String type;      // نوع الكتاب (ورقي أو إلكتروني)
    private boolean isBorrowed; // حالة الكتاب (معار أم لا)

    // دالة البناء (Constructor) لإنشاء كائن جديد من نوع Book
    public Book(String title, String author, String isbn, String type) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
        this.isBorrowed = false; // في البداية الكتاب غير معار
    }

    // دالة لإعارة الكتاب
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("تم إعارة الكتاب: " + title);
        } else {
            System.out.println("الكتاب معار بالفعل: " + title);
        }
    }

    // دالة لاسترجاع الكتاب
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("تم استرجاع الكتاب: " + title);
        } else {
            System.out.println("الكتاب لم يتم إعارته بعد: " + title);
        }
    }

    // Getters (للوصول للبيانات بشكل آمن)

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getType() {
        return type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Setter لو احتجنا تغيير حالة الإعارة يدويًا
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
