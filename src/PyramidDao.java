import java.util.ArrayList;

interface PyramidDao{
    public ArrayList<Pyramid> getAllPyramids();
    public void updatePyramid(Pyramid p);
    public void deletePyramid(Pyramid p);
    public void addPyramid(Pyramid p);
}