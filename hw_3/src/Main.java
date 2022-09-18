public class Main {
    public static void main(String[] args) {
        Read read = new Read();
        read.readFile(read.readPath());
        read.getSortList();
        read.getWordInformation();
        read.getInformationWordMaxRepetition();
    }
}
