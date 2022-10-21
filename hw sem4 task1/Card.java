package renata.cards;

import java.time.LocalDateTime;

public abstract class Card {
    private static int num = 0;
    private int number;//номер карты
    int month = LocalDateTime.now().getMonth().getValue(); //узнаем текущий месяц
    private boolean isBlocked = false;//заблокирована ли карта
    private int numberOfWays;//число поездок
    private int remainedWays;//оставшиеся поездки
    private double sum;//кол-во денег на карте
    private double priceOfOneWay;//стоимость 1 поездки
    private double monthPay;//сколько платить в месяц

    public Card(double monthPay, double priceOfOneWay, int numberOfWays) {
        this.setNumber();
        this.setMonthPay(monthPay);
        this.setSum(0);
        this.setPriceOfOneWay(priceOfOneWay);
        this.setNumberOfWays(numberOfWays);
        this.setRemainedWays(numberOfWays);
    }

    public void setNumber() {
        this.number = Card.num;//устанавливаем номер карты
        num++;
    }

    public int getMonth() {
        return month;
    }//получаем месяц

    public void setMonth(int month) {
        this.month = month;
    }//устанавливаем месяц

    public boolean isBlocked() {
        return isBlocked;
    }//получаем заблокирована ли карта

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }//блокируем карту

    public int getNumberOfWays() {
        return numberOfWays;
    }//получаем число поездок

    public void setNumberOfWays(int numberOfWays) {
        this.numberOfWays = numberOfWays;
    }//устанавливаем число поездок

    public int getRemainedWays() {
        return remainedWays;
    }//получаем оставшиеся поездки

    public void setRemainedWays(int remainedWays) {
        this.remainedWays = remainedWays;
    }//уст ост поездки

    public double getSum() {
        return sum;
    }//получаем кол-во денег на карте

    public void setSum(double sum) {
        this.sum = sum;
    }//устанав кол-во денег на карте

    public double getPriceOfOneWay() {
        return priceOfOneWay;
    }//получ цену на 1 поездку

    public void setPriceOfOneWay(double priceOfOneWay) {
        this.priceOfOneWay = priceOfOneWay;
    }//устанавливаем цену на 1 поездку

    public double getMonthPay() {
        return monthPay;
    }//получ цену на месяц

    public void setMonthPay(double monthPay) {
        this.monthPay = monthPay;
    }//уст цену на месяц

    public void checkMonth() { //проверяем просрочен месяц или нен
        if (!isBlocked) {//если не заблокирована карта то проверим не нужно ли ее заблокировать
            if (LocalDateTime.now().getMonth().getValue() != this.getMonth()) { // если текущий месяц не равен тому который записан на карте
                this.setMonth(LocalDateTime.now().getMonth().getValue());//то записываем на карту новый т.е. текущий месяц
                this.setSum(this.getSum() - this.getMonthPay());//снимаем деньги с баланса
                this.setRemainedWays(this.getNumberOfWays());//обновляем оставшиеся поездки, записываем туда новый
                if (this.getSum() < 0) {//если сумма на карточке отрицательная то блочим карту
                    this.setBlocked(true);
                }
            }
        }
    }
}
