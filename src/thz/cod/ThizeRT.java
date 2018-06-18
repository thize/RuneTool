package thz.cod;

import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ThizeRT {
	static String tComoUsar = "How to Use?";
	static String tProcurarUpdate = "";
	static String tAbrir = "START";
	static String tChampSelect = "In Champion Select";
	static String tClienteResolucao = "Client Resolution:";
	static String tLane = "Pick a Lane";
	static String tStat = "Stat:";
	static String tChampion = "Champion:";
	static String tAtribuir = "ASSIGN";
	static String tMost = "Most Frequent";
	static String tHigh = "Highest Win";
	static String tHigh2 = "HW";
	static String tMost2 = "MF";
	static String tNotFound = "NOT FOUND";
	static String tSup = "SUPP";
	static String tCarregando = "LOADING...";
	static String tBard = "Bard";
	public static Integer dpY = 10, dcY, dcX, dpX = 44, d, q, dt = 0, posi, aux;
	public static Integer x, y, n1, n2, n3, n4, idiomaSelecionado = 0;
	public static double versaoG, proporcao;;
	public static boolean selecao = true;
	public static String stat = "", champ = "", lane = "", linha;
	static Robot robot;
	static Integer iResolucao = 0;
	static Rectangle ret = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	static String VERSAO = "2.3", idioma = "EN_US", resolucao = "1024x576", versao = "2.3";
	static double versaoL = 0;

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		config();
		ver();
		robot = new Robot();
		Index.main(args);
	}

	private static void config() throws FileNotFoundException, IOException {
		try {
			br = new BufferedReader(new FileReader("config.txt"));
			versao = br.readLine();
			resolucao = br.readLine();
			idioma = br.readLine();
			if (idioma.equals("PT_BR")) {
				mudarIdioma(1);
			}
			lerConfig();
		} catch (Exception e) {
			File file = new File("ver.txt");
			file.delete();
			file = new File("language.txt");
			file.delete();
			FileWriter criar = new FileWriter("config.txt");
			String config = VERSAO + "\n" + resolucao + "\n" + idioma;
			System.out.println(config);
			criar.write(config);
			criar.close();
			config();
		}
	}

	static void lerConfig() {
		if (resolucao.equals("1280x720")) {
			iResolucao = 1;
		} else if (resolucao.equals("1600x900")) {
			iResolucao = 2;
		} else if (resolucao.equals("1920x1080")) {
			iResolucao = 3;
		}else {
			iResolucao = 0;
		}
	}

	public static void ver() throws IOException {
		Document web = null;
		web = Jsoup.connect("https://raw.githubusercontent.com/thize/RuneToolFiles/master/ver.txt").get();
		Elements clas = web.getElementsByTag("body");
		versaoG = Double.parseDouble(clas.text());
		versaoL = Double.parseDouble(versao);
		if (versaoG > versaoL) {
			tProcurarUpdate = "CLICK HERE TO UPDATE";
		}
	}

	static void mudarIdioma(int i) {
		if (i == 0) {
			if (versaoG > versaoL) {
				tProcurarUpdate = "CLICK HERE TO UPDATE";
			}
			idiomaSelecionado = 0;
			// EN
			tComoUsar = "How to Use?";
			tAbrir = "START";
			tChampSelect = "In Champion Select";
			tClienteResolucao = "Client Resolution:";
			tLane = "Pick a Lane";
			tStat = "Stat:";
			tChampion = "Champion:";
			tAtribuir = "ASSIGN";
			tMost = "Most Frequent";
			tHigh = "Highest Win";
			tNotFound = "NOT FOUND";
			tCarregando = "LOADING...";
			tHigh2 = "HW";
			tMost2 = "MF";
			tSup = "SUPP";
			tBard = "Bard";
		} else {
			if (versaoG > versaoL) {
				tProcurarUpdate = "CLICK AQUI PARA ATUALIZAR";
			}
			idiomaSelecionado = 1;
			// PT
			tComoUsar = "Como usar?";
			tAbrir = "COMEÇAR";
			tChampSelect = "Na Seleção de Campeão";
			tClienteResolucao = "Resolução Cliente:";
			tLane = "Escolha a Lane";
			tStat = "Stat:";
			tBard = "Bardo";
			tChampion = "Campeão:";
			tAtribuir = "ATRIBUIR";
			tMost = "Mais Frequente";
			tHigh = "Maior Vitória";
			tHigh2 = "MV";
			tMost2 = "MF";
			tNotFound = "NÃO ENCONTRADO";
			tCarregando = "BUSCANDO...";
			tSup = "SUP";
		}
	}

	private static void pegarRuna(String url, int Z, int N) throws IOException, InterruptedException {
		Document web = null;
		// N : Runa Desejada
		// Z : Posi Classe(7 ou 8)
		web = Jsoup.connect(url).get();
		Elements clas = web.getElementsByTag("tbody");
		Elements rw = clas.get(Z).select("tr");
		d = 23;// paraRunaDeDeterminaï¿½ï¿½o
		q = 12;// Quantidade de elementos na runa
		Main.assignReady();
		clicar(73, 600);// MudarLayout Runas
		primeiraAbaRuna(N, rw);
		segundaAbaRuna(N, rw, d, q);
		// Concluir Runa
		nomearRuna(stat, champ, lane);
		clicar(410, 50);// Salvar
	}

	static Boolean precisao = false;
	static Boolean dominacao = false;
	static Boolean feiticaria = false;
	static Boolean determinacao = false;
	static Boolean inspiracao = false;
	static BufferedReader br;

	private static void primeiraAbaRuna(int N, Elements rw) throws InterruptedException {
		// PrimeiraAbaDasRunas
		dt = 0;
		// dt = Adicionar 1 bloco na segunda runa caso primeira seja Dominacao
		for (int i = 0; i <= q; i++) {
			int escolha = 0;
			for (Element row : rw) {
				Elements img = row.getElementsByTag("img");
				if (escolha == N && !img.get(i).attr("src").contains("?image=e_grayscale&v=1")) {// Escolha = N(0 ou 1)
					if (i == 0)
						classeRuna(img.get(i).attr("src"), 1);
					if (i == 0 && img.get(i).attr("src")
							.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8000.png") || precisao) {
						if (!precisao) {
							q++;
							d++;// AumentarSegundoForPara2Runa
							dt++;
						}
						precisao = true;
						if (i == 1 || i == 2 || i == 3 || i == 4) {// Linha 11
							linhasPrimeiraAba(11, i - 1);
						} else if (i == 5 || i == 6 || i == 7) {// Linha 2
							linhasPrimeiraAba(2, i - 5);
						} else if (i == 8 || i == 9 || i == 10) {// Linha 3
							linhasPrimeiraAba(3, i - 8);
						} else if (i == 11 || i == 12 || i == 13) {// Linha 11
							linhasPrimeiraAba(4, i - 11);
						}
					} else if (i == 0 && img.get(i).attr("src")
							.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8100.png") || dominacao) {
						if (!dominacao) {
							q += 2;
							d++;// AumentarSegundoForPara2Runa
							dt += 2;
						}
						dominacao = true;
						if (i == 1 || i == 2 || i == 3 || i == 4) {// Linha 11
							linhasPrimeiraAba(11, i - 1);
						} else if (i == 5 || i == 6 || i == 7) {// Linha 2
							linhasPrimeiraAba(2, i - 5);
						} else if (i == 8 || i == 9 || i == 10) {// Linha 3
							linhasPrimeiraAba(3, i - 8);
						} else if (i == 11 || i == 12 || i == 13 || i == 14) {// Linha 11
							linhasPrimeiraAba(44, i - 11);
						}
					} else if (i == 0
							&& img.get(i).attr("src")
									.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8200.png")
							|| feiticaria) {
						feiticaria = true;
						if (i == 1 || i == 2 || i == 3) {// Linha 11
							linhasPrimeiraAba(1, i - 1);
						} else if (i == 4 || i == 5 || i == 6) {// Linha 2
							linhasPrimeiraAba(2, i - 4);
						} else if (i == 7 || i == 8 || i == 9) {// Linha 3
							linhasPrimeiraAba(3, i - 7);
						} else if (i == 10 || i == 11 || i == 12) {// Linha 11
							linhasPrimeiraAba(4, i - 10);
						}
					} else if (i == 0
							&& img.get(i).attr("src")
									.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8400.png")
							|| determinacao) {
						determinacao = true;
						if (i == 1 || i == 2 || i == 3) {// Linha 11
							linhasPrimeiraAba(1, i - 1);
						} else if (i == 4 || i == 5 || i == 6) {// Linha 2
							linhasPrimeiraAba(2, i - 4);
						} else if (i == 7 || i == 8 || i == 9) {// Linha 3
							linhasPrimeiraAba(3, i - 7);
						} else if (i == 10 || i == 11 || i == 12) {// Linha 4
							linhasPrimeiraAba(4, i - 10);
						}
					} else if (i == 0
							&& img.get(i).attr("src")
									.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8300.png")
							|| inspiracao) {
						inspiracao = true;
						if (i == 1 || i == 2 || i == 3) {// Linha 11
							linhasPrimeiraAba(1, i - 1);
						} else if (i == 4 || i == 5 || i == 6) {// Linha 2
							linhasPrimeiraAba(2, i - 4);
						} else if (i == 7 || i == 8 || i == 9) {// Linha 3
							linhasPrimeiraAba(3, i - 7);
						} else if (i == 10 || i == 11 || i == 12) {// Linha 4
							linhasPrimeiraAba(4, i - 10);
						}
					}
				}
				escolha++;
			}
		}

	}

	private static void segundaAbaRuna(int N, Elements rw, int d, int q) throws InterruptedException {
		// SegundaAbaDasRunas
		N = 0;
		boolean dominacao = false;
		for (int i = (q + 1); i < d; i++) {
			int escolha = 0;
			for (Element row : rw) {
				Elements img = row.getElementsByTag("img");
				if (img.get(i).attr("src").equals("//opgg-static.akamaized.net/images/lol/perkStyle/8100.png")) {
					dominacao = true;
				}
				if (escolha == N && !img.get(i).attr("src").contains("?image=e_grayscale&v=1")) {// Escolha = N(0 ou 1)
					if (i == (q + 1)) {
						classeRuna(img.get(i).attr("src"), 2);
					} else if (i == (dt + 14) || i == (dt + 15) || i == (dt + 16)) {// Linha 1
						linhasSegundaAba(1, i - (dt + 14));
					} else if (i == (dt + 17) || i == (dt + 18) || i == (dt + 19)) {// Linha 2
						linhasSegundaAba(2, i - (dt + 17));
					} else if (dominacao) {
						if (i == (dt + 20) || i == (dt + 21) || i == (dt + 22) || i == (dt + 23)) {
							linhasSegundaAba(33, i - (dt + 20));
						}
					} else if (i == (dt + 20) || i == (dt + 21) || i == (dt + 22)) {
						linhasSegundaAba(3, i - (dt + 20));
					}
				}
				escolha++;
			}

		}
	}

	private static void classeRuna(String runa, int aba) throws InterruptedException {
		if (runa.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8000.png")) {
			posi = 0;
			if (aba == 1) {
				aux = 1;
			}
		} else if (runa.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8100.png")) {
			posi = 1;
			if (aba == 1) {
				aux = 2;
			}
		} else if (runa.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8200.png")) {
			posi = 2;
			if (aba == 1) {
				aux = 3;
			}
		} else if (runa.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8400.png")) {
			posi = 3;
			if (aba == 1) {
				aux = 4;
			}
		} else if (runa.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8300.png")) {
			posi = 4;
			if (aba == 1) {
				aux = 5;
			}
		}

		if (aba == 1) {
			clicar(129 + (posi * 40), 138);
		} else {
			if (aux <= posi) {
				posi--;
			}
			clicar(460 + (posi * 50), 138);
		}

	}

	private static void clicar(double k, double l) throws InterruptedException {
		Double x = k;
		Double y = l;
		Thread.sleep(250);
		// Distancia Cliente = dc
		// Distancia PC = dp
		dcX = 0;
		dcY = 74;
		if (selecao) {// ChampionSelect
			dcX = 109;
			dcY -= 3;
		}
		x = ((x + dcX) / proporcao) + dpX;
		y = ((y + dcY) / proporcao) + dpY;
		robot.mouseMove(x.intValue() + ImageScanner.thizeX.intValue(), y.intValue() + ImageScanner.thizeY.intValue());
		robot.mousePress(InputEvent.BUTTON1_MASK);// Clicar
		robot.mouseRelease(InputEvent.BUTTON1_MASK);// Clicar

	}

	private static void linhasPrimeiraAba(int c, int a) throws InterruptedException {
		if (c == 1) {
			x = 145 + (a * 66);
			y = 250;
		} else if (c == 11) {
			x = 138 + (a * 51);
			y = 250;
		} else if (c == 2) {
			x = 145 + (a * 66);
			y = 350;
		} else if (c == 22) {
			x = 138 + (a * 51);
			y = 350;
		} else if (c == 3) {
			x = 145 + (a * 66);
			y = 440;
		} else if (c == 33) {
			x = 138 + (a * 51);
			y = 440;
		} else if (c == 4) {
			x = 145 + (a * 66);
			y = 525;
		} else if (c == 44) {
			x = 138 + (a * 51);
			y = 525;
		}
		clicar(x, y);
	}

	private static void linhasSegundaAba(int c, int a) throws InterruptedException {
		if (c == 1) {
			x = 471 + (a * 66);
			y = 226;
		} else if (c == 11) {
			x = 464 + (a * 51);
			y = 226;
		} else if (c == 2) {
			x = 463 + (a * 66);
			y = 304;
		} else if (c == 22) {
			x = 464 + (a * 51);
			y = 304;
		} else if (c == 3) {
			x = 471 + (a * 66);
			y = 382;
		} else if (c == 33) {
			x = 464 + (a * 51);
			y = 382;
		}
		clicar(x, y);
	}

	private void jsoup(String url, int a, int k, String palavra) throws IOException {
		Document web = null;
		web = Jsoup.connect(url).get();
		Elements clas = web.getElementsByTag("tbody");
		Elements rw = null;
		try {
			if (k == 0) {
				rw = clas.get(7).select("tr");
			} else {
				rw = clas.get(8).select("tr");
			}
		} catch (Exception e) {
			Main.assignMouseRed();
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
					n1 = (int) Double.parseDouble(aux);
					auxx++;
				} else {
					n2 = (int) Double.parseDouble(aux);
				}
			} else {
				if (auxx == 0) {
					n3 = (int) Double.parseDouble(aux);
					auxx++;
				} else {
					n4 = (int) Double.parseDouble(aux);
				}
			}

		}
	}

	private static void nomearRuna(String win, String champ, String lane) throws InterruptedException {
		clicar(50, 52);// NomearRuna
		clicar(294, 52);// NomearRuna
		clicar(294, 52);// NomearRuna
		clicar(294, 52);// NomearRuna
		String stat;
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		if (lane.equals("top")) {
			lane = "Top";
		} else if (lane.equals("jungle")) {
			lane = "Jg";
		} else if (lane.equals("mid")) {
			lane = "Mid";
		} else if (lane.equals("adc")) {
			lane = "Adc";
		} else {
			lane = "Sup";
		}
		if (win.equals(tMost)) {
			stat = tMost2;
		} else {
			stat = tHigh2;
		}
		String text = champ + " | " + lane + " | " + stat;
		StringSelection selection = new StringSelection(text);
		clipboard.setContents(selection, null);
		try {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
		} catch (Exception e) {

		}
	}

	static void chamarRuna(String champp, String lanee, String statt, String resoo)
			throws InterruptedException, IOException {
		champ = champp;
		stat = statt;
		lane = lanee;
		if (resoo.equals("1280x720")) {
			dpX = (ret.width - 1280) / 2;
			dpY = (ret.height - 720) / 2;
			proporcao = 1;
		} else if (resoo.equals("1024x576")) {
			dpX = (ret.width - 1024) / 2;
			dpY = (ret.height - 576) / 2;
			proporcao = 1.25;
		} else if (resoo.equals("1600x900")) {
			dpX = (ret.width - 1600) / 2;
			dpY = (ret.height - 900) / 2;
			proporcao = 0.8;
		} else if (resoo.equals("1920x1080")) {
			dpX = (ret.width - 1920) / 2;
			dpY = (ret.height - 1080) / 2;
			proporcao = 0.66666666666666667;
		}
		String url = "https://br.op.gg/champion/" + champp + "/statistics/" + lanee;
		ThizeRT scrapper = new ThizeRT();
		ImageScanner.thizeX = ImageScanner.valorX;
		ImageScanner.thizeY = ImageScanner.valorY;
		ImageScanner.thizeX = (ImageScanner.thizeX - (ret.width - (1280 / proporcao)) / 2);
		ImageScanner.thizeY = (ImageScanner.thizeY - (ret.height - (720 / proporcao)) / 2);
		if (!Main.imagemEncontrada) {
			ImageScanner.thizeX = 0.0;
			ImageScanner.thizeY = 0.0;
		}
		if (statt.equals(tMost)) {
			winPick(url, scrapper, 0, "span");
		} else {
			winPick(url, scrapper, 1, "strong");
		}
	}

	private static void winPick(String url, ThizeRT scrapper, int ss, String wp)
			throws InterruptedException, IOException {
		scrapper.jsoup(url, ss, 0, wp);// Pick (ss = 0, wp ="span")
		scrapper.jsoup(url, ss, 1, wp);// Win (ss = 1, wp = "strong")
		if (n1 >= n2 && n1 >= n3 && n1 >= n4) {
			pegarRuna(url, 7, 0);
		} else if (n2 >= n1 && n2 >= n3 && n2 >= n4) {
			pegarRuna(url, 7, 1);
		} else if (n3 >= n1 && n3 >= n2 && n3 >= n4) {
			pegarRuna(url, 8, 0);
		} else {
			pegarRuna(url, 8, 1);
		}

	}

	public static void sobescrever(int a, String string) throws IOException {
		FileWriter criar = new FileWriter("config.txt");
		String config = versao + "\n" + resolucao + "\n" + string;
		if (a == 0) {
			config = string + "\n" + resolucao + "\n" + idioma;
		} else if (a == 1) {
			config = versao + "\n" + string + "\n" + idioma;
		}
		criar.write(config);
		criar.close();
	}
}