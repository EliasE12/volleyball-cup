package model;

import customExceptions.NotExistViewerException;

import java.util.Date;
import java.util.List;

public class Viewer extends Person implements Comparable<Viewer>{

    private Viewer leftViewer;
    private Viewer rightViewer;

    public Viewer(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
        super(id, firstName, lastName, email, gender, country, photo, birthday);
        leftViewer = null;
        rightViewer = null;
    }


    public void preOrder(List<Viewer> list){
        list.add(this);
        if (leftViewer != null)
            leftViewer.preOrder(list);
        if (rightViewer != null)
            rightViewer.preOrder(list);
    }


    public void inOrder(List<Viewer> list){
        if (leftViewer != null){
            leftViewer.inOrder(list);
        }
        list.add(this);
        if (rightViewer != null){
            rightViewer.inOrder(list);
        }
    }



    public Viewer getLeftViewer() {
        return leftViewer;
    }

    public void setLeftViewer(Viewer leftViewer) {
        this.leftViewer = leftViewer;
    }

    public Viewer getRightViewer() {
        return rightViewer;
    }


    public void setRightViewer(Viewer rightViewer) {
        this.rightViewer = rightViewer;
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
