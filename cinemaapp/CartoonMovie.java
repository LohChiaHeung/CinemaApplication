/*
Group Members: FXL,LCH,TJY
Create date: 21-7-22
Password: suc
 */
package cinemaapp;
public class CartoonMovie extends Movie{
    private String voiceCast;
    
    
    //Default constructor
    public CartoonMovie(){
        this(0);
    }
    
    public CartoonMovie(int i){
        switch(i){
            case 1:
                super.setMovieName("Minions: The Rise of Gru");
                this.setVoiceCast("Steve Carell(voice), Pierre Coffin(voice), Alan Arkin(voice)");
                super.setDirector("Kyle Balda, Brad Ableson, Jonathan del Val");
                super.setDescription("The untold story of one twelve-year-old's dream to become the world's greatest supervillain.");
                super.setDurationInMins(87);
                super.setAdultPrice(22);
                break;
            case 2:
                super.setMovieName("DC League of Super-Pets");
                this.setVoiceCast("Dwayne Johnson(Krypto), Kevin Hart(Ace), Natasha Lyonne(Merton)");
                super.setDirector("Jared Stern, Sam Levine");
                super.setDescription("Krypto the Super-Dog and Superman are inseparable best friends, sharing the same superpowers and fighting crime side by side in Metropolis. However, Krypto must master his own powers for a rescue mission when Superman is kidnapped.");
                super.setDurationInMins(106);
                super.setAdultPrice(19);
                break;
            case 0: 
                super.setMovieName("Cartoon: Lorem");
                super.setActors("");
                this.setVoiceCast("Lorem, Ipsum, Dolor1");
                super.setDirector("Lorem Dolor");
                super.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut malesuada nisl eget convallis volutpat.");
                super.setDurationInMins(1);
                break;
        }
    }
    //Constructor with arguments
    public CartoonMovie(String movieName, String voiceCast, String director, String description, int duration, boolean adultOnly, int adultPrice, int childPrice){
        super(movieName, "", director, description, duration, adultOnly, adultPrice, childPrice);
        this.voiceCast = voiceCast;
    }
    
    public String getVoiceCast()    {return voiceCast;}
    
    public void setVoiceCast(String voiceCast) {this.voiceCast = voiceCast;}
    
    /*---User Defined Method---*/
    @Override
    public String printMovieInfo(){
        return "\n================= Movie Info =================" + 
                "\nTitle : " + super.getMovieName() +
                "\nVoice Cast : " + getVoiceCast() + 
                "\nDirector : " + getDirector() + 
                "\nDescription : " + getDescription() + 
                "\nDuration : " + ((int)getDurationInMins()/60) + " hours " + (getDurationInMins()%60)+ " mins" +   
                "\nRating : " + getRating() + 
                "\nPrice : RM " + getAdultPrice()+ ".00(Adult), RM " + getChildPrice() + ".00(Child)" + """
                                                                                                                                                                                                              
                ==============================================""";
    }
    
    @Override
    public String movieInfoEdit(){
        return "\n================= Movie Info =================" + 
                "\n1. Title : " + getMovieName() +
                "\n2. Voice Cast : " + getVoiceCast() + 
                "\n3. Director : " + getDirector() + 
                "\n4. Description : " + getDescription() + 
                "\n5. Duration : " + ((int)getDurationInMins()/60) + " hours " + (getDurationInMins()%60)+ " mins" +
                "\n6. AdultPrice : RM " + getAdultPrice()+ ".00" +
                "\n7. ChildPrice : RM " + getChildPrice() + ".00" + """
                                                                                                       
                ==============================================""";
    }
    
    public boolean isCartoon(){
        return true;
    }
}
