/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author javiersarmiento
 */
public class Generate {
    String[] _firstMaleName = new String[]{"Adam", "Alex", "Aaron", "Ben", 
        "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", 
        "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", 
        "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", 
        "Thomas", "Tim", "Ty", "Victor", "Walter"};
    
    String[] _firstFemaleName = new String[]{"Emily", "Hannah", "Madison", 
        "Ashley", "Sarah", "Alexis", "Samantha", "Jessica", "Elizabeth", 
        "Taylor", "Lauren", "Alyssa", "Kayla", "Abigail", "Brianna", "Olivia", 
        "Emma", "Megan", "Grace", "Victoria", "Rachel", "Anna", "Sydney", 
        "Destiny", "Morgan", "Jennifer", "Jasmine", "Haley", "Julia", "Kaitlyn",
        "Nicole", "Amanda", "Katherine", "Natalie", "Hailey", "Alexandra", 
        "Savannah", "Chloe", "Rebecca", "Stephanie", "Maria", "Sophia", 
        "Mackenzie", "Allison", "Isabella", "Amber", "Mary", "Danielle", 
        "Gabrielle", "Jordan", "Brooke", "Michelle", "Sierra", "Katelyn", 
        "Andrea", "Madeline", "Sara", "Kimberly", "Courtney", "Erin", 
        "Brittany", "Vanessa", "Jenna", "Jacqueline", "Caroline", "Faith", 
        "Makayla", "Bailey", "Paige", "Shelby", "Melissa", "Kaylee"};
    
    String[] _lastName = new String[]{"Anderson", "Ashwoon", "Aikin", "Bateman",
        "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", 
        "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", 
        "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", 
        "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", 
        "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", 
        "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", 
        "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", 
        "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", 
        "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", 
        "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", 
        "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", 
        "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", 
        "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", 
        "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", 
        "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", 
        "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", 
        "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", 
        "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", 
        "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", 
        "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reyes"};
    
    public void GenerateMaleFirstName() {
        int r = ThreadLocalRandom.current().nextInt(0, _firstMaleName.length);
        String result = _firstMaleName[r];
        System.out.println(result);
    }
    
    public void GenerateFemaleFirstName() {
        int r = ThreadLocalRandom.current().nextInt(0, _firstFemaleName.length);
        String result = _firstFemaleName[r];
        System.out.println(result);
    }
    
    public void GenerateLastName() {
        int r = ThreadLocalRandom.current().nextInt(0, _lastName.length);
        String result = _lastName[r];
        System.out.println(result);
    }
}
