import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The AntenatalCareRegister class manages information about midwives and mothers
 * in an antenatal care system, along with methods to manipulate patient records.
 */
public class AntenatalCareRegister {
    private HashMap<String, Midwife> midwives;
    private HashMap<String, Mother> mothers;

    /**
     * Constructs a new AntenatalCareRegister with empty lists for midwives and mothers.
     */
    public AntenatalCareRegister() {
        this.midwives = new HashMap<>();
        this.mothers = new HashMap<>();
    }

    public void addMidwife(String name, Midwife midwife) {
        midwives.put(name, midwife);
    }

    public boolean hasMidwife(String name) {
        return midwives.containsKey(name);
    }

    public Midwife getMidwife(String name) {
        return midwives.get(name);
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
        return new ArrayList<>(midwives.values());
    }

    public List<Mother> getMothers() {
        return new ArrayList<>(mothers.values());
    }
}
