import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LibraryMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        LibrarySystem object = new LibrarySystem<>();


        int choice, choice1 = 0;
        do {
            System.out.println("Menu:");
            System.out.println("\t1 - Book manager.");
            System.out.println("\t2 - Member manager.");
            System.out.println("\t3 - Add member & book.");
            System.out.println("\t0 - Quit application.");
            choice = input.nextInt();

            if(choice < 0 || 4 <= choice) {
                System.out.println("Invalid option!");
                TimeUnit.SECONDS.sleep(2);
                continue;
            }

            do {
                if(choice == 1) {
                    System.out.println("\t1 - Add a book to the library.");
                    System.out.println("\t2 - Remove a book from the library.");
                    System.out.println("\t3 - List all books in the library.");
                    System.out.println("\t4 - Search for a specific book by title.");
                    System.out.println("\t5 - Search for a specific book by author.");
                    System.out.println("\t0 - Return to menu");
                    choice1 = input.nextInt();

                    if(choice1 < 0 || 6 <= choice1) {
                        System.out.println("Invalid option!");
                        TimeUnit.SECONDS.sleep(2);
                        continue;
                    }

                    if(choice1 == 1) {
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

                    if(choice1 == 2) {
                        System.out.print("write the accession Num: ");
                        long accessionNum = input.nextLong();

                        if(object.deleteBook(accessionNum)) {
                            System.out.println("the book has been deleted succesfully.");
                        } else {
                            System.out.println("sorry we could not found the book.");
                        }
                    }

                    if(choice1 == 3) {
                        if(object.toStringBook().equalsIgnoreCase(" ")) {
                            System.out.println("there are no books in the library yet.");
                            TimeUnit.SECONDS.sleep(2);
                        } else {
                            System.out.println(object.toStringBook());
                        }
                    }

                    if(choice1 == 4) {
                        System.out.print("please write the accession Num Number: ");
                        long accessionNum = input.nextLong();

                        if(object.searchBook(accessionNum) == -1) {
                            System.out.println("we could not find this book");
                        } else {
                            System.out.println(object.getBook(object.searchBook(accessionNum)));
                        }
                    }

                    if(choice1 == 5) {
                        System.out.print("please enter the accession number: ");
                        long accessionNum = input.nextLong();

                        object.printBooksIssued(accessionNum);
                    }
                }
            } while (!(choice1 == 0));

            if(choice == 2) {
                do {
                    System.out.println("\t1 - Add a member.");
                    System.out.println("\t2 - Remove a member.");
                    System.out.println("\t3 - List all members.");
                    System.out.println("\t4 - Search for a member.");
                    System.out.println("\t5 - Search the book issued to member.");
                    System.out.println("\t0 - Return to menu");
                    choice1 = input.nextInt();

                    if(choice1 < 0 || 6 <= choice1) {
                        System.out.println("Invalid option!");
                        TimeUnit.SECONDS.sleep(2);
                        continue;
                    }

                    if(choice1 == 1) {
                        System.out.print("\tfirst name: ");
                        String firstName = input.next();

                        System.out.print("\tlast name: ");
                        String lastName = input.next();
                        
                        System.out.print("\tgender: ");
                        char gender = input.next().charAt(0);

                        System.out.print("\tcpr number: ");
                        long cprNum = input.nextLong();

                        System.out.print("\ttelephone number: ");
                        String teleNum = input.next();

                        LibMember newMember = new LibMember(firstName, lastName, gender, cprNum, teleNum);
                        object.addMember(newMember);
                    }

                    if(choice1 == 2) {
                        System.out.print("write the CPR Num: ");
                        long cprNum = input.nextLong();

                        if(object.deleteMember(cprNum)) {
                            System.out.println("the member has been deleted succesfully.");
                        } else {
                            System.out.println("sorry we could not found the member.");
                        }
                    }

                    if(choice1 == 3) {
                        if(object.toStringMembers().equalsIgnoreCase(" ")) {
                            System.out.println("there are no member yet.");
                            TimeUnit.SECONDS.sleep(2);
                        } else {
                            System.out.println(object.toStringMembers());
                        }
                    }

                    if(choice1 == 4) {
                        System.out.print("please write the CPR Number: ");
                        long cprNum = input.nextLong();

                        if(object.searchMember(cprNum) == -1) {
                            System.out.println("we could not find this member");
                        } else {
                            System.out.println(object.getMember(object.searchMember(cprNum)));
                        }
                    }

                    if(choice1 == 5) {
                        System.out.print("please write the CPR number of the member you want: ");
                        long cpr = input.nextLong();

                        object.printBooksIssued(cpr);
                    }
                } while (!(choice1 == 0));
            }

            if(choice == 3) {
                System.out.print("\tenter the CPR:");
                long cpr = input.nextLong();

                System.out.print("\tenter the accession Number:");
                long accessionNum = input.nextLong();
                object.issueBook(accessionNum, cpr);
            }

            
        } while(!(choice == 0));
    }
}
