import champion.*;

public class Main {

    public static void main(String[] args) {

        ChampionFactory zinxFactory = ChampionFactorySelector.get(ChampionType.ZINX);
        Champion zinx = zinxFactory.create();

        ChampionFactory zileanFactory = ChampionFactorySelector.get(ChampionType.ZILEAN);
        Champion zilean = zileanFactory.create();

        System.out.println("zinx : " + zinx.toString());
        System.out.println("zilean : " + zilean.toString());
    }
}
