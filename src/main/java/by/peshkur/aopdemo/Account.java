package by.peshkur.aopdemo;

public class Account {
    private String name;
    private String level;

    public Account() {
    }

    public Account(String name, String level, boolean vipFlag) {
        this.name = name;
        this.level = level;
        this.vipFlag = vipFlag;
    }

    public boolean isVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(boolean vipFlag) {
        this.vipFlag = vipFlag;
    }

    private boolean vipFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", vipFlag=" + vipFlag +
                '}';
    }
}
