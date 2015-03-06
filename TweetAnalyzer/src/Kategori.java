import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class Kategori {
	public List <String> lokasi;
	public List <String> tweets;
	public List <String> link;
	public List <String> keywords;
	public int jumlah;
	
	public boolean prosesTweetKMP(tweet input)
	{
		boolean kategoriIni = false;
		int i = 0;
		
		while ((!kategoriIni) && (i < keywords.size()))
		{
			if (PatternMatcher.kmpMatch(input.getText(), keywords.get(i))!= -1)
			{
				kategoriIni = true;
				
				String lokasi = StringMatcher.cekRegex(input.getText());
				if (lokasi.equalsIgnoreCase(""))
				{
					lokasi = PengecekKata.searchDaerahKMP(input.getText());
				}
				
				this.add(input.getLink(), input.getText(), lokasi);
				 
			} else {
				i++;
			}
		}
		
		return kategoriIni;
	}
	
	public boolean prosesTweetBM(tweet input)
	{
		boolean kategoriIni = false;
		int i = 0;
		
		while ((!kategoriIni) && (i < keywords.size()))
		{
			if (PatternMatcher.kmpMatch(input.getText(), keywords.get(i))!= -1)
			{
				kategoriIni = true;
				
				String lokasi = StringMatcher.cekRegex(input.getText());
				if (lokasi.equalsIgnoreCase(""))
				{
					lokasi = PengecekKata.searchDaerahBM(input.getText());
				}
				
				this.add(input.getLink(), input.getText(), lokasi);
				 
			} else {
				i++;
			}
		}
		
		return kategoriIni;
	}
	
	public boolean isKategoriBM(tweet input)
	{
		boolean kategoriIni = false;
		int i = 0;
		
		while ((!kategoriIni) && (i < keywords.size()))
		{
			if (PatternMatcher.bmMatch(input.getText(), keywords.get(i))!= -1)
			{
				kategoriIni = true;
			} else {
				i++;
			}
		}
		
		return kategoriIni;
	}
	
	public Kategori()
	{
		jumlah = 0;
		lokasi = new ArrayList<>();
		tweets = new ArrayList<>();
		link = new ArrayList<>();
	}
	
	public void add(String link, String tweet, String lokasi)
	{
		jumlah++;
		this.lokasi.add(lokasi);
		this.tweets.add(tweet);
		this.link.add(link);
	}
	
	public void add(String link, String tweet)
	{
		jumlah++;
		this.lokasi.add("");
		this.tweets.add(tweet);
		this.link.add(link);
	}
	
	public void printToFile(PrintStream printer)
	{
		int i;
		
		printer.print("Lokasi: ");
		
		//Remove duplicate elements
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		
		for (i=0; i< lokasi.size(); i++)
		{
			String tmp = lokasi.get(i);
			tmp = tmp.toLowerCase();
			hs.add(tmp);
		}
		
		ArrayList <String> temp = new ArrayList<>();
		temp.addAll(hs);		
		for (i=0; i<temp.size(); i++)
		{
			if (temp.get(i).length() > 0)
			{
				if (i == temp.size() - 1)
				{
					printer.println(temp.get(i));
				} else {
					printer.printf("%s, ", temp.get(i));
				}
			}
		}
		
		printer.println("Tweets:");
		for (i=0; i<tweets.size(); i++)
		{
			printer.print(link.get(i));
			printer.print(" ||| ");
			printer.println(tweets.get(i));
		}
	}
}
