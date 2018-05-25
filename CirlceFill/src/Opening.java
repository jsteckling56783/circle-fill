import java.awt.Graphics2D;
import java.awt.Shape;
import org.locationtech.jts.geom.Geometry;

public class Opening implements Comparable<Opening> {
    
    double diam; // diameter of largest possible circle which fits in it
    Geometry inscribedCircle;

//    public Opening() {
//        // somehow pick a good starting point
//        // place a tiny circle there
//        // grow the circle using graphics shape stuff (precomputation)
//        inscribedCircle = new Geometry(); // put the circle here
//    }
    
    public Opening(Container c) {
        
    }

    @Override
    public int compareTo(Opening other) {
        // TODO Auto-generated method stub
        return Double.compare(diam, other.diam);
    }

}
