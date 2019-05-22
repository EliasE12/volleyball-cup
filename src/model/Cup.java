package model;

import customExceptions.EmptyCountryException;
import customExceptions.EmptyIdException;
import customExceptions.NotExistCompetitorException;
import customExceptions.NotExistViewerException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Clase
public class Cup {

    // Atributos
    private int numberViewers;
    private int numberCompetitor;
    private long time;

    private Viewer rootViewer;
    private Competitor firstCompetitor;
    private Competitor lastCompetitor;

    // Constructor
    public Cup() {
        rootViewer = null;
        firstCompetitor = null;
    }

    // Métodos

    // Carga los datos de los espectadores.
    public void loadInfo(File file) throws IOException {
        long start = System.currentTimeMillis();
        String id, fN, lN, email, gd, country, photo, birthday;
        String linea;
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
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
            System.out.println(numberViewers);
            selectCompetitors();
        }
        br.close();
        long end = System.currentTimeMillis();
        time = (end-start);
    }

    // Verifica si el árbol de espectadores esta vacío.
    public boolean isEmptyTree() {
        if (rootViewer == null)
            return true;
        else
            return false;
    }

    // Agrega un nuevo espectadores.
    public void addViewer(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
        Viewer newViewer = new Viewer(id, firstName, lastName, email, gender, country, photo, birthday);
        boolean added = false;
        if (rootViewer == null) {
            rootViewer = newViewer;
        } else {
            Viewer root;
            Viewer current = rootViewer;
            while (!added) {
                root = current;
                if (newViewer.getId().compareTo(current.getId()) <= 0) {
                    current = current.getLeftViewer();
                    if (current == null) {
                        root.setLeftViewer(newViewer);
                        added = true;
                    }
                } else {
                    current = current.getRightViewer();
                    if (current == null) {
                        root.setRightViewer(newViewer);
                        added = true;
                    }
                }
            }
        }
        numberViewers++;
    }

    // Busca un espectador con el id ingresado.
    public Viewer searchViewer(String id) throws EmptyIdException, NotExistViewerException {
         time = 0;
         long start = System.currentTimeMillis();
        Viewer current = rootViewer;
        if(id.equals("")) {
            throw new EmptyIdException();
        }if (isEmptyTree()) {
            throw new NotExistViewerException();
        } else {
            while (current.getId().compareTo(id) != 0) {
                if (current.getId().compareTo(id) > 0) {
                    current = current.getLeftViewer();
                } else {
                    current = current.getRightViewer();
                }
            }
        }

        if(current == null){
            throw new NotExistViewerException();
        }
        long end = System.currentTimeMillis();
        time = (end-start);
        return current;
    }

    // Agrega un nuevo participante.
    public void addCompetitor(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
        Competitor newCompetitor = new Competitor(id, firstName, lastName, email, gender, country, photo, birthday);
        if (firstCompetitor == null) {
            firstCompetitor = newCompetitor;
            lastCompetitor = newCompetitor;
        } else {
            lastCompetitor.setNextCompetitor(newCompetitor);
            newCompetitor.setPreviousCompetitor(lastCompetitor);
            lastCompetitor = newCompetitor;
        }
        numberCompetitor++;
    }


    public List<Viewer> inOrder() {
        List<Viewer> list = new ArrayList<>();
        if (rootViewer != null)
            rootViewer.inOrder(list);
        return list;
    }

    public boolean isEmptyList() {
        if (firstCompetitor == null)
            return true;
        else
            return false;
    }

    public Competitor searchCompetitor(String id) throws EmptyIdException, NotExistCompetitorException {
        time = 0;
        long start = System.currentTimeMillis();
        Competitor current = firstCompetitor;
        Competitor searched = null;
        boolean found = false;
        if (id.equals("")) {
            throw new EmptyIdException();
        } else if(isEmptyList()) {
            throw new NotExistCompetitorException();
        }else {
            while(current!=null && !found){
                if(current.getId().compareTo(id) == 0) {
                    searched = current ;
                    found = true;
                }
                current = current.getNextCompetitor();
            }
        }
        if(searched == null){
            throw new NotExistCompetitorException();
        }
        long end = System.currentTimeMillis();
        time = (end-start);
        return searched;
    }

    public void selectCompetitors() {
        Random random = new Random();
        List<Viewer> viewers = inOrder();
        int index;
        while (numberCompetitor <= (numberViewers / 2)) {
            index = random.nextInt(viewers.size());
            Viewer current = viewers.get(index);
            addCompetitor(current.getId(), current.getFirstName(), current.getLastName(),
                    current.getEmail(), current.getGender(), current.getCountry(),
                    current.getPathPhoto(), current.getBirthday());
        }
    }

    public void EmptyList(){
        firstCompetitor = null;
        lastCompetitor = null;
        numberCompetitor = 0;
    }

    public List<Viewer> viewersToPrint(String country)throws EmptyCountryException{
        List<Viewer> viewers= new ArrayList<>();
        if (country.equals("")){
            throw new EmptyCountryException();
        }else {
            for (Viewer current:inOrder()) {
                if (current.getCountry().compareTo(country) == 0){
                    viewers.add(current);
                }
            }
        }
        return viewers;
    }

    public Viewer treeViewersToPrint(List<Viewer> list) {
        Viewer root = null;
        for (Viewer current:list) {
            if(root == null){
                root = current;
            }else{
                root.insert(current);
            }
        }
        return root;
    }

    public List<Competitor> competitorsToPrint(String country) throws EmptyCountryException{
        List<Competitor> competitors = new ArrayList<>();
        if(country.equals("")){
           throw new EmptyCountryException();
        }else{
            Competitor current = firstCompetitor;
            while (current != null){
                if(current.getCountry().compareTo(country)==0) {
                    competitors.add(current);
                }
                current = current.getNextCompetitor();
            }
        }
        return competitors;
    }

    public void EmptyTree(){
        rootViewer = null;
        numberViewers = 0;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Competitor getLastCompetitor() {
        return lastCompetitor;
    }

    public void setLastCompetitor(Competitor lastCompetitor) {
        this.lastCompetitor = lastCompetitor;
    }
}
