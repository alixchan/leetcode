package Other;

public class ExcelColumnTitle168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            System.out.println(columnNumber % 26);
            sb.append((char) ('A' + (--columnNumber) % 26));

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }

}
