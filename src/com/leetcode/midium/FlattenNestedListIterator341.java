package com.leetcode.midium;


import java.util.*;

public class FlattenNestedListIterator341 {
    public static void main(String[] args) {

    }

    /**
     * // This is the interface that allows for creating nested lists.
     * <p>
     * // You should not implement it, or speculate about its implementation
     */
    public class NestedIterator implements Iterator<Integer> {

        private ArrayList<Integer> flatList;
        private Iterator<Integer> it;
        public NestedIterator(List<NestedInteger> nestedList) {
            flatList = new ArrayList<>();

            flatten(nestedList);
            it = flatList.iterator();
        }

        private void flatten(List<NestedInteger> nestedList){
            for(NestedInteger n : nestedList){
                if(n.isInteger()){
                    flatList.add(n.getInteger());
                }else{
                    flatten(n.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
