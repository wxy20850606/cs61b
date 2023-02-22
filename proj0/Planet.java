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

public double calcForceExertedByX(Planet x){
    double Force = this.calcForceExertedBy(x);
    return Force*(x.xxPos-this.xxPos)/this.calcDistance(x);

}

public double calcForceExertedByY(Planet x){
    double Force = this.calcForceExertedBy(x);
    return Force*(x.yyPos-this.yyPos)/this.calcDistance(x);
}

//* samh.equals(samh) = true*/
public double calcNetForceExertedByX(Planet[] allPlanets){
    double totalNetForce = 0;
    for(Planet s : allPlanets){
            if(this.equals(s)){
                continue;
            }
            totalNetForce += this.calcForceExertedByX(s);
        }
return totalNetForce;
}

public double calcNetForceExertedByY(Planet[] allPlanets){
    double totalNetForce = 0;
    for(Planet s : allPlanets){
            if(this.equals(s)){
                continue;
            }
            totalNetForce += this.calcForceExertedByY(s);
        }
return totalNetForce;
}

}