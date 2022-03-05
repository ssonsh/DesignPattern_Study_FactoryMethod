package champion;

public class ZinxChampionFactory implements ChampionFactory{

    @Override
    public Champion create() {
        return new Zinx("징크스", "징크스 Q", "징크스 W", "징크스 E", "징크스 R", "징크스 기본 패시브", "징크스 전용 패시브");
    }
}
