package testModel;

import model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;


    private void setupScenary1(){
        person = new Person("23-435646432", "Camilo", "Sanchez", "camichez2@mail.com", "Male", "Chile", "https://robohash.org/quiarepellatquas.bmp?size=170x170&set=set1", "07/04/1993");
    }


    @Test
    void testPerson(){

        setupScenary1();

        assertNotNull(person,"La persona no existe.");

        String id = "23-435646432";
        String fn =  "Camilo";
        String ln = "Sanchez";
        String e = "camichez2@mail.com";
        String g = "Male";
        String c = "Chile";
        String pP = "https://robohash.org/quiarepellatquas.bmp?size=170x170&set=set1";
        String b = "07/04/1993";

        assertEquals(id,person.getId(), "El id es diferente");

        assertEquals(fn,person.getFirstName(), "El nombre es diferente");

        assertEquals(ln,person.getLastName(), "El apellido es diferente");

        assertEquals(e,person.getEmail(), "El correo es diferente");

        assertEquals(g,person.getGender(), "El género es diferente");

        assertEquals(c,person.getCountry(), "El país es diferente");

        assertEquals(pP,person.getPathPhoto(), "La ruta de la foto es diferente");

        assertEquals(b,person.getBirthday(), "La fecha de cumpleaños es diferente");


    }

}