package thz.cod;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private static String lane = "";
	int xMouse = 0, yMouse = 0;
	static int ready = 0;

	public Main(int x, int y) {
		java.net.URL url = this.getClass().getResource("/thz/img/thz.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(imagemTitulo);
		initComponents();
		setLocationRelativeTo(null);
		if (Index.resX != 0 && Index.resY != 0) {
			this.setLocation(Index.resX, Index.resY);
		}
	}

	private void initComponents() {
		botaoCor = new javax.swing.JPanel();
		botaoCor2 = new javax.swing.JPanel();
		tCriar = new javax.swing.JLabel();
		tOpgg = new javax.swing.JLabel();
		bVoltar = new javax.swing.JLabel();
		champSelect = new javax.swing.JCheckBox();
		tThize = new javax.swing.JLabel();
		tVer = new javax.swing.JLabel();
		mover = new javax.swing.JLabel();
		bMinimizar = new javax.swing.JLabel();
		tTrndd = new javax.swing.JLabel();
		iconMID = new javax.swing.JLabel();
		iconJG = new javax.swing.JLabel();
		iconTOP = new javax.swing.JLabel();
		iconADC = new javax.swing.JLabel();
		iconSUPP = new javax.swing.JLabel();
		champ = new javax.swing.JComboBox<>();
		stat = new javax.swing.JComboBox<>();
		reso = new javax.swing.JComboBox<>();
		tReso = new javax.swing.JLabel();
		tStat = new javax.swing.JLabel();
		tChamp = new javax.swing.JLabel();
		logo = new javax.swing.JLabel();
		bFechar = new javax.swing.JLabel();
		fundo = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		setPreferredSize(new java.awt.Dimension(422, 478));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		botaoCor.setBackground(new Color(40, 40, 40));

		tCriar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tCriar.setForeground(new java.awt.Color(255, 255, 255));
		tCriar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tCriar.setText("Pick a Lane");

		botaoCor2.setBackground(new Color(40, 40, 40));

		tOpgg.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
		tOpgg.setForeground(new java.awt.Color(255, 255, 255));
		tOpgg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tOpgg.setText("OP.GG");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(botaoCor);
		botaoCor.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(tCriar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(tCriar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

		getContentPane().add(botaoCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 110, 40));

		javax.swing.GroupLayout jPanel1Layout2 = new javax.swing.GroupLayout(botaoCor2);
		botaoCor2.setLayout(jPanel1Layout2);
		jPanel1Layout2.setHorizontalGroup(jPanel1Layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(tOpgg, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE));
		jPanel1Layout2.setVerticalGroup(jPanel1Layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(tOpgg, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE));

		getContentPane().add(botaoCor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 448, 55, 20));

		bVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		bVoltar.setForeground(new java.awt.Color(255, 255, 255));
		bVoltar.setText("<");
		bVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					voltarMouseClicked(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(bVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

		champSelect.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		champSelect.setForeground(new java.awt.Color(255, 255, 255));
		champSelect.setSelected(true);
		champSelect.setText("In Champion Select");
		champSelect.setBorder(null);
		champSelect.setContentAreaFilled(false);
		champSelect.setFocusPainted(false);
		champSelect.setFocusable(false);
		champSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/nsel.png")));
		champSelect.setRequestFocusEnabled(false);
		champSelect.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/nsel.png"))); // NOI18N
		champSelect.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/sel.png"))); // NOI18N
		champSelect.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/sel.png"))); // NOI18N
		champSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				championSelect(evt);
			}
		});
		getContentPane().add(champSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));
		mover.setToolTipText("");
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
		getContentPane().add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 330, 170));

		tThize.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
		tThize.setForeground(new java.awt.Color(153, 153, 153));
		tThize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/git.png"))); // NOI18N
		tThize.setText("Thize");
		tThize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tThize.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				thizeMouseClicked(evt);
			}
		});
		getContentPane().add(tThize, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, 19));
		tVer.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
		tVer.setForeground(new java.awt.Color(153, 153, 153));
		tVer.setText("v2.0");
		tVer.setBounds(250, 450, -1, 19);
		tVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tVer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				thizeMouseClicked(evt);
			}
		});
		getContentPane().add(tVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, -1, 19));

		bMinimizar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		bMinimizar.setForeground(new java.awt.Color(255, 255, 255));
		bMinimizar.setText("_");
		bMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				minimizarMouseClicked(evt);
			}
		});
		getContentPane().add(bMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 10, 40));

		tTrndd.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
		tTrndd.setForeground(new java.awt.Color(153, 153, 153));
		tTrndd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/git.png"))); // NOI18N
		tTrndd.setText("Trndd");
		tTrndd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tTrndd.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				trnddMouseClicked(evt);
			}
		});
		getContentPane().add(tTrndd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, 19));

		iconMID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		iconMID.setForeground(new java.awt.Color(255, 255, 255));
		iconMID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/mid.png"))); // NOI18N
		iconMID.setText("MID");
		iconMID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		iconMID.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				iconMIDMouseClicked(evt);
			}
		});
		getContentPane().add(iconMID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

		iconJG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		iconJG.setForeground(new java.awt.Color(255, 255, 255));
		iconJG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/jg.png"))); // NOI18N
		iconJG.setText("JG");
		iconJG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		iconJG.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				iconJGMouseClicked(evt);
			}
		});
		getContentPane().add(iconJG, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

		iconTOP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		iconTOP.setForeground(new java.awt.Color(255, 255, 255));
		iconTOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/top.png"))); // NOI18N
		iconTOP.setText("TOP");
		iconTOP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		iconTOP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				iconTOPMouseClicked(evt);
			}
		});
		getContentPane().add(iconTOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

		iconADC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		iconADC.setForeground(new java.awt.Color(255, 255, 255));
		iconADC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/adc.png"))); // NOI18N
		iconADC.setText("ADC");
		iconADC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		iconADC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				iconADCMouseClicked(evt);
			}
		});
		getContentPane().add(iconADC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

		iconSUPP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		iconSUPP.setForeground(new java.awt.Color(255, 255, 255));
		iconSUPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/supp.png"))); // NOI18N
		iconSUPP.setText("SUPP");
		iconSUPP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		iconSUPP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				iconSUPPMouseClicked(evt);
			}
		});
		getContentPane().add(iconSUPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

		champ.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		champ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aatrox", "Ahri", "Akali", "Alistar",
				"Amumu", "Anivia", "Annie", "Ashe", "Aurelion Sol", "Azir", "Bard", "Blitzcrank", "Brand", "Braum",
				"Caitlyn", "Camille", "Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr. Mundo ", "Draven",
				"Ekko ", "Elise ", "Evelynn ", "Ezreal ", "Fiddlesticks", "Fiora ", "Fizz", "Galio", "Gangplank",
				"Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Illaoi", "Irelia", "Ivern", "Janna",
				"Jarvan IV", "Jax", "Jayce", "Jhin", "Jinx", "Kai'sa", "Kalista", "Karma", "Karthus", "Kassadin",
				"Katarina", "Kayle", "Kayn", "Kennen", "Kha'Zix", "Kindred", "Kled", "Kog'Maw", "LeBlanc", "Lee Sin",
				"Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi",
				"Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu",
				"Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Pyke", "Quinn", "Rakan", "Rammus", "Rek'Sai",
				"Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed",
				"Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Tahm Kench", "Taliyah", "Talon",
				"Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr",
				"Urgot", "Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick",
				"Wukong", "Xayah", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zoe",
				"Zyra" }));
		champ.setBorder(null);
		getContentPane().add(champ, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 110, 30));

		stat.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Most Frequent", "Highest Win" }));
		stat.setBorder(null);
		getContentPane().add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 110, 30));

		tReso.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
		tReso.setForeground(new java.awt.Color(255, 255, 255));
		tReso.setText("Client Resolution:");
		getContentPane().add(tReso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 385, -1, -1));

		reso.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		reso.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "1280x720", "1024x576", "1600x900", "1920x1080" }));
		reso.setBorder(null);
		getContentPane().add(reso, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 400, 90, 30));

		tStat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tStat.setForeground(new java.awt.Color(255, 255, 255));
		tStat.setText("Stat:");
		getContentPane().add(tStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

		tChamp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tChamp.setForeground(new java.awt.Color(255, 255, 255));
		tChamp.setText("Champion:");
		getContentPane().add(tChamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

		logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/logo.png"))); // NOI18N
		getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

		bFechar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		bFechar.setForeground(new java.awt.Color(255, 255, 255));
		bFechar.setText("X");
		bFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bFechar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				xMouseClicked(evt);
			}
		});
		getContentPane().add(bFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

		fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thz/img/bg2.png"))); // NOI18N
		getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

		pack();
	}

	static void assignReady() {
		botaoCor.setBackground(new Color(161, 133, 77));
		botaoCor2.setBackground(new Color(30, 144, 255));
		tCriar.setText("ASSIGN");
		Main.tCriar.paintImmediately(Main.tCriar.getVisibleRect());
		tCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tOpgg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		if (ready == 0) {
			tCriar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					try {
						assignMouseClicked(evt);
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
				}
			});
			tOpgg.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					try {
						opGGMouseClicked(evt);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				private void opGGMouseClicked(MouseEvent evt) throws IOException, URISyntaxException {
					java.awt.Desktop.getDesktop().browse(new java.net.URI(
							"https://op.gg/champion/" + (String) champ.getSelectedItem() + "/statistics/" + lane));
				}
			});
			ready++;
		}

	}

	private void xMouseClicked(java.awt.event.MouseEvent evt) {
		dispose();
	}

	private void championSelect(java.awt.event.ActionEvent evt) {
		if (champSelect.isSelected()) {
			ThizeRT.selecao = true;
		} else {
			ThizeRT.selecao = false;
		}
	}

	public static void assignMouseRed() {
		botaoCor.setBackground(new Color(180, 40, 40));
		tCriar.setText("NOT FOUND");
		tCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tOpgg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	private static void assignMouseClicked(java.awt.event.MouseEvent evt) throws InterruptedException, IOException {// GEN-FIRST:event_jLabel2MouseClicked
		ThizeRT.q = 12;
		ThizeRT.d = 23;// AumentarSegundoForPara2Runa
		ThizeRT.dt = 0;
		ThizeRT.precisao = false;
		ThizeRT.dominacao = false;
		ThizeRT.feiticaria = false;
		ThizeRT.determinacao = false;
		ThizeRT.inspiracao = false;
		loading();
		ThizeRT.chamarRuna((String) champ.getSelectedItem(), lane, (String) stat.getSelectedItem(),
				(String) reso.getSelectedItem());
	}

	private static void loading() {
		tCriar.setText("LOADING...");
		botaoCor.setBackground(new Color(40, 40, 180));
		tCriar.paintImmediately(tCriar.getVisibleRect());
	}

	private void iconTOPMouseClicked(java.awt.event.MouseEvent evt) {
		assignReady();
		lane = "top";
		iconTOP.setForeground(new Color(220, 170, 110));
		iconJG.setForeground(new Color(250, 250, 250));
		iconMID.setForeground(new Color(250, 250, 250));
		iconADC.setForeground(new Color(250, 250, 250));
		iconSUPP.setForeground(new Color(250, 250, 250));

	}

	private void iconJGMouseClicked(java.awt.event.MouseEvent evt) {
		assignReady();
		lane = "jungle";
		iconTOP.setForeground(new Color(250, 250, 250));
		iconJG.setForeground(new Color(220, 170, 110));
		iconMID.setForeground(new Color(250, 250, 250));
		iconADC.setForeground(new Color(250, 250, 250));
		iconSUPP.setForeground(new Color(250, 250, 250));

	}

	private void iconMIDMouseClicked(java.awt.event.MouseEvent evt) {
		assignReady();
		lane = "mid";
		iconTOP.setForeground(new Color(250, 250, 250));
		iconJG.setForeground(new Color(250, 250, 250));
		iconMID.setForeground(new Color(220, 170, 110));
		iconADC.setForeground(new Color(250, 250, 250));
		iconSUPP.setForeground(new Color(250, 250, 250));

	}

	private void iconADCMouseClicked(java.awt.event.MouseEvent evt) {
		assignReady();
		lane = "adc";
		iconTOP.setForeground(new Color(250, 250, 250));
		iconJG.setForeground(new Color(250, 250, 250));
		iconMID.setForeground(new Color(250, 250, 250));
		iconADC.setForeground(new Color(220, 170, 110));
		iconSUPP.setForeground(new Color(250, 250, 250));

	}

	private void iconSUPPMouseClicked(java.awt.event.MouseEvent evt) {
		assignReady();
		lane = "support";
		iconTOP.setForeground(new Color(250, 250, 250));
		iconJG.setForeground(new Color(250, 250, 250));
		iconMID.setForeground(new Color(250, 250, 250));
		iconADC.setForeground(new Color(250, 250, 250));
		iconSUPP.setForeground(new Color(220, 170, 110));

	}

	private void thizeMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/thize/ThizeRuneTool"));
		} catch (URISyntaxException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void moverMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		Index.resX = (x - xMouse) - 40;
		Index.resY = (y - yMouse);
		this.setLocation(Index.resX, Index.resY);
	}

	private void moverMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void trnddMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/trndd/InterfaceThizeRuneTool"));
		} catch (URISyntaxException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void voltarMouseClicked(java.awt.event.MouseEvent evt) throws IOException {
		dispose();
		Index nm = new Index(Index.resX, Index.resY);
		nm.setVisible(true);
	}

	private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(Main.ICONIFIED);
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
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main(0, 0).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public static javax.swing.JLabel iconADC;
	public static javax.swing.JLabel iconJG;
	public static javax.swing.JLabel iconMID;
	public static javax.swing.JLabel iconSUPP;
	public static javax.swing.JLabel iconTOP;
	public static javax.swing.JCheckBox champSelect;
	public static javax.swing.JComboBox<String> champ;
	public static javax.swing.JComboBox<String> stat;
	public static javax.swing.JComboBox<String> reso;
	private javax.swing.JLabel mover;
	private javax.swing.JLabel fundo;
	private javax.swing.JLabel bMinimizar;
	private javax.swing.JLabel bFechar;
	static javax.swing.JLabel tCriar;
	static javax.swing.JLabel tOpgg;
	private javax.swing.JLabel tChamp;
	private javax.swing.JLabel logo;
	private javax.swing.JLabel tStat;
	private javax.swing.JLabel tReso;
	private javax.swing.JLabel bVoltar;
	private javax.swing.JLabel tThize;
	private javax.swing.JLabel tVer;
	private javax.swing.JLabel tTrndd;
	static javax.swing.JPanel botaoCor;
	static javax.swing.JPanel botaoCor2;
	// End of variables declaration//GEN-END:variables

}
