package homework;

interface ServiceInterface {
    void doService1();
    void doService2();
    void doService3();
}

abstract class AbstractService implements ServiceInterface {
    @Override
    public void doService1() {

    }

    @Override
    public void doService2() {

    }

    @Override
    public void doService3() {

    }

    public void test1() {

    }
}

class Myservice implements ServiceInterface {
    @Override
    public void doService3() {

    }

    @Override
    public void doService2() {

    }

    @Override
    public void doService1() {

    }
}
class MyServce extends AbstractService {
    @Override
    public void test1() {
        super.test1();
    }

    @Override
    public void doService1() {
        super.doService1();
    }
}
public class _48 {

}
