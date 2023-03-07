import java.util.Map;

public class tactic {
    public static boolean decideMatch(int count) {
        return count >= 3;
    }
    public void printResult(){
        StringBuilder out = new StringBuilder();
        Map<Mopokens, Mopokens> fight = SelectMokopen.getFight();
        for (Map.Entry<Mopokens, Mopokens> m : fight.entrySet()) {
            out.append(m.getValue().getName()).append("#").append(m.getValue().getLevel()).append(";");
        }
        System.out.println(out);
    }
}
