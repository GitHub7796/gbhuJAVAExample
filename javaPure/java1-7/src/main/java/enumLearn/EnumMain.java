package enumLearn;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumMain {
    public static void main(String[] args) {
/**
 *枚 举使用
 */

        SimpleEnumLevel levelSimpleEnum = SimpleEnumLevel.LOW;
/**
 *  枚举的 条件判断
 */
//        1. if
        if (levelSimpleEnum == SimpleEnumLevel.LOW) {}
        else if (levelSimpleEnum == SimpleEnumLevel.HIGH) {}
        else if (levelSimpleEnum == SimpleEnumLevel.MEDIUM) {}
//          2. switch
        switch (levelSimpleEnum) {
            case LOW:break;
            case HIGH:break;
            case MEDIUM:break;
        }
/**
 * Enum Iteration 枚举迭代
 * 运行结果：
 * HIGH
 * MEDIUM
 * LOW
  */
        for(SimpleEnumLevel level: SimpleEnumLevel.values()) {
            System.out.println(level);
        }
        /**
         * 枚举 与 字符串
         */
//    enum-》string
        String levelText = SimpleEnumLevel.LOW.toString();
//    string-》 enum
        SimpleEnumLevel level = SimpleEnumLevel.valueOf(levelText);
//        java 后台自己会调用 level.toString()
        System.out.println(level);

        /**
         * EnumSet、EnumMap
         */
        EnumSet<SimpleEnumLevel> enumSet = EnumSet.of(SimpleEnumLevel.HIGH, SimpleEnumLevel.MEDIUM, SimpleEnumLevel.LOW);
        EnumMap<SimpleEnumLevel,String> enumMap=new EnumMap<>(SimpleEnumLevel.class);
        enumMap.put(SimpleEnumLevel.HIGH, "High");
        enumMap.put(SimpleEnumLevel.MEDIUM, "Medium");
        /**
         * 自定义枚举字段
         */
        CustomDefineEnumLevel customDefineEnumLevel = CustomDefineEnumLevel.MEDIUM;
        System.out.println("customDefineEnumLevel:"+customDefineEnumLevel);
        System.out.println("customDefineEnumLevel.getValue():"+customDefineEnumLevel.getValue());
        /**
         * 带有抽象方法的枚举
         */
        AbstractMethodsEnum abstractMethodsEnum = AbstractMethodsEnum.MEDIUM;
        System.out.println("abstractMethodsEnum:"+abstractMethodsEnum.abMethod());

        /**
         * 枚举实现接口
         */
        EnumInterfaceImpl level1= EnumInterfaceImpl.LOW;
        System.out.println(level1.name());
        System.out.println(level1.getDescription());

    }


}
