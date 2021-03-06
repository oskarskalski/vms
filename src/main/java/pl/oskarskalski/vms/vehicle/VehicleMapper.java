package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.ObjectMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VehicleMapper<VehicleObject> {
    private final ObjectMethods<VehicleObject> methods = new ObjectMethods<>();

    public VehicleObject mapToObject(VehicleObject vehicleObject, String[] data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] setters = methods.getSetterMethods(vehicleObject);

        if(data.length == 1)
            return vehicleObject;

        for (int i = 1; i < data.length; i++) {
            String method = setters[i - 1];

            String methodName = methods.getMethodName(method);

            String methodParam = methods.getMethodParamType(method);

            if (methodParam.equals("int")) {
                Method getMethod = vehicleObject.getClass().getMethod(methodName, int.class);

                getMethod.invoke(vehicleObject, Integer.parseInt(data[i]));
            }

            if (methodParam.equals("double")) {
                Method getMethod = vehicleObject.getClass().getMethod(methodName, double.class);

                getMethod.invoke(vehicleObject, Double.parseDouble(data[i]));
            }

            if (methodParam.equals("boolean")) {
                Method getMethod = vehicleObject.getClass().getMethod(methodName, boolean.class);

                getMethod.invoke(vehicleObject, Boolean.parseBoolean(data[i]));
            }

            if (methodParam.equals("String")) {
                Method getMethod = vehicleObject.getClass().getMethod(methodName, String.class);

                getMethod.invoke(vehicleObject, data[i]);
            }

        }
        return vehicleObject;
    }

    public String mapToString(VehicleObject vehicleObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] getters = methods.getGetterMethods(vehicleObject);
        String[] objectName = vehicleObject.getClass().getName().split("\\.");

        StringBuilder sb = new StringBuilder();
        sb.append(objectName[objectName.length - 1]);
        for (String methodName : getters) {
            sb.append(" ");
            Method getMethod = vehicleObject.getClass().getMethod(methods.getMethodName(methodName));
            sb.append(getMethod.invoke(vehicleObject));
        }
        return sb.toString();
    }


}
