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
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ThizeRT {
	private static int dpY = 10, dcY, dcX, dpX = 44, d, q, dt = 0, posi, aux;
	private static int x, y, n1, n2, n3, n4;
	public static double versaoG;
	public static boolean selecao = true;
	private static String stat = "", champ = "", lane = "";
	static Robot robot;

	public static void ver() throws IOException {
		Document web = null;
		web = Jsoup.connect("https://raw.githubusercontent.com/thize/RuneTool/master/ver.txt").get();
		Elements clas = web.getElementsByTag("body");
		versaoG = Double.parseDouble(clas.text());
	}

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		robot = new Robot();
		Rectangle d = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		dpX = (d.width - 1280) / 2;
		dpY = (d.height - 720) / 2;
		Index.main(args);
	}

	private static void pegarRuna(String url, int Z, int N) throws IOException, InterruptedException {
		Document web = null;
		// N : Runa Desejada
		// Z : Posi Classe(7 ou 8)
		web = Jsoup.connect(url).get();
		Elements clas = web.getElementsByTag("tbody");
		Elements rw = clas.get(Z).select("tr");
		d = 23;// paraRunaDeDetermina��o
		q = 12;// Quantidade de elementos na runa
		Main.assignReady();
		clicar(73, 600);// MudarLayout Runas
		primeiraAbaRuna(N, rw);
		segundaAbaRuna(N, rw, d, q);
		// Concluir Runa
		nomearRuna(stat, champ, lane);
		clicar(410, 50);// Salvar
	}

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
							.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8000.png")) {
						q++;
						d++;// AumentarSegundoForPara2Runa
						dt = 1;
					} else {
						if (q == 13) {
							if (i == 1 || i == 2 || i == 3 || i == 4) {// Linha 11
								linhasPrimeiraAba(11, i - 1);
							}
						} else {
							if (i == 1 || i == 2 || i == 3) {// Linha 1
								linhasPrimeiraAba(1, i - 1);
							}
						}
						if (i == (dt + 4) || i == (dt + 5) || i == (dt + 6)) {// Linha 2
							linhasPrimeiraAba(2, i - (dt + 4));
						} else if (i == (dt + 7) || i == (dt + 8) || i == (dt + 9)) {// Linha 3
							linhasPrimeiraAba(3, i - (dt + 7));
						} else if (i == (dt + 10) || i == (dt + 11) || i == (dt + 12)) {// Linha 4
							linhasPrimeiraAba(4, i - (dt + 10));
						}
					}
				}
				escolha++;
			}
		}

	}

	private static void segundaAbaRuna(int N, Elements rw, int d, int q) throws InterruptedException {
		// SegundaAbaDasRunas
		for (int i = (q + 1); i < d; i++) {
			int escolha = 0;
			for (Element row : rw) {
				Elements img = row.getElementsByTag("img");
				if (escolha == N && !img.get(i).attr("src").contains("?image=e_grayscale&v=1")) {// Escolha = N(0 ou 1)
					if (i == (q + 1)) {
						classeRuna(img.get(i).attr("src"), 2);
					} else if (i == (dt + 14) || i == (dt + 15) || i == (dt + 16)) {// Linha 1
						linhasSegundaAba(1, i - (dt + 14));
					} else if (i == (dt + 17) || i == (dt + 18) || i == (dt + 19)) {// Linha 2
						linhasSegundaAba(2, i - (dt + 17));
					} else if (i == (dt + 20) || i == (dt + 21) || i == (dt + 22)) {// Linha 3
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

	private static void clicar(int x, int y) throws InterruptedException {
		Thread.sleep(250);
		// Distancia Cliente = dc
		// Distancia PC = dp
		dcX = 0;
		dcY = 74;
		if (selecao) {// ChampionSelect
			dcX = 109;
			dcY -= 3;
		}
		robot.mouseMove((x + dcX + dpX), (y + dcY + dpY));
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
		} else if (c == 3) {
			x = 145 + (a * 66);
			y = 440;
		} else if (c == 4) {
			x = 145 + (a * 66);
			y = 525;
		}
		clicar(x, y);
	}

	private static void linhasSegundaAba(int c, int a) throws InterruptedException {
		if (c == 1) {
			x = 471 + (a * 66);
			y = 226;
		} else if (c == 2) {
			x = 463 + (a * 66);
			y = 304;
		} else if (c == 3) {
			x = 471 + (a * 66);
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
		if (win.equals("Most Frequent")) {
			stat = "MF";
		} else {
			stat = "HW";
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

	static void chamarRuna(String champp, String lanee, String statt) throws InterruptedException, IOException {
		champ = champp;
		stat = statt;
		lane = lanee;
		String url = "https://br.op.gg/champion/" + champp + "/statistics/" + lanee;
		ThizeRT scrapper = new ThizeRT();
		if (statt.equals("Most Frequent")) {
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
}