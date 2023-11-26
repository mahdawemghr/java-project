import java.util.Arrays;

public class LibMember {
    public String firstName;
    public String lastName;
    public char gender;
    public long cprNum;
    public String teleNum;
    public Book []booksIssued;
    public int numBooksIssued;

    public LibMember(){
        firstName =null;
        lastName =null;
        teleNum = null;
        gender = ' ';
        cprNum = 0L;
        booksIssued = null;
        numBooksIssued = 0;
        booksIssued = new Book[10];
    }

    public LibMember(String firstName, String lastName, char gender, long cprNum, String teleNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.teleNum = teleNum;
        booksIssued = null;
        this.numBooksIssued = 0;
        this.cprNum = cprNum;
        booksIssued = new Book[10];
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getCprNum() {
        return cprNum;
    }

    public void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }
    public Book[] getBookslssued() {
        return booksIssued;
    }

    public void setBookslssued(Book[] var1) {

    booksIssued = var1;
    }

    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    public void setNumBooksIssued(int numBooksIssued) {
        this.numBooksIssued = numBooksIssued;
    }

    public String toString() {
        return "LibMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", cprNum=" + cprNum +
                ", teleNum='" + teleNum + '\'' +
                ", booksIssued=" + Arrays.toString(booksIssued) +
                ", numBooksIssued=" + numBooksIssued +
                '}';
    }

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