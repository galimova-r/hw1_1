public class Book {
    private String name;//название книги
    private String author;//автор

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return "" +
                "Название книги '" + name + '\'' +
                ", Автор '" + author + '\'' +
                ' ';
    }
}