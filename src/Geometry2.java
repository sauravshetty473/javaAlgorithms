
public class Geometry2 {

    final static double pi = 3.14;        //declaring pi as a constant
    public static double sphereVolume(double r){      // function to calculate volume of sphere
        return r*r*r*(4f/3)*pi;
    }

    public static double sphereSurface(double r){ // function to calculate surface area of sphere
        return 4*pi*r*r;
    }

    public static double coneVolume(double r,double h){  // function to calculate volume of cone
        return h*pi*r*r/3;
    }

    public static double coneSurface(double r,double h){ // function to calculate surface area of cone
        return pi*r*(h+r);
    }
}
