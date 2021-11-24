public class Cat {
    private int privateField;
    private int publicField;
    private int defaultField;

    public Cat(int privateField, int publicField, int defaultField) {
        this.privateField = privateField;
        this.publicField = publicField;
        this.defaultField = defaultField;
    }

    public Cat() {
    }

    public void publicmeow(){
        System.out.println("public meow");
    }

    private void privatemeow(){
        System.out.println("private meow");
    }
}
