package Google_07;

public class Child {

    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    @Override
    public String toString() {
        return getChildName() + " " + getChildBirthday();
    }
}
