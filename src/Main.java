public class Main {
    public static void main(String[] args) {
        // Press Alt+Eingabe with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to JDBC!");

        int i = 12;

        int erg = 23 + i;


        //Connect.connect();
       //Connect.readKategorien();
       Connect.displayBewertungenOrderByBewertung();
Connect.printMetadata();

        Connect.displayBewertungenOrderByBewertung();


        //Connect.connect();
        //  Connect.readKategorien();
        //  Connect.printMetadata();

        String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";

        System.out.printf("%nmit Helper %n");

        //try {

        JDBCHelper helper = new JDBCHelper(url);
        System.out.printf("%n alle Bewertugen mit Helper %n");
        helper.printAllBewertungen();
        System.out.printf("%n alle Kategorien mit Helper %n");
        helper.printKategorien();
        System.out.printf("%n alle Kommentare mit Helper %n");
        helper.printAlleKommentare();

            /*
            ResultSet rs = helper.executeQuery("SELECT UrlaubsID, Schlagwort, UrlaubskategorieID FROM Urlaube");
            while (rs.next()) {
                System.out.printf("%s %n", rs.getString("Schlagwort"));
            }*/

        helper.closeConnection();
        //} catch (SQLException e) {
        //  throw new RuntimeException(e);
    }

    }
