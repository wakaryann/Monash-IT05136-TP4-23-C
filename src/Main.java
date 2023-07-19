// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\r\n");

        try {
            Connection connection = DriverManager.getConnection(url "jdbc:mysql://localhost:3306/jdbc-test", user:"root", password:"toor");

            Statement statement = connection.creatStatement();

            ResultSet resultSet = statement.executeQuery( sql: "select * from people");

            while (resultSet.next()) {
                System.out.prinln(resultSet.getString(columnLabel: "name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}