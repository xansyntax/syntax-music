package com.google.common.base;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Suppliers$MemoizingSupplier implements Supplier, Serializable {
    public final Supplier delegate;
    public volatile transient boolean initialized;
    public transient Object lock = new Object();
    public transient Object value;

    public Suppliers$MemoizingSupplier(Supplier supplier) {
        this.delegate = supplier;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.lock = new Object();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        if (!this.initialized) {
            synchronized (this.lock) {
                try {
                    if (!this.initialized) {
                        Object obj = this.delegate.get();
                        this.value = obj;
                        this.initialized = true;
                        return obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.initialized) {
            obj = "<supplier that returned " + this.value + ">";
        } else {
            obj = this.delegate;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
