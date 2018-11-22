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
    String[] firstMaleName = new String[]{"Adam", "Alex", "Aaron", "Ben", 
        "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", 
        "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", 
        "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", 
        "Thomas", "Tim", "Ty", "Victor", "Walter"};
    
    String[] firstFemaleName = new String[]{"Emily", "Hannah", "Madison", 
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
    
    String[] lastName = new String[]{"Anderson", "Ashwoon", "Aikin", "Bateman",
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
        "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reyes", "Chua",
        "Racela", "Sarmiento", "Morelle", "Zi", "Zhu", "Chu", "Li", "Qi", 
        "Harden", "James", "Curry", "Bro", "Ateneo", "Avelino", "Pua", "Salmon"
        , "Chickowski", "Hwoarang", "Kazama"};
    
    String[] nationality = new String[]{"USA", "Japan", "Philippines", "China",
        "France", "Spain", "Italy", "India", "England", "Brazil"
    };
    
    String[] birthPlace = new String[]{"Washington", "Tokyo", "Manila", 
        "Beijing", "Paris", "Madrid", "Rome", "New Delhi", "London", "Rio de "
            + "Janeiro"};
    
    String[] birthYear = new String[]{"1980", "1981", "1982", "1983", "1984", 
        "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993"
            , "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", 
            "2002"
    };
    
    String[] birthDay = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", 
        "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", 
        "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
    };
    
    String[] birthMonth = new String[]{"January", "February", "March", "April",
        "May", "June", "July", "August", "September", "October", "November", 
        "December"
    };
    
    String[] sponsors = new String[] {"Nike", "Adidas", "Puma", "Rolex", 
        "Uniqlo", "New Balance"};
    
    String[] colors = new String[] {"Red", "Blue", "Green", "Orange", "Violet",
    "Yellow", "Indigo"};
    
    int maleRank = 1;
    int femaleRank = 1;
    
    // Also for Male Nickname
    private String generateMaleFirstName() {
        int r = ThreadLocalRandom.current().nextInt(0, firstMaleName.length);
        String result = firstMaleName[r];
        return result;
    }
    
    // Also for Female Nickname
    private String generateFemaleFirstName() {
        int r = ThreadLocalRandom.current().nextInt(0, firstFemaleName.length);
        String result = firstFemaleName[r];
        return result;
    }
    
    // Also for CurrentName
    private String generateLastName() {
        int r = ThreadLocalRandom.current().nextInt(0, lastName.length);
        String result = lastName[r];
        return result;
    }
    
    private String generateNationality() {
        int r = ThreadLocalRandom.current().nextInt(0, nationality.length);
        String result = nationality[r];
        return result;
    }
    
    private String generateBirthPlace() {
        int r = ThreadLocalRandom.current().nextInt(0, birthPlace.length);
        String result = birthPlace[r];
        return result;
    }
    
    private String generateBirthDate() {
        int r = ThreadLocalRandom.current().nextInt(0, birthYear.length);
        int s = ThreadLocalRandom.current().nextInt(0, birthMonth.length);
        int t = ThreadLocalRandom.current().nextInt(0, birthDay.length);
        String result0 = birthYear[r];
        String result1 = birthMonth[s];
        String result2 = birthDay[t];
        String result = result2 + "/" + result1 + "/" + result0;
        return result;
    }
    
    private double generateFemaleWeight() {
        double r = ThreadLocalRandom.current().nextInt(45, 81);
        return r;
    }
    
    private double generateMaleWeight() {
        double r = ThreadLocalRandom.current().nextInt(55, 101);
        return r;
    }
    
    private double generateHeight() {
        double r = ThreadLocalRandom.current().nextInt(160, 204);
        return r;
    }
    
    private String generateSponsor() {
    	int r = ThreadLocalRandom.current().nextInt(0, sponsors.length);
        String result = sponsors[r];
        return result;
    }

    public String generateHand() {
		String result = "";

		int r = ThreadLocalRandom.current().nextInt(0, 1+1);
		if (r == 0) {
			result = "R";
		}
		else {
			result = "L";
		}
        
        return result;
    }
    
    private String generateColor() {
        int r = ThreadLocalRandom.current().nextInt(0, sponsors.length);
        String result = colors[r];
        return result;
    }
        
    public Player generateFemalePlayer() {
        String bln = generateLastName();
        String g = "F";
        String cn = generateLastName();
        String fn = generateFemaleFirstName();
        String nn = generateFemaleFirstName();
        String bd = generateBirthDate();
        String bp = generateBirthPlace();
        String dd = "";
        String nat = generateNationality();
        double h = generateHeight();
        double w = generateFemaleWeight();
        String han = generateHand();
        String spon = generateSponsor();
        String co = generateMaleFirstName() + " " + generateLastName();
        int ra = femaleRank;
        femaleRank++;
        
        return new Player(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w, han, spon, 
                co, ra);
    }
    
    public Player generateMalePlayer() {
        String bln = generateLastName();
        String g = "M";
        String cn = generateLastName();
        String fn = generateMaleFirstName();
        String nn = generateMaleFirstName();
        String bd = generateBirthDate();
        String bp = generateBirthPlace();
        String dd = "";
        String nat = generateNationality();
        double h = generateHeight();
        double w = generateMaleWeight();
        String han = generateHand();
        String spon = generateSponsor();
        String co = generateMaleFirstName() + " " + generateLastName();
        int ra = maleRank;
        maleRank++;
        
        return new Player(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w, han, spon, 
                co, ra);
        
    }
    
    public Referee generateReferee() {
        String bln = generateLastName();
        String g = "M";
        String cn = generateLastName();
        String fn = generateMaleFirstName();
        String nn = generateMaleFirstName();
        String bd = generateBirthDate();
        String bp = generateBirthPlace();
        String dd = "";
        String nat = generateNationality();
        double h = generateHeight();
        double w = generateMaleWeight();
        
        return new Referee(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w);
    }
    
    public Spectator generateSpectator() {
        String bln = generateLastName();
        String g = "M";
        String cn = generateLastName();
        String fn = generateMaleFirstName();
        String nn = generateMaleFirstName();
        String bd = generateBirthDate();
        String bp = generateBirthPlace();
        String dd = "";
        String nat = generateNationality();
        double h = generateHeight();
        double w = generateMaleWeight();
        String col = generateColor();

        return new Spectator(bln, g, cn, fn, nn, bd, bp, dd, nat, h, w, col);
    }
}
