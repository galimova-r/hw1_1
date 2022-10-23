package renata.worker;

import java.io.*;
import java.util.ArrayList;

public class Firm {

    public final String fileName = "info.txt";

    public static void main(String[] args) throws Exception {
        Firm firm = new Firm();
        firm.newWorker(new HourWorker(firm.getWorkerId(), "Vasily", 200));//создаем работников
        firm.newWorker(new HourWorker(firm.getWorkerId(), "Olga", 250));
        firm.newWorker(new MonthWorker(firm.getWorkerId(), "Maia", 75000));
        firm.newWorker(new MonthWorker(firm.getWorkerId(), "Elena", 15000));
        firm.newWorker(new MonthWorker(firm.getWorkerId(), "Svetlana", 75000));
        firm.newWorker(new HourWorker(firm.getWorkerId(), "Dinara", 200));
        firm.newWorker(new HourWorker(firm.getWorkerId(), "Oleg", 200));
        firm.arrange();
        for (int i = 0; i < firm.getWorkers().size(); i++) {//вывод отсортированного списка работников
            System.out.printf("Id: %d; name: %s; salary in month: %f.%s", firm.getWorkers().get(i).getId(),
                    firm.getWorkers().get(i).getName(), firm.getWorkers().get(i).count(), System.lineSeparator());
        }
        System.out.println("-------");//вывод 5 первых имен
        for (int i = 0; i < firm.getWorkers().size(); i++) {
            System.out.println(firm.getWorkers().get(i).getName());
            if (i == 4) {
                break;
            }
        }
        System.out.println("-------");//вывод последних трех ID
        for (int i = 0; i < firm.getWorkers().size(); i++) {
            System.out.println("Id: " + firm.getWorkers().get(firm.getWorkers().size() - 1 - i).getId());
            if (i == 2) {
                break;
            }
        }

        firm.write();
        ArrayList<Worker> newFirm = firm.read();
        System.out.println();
    }


    private int workerId = 0;
    private ArrayList<Worker> workers = new ArrayList<>();

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public int getWorkerId() {
        return ++this.workerId;
    }

    public void newWorker(Worker worker) {
        workers.add(worker);
    }

    public void arrange() {
        for (int i = 0; i < workers.size() - 1; i++) {
            for (int j = i + 1; j < workers.size(); j++) {
                if ((workerComparator(workers.get(i), workers.get(j))) < 0) {//после сравнения зп меняем работников,сортируем
                    Worker temp = workers.get(i);
                    workers.set(i, workers.get(j));
                    workers.set(j, temp);
                }
            }
        }
    }

    private int workerComparator(Worker one, Worker two) {//сравниваем зп
        int result = 0;
        if (one.count() > two.count()) {
            result = 1;
        } else if (one.count() < two.count()) {
            result = -1;
        } else {
            result = two.getName().compareTo(one.getName());
        }
        return result;
    }

    private void write() {
        String info = "@";
        for (int i = 0; i < workers.size(); i++) {
            info += workers.get(i).toString();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));//записывать на файл
            bw.write(info);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Worker> read() throws Exception {//чтобы читать с файла
        ArrayList<Worker> workers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String info = br.readLine();
        String[] infos = info.split("@");
        if ((infos.length % 4 - 1) != 0) {
            throw new Exception("Broken data");
        }
        for (int i = 1; i < infos.length; i = i + 4) {
            String id = infos[i];//получаем по очереди id, имя, зп, тип работы
            String name = infos[i + 1];
            String getForPay = infos[i + 2];
            String type = infos[i + 3];
            if (this.isName(id) || this.isName(getForPay) || !this.checkType(type)) {
                throw new Exception("Impossible data.");
            } else {
                Worker temp;
                if (type.equals("MonthWorker")) {//пока читаем с фала проверяем помесячная  оплата или почасовая в зависимости от этого зоздаем нового работника по параметрам
                    temp = new MonthWorker(Integer.parseInt(id), name, Double.parseDouble(getForPay));
                } else {
                    temp = new HourWorker(Integer.parseInt(id), name, Double.parseDouble(getForPay));
                }
                workers.add(temp);
            }
        }
        return workers;
    }

    private boolean checkType(String type) {
        return type.equals("HourWorker") || type.equals("MonthWorker");
    }//проваеряем тип работника час/месяц

    private boolean isName(String name) {
        boolean good = false;
        for (int i = 0; i < name.length(); i++) {
            if (!(Character.isDigit(name.charAt(i)) || name.charAt(i) == '.')) {//проверяем что в файле цифры
                good = true;
                break;
            }
        }
        return good;
    }


}
