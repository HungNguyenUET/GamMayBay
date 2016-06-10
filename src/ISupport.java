import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thu Trang on 04/06/16.
 */
public interface ISupport {
    void bonusHP(List<Plane> listPlane);
    void bunusHp(Plane plane);
    void anQua(Gift gift);
    void anQua(Gift gift, ArrayList<IFighter> listFighter);
    void addFighter(IFighter fighter);
    void deleteFighter(IFighter fighter);
}
