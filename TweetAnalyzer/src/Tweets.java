import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class Tweets {
	
	//Ambil 100 tweet terbaaru dengan hashtag sesuai input
	public static ArrayList<tweet> getTweets(String hashTag, String proxyString) {
		ArrayList<tweet> ListofTweets = new ArrayList<>();
		//Setting proxy
		/*
        boolean IsProxyEnabled = true;
        String username = "fauzan_hilmi";
        String password = "seiryukan";
        String hashtag = hashTag;
        */
		
		boolean IsProxyEnabled;
		String username = "";
		String password = "";
		int port = 80;
		String host = "";
		if (proxyString.isEmpty())
		{
			IsProxyEnabled = false;
		} else {
			IsProxyEnabled = true;
			Scanner stringScanner = new Scanner(proxyString);
			stringScanner.useDelimiter(":");
			try
			{
				host = stringScanner.next();
				port = Integer.parseInt(stringScanner.next());
				username = stringScanner.next();
				password = stringScanner.next();
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
			stringScanner.close();
		}
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("zhCOwBkE9H3F1qz6obodIiisW");
        cb.setOAuthConsumerSecret("dpfEM2vN1Jyl2XalJO0BJ2Hh8ScPPDM5A93SLp84UBp56KN8Gk");
        cb.setOAuthAccessToken("2465006881-Tj7sm7Gnky3k6g5renjzC4cf2avScoXYJtCtWCH");
        cb.setOAuthAccessTokenSecret("U6NdUUohGWsdJXSfQfkXvhnsXAX7XUIUE9Xg9jDbxIDJg");
        if (IsProxyEnabled)
        {
           cb.setHttpProxyHost(host);
           cb.setHttpProxyPort(port);
           cb.setHttpProxyUser(username);
           cb.setHttpProxyPassword(password);
        }
        
       TwitterFactory tf = new TwitterFactory(cb.build());
       Twitter twitter = tf.getInstance();
       //Ambil 100 tweet terbaru
       try{
           Query q = new Query(hashTag+"+exclude:retweets");
           q.setCount(100);
           QueryResult qr = twitter.search(q);
           ListofTweets = new ArrayList<>();
           for (int i=0; i<qr.getTweets().size(); i++)
           {
                /*System.out.println(qr.getTweets().get(i).getText());
                System.out.println(qr.getTweets().get(i).getId());
                System.out.println(qr.getTweets().get(i).getUser().getScreenName());
                System.out.println("https://twitter.com/"+qr.getTweets().get(i).getUser().getScreenName()+"/status/"+qr.getTweets().get(i).getId());
                System.out.println();*/
               
                long id = qr.getTweets().get(i).getId();
                String user = qr.getTweets().get(i).getUser().getScreenName();
                String text = qr.getTweets().get(i).getText();
                String link = "https://twitter.com/"+user+"/status/"+id;
                
                tweet tw = new tweet(user,text,link);
                ListofTweets.add(tw);
           }
            for (tweet ListofTweet : ListofTweets) {
                System.out.println("@" + ListofTweet.getUserName() + " : " + ListofTweet.getText() + "(" + ListofTweet.getLink() + ")");
            }
       } catch (TwitterException te) {
           te.printStackTrace();
       }
       
       return ListofTweets;
    }
}
