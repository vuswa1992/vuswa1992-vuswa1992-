package Krocketspiel;
import java.util.Scanner;

public class Krocketspiel {
	// Überprüft, ob drei Punkte kollinear sind
    static boolean areCollinear(Point p1, Point p2, Point p3) {
        // Die Punkte sind kollinear, wenn der Flächeninhalt des Dreiecks Null ist
        return (p2.y - p1.y) * (p3.x - p2.x) == (p2.x - p1.x) * (p3.y - p2.y);
    }
    
    // Überprüft, ob zwei Richtungen gleich sind (d.h., ob die Vektoren parallel sind)
    static boolean areSameDirection(Point dir1, Point dir2) {
        // Zwei Vektoren sind parallel, wenn der Kreuzprodukt Null ist
        return (dir1.x * dir2.y - dir1.y * dir2.x) == 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Wie viele Tore gibt es?");
        int n = scanner.nextInt();
        
        Segment[] tore = new Segment[n];
        
        // Tore einlesen
        for (int i = 0; i < n; i++) {
            System.out.println("Geben Sie die Koordinaten für Tor " + (i + 1) + " ein:");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            tore[i] = new Segment(new Point(x1, y1), new Point(x2, y2));
        }
        
        // Startpunkt und Richtung festlegen
        Point start = tore[0].p1;  // Wir starten vom ersten Tor
        Point direction = tore[0].direction();  // Richtung des ersten Tores
        
        boolean canPassAllGates = true;
        
        // Prüfen, ob alle Tore in der gleichen Richtung durchschlagen werden können
        for (int i = 1; i < n; i++) {
            Segment currentTor = tore[i];
            
            // Überprüfen, ob das aktuelle Tor in der gleichen Richtung liegt
            if (!areCollinear(start, currentTor.p1, currentTor.p2) || 
                !areSameDirection(direction, currentTor.direction())) {
                canPassAllGates = false;
                break;
            }
        }
        
        if (canPassAllGates) {
            System.out.println("Ja, alle Tore können mit einem Schlag durchquert werden!");
            System.out.println("Startpunkt: (" + start.x + ", " + start.y + ")");
            System.out.println("Schlagrichtung: (" + direction.x + ", " + direction.y + ")");
        } else {
            System.out.println("Nein, es ist nicht möglich, alle Tore mit einem Schlag zu durchqueren.");
        }
        
        scanner.close();
    }
}


