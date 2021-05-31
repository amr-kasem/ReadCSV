import java.util.Comparator;

public class PyramidHeightComparator implements Comparator<Pyramid>{
    public int compare(Pyramid p1, Pyramid p2){
        if (p1.getHeight() == p2.getHeight())
            return 0;
        else if (p1.getHeight() > p2.getHeight())
            return 1;
        else
            return -1;
    }
}
