package com.whg;

public class Pair<L, R> {

    private final L left;
    private final R right;

    public static <L, R> Pair<L, R> of(L l, R r) {
        return new Pair<>(l, r);
    }

    private Pair(L left, R right) {
        super();
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

}
