package enumLearn;

public class EnumMain {
    public static void main(String[] args) {
        LevelSimpleEnum levelSimpleEnum = LevelSimpleEnum.LOW;

        if (levelSimpleEnum == LevelSimpleEnum.LOW) {}
        else if (levelSimpleEnum == LevelSimpleEnum.HIGH) {}
        else if (levelSimpleEnum == LevelSimpleEnum.MEDIUM) {}

        switch (levelSimpleEnum) {
            case LOW:break;
            case HIGH:break;
            case MEDIUM:break;
        }

        for(LevelSimpleEnum level: LevelSimpleEnum.values()) {

        }
    }
}
