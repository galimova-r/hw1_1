public class SeasonDo {
    public static void main(String[] args) {
        Season season = Season.SUMMER;//переменная с моим временем года
        System.out.println(season);
        print(season.SUMMER);
        printAllValues();
    }

    public static void print(Season season){
        switch (season){//выводим я люблю ... определенный сезон
            case AUTUMN -> System.out.println("Я люблю осень");
            case SPRING -> System.out.println("Я люблю весну");
            case SUMMER -> System.out.println("Я люблю лето");
            case WINTER -> System.out.println("Я люблю зиму");
        }
    }
    public static void printAllValues(){
        for (Season s : Season.values()){// values возвращает массив содержащий инф в Season
            System.out.println(s+" "+s.getTemp()+" "+s.getDescription());//выводим название сезона ср температуру и холодное/теплое время года
        }
    }
}
