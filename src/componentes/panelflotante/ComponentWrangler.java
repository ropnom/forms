package componentes.panelflotante;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

/**
 * select and drag components with the mouse
 */
public class ComponentWrangler extends MouseInputAdapter {

	Component selectedComponent;
	Point offset;
	boolean dragging;

	public ComponentWrangler() {
		dragging = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		selectedComponent = (Component) e.getSource();
		offset = e.getPoint();
		dragging = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragging = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragging) {
			//get size of component
			Rectangle r = selectedComponent.getBounds();
			// posicion final = posicion actual + (posicion raton - primerclick)
			r.x += e.getX() - offset.x;
			r.y += e.getY() - offset.y;
			selectedComponent.setBounds(r);
		}
	}

}
