package lab4;

import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;

public class Hyperbola implements Function, Comparable<Hyperbola>, Iterator<Object>, Iterable<Object> {
    private double a=0;
    private double b=0;

    private double solution_1 = 0;
    private double solution_2 = 0;
    
    private int iterator_idx = 0;

    public String center_color;
    public String color;

    private void reset(){
        iterator_idx=0;
    }

    @Override
    public boolean hasNext() {
        return iterator_idx<=3;
    }

    public Hyperbola(String equation){
        Matcher matcher = pat.matcher(equation);
        if(matcher.find()){
            a = Double.parseDouble(matcher.group(1));
            if(a==0){
                System.out.println("Wrong parameter of a");
            }
        }
        else{
            System.out.println("Wrong parameter of a");
        }
        if(matcher.find()){
            b = Double.parseDouble(matcher.group(1));
            if(b==0){
                System.out.println("Wrong parameter of b");
            }
        }
        else{
            System.out.println("Wrong parameter of b");
        }
        String[] args = equation.split(",");
        center_color = args[1];
        color = args[2];
    }

    @Override
    public void solve(int x) throws Exception {
        if(x<Math.sqrt(a))throw new Exception("Wrong x value");
        solution_1 = Math.sqrt(b*(Math.pow(x,2)/a-1));
        solution_2 = -Math.sqrt(b*(Math.pow(x,2)/a-1));

    }

    @Override
    public int compareTo(Hyperbola o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Hyperbola{ x^2/" + a +
                " - y^2/" + b + " = 1 " +
                ", solution_1=" + solution_1 +
                ", solution_2=" + solution_2 +
                '}';
    }

    @Override
    public Object next() {
        switch(iterator_idx){
            case 0:
                iterator_idx++;
                return Double.valueOf(a);
            case 1:
                iterator_idx++;
                return Double.valueOf(b);
            case 2:
                iterator_idx++;
                return Double.valueOf(solution_1);
            case 3:
                iterator_idx++;
                return Double.valueOf(solution_2);
            default:
                reset();
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hyperbola hyperbola = (Hyperbola) o;
        return Double.compare(hyperbola.a, a) == 0 &&
                Double.compare(hyperbola.b, b) == 0 &&
                Double.compare(hyperbola.solution_1, solution_1) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b, solution_1);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getSolution_1() {
        return solution_1;
    }

    @Override
    public Iterator<Object> iterator() {
        return this;
    }
}
