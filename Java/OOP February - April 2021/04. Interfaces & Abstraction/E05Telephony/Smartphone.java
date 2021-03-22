package E05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;

    }

    @Override
    public String browse() {
        StringBuilder sbBrowsers = new StringBuilder();
        for (String url : urls) {
            if (url.matches("^[^0-9]+$")) {
                sbBrowsers.append(String.format("Browsing: %s!", url))
                        .append(System.lineSeparator());
            } else {
                sbBrowsers.append("Invalid URL!")
                        .append(System.lineSeparator());
            }
        }

        return sbBrowsers.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sbNumbers = new StringBuilder();
        for (String number : numbers) {
            if (number.matches("^[0-9]+$")) {
                sbNumbers.append(String.format("Calling... %s", number))
                        .append(System.lineSeparator());
            } else {
                sbNumbers.append("Invalid number!")
                        .append(System.lineSeparator());
            }
        }
        return sbNumbers.toString().trim();
    }
}
