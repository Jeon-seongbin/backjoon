package com.leetcode.midium;

import java.util.HashMap;

public class ImnplementTrie208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
    }

    static class TrieNode {
        HashMap<Character, TrieNode> childen;
        boolean isEndOfWord;

        TrieNode() {
            this.childen = new HashMap<>();
            isEndOfWord = false;
        }
    }

    static class Trie {

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current = current.childen.computeIfAbsent(ch, c -> new TrieNode());
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current = current.childen.get(ch);
                if (current == null) {
                    return false;
                }
            }
            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char ch : prefix.toCharArray()) {
                current = current.childen.get(ch);
                if (current == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
