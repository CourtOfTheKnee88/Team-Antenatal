import java.util.ArrayList;

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

    /**
     * Updates the given record by calling its updateRecords method.
     *
     * @param record The record to be updated
     */
    public void updateRecord(Record record) {
        record.updateRecords();
    }

    /**
     * Deletes a record by calling its delete method.
     *
     * @param record The record to be deleted
     */
    public void deleteRecord(Record record) {
        mother.records.get(index).delete();
    }

    /**
     * Retrieves a specific record for a mother at the given index.
     *
     * @param mother The mother identifier or index
     * @param index The index of the record in the mother's record list
     * @return The retrieved record
     */
    public Record getRecord(int mother, int index) {
        record = mother.records.get(index);
        return record;
    }

    /**
     * Adds a new record to a mother's record list.
     *
     * @param record The record to be added
     */
    public void addRecord(Record record) {
        mother.addRecord(record);
    }
}
