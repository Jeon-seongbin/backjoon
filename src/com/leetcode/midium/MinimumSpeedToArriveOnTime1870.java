package com.leetcode.midium;

public class MinimumSpeedToArriveOnTime1870 {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 6));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int start = 1;
        int end = 1000000000;
        int result = -1;

        while (start <= end) {
            int midSpeed = start + (end - start) / 2;
            double keisan = 0.0;
            for (int i = 0; i < dist.length; i++) {
                keisan = Math.ceil(keisan);
                keisan += Double.valueOf(dist[i]) / Double.valueOf(midSpeed);
            }

            if (keisan <= hour) {
                end = midSpeed - 1;
                result = midSpeed;
            } else {
                start = midSpeed + 1;
            }
        }
        return result;
    }
}

// 거시속 계산해서
// 속도가 현재보다 낮으니
// 시간을 좁혀야함
