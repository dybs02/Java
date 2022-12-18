import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class MyVector {

    public static class DifferentVectorsLengthsException extends Exception {
        public ArrayList<Integer> lengths = new ArrayList<>();

        public DifferentVectorsLengthsException (String msg) {
            super(msg);
        }

        public DifferentVectorsLengthsException(String msg, ArrayList<MyVector> vectors) {
            super(msg);
            for (MyVector v : vectors) {
                lengths.add(v.getLength());
            }
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

    public static MyVector sumAll(ArrayList<MyVector> vectors) throws DifferentVectorsLengthsException {
        int baseLength = vectors.get(0).getLength();
        MyVector sumOfVectors = new MyVector(baseLength);

        for (MyVector v : vectors) {
            if (v.getLength() != baseLength) {
                throw new DifferentVectorsLengthsException("Cannot add vectors with different lengths", vectors);
            }

            for (int i = 0; i < baseLength; i++) {
                sumOfVectors.elements.set(i, sumOfVectors.getElement(i) + v.getElement(i));
            }
        }

        return sumOfVectors;
    }

    public void addElement(int e) {
        this.elements.add(e);
    }

    public int getElement(int i) {
        return this.elements.get(i);
    }

    public int getLength() {
        return this.elements.size();
    }

    @Override
    public String toString() {
        return this.elements.toString() + ", length = " + this.elements.size();
    }
}
