public class Book { // questions one
    public String title;
    public String author1;
    public String author2;
    public String publisher;
    public int yearPublication;
    public String isbn;
    public long accessionNum;
    public LibMember issuedTo;

    public Book(){ // default constructor 
        this.title = this.author1 = this.author2 = this.publisher = null;
        this.isbn = "0000000000000";
        this.accessionNum = 1000L;
        this.issuedTo = null;
        this.yearPublication = 0;
    }

    public Book(String title, String author1, String author2, String publisher, int yearPublication, String isbn, long accessionNum) { // second constructor
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        this.isbn = isbn;
        this.accessionNum = accessionNum;
        this.issuedTo = null; //! change it to null
    }

    // whole set methods 
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAccessionNum(long accessionNum) {
        this.accessionNum = accessionNum;
    }

    public void setIssuedTo(LibMember issuedTo) {
        this.issuedTo = issuedTo;
    }

    // whole get methods
    public String getTitle() {
        return title;
    }

    public String getAuthor1() {
        return author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public long getAccessionNum() {
        return accessionNum;
    }

    public LibMember getIssuedTo() {
        return issuedTo;
    }

    // equals methods
    public boolean Equals(Book var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else if (!this.getAuthor1().equalsIgnoreCase(var1.getAuthor1())) {
            return false;
        } else if (!this.getAuthor2().equalsIgnoreCase(var1.getAuthor2())) {
            return false;
        } else if (this.getAccessionNum() != var1.getAccessionNum()) {
            return false;
        } else if (this.getIssuedTo() != var1.getIssuedTo()) {
            return false;
        } else if (!this.getPublisher().equalsIgnoreCase(var1.getPublisher())) {
            return false;
        } else if (!this.getTitle().equalsIgnoreCase(var1.getTitle())) {
            return false;
        } else if (this.getYearPublication() != var1.getYearPublication()) {
            return false;
        } else {
            return this.getIsbn().equalsIgnoreCase(var1.getIsbn());
        }
    }

    // toString methods
    public String toString() {
        return "Book" + '\n'+
                "\ttitle: '" + title + '\n' +
                "\tauthor1: '" + author1 + '\n' +
                "\tauthor2: '" + author2 + '\n' +
                "\tpublisher: '" + publisher + '\n' +
                "\tyearPublication: " + yearPublication + '\n' +
                "\tisbn: " + isbn + '\n' + 
                "\taccessionNum: " + accessionNum + '\n' +
                "\tissuedTo: " + issuedTo + '\n';
    }
}
