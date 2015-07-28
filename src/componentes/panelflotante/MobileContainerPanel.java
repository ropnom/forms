package componentes.panelflotante;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MobileContainerPanel extends JPanel {

	//Lista de componenetes dentro del panel
	List componentList;
	// Movedor de componentes
	ComponentWrangler wrangler;
	final int PAD = 10;

	public MobileContainerPanel() {
		componentList = new ArrayList();
		wrangler = new ComponentWrangler();
		//layout absoluto
		setLayout(null);
	}

	public void addNext(Component c) {
		//añadimos el componente a la lista
		componentList.add(c);
		// lo subscribimos a los listeners de wrangler
		c.addMouseListener(wrangler);
		c.addMouseMotionListener(wrangler);
		add(c);
		
		//Esto nohara falta
		Dimension d = c.getPreferredSize();
		Point p = getNextLocation(d);
		c.setBounds(p.x, p.y, d.width, d.height);
		repaint();
	}

	//Esta funcion nohara falta
	private Point getNextLocation(Dimension d) {
		int maxX = 0, maxY = 0;
		Component c, last = null;
		Rectangle r;
		// find level of lowest component(s)
		for (int j = 0; j < componentList.size(); j++) {
			c = (Component) componentList.get(j);
			r = c.getBounds();
			if (r.y + r.height > maxY) {
				maxY = r.y + r.height;
				last = c;
			}
		}
		// find last (in row) of lowest components
		for (int j = 0; j < componentList.size(); j++) {
			c = (Component) componentList.get(j);
			r = c.getBounds();
			if (r.y + r.height == maxY && r.x + r.width > maxX) {
				maxX = r.x + r.width;
				last = c;
			}
		}
		// determine location of next component based on location of last
		Point p = new Point();
		if (last == null) // first component
		{
			p.x = PAD;
			p.y = PAD;
			return p;
		}
		r = last.getBounds();
		int x, y;
		if (r.x + r.width + PAD + d.width < getWidth()) // next in row
		{
			p.x = r.x + r.width + PAD;
			p.y = r.y;
		} else // skip to new row
		{
			p.x = PAD;
			p.y = r.y + r.height + PAD;
		}
		return p;
	}

	public void renewLayout() {
		removeAll();
		Component c;
		Dimension d;
		// set location of all components to offscreen positions
		for (int j = 0; j < componentList.size(); j++) {
			c = (Component) componentList.get(j);
			d = c.getSize();
			c.setBounds(-d.width, -d.height, d.width, d.height);
		}
		Point p;
		// add components and reset their location
		for (int j = 0; j < componentList.size(); j++) {
			c = (Component) componentList.get(j);
			add(c);
			d = c.getSize();
			p = getNextLocation(d);
			c.setBounds(p.x, p.y, d.width, d.height);
		}
		repaint();
	}

	public void clear() {
		removeAll();
		componentList.clear();
		repaint();
	}

}
