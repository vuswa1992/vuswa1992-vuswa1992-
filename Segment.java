package Krocketspiel;

public class Segment {
	
	    Point p1, p2;
	    
	    Segment(Point p1, Point p2) {
	        this.p1 = p1;
	        this.p2 = p2;
	    }
	    Point direction() {
	        return new Point(p2.x - p1.x, p2.y - p1.y);
	    } 
}
