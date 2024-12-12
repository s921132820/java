package figureCalculator;

public abstract class Figure implements FigureInterface{
    // public이 들어가야 다른 패키지에서도 참조
    public abstract double area();
}
