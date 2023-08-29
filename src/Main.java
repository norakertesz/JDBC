import models.Bewertung;
import models.Kunde;
import models.Urlaub;
import models.Urlaubskategorien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Eingabe with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to JDBC!");

//        int i = 12;
//
//        int erg = 23 + i;
//
//        System.out.println("Aufgabe Mittwoch");
//        Connect.AufgabeNachmittagMittwoch();
//
//        Connect.displayBewertungenOrderByBewertung();
//

        //Connect.connect();
        //  Connect.readKategorien();
        //  Connect.printMetadata();

        String url = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\Campu02JDBC.db";
        String url2 = "jdbc:sqlite:C:\\Users\\kerte\\Downloads\\eLearningDB29.db";
        eLearning29 myHelper =new eLearning29(url2);
        //myHelper.createTableKunden();
        //System.out.printf("Tabelle Kunden wurde erzeugt");

        Kunde k =new Kunde();
//        k.setVorname("Victoria");
//        k.setBonuspunkte(900);
//        myHelper.insertKunde(k);

        System.out.printf("Kunden %s wurde hinzugefügt, die neue id ist %d",k.getVorname(), k.getKundenid());
        System.out.printf("%nmit Helper %n");
        myHelper.deleteKunde(8);
        //try {
        ArrayList<Kunde> allKunden =myHelper.getAllKunden();
        System.out.println(allKunden);
        ArrayList<Kunde> allKundenMitTelefonnummer = myHelper.getAllKundenMitTelefon();
        System.out.println("allKundenMitTelefonnummer"+"\n"+allKundenMitTelefonnummer);
        double durchschnittsBonuspunkte = myHelper.getDurchschnittsBonuspunkte();
        System.out.println("durchschnittsBonuspunkte:" + durchschnittsBonuspunkte);
        Kunde kundeMitMeistenBonuspunkten= myHelper.kundeMitMeistenBonuspunkten();
        System.out.println("kundeMitMeistenBonuspunkten:" + kundeMitMeistenBonuspunkten);






                JDBCHelper helper = new JDBCHelper(url);

            /*
            System.out.printf("%n alle Bewertugen mit Helper %n");
            helper.printAllBewertungen();

        System.out.printf("%n alle Kategorien mit Helper %n");
            helper.printKategorien();


        System.out.printf("%n printAlleKommentare mit Helper %n");
        helper.printAlleKommentare();

        System.out.printf("%n Urlaub mit Nummer  %n");
        helper.displayUrlaubMitID("SELECT Schlagwort FROM URLAUBE WHERE UrlaubsID=?",1);

        System.out.printf("%n Bewertungen mit Parametern  %n");
        helper.printAllBewertungenMinPunkteHoeherAls(6);


        System.out.printf("%n Bewertungen mit Parametern und PreparedStatement %n");
        helper.printAllBewertungenMinPunkteHoeherAlsMitPreparedStatement(6);

        System.out.printf("%nInsert neue Kategorie %n");
        helper.insertKategorie("Safari");

        System.out.printf("%nUpdate Kategorie%n");
        helper.updateKategorie(9, "Safari");

        System.out.printf("%nInsert neue Kategorie %n");
        Urlaubskategorien kNeu =new Urlaubskategorien();
        kNeu.setKategorie("Bildung");
        helper.insertKategorie(kNeu);
        */


        /*
        //1. Aufgabe - Klasse Bewertung mit Properties erstellen, BewertungsId, UrlaubsId, Punkte, Kommentar
        Bewertung bNeu=new Bewertung();
        bNeu.setUrlaubsId(1);
        bNeu.setPunkte(12);
        bNeu.setKommentar('ziemlich gut');
        //2. eine Methode im JDBC-Helper um ein Objekt vom Typ Bewertung hinzufügen zu können
        helper.insertBewertung(bNeu);
        //3. Aufgabe
        List<Bewertung> alleBewertungen = helper.getBewertungen(); --> liefert eine Liste von Bewertungen
        */

        //Auflösung um 12:40 Uhr - Prüfungsgespräch oder Prüfung



        //UrlaubsId wird von der DB über AUTOINCREMENT befüllt
//        Bewertung b1 =new Bewertung(-1,1,4,"so lala");
//        helper.insertBewertung(b1);
//        System.out.printf("Ihre Bewertung mit dem Kommentar %s wurde unter der id %d gespeichert",
//                b1.getKommentar(),
//                b1.getBewertungsId());
//
//
//
//
//        Bewertung bSuchen = helper.getBewertungById(9);
//
//        System.out.println("\n sucherergbnis von 10 \n" + bSuchen);
//
//        ArrayList<Bewertung> alleBewertungen = helper.getAlleBewertungen();
//
//        System.out.println("\nAlle Bewertungen\n");
//        System.out.println(alleBewertungen);
//
//        System.out.println("\nAlle Urlaube mit Schlagwort\n");
//        ArrayList<Urlaub> suchergebnis =  helper.findUrlaubBySchlagwort("und");
//        System.out.println(suchergebnis);


        //1. AufgabefindUrlaubBySchlagwort
        //alles was "irgendwie" fun im Schlagwort enthält soll gefunden werden
        /*
        ArrayList<Urlaub> gefundeneUrlaube = helper.findUrlaubBySchlagwort("fun");
        SELECT * FROM Urlaube
            WHERE Schlagwort LIKE '%arbeit%'*/

        //2. getBewertungMitHoechstenPunkten() -- falls es bewertungen mit gleichen Punkten gibt, irgendeine dieser Bewertungn

        //Auflösung 14:40 Uhr


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