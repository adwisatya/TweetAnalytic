
public class tweet {
    private String UserName;
    private String Text;
    private String Link;
    
    
    public tweet(String user, String text, String link) 
    {
        UserName = user;
        Text = text;
        Link = link;
    }
    
    public String getUserName() {return UserName;}
    public String getText() {return Text;}
    public String getLink() {return Link;}
    
    public void setUserName(String user) {UserName = user;}
    public void setText(String text) {Text = text;}
    public void setLink(String link) {Link = link;}
}
