package com.codingTest.green;

import java.util.*;

public class Main5 {


    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        String[] lines = getStdin();
        for (int i = 1; i < lines.length; i++) {
            words.add(lines[i]);
        }

        Map<String, List<String>> prefixMap = new HashMap<>();
        int maxLength = 0;

        // プレフィックスマップの構築
        for (String word : words) {
            if (word.length() >= 2) {
                String prefix = word.substring(0, 2);
                prefixMap.putIfAbsent(prefix, new ArrayList<>());
                prefixMap.get(prefix).add(word);
            }
        }

        // 最長の造語を探索
        for (String word : words) {
            if (word.length() >= 2) {
                String suffix = word.substring(word.length() - 2);
                if (prefixMap.containsKey(suffix)) {
                    for (String nextWord : prefixMap.get(suffix)) {
                        if (!word.equals(nextWord)) {
                            int length = word.length() + nextWord.length() - 2;
                            maxLength = Math.max(maxLength, length);
                        }
                    }
                }
            }
        }

        System.out.println(maxLength > 0 ? maxLength : -1);
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
/*
package track;
import java.util.*;

public class App {

  public static void main(String[] args) {
    // このコードは標準入力と標準出力を用いたサンプルコードです。
    // このコードは好きなように編集・削除してもらって構いません。
    // ---
    // This is a sample code to use stdin and stdout.
    // Edit and remove this code as you like.
    ArrayList<String> words = new ArrayList<>();
    String[] lines = getStdin();
    for (int i = 0, l = lines.length; i < l; i++) {
      String output = String.format("line[%s]: %s", i, lines[i]);
      // System.out.println(output);
      if(i != 0){
   words.add( lines[i]);
      }
    }
            words.sort(Comparator.naturalOrder());
    int n = words.size();
        String longestCoinage = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String coinage = findCoinage(words.get(i), words.get(j));
                    if (coinage.length() > longestCoinage.length()) {
                        longestCoinage = coinage;
                    }
                }
            }
        }
        System.out.println(longestCoinage.isEmpty() ? -1 : longestCoinage.length());
  }

  private static String[] getStdin() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> lines = new ArrayList<>();
    while (scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }
    return lines.toArray(new String[lines.size()]);
  }

      public static String findCoinage(String word1, String word2) {
        if (word1.length() < 2 || word2.length() < 2) {
            return "";
        }

        String end = word1.substring(word1.length() - 2);
        String start = word2.substring(0, 2);

        if (end.equals(start)) {
            return word1 + word2.substring(2);
        }

        return "";
    }
}
 */
}
