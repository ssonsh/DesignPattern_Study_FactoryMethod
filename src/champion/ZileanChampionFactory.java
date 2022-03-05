package champion;

public class ZileanChampionFactory implements ChampionFactory {
    @Override
    public Champion create() {
        return new Zilean("질리언", "질리언 Q", "질리언 W", "질리언 E", "질리언 R", "질리언 기본 패시브", "질리언 전용 패시브");
    }
}
