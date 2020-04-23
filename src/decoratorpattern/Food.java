package decoratorpattern;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 装饰者模式
 * @create: 2020-04-23 23:18
 **/
public class Food {

    private String foodName;

    public Food() {

    }

    public Food(String foodName){
        this.foodName =foodName;
    }

    public String make(){
        return foodName;
    }

}
