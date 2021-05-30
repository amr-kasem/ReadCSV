import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PyramidDaoImpl implements PyramidDao {
    private ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>();
    FileReader f;
    BufferedReader bf;

    public PyramidDaoImpl() {
        String pharaoh = "";
        String ancient_name = "";
        String modern_name = "";
        Integer dynasty = 0;
        String site = "";
        Double base1 = 0.0;
        Double base2 = 0.0;
        Double height = 0.0;
        Double slope = 0.0;
        Double volume = 0.0;
        Double latitude = 0.0;
        Double longitude = 0.0;
        String type = "";
        String lepsius = "";
        String material = "";
        String comment = "";
        try {
            f = new FileReader("/home/auk/pyramids.csv");
            bf = new BufferedReader(f);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try {
            String text = bf.readLine();
            text = text.replaceAll(",,",",0,");
            while (text != null) {
                System.out.println(text);
                String[] data = text.split(",");
                for(int i =0; i < data.length;i++)
                    if(data[i].length() < 1)
                        data[i] = "0";
                try {
                    pharaoh = data[0];
                    ancient_name = data[1];
                    modern_name = data[2];
                    dynasty = Integer.parseInt(data[3]);
                    site = data[4];
                    base1 = Double.parseDouble(data[5]);
                    base2 = Double.parseDouble(data[6]);
                    height = Double.parseDouble(data[7]);
                    slope = Double.parseDouble(data[8]);
                    volume = Double.parseDouble(data[9]);
                    latitude = Double.parseDouble(data[10]);
                    longitude = Double.parseDouble(data[11]);
                    type = data[12];
                    lepsius = data[13];
                    material = data[14];
                    comment = data[15];
                } catch (Exception e) {
                    // System.out.println(e.toString()+",,"+text);
                    text = bf.readLine();
                    continue; // pybass problematic rows
                } finally {
                }
                text = bf.readLine();
                pyramids.add(new Pyramid(pharaoh, ancient_name, modern_name, dynasty, site, base1, base2, height,
                slope, volume, latitude, longitude, type, lepsius, material, comment));
            }
        } catch (Exception e) {
            System.out.println("problem reading from file");
        }
        try {
            bf.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public ArrayList<Pyramid> getAllPyramids() {
        return pyramids;
    }

    public void deletePyramid(Pyramid p) {
        pyramids.remove(p);
        saveChanges();
    }

    public void addPyramid(Pyramid p) {
        pyramids.add(p);
        saveChanges();
    }

    public void updatePyramid(Pyramid p) {
        saveChanges();
    }

    private void saveChanges() {
        String h = "Pharaoh,Ancient name,Modern name,Dynasty,Site,Base1 (m),Base2 (m),Height (m),Slope (dec degr),Volume (cu.m),Latitude,Longitude,Type,Lepsius,Material,Comment";
        try {
            FileWriter fw = new FileWriter("pyramids.csv");
            BufferedWriter Bw = new BufferedWriter(fw);
            Bw.write(h + "\n");
            for (Pyramid p : pyramids) {
                Bw.write(p.getPharaoh() + "," + p.getAncient_name() + "," + p.getModern_name() + "," + p.getDynasty()
                        + "," + p.getSite() + "," + p.getBase1() + "," + p.getBase2() + "," + p.getHeight() + ","
                        + p.getSlope() + "," + p.getVolume() + "," + p.getLatitude() + "," + p.getLongitude() + ","
                        + p.getType() + "," + p.getLepsius() + "," + p.getMaterial() + "," + p.getComment() + '\n');
            }
            Bw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
