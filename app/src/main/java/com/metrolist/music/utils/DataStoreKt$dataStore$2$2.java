package com.metrolist.music.utils;

import android.content.Context;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DataStoreKt$dataStore$2$2 extends PropertyReference0Impl {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreKt$dataStore$2$2(Object obj, Class cls, String str, String str2, int i, byte b) {
        super(obj, cls, str, str2, i);
        this.$r8$classId = b;
    }

    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return UtilsKt.getDataStore((Context) this.receiver);
            case 1:
                return ((State) this.receiver).getValue();
            case 2:
                return ((State) this.receiver).getValue();
            case 3:
                return ((State) this.receiver).getValue();
            case 4:
                return ((State) this.receiver).getValue();
            case 5:
                return ((State) this.receiver).getValue();
            default:
                return this.receiver.getClass().getSimpleName();
        }
    }
}
