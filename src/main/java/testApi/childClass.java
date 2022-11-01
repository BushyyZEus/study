package testApi;

public class childClass extends fatherClass{
    String childName;
    String childMain;
//子类
    public String getChildName() {
        System.out.println("子类方法getChildName");
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildMain() {
        System.out.println("子类方法getChildMain");
        return childMain;
    }

    public void setChildMain(String childMain) {
        this.childMain = childMain;
    }

    @Override
    public String getMain() {
        return super.getMain();
    }
//重写父类方法
    @Override
    public void setMain(String main) {
        super.setMain(main);
    }
//用了同名但编译器不能识别为重写父类方法
 //   @Override
//    public void setMain(String main) {
//        this.main = main;
//        System.out.println("子类方法setMain");
//    }
}
