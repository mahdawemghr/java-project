import java.util.LinkedList;
import java.util.ListIterator;

public class LibrarySystem<E> { // questions three
    public LinkedList<Book> booksList = new LinkedList<Book>();
    public LinkedList<LibMember> membersList = new LinkedList<LibMember>();
    public int booksListSize;
    private int membersListSize;

    LibrarySystem() { // default constructor
        this.booksList = new LinkedList<>(); //! empty linked list
        this.membersList = new LinkedList<>(); //! empty linked list 
        //? fixed by Sara
        
        booksListSize = 0;
        membersListSize = 0;
    }

    // addBook method 
    public boolean addBook(Book value) {
        if (this.booksListSize == 0) {
            booksList.addFirst(value);
            booksListSize++;
            return true;
        } else {
            ListIterator<Book> iterator = this.booksList.listIterator();

            do {
                if (!iterator.hasNext()) {
                    booksList.add(value);
                    ++this.booksListSize;
                    return true;
                }
            } while(!iterator.next().equals(value));

            return false;
        }
    }

    // delete book method
    public boolean deleteBook(long accessionNum) {
        for(Book book: booksList) {
            if (book.getAccessionNum() == accessionNum) {
                if (book.getIssuedTo() != null) {
                    return false; // Book is issued to a member, cannot be deleted
                } else {
                    booksList.remove(book);
                    booksListSize--;
                    return true;
                }
            }
        }
        return false; // Book not found in the list
    }

    // add member method
    public boolean addMember(LibMember member) {
        if (membersList.contains(member)) {
            return false; // Member already exists in the list
        }

        membersList.add(member);
        membersListSize++;
        return true;
    }

    // delete member method
    public boolean deleteMember(long cprNum) { //! change it to long 
        for (LibMember member: membersList) {
            if (member.getCprNum() == cprNum) {
                if (member.getBookslssued().length > 0) {
                    return false; // Member has issued books, cannot be deleted
                }

                membersList.remove(member);
                membersListSize--;
                return true;
            }
        }
        return false; // Member not found in the list
    }

    // search book method
    public int searchBook(long accessionNum) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getAccessionNum() == accessionNum) {
                return i; // Book found at index i
            }
        }
        return -1; // Book not found
    }

    // search member method
    public int searchMember(long cprNum) { //! change it to long
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getCprNum() == cprNum) {
                return i; // Member found at index i
            }
        }
        return -1; // Member not found
    }

    public String getMember(int index) {
        if (index >= 0 && index < membersList.size()) {
            return membersList.get(index).toString();
        } else {
                return "Invalid Index";
            }
    }

    public String getBook(int index) {
        if (index >= 0 && index < booksList.size()) {
            return booksList.get(index).toString();
        } else {
                return "Invalid Index";
            }
    }

    // is empty methods 
    public boolean isEmptyBooksList() {
        return booksList.isEmpty();
    }

    public boolean isEmptyMembersList() {
        return membersList.isEmpty();
    }

    // get size methods
    public int sizeBooksList() {
        return booksListSize;
    }

    public int sizeMembersList() {
        return membersListSize;
    }
    
    public boolean issueBook(long accessionNum, long cprNum) {
        Book book = null;
        LibMember member = null;

        for (Book b : booksList) {
            if (b.getAccessionNum() == accessionNum) {
                book = b;
                break;
            }
        }

        for (LibMember m : membersList) {
            if (m.getCprNum() == cprNum) {
                member = m;
                break;
            }
        }

        if (book == null || member == null || book.getIssuedTo() != null || member.getNumBooksIssued() >= 10) {
            return false; // Book cannot be issued
        }

        member.addBookIssued(book); //! error
        book.setIssuedTo(member);
        return true;
    }

    public boolean returnBook(long accessionNum) {
        Book book = null;

        for (Book b : booksList) {
            if (b.getAccessionNum() == accessionNum) {
                book = b;
                break;
            }
        }

        if (book == null || book.getIssuedTo() == null) {
            return false; // Book cannot be returned
        }

        LibMember member = book.getIssuedTo();
        member.removeBookIssued(book); //! error
        book.setIssuedTo(null);
        return true;
    }

    public void printBooksIssued(long cprNum) {
        LibMember member = null;

        for (LibMember m: membersList) {
            if (m.getCprNum() == cprNum) {
                member = m;
                break;
            }
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        Book[] booksIssued = member.getBookslssued();

        if (booksIssued.length == 0) {
            System.out.println("No books issued to this member.");
            return;
        }

        System.out.println("Books issued to " + member.getFirstName() + " " + member.getLastName() + ":");
        for (Book book : booksIssued) {
            System.out.println(book.toString());
        }
    }

    public String toStringBook() {
        String str = " ";
        LinkedList<Book> b = booksList;
        
        for(int i = 0; i < b.size(); i++) {
            str += (b.toString() + "\n");
        }

        return str;

    }

    public String toStringMembers() {
        String str = " ";
        LinkedList<LibMember> b = membersList;
        
        for(int i = 0; i < b.size(); i++) {
            str += (b.toString() + "\n");
        }

        return str;

    }
}
