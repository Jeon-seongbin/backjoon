package com.acmicpc.season1.company;

public class Main8 {
//    public static void main(String[] args) throws IOException {
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int inputCount = Integer.parseInt(br.readLine());  // Read user input
//        for (int i = 0; i < inputCount; i++) {
//            String userInput = br.readLine();
//            Stack stack = new Stack();
//            boolean isChanged = false;
//            int stringSize = userInput.length();
//            for (int j = 0; j < stringSize; j++) {
//                char kako = userInput.charAt(j);
//
//                if (kako == '(') {
////                    isChanged = true;
//                    stack.push("(");
////                } else if (isChanged && stack.size() != 0) {
////                    stack.pop();
//                }else if (stack.size() == 0) {
//                        System.out.println("NO");
//                    isChanged = true;
//                        break;
//                    }
//
////                    출처: https://st-lab.tistory.com/178 [Stranger's LAB]
//                else {
//                    stack.pop();
////                    isChanged = false;
//
//                }
//            }
//            if(isChanged){
//                continue;
//            }
////            System.out.println(stack.size());
////            stack.print();
////            if (isChanged) {
//                if (stack.size() != 0) {
//                    System.out.println("NO");
//                } else {
//                    System.out.println("YES");
//                }
////            } else {
////                System.out.println("NO");
////            }
//
//
////            String[] userInput1 = userInput.split(" ");
////            int userInput2 = 0;
////            if (userInput1.length == 2) {
////                userInput2 = Integer.parseInt(userInput1[1]);
////            }
////
////            switch (userInput1[0]) {
////                case "push":
////                    stack.push(userInput2);
////                    break;
////                case "pop":
////                    System.out.println(stack.pop());
////                    break;
////                case "size":
////                    System.out.println(stack.size());
////                    break;
////                case "empty":
////                    System.out.println(stack.isEmpty());
////                    break;
////                case "top":
////                    System.out.println(stack.top());
////                    break;
////
////            }
//
//        }
//
//
//////        bw.flush();
//////        bw.close();
//    }
//}
//
//class Stack {
//
//    public Stack(){
//        this.data = new ArrayList<>();
//    }
//    private ArrayList<String> data;
//
//    public void push(String i) {
//        data.add(i);
//    }
//    public void print() {
//        for(int i = 0 ; i< this.data.size(); i++){
//            System.out.println(data.get(i));
//        }
//    }
//
//    public String pop() {
//
//        if (this.isEmpty() == 1) {
//            return "-1";
//        }
//
//        int index = data.size() - 1;
//        String result = this.top();
//        data.remove(index);
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
//    public String top() {
//        if (this.isEmpty() == 1) {
//            return "-1";
//        }
//        int index = data.size() - 1;
//        String result = data.get(index);
//        return result;
//    }
}
