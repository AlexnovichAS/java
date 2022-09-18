import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class Read {

    private List<String> resultWords = new ArrayList<>();
    private Map<String, Integer> allRepetitions = new LinkedHashMap<>();
    private Map<String, Integer> allRepetitionsMax = new LinkedHashMap<>();


    public String readPath() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите путь к файлу:");
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void readFile(String stringPath) {
        Pattern p = Pattern.compile("\\s*(\\s|,|:|;|-|!|\\?|\\.)\\s*");
        try (BufferedReader writer = new BufferedReader(new FileReader(String.valueOf(Path.of(stringPath).toAbsolutePath())))) {
            while (writer.ready()) {
                String line = writer.readLine();
                resultWords.addAll(Arrays.asList(p.split(line.trim().toLowerCase())));
            }
            resultWords.forEach(System.out::println);
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSortList() {
        Collections.sort(resultWords);
        System.out.println("___________________");
        resultWords.forEach(System.out::println);
    }

    public void getWordInformation() {
        for (int i = 0; i < resultWords.size(); i++) {
            int numOccurrences = Collections.frequency(resultWords, resultWords.get(i));
            allRepetitions.put(resultWords.get(i), numOccurrences);
        }
        System.out.println("___________________");
        allRepetitions.forEach((x, y) -> System.out.println("Слово: " + x + " количество повторений: " + y));
    }

    public void getInformationWordMaxRepetition() {
        int maxNumber;
        try {
            maxNumber = allRepetitions.values().stream().reduce(Integer::max).orElse(0);
            for (Map.Entry<String, Integer> pair : allRepetitions.entrySet()) {
                if (pair.getValue() == maxNumber) {
                    allRepetitionsMax.put(pair.getKey(), pair.getValue());
                }
            }
            System.out.println("___________________");
            allRepetitionsMax.forEach((x, y) -> System.out.println("Слово встречающееся max количество раз: " + x + " количество повторений: " + y));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
