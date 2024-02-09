class GenericBox<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class GenericVSLegacy {

    public static void main(String[] args) {

        GenericBox<Integer> genericBox = new GenericBox<>();
        genericBox.setItem(1);

        int value = genericBox.getItem();
        System.out.println(value);

        GenericBox<String> genericBoxString = new GenericBox<>();
        genericBoxString.setItem("Youtube");
        System.out.println(genericBoxString.getItem());



    }
}
