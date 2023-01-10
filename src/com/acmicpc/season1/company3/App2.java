package com.acmicpc.season1.company3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int partyPeopleCount = Integer.parseInt(br.readLine());
        int pairCount = 0;

        ArrayList<String[]> partyPeopleName = new ArrayList<>();

        for (int i = 0; i < partyPeopleCount; i++) {
            String[] nameInitialArray = br.readLine().split(" ");
            partyPeopleName.add(nameInitialArray);
        }

        for (int i = 0; i < partyPeopleCount; i++) {
            boolean isSame = false;
            for (int j = 0; j < partyPeopleName.size(); j++) {

                String[] nameInitialArrayOriginal = partyPeopleName.get(j);

                for (int z = j; z < partyPeopleName.size(); z++) {
                    String[] nameInitialArrayTarget = partyPeopleName.get(z);
                    if (nameInitialArrayOriginal[0].equals(nameInitialArrayTarget[1]) && nameInitialArrayOriginal[1].equals(nameInitialArrayTarget[0])) {
                        partyPeopleName.remove(j);
                        if (partyPeopleName.size() != 0) {

                            if (z - 1 == -1) {
                                partyPeopleName.remove(z);
                            } else {
                                partyPeopleName.remove(z - 1);
                            }

                            pairCount++;
                            isSame = true;
                        }
                    }
                    if (isSame) {
                        break;
                    }
                }
                if (isSame) {
                    break;
                }
            }
        }
        System.out.println(pairCount);

    }


}
