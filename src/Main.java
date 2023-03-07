public class Main {
    public static void main(String[] args) {

        AllMopokens trainer = new AllMopokens("Fire#10;Water#20;Fighting#6;Psychic#10;Electric#12");
        AllMopokens opponent = new AllMopokens("Water#10;Fighting#10;Psychic#10;Fire#12;Grass#2");
        BattleResults selection = new SelectMokopen(trainer,opponent);
        selection.prepareBattles();
    }
}