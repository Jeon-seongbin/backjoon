package com.acmicpc.season1.company1;

public class Main2 {
//    public static void main(String[] args) throws IOException {
//
//        Stack stack = new Stack();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int inputCount = Integer.parseInt(br.readLine());  // Read user input
//        for (int i = 0; i < inputCount; i++) {
//            String userInput = br.readLine();
//
//            String[] userInput1 = userInput.split(" ");
//            int userInput2 = 0;
//            if (userInput1.length == 2) {
//                userInput2 = Integer.parseInt(userInput1[1]);
//            }
//
//            switch (userInput1[0]) {
//                case "push":
//                    stack.push(userInput2);
//                    break;
//                case "pop":
//                    System.out.println(stack.pop());
//                    break;
//                case "size":
//                    System.out.println(stack.size());
//                    break;
//                case "empty":
//                    System.out.println(stack.isEmpty());
//                    break;
//                case "top":
//                    System.out.println(stack.top());
//                    break;
//
//            }
//
//        }
////        bw.flush();
////        bw.close();
//    }
}
//
//class Stack {
//    static private final ArrayList<Integer> data = new ArrayList<>();
//
//    public void push(int i) {
//        data.add(i);
//    }
//
//    public int pop() {
//
//        if (this.isEmpty() == 1) {
//            return -1;
//        }
//
//        int index = data.size() - 1;
//        int result = this.top();
//        data.remove(index);
//
//        return result;
//    }
//
//    public int size() {
//        return data.size();
//    }
//
//    public int isEmpty() {
//        if (data == null || data.size() == 0) {
//            return 1;
//        }
//        return 0;
//    }
//
//    public int top() {
//        if (this.isEmpty() == 1) {
//            return -1;
//        }
//        int index = data.size() - 1;
//        int result = data.get(index);
//        return result;
//    }
//}
