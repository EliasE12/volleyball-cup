package model;

import java.util.Date;

public class Competitor extends Person implements Comparable<Competitor> {

    private Competitor firstCompetitor;
    private Competitor lastCompetitor;


    public Competitor(String id, String firstName, String lastName, String email, String gender, String country, String photo, Date birthday) {
        super(id, firstName, lastName, email, gender, country, photo, birthday);
        firstCompetitor = null;
        lastCompetitor = null;
    }




    public Competitor getFirstCompetitor() {
        return firstCompetitor;
    }

    public void setFirstCompetitor(Competitor firstCompetitor) {
        this.firstCompetitor = firstCompetitor;
    }

    public Competitor getLastCompetitor() {
        return lastCompetitor;
    }

    public void setLastCompetitor(Competitor lastCompetitor) {
        this.lastCompetitor = lastCompetitor;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                       ", id='" + id + '\'' +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", email='" + email + '\'' +
                       ", gender='" + gender + '\'' +
                       ", country='" + country + '\'' +
                       ", photo='" + photo + '\'' +
                       ", birthday=" + birthday +
                       "firstCompetitor=" + firstCompetitor +
                       ", lastCompetitor=" + lastCompetitor +
                       '}';
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
