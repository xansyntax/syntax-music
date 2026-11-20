package com.metrolist.innertubex.cipher;

import com.dokar.quickjs.QuickJs;
import com.dokar.quickjs.QuickJsException;
import com.metrolist.music.db.DatabaseDao_Impl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuickJsEngine$execute$2$invokeSuspend$$inlined$evaluate$default$1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ QuickJs this$0;

    public /* synthetic */ QuickJsEngine$execute$2$invokeSuspend$$inlined$evaluate$default$1(QuickJs quickJs, byte b) {
        this.$r8$classId = b;
        this.this$0 = quickJs;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws QuickJsException {
        byte b = this.$r8$classId;
        QuickJs quickJs = this.this$0;
        obj.getClass();
        switch (b) {
            case 0:
                quickJs.getTypeConverters().convert(obj, DatabaseDao_Impl.AnonymousClass17.typeOfInstance(quickJs.getTypeConverters(), obj), Reflection.nullableTypeOf(Object.class));
                break;
            case 1:
                quickJs.getTypeConverters().convert(obj, DatabaseDao_Impl.AnonymousClass17.typeOfInstance(quickJs.getTypeConverters(), obj), Reflection.nullableTypeOf(String.class));
                break;
            default:
                quickJs.getTypeConverters().convert(obj, DatabaseDao_Impl.AnonymousClass17.typeOfInstance(quickJs.getTypeConverters(), obj), Reflection.nullableTypeOf(String.class));
                break;
        }
        return obj;
    }
}
