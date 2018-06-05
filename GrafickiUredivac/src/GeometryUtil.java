
public class GeometryUtil {

	public static double distanceFromPoint(Point point1, Point point2) {
		// izra�unaj euklidsku udaljenost izme�u dvije to�ke ...
		return Math.sqrt(Math.pow(point1.getX()-point2.getX(),2.0)+Math.pow(point1.getY()-point2.getY(),2.0));
	}
	
	public static double distanceFromLineSegment(Point s, Point e, Point p) {
		// Izra�unaj koliko je to�ka P udaljena od linijskog segmenta odre�enog
		// po�etnom to�kom S i zavr�nom to�kom E. Uo�ite: ako je to�ka P iznad/ispod
		// tog segmenta, ova udaljenost je udaljenost okomice spu�tene iz P na S-E.
		// Ako je to�ka P "prije" to�ke S ili "iza" to�ke E, udaljenost odgovara
		// udaljenosti od P do po�etne/kona�ne to�ke segmenta.
		double a = distanceFromPoint(p, s);
		double b = distanceFromPoint(p, e);
		double c = distanceFromPoint(s, e);
		if (Math.abs( Math.abs(a-b) - c) < 5.0){
			return Math.min(a, b);
		}else{
			Point va = p.difference(s);
			Point vc = e.difference(s);
			double y= Math.sqrt(va.getX()*va.getX()+va.getY()*va.getY());
			double x =y* ((double)(va.getX()*vc.getX()+va.getY()*vc.getY()))/(Math.sqrt(va.getX()*va.getX()+va.getY()*va.getY())*Math.sqrt(vc.getX()*vc.getX()+vc.getY()*vc.getY()));
			return Math.sqrt(y*y-x*x);
			
		}
	}
}
