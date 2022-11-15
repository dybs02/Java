import java.util.ArrayList;
import java.util.Collections;

public class MyVector {

    public class DifferentVectorsLengthsException extends Exception {
        public DifferentVectorsLengthsException (int len1, int len2) {
            super(String.format("Vector lengths are not the same: %d, %d", len1, len2));
        }
    }

    private ArrayList<Integer> elements;

    public MyVector() {
        this.elements = new ArrayList<>();
    }

    public MyVector(int numberOfElements) {
        this.elements = new ArrayList<>(Collections.nCopies(numberOfElements, 0));
    }

//    TODO do i need this ?
    public MyVector(int... args) {
        this.elements = new ArrayList<>();

        for (int arg : args) {
            this.elements.add(arg);
        }
    }

    public MyVector(ArrayList<Integer> arrayList) {
        this.elements = new ArrayList<>(arrayList);
    }

    public MyVector add(MyVector v) throws DifferentVectorsLengthsException {
        if (this.getLength() != v.getLength()) {
            throw new DifferentVectorsLengthsException(this.getLength(), v.getLength());
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
