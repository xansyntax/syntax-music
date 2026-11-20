package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SortHeaderKt$SortHeader$1$2$1 implements Function0 {
    public final /* synthetic */ MutableState $menuExpanded$delegate;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SortHeaderKt$SortHeader$1$2$1(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$menuExpanded$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$menuExpanded$delegate;
        switch (b) {
            case 0:
                mutableState.setValue(Boolean.valueOf(!MenuKt.m1492SortHeader$lambda1(mutableState)));
                break;
            default:
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
