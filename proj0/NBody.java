public class NBody {

public static double readRadius(String name){
    In in = new In(name);
    int number = in.readInt();
	double radius = in.readDouble();
    return radius;
}
    


public static Planet[] readPlanets(String name){
    //*get rid of first two lines */

    In in = new In(name);
    int number = in.readInt();
    double radius =in.readDouble();
    Planet[] fivePlanet = new Planet[number];
    //*get information of the planet */ 
    for (int i = 0; i < number; i+=1){

        double xxPos = in.readDouble();
        double yyPos = in.readDouble();
        double xxVel = in.readDouble();
        double yyVel = in.readDouble();
        double mass = in.readDouble();
        String imgFileName = in.readString();
        fivePlanet[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
    }
    
    return fivePlanet;
}
}