import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibrarySystem object = new LibrarySystem<>();


        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("\t1 - Book manager.");
            System.out.println("\t2 - Member manager.");
            System.out.println("\t0 - Quit application.");
            choice = input.nextInt();

            if(choice == 1) {
                System.out.println("\t1 - Add a book to the library.");
                System.out.println("\t2 - Remove a book from the library.");
                System.out.println("\t3 - List all books in the library.");
                System.out.println("\t4 - Search for a specific book by title or author.");
                System.out.println("\t0 - Return to menu");
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

                    System.out.print("\tisbn: ");
                    String isbn = input.next();

                    System.out.print("\taccession Num: ");
                    long accessionNum = input.nextLong();

                    Book newBook = new Book(title, firstAuthor, secondAuthor, publisher, yearPublication, isbn, accessionNum);
                    object.addBook(newBook);
                }

                if(choice == 2) {
                    System.out.print("write the accession Num: ");
                    long accessionNum = input.nextLong();

                    if(object.deleteBook(accessionNum)) {
                        System.out.println("the book has been deleted succesfully.");
                    } else {
                        System.out.println("sorry we could not found the book.");
                    }
                }

                if(choice == 3) {
                    if(object.toStringBook().equalsIgnoreCase(" ")) {
                        System.out.println("there are no books in the library yet.");
                    } else {
                        System.out.println(object.toStringBook());
                    }
                }
            }

            if(choice == 2) {
                do {
                    System.out.println("\t1 - Add a member.");
                    System.out.println("\t2 - Remove a member.");
                    System.out.println("\t3 - List all members.");
                    System.out.println("\t4 - Search for a member.");
                    System.out.println("\t0 - Return to menu");
                    choice = input.nextInt();

                    if(choice == 1) {
                        System.out.print("\tfirst name: ");
                        String firstName = input.next();

                        System.out.print("\tlast name: ");
                        String lastName = input.next();
                        
                        System.out.print("\tgender: ");
                        String gender = input.next();

                        System.out.print("\tcpr number: ");
                        long cprNum = input.nextLong();

                        System.out.print("\ttelephone number: ");
                        String teleNum = input.next();

                        LibMember newMember = new LibMember();
                        object.addMember(newMember);
                    }

                    if(choice == 2) {
                        System.out.print("write the accession Num: ");
                        long accessionNum = input.nextLong();

                        if(object.deleteBook(accessionNum)) {
                            System.out.println("the book has been deleted succesfully.");
                        } else {
                            System.out.println("sorry we could not found the book.");
                        }
                    }

                    if(choice == 3) {
                        if(object.toStringBook().equalsIgnoreCase(" ")) {
                            System.out.println("there are no books in the library yet.");
                        } else {
                            System.out.println(object.toStringBook());
                        }
                    }
                } while (!(choice == 0));
            }

            
        } while(!(choice == 0));
    }

}
