package org.jesgs.moonphase;

/**
 *
 * @author Jess Green <jgreen@periscope.com>
 */
public class MoonDataCollection {

    private String label;
    private String value;


    public MoonDataCollection(String label, String value) {
        this.put(label, value);
    }

    private void put(String label, String value) {
        this.label = label;
        this.value = value;
    }


    /**
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return String
     */
    public String getLabel() {
        return label;
    }


    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }


    /**
     *
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
