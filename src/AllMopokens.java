import java.util.*;

public class AllMopokens implements MatchPlayers{
    public Map<String, Mopokens> mopokens = new HashMap<>();

    public AllMopokens(String allMokopens){
        MokopenList(allMokopens);
    }

    public void MokopenList(String inputLine){
        String[] mokopen = inputLine.split(";");
        for (String s : mokopen) {
            String str[] = s.split("#");
            mopokens.put(str[0], new Mopokens(str[0], Integer.parseInt(str[1])));
        }
    }

    public Map<String, Mopokens> getMopokens() {
        return this.mopokens;
    }

}
