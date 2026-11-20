package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.db.entities.Album;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Album f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Function3 f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ boolean f$6;
    public final /* synthetic */ int f$7;
    public final /* synthetic */ byte f$8;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda6(Album album, Modifier modifier, CoroutineScope coroutineScope, Function3 function3, boolean z, boolean z2, boolean z3, int i, int i2) {
        this.f$0 = album;
        this.f$1 = modifier;
        this.f$2 = coroutineScope;
        this.f$3 = function3;
        this.f$4 = z;
        this.f$5 = z2;
        this.f$6 = z3;
        this.f$7 = i;
        this.f$8 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Object obj3 = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                MenuKt.AlbumGridItem(this.f$0, this.f$1, (CoroutineScope) obj3, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags, this.f$8);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                MenuKt.AlbumListItem(this.f$0, this.f$1, this.f$4, this.f$3, this.f$5, this.f$6, (Function3) obj3, (Composer) obj, iUpdateChangedFlags2, this.f$8);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda6(Album album, Modifier modifier, boolean z, Function3 function3, boolean z2, boolean z3, Function3 function4, int i, int i2) {
        this.f$0 = album;
        this.f$1 = modifier;
        this.f$4 = z;
        this.f$3 = function3;
        this.f$5 = z2;
        this.f$6 = z3;
        this.f$2 = function4;
        this.f$7 = i;
        this.f$8 = i2;
    }
}
