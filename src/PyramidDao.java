import java.util.ArrayList;
import java.util.HashMap;

interface PyramidDao{
    public ArrayList<Pyramid> getAllPyramids();
    public void updatePyramid(Pyramid p);
    public void deletePyramid(Pyramid p);
    public void addPyramid(Pyramid p);
    public HashMap<String ,Integer> getNoPyramidsPerSite();
}