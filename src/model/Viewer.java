package model;

import java.util.Date;

public class Viewer extends Person implements Comparable<Viewer>{

    private Viewer leftViewer;
    private Viewer righttViewer;


    public Viewer(String id, String firstName, String lastName, String email, String gender, String country, String photo, Date birthday) {
        super(id, firstName, lastName, email, gender, country, photo, birthday);
        leftViewer = null;
        righttViewer = null;
    }




    public Viewer getLeftViewer() {
        return leftViewer;
    }

    public void setLeftViewer(Viewer leftViewer) {
        this.leftViewer = leftViewer;
    }

    public Viewer getRighttViewer() {
        return righttViewer;
    }

    public void setRighttViewer(Viewer righttViewer) {
        this.righttViewer = righttViewer;
    }

    @Override
    public String toString() {
        return "Viewer{" +
                       ", id='" + id + '\'' +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", email='" + email + '\'' +
                       ", gender='" + gender + '\'' +
                       ", country='" + country + '\'' +
                       ", photo='" + photo + '\'' +
                       ", birthday=" + birthday +
                       "leftViewer=" + leftViewer +
                       ", righttViewer=" + righttViewer +
                       '}';
    }

    @Override
    public int compareTo(Viewer viewer) {
        if (id.compareTo(viewer.getId()) > 0) {
            return 1;
        } else if (id.compareTo(viewer.getId()) < 0)
            return -1;
        else
            return 0;
    }
}
