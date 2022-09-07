/*
Group Members: FXL,LCH,TJY
Create date: 16-7-22
Password: suc
 */
package cinemaapp;

public class Movie {
    
    private String movieName;   
    private String actors;      
    private String director;    
    private String description; 
    private int durationInMins; 
    private double rating = 5;      
    private int rateCounter = 1;    
    private int adultPrice = 20;
    private int childPrice = 9; 
    private boolean adultOnly = false;

    //no-arg constructor
    public Movie(){
        this(0);
    }
    
    //default library
    public Movie(int i) {
        switch (i) {
            case 1:
                this.movieName = "Thor: Love and Thunder";
                this.actors = "Chris Hemsworth, Tessa Thompson, Natalie Portman and Christian Bale";
                this.director = "Taika Waititi";
                this.description = "Thor enlists the help of Valkyrie, Korg and ex-girlfriend Jane Foster to fight Gorr the God Butcher, who intends to make the gods extinct.";
                this.durationInMins = 119;
                this.adultPrice = 18;
                break;
            case 2:
                this.movieName = "Jurassic World: Dominion";
                this.actors = "Chris Pratt, Bryce Dallas Howard, Laura Dern";
                this.director = "Colin Trevorrow";
                this.description = "Four years after the destruction of Isla Nublar, dinosaurs now live--and hunt--alongside humans all over the world. This fragile balance will reshape the future and determine, once and for all, whether human beings are to remain the apex predators on a planet they now share with history's most fearsome creatures in a new Era.";
                this.durationInMins = 147;
                break;
            case 3:
                this.movieName = "Incantation (II)";
                this.actors = "	Hsuan-yen Tsai";
                this.director = "Kevin Ko";
                this.description = "Six years ago, Li Ronan was cursed after breaking a religious taboo. Now, she must protect her daughter from the consequences of her actions.";
                this.durationInMins = 110;
                this.adultPrice = 23;
                this.adultOnly = true;
                break;
            case 0:
                this.movieName = "Movie: Lorem";
                this.actors = "Lorem, Ipsum, Dolor";
                this.director = "Lorem Dolor";
                this.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut malesuada nisl eget convallis volutpat.";
                this.durationInMins = 1;
                break;
        }
    }

    //Constructor with argument
    public Movie(String movieName, String actors, String director, String description, int duration, boolean adultOnly) {
        this.movieName = movieName;
        this.actors = actors;
        this.director = director;
        this.description = description;
        this.durationInMins = duration;
        this.adultOnly = adultOnly;
    }
    
    
    public Movie(String movieName, String actors, String director, String description, int duration, boolean adultOnly, int adultPrice, int childPrice) {
        this.movieName = movieName;
        this.actors = actors;
        this.director = director;
        this.description = description;
        this.durationInMins = duration;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.adultOnly = adultOnly;
    }
    

    //Getter (accessor)
    public String getMovieName()    {return movieName;}
    public String getActors()       {return actors;}
    public String getDirector()     {return director;}
    public String getDescription()  {return description;}
    public int getDurationInMins()  {return durationInMins;}
    public double getRating()       {return rating;}
    public int getRateCounter()     {return rateCounter;}
    public int getAdultPrice()      {return adultPrice;}
    public int getChildPrice()      {return childPrice;}
    public boolean getAdultOnly()      {return adultOnly;}
    
    //Setter (mutator)
    public void setMovieName(String movieName)          {this.movieName = movieName;}
    public void setActors(String actors)                {this.actors = actors;}
    public void setDirector(String director)            {this.director = director;}
    public void setDescription(String description)      {this.description = description;}
    public void setDurationInMins(int durationInMins)   {this.durationInMins = durationInMins;}
    public void setRating(double rating)                {this.rating = rating;}
    public void setRateCounter(int rateCounter)         {this.rateCounter = rateCounter;}
    public void setAdultPrice(int adultPrice)           {this.adultPrice = adultPrice;}
    public void setChildPrice(int childPrice)           {this.childPrice = childPrice;}
    public void setAdultOnly(boolean adultOnly)           {this.adultOnly = adultOnly;}
    
    
    /*---User Defined Method---*/
    public String printMovieInfo(){
        String string;
        if(adultOnly==true){
            string = "\n================= Movie Info =================" + 
            "\nTitle : " + getMovieName() +
            "\nActors : " + getActors() + 
            "\nDirector : " + getDirector() + 
            "\nDescription : " + getDescription() + 
            "\nDuration : " + ((int)getDurationInMins()/60) + " hours " + (getDurationInMins()%60)+ " mins" +   
            "\nRating : " + getRating() + 
            "\nPrice : RM " + getAdultPrice()+ ".00(Adult only)" + """

            ==============================================""";
        }else{
        string = "\n================= Movie Info =================" + 
                "\nTitle : " + getMovieName() +
                "\nActors : " + getActors() + 
                "\nDirector : " + getDirector() + 
                "\nDescription : " + getDescription() + 
                "\nDuration : " + ((int)getDurationInMins()/60) + " hours " + (getDurationInMins()%60)+ " mins" +   
                "\nRating : " + getRating() + 
                "\nPrice : RM " + getAdultPrice()+ ".00(Adult), RM " + getChildPrice() + ".00(Child)" + """
                                                                                                       
                ==============================================""";
        }
        return string;
    }
    
    
    public String movieInfoEdit(){
        return "\n================= Movie Info =================" + 
                "\n1. Title : " + getMovieName() +
                "\n2. Actors : " + getActors() + 
                "\n3. Director : " + getDirector() + 
                "\n4. Description : " + getDescription() + 
                "\n5. Duration : " + ((int)getDurationInMins()/60) + " hours " + (getDurationInMins()%60)+ " mins" +
                "\n6. AdultPrice : RM " + getAdultPrice()+ ".00" +
                "\n7. ChildPrice : RM " + getChildPrice() + ".00" + """
                                                                                                       
                ==============================================""";
    }
    
    //admin
    
    
    
    //user
    public int calculatePrice(int adult, int child){
        int price = adultPrice * adult + childPrice * child; //Adult Price = 20, Child Price = 9
        return price;
    }
    
    //Rate Movie 
    public double rateMovie(double newRate){
        double rate = ((this.rating * rateCounter) + newRate); //4 x 5 = 20 + 4 = 24
        rateCounter++;   //6
        rating = rate/rateCounter; // 24/ 6 = 4
        
        return rating;
    }
    
   
    public String printReceipt(int adult, int child){
        return """
               ******************
                     Receipt     
               Title: """+ getMovieName() +
                "\nAdult : " +  calculatePrice(adult, child) + 
                "\nChild : " + child +
                "\nTotal paid: RM" + calculatePrice(adult, child) + ".00" + 
                "\n******************";
    }
    
    
    public boolean isCartoon(){
        return false;
    }
}
