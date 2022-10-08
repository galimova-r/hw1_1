public class MySBAppendString extends MySB {
    public MySBAppendString(StringBuilder sb) {
        super(sb);
    }

    public void append(int i) {
        this.sb.append(i);
    }
}
