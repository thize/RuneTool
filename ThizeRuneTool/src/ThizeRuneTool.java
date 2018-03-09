import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ThizeRuneTool extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public static Robot robot;
	static int y = 0, w = 0, x = 0, z = 0;//
	static int second;

	public static void main(String[] args) throws IOException, AWTException {
		robot = new Robot();
		iniciarInterface();
	}

	public ThizeRuneTool() {
		initComponents();
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Giovani\\Desktop\\logo.png");
		this.setIconImage(imagemTitulo);
	}

	private static void iniciarInterface() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ThizeRuneTool.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ThizeRuneTool.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ThizeRuneTool.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ThizeRuneTool.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ThizeRuneTool().setVisible(true);
			}
		});
	}

	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		win = new javax.swing.JComboBox<>();
		tStat = new javax.swing.JLabel();
		champ = new javax.swing.JComboBox<>();
		lane = new javax.swing.JComboBox<>();
		tChamp = new javax.swing.JLabel();
		tLane = new javax.swing.JLabel();
		tThize = new javax.swing.JLabel();
		tVers = new javax.swing.JLabel();
		start = new javax.swing.JButton();
		att = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		fundo = new javax.swing.JLabel();

		javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
		jLayeredPane1.setLayout(jLayeredPane1Layout);
		jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
		jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setAutoRequestFocus(false);
		setBackground(new java.awt.Color(51, 153, 0));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setFocusTraversalPolicyProvider(true);
		setPreferredSize(new java.awt.Dimension(500, 500));
		setResizable(false);
		setType(java.awt.Window.Type.POPUP);
		getContentPane().setLayout(null);

		win.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		win.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Highest Win", "Most Frequent" }));
		getContentPane().add(win);
		win.setBounds(200, 350, 124, 20);

		tStat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tStat.setForeground(new java.awt.Color(0, 0, 0));
		tStat.setText("Stat:");
		getContentPane().add(tStat);
		tStat.setBounds(160, 350, 27, 14);

		champ.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		champ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aatrox", "Ahri", "Akali", "Alistar",
				"Amumu", "Anivia", "Annie", "Ashe", "Aurelion Sol", "Azir", "Bard", "Blitzcrank", "Brand", "Braum",
				"Caitlyn", "Camille", "Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr. Mundo ", "Draven",
				"Ekko ", "Elise ", "Evelynn ", "Ezreal ", "Fiddlesticks", "Fiora ", "Fizz", "Galio", "Gangplank",
				"Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Illaoi", "Irelia", "Ivern", "Janna",
				"Jarvan IV", "Jax", "Jayce", "Jhin", "Jinx", "Kai'sa", "Kalista", "Karma", "Karthus", "Kassadin",
				"Katarina", "Kayle", "Kayn", "Kennen", "Kha'Zix", "Kindred", "Kled", "Kog'Maw", "LeBlanc", "Lee Sin",
				"Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi",
				"Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu",
				"Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Quinn", "Rakan", "Rammus", "Rek'Sai", "Renekton",
				"Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir",
				"Skarner", "Sona", "Soraka", "Swain", "Syndra", "Tahm Kench", "Taliyah", "Talon", "Taric", "Teemo",
				"Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus",
				"Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xayah",
				"Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zoe", "Zyra" }));
		champ.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		getContentPane().add(champ);
		champ.setBounds(200, 290, 124, 20);

		lane.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lane.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top", "Jg", "Mid", "Adc", "Sup" }));
		getContentPane().add(lane);
		lane.setBounds(200, 320, 124, 20);

		tChamp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tChamp.setForeground(new java.awt.Color(0, 0, 0));
		tChamp.setText("Champion:");
		getContentPane().add(tChamp);
		tChamp.setBounds(130, 290, 59, 14);

		tLane.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tLane.setForeground(new java.awt.Color(0, 0, 0));
		tLane.setText("Lane:");
		getContentPane().add(tLane);
		tLane.setBounds(160, 320, 30, 14);

		tThize.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tThize.setForeground(new java.awt.Color(0, 0, 0));
		tThize.setText("Thize");
		getContentPane().add(tThize);
		tThize.setBounds(450, 450, 30, 14);

		tVers.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		tVers.setForeground(new java.awt.Color(0, 0, 0));
		tVers.setText("Beta");
		getContentPane().add(tVers);
		tVers.setBounds(10, 450, 30, 14);

		start.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		start.setText("Start");
		start.setAlignmentY(0.0F);
		start.setMargin(new java.awt.Insets(0, 14, 0, 14));
		start.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					startActionPerformed(evt);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(start);
		start.setBounds(120, 410, 272, 52);
		att.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOz18N
		att.setText("Att");
		att.setAlignmentY(0.0F);
		att.setMargin(new java.awt.Insets(0, 14, 0, 14));
		att.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				attActionPerformed(evt);
			}
		});
		getContentPane().add(att);
		att.setBounds(40, 430, 80, 30);

		jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Giovani\\Desktop\\League_of_Legends_logo.png")); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, -10, 500, 280);

		fundo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Giovani\\Desktop\\g.png")); // NOI18N
		getContentPane().add(fundo);
		fundo.setBounds(0, 0, 500, 510);

		pack();
	}// </editor-fold>

	private void startActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
		ChamarCampeao(champ.getSelectedItem(), lane.getSelectedItem(), win.getSelectedItem());
	}

	private void attActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("Em implementação");
	}

	public void span(String url, int a, int k, String palavra) {
		Document web = null;
		try {
			web = Jsoup.connect(url).get();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		Elements clas = web.getElementsByTag("tbody");
		Elements rw = null;
		if (k == 0) {
			rw = clas.get(7).select("tr");
		} else {
			rw = clas.get(8).select("tr");
		}
		int auxx = 0;
		for (Element row : rw) {
			Elements columns = row.getElementsByTag(palavra);
			String aux = "";
			if (a == 0) {
				aux = columns.get(a).text().replace(",", "");
			} else {
				aux = columns.get(a).text().replace("%", "");
			}
			if (k == 0) {
				if (auxx == 0) {
					w = (int) Double.parseDouble(aux);
					auxx++;
				} else {
					x = (int) Double.parseDouble(aux);
				}
			} else {
				if (auxx == 0) {
					y = (int) Double.parseDouble(aux);
					auxx++;
				} else {
					z = (int) Double.parseDouble(aux);
				}
			}

		}
	}

	public static void pegarRuna(String url, int z, int n) throws InterruptedException {
		Document web = null;
		try {
			web = Jsoup.connect(url).get();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		Elements clas = web.getElementsByTag("tbody");
		Elements rw = clas.get(z).select("tr");
		int k = 0;
		int p = 23;
		clicar(-69, 345);
		for (int i = 0; i < p; i++) {
			int aux = 0;
			for (Element row : rw) {
				if (aux == n) {
					Elements img = row.getElementsByTag("img");
					if (i == k) {
						if (img.get(i).attr("src")
								.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8400.png")) {
							k = 14;
							p++;
						} else {
							k = 13;
						}
						runaPrincipal(img.get(i).attr("src"), i);
						clicar(x, y);
					} else if (!img.get(i).attr("src").contains("?image=e_grayscale&v=1")) {
						if (img.get(i).attr("src")
								.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8400.png")) {
						} else {
							runasGerais(img.get(i).attr("alt"), i);
							// System.out.println(img.get(i).attr("alt"));
							clicar(x, y);
						}
					}
				}
				aux++;
			}
		}
		clicar(266, -205);
	}

	private static void runaPrincipal(String attr, int i) throws InterruptedException {
		int aux = 0;
		if (i == 0) {
			// Primeira Aba da Runa
			switch (attr) {
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8000.png":
				second = 1;
				x = -16;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8100.png":
				second = 2;
				x = 23;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8200.png":
				second = 3;
				x = 62;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8400.png":
				second = 4;
				x = 101;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8300.png":
				second = 5;
				x = 143;
				y = -120;
				break;
			}
		} else {
			// Segunda Aba da Runa
			switch (attr) {
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8000.png":
				x = 314;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8100.png":
				aux = 2;
				x = 366;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8200.png":
				aux = 3;
				x = 414;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8400.png":
				aux = 4;
				x = 466;
				y = -120;
				break;
			case "//opgg-static.akamaized.net/images/lol/perkStyle/8300.png":
				aux = 5;
				x = 514;
				y = -120;
				break;
			}
			if (aux > second) {
				x -= 50;
			}
		}
	}

	private static void clicar(int x, int y) throws InterruptedException {
		Thread.sleep(100);
		robot.mouseMove((x + 186), (y + 341));
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	private static void runasGerais(String attr, int i) {
		switch (i) {
		case 1:
			x = 0;
			y = 0;
			break;
		case 2:
			x = 65;
			y = 0;
			break;
		case 3:
			x = 130;
			y = 0;
			break;
		case 4:
			x = 0;
			y = 99;
			break;
		case 5:
			x = 65;
			y = 99;
			break;
		case 6:
			x = 130;
			y = 99;
			break;
		case 7:
			x = 0;
			y = 188;
			break;
		case 8:
			x = 65;
			y = 188;
			break;
		case 9:
			x = 130;
			y = 188;
			break;
		case 10:
			x = 0;
			y = 275;
			break;
		case 11:
			x = 65;
			y = 275;
			break;
		case 12:
			x = 130;
			y = 275;
			break;
		case 14:
			x = 324;
			y = -30;
			break;
		case 15:
			x = 390;
			y = -30;
			break;
		case 16:
			x = 456;
			y = -30;
			break;
		case 17:
			x = 324;
			y = 50;
			break;
		case 18:
			x = 390;
			y = 50;
			break;
		case 19:
			x = 456;
			y = 50;
			break;
		case 20:
			x = 324;
			y = 125;
			break;
		case 21:
			x = 390;
			y = 125;
			break;
		case 22:
			x = 456;
			y = 125;
			break;
		}
	}

	private static void ChamarCampeao(Object champ, Object lane, Object stat) throws InterruptedException {
		String url = "https://br.op.gg/champion/" + champ + "/statistics/" + lane;
		ThizeRuneTool scrapper = new ThizeRuneTool();
		if (stat.equals("Highest Win")) {
			winrate(url, scrapper);
		} else {
			escolha(url, scrapper);
		}
	}

	private static void winrate(String url, ThizeRuneTool scrapper) throws InterruptedException {
		scrapper.span(url, 1, 0, "strong");
		scrapper.span(url, 1, 1, "strong");
		if (w >= x && w >= y && w >= z) {
			pegarRuna(url, 7, 0);
		} else if (x >= y && x >= z && x >= w) {
			pegarRuna(url, 7, 1);
		} else if (y >= x && y >= w && y >= z) {
			pegarRuna(url, 8, 0);
		} else {
			pegarRuna(url, 8, 1);
		}

	}

	private static void escolha(String url, ThizeRuneTool scrapper) throws InterruptedException {
		scrapper.span(url, 0, 0, "span");
		scrapper.span(url, 0, 1, "span");
		if (w >= x && w >= y && w >= z) {
			pegarRuna(url, 7, 0);
		} else if (x >= y && x >= z && x >= w) {
			pegarRuna(url, 7, 1);
		} else if (y >= x && y >= w && y >= z) {
			pegarRuna(url, 8, 0);
		} else {
			pegarRuna(url, 8, 1);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton att;
	private javax.swing.JComboBox<String> champ;
	private javax.swing.JLabel fundo;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JComboBox<String> lane;
	private javax.swing.JButton start;
	private javax.swing.JLabel tChamp;
	private javax.swing.JLabel tLane;
	private javax.swing.JLabel tThize;
	private javax.swing.JLabel tVers;
	private javax.swing.JLabel tStat;
	private javax.swing.JComboBox<String> win;
	// End of variables declaration

	
}