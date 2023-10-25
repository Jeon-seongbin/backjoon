package com.programmers.level2;

public class SkillTree {
    public static void main(String[] args) {


        int a = solution("CBD", new String[]{"BDA"});
        System.out.println(a);
    }

    public static int solution(String skill, String[] skill_trees) {

        int answer = 0;

        for (String s : skill_trees) {
            String s2 = s.replaceAll("[^" + skill + "]", "");  // BCD, CBD, CB, BD  로 변환
            if (skill.startsWith(s2)) answer++;
        }

        return answer;
    }
}
