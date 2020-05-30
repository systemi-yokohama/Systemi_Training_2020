
import java.util.List;

public class mysql_books {
	public static void main(String[] args) throws Exception {

        mysql_dao bookDao = new mysql_dao();

        List<mysql_dao_booksrec> allBooks = bookDao.selectAll();
        printData(allBooks);

        mysql_dao_booksrec book = new mysql_dao_booksrec();
        book.setAuthorId(1);
        book.setTitle("明暗");
        bookDao.insert(book);

        allBooks = bookDao.selectAll();
        printData(allBooks);
    }

    private static void printData(List<mysql_dao_booksrec> allBooks) {
        for (mysql_dao_booksrec book : allBooks) {
            System.out.println(book);
        }
        System.out.println();
    }
	
}