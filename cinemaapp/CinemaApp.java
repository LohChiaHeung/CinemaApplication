/*
Group Members: FXL,LCH,TJY
Create date: 16-7-22

to access ADMIN key in "admin" at start, pw = "suc"
 */
package cinemaapp;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CinemaApp {
    public static void main(String[] args) {
        //-----data field
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        Scanner input = new Scanner(System.in);
        String role="0";
        String pw="example";
        int option;
        int movieType;
        String name;
        String actor="";
        String voiceCast="";
        String director;
        String descr;
        int duration;
        boolean adultOnly;
        int adultPrice;
        int childPrice;
        double rate;
        boolean yn=true;
        //-----data field-----
        
        //-----Sample data-----
        Movie m1 = new Movie(1);
        Movie m2 = new Movie(2);
        Movie m3 = new Movie(3);
        Movie m4 = new Movie();
        CartoonMovie m5 = new CartoonMovie(1);
        CartoonMovie m6 = new CartoonMovie(2);
        CartoonMovie m7 = new CartoonMovie();
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);
        movieList.add(m5);
        movieList.add(m6);
        movieList.add(m7);
        //-----Sample data-----
        
        
        /*==========================*/
        /*=========Main Code========*/
        /*==========================*/
        try{
            /*-----MENU-----*/
            //check role
            while((!role.equals("ADMIN")) && role!=""){
                System.out.println("Maxi Cinema App");
                System.out.println("(Press Enter to start)          |key in 'admin' for admin function");
                role = input.nextLine().toUpperCase();
            }
            /***************************************************************** ADMIN *****************************************************************/
            main:
            if(role.equals("ADMIN")){
                while(!pw.equals("suc")){
                    System.out.print("[ADMIN] Please enter password (0: Exit) \n->");
                    pw = input.next();
                    if(pw.equals("0")){
                        break main;
                    }
                }
                    System.out.println("Welcome back to admin panel!");
                    //admin option
                    while(true){
                        System.out.println("-----Admin Panel-----\n  1. Movie List\n  2. Add movie\n  3. Edit movie\n  0: Exit");
                        System.out.print("->");
                        option = input.next().charAt(0);
                        menu:
                            if(option == '0'){
                                break main;
                            }
                            else if(option =='1'){
                                /*LIST movie*/
                                System.out.println("\n***** VIEW Movie function *****");
                                System.out.println("--------- Movie List ---------");
                                for(int i=0;i<movieList.size();){
                                    Movie movie = movieList.get(i);
                                    System.out.println("  "+ ++i + ": " + movie.getMovieName());
                                }
                                System.out.println("------------------------------");
                                System.out.println("\nSelect no. of movie to VIEW");
                                System.out.print("->");
                                int movieIndex = input.nextInt();
                                Movie movie = movieList.get(movieIndex-1);
                                System.out.println(movie.printMovieInfo());
                                yn=true; //reset Yes/No
                                while(yn){
                                    System.out.print("Continue for other function? (Y/N) ->");
                                    char continue1=input.next().toUpperCase().charAt(0);
                                    if(continue1=='Y'){
                                        yn=false;
                                        break menu;
                                    }else if(continue1=='N'){
                                        yn=false;
                                        break main;
                                    }
                                }
                            }
                            else if(option =='2'){
                                /*ADD movie*/
                                System.out.println("\n***** ADD Movie function *****");
                                System.out.print("What type of movie? \n1: Normal movie \n2: Cartoon movie \n->");
                                movieType = input.nextInt();
                                input.nextLine(); // consume \n
                                System.out.println("**Fill in all information");
                                System.out.print("Movie Name: ");
                                name = input.nextLine();
                                if(movieType == 1){
                                    System.out.print("Actors (connects with ','): ");
                                    actor = input.nextLine();
                                }else if(movieType==2){
                                    System.out.print("Voice Cast (connects with ','): ");
                                    voiceCast = input.nextLine();
                                }
                                System.out.print("Director(s): ");
                                director = input.nextLine();
                                System.out.print("Description: ");
                                descr = input.nextLine();
                                System.out.print("Duration (in minutes): ");
                                duration = input.nextInt();
                                System.out.print("Adult only? (Y/N): ");
                                if(input.next().toUpperCase().charAt(0) == 'Y'){
                                    adultOnly = true;
                                }else{
                                    adultOnly = false;
                                }
                                System.out.print("Adult price(whole number) : RM");
                                adultPrice = input.nextInt();
                                if(adultOnly==true){
                                    childPrice = 0;
                                }else {
                                    System.out.print("Child price(whole number) : RM");
                                    childPrice = input.nextInt();
                                }
                                if(movieType == 1){
                                    Movie m = new Movie(name, actor, director, descr, duration, adultOnly, adultPrice, childPrice);
                                    movieList.add(m);
                                }else{
                                    Movie m = new CartoonMovie(name, voiceCast, director, descr, duration, adultOnly, adultPrice, childPrice);
                                    movieList.add(m);
                                }
                                System.out.println("Movie added!");
                                yn=true; //reset Yes/No
                                while(yn){
                                    System.out.print("Continue for other function? (Y/N) ->");
                                    char continueOrNot=input.next().toUpperCase().charAt(0);
                                    if(continueOrNot=='Y'){
                                        yn=false;
                                        break menu;
                                    }else if(continueOrNot=='N'){
                                        yn=false;
                                        break main;
                                    }
                                }
                            }else if(option == '3'){
                                /*EDIT movie*/
                                System.out.println("\n***** Edit Movie function *****");
                                //List movie
                                System.out.println("--------- Movie List ---------");
                                for(int i=0;i<movieList.size();){
                                    Movie movie = movieList.get(i);
                                    System.out.println("  "+ ++i + ": " + movie.getMovieName());
                                }
                                System.out.println("------------------------------");
                                System.out.println("\nSelect no. of movie that you want to EDIT");
                                System.out.print("->");
                                int movieIndex = input.nextInt();
                                Movie movie = movieList.get(movieIndex-1);
                                System.out.println(movie.movieInfoEdit());
                                System.out.println("Which aspect you want to EDIT? (1-7)");
                                System.out.print("->");
                                int edit = input.nextInt();
                                switch(edit){
                                    case 1:
                                        System.out.print("New Title : ");
                                        input.nextLine(); //consume \n
                                        movie.setMovieName(input.nextLine());
                                        break;
                                    case 2:
                                        if(movie.isCartoon()){
                                            System.out.print("New Voice Cast (connects with ','): ");
                                            input.nextLine(); //consume \n
                                            ((CartoonMovie)movie).setVoiceCast(input.nextLine());
                                        }else{
                                            System.out.print("New Actors (connects with ','): ");
                                            input.nextLine(); //consume \n
                                            ((Movie)movie).setActors(input.nextLine());
                                        }
                                        break;
                                    case 3:
                                        System.out.print("New Director(s) (connects with ','): ");
                                        input.nextLine(); //consume \n
                                        movie.setDirector(input.nextLine());
                                        break;
                                    case 4:
                                        System.out.print("New Description : ");
                                        input.nextLine(); //consume \n
                                        movie.setDescription(input.nextLine());
                                        break;
                                    case 5:
                                        System.out.print("New Duration (in minutes): ");
                                        movie.setDurationInMins(input.nextInt());
                                        break;
                                    case 6:
                                        System.out.print("New Adult Price (whole number): RM");
                                        movie.setAdultPrice(input.nextInt());
                                        break;
                                    case 7:
                                        System.out.print("New Child Price (whole number): RM");
                                        movie.setChildPrice(input.nextInt());
                                        break;
                                    default: break;
                                }
                                if(movie.isCartoon()){
                                    System.out.println(((CartoonMovie)movie).printMovieInfo());
                                }else{
                                    System.out.println(movie.printMovieInfo());
                                }
                                yn=true; //reset Yes/No
                                while(yn){
                                    System.out.print("Continue for other function? (Y/N) ->");
                                    char continueOrNot=input.next().toUpperCase().charAt(0);
                                    if(continueOrNot=='Y'){
                                        yn=false;
                                        break menu;
                                    }else if(continueOrNot=='N'){
                                        yn=false;
                                        break main;
                                    }
                                }
                            }
                    }
                }   
            /***************************************************************** USER *****************************************************************/
            else if (role==""){
                System.out.println("Welcome to our application!");
                while(true){
                    System.out.println("\n-----User Panel-----\n  1. Movie available \n  2. Rate a movie\n  0: Exit");
                    System.out.print("->");
                    option = input.next().charAt(0);
                    userMenu:
                    if(option == '0'){
                        break main;
                    }
                    else if (option =='1'){
                        /*VIEW Movie Available*/
                        System.out.println("\n******** Movie (Now Showing) ********");
                        System.out.println("--------- Movie List ---------");
                        for(int i=0;i<movieList.size();){
                            Movie movie = movieList.get(i);
                            System.out.println("  "+ ++i + ": " + movie.getMovieName());
                        }
                        System.out.println("------------------------------");
                        System.out.println("\nSelect no. of movie that you're interested");
                        System.out.print("->");
                        int movieIndex = input.nextInt();
                        Movie movie = movieList.get(movieIndex-1);
                        System.out.println(movie.printMovieInfo());
                        yn=true;
                        while(yn){
                            System.out.print("Buy a ticket? Y/N ->");
                            char buy = Character.toUpperCase(input.next().charAt(0));
                            if(buy=='Y'){
                                yn=false;
                                System.out.print("Number of adult: ");
                                int adult = input.nextInt();
                                int child = 0;
                                if(!movie.getAdultOnly()){
                                    System.out.print("Number of child (0 for none): ");
                                    child = input.nextInt();
                                }else{
                                    //System.out.println("This movie not available for kids");
                                }
                                System.out.println("Total price: RM " + movie.calculatePrice(adult,child) + ".00");
                                yn=true;
                                while(yn){
                                    System.out.print("Confirm payment? Y/N ->");
                                    char pay = Character.toUpperCase(input.next().charAt(0));
                                    if (pay=='Y'){
                                        try{
                                            yn=false;
                                            System.out.print("|");
                                            for(int i=0;i<10;i++){
                                                System.out.append("=");
                                                Thread.sleep(300);
                                            }
                                            System.out.println("|");
                                            Thread.sleep(300);
                                            System.out.println("Payment completed!\n");
                                            Thread.sleep(1000);
                                            //receipt
                                            System.out.println(movie.printReceipt(adult,child));
                                        }catch(Exception io){}
                                    }else if(pay=='N'){
                                        yn=false;
                                        break userMenu;
                                    }
                                }
                            }else if(buy=='N'){
                                yn=false;
                                break userMenu;
                            }
                        }

                            yn=true; //reset Yes/No
                            while(yn){
                                System.out.print("Continue for other function? (Y/N) ->");
                                char continueOrNot=input.next().toUpperCase().charAt(0);
                                if(continueOrNot=='Y'){
                                    yn=false;
                                    break userMenu;
                                }else if(continueOrNot=='N'){
                                    yn=false;
                                    break main;
                                }
                            }
                    }else if(option=='2'){
                        /*RATE movie*/
                        System.out.println("\n******** Rate a Movie ********");
                        System.out.println("--------- Movie List ---------");
                        for(int i=0;i<movieList.size();){
                            Movie movie = movieList.get(i);
                            System.out.println("  "+ ++i + ": " + movie.getMovieName());
                        }
                        System.out.println("------------------------------");
                        System.out.println("\nSelect no. of movie that you want to rate");
                        System.out.print("->");
                        int movieIndex = input.nextInt();
                        Movie movie = movieList.get(movieIndex-1);
                        System.out.println(movie.printMovieInfo());
                        System.out.print("Please rate this movie (1.0~5.0)\n->");

                        rate = input.nextDouble();
                        movie.rateMovie(rate);
                        System.out.println("\nYou've rated " + rate + "/5.0 to " + movie.getMovieName());
                        System.out.println("New Rate of "+ movie.getMovieName() + " is " + movie.getRating() + "/5.0 ");
                        yn=true; //reset Yes/No
                        while(yn){
                            System.out.print("Continue for other function? (Y/N) ->");
                            char continueOrNot=input.next().toUpperCase().charAt(0);
                            if(continueOrNot=='Y'){
                                yn=false;
                                break userMenu;
                            }else if(continueOrNot=='N'){
                                yn=false;
                                break main;
                            }
                        }
                    }
                }
            }
            System.out.println("App Closed.");
        }catch(InputMismatchException ime){
            System.out.println("Error: "+ ime);
            System.out.println("Input is not in correct type!");
        }
        catch(IndexOutOfBoundsException ioobe){
            System.out.println("Error: Index out of bounds.");
            System.out.println("Inputing invalid number!");
        }
        
    }
}
