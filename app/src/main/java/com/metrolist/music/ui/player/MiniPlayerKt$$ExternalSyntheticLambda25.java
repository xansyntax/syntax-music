package com.metrolist.music.ui.player;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.DialogKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda25 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ Modifier f$3;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda25(Modifier modifier, long j, long j2, Shape shape, int i) {
        this.f$3 = modifier;
        this.f$1 = j;
        this.f$2 = j2;
        this.f$0 = shape;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                QueueKt.m1503NewMiniPlayerSongInfoeopBjH0((MediaMetadata) obj3, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                DialogKt.m1465ContainedLoadingIndicatoreopBjH0(this.f$3, this.f$1, this.f$2, (Shape) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda25(MediaMetadata mediaMetadata, long j, long j2, Modifier modifier, int i) {
        this.f$0 = mediaMetadata;
        this.f$1 = j;
        this.f$2 = j2;
        this.f$3 = modifier;
    }
}
