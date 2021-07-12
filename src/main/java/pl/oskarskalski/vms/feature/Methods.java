package pl.oskarskalski.vms.feature;

import java.util.*;

public class Methods<VehicleObject> {
    public String[] getSetters(VehicleObject vehicleObject) {
        String[] methods = Arrays.toString(vehicleObject.getClass().getMethods()).split(",");

        List<String> result = new ArrayList<>();

        for (String method : methods) {
            if (method.contains("set")) {
                if (method.contains("java.lang"))
                    method = method.replace("java.lang.", "");

                List<String> splitMethodInformationByDot = Arrays.asList(method.split("\\."));
                String methodName = splitMethodInformationByDot
                        .get(splitMethodInformationByDot.size() - 1);
                result.add(methodName);
            }
        }
        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public String[] getGetters(VehicleObject vehicleObject) {
        List<String> result = new ArrayList<>();
        String[] methods = Arrays.toString(vehicleObject.getClass().getMethods()).split(",");

        for (String method : methods) {
            String[] splitMethodInformationByDot = method.split("\\.");
            String methodName = splitMethodInformationByDot[splitMethodInformationByDot.length - 1];
            if(methodName.contains("java.lang.String")){
                System.out.println("found!!");
                methodName = methodName.replace("java.lang.String", "");
            }

            if (!methodName.contains("getClass") && !methodName.contains("hashCode")) {
                if (methodName.contains("get") || methodName.contains("has") || methodName.contains("is")) {
                    result.add(methodName);
                }
            }
        }
        Sort sort = new Sort();
        String[] names = result.toArray(new String[0]);
        names = sort.sortGettersNames(names);

        return names;
    }

    public String getMethodName(String value) {
        String methodName = value
                .substring(0, value.indexOf("("));
        return methodName;
    }

    public String getMethodParam(String value) {
        String param = value
                .substring(value.indexOf("(") + 1, value.indexOf(")"));
        return param;
    }
}
