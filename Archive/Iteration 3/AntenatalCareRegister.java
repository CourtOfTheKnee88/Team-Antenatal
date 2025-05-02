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

    /**
     * Adds a midwife to the registry.
     *
     * @param name the name key under which to store the midwife
     * @param midwife the Midwife object to store
     */
    public void addMidwife(String name, Midwife midwife) {
        midwives.put(name, midwife);
    }

    /**
     * Checks if a midwife exists in the register.
     *
     * @param name name of the midwife
     * @return true if present, false otherwise
     */
    public boolean hasMidwife(String name) {
        return midwives.containsKey(name);
    }

    /**
     * Retrieves a midwife from the register.
     *
     * @param name name of the midwife
     * @return the Midwife object, or null if not found
     */
    public Midwife getMidwife(String name) {
        return midwives.get(name);
    }

    /**
     * Adds a mother to the registry.
     *
     * @param name the name key under which to store the mother
     * @param mother the Mother object to store
     */
    public void addMother(String name, Mother mother) {
        mothers.put(name, mother);
    }

    /**
     * Checks if a mother exists in the register.
     *
     * @param name name of the mother
     * @return true if present, false otherwise
     */
    public boolean hasMother(String name) {
        return mothers.containsKey(name);
    }

    /**
     * Retrieves a mother from the register.
     *
     * @param name name of the mother
     * @return the Mother object, or null if not found
     */
    public Mother getMother(String name) {
        return mothers.get(name);
    }

    /**
     * Returns a list of all registered midwives.
     *
     * @return list of Midwife objects
     */
    public List<Midwife> getMidwives() {
        return new ArrayList<>(midwives.values());
    }

    /**
     * Returns a list of all registered mothers.
     *
     * @return list of Mother objects
     */
    public List<Mother> getMothers() {
        return new ArrayList<>(mothers.values());
    }
}
