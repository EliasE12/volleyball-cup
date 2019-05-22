package testModel;

import customExceptions.EmptyIdException;
import customExceptions.NotExistCompetitorException;
import customExceptions.NotExistViewerException;
import model.Competitor;
import model.Cup;
import model.Viewer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    private Cup cup;

    private void setupScenary1(){
        cup = new Cup();
    }

    private void setupScenary2(){
        cup = new Cup();
        cup.setRootViewer(new Viewer("81-1032628","Mignon","Duggen","mduggengd@npr.org","Female","Philippines","https://robohash.org/repellatlaudantiumdolorum.png?size=170x170&set=set1","4/24/1983"));
    }

    private void setupScenary3(){
        cup = new Cup();
        cup.setFirstCompetitor(new Competitor("06-4197009","Lewes","Rudledge","lrudledgeg6@hud.gov","Male","Indonesia","https://robohash.org/inoccaecatiquis.jpg?size=170x170&set=set1","8/20/1984"));
    }



    @Test
    void testLoadInfo() {

        setupScenary1();

        try{
            cup.loadInfo(new File("Little_Data.csv"));
        }catch (IOException e){
        }
    }


    @Test
    void testIsEmptyTree() {
        setupScenary1();

        assertNull(cup.getRootViewer(),"El árbol no está vacía.");
    }

    @Test
    void testAddViewer() {
        setupScenary1();

        String id = "82-1455378";
        String fn = "Ceil";
        String ln = "Densie";
        String e = "cdensieht@umn.edu";
        String g = "Female";
        String c = "China";
        String pP = "https://robohash.org/quiarepellatquas.bmp?size=170x170&set=set1";
        String b = "4/24/1989";

        cup.addViewer(id,fn,ln,e,g,c,pP,b);

        assertNotNull(cup.getRootViewer().getId(), "El spectador no se ha agregado");
    }

    @Test
    void testSearchViewer() {
        setupScenary2();

        try {
            assertNotNull(cup.searchViewer("81-1032628"), "El espectador buscado no existe.");
        } catch (EmptyIdException e) {
            e.printStackTrace();
        } catch (NotExistViewerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAddCompetitor() {
        setupScenary1();

        String id = "99-1451378";
        String fn = "Centel";
        String ln = "Colrnell";
        String e = "cennell@umn.mi";
        String g = "Male";
        String c = "Australia";
        String pP = "https://robohash.org/euidquerree.bmp?size=170x170&set=set1";
        String b = "8/05/1994";

        cup.addCompetitor(id,fn,ln,e,g,c,pP,b);

        assertNotNull(cup.getFirstCompetitor(), "El participante no se ha agregado.");
    }

    @Test
    void testInOrder() {

    }

    @Test
    void testIsEmptyList() {

    }

    @Test
    void testSearchCompetitor() {
        setupScenary3();

        try {
           assertNotNull(cup.searchCompetitor("06-4197009"), "El participante buscado no existe.");
        } catch (EmptyIdException e) {
            e.printStackTrace();
        } catch (NotExistCompetitorException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testSelectCompetitors() {
    }

    @Test
    void testEmptyList() {
    }

    @Test
    void testViewersToPrint() {
    }

    @Test
    void testTreeViewersToPrint() {
    }

    @Test
    void testCompetitorsToPrint() {
    }

    @Test
    void testEmptyTree() {
    }


}