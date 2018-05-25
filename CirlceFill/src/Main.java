import java.awt.geom.AffineTransform;

import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateSequence;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.locationtech.jts.geom.impl.CoordinateArraySequenceFactory;
import org.locationtech.jts.geom.util.GeometryTransformer;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.PriorityQueue;
import org.locationtech.jts.shape.*;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.locationtech.jts.geom.util.*;
import org.locationtech.jts.algorithm.*;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Main {
    // hello there test test 

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        Container c = new Container();
        
        Ellipse2D e = new Ellipse2D.Double(5, 5, 5, 5);
        Rectangle2D r = new Rectangle2D.Double(0, 0, 5, 5);
        AffineTransform at = new AffineTransform();
        PathIterator epi = e.getPathIterator(at);
        System.out.println(r.getCenterX());
        
        // find interior point or centroid of first triangle
        
        
        Geometry p = createRightTriangleAsPolygon(0, 0, 15, 18);
        Point pc = getCentroid(p);
        Geometry q = createRightTriangleAsPolygon(5, 5, 25, 28);
        Point qc = getCentroid(q);
        
        System.out.println(p.intersects(q));
        Polygon pq = (Polygon) p.intersection(q);
        System.out.println(pq.toText());
        System.out.println(pq.getBoundaryDimension());
        
        
//        LinearRing lr = new LinearRing(cs, gf);
//        Point lrc = lr.getCentroid();
//        System.out.println(lrc.toText());
//        System.out.println(lr.toText());
//        System.out.println(lrc.within(lr));
//        System.out.println(lr.getArea());
        
//        GeometryTransformer gtr = new GeometryTransformer();
//        gtr.transform(lr);
//        Geometry p = new Polygon(null, null, 0);
        

    }
    
    public static Polygon createRightTriangleAsPolygon(double x, double y, double w, double h) {
        Coordinate[] cd = {new Coordinate(x, y), new Coordinate(x + w, y), new Coordinate(x, y + h), new Coordinate(x, y)};
        CoordinateSequence cs = new CoordinateArraySequence(cd);
        CoordinateArraySequenceFactory casf = CoordinateArraySequenceFactory.instance();
        GeometryFactory gf = new GeometryFactory(casf);
        Polygon p = gf.createPolygon(cs);
        System.out.println("from gf: " + p.toText());
        return p;
    }
    
    public static Point getCentroid(Geometry g) {
        Point ctr = g.getCentroid();
        Point ip = g.getInteriorPoint();
        System.out.println();
        System.out.println("interior: " + ip.getX() + ", " + ip.getY() + ", type: " + ip.getGeometryType());
        System.out.println("centroid: " + ctr.getX() + ", " + ctr.getY() + ", type: " + ctr.getGeometryType());

        System.out.println("interior inside: " + ip.within(g));
        System.out.println("centroid inside: " + ctr.within(g));
        
        return ctr;
    }

}
