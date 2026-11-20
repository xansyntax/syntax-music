package com.metrolist.music.listentogether;

import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherManager$startVolumeSyncObservation$1$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ float F$0;
    public final /* synthetic */ ListenTogetherManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenTogetherManager$startVolumeSyncObservation$1$1(ListenTogetherManager listenTogetherManager, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listenTogetherManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ListenTogetherManager$startVolumeSyncObservation$1$1 listenTogetherManager$startVolumeSyncObservation$1$1 = new ListenTogetherManager$startVolumeSyncObservation$1$1(this.this$0, continuation);
        listenTogetherManager$startVolumeSyncObservation$1$1.F$0 = ((Number) obj).floatValue();
        return listenTogetherManager$startVolumeSyncObservation$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ListenTogetherManager$startVolumeSyncObservation$1$1 listenTogetherManager$startVolumeSyncObservation$1$1 = (ListenTogetherManager$startVolumeSyncObservation$1$1) create(Float.valueOf(((Number) obj).floatValue()), (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        listenTogetherManager$startVolumeSyncObservation$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f = this.F$0;
        ResultKt.throwOnFailure(obj);
        ListenTogetherManager listenTogetherManager = this.this$0;
        ListenTogetherClient listenTogetherClient = listenTogetherManager.client;
        boolean zIsHost = listenTogetherManager.isHost();
        Unit unit = Unit.INSTANCE;
        if (zIsHost && listenTogetherClient.isInRoom() && ((Boolean) listenTogetherManager.syncHostVolumeEnabled.getValue()).booleanValue()) {
            float fCoerceIn = UuidKt.coerceIn(f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
            Float f2 = listenTogetherManager.lastSyncedVolume;
            if (f2 == null || Math.abs(f2.floatValue() - fCoerceIn) >= 0.01f) {
                listenTogetherManager.lastSyncedVolume = new Float(fCoerceIn);
                ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient, "set_volume", null, null, null, null, null, new Float(fCoerceIn), 126);
            }
        }
        return unit;
    }
}
