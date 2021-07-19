package pl.oskarskalski.vms.feature;

import java.util.Arrays;

public class Sort {

    public String[] sortGettersNames(String[] names) {
        String[] sortedNames = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name.startsWith("get"))
                sortedNames[i] = name.replace("get", "");
            else if (name.startsWith("is"))
                sortedNames[i] = name.replace("is", "");
            else if (name.startsWith("has"))
                sortedNames[i] = name.replace("has", "");
            else
                System.out.println("\n" + name);
        }
        Arrays.sort(sortedNames);

        for (int i = 0; i < sortedNames.length; i++) {
            for (int j = 0; j < names.length; j++) {

                if (names[j].contains(sortedNames[i])) {
                    sortedNames[i] = names[j];
                    j = names.length;
                }
            }
        }

        return sortedNames;
    }
}
