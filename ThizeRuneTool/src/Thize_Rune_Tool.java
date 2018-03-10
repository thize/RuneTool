import java.awt.AWTException;
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

public class Thize_Rune_Tool {
	private static int dpy = 10, dcy = 74, dcx = 0, dpx = 44, d, q, dt = 0, posi, aux;
	private static int x, y, n1, n2, n3, n4;
	private static Robot robot;
	private static boolean selecao = false;
	private static String stat = "dMost Frequent", champ = "maokai", lane = "top";

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		robot = new Robot();
		chamarRuna(champ, lane, stat);
	}

	private Thize_Rune_Tool() {
		// Cod para colocar Icone no Jframe
		/*
		 * Image imagemTitulo =
		 * Toolkit.getDefaultToolkit().getImage("C:\\Users\\Giovani\\Desktop\\logo.png")
		 * ; this.setIconImage(imagemTitulo);
		 */
		// Fim Cod para colocar Icone no Jframe
	}

	private static void pegarRuna(String url, int Z, int N) throws IOException, InterruptedException {
		Document web = null;
		// N : Runa Desejada
		// Z : Posi Classe(7 ou 8)
		web = Jsoup.connect(url).get();
		Elements clas = web.getElementsByTag("tbody");
		Elements rw = clas.get(Z).select("tr");
		d = 23;// paraRunaDeDeterminação
		q = 12;// Quantidade de elementos na runa
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
							.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8400.png")/* Determinação */) {
						q++;
						d++;// AumentarSegundoForPara2Runa
						dt = 1;
					}
					if (i == 1 || i == 2 || i == 3) {// Linha 1
						linhasPrimeiraAba(1, i - 1);
					} else if (i == 4 || i == 5 || i == 6) {// Linha 2
						linhasPrimeiraAba(2, i - 4);
					}
					if (q == 12) {
						if (i == 7 || i == 8 || i == 9) {// Linha 3
							linhasPrimeiraAba(3, i - 7);
						}
					} else {
						if (i == 7 || i == 8 || i == 9 || i == 10) {// Linha 3 Com Dominacao
							linhasPrimeiraAba(33, i - 7);
						}
					}
					if (i == 10 + dt || i == 11 + dt || i == 12 + dt) {// Linha 4
						linhasPrimeiraAba(4, i - (10 + dt));
					}
				}
				escolha++;
			}
		}
	}

	private static void segundaAbaRuna(int N, Elements rw, int d, int q) throws InterruptedException {
		// SegundaAbaDasRunas
		int p = 0;
		int dd = 0;
		for (int i = (q + 1); i < d; i++) {
			int escolha = 0;
			for (Element row : rw) {
				Elements img = row.getElementsByTag("img");
				if (escolha == N && !img.get(i).attr("src").contains("?image=e_grayscale&v=1")) {// Escolha = N(0 ou 1)
					if (i == (q + 1)) {
						classeRuna(img.get(i).attr("src"), 2);
					}

					if (i == (q + 1) && img.get(i).attr("src")
							.equals("//opgg-static.akamaized.net/images/lol/perkStyle/8400.png")) {// Determinacao
						p++;
						d++;// AumentarFor
						dd++;
					} else if (i == (dt + 14) || i == (dt + 15) || i == (dt + 16)) {// Linha 1
						linhasSegundaAba(1, i - (dt+14));
					}
					if (p == 13) {
						if (i == 17 || i == 18 || i == 19 || i == 20) {// Linha 2D
							linhasSegundaAba(22, i - 17);
						}
					} else {
						if (i == (dt + 17) || i == (dt + 18) || i == (dt + 19)) {// Linha 2
							linhasSegundaAba(2, i - (dt+17));
						}
					}
					if (i == (dt+dd + 20) || i == (dt+dd + 21) || i == (dd +dt+ 22)) {// Linha 3
						linhasSegundaAba(3, i - (dd+dt+20));
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
		Thread.sleep(200);
		// Distancia Cliente = dc
		// Distancia PC = dp
		dcx = 0;
		dcx = 0;
		if (selecao) {// ChampionSelect
			dcx = 5;
			dcy = 4;
		}
		robot.mouseMove((x + dcx + dpx), (y + dcy + dpy));
		robot.mousePress(InputEvent.BUTTON1_MASK);// Clicar
		robot.mouseRelease(InputEvent.BUTTON1_MASK);// Clicar
	}

	private static void linhasPrimeiraAba(int c, int a) throws InterruptedException {
		if (c == 1) {
			x = 145 + (a * 66);
			y = 250;
		} else if (c == 2) {
			x = 145 + (a * 66);
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
		} else if (c == 22) {
			x = 463 + (a * 51);
			y = 304;
		} else if (c == 3) {
			x = 471 + (a * 66);
			y = 382;
		}
		clicar(x, y);
	}

	private void jsoup(String url, int a, int k, String palavra) {
		// TODO Arrumar esse Codigo Feio
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
		if (win.equals("Most Frequent")) {
			stat = "MF";
		} else {
			stat = "HW";
		}
		String text = champ + "|" + lane + "|" + stat;
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

	private static void chamarRuna(String champ, String lane, String stat) throws InterruptedException, IOException {
		String url = "https://br.op.gg/champion/" + champ + "/statistics/" + lane;
		Thize_Rune_Tool scrapper = new Thize_Rune_Tool();
		if (stat.equals("Most Frequent")) {
			winPick(url, scrapper, 0, "span");
		} else {
			winPick(url, scrapper, 1, "strong");
		}
	}

	private static void winPick(String url, Thize_Rune_Tool scrapper, int ss, String wp)
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