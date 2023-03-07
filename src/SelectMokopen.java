import java.util.*;

public class SelectMokopen implements BattleResults {
    private static Map<Mopokens, Mopokens> fight;
    private MatchPlayers opponent;
    private Equity equity;

    public static Map<Mopokens, Mopokens> getFight() {
        return fight;
    }

    public static void setFight(Map<Mopokens, Mopokens> fight) {
        SelectMokopen.fight = fight;
    }

    public MatchPlayers getOpponent() {
        return opponent;
    }

    public void setOpponent(MatchPlayers opponent) {
        this.opponent = opponent;
    }

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }

    public SelectMokopen(MatchPlayers trainer, MatchPlayers opponent) {
        this.equity =new EquityMopoken(trainer.getMopokens());
        this.opponent=opponent;
        fight = new HashMap<Mopokens, Mopokens>();
    }
    public void prepareBattles() {
        Map<String, Mopokens> opponents = opponent.getMopokens();
        for (Map.Entry<String, Mopokens> m : opponents.entrySet()) {
            Mopokens mopoken = equity.match(m.getValue());
            fight.put(m.getValue(), mopoken);
        }
        if(tactic.decideMatch(EquityMopoken.decide)){
            tactic out = new tactic();
            out.printResult();
        }
    }

}
