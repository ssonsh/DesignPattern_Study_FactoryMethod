package champion;

public class ChampionFactorySelector {

    public static ChampionFactory get(ChampionType type) {
        switch (type){
            case ZINX:
                return new ZinxChampionFactory();
            case ZILEAN:
                return new ZileanChampionFactory();
            default:
                throw new IllegalStateException();
        }
    }
}
