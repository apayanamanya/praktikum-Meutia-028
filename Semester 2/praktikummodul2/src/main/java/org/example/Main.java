import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    static Book[] bookList = new Book[]{
            new Book(10, "Galaksi", "Poppi Pertiwi", "Fiksi"),
            new Book(20, "Mozachiko", "Poppi Pertiwi", "Romance"),
            new Book(30, "Antares", "Rweinda", "Misteri")
    };

    static ArrayList<User> userStudents = new ArrayList<>();
    static User currentUser = null;

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== Menu ======");
            System.out.println("1. Masuk sebagai Siswa");
            System.out.println("2. Masuk sebagai Admin");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi (1-3): ");

            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    Student siswa = new Student();
                    if (siswa.login()) {
                        currentUser = siswa;
                        siswa.menuStudent();
                    }
                    break;
                case 2:
                    Admin admin = new Admin();
                    if (admin.login()) {
                        admin.menuAdmin();
                    }
                    break;
                case 3:
                    System.out.println("Program selesai!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Book {
    int id;
    String judul;
    String penulis;
    String genre;

    public Book(int id, String judul, String penulis, String genre) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
    }
}

class User {
    String name;
    String nim;

    public User(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }
}

class Student extends User {
    static HashMap<String, ArrayList<Book>> borrowedBooksMap = new HashMap<>();

    public Student() {
        super("", "");
    }

    boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Student ID (NIM): ");
        nim = scanner.nextLine();
        if (checkNim(nim)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid Student ID (NIM). Please try again.");
            return false;
        }
    }

    boolean checkNim(String nim) {
        for (User student : Main.userStudents) {
            if (student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }

    void menuStudent() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Student Dashboard ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buu");
            System.out.println("3. Pinjam buku atau Logout");
            System.out.print("Choose option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayBorrowedBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    logout();
                    System.out.println("Logout successful.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void borrowBook() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Borrow a Book ===");
            displayBookList();
            System.out.println("99. Return");

            System.out.print("Enter the book ID you want to borrow (input 99 to return): ");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            if (bookId == 99) {
                return;
            }

            Book bookToBorrow = findBookById(bookId);
            if (bookToBorrow != null && !isBookAlreadyBorrowed(bookToBorrow)) {
                borrowedBooksMap.computeIfAbsent(nim, k -> new ArrayList<>()).add(bookToBorrow);
                System.out.println("Book borrowed successfully.");
                return;
            } else {
                System.out.println("Book is not available or has been borrowed before. Please try again.");
            }
        }
    }

    void displayBookList() {
        System.out.println("=====================================");
        System.out.println("|| No || Book ID || Title || Author || Category ||");
        System.out.println("=====================================");
        for (Book book : Main.bookList) {
            System.out.println(
                    "|| " + book.id + " || " + book.judul + " || " + book.penulis + " || " + book.genre + " ||");
        }
        System.out.println("=====================================");
    }

    Book findBookById(int id) {
        for (Book book : Main.bookList) {
            if (book.id == id) {
                return book;
            }
        }
        return null;
    }

    boolean isBookAlreadyBorrowed(Book book) {
        ArrayList<Book> borrowedBooks = borrowedBooksMap.getOrDefault(nim, new ArrayList<>());
        return borrowedBooks.contains(book);
    }

    void displayBorrowedBooks() {
        ArrayList<Book> borrowedBooks = borrowedBooksMap.getOrDefault(nim, new ArrayList<>());
        System.out.println("List of Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("ID: " + book.id);
            System.out.println("Judul: " + book.judul);
            System.out.println("Penulis: " + book.penulis);
            System.out.println("Genre: " + book.genre);
            System.out.println();
        }
    }

    void logout() {
        Main.currentUser = null;
    }
}

class Admin {
    String username = "UMM";
    String password = "UMM123";

    boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed. Incorrect username or password.");
            return false;
        }
    }

    void menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Admin Dashboard ===");
            System.out.println("1. Add a student");
            System.out.println("2. Display registered students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");

            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayRegisteredStudents();
                    break;
                case 3:
                    System.out.println("Logout successful.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        String nim = inputNim();

        User newStudent = new User(name, nim);
        Main.userStudents.add(newStudent);

        System.out.println("Student added successfully.");
    }

    String inputNim() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Student ID (NIM) (15 digits long): ");
            String nim = scanner.nextLine();
            if (nim.length() == 15) {
                return nim;
            } else {
                System.out.println("Enter NIM (Must be 15 digits). Please try again.");
            }
        }
    }

    void displayRegisteredStudents() {
        System.out.println("List of Registered Students:");
        for (User student : Main.userStudents) {
            System.out.println("Name: " + student.name);
            System.out.println("NIM: " + student.nim);
            System.out.println();
        }
    }
}
