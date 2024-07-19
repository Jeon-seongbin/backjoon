package com.leetcode.midium;

import java.util.HashMap;

public class ImnplementTrie208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        boolean result = trie.startsWith("ab");
        System.out.println(result);
    }


    static class TrieNode {
        HashMap<Character, TrieNode> trieNode;
        boolean isEndOfWord;

        TrieNode() {
            this.trieNode = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            // Objectが作成された時点のRootを持ってくる
            TrieNode current = root;

            for (char w : word.toCharArray()) {
                // wが存在しなかったら、wをTreeの最後に追加する
                // 最後のは常に最後になる
                current = current.trieNode.computeIfAbsent(w, ww -> new TrieNode());
            }
            current.isEndOfWord = true;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char p : prefix.toCharArray()) {
                current = current.trieNode.get(p);
                if (current == null) {
                    return false;
                }
            }
            return true;
        }


        public boolean search(String word) {
            TrieNode current = root;

            for (char w : word.toCharArray()) {
                current = current.trieNode.get(w);
                if (current == null) {
                    return false;
                }
            }
            return current.isEndOfWord;
        }
    }
}