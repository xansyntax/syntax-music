package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Iterators$6 extends TransformedIterator {
    public final /* synthetic */ Function val$function;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Iterators$6(Iterator it, Function function) {
        super(it);
        this.val$function = function;
    }

    @Override // com.google.common.collect.TransformedIterator
    public final Object transform(Object obj) {
        return this.val$function.apply(obj);
    }
}
