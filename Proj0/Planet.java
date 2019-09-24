public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p2) {
        double sqrtdist =  (this.xxPos - p2.xxPos) * (this.xxPos - p2.xxPos) + (this.yyPos - p2.yyPos) * (this.yyPos - p2.yyPos);
        return Math.sqrt(sqrtdist);
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67E-11;
        return (G * this.mass * p.mass) / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        double F = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        double dx = p.xxPos - this.xxPos;
        return (F * dx) / r;
    }

    public double calcForceExertedByY(Planet p) {
        double F = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        double dy = p.yyPos - this.yyPos;
        return (F * dy) / r;
    }

    public double calcNetForceExertedByX(Planet[] Ps) {
        int i = 0;
        double Fx = 0;
        while (i < Ps.length) {
            if (!this.equals(Ps[i])) {
                Fx += this.calcForceExertedByX(Ps[i]);
            }
            i = i + 1;
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] Ps) {
        int i = 0;
        double Fy = 0;
        while (i < Ps.length) {
            if (!this.equals(Ps[i])) {
                Fy += this.calcForceExertedByY(Ps[i]);
            }
            i = i + 1;
        }
        return Fy;
    }

    public void update(double dt, double fX, double fY) {
        // Calculate the acceleration using the provided x- and y-forces.
        double aX = fX / this.mass;
        double aY = fY / this.mass;

        // Calculate the new velocity by using the acceleration and current velocity.
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;

        // Calculate the new position by using the velocity computed in step 2 and the current position.
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }


}
