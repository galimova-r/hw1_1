package renata.cards;
public abstract class Bank {//создан для классов Mobile и ATM, типа пополнение с мобильного и пополнение через банкомат, т.е. по сути одно и тоже)))
    public void fillCard(Card card, double money) {//получает карту и сол-во денег кот. нужно положить
        card.setSum(card.getSum() + money);//устанавливаем новый баланс карты
        if (card.isBlocked() && card.getSum() >= 0) {//если карта заблочена и сумма на карте больше или = 0, то карту разблокируют
            card.setBlocked(false);
        }
        System.out.println("Your card balance is " + card.getSum() + " now.");// выводится баланс
    }
}
