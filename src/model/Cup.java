package model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cup {

    private int numberViewers;
    private int numberCompetitor;

    private Viewer rootViewer;
    private Competitor firstCompetitor;
    private Competitor lastCompetitor;

    private Cup() {
        rootViewer = null;
        firstCompetitor = null;
        lastCompetitor = null;
    }


    public void loadInfo(File file) throws FileNotFoundException, IOException {
        String id, fN, lN, email, gd, country, photo, birthday;
        String linea = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        int contador = 0;
        while ((linea = br.readLine()) != null) {
            String[] rowArray = linea.split(",");
            id = rowArray[0];
            fN = rowArray[1];
            lN = rowArray[2];
            email = rowArray[3];
            gd = rowArray[4];
            country = rowArray[5];
            photo = rowArray[6];
            birthday = rowArray[7];
            addViewer(id, fN, lN, email, gd, country, photo, birthday);
        }
        br.close();
    }


    public Date convertDate(String d) {
        SimpleDateFormat fomatter = new SimpleDateFormat("MM/dd/yyy");
        Date date = null;
        try {
            date = fomatter.parse(d);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return date;
    }


    public boolean isTreeEmpty(){
        if (rootViewer == null)
            return true;
        else
            return false;
    }


    public void addViewer(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
        Viewer newViewer = new Viewer(id, firstName, lastName, email, gender, country, photo, convertDate(birthday));
        if (isTreeEmpty()) {
            rootViewer = newViewer;
        } else {
            Viewer current = rootViewer;
            boolean added = false;
            while (!added) {
                if (newViewer.compareTo(current) > 0) {
                    if (current.getRighttViewer() == null) {
                        current.setRighttViewer(newViewer);
                        added = true;
                    } else {
                        current = current.getRighttViewer();
                    }
                } else {
                    if (current.getLeftViewer() == null) {
                        current.setLeftViewer(newViewer);
                        added = true;
                    } else {
                        current = current.getLeftViewer();
                    }
                }
            }
        }
        numberViewers++;
    }







    public int getNumberViewers() {
        return numberViewers;
    }

    public void setNumberViewers(int numberViewers) {
        this.numberViewers = numberViewers;
    }

    public int getNumberCompetitor() {
        return numberCompetitor;
    }

    public void setNumberCompetitor(int numberCompetitor) {
        this.numberCompetitor = numberCompetitor;
    }

    public Viewer getRootViewer() {
        return rootViewer;
    }

    public void setRootViewer(Viewer rootViewer) {
        this.rootViewer = rootViewer;
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
}
