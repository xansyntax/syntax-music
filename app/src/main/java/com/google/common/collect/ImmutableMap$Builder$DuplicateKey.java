package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmutableMap$Builder$DuplicateKey {
    public final Object key;
    public final Object value1;
    public final Object value2;

    public ImmutableMap$Builder$DuplicateKey(Object obj, Object obj2, Object obj3) {
        this.key = obj;
        this.value1 = obj2;
        this.value2 = obj3;
    }

    public final IllegalArgumentException exception() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.key;
        sb.append(obj);
        sb.append("=");
        sb.append(this.value1);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.value2);
        return new IllegalArgumentException(sb.toString());
    }
}
