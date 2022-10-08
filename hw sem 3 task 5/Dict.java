import java.util.ArrayList;
import java.util.Locale;

public class Dict {
    ArrayList<Word> words = new ArrayList<>();

    public static void main(String[] args) {
        Dict d = new Dict();
        d.setWords("Мама мыла раму Мама мама");
        d.print();
    }

    public void setWords(String string) {
        string = string.toLowerCase(Locale.ROOT);
        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if (Character.isAlphabetic(temp)) {
                sb.append(temp);
            } else {
                if (!sb.isEmpty()) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (!sb.isEmpty()) {
            words.add(sb.toString());
        }
        this.words = prepareWords(words);
    }

    private ArrayList<Word> prepareWords(ArrayList<String> words) {
        ArrayList<Word> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            Word word = new Word(words.get(i));
            if (result.contains(word)) {
                Word temp = result.remove(result.indexOf(word));
                temp.incr();
                result.add(temp);
            } else {
                result.add(word);
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < this.words.size(); i++) {
            System.out.println(words.get(i));
        }
    }
}