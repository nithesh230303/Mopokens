import java.util.*;

public class MopokenStrength {
    private static MopokenStrength mopokenStrength = null;
    private Map<String, List<String>> strength = new HashMap<String, List<String>>();

    private MopokenStrength() {
    }

    public static MopokenStrength getInstance() {
        mopokenStrength = new MopokenStrength();
        return mopokenStrength;
    }

    public Map<String, List<String>> getMopokenStrength() {
        strength.put("Fire", Arrays.asList("Grass", "Ghost"));
        strength.put("Water", List.of("Fire"));
        strength.put("Grass", Arrays.asList("Electric", "Fighting"));
        strength.put("Electric", List.of("Water"));
        strength.put("Psychic", List.of("Ghost"));
        strength.put("Ghost", Arrays.asList("Fighting", "Fire", "Electric"));
        strength.put("Fighting", List.of("Electric"));
        return strength;
    }
}