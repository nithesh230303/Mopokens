import java.util.*;

public class EquityMopoken implements Equity {
    private MopokenStrength strength;
    private Map<String, Mopokens> squad;
    private Mopokens result = null;
    public static int decide = 0;
    public boolean isWin = false;

    public EquityMopoken(Map<String, Mopokens> player) {
        this.squad = player;
        this.setMopokenStrength();
    }

    private void setMopokenStrength() {
        this.strength = MopokenStrength.getInstance();
    }

    public Mopokens match(Mopokens mopoken) {
        result = null;
        LevelAdvantage(mopoken);
        WeakAdvantage(mopoken);
        TypeAdvantage(mopoken);
        if (!isWin) {
            makeDraw(mopoken);
            if (result == null) {
                Map<String, Mopokens> squad = this.squad;
                for (Map.Entry<String, Mopokens> s : squad.entrySet()) {
                    result = s.getValue();
                    break;
                }
            }
        }
        assert result != null;
        this.squad.remove(result.getName());
        if (isWin) {
            decide++;
        }
        isWin = false;
        return result;
    }
    private void chooseClosestLevel(Mopokens opponent, Mopokens player) {
        if (opponent.getLevel() < player.getLevel()) {
            if (player.getLevel() <= result.getLevel()) {
                result = player;
                isWin = true;
            } else if (opponent.getLevel() > player.getLevel()) {
                if (player.getLevel() > result.getLevel()) {
                    result = player;
                    isWin = true;
                }
            }
        }
    }

    public void TypeAdvantage(Mopokens opponent) {
        Map<String, Mopokens> mysquad = this.squad;
        for (Map.Entry<String, Mopokens> map : mysquad.entrySet()) {
            List<String> oppAdv = this.strength.getMopokenStrength().get(map.getKey());
            for (String s : oppAdv) {
                if (opponent.getName().equals(s)) {
                    if (opponent.getLevel() < map.getValue().getLevel()
                            || opponent.getLevel() < (2 * map.getValue().getLevel())) {
                        if (result != null) {
                            chooseClosestLevel(opponent, map.getValue());
                        } else {
                            isWin = true;
                            result = map.getValue();
                        }
                        break;
                    }
                }
            }
        }
    }

    public void WeakAdvantage(Mopokens opponent) {
        List<String> oppAdv = this.strength.getMopokenStrength().get(opponent.getName());
        Map<String, Mopokens> mySquad = this.squad;
        for (String s : oppAdv) {
            if (mySquad.containsKey(s)) {
                Mopokens player = mySquad.get(s);
                if (player.getLevel() >= (2 * opponent.getLevel())) {
                    if (result != null) {
                        chooseClosestLevel(opponent, player);
                    } else {
                        isWin = true;
                        result = player;
                    }
                    break;
                }
            }
        }
    }
    public void LevelAdvantage(Mopokens opponent) {
        Map<String, Mopokens> mySquad = this.squad;
        for (Map.Entry<String, Mopokens> s : mySquad.entrySet()) {
            if (s.getValue().getLevel() > opponent.getLevel()) {
                if (result != null) {
                    chooseClosestLevel(opponent, s.getValue());
                } else {
                    isWin = true;
                    result = s.getValue();
                }
                break;

            }
        }
    }

    public void makeDraw(Mopokens opponent) {
        Map<String, Mopokens> mySquad = this.squad;
        for (Map.Entry<String, Mopokens> s : mySquad.entrySet()) {
            if (s.getValue().getLevel() == opponent.getLevel()) {
                result = s.getValue();
                break;
            }
        }
    }
}