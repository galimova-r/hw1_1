public enum Season {//перечисление времен года
    WINTER(-10.5), SPRING(15.7), SUMMER(23.4){//для константы лето возвращает теплое время года
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN(5.6);

    private double Temp;//переменная содержащая среднюю температуру

    Season(double temp) {
        this.Temp = temp;
    }

    public double getTemp() {
        return Temp;
    }
    public String getDescription(){//возвращает Холодное время года кроме лето
        return "Холодное время года";
    }
}
