package com.leetcode.midium;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure211 {
    public static void main(String[] args) {

    }
}

class TrieNode211 {
    Map<Character, TrieNode211> children;
    boolean isWord;

    public TrieNode211() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {
    TrieNode211 root;

    public WordDictionary() {
        root = new TrieNode211();
    }

    public void addWord(String word) {
        TrieNode211 node = root;

        for (char w : word.toCharArray()) {
            if (!node.children.containsKey(w)) {
                node.children.put(w, new TrieNode211());
            }
            node = node.children.get(w);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode211 node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode211 child : node.children.values()) {
                if (searchHelper(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode211 child = node.children.get(c);
            if (child == null) {
                return false;
            }

            return searchHelper(child, word, index + 1);
        }

    }
}
