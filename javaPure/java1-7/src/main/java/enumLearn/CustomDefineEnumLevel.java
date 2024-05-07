package enumLearn;

/**
 * 自定义枚举 值
 */
public enum CustomDefineEnumLevel {
    HIGH("高"),
    MEDIUM("中"),
    LOW("低")
    ;
    private String value;
    private CustomDefineEnumLevel(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
