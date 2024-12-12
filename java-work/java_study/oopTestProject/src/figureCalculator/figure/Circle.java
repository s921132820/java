package figureCalculator.figure;

import figureCalculator.Figure;

import java.security.PrivateKey;

public class Circle extends Figure {
    private int radius;
    public void  setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "원";
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
