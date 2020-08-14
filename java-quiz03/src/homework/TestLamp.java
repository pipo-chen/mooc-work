package homework;

interface Light {
    void shine();
}
class RedLight implements Light {
    @Override
    public void shine() {
        System.out.println("Red");
    }
}
class YellowLight implements Light {
    @Override
    public void shine() {
        System.out.println("Yellow");
    }
}
class GreenLight implements Light {
    @Override
    public void shine() {
        System.out.println("Green");
    }
}
class Lamp {
    private Light light;

    public void setLight(Light light) {
        this.light = light;
    }

    public void on() {
        light.shine();
    }
}
public class TestLamp {
    public static void main(String[] args) {
        Light[] ls = new Light[3];
        ls[0] = new RedLight();
        ls[1] = new YellowLight();
        ls[2] = new GreenLight();
        Lamp lamp = new Lamp();
        for (int i =0 ; i< ls.length;i++) {
            lamp.setLight(ls[i]);
            lamp.on();
        }
    }

}
