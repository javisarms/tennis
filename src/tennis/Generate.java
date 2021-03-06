/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class generates all humans and their respective attributes.
 * It can generate all players,referees, and spectators needed to run the program
 * using arrays of pre-arranges strings and random numbers.
 * @author Javier Sarmiento and Rafael Racela
 */
public class Generate {
    /**
     * Array of possible male first names and nicknames
     */
    String[] firstMaleName = new String[]{"Adam", "Alex", "Aaron", "Ben", 
        "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", 
        "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", 
        "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", 
        "Thomas", "Tim", "Ty", "Victor", "Walter"};

    /**
     * Array of possible female first names and nicknames
     */
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
    
    /**
     * Array of possible last names
     */
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
    
    /**
     * Array of possible nationalities
     */
    String[] nationality = new String[]{"USA", "Japan", "Philippines", "China",
        "France", "Spain", "Italy", "India", "England", "Brazil"
    };
    
    /**
     * Array of possible places of birth
     */
    String[] birthPlace = new String[]{"Washington", "Tokyo", "Manila", 
        "Beijing", "Paris", "Madrid", "Rome", "New Delhi", "London", "Rio de "
            + "Janeiro"};
    
    /**
     * Array of possible birth years
     */
    String[] birthYear = new String[]{"1980", "1981", "1982", "1983", "1984", 
        "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993"
            , "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", 
            "2002"
    };
    
    /**
     * Array of possible birth days
     */
    String[] birthDay = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", 
        "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", 
        "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
    };
    
    /**
     * Array of possible birth months
     */
    String[] birthMonth = new String[]{"January", "February", "March", "April",
        "May", "June", "July", "August", "September", "October", "November", 
        "December"
    };
    
    /**
     * Array of possible player sponsors
     */
    String[] sponsors = new String[] {"Nike", "Adidas", "Puma", "Rolex", 
        "Uniqlo", "New Balance"};
    
    /**
     * Array of possible spectator item colors
     */
    String[] colors = new String[] {"Red", "Blue", "Green", "Orange", "Violet",
    "Yellow", "Indigo"};
    
    /**
     * The ranking of a male player
     */
    int maleRank = 1;
    /**
     * The ranking of a female player
     */
    int femaleRank = 1;
    
    /**
     * This method generates a random String from the array
     * <code>firstMaleName</code> to be used as a human male's first name.
     * It is also used for generating a random male nickname.
     * @return String of a random male first name.
     */
    private String generateMaleFirstName() {
        int r = ThreadLocalRandom.current().nextInt(0, firstMaleName.length);
        String result = firstMaleName[r];
        return result;
    }
    /**
     * This method generates a random String from the array
     * <code>firstFemaleName</code> to be used as a human female's first name.
     * It is also used for generating a random female nickname.
     * @return String of a random female first name.
     */
    private String generateFemaleFirstName() {
        int r = ThreadLocalRandom.current().nextInt(0, firstFemaleName.length);
        String result = firstFemaleName[r];
        return result;
    }
    
    /**
     * This method generates a random String from the array
     * <code>lastName</code> to be used as a human's lastname.
     * @return String of a random lastname.
     */
    private String generateLastName() {
        int r = ThreadLocalRandom.current().nextInt(0, lastName.length);
        String result = lastName[r];
        return result;
    }
    
    /**
     * This method generates a random String from the array
     * <code>nationality</code> to be used as a human's nationality.
     * @return String of a random nationality (country).
     */
    private String generateNationality() {
        int r = ThreadLocalRandom.current().nextInt(0, nationality.length);
        String result = nationality[r];
        return result;
    }
    
    /**
     * This method generates a random String from the array
     * <code>birthPlace</code> to be used as a human's birthplace.
     * @return String of a random birthplace (city).
     */
    private String generateBirthPlace() {
        int r = ThreadLocalRandom.current().nextInt(0, birthPlace.length);
        String result = birthPlace[r];
        return result;
    }
    
    /**
     * This method generates a String from the following arrays:
     * <code>birthYear</code>, <code>birthMonth</code>, and
     * <code>birthDay</code>, to be used as a human's birthday.
     * It follows the "dd/mm/yyy" format.
     * @return String of a random date.
     */
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
    
    /**
     * This method generates a random number from the range (45,80)
     * to be used as a female human's weight.
     * @return double of a random female weight from 45 to 80.
     */
    private double generateFemaleWeight() {
        double r = ThreadLocalRandom.current().nextInt(45, 81);
        return r;
    }
    
    /**
     * This method generates a random number from the range (55,101)
     * to be used as a male human's weight.
     * @return double of a random male weight from 55 to 101.
     */
    private double generateMaleWeight() {
        double r = ThreadLocalRandom.current().nextInt(55, 101);
        return r;
    }
    
    /**
     * This method generates a random number from the range (160,204)
     * to be used as a human's height.
     * @return double of a random height from 160 to 204.
     */
    private double generateHeight() {
        double r = ThreadLocalRandom.current().nextInt(160, 204);
        return r;
    }
    
    /**
     * This method generates a random String from the
     * <code>sponsors</code> array to be used as a human's sponsor.
     * @return String of a random sponsor.
     */
    private String generateSponsor() {
        int r = ThreadLocalRandom.current().nextInt(0, sponsors.length);
        String result = sponsors[r];
        return result;
    }

    /**
     * This method generates a random dominant hand to be used by a human.
     * @return String of a random dominant hand.
     */
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
    
    /**
     * This method generates a random String from the <code>colors</code>
     * array to be used for the color of a human's item.
     * @return String of a random color.
     */
    private String generateColor() {
        int r = ThreadLocalRandom.current().nextInt(0, sponsors.length);
        String result = colors[r];
        return result;
    }
    
    /**
     * This method generates a female player with random attributes.
     * @return Player of the female gender.
     */
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
    
    /**
     * This method generates a male player with random attributes.
     * @return Player of the male gender.
     */
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
    
    /**
     * This method generates a referee with random attributes.
     * @return Referee.
     */
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
    
    /**
     * This method generates a spectator with random attributes.
     * @return Spectator.
     */
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
