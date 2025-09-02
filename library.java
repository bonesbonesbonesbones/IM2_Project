import java.util.Scanner;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class library {

    

    private static HashMap<String, Integer> books = new HashMap<String,Integer>();
    private static int val = 3;
    public static void main(String [] args){
        books.put("Book 1", val);
        books.put("Book 2", val);
        books.put("Book 3", val);
       
        Scanner sc = new Scanner(System.in); 
        Scanner sc1 = new Scanner(System.in);
        while(true){ 
        System.out.println();     
        System.out.print("Student[s] Or Librarian[l]: ");
        String choice = sc.nextLine();
        if(choice.equals("s")){
            System.out.print("Borrow[b] Return[r] Exit[e]: ");
            String in = sc.nextLine().toLowerCase();
            if(in.equals("b")){
                availableBooks();
                System.out.print("Enter Book: ");
                String bbook = sc.nextLine();
               if(books.containsKey(bbook)&&books.get(bbook) > 0){ 
                System.out.print("Confirm borrow? y/n: ");
                String ans = sc.nextLine();
                 if(ans.equals("y")){ 
                borrowbook(bbook);
                LocalDate bdate = LocalDate.now();
                LocalDate ddate = bdate.plusDays(7);
                System.out.println("Borrowed succesfully at: " + bdate+ "\n" + "Please return at: " + ddate);

                 }
               }
                    
                }
                if(in.equals("r")){
                    borrowedBooks();
                    System.out.print("Return: ");
                    String rbook = sc.nextLine();
                    if(books.containsKey(rbook)&&books.get(rbook) > 0){
                      System.out.println("Enter today's date (yyyy-mm-dd): ");
                       String day = sc.nextLine(); 
                       LocalDate rdate = LocalDate.parse(day);
                        LocalDate sdate = LocalDate.now();
                        LocalDate edate = sdate.plusDays(7);
                        long result = returnDate(rdate,edate);
                        
                        
                        if(result==0){
                            System.out.println("Returned Succesfully"); 
                            returnbook(rbook);
                        }
                        if(result != 0){
                            System.out.println("Over due: " +result*-1+ " day/s"+ " Please pay " +(result * 100)*-1);
                            returnbook(rbook);
                        }
                        else{
                            System.out.println("Please enter a valid date");
                        }
                        

                    }

                }
                if(in.equals("e")){
                    System.out.print("Program Closed");
                    return;
                }
                
        }
        if(choice.equals("l")){
            System.out.print("Add[a] or Remove[r] book: ");
            String in = sc.nextLine();
            if(in.equals("a")){
                System.out.print("Enter the book: ");
                String abook = sc.nextLine();
                System.out.print("How many copy/s to add?: ");
                int copy = sc.nextInt();
                addBook(abook,copy);
                System.out.println("Updated the list: ");
                availableBooks();
            }
            if (in.equals("r")){
                System.out.print("remove[a] or decrease copy/s?[b]: ");
                String ans = sc.nextLine().toLowerCase();
                if(ans.equals("a")){
                     System.out.println("Enter the book you want to remove: ");
                String rem = sc.nextLine();
                removeBook(rem);
                System.out.println("Updated the list: ");
                availableBooks();
                }
                if(ans.equals("b")){
                    System.out.print("Enter the book: ");
                    String rembook = sc.nextLine();
                    System.out.print("How many copy/s to remove?: ");
                    int copy = sc1.nextInt();
                    decreaseBook(rembook,copy);
                    System.out.println("Updated the list: ");
                    availableBooks();

                }
                  
                    
            }
        }
        
        }
           
            
        }
    public static HashMap<String,Integer> borrowbook(String pbook){
        
       
            books.put(pbook,books.getOrDefault(pbook, val)-1);
             return books;
        }
        public static HashMap<String,Integer> returnbook(String rbook){
            books.put(rbook,books.getOrDefault(rbook, val)+1);
            return books;
        }
        public static long returnDate(LocalDate rdate, LocalDate ddate){
            long result = ChronoUnit.DAYS.between(rdate,ddate);
            return result;
        }
        public static HashMap<String,Integer> addBook(String abook,int add){
            books.put(abook,books.getOrDefault(abook, 0)+ add);
            return books;

        }
        public static HashMap<String,Integer> removeBook(String book){
            books.remove(book, books.getOrDefault(book, 0));
            return books;
        }
        public static HashMap<String,Integer> decreaseBook(String book,int dec){
            books.put(book,books.getOrDefault(book, 0)-dec);
            return books;
        }


       
        
    
    private static void availableBooks(){
        for(String i : books.keySet()){
            if(books.get(i) > 0){
                System.out.println(i +" = " + books.get(i) + " Copy/s" );

            }
        }
    }
    private static void borrowedBooks(){
        for(String i : books.keySet()){
            if(books.get(i) < 3 && books.get(i) >= 0){
                
                System.out.println(i);

            }
        }
    }

}


    

