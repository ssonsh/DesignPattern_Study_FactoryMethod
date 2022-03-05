package champion;

public abstract class Champion {
    private String name;

    private String qSkill;
    private String wSkill;
    private String eSkill;
    private String rSkill;

    private String defaultPassive;
    private String specialPassive;

    public Champion(String name, String q, String w, String e, String r, String defaultPassive, String specialPassive) {
        this.name = name;
        this.qSkill = q;
        this.wSkill = w;
        this.eSkill = e;
        this.rSkill = r;
        this.defaultPassive = defaultPassive;
        this.specialPassive = specialPassive;
    }

    @Override
    public String toString() {
        return "Champion{" +
               "name='" + name + '\'' +
               ", qSkill='" + qSkill + '\'' +
               ", wSkill='" + wSkill + '\'' +
               ", eSkill='" + eSkill + '\'' +
               ", rSkill='" + rSkill + '\'' +
               ", defaultPassive='" + defaultPassive + '\'' +
               ", specialPassive='" + specialPassive + '\'' +
               '}';
    }
}
