package model;

import java.util.Date;

public class Competitor extends Person implements Comparable<Competitor> {

    private Competitor nextCompetitor;
    private Competitor previousCompetitor;

    public Competitor(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
        super(id, firstName, lastName, email, gender, country, photo, birthday);
        nextCompetitor = null;
        previousCompetitor = null;
    }


    public Competitor getNextCompetitor() {
        return nextCompetitor;
    }

    public void setNextCompetitor(Competitor nextCompetitor) {
        this.nextCompetitor = nextCompetitor;
    }

    public Competitor getPreviousCompetitor() {
        return previousCompetitor;
    }

    public void setPreviousCompetitor(Competitor previousCompetitor) {
        this.previousCompetitor = previousCompetitor;
    }


    @Override
    public int compareTo(Competitor competitor) {
        if (id.compareTo(competitor.getId()) > 0) {
            return 1;
        } else if (id.compareTo(competitor.getId()) < 0)
            return -1;
        else
            return 0;
    }

}
