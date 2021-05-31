import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PyramidDaoImpl implements PyramidDao {
    private ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>();
    FileReader f;
    BufferedReader bf;
    // String file;

    public PyramidDaoImpl(String fname) {
        // file = fname;
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
            f = new FileReader(fname);
            bf = new BufferedReader(f);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try {
            String text = bf.readLine();
            while (text != null) {
                text = "-" +text.replaceAll(",,", ",0,")+"-";
                String[] data = text.split(",");
                for (int i = 0; i < data.length; i++)
                    if (data[i].length() < 1)
                        data[i] = "0";
                pharaoh = data[0].substring(1);
                ancient_name = data[1];
                modern_name = data[2];
                try {
                    dynasty = Integer.parseInt(data[3]);
                } catch (Exception e) {
                    dynasty = 0;
                }
                site = data[4];
                try {
                    base1 = Double.parseDouble(data[5]);
                } catch (Exception e) {
                    base1 = 0.0;
                }
                try {
                    base2 = Double.parseDouble(data[6].length() > 0 ? data[6] : "0");
                } catch (Exception e) {
                    base2 = 0.0;
                }
                try {
                    height = Double.parseDouble(data[7].length() > 0 ? data[7] : "0");
                } catch (Exception e) {
                    height = 0.0;
                }
                try {
                    slope = Double.parseDouble(data[8].length() > 0 ? data[8] : "0");
                } catch (Exception e) {
                    slope = 0.0;
                }
                try {
                    volume = Double.parseDouble(data[9].length() > 0 ? data[9] : "0");
                } catch (Exception e) {
                    volume = 0.0;
                }
                try {
                    latitude = Double.parseDouble(data[10].length() > 0 ? data[10] : "0");                    
                } catch (Exception e) {
                    latitude = 0.0;
                }
                try{
                    longitude = Double.parseDouble(data[11].length() > 0 ? data[11] : "0");
                }catch(Exception e){
                    longitude = 0.0;
                }
                type = data[12];
                lepsius = data[13];
                material = data[14];
                comment = data[15].substring(0, data[15].length() - 1);
                pyramids.add(new Pyramid(pharaoh, ancient_name, modern_name, dynasty, site, base1, base2, height, slope,
                volume, latitude, longitude, type, lepsius, material, comment));
                text = bf.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            bf.close();
        } catch (Exception e) {

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
    public HashMap<String,Integer> getNoPyramidsPerSite(){
        HashMap<String,Integer> m = new HashMap<>();
        for(Pyramid p : pyramids){
            String t = p.getSite();
            Integer c = m.putIfAbsent(t,1);
            if(c != null){
                m.put(t, c + 1);
            }
        }
        return m;
    }
}
