import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BookDao bookDao = new BookDao();

        List<Book> allBooks = bookDao.selectAll();
        printData(allBooks);

        Book book = new Book();
        book.setAuthorId(1);
        book.setTitle("明暗");
        bookDao.insert(book);

        allBooks = bookDao.selectAll();
        printData(allBooks);
    }

    private static void printData(List<Book> allBooks) {
        for (Book book : allBooks) {
            System.out.println(book);
        }
        System.out.println();
    }
}