package chime;

public class Interview {

    public static String getString(String str) {
        return str + "123";
    }

    public static void main(String[] args) {
        String st = getString("hello");
        System.out.println(st);
    }
}
