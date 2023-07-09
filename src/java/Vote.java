public class Vote {
    private String voter_id;
    private int vote_id;
    private int nominee_id;

    public Vote(String voter_id, int vote_id, int nominee_id) {
        this.voter_id = voter_id;
        this.vote_id = vote_id;
        this.nominee_id = nominee_id;
    }
    
    public Vote(String voter_id, int nominee_id) {
        this.voter_id = voter_id;
        this.nominee_id = nominee_id;
    }

    public int getVote_id() {
        return vote_id;
    }

    public String getVoter_id() {
        return voter_id;
    }

    public int getNominee_id() {
        return nominee_id;
    }
}
