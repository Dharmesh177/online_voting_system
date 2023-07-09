public class Nominee {
    private int id;
    private String name;
    private String slogan;
    private int votes;
    
    public Nominee(int id,String name, String slogan) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
    }
    
    public Nominee(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }
    
    public Nominee(int id,String name, int votes) {
        this.id = id;
        this.name = name;
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlogan() {
        return slogan;
    }

    public int getVotes() {
        return votes;
    }
}
