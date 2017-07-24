package zhang.test.proxy;

/**
 * @author zhangkun
 * @version 1.0
 * @date 2017/7/24
 * @description
 */
/**
 * 电能车类，实现Rechargable，Vehicle接口
 * @author louluan
 */
public class ElectricCar implements Rechargable, Vehicle {

    @Override
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    @Override
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }

}
