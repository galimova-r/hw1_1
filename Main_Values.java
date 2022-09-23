public class Main_Values {
    public static void main(String[] args) {
        Values values = new Values(new int[]{1,2,3}, new int[]{1,2,3});
        for (int i = 0; i<6;i++){
            int u = values.getValue();
            System.out.println(u);
        }
    }
}