package testModel;

import model.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewerTest {

    private Viewer viewer;

    private void setupScenary1(){

        viewer = new Viewer("33-6606868","Vina","Wearne","vwearneh@istockphoto.com","Female","Indonesia","https://robohash.org/aspernaturetfugiat.png?size=170x170&set=set1","9/25/2010");


    }

    @Test
    void testViewer() {
        setupScenary1();

        viewer.setLeftViewer(new Viewer("69-7491872","Grange","Caldecourt","gcaldecourt5@cnbc.com","Male","China","https://robohash.org/nequeexsit.png?size=170x170&set=set1","1/11/1971"));
        viewer.setRightViewer(new Viewer("10-1229903","Tamas","Edwicker","tedwickera@umich.edu","Male","Armenia","https://robohash.org/excepturisintsuscipit.bmp?size=170x170&set=set1","10/8/1972"));


        assertNotNull(viewer, "El espectador no existe");

        assertNotNull(viewer.getLeftViewer(), "El espectador izquierdo del especatdor actual no existe.");

        assertNotNull(viewer.getRightViewer(), "El espectador derecho del espectador actual no existe.");

    }

}