package renata.cards;

import java.util.Scanner;

public class Terminal {
    int cards = 0;//сколько прошло карт
    int freePasses = 0;//сколько людей прошли
    double money = 0;//сколько денег заработал терминал
    int passes = 0;// сколько раз пытались пробить карточку и удачные и не удачные попытки

    double schoolMonthPay; //сколько будет стоить школьный билет на месяц
    double studentMonthPay;//сколько будет стоить студеньческий билет на месяц
    double socialMonthPay;//сколько будет стоить социальный билет на месяц
    double schoolPrice;//сколько будет стоить школьный разовый проезд
    double studentPrice;//сколько будет стоить суденьческий разовый проезд
    double socialPrice;//сколько будет стоить социальный разовый проезд
    int schoolNumber;//кол-во поездок для школьного билета
    int studentNumber;//кол-во поездок для студеньческого билета
    int socialNumber;//кол-во поездок для соц билета(установим по умолч. -1, для бесконечныйх поездок по соц карте)

    public Terminal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month pay for school card");
        this.schoolMonthPay = scanner.nextDouble();


        System.out.println("Enter month pay for student card");
        this.studentMonthPay = scanner.nextDouble();

        System.out.println("Enter month pay for social card");
        this.socialMonthPay = scanner.nextDouble();

        System.out.println("Enter 1 way pay for school card");
        this.schoolPrice = scanner.nextDouble();

        System.out.println("Enter 1 way pay for student card");
        this.studentPrice = scanner.nextDouble();

        System.out.println("Enter 1 way pay for social card");
        this.socialPrice = scanner.nextDouble();

        System.out.println("Enter number of trips for school card");
        this.schoolNumber = scanner.nextInt();

        System.out.println("Enter number of trips for student card");
        this.studentNumber = scanner.nextInt();

        this.socialNumber = -1; //для соц карты сделаем безлимитные поездки
    }

    public Card createNewCard() {
        Card card = null;
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Enter your card type:");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "school":
                    card = new SchoolCard(schoolMonthPay, schoolPrice, schoolNumber);
                    isCorrect = true;
                    break;
                case "student":
                    card = new StudentCard(studentMonthPay, studentPrice, studentNumber);
                    isCorrect = true;
                    break;
                case "social":
                    card = new SocialCard(socialMonthPay, socialPrice, socialNumber);
                    isCorrect = true;
                    break;
                default:
                    System.out.println("Unknown type.");
            }
        }
        return card;
    }

    public void pass(Card card) { //класс для прохода
        card.checkMonth();
        this.cards++;
        this.passes++;
        if (!card.isBlocked()) {//если карта не заблочена, то проходим
            if (card.getRemainedWays() != 0) {//если оставшиеся поездки не равны 0, то проходим
                card.setRemainedWays(card.getRemainedWays() - 1);//и отнимаем 1 поездку
                this.freePasses++;//для подсчета сколько человек прошло по карте за счет поездок
                System.out.println("You may pass; paid by remaining passes.");
            } else {
                if (card.getSum() >= card.getPriceOfOneWay()) {//если поездок 0
                    card.setSum(card.getSum() - card.getPriceOfOneWay());//то снимаем опр цену за проезд с баланса
                    this.money += card.getPriceOfOneWay();//пополняем счетчик денег в терминале
                    System.out.println("You may pass; paid by card money.");
                } else {
                    this.passes--;
                    System.out.println("There is no so much money on card!");//нет ни денег ни поездок
                }
            }
        } else {
            this.passes--;
            System.out.println("Have no money on card.");//нет денег на карте, т.е. она заблочена
        }
    }

    public String getStatistics() {//выводим статистику по терминалу
        return String.format("Number of cards: %d;%sNumber of free passes: %d;%sNumber of taken money: %f;%sNumber of all passes: %d.",
                this.cards, System.lineSeparator(), this.freePasses, System.lineSeparator(), this.money, System.lineSeparator(), this.passes);
    }
}
