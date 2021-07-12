package pl.oskarskalski.vms.feature;

import pl.oskarskalski.vms.model.Vehicle;
import pl.oskarskalski.vms.vehicle.VehicleConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
    private final UserInput userInput = new UserInput();

    public List<String[]> read() throws IOException {
        List<String[]> result = new ArrayList<>();

        String path = userInput.getValueFromUser("Write path to the file");

        File file = new File(path);
        Scanner readLinesFromFile = new Scanner(file);

        while (readLinesFromFile.hasNextLine()) {
            String data = readLinesFromFile.nextLine();
            result.add(data.split(" "));
        }

        readLinesFromFile.close();
        return result;
    }

    public void saveDataToFile(List<Vehicle> vehicles) {
        try {
            String path = userInput.getValueFromUser("Write path to the .txt file with file name");

            if (!path.endsWith(".txt")) {
                System.out.println("Something went wrong with the file path.");
                return;
            }

            boolean overrideFile = Boolean.parseBoolean(
                    userInput.getValueFromUser("Do you want to override the file?(Type true/false)"));

            FileWriter fileWriter = new FileWriter(path, !overrideFile);

            VehicleConverter vehicleConverter = new VehicleConverter();
            String[] data = vehicleConverter.convertToStrings(vehicles);
            for (String values : data) {
                fileWriter.write(values);
                fileWriter.write(System.lineSeparator());
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong with saving the file");
        }
    }

}
