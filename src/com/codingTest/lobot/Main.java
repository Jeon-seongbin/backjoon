package com.codingTest.lobot;

import java.util.*;

public class Main {
    static class TrieNode {

        private String result;
        private HashMap<Character, TrieNode> trieNode;
        private boolean isEndOfWord;

        TrieNode() {
            this.trieNode = new HashMap<>();
            this.isEndOfWord = false;
            this.result = "";
        }

        public String getResult() {
            return result;
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }


        public void insert(String word) {
            TrieNode current = root;
            for (char w : word.toCharArray()) {
                current = current.trieNode.computeIfAbsent(w, ww -> new TrieNode());
            }
            current.isEndOfWord = true;
            root.result = word;
        }


        public boolean startWith(String prefix) {
            TrieNode current = root;
            String temp = "";
            for (char p : prefix.toCharArray()) {
                current = current.trieNode.get(p);
                if (current == null) {
                    root.result = temp;
                    return false;
                }
                temp += p;
            }
            root.result = temp;
            return true;
        }
    }


    public static String commonPrefix(List<String> words) {

        if (words == null || words.isEmpty()) {
            return "";
        }

        Trie trie = new Trie();

        trie.insert(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            trie.startWith(words.get(i));
        }
        return trie.root.getResult();
    }


    public static void main(String[] args) {
        System.out.println(commonPrefix(Arrays.asList("flower", "flow", "flight")));   // -> "fl"
        System.out.println(commonPrefix(Arrays.asList("flow", "flower", "flowchart")));   // -> "flow"
        System.out.println(commonPrefix(Arrays.asList("flower", "flow", "flowchart")));   // -> "flow"
        System.out.println(commonPrefix(Arrays.asList("car", "cat", "dog", "bird", "cow", "rabbit")));   // -> ""
        System.out.println(commonPrefix(Arrays.asList("one word")));   // -> "one word"
        System.out.println(commonPrefix(Arrays.asList("")));   // -> ""
        System.out.println(commonPrefix(Arrays.asList()));   // -> ""
    }
}
