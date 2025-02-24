public class StringProcessor {
    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public int countOccurrences(String text, String sub) {
        int count = 0;
        int idx = 0;

        while ((idx = text.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    public String splitAndCapitalize(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        StringProcessor sp = new StringProcessor();

        System.out.println(sp.reverseString("hello"));
        System.out.println(sp.countOccurrences("hello hello world", "hello"));
        System.out.println(sp.splitAndCapitalize("hello world from java"));
    }
}
