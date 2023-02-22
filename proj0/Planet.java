public class Planet{
public double xxPos;
public double yyPos;
public double xxVel;
public double yyVel;
public double mass;
public String imgFileName;
static final double G = 6.67e-11;

public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
              xxPos = xP;
              yyPos = yP;
              xxVel = xV;
              yyVel = yV;
              mass = m;
              imgFileName = img;
              }
              
public Planet(Planet p){
              xxPos = p.xxPos;
              yyPos = p.yyPos;
              xxVel = p.xxVel;
              yyVel = p.yyVel;
              mass = p.mass;
              imgFileName = p.imgFileName;
              
}

public double calcDistance(Planet x){
              double square = (xxPos-x.xxPos)*(xxPos-x.xxPos)+(yyPos-x.yyPos)*(yyPos-x.yyPos);
              double squareRoot = (square+1)/2;

              while ((squareRoot*squareRoot-square) > 0.001){
              double reciprocalSquare =square/squareRoot;
                squareRoot = (squareRoot + reciprocalSquare)/2;
              }
              return squareRoot;
}

public double calcForceExertedBy(Planet x){
    double r = this.calcDistance(x);
    return G * this.mass * x.mass/(r * r);
}


}