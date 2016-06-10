import java.util.ArrayList;

/**
 * Created by Thu Trang on 04/06/16.
 */
public interface IFighter {
    ArrayList<Dan> listDan = new ArrayList<>();
    ArrayList<Bom> listBom = new ArrayList<>();
    void dropBoom();
    void banDan();
    void tangMau();
}
