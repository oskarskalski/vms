package pl.oskarskalski.vms.feature;

import java.util.*;

public class ObjectMethods<VehicleObject> {
    public String[] getSetterMethods(VehicleObject vehicleObject) {
        String[] methods = Arrays.toString(vehicleObject.getClass().getMethods()).split(",");

        List<String> setters = new ArrayList<>();

        for (String method : methods) {
            if (method.contains("set")) {
                if (method.contains("java.lang"))
                    method = method.replace("java.lang.", "");

                List<String> splitMethodInformationByDot = Arrays.asList(method.split("\\."));
                String methodName = splitMethodInformationByDot
                        .get(splitMethodInformationByDot.size() - 1);
                setters.add(methodName);
            }
        }
        String[] result = setters.toArray(new String[0]);
        Arrays.sort(result);

        return result;
    }

    public String[] getGetterMethods(VehicleObject vehicleObject){
        List<String> result = new ArrayList<>();
        String[] methods = Arrays.toString(vehicleObject.getClass().getMethods()).split(",");
        for (String method : methods) {
            String[] splitMethodInformationByDot = method.split("\\.");
            String methodName = splitMethodInformationByDot[splitMethodInformationByDot.length - 1];
            if(methodName.contains("java.lang.String")){
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

    public String getMethodParamType(String value) {
        String param = value
                .substring(value.indexOf("(") + 1, value.indexOf(")"));
        return param;
    }
}
