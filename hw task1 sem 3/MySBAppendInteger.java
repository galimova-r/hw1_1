public class MySBAppendInteger extends MySB{
    public MySBAppendInteger(StringBuilder sb) {
        super(sb);
    }

    public void append(int i) {
        this.sb.append(i);
    }
}

