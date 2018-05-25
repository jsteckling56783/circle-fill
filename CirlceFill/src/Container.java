import java.util.PriorityQueue;
import org.locationtech.jts.shape.*;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.locationtech.jts.geom.util.*;
import org.locationtech.jts.algorithm.*;
import java.awt.Graphics2D;
import java.awt.geom.*;
//import org.geotools


public class Container {
    
    PriorityQueue<Opening> pq = new PriorityQueue<Opening>();
    double smallestAcceptableDiam = 5;

    public Container() {
        pq.add(new Opening(this));  // use whole container as original opening
        
        GeometryTransformer gt = new GeometryTransformer();
       
        
//        PathIterator pi = new PathIterator();
//        FlatteningPathIterator fpi = new FlatteningPathIterator(fpi, smallestAcceptableDiam);
//        
//        nextCircle();
        
  org.locationtech.jts.geom.util.GeometryTransformer gtr = new GeometryTransformer();
        
//        CurvedGeometryFactory cGf 
        
        
//        gtr.transform(inputGeom)
        
    }
    
    private void nextCircle() {
        Opening o = pq.remove(); // get the highest priority opening (largest diam)
        
        if(o.diam >= smallestAcceptableDiam) { // halt recursion if base case of no big enough openings
            drawCircle(o); // place circle in that opening
            
            for(Opening babyO : getNewOpenings(o)) { // add newly created openings to pq
                pq.add(babyO);
            }
            
            nextCircle();
        }
    }
    
    private void drawCircle(Opening o) {
        
    }
    
    private Opening[] getNewOpenings(Opening o) {
        Geometry remainingOpening = ((Geometry)((Object)o)).difference(o.inscribedCircle); //TODO: make Opening extend Geometry
        return null;
    }


}
