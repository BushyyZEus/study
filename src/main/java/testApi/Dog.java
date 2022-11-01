package testApi;

class Dog implements Animal{

    @Override
    public void breath() {
        System.out.println("breath");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
