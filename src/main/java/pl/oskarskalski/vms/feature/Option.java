package pl.oskarskalski.vms.feature;

public class Option {
    private String[] options = {
            "What do you want to do?",
            "Close program",
            "Read data from file",
            "Save data to file",
            "Print vehicle",
            "Print vehicles",
            "Add vehicle",
            "Delete vehicle",
    };

    public void printOptions() {
        int index = 0;
        for (String option : options) {
            if (index == 0) {
                System.out.println(option);
            } else {
                System.out.println("\t" + (index - 1) + ". " + option);
            }
            index++;
        }
    }
}
