package testApi;
//父类
public class fatherClass {
    String name;
    String main;

    public String getName() {
        System.out.println("父类方法getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain() {
        System.out.println("父类方法getMain");
        return main;
    }

    public void setMain(String main) {
        this.main = main;
        System.out.println("父类方法setMain");
    }
}


