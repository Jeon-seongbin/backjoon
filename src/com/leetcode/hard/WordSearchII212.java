package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {
    public static void main(String[] args) {
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode212 root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public static void dfs(char[][] board, int i, int j, TrieNode212 p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }

        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public static TrieNode212 buildTrie(String[] words) {
        TrieNode212 root = new TrieNode212();
        for (int i = 0; i < words.length; i++) {
            TrieNode212 p = root;
            for (int j = 0; j < words[i].toCharArray().length; j++) {
                int k = words[i].toCharArray()[j] - 'a';
                if (p.next[k] == null) {
                    p.next[k] = new TrieNode212();
                }
                p = p.next[k];
            }
            p.word = words[i];
        }
        return root;
    }
}

class TrieNode212 {
    TrieNode212[] next = new TrieNode212[26];
    String word;
}