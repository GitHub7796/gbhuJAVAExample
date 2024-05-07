package enumLearn;

/**
 * 含有抽象方法的 枚举,每个枚举都要实现这个抽象方法
 */
public enum AbstractMethodsEnum {
    HIGH {
        @Override
        public String abMethod() {
            return "high:"+HIGH.toString();
        }
    },
    MEDIUM {
        @Override
        public String abMethod() {
            return "medium:"+MEDIUM.toString();
        }
    },
    LOW {
        @Override
        public String abMethod() {
            return "low:"+LOW.toString();
        }
    };

    public abstract String abMethod();
}
