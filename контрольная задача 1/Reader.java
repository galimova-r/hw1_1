public class Reader {
    private String fio;//хранит фио
    private int number;//номер чит билета
    private String facultet;//факультет
    private String datebday;//дата рождения
    private String phone;//номер телефона

    public Reader(String fio, int number, String facultet, String datebday, String phone) {//создаем массив инф
        this.fio = fio;
        this.number = number;
        this.facultet = facultet;
        this.datebday = datebday;
        this.phone = phone;
    }

    public Reader() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public String getDatebday() {
        return datebday;
    }

    public void setDatebday(String datebday) {
        this.datebday = datebday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void takeBook(int number) {
        System.out.println(this.fio + " взял/-ла " + number + " книги.");//выводит кол-во взятых книг
    }

    public void takeBook(String... books) {//кто и какие книги взял
        System.out.println(this.fio + " взял/-ла следующие книги:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void takeBook(Book... books) {//кто какие книги и с каким автором
        System.out.println(this.fio + " взял/-ла следующие книги:");
        for (Book book : books) {
            System.out.println(book.getName() + ", автор - " + book.getAuthor());
        }
        System.out.println();
    }

    public void returnBook(int number) {//какое кол-во книг вернул читатель
        System.out.println(this.fio + " вернул/-ла " + number + " книги.");
    }

    public void returnBook(String... books) {//кто и какие книги вернул по названию
        System.out.println(this.fio + " вернул/-ла следующие книги:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void returnBook(Book... books) {//кто, какие книги и с каким автором вернул
        System.out.println(this.fio + " вернул/-ла следующие книги:");
        for (Book book : books) {
            System.out.println(book.getName() + ", автор - " + book.getAuthor());
        }
        System.out.println();
    }

    public String getInfo() {
        return "" +
                "ФИО '" + fio + '\'' +
                ", Номер читательского билета " + number +
                ", Факультет '" + facultet + '\'' +
                ", Дата рождения '" + datebday + '\'' +
                ", Телефон '" + phone + '\'' +
                ' ';
    }
}