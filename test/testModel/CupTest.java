package testModel;

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
    void isEmptyTree() {
        setupScenary1();


    }

    @Test
    void addViewer() {
    }

    @Test
    void searchViewer() {
        setupScenary2();


    }

    @Test
    void addCompetitor() {
    }

    @Test
    void preOrder() {
    }

    @Test
    void inOrder() {
    }

    @Test
    void isEmptyList() {
    }

    @Test
    void searchCompetitor() {
        setupScenary3();


    }

    @Test
    void selectCompetitors() {
    }

    @Test
    void emptyList() {
    }

    @Test
    void viewersToPrint() {
    }

    @Test
    void treeViewersToPrint() {
    }

    @Test
    void competitorsToPrint() {
    }

    @Test
    void emptyTree() {
    }

    @Test
    void getNumberViewers() {
    }

    @Test
    void setNumberViewers() {
    }

    @Test
    void getNumberCompetitor() {
    }

    @Test
    void setNumberCompetitor() {
    }

    @Test
    void getRootViewer() {
    }

    @Test
    void setRootViewer() {
    }

    @Test
    void getFirstCompetitor() {
    }

    @Test
    void setFirstCompetitor() {
    }

    @Test
    void getTime() {
    }

    @Test
    void setTime() {
    }

    @Test
    void getLastCompetitor() {
    }

    @Test
    void setLastCompetitor() {
    }
}