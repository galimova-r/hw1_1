
public class Main {
    public static void main(String[] args) {
        StringBuilder test = new StringBuilder();
        MySBAppendString str = new MySBAppendString(test);
        MySBAppendInteger integer = new MySBAppendInteger(test);
        str.append(1);
        System.out.println();
    }
}
