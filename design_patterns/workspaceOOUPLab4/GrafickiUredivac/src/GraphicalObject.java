import java.util.List;
import java.util.Stack;


public interface GraphicalObject {

	// Podr�ka za ure�ivanje objekta
	boolean isSelected();
	void setSelected(boolean selected);
	int getNumberOfHotPoints();
	Point getHotPoint(int index);
	void setHotPoint(int index, Point point);
	boolean isHotPointSelected(int index);
	void setHotPointSelected(int index, boolean selected);
	double getHotPointDistance(int index, Point mousePoint);

	// Geometrijska operacija nad oblikom
	void translate(Point delta);
	Rectangle getBoundingBox();
	double selectionDistance(Point mousePoint);
	
	// Podr�ka za crtanje (dio mosta)
	void render(Renderer r);
	
	// Observer za dojavu promjena modelu
	public void addGraphicalObjectListener(GraphicalObjectListener l);
	public void removeGraphicalObjectListener(GraphicalObjectListener l);

	// Podr�ka za prototip (alatna traka, stvaranje objekata u crte�u, ...)
	String getShapeName();
	GraphicalObject duplicate();
	
	// Podr�ka za snimanje i u�itavanje
	public String getShapeID();
	public void load(Stack<GraphicalObject> stack, String data);
	public void save(List<String> rows);
	
}
