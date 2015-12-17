/**
 * Created by elagin on 17.12.15.
 */
public class Poi {
    String type;
    String label;
    String data;

    final String TYPE = "Type";
    final String LABEL = "Label";
    final String DATA = "Data0";

    final String EOL = "\n\r";

    public Poi(String line) {
        String[] list = line.split(";");
        for (String item : list) {
            try {
                int dividerPtr = item.indexOf("=");
                String name = item.substring(0, dividerPtr);
                String value = item.substring(dividerPtr + 1, item.length());
                if(name.equals(TYPE))
                    this.type = value;
                else if(name.equals(LABEL))
                    this.label = value;
                else if(name.equals(DATA))
                    this.data = value;
            } catch (Exception ex) {
                ex.getLocalizedMessage();
            }
        }
    }
}
