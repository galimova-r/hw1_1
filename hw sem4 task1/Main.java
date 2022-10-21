package renata.cards;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();//создаем терминал
        Card mycard = terminal.createNewCard();//создам карту

        ATM atm = new ATM();
        atm.fillCard(mycard, 1000000);//положим на баланс карты через банкомат 1000000 у.е.
        for (int i = 0; i < 10; i++) {//сделаем цикл для проверки, что мы типа прошли через терминал 10 раза
            terminal.pass(mycard);//проходим используя мою карту будут выводиться сообщения, о том как и успешно ли мы прошли
        }
        System.out.println("*****");
        System.out.println(terminal.getStatistics());//выведется статистика терминала

        System.out.println();
    }
}
