import java.util.*;

public class SortRute extends Rute{
	public SortRute(int rad, int kol, Labyrint brett) {
		super(rad, kol, brett);
	}

	@Override
	public String toString() {
		return "#";
	}

	@Override
	public ArrayList<Rute> finn(Rute fra) {
		ArrayList<Rute> ikkeNo = new ArrayList<>();
		return ikkeNo;
	}
}
