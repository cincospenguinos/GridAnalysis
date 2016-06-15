package diagonal_path;

/**
 * Created by tsvetok on 6/14/16.
 */
public class Pair<A, B> {

    private A obj1;
    private B obj2;

    public Pair(A _obj1, B _obj2){
        obj1 = _obj1;
        obj2 = _obj2;
    }

    public A getObj1() {
        return obj1;
    }

    public B getObj2() {
        return obj2;
    }
}
