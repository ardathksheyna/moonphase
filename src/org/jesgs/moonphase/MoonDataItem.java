package org.jesgs.moonphase;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class MoonDataItem {

    private String label;
    private String value;


    /**
     * Add a new item
     *
     * @param label
     * @param value
     */
    public MoonDataItem(String label, String value) {
        this.put(label, value);
    }

    /**
     * Add values
     *
     * @param label
     * @param value
     */
    private void put(String label, String value) {
        this.label = label;
        this.value = value;
    }


    /**
     * Set the label
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }


    /**
     * Get the label
     * @return String
     */
    public String getLabel() {
        return label;
    }


    /**
     * Set value
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }


    /**
     * Get value
     * @return String
     */
    public String getValue() {
        return this.value;
    }


    @Override
    public String toString() {
        String data = this.label + " " + this.value;

        return data;
    }

}
