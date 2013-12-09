/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Generators;

import domain.Knooppunt;
import domain.Route;
import domain.Speelveld;
import static java.lang.Math.random;

/**
 *
 * @author johan
 */
public class SpeelveldGenerator extends Speelveld {

    private int rij = 0;
    private int kol = 0;

    public SpeelveldGenerator(VeldType[][] speelveld, int rij, int kol , double aandeelLeeg) {
        super(speelveld);
        setRij(rij);
        setKol(kol);
        genSpeelveld(aandeelLeeg);

    }
/**
 * 
 * @param Geef het aantal rijen mee aan de generator
 * @throws IllegalArgumentException 
 */
    private void setRij(int rij) throws IllegalArgumentException {
        if (rij <= 0) {
            throw new IllegalArgumentException("Rij mag niet onder 0 gaan");
        }
        this.rij = rij;

    }
/**
 * 
 * @param Geef het aantal kolommen mee aan de generator
 * @throws IllegalArgumentException 
 */
    private void setKol(int kol) throws IllegalArgumentException {
        if (rij <= 0) {
            throw new IllegalArgumentException("Kolom mag niet onder 0 gaan");
        }
        this.kol = kol;
    }
/**
 * 
 * @param Geef het aandeel lege muren mee aan de generator
 * @return Geeft een speelveld van veldtypes terug die op willekeurige plaatsen lege velden als muren bevat
 * @throws IllegalArgumentException 
 */
    private VeldType[][] genSpeelveld(double aandeelLeeg) throws IllegalArgumentException {
        if(aandeelLeeg < 0 || aandeelLeeg > 1) throw new IllegalArgumentException("Getal moet tussen 0 en 1 liggen");

        int max = 2;
        int min = 1;
        int range = (max - min) + 1;
        int type = 0;

        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld[i].length; j++) {
                
                
               // type = (int) (Math.random() * range) + min;

                if (Math.random() < aandeelLeeg ) {
                    speelveld[i][j] = VeldType.LEEG;
                } else {
                    speelveld[i][j] = VeldType.MUUR;
                }

            }

        }
        return speelveld;

    }

  
}
