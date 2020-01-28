package cn.yydcyy._4.hashset;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author YYDCYY
 * @create 2020-01-28
 * HashSet1<E>  java.io.Serializable , 加了这个不用导包. 可能为了区分别的 Serializable 包.
 */
public class HashSet1<E> extends AbstractSet<E>
        implements Set<E>, Cloneable, Serializable {
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
