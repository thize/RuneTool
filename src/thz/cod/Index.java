package thz.cod;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import javax.imageio.ImageIO;

public class Index extends javax.swing.JFrame {

	private static final long serialVersionUID = 5837267110766372719L;
	int xMouse = 0, yMouse = 0;
	int x = 0, y = 0;
	static int resX = 0, resY = 0;

	public Index(int resX, int resY) throws IOException {
		java.net.URL url = this.getClass().getResource("/thz/img/thz.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(imagemTitulo);
		initComponents();
		setLocationRelativeTo(null);
		if (resX != 0 && resY != 0) {
			this.setLocation(resX, resY);
		}
	}

	private void initComponents() throws IOException {
		mover = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		update = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		idioma = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 3));
		jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(20, 20, 20));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText(ThizeRT.tAbrir);
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					jLabel2MouseClicked(evt);
				} catch (AWTException | IOException e) {
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE));

		getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 130, 40));

		jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText(ThizeRT.tComoUsar);
		jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ajudaMouseClicked(evt);
			}
		});
		getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));
		idioma.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		idioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN_US", "PT_BR" }));
		idioma.setSelectedIndex(ThizeRT.idiomaSelecionado);
		idioma.setBorder(null);
		getContentPane().add(idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 420, 70, 30));
		update.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
		update.setForeground(new java.awt.Color(255, 255, 255));
		update.setText(ThizeRT.tProcurarUpdate);
		update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		update.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				update(evt);
			}
		});
		getContentPane().add(update,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(175 + ThizeRT.vProcurarUpdate, 400, -1, -1));

		jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("X");
		jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}
		});
		mover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent evt) {
				moverMouseDragged(evt);
			}
		});
		mover.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				moverMousePressed(evt);
			}
		});
		getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 380, 150));

		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/logo.png"))); // NOI18N
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

		URL url = new URL("https://raw.githubusercontent.com/thize/RuneToolFiles/master/bg.png");
		Image imagem = ImageIO.read(url);
		// jLabel1.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/thz/img/bg.png"))); //
		jLabel1.setIcon(new javax.swing.ImageIcon(imagem)); // NOI18N NOI18N
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
		pack();
	}

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel4MouseClicked
		dispose();
	}

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) throws AWTException, IOException {// GEN-FIRST:event_jLabel2MouseClicked
		if (ThizeRT.idiomaSelecionado != idioma.getSelectedIndex()) {
			if (idioma.getSelectedItem().equals("PT_BR")) {
				ThizeRT.idiomaSelecionado = 1;
				File ler = new File("language.txt");
				ler.delete();
				ler.exists();
				FileWriter escrever = new FileWriter("language.txt");
				escrever.write("PT_BR");
				escrever.close();
				ThizeRT.mudarIdioma(1);
			} else {
				ThizeRT.idiomaSelecionado = 0;
				File ler = new File("language.txt");
				ler.delete();
				ler.exists();
				FileWriter escrever = new FileWriter("language.txt");
				escrever.write("EN_US");
				escrever.close();
				ThizeRT.mudarIdioma(0);
			}
		}
		dispose();
		Main nm = new Main(resX, resY);
		nm.setVisible(true);
	}

	private void moverMouseDragged(java.awt.event.MouseEvent evt) {
		x = evt.getXOnScreen();
		y = evt.getYOnScreen();
		resX = x - xMouse;
		resY = y - yMouse;
		this.setLocation(resX, resY);
	}

	private void moverMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void ajudaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		try {
			java.awt.Desktop.getDesktop().browse(new java.net.URI("https://runetool.github.io/#box2"));
		} catch (URISyntaxException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void update(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		try {
			Runtime.getRuntime().exec("java -jar Update.jar");
			dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Index(0, 0).setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	public static javax.swing.JComboBox<String> idioma;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel update;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel mover;
	// End of variables declaration//GEN-END:variables
}
