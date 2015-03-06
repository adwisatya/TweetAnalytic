import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class PengecekKata 
{
		
	//Mengecek apakah kata ada di dalam daftar daerah. Mengembalkan true jika kata ada di dalam daftar daerah
	//Menggunakan algoritma KMP untuk pattern matching
	public static boolean isDaerahKMP(String kata)
	{
		boolean found = false;
		try
		{
			Path daerah = Paths.get("daerah.txt");
			
			List<String> fileContent = Files.readAllLines(daerah, StandardCharsets.UTF_8);
			
			int i = 0;
			while ((!found) && (i < fileContent.size()))
			{
				if (PatternMatcher.kmpMatch(kata, fileContent.get(i)) != -1)
				{
					found = true;
				} else {
					i++;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return found;
	}
	
	//Mengecek apakah kata ada di dalam daftar daerah. Mengembalkan true jika kata ada di dalam daftar daerah
	//Menggunakan algoritma BM untuk pattern matching
	public static boolean isDaerahBM(String kata)
	{
		boolean found = false;
		try
		{
			Path daerah = Paths.get("daerah.txt");
			
			List<String> fileContent = Files.readAllLines(daerah, StandardCharsets.UTF_8);
			
			int i = 0;
			while ((!found) && (i < fileContent.size()))
			{
				if (PatternMatcher.bmMatch(kata, fileContent.get(i)) != -1)
				{
					found = true;
				} else {
					i++;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return found;
	}
	
	//Fungsi untuk mengambil daerah dengan KMP
	public static String searchDaerahKMP(String input)
	{
		String output = "";
		
		boolean found = false;
		int i = 0;
		
		String[] pieces = input.split(" ");
		
		while ((!found) && (i < pieces.length))
		{
			if (PengecekKata.isDaerahKMP(pieces[i]))
			{
				output = pieces[i];
			} else {
				i++;
			}
		}
		return output;
	}
	
	//Fungsi untuk mengambil daerah dari string dengan BM
	public static String searchDaerahBM(String input)
	{
		String output = "";
		
		boolean found = false;
		int i = 0;
		
		String[] pieces = input.split(" ");
		
		while ((!found) && (i < pieces.length))
		{
			if (PengecekKata.isDaerahBM(pieces[i]))
			{
				output = pieces[i];
			} else {
				i++;
			}
		}
		return output;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		System.out.println(isDaerahBM(input));
		
		in.close();
	}
}
