package com.metrolist.music.ui.player;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$3;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda2(CoroutineScope coroutineScope, Context context, String str, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$0 = coroutineScope;
        this.f$1 = context;
        this.f$2 = str;
        this.f$3 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$3;
        String str = this.f$2;
        Context context = this.f$1;
        CoroutineScope coroutineScope = this.f$0;
        switch (b) {
            case 0:
                AwaitKt.launch$default(coroutineScope, null, null, new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, null, (byte) 1), 3);
                Toast.makeText(context, String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()))}, 1)), 0).show();
                break;
            case 1:
                AwaitKt.launch$default(coroutineScope, null, null, new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, null, (byte) 2), 3);
                Toast.makeText(context, String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()))}, 1)), 0).show();
                break;
            case 2:
                AwaitKt.launch$default(coroutineScope, null, null, new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, null, (byte) 0), 3);
                Toast.makeText(context, String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()))}, 1)), 0).show();
                break;
            default:
                AwaitKt.launch$default(coroutineScope, null, null, new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, null, (byte) 3), 3);
                Toast.makeText(context, String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()))}, 1)), 0).show();
                break;
        }
        return unit;
    }
}
