import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> cmp;
    public MaxArrayDeque(Comparator<T> c){
        super();
        cmp = c;
    }

    public T max(){
        return max(cmp);
    }
    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }
        int maxIndex = 0;
        for (int i = 1; i < size(); i += 1) {
            if (c.compare(get(i),get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }
}
