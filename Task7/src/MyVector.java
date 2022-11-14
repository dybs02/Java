import java.util.ArrayList;

public class MyVector {
    private ArrayList<Integer> elements;

    public MyVector() {
        this.elements = new ArrayList<>();
    }

    public MyVector(int... args) {
        this.elements = new ArrayList<>();

        for (int arg : args) {
            this.elements.add(arg);
        }
    }

    public MyVector(ArrayList<Integer> arrayList) {
        this.elements = new ArrayList<>(arrayList);
    }

    public MyVector add(MyVector v) {
        if (this.getLength() != v.getLength()) {
            return null;
        }

        MyVector new_vector = new MyVector();
        for (int i = 0; i < this.elements.size(); i++) {
            new_vector.addElement(this.elements.get(i) + v.elements.get(i));
        }
        return new_vector;
    }

    public void addElement(int e) {
        this.elements.add(e);
    }

    public int getLength() {
        return this.elements.size();
    }

    @Override
    public String toString() {
        return this.elements.toString() + ", length = " + this.elements.size();
    }
}
