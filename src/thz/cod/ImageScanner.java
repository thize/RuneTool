package thz.cod;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageScanner {
	static Double thizeX = 0.0, thizeY = 0.0;
	static Double valorY = 0.0;
	static Double valorX = 0.0;
	static boolean isOnScreen;
	final static String link1 = "/thz/img/search.png";
	final static String link2 = "/thz/img/search2.png";
	final static String link22 = "/thz/img/search22.png";

	boolean rodar() throws IOException {
		boolean aberto = false;
		String imagem = link1;
		BufferedImage image = ImageIO.read(getClass().getResource(imagem));
		isOnScreen = isOnScreen(image);
		if (isOnScreen) {
			aberto = true;
		}
		return aberto;
	}

	void rodar2(String link) throws IOException {
		String imagem = link;
		BufferedImage image = ImageIO.read(getClass().getResource(imagem));
		isOnScreen = isOnScreen(image);
		if (isOnScreen) {
			clicar();
		}
	}

	private static void clicar() {
		ThizeRT.robot.mouseMove(thizeX.intValue(), thizeY.intValue());
		ThizeRT.robot.mousePress(InputEvent.BUTTON1_MASK);// Clicar
		ThizeRT.robot.mouseRelease(InputEvent.BUTTON1_MASK);// Clicar
	}

	private static boolean isOnScreen(BufferedImage bi) {
		boolean passou = false;
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Integer x = 0; x < image.getWidth(); x++) {
			for (Integer y = 0; y < image.getHeight(); y++) {
				boolean invalid = false;
				thizeX = Double.parseDouble(x.toString());
				thizeY = Double.parseDouble(y.toString());
				for (int a = 0; a < bi.getWidth(); a++) {
					thizeY = Double.parseDouble(y.toString());
					;
					for (int b = 0; b < bi.getHeight(); b++) {
						if (bi.getRGB(a, b) != image.getRGB(thizeX.intValue(), thizeY.intValue())) {
							invalid = true;
							break;
						} else {
							thizeY++;
							if (thizeY >= (y + 5) && passou == false) {
								passou = true;
								valorY = thizeY - 5;
								valorX = thizeX;
							}
						}
					}
					if (invalid) {
						break;
					} else {
						thizeX++;
					}
				}
				if (!invalid || passou) {
					return true;
				}
			}
		}
		return false; // If no image is found

	}

}