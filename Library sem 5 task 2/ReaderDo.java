public class ReaderDo {
    public static void main(String[] args) {
        Reader reader_1 = new Reader("Кондрашов С. К.", 1, "Прикладная Информатика", "23.12.2000", "+79685632121");
        Reader reader_2 = new Reader("Власов М.Д.", 2, "Информационная Безопасность", "08.05.1999", "+79358621415");
        Reader reader_3 = new Reader("Позднякова Е.Л.", 3, "Менеджмент", "01.01.2003", "+79602358779");
        Reader[] readers = {reader_1, reader_2, reader_3};

        Book book_1 = new Book("Война и мир 1 том", "Л. Н. Толстой");
        Book book_2 = new Book("Преступление и наказание", "Ф. М. Достоеввский");
        Book book_3 = new Book("Евгений Онегин", "А. С. Пушкин");
        Book[] books = {book_1, book_2, book_3};

        printReaders(readers);
        printBooks(books);

        reader_1.takeBook(3);
        System.out.println();
        reader_2.takeBook("Пиковая дама, Сердца в Атлантиде");
        reader_3.takeBook(book_1, book_2, book_3);

    }

    private static void printBooks(Book[] books) {
        System.out.println("Список книг:");
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
        System.out.println();
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("Список читателей:");
        for (Reader reader : readers) {
            System.out.println( reader.getInfo());
        }
        System.out.println();
    }
}