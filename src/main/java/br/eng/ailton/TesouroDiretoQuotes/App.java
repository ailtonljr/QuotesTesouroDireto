package br.eng.ailton.TesouroDiretoQuotes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class App {

	private static final String ELEMENT_CLASS = "camposTesouroDireto";
	
	private final static String cotesURL = "http://www.tesouro.fazenda.gov.br/tesouro-direto-precos-e-taxas-dos-titulos";

	public static void main(String[] args) throws Exception {

		if (args.length > 0) {

			
			String assetName = String.join(" ", args);

			Document doc = Jsoup.connect(cotesURL).get();

			Elements coteFieldsElements = doc.getElementsByClass(ELEMENT_CLASS);

			for (Element element : coteFieldsElements) {
				
				//If is the required element, print in the output.
				if (element.text().startsWith(assetName)) {
					
					//Get current date
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate localDate = LocalDate.now();
					String date = dtf.format(localDate);
					
					//Print element data and the current date
					if (element.children().size() == 4) {
						System.out.println(element.text() + " " + date);

					}

				}
			}

		}
	}
}
