package labassignments.lab07;
import java.util.*;

class Analyzer {
    private String text;
    private List<String> reserved;
    private List<String> words;
    private Map<String, Integer> freq;

    public Analyzer(String input, List<String> res) {
        this.text = input;
        this.reserved = res;
        this.words = new ArrayList<>();
        this.freq = new LinkedHashMap<>();
        process();
    }

    private void process() {
        String clean = text.toLowerCase().replaceAll("[.,;:'\"\\-—]", "");
        String[] arr = clean.split("\\s+");

        for (String w : arr) {
            if (!w.isEmpty()) {
                words.add(w);
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }
    }

    public ArrayList<String> getUnique() {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (String w : words) {
            if (!seen.contains(w)) {
                ans.add(w);
                seen.add(w);
            }
        }
        return ans;
    }

    public ArrayList<String> getSorted() {
        ArrayList<String> ans = new ArrayList<>(freq.keySet());
        Collections.sort(ans);
        return ans;
    }

    public ArrayList<String> getByLength() {
        ArrayList<String> ans = new ArrayList<>(freq.keySet());

        Collections.sort(ans, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }
                return a.compareTo(b);
            }
        });
        return ans;
    }

    public ArrayList<String> getByFreq() {
        ArrayList<String> ans = new ArrayList<>(freq.keySet());

        Collections.sort(ans, new Comparator<String>() {
            public int compare(String a, String b) {
                return freq.get(a) - freq.get(b);
            }
        });
        return ans;
    }

    public ArrayList<String> getLetterCount() {
        Map<Character, Integer> count = new TreeMap<>();

        for (String w : freq.keySet()) {
            if (!w.isEmpty()) {
                char c = w.charAt(0);
                if (Character.isLetter(c)) {
                    count.put(c, count.getOrDefault(c, 0) + 1);
                }
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> e : count.entrySet()) {
            ans.add(e.getKey() + " " + e.getValue());
        }
        return ans;
    }

    public ArrayList<String> getReservedOrder() {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> resSet = new HashSet<>();

        for (String w : reserved) {
            resSet.add(w.toLowerCase());
        }

        Set<String> seen = new HashSet<>();
        for (String w : words) {
            if (resSet.contains(w) && !seen.contains(w)) {
                ans.add(w);
                seen.add(w);
            }
        }
        return ans;
    }

    public ArrayList<String> getReservedFreq() {
        Set<String> resSet = new HashSet<>();
        for (String w : reserved) {
            resSet.add(w.toLowerCase());
        }

        ArrayList<String> ans = new ArrayList<>();
        for (String w : freq.keySet()) {
            if (resSet.contains(w)) {
                ans.add(w);
            }
        }

        Collections.sort(ans, new Comparator<String>() {
            public int compare(String a, String b) {
                return freq.get(b) - freq.get(a);
            }
        });
        return ans;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter reserved words: ");
        String resLine = sc.nextLine();
        List<String> reserved = Arrays.asList(resLine.trim().split("\\s+"));

        System.out.print("Enter text (type END on new line when done): ");
        StringBuilder sb = new StringBuilder();
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.equals("END")) break;
            sb.append(line).append(" ");
        }
        String input = sb.toString().trim();

        sc.close();

        Analyzer a = new Analyzer(input, reserved);

        System.out.println("1a:");
        print(a.getUnique());

        System.out.println("\n1b:");
        print(a.getSorted());

        System.out.println("\n1c:");
        print(a.getByLength());

        System.out.println("\n1d:");
        print(a.getByFreq());

        System.out.println("\n2a:");
        for (String s : a.getLetterCount()) {
            System.out.println(s);
        }

        System.out.println("\n3a:");
        print(a.getReservedOrder());

        System.out.println("\n3b:");
        print(a.getReservedFreq());
    }

    private static void print(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}