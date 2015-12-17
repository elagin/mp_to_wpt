import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elagin on 17.12.15.
 */
public class Main {
    final static String POI = "[POI]";
    final static String END = "[END]";

    static List<Poi> poiList = new ArrayList<Poi>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("data/poi-point.mp"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print(e.getLocalizedMessage());
        }

        String s;
        StringBuffer buff = new StringBuffer();
        boolean read = false;

        while ((s = br.readLine()) != null) {
            if (!read && s.equals(POI)) {
                //buff.append(s);
                read = true;
            } else if (read) {
                if (!s.equals(END))
                    buff.append(s).append(";");
                else {
                    Poi poi = new Poi(buff.toString());
                    poiList.add(poi);
                    read = false;
                    buff.delete(0, buff.length());
                }
            }
        }
        System.out.print(String.format("Successful. %i", poiList.size()));
    }
}

