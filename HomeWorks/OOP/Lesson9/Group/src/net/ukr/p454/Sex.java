package net.ukr.p454;

/**
 * Created by user on 18.09.2016.
 */
public enum Sex {
    MALE("Man"), FEMALE("Woman");

    private String sex;

    private Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String inRus) {
        this.sex = sex;
    }
}
