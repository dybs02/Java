import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class MyVector {

    public class DifferentVectorsLengthsException extends Exception {
        public DifferentVectorsLengthsException (String msg) {
            super(msg);
        }

        public DifferentVectorsLengthsException (MyVector v1, MyVector v2) {
            super(String.format("Vectors have different lengths:\n%s \n%s", v1, v2));
        }
    }

    private ArrayList<Integer> elements;


    public MyVector() {
        this.elements = new ArrayList<>();
    }

    public MyVector(int numberOfElements) {
        this.elements = new ArrayList<>(Collections.nCopies(numberOfElements, 0));
    }

    public MyVector(ArrayList<Integer> arrayList) {
        this.elements = new ArrayList<>(arrayList);
    }

    public MyVector add(MyVector v) throws DifferentVectorsLengthsException {
        if (this.getLength() != v.getLength()) {
            throw new DifferentVectorsLengthsException(this, v);
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
