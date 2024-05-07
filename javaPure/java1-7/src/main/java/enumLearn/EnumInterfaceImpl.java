package enumLearn;

public enum EnumInterfaceImpl implements EnumInterface{
    HIGH("高"),
    MEDIUM("中"),
    LOW("低")
    ;

    private String value;
    private EnumInterfaceImpl(String value){
        this.value = value;
    }
    @Override
    public String getDescription() {
        return this.value;
    }
}
