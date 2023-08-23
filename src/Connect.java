import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class Connect {
    /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            //1. Project Structure -- add Referenz to sqlite jar driver
            //2. Define connection string jdbc:subprotocol
            String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";
            //Wie ist ein connection-String aufgebaut - DriverName:Filename
            // create a connection to the database
            //3. Get Connection
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void connectXYZ() {
        Connection conn = null;
        try {
            // db parameters
            //1. Project Structure -- add Referenz to sqlite jar driver
            //2. Define connection string jdbc:subprotocol
            String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";
            //Wie ist ein connection-String aufgebaut - DriverName:Filename
            // create a connection to the database
            //3. Get Connection
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void readKategorien() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";
            //Wie ist ein connection-String aufgebaut - DriverName:Filename
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();

            String query = "SELECT UrlaubsID, Schlagwort, UrlaubskategorieID FROM Urlaube";
            ResultSet rs = stmt.executeQuery( query );

            //rs ist ein Zeiger auf eine virtuelle Tabelle,
            // zeigt nach dem Öffnen auf den Datensatz - 1

            while ( rs.next() ) {
                System.out.printf("Schlagwort: %s die UrlaubsID ist: %d %n",
                        rs.getString("Schlagwort"),
                        rs.getInt("UrlaubsID"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void AufgabeNachmittagMittwoch() {
        //
        //1. Aufgabe - neue Tabelle in SQLite Studio - beispiele Hinzufügen über SQLite
        //Jede Bewertung soll kommentiert werden können
        //1	  1	7	fasst perfekt - Bewertungstabelle

        //KommentareZuBewerungen
        //1    1    ich stimme dir zu    JG
        //2    1    bin ähnlicher Meinung XY
        //3    1    bin völlig anderer Meinung ABC

        //neue Methode - Zeige alle Kommentare pro Bewertung JOIN Bewertungen und KommentareZuBewertungen

        //11:45 12:30 --- heute um 13:00 Uhr Auflösung
        /*CREATE TABLE KommentareZuBewertung
(
    KommentarId INTEGER PRIMARY KEY AUTOINCREMENT,
    Kommentar varchar(50),
    BewertungsId int,

    CONSTRAINT fk_kommentare FOREIGN KEY (
        BewertungsId
    )
    REFERENCES Bewertungen (BewertungsId)


)*/

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";
            //Wie ist ein connection-String aufgebaut - DriverName:Filename
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();

            String query = "SELECT b.Kommentar AS KommentarBewertung, b.Punkte, k.Kommentar\n" +
                    " FROM Bewertungen b JOIN KommentareZuBewertung k\n" +
                    " ON b.BewertungsID = k.BewertungsID\n" +
                    " ORDER BY Punkte";
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                System.out.printf("Kommentar: %s Punkte: %d Kommentar %s %n",
                        rs.getString("KommentarBewertung"),
                        rs.getInt("Punkte"),
                        rs.getString("Kommentar")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }

    public static void displayBewertungenOrderByBewertung() {
        //1. Connection aufbauen
        //2. Resultset erzeugen
        //3. Ausgabe der Bewertungen inkl. Schlagwort aus der Tabelle Urlaube mit printf
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";
            //Wie ist ein connection-String aufgebaut - DriverName:Filename
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();

            String query = "SELECT Urlaube.Schlagwort, Bewertungen.Punkte, Bewertungen.Kommentar FROM Urlaube INNER JOIN Bewertungen ON Urlaube.UrlaubsID = Bewertungen.UrlaubsID"+
                    " ORDER BY Punkte DESC";
            ResultSet rs = stmt.executeQuery( query );

            //rs ist ein Zeiger auf eine virtuelle Tabelle,
            // zeigt nach dem Öffnen auf den Datensatz - 1
//            String query2 = "SELECT Schlagwort FROM Urlaube";
//            ResultSet rs2 = stmt.executeQuery( query2 );
            while ( rs.next()) {
                System.out.printf("Die Punkte sind: %s | Schlagwort:%s | Kommentare:%s%n",

                        rs.getInt("Punkte"),
                        rs.getString("Schlagwort"),
                        rs.getString("Kommentar"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void printMetadata() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campus02JDBC.db";
            //Wie ist ein connection-String aufgebaut - DriverName:Filename
            // create a connection to the database
            conn = DriverManager.getConnection(url);


            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Tabelle gefunden: " + tableName);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}



