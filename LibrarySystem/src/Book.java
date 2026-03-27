public class Book {
    // implement requirements A - D here
    // Declaring variables. Question A
    private String borrowerID, bookID, title, author;

    // Code to insert new book into the system. Question B
    public Book(String ID, String bookTitle, String bookAuthor) {
        this.bookID = ID;
        this.title = bookTitle;
        this.author = bookAuthor;
        this.borrowerID = null;
    }

    // Getters for bookID and title
    public String getBookID() {
        return this.bookID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBorrowerID() {
        return borrowerID;
    }

    // Added borrow method. Question D
    public boolean borrow(String ID) {
        if (this.borrowerID == null && ID != null) {
            this.borrowerID = ID;
            return true;
        } else {
            System.out.println("Book not available");
            return false;
        }
    }

    // method which allows the Book to be "returned" if it has been borrowed
    public boolean returnBook() {
        // if borrower ID has been set (ie. book has been borrowed)
        if (this.borrowerID != null) {
            // reset borrowerID to null and return true result
            this.borrowerID = null;
            System.out.println("Book returned");
            return false;
        } else {
            System.out.println("Book not on loan");
            return true;
        }
    }

    // format Book details to a String (useful for printing!)
    public String toString() {
        return String.format("Book ID: %s\nTitle: %s\nAuthor: %s\nBorrowed by: %s\n", this.bookID, this.title, this.author, this.borrowerID != null ? this.borrowerID : "Available");
    }
}