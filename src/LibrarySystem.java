import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. View All Books");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    library.addBook(new Book(isbn, title, author, genre));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    library.addMember(new Member(id, name, contact));
                    System.out.println("Member added successfully!");
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    id = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    isbn = sc.nextLine();

                    Member member = library.findMemberById(id);
                    Book book = library.findBookByISBN(isbn);

                    if (member != null && book != null && member.borrowBook(book)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Borrowing failed!");
                    }
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    id = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    isbn = sc.nextLine();

                    member = library.findMemberById(id);
                    book = library.findBookByISBN(isbn);

                    if (member != null && book != null && member.returnBook(book)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Return failed!");
                    }
                    break;

                case 5:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    library.searchBooks(keyword);
                    break;

                case 6:
                    library.showAllBooks();
                    break;

                case 7:
                    System.out.println("Thank you for using Library System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
