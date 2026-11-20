package com.metrolist.music.ui.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SortHeaderKt$SortHeader$1$5 implements Function0 {
    public final /* synthetic */ Function1 $onSortDescendingChange;
    public final /* synthetic */ boolean $sortDescending;

    public SortHeaderKt$SortHeader$1$5(Function1 function1, boolean z) {
        this.$onSortDescendingChange = function1;
        this.$sortDescending = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.$onSortDescendingChange.invoke(Boolean.valueOf(!this.$sortDescending));
        return Unit.INSTANCE;
    }
}
