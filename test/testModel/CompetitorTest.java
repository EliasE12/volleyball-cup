package testModel;

import model.Competitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitorTest {

    private Competitor competitor;

    private void setupScenary1(){
        competitor  = new Competitor("53-5985574","Keefe","Jandourek","kjandourekg@google.co.uk","Male","Brazil","https://robohash.org/suscipitdolorematque.png?size=170x170&set=set1","7/4/1975");

    }
    @Test
    void testCompetitor() {
        setupScenary1();

        competitor.setPreviousCompetitor(new Competitor("79-5836261","Giraud","Nayer","gnayer3@xinhuanet.com","Male","Germany","https://robohash.org/fugiatmaximearchitecto.bmp?size=170x170&set=set1","4/24/2007"));
        competitor.setNextCompetitor(new Competitor("82-6772874","Hope","Puttergill","hputtergill6@fema.gov","Female","China","https://robohash.org/earummodivoluptatum.bmp?size=170x170&set=set1","4/24/1990"));


        assertNotNull(competitor, "El participante no existe");

        assertNotNull(competitor.getPreviousCompetitor(), "El participante anterior del actual no existe.");

        assertNotNull(competitor.getNextCompetitor(), "El perticipante siguiente del actual no existe.");


    }

}