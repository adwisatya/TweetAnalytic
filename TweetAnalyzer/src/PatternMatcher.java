import java.util.Scanner;

public class PatternMatcher {
	
	
	//Fungsi untuk melakukan pattern matching pada text dan pattern dengan menggunakna algoritma KMP
	//Mengembalikan posisi tempat pattern match jika pattern ditemukan. Posisi karakter pertama adalah 0.
	//Mengembalikan -1 jika pattern tidak ditemukan
	//Fungsi ini tidak case sensititve
	public static int kmpMatch(String text,String pattern)
	{
		text = text.toLowerCase();
		pattern = pattern.toLowerCase();
		int n = text.length();
		int m = pattern.length();
		int fail[] = computeFail(pattern);
		
		//System.out.println(Arrays.toString(fail));
		int i=0;
		int j=0;
		while(i <n){
			if(pattern.charAt(j) ==  text.charAt(i)){
				if(j == m-1){
					return i-m+1;
				}
				i++;
				j++;
			}else if(j>0)
			{
				j = fail[j-1];
			}else{
				i++;
			}
		}
		
		return -1;
	}
		
	//Fungsi penghitung fungsi failure dari kmp
	private static int[] computeFail(String pattern)
	{
		int[] fail = new int[pattern.length()];
		int k, q;
		
		fail[0] = -1;
		q = 1;
		k = -1;
		
		for (q=1;q<pattern.length(); q++)
		{
			while ((k >= 0) && (pattern.charAt(q) != pattern.charAt(k+1)))
			{
				k = fail[k];
			}
		
			if (pattern.charAt(q) == pattern.charAt(k+1))
			{
				k = k + 1;
			}
				
			fail[q] = k; 		
		}
		
		//Increment seluruh array
		int i;
		for (i=0; i<pattern.length(); i++)
		{
			fail[i]++;
		}
		return fail;
	}
	
	//Fungsi untuk melakukan pattern matching pada text dan pattern dengan menggunakna algoritma Booyer-Moore
	//Mengembalikan posisi tempat pattern match jika pattern ditemukan. Posisi karakter pertama adalah 0.
	//Mengembalikan -1 jika pattern tidak ditemukan
	//Fungsi ini tidak case sensititve
	public static int bmMatch(String text, String pattern)
	{
		text = text.toLowerCase();
		pattern = pattern.toLowerCase();
		int last[] = buildLast(pattern);
		int n = text.length();
		int m = pattern.length(); 
		int i = m-1;

		if(i>n-1)
		{
			return -1;
		}
		
		int j = m-1;
		
		do{
			if(pattern.charAt(j)   == text.charAt(i))
			{
				if(j==0)
				{
					return i;
				}else{
					i--;
					j--;
				}
			}else{
				int lo  =    last[text.charAt(i)];
				i = i+m - Math.min(j,1+lo);
				j = m-1;
			}
		} while(i<= n-1);
		return -1;
	}
	
	private static int[] buildLast(String pattern)
	{
		int last[] = new int[128];
		
		for(int i   =0; i<128;i++){
			last[i] =   -1;
		}
		
		for(int i=0;i<pattern.length(); i++)
		{
			last[pattern.charAt(i)] =   i;
		}
		
		return last;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
        
        System.out.println("Masukkan text:");
        String text = in.next();
        System.out.println("Masukkan pattern:");
        String pattern = in.next();
        
        int posn = kmpMatch(text, pattern);
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        
        
        if(posn == -1){
            System.out.println("Pattern not found");
          
        }else{
            System.out.println("Patter starts at posn " + posn);
        }
        
        in.close();
	}
}
