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

public static void main(String[] args) {
    //*get data */
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double r = readRadius(filename);
    Planet[] fivePlanet = readPlanets(filename);
   
    //*draw background */
    StdDraw.setScale(-r, r);
    StdDraw.picture(0,0,"images/starfield.jpg",2*r,2*r);

    //*draw planets */
    for (Planet p: fivePlanet){
        p.draw();
    }

     //*prevent flickering in the animation */
     StdDraw.enableDoubleBuffering();

     //*set a time variable */

     double time = 0;
     while (time <= T){
     //*Create an xForces array and yForces array. */
     double xForces[];
     xForces = new double[5];
     double yForces[];
     yForces = new double[5];
     
     //* Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively.*/
     for(int i =0;i<5 ;i+=1){
        xForces[i] = fivePlanet[i].calcNetForceExertedByX(fivePlanet);
        yForces[i] = fivePlanet[i].calcNetForceExertedByY(fivePlanet);
     }
     
     //* Call update on each of the planets. This will update each planet’s position, velocity, and acceleration.*/
      
      for(int i =0;i<5 ;i+=1){
        fivePlanet[i].update(dt,xForces[i], yForces[i]);
      }
     //*Draw the background image. */
     StdDraw.picture(0,0,"images/starfield.jpg");
      //*Draw all of the planets. */
     for (Planet p: fivePlanet){
        p.draw();
     }
      //*Show the offscreen buffer (see the show method of StdDraw). */
      StdDraw.show();
      //* Pause the animation for 10 milliseconds*/
      int waitTimeMilliseconds = 10;
      StdDraw.pause(waitTimeMilliseconds);
      //*Increase your time variable by dt. */
      time += dt;
      }

}
	
}