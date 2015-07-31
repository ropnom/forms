package style.JFrame;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TransparentJFrame extends JFrame {

	public TransparentJFrame() {

		super("TranslucentWindow");
		// setLayout(new GridBagLayout());

		setBackground(new Color(0, 0, 0, 30));
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// Determine what the GraphicsDevice can support.
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		boolean isPerPixelTranslucencySupported = gd
				.isWindowTranslucencySupported(WindowTranslucency.PERPIXEL_TRANSLUCENT);

		// If translucent windows aren't supported, exit.
		if (!isPerPixelTranslucencySupported) {
			System.out.println("Per-pixel translucency is not supported");
			System.exit(0);
		}

		JFrame.setDefaultLookAndFeelDecorated(true);
//		try {
//		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}

		// Create the GUI on the event-dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TransparentJFrame gtw = new TransparentJFrame();

				// Display the window.
				gtw.setVisible(true);
			}
		});
	}

}
