package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultimapBuilder$ArrayListSupplier implements Supplier, Serializable {
    @Override // com.google.common.base.Supplier
    public final Object get() {
        return new ArrayList(2);
    }
}
