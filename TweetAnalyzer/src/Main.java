import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Kelas untuk main program
public class Main {
	public static void main(String[] args)
	{
		String hashtag = "";
		String keywordKategori1 = "";
		String keywordKategori2 = "";
		String keywordKategori3 = "";
		String algoritma = "";
		String proxyString = "";
		
		//Baca proxy setting
		try
		{
			Scanner in = new Scanner(new File("proxy.txt"));
			in.useDelimiter(System.getProperty("line.separator"));
			proxyString = in.next();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Baca file input
		try
		{
			File inputFile = new File("input.txt");
			Scanner in = new Scanner(inputFile);
			in.useDelimiter(System.getProperty("line.separator"));
			hashtag = in.next();
			keywordKategori1 = in.next();
			keywordKategori2 = in.next();
			keywordKategori3 = in.next();
			algoritma = in.next();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		//Tentukan jenis algoritma
		boolean isKMP = true;
		if (algoritma.equalsIgnoreCase("BM"))
		{
			isKMP = false;
		}
		
		//Ambil tweetnya
		ArrayList<tweet> listOfTweet = Tweets.getTweets(hashtag, proxyString);
		
		// Proses tweetnya
		//Siapkan tiap-tiap kategori
		Kategori macet = new Kategori();
		Kategori tutup = new Kategori();
		Kategori kecelakaan = new Kategori();
		Kategori etc = new Kategori();
		
		macet.keywords = Arrays.asList(keywordKategori1.split(","));
		tutup.keywords = Arrays.asList(keywordKategori2.split(","));
		kecelakaan.keywords = Arrays.asList(keywordKategori3.split(","));
		
		// Proses kategorinya
		int i = 0;
		
		if (isKMP)
		{
			//Proses kategori macet
			while (i < listOfTweet.size())
			{
				if (macet.prosesTweetKMP(listOfTweet.get(i)))
				{
					listOfTweet.remove(i);
				} else {
					i++;
				}
			}
			
			//Proses kategori tutup
			i = 0;
			while (i < listOfTweet.size())
			{
				if (tutup.prosesTweetKMP(listOfTweet.get(i)))
				{
					listOfTweet.remove(i);
				} else {
					i++;
				}
			}
			
			//Proses kategori kecelakaan
			i = 0;
			while (i < listOfTweet.size())
			{
				if (kecelakaan.prosesTweetKMP(listOfTweet.get(i)))
				{
					listOfTweet.remove(i);
				} else {
					i++;
				}
			}
		} else {
			//Proses kategori macet
			while (i < listOfTweet.size())
			{
				if (macet.prosesTweetBM(listOfTweet.get(i)))
				{
					listOfTweet.remove(i);
				} else {
					i++;
				}
			}
			
			//Proses kategori tutup
			i = 0;
			while (i < listOfTweet.size())
			{
				if (tutup.prosesTweetBM(listOfTweet.get(i)))
				{
					listOfTweet.remove(i);
				} else {
					i++;
				}
			}
			
			//Proses kategori kecelakaan
			i = 0;
			while (i < listOfTweet.size())
			{
				if (kecelakaan.prosesTweetBM(listOfTweet.get(i)))
				{
					listOfTweet.remove(i);
				} else {
					i++;
				}
			}
		}
		//Masukkin sisa tweet ke kategori lainnya
		while (!listOfTweet.isEmpty())
		{
			etc.add(listOfTweet.get(0).getLink(), listOfTweet.get(0).getText());
			listOfTweet.remove(0);
		}
		
		//Cetak semuanya ke output
		try {
			PrintStream printer = new PrintStream("output.txt");
			
			printer.println("Kategori macet");
			printer.printf("Total tweet: %d%s", macet.jumlah, System.getProperty("line.separator"));
			macet.printToFile(printer);
			
			printer.println("Kategori tutup:");
			printer.printf("Total tweet: %d%s", tutup.jumlah, System.getProperty("line.separator"));
			tutup.printToFile(printer);
			
			printer.println("Kategori kecelakaan");
			printer.printf("Total tweet: %d%s", kecelakaan.jumlah, System.getProperty("line.separator"));
			kecelakaan.printToFile(printer);
			
			printer.println("Kategori unknown");
			printer.printf("Total tweet: %d%s", etc.jumlah, System.getProperty("line.separator"));
			etc.printToFile(printer);
						
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
