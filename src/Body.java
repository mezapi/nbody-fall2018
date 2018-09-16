
public class Body {
	
	/**
	 * Instance Variables
	 */
	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	
	
	/**
	 * Body Method
	 * @param x
	 * @param y
	 * @param xv
	 * @param yv
	 * @param mass
	 * @param filename
	 */
	public Body(double x, double y, double xv, double yv,
			    double mass, String filename) {
		myXPos = x;
		myYPos = y;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename; }
	
	/**
	 * Copy of Body Method
	 * @param b
	 */
	public Body(Body b) {
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName(); }

	/**
	 * Getter Methods
	 * @return
	 */
	public double getX() {
		return myXPos; }
	
	public double getY() {
		return myYPos; }
	
	public double getXVel() {
		return myXVel; }
	
	public double getYVel() {
		return myYVel; }
	
	public double getMass() {
		return myMass; }
	
	public String getName() {
		return myFileName; }

	/**
	 * Calculate Distance between two Bodies
	 * @param b
	 * @return
	 */
	public double calcDistance(Body b) {
		double dist = Math.sqrt(Math.pow(myXPos - b.getX(),2)+Math.pow(myYPos - b.getY(), 2));
		return dist; }

	/**
	 * Calculate Force Exerted by as Body
	 * @param p
	 * @return
	 */
	public double calcForceExertedBy(Body p) {
		double G = 6.67*1e-11;
		double force = G*(myMass*p.getMass())/Math.pow(calcDistance(p), 2);
		return force;  }
	
	/**
	 * Calculate Force Exerted by X
	 * @param p
	 * @return
	 */
	public double calcForceExertedByX(Body p) {
		double forceX = calcForceExertedBy(p)*(p.getX()-myXPos)/calcDistance(p);
		return forceX;	}
	
	/**
	 * Calculate Force Exerted by Y
	 * @param p
	 * @return
	 */
	public double calcForceExertedByY(Body p) {
		double forceY = calcForceExertedBy(p)*(p.getY()-myYPos)/calcDistance(p);
		return forceY; 	}
	
	/**
	 * Calculate Net Force Exerted by X
	 * @param Bodies
	 * @return
	 */
	public double calcNetForceExertedByX(Body[] Bodies) {
		double netForceX = 0.0;
		for(Body b : Bodies) {
			if(! b.equals(this)) {
				netForceX += calcForceExertedByX(b); }
		}
		return netForceX;   }
	
	/**
	 * Calculate Net Force Exerted by Y
	 * @param Bodies
	 * @return
	 */
	public double calcNetForceExertedByY(Body[] Bodies) {
		double netForceY = 0.0;
		for(Body b : Bodies) {
			if(! b.equals(this)) {
				netForceY += calcForceExertedByY(b); }
		}
		return netForceY;   }
	
	/**
	 * Update Method
	 * @param deltaT
	 * @param xForce
	 * @param yForce
	 */
	public void update(double deltaT, double xForce, double yForce) {
		double ax = xForce/myMass;
		double ay = yForce/myMass;
		double nvx = myXVel + deltaT*ax;
		double nvy = myYVel + deltaT*ay;
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;  }	
	
	/**
	 * Draw Method
	 */
	public void draw() {
		StdDraw.picture(myXPos,  myYPos,  "images/"+myFileName); }
	
	
}
