import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The AntenatalCareRegister class manages information about midwives and mothers
 * in an antenatal care system, along with methods to manipulate patient records.
 */
public class AntenatalCareRegister {
    private ArrayList<Midwife> midwifeList;
    private HashMap<String, Mother> mothers;

    /**
     * Constructs a new AntenatalCareRegister with empty lists for midwives and mothers.
     */
    public AntenatalCareRegister() {
        this.midwifeList = new ArrayList<>();
        this.mothers = new HashMap<>();
    }

    public void addMidwife(Midwife midwife) {
        midwifeList.add(midwife);
    }

    public void addMother(String name, Mother mother) {
        mothers.put(name, mother);
    }

    public boolean hasMother(String name) {
        return mothers.containsKey(name);
    }

    public Mother getMother(String name) {
        return mothers.get(name);
    }

    public List<Midwife> getMidwives() {
        return midwifeList;
    }

    public List<Mother> getMothers() {
        return new ArrayList<>(mothers.values());
    }
}
