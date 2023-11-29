import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibrarySystem object = new LibrarySystem<>();


        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("\t1 - Add a book to the library.");
            System.out.println("\t2 - Remove a book from the library.");
            System.out.println("\t3 - List all books in the library.");
            System.out.println("\t4 - Search for a specific book by title or author.");
            System.out.println("\t5 - Quit application.");
            choice = input.nextInt();

            if(choice == 1) {
                System.out.print("\ttitle: ");
                String title = input.next();

                System.out.print("\tfirst author: ");
                String firstAuthor = input.next();
                
                System.out.print("\tsecond author: ");
                String secondAuthor = input.next();

                System.out.print("\tpublisher: ");
                String publisher = input.next();

                System.out.print("\tyear publication: ");
                int yearPublication = input.nextInt();

                System.out.print("\tisbn");
                String isbn = input.next();

                System.out.print("\taccession Num: ");
                long accessionNum = input.nextLong();

                Book newBook = new Book(title, firstAuthor, secondAuthor, publisher, yearPublication, isbn, accessionNum);
                object.addBook(newBook);
            }

            if(choice == 2) {

            }

            if(choice == 3) {
                
            }
        } while(!(choice == 5));
    }

}
