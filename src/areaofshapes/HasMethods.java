
package areaofshapes;


public class HasMethods  {
    
    public double rectangleArea(double a, double b) {
        return a * b;
    }
    
    public double triangleArea(double a, double ma) {
        return a * ma / 2;
    }
    
    public double squareArea(double a) {
        return a * a;
    }
    
    public double circleArea(double r) {
        return r * r * 3.1415926535;
    }
    
    public double deltoidArea(double e, double f) {
        return e * f / 2;
    }
    
    public double rhombusArea(double e) {
        return e * e / 2;
    }
    
    public double trapezoidArea(double a, double c, double m) {
        return (a + c) / 2 * m;
    }
    
    public double parallelogramArea(double a, double ma) {
        return a * ma;
    }
    
    
}
