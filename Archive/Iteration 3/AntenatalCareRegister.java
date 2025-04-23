import java.util.ArrayList;
import java.util.List;

/**
 * The AntenatalCareRegister class manages information about midwives and mothers
 * in an antenatal care system, along with methods to manipulate patient records.
 */
public class AntenatalCareRegister {
    private ArrayList<Midwife> midwifeList;
    private ArrayList<Mother> motherList;

    /**
     * Constructs a new AntenatalCareRegister with empty lists for midwives and mothers.
     */
    public AntenatalCareRegister() {
        this.midwifeList = new ArrayList<>();
        this.motherList = new ArrayList<>();
    }

    public void addMidwife(Midwife midwife) {
        midwifeList.add(midwife);
    }

    public void addMother(Mother mother) {
        motherList.add(mother);
    }

    public List<Midwife> getMidwives() {
        return midwifeList;
    }

    public List<Mother> getMothers() {
        return motherList;
    }
}
