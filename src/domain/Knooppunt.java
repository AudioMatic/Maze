/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author AudioMatic
 */
public class Knooppunt {
      public int rij;
        public int kol;

        public Knooppunt(int rij, int kol) {
            setRij(rij);
            setKol(kol);
        }

    private void setRij(int rij) {
        this.rij = rij;
    }

    private void setKol(int kol) {
        this.kol = kol;
    }

    public int getRij() {
        return rij;
    }

    public int getKol() {
        return kol;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Knooppunt other = (Knooppunt) obj;
        if (this.rij != other.rij) {
            return false;
        }
        if (this.kol != other.kol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+ this.kol + "|"+this.rij+"]";
    }
    
   // Done so far..
}
