/**
 *Planet
 */
public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
    		this.xxPos = xP;
    		this.yyPos = yP;
    		this.xxVel = xV;
    		this.yyVel = yV;
    		this.mass = m;
    		this.imgFileName = img;
    	}

    public Planet(Planet p) {
    		this.xxPos = p.xxPos;
    		this.yyPos = p.yyPos;
    		this.xxVel = p.xxVel;
    		this.yyVel = p.yyVel;
    		this.mass = p.mass;
    		this.imgFileName = p.imgFileName;
    	}

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
      }

    public double calcForceExertedBy(Planet p){
        return(G * this.mass * p.mass / Math.pow(calcDistance(p),2));
      }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
      }

    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
      }

    public double calcNetForceExertedByX(Planet[] ps){
        double xForce = 0;
        for (Planet p : ps) {
          if (!this.equals(p)) {
            xForce += calcForceExertedByX(p);
          }
        }
        return xForce;
      }

    public double calcNetForceExertedByY(Planet[] ps){
        double yForce = 0;
        for (Planet p : ps) {
          if (!this.equals(p)) {
            yForce += calcForceExertedByY(p);
          }
        }
        return yForce;
      }

    public void update(double dt, double fx, double fy){
        xxVel += dt * fx / mass;
        yyVel += dt * fy / mass;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
      }

      public void draw() {
    		String filename = "images/" + imgFileName;
    		StdDraw.picture(xxPos, yyPos, filename);
    	}

}
