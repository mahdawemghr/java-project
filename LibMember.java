import java.util.Arrays;

public class LibMember { // questions two 
    public String firstName;
    public String lastName;
    public char gender;
    public long cprNum;
    public String teleNum;
    public Book []booksIssued;
    public int numBooksIssued;

    public LibMember(){ // default constructor 
        firstName =null;
        lastName =null;
        teleNum = null;
        gender = ' ';
        cprNum = 0L;
        booksIssued = null;
        numBooksIssued = 0;
        booksIssued = new Book[10];
    }

    public LibMember(String firstName, String lastName, char gender, long cprNum, String teleNum) { // second constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.teleNum = teleNum;
        booksIssued = null;
        this.numBooksIssued = 0;
        this.cprNum = cprNum;
        booksIssued = new Book[10];
    }

    // whole get methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public long getCprNum() {
        return cprNum;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public Book[] getBookslssued() {
        return booksIssued; //! check it
    }

    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    // whole set methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    public void setBooksIssued(Book[] var1) {
    booksIssued = new Book[var1.length];
    for (int i = 0; i < var1.length; i++) {
        booksIssued[i] = var1[i];
    }
    }

    public void setNumBooksIssued(int numBooksIssued) {
        this.numBooksIssued = numBooksIssued;
    }

    public void addBookIssued(Book book) {
        booksIssued[booksIssued.length - 1] = book;
    }

    public void removeBookIssued(Book book) {
        for (int i = 0; i < booksIssued.length; i++) {
            if (booksIssued[i].equals(book)) {
                booksIssued[i] = null;
                break;
            }
        }
    }

    // toString methods 
    public String toString() {
        return "LibMember" + '\n' +
                "\tfirstName: " + firstName + '\n' +
                "\tlastName: " + lastName + '\n' +
                "\tgender: " + gender + '\n' +
                "\tcprNum: " + cprNum + '\n' +
                "\tteleNum: " + teleNum + '\n' +
                "\tbooksIssued: " + Arrays.toString(booksIssued) + '\n' +
                "\tnumBooksIssued: " + numBooksIssued + '\n';
    }

    // equals methods 
    public boolean Equals(LibMember var) {
        if (this == var) {
            return true;
        } else if (var == null) {
            return false;
        } else if (!this.getFirstName().equalsIgnoreCase(var.getFirstName())) {
            return false;
        } else if (!this.getLastName().equalsIgnoreCase(var.getLastName())) {
            return false;
        } else if (!this.getTeleNum().equalsIgnoreCase(var.getTeleNum())) {
            return false;
        } else if (!Arrays.toString(booksIssued).equalsIgnoreCase(Arrays.toString(booksIssued))) {
            return false;
        } else if (this.getCprNum() != var.getCprNum()) {
            return false;
        } else if (this.getGender() != var.getGender()) {
            return false;
        } else {
            return this.getNumBooksIssued() == var.getNumBooksIssued();
        }
    }
}
