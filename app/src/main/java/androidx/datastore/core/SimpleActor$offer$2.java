package androidx.datastore.core;

import androidx.compose.foundation.MarqueeModifierNode;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogicImpl;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.ui.platform.WeakCache;
import androidx.room.Transactor;
import androidx.room.TriggerBasedInvalidationTracker;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.utils.SyncUtils;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleActor$offer$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public Object L$0;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleActor$offer$2(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$0 = obj;
        this.this$0 = obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                return new SimpleActor$offer$2((Dispatcher) obj2, continuation, (byte) 0);
            case 1:
                return new SimpleActor$offer$2((Job) this.L$0, (MarqueeModifierNode) obj2, continuation, (byte) 1);
            case 2:
                return new SimpleActor$offer$2((AnchoredDraggableNode) this.L$0, (DragEvent.DragStopped) obj2, continuation, (byte) 2);
            case 3:
                SimpleActor$offer$2 simpleActor$offer$2 = new SimpleActor$offer$2((MouseWheelScrollingLogicImpl) obj2, continuation, (byte) 3);
                simpleActor$offer$2.L$0 = obj;
                return simpleActor$offer$2;
            case 4:
                return new SimpleActor$offer$2((Job) this.L$0, (PressGestureScopeImpl) obj2, continuation, (byte) 4);
            case 5:
                return new SimpleActor$offer$2((AndroidLegacyPlatformTextInputServiceAdapter) this.L$0, (WeakCache) obj2, continuation, (byte) 5);
            case 6:
                return new SimpleActor$offer$2((Job) this.L$0, (CursorAnimationState) obj2, continuation, (byte) 6);
            case 7:
                return new SimpleActor$offer$2((DataStoreImpl) this.L$0, (Message$Update) obj2, continuation, (byte) 7);
            case 8:
                return new SimpleActor$offer$2((Flow) this.L$0, (ProduceStateScopeImpl) obj2, continuation, (byte) 8);
            case 9:
                SimpleActor$offer$2 simpleActor$offer$3 = new SimpleActor$offer$2((TriggerBasedInvalidationTracker) obj2, continuation, (byte) 9);
                simpleActor$offer$3.L$0 = obj;
                return simpleActor$offer$3;
            case 10:
                return new SimpleActor$offer$2((MainActivity) obj2, continuation, (byte) 10);
            case 11:
                return new SimpleActor$offer$2((ListenTogetherClient) obj2, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new SimpleActor$offer$2((DownloadUtil) this.L$0, (String) obj2, continuation, (byte) 12);
            case 13:
                return new SimpleActor$offer$2((MusicService) obj2, continuation, (byte) 13);
            case 14:
                return new SimpleActor$offer$2((String) this.L$0, (PlayerConnection) obj2, continuation, (byte) 14);
            case 15:
                return new SimpleActor$offer$2((SyncUtils) obj2, continuation, (byte) 15);
            default:
                return new SimpleActor$offer$2((SyncUtils) this.L$0, (SongEntity) obj2, continuation, (byte) 16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 5:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 6:
                ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 7:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 8:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 9:
                return ((SimpleActor$offer$2) create((Transactor) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 10:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 11:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 13:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 14:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 15:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((SimpleActor$offer$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:343:0x0621 A[Catch: all -> 0x0609, PHI: r0
      0x0621: PHI (r0v39 kotlinx.coroutines.CoroutineScope) = 
      (r0v37 kotlinx.coroutines.CoroutineScope)
      (r0v38 kotlinx.coroutines.CoroutineScope)
      (r0v43 kotlinx.coroutines.CoroutineScope)
     binds: [B:342:0x061a, B:349:0x0654, B:334:0x0605] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #4 {all -> 0x0609, blocks: (B:334:0x0605, B:343:0x0621, B:345:0x062b, B:348:0x0638, B:340:0x0614), top: B:423:0x05fb }] */
    /* JADX WARN: Code duplicated, block: B:345:0x062b A[Catch: all -> 0x0609, TryCatch #4 {all -> 0x0609, blocks: (B:334:0x0605, B:343:0x0621, B:345:0x062b, B:348:0x0638, B:340:0x0614), top: B:423:0x05fb }] */
    /* JADX WARN: Code duplicated, block: B:347:0x0637  */
    /* JADX WARN: Code duplicated, block: B:348:0x0638 A[Catch: all -> 0x0609, PHI: r0 r2
      0x0638: PHI (r0v38 kotlinx.coroutines.CoroutineScope) = (r0v39 kotlinx.coroutines.CoroutineScope), (r0v41 kotlinx.coroutines.CoroutineScope) binds: [B:346:0x0635, B:341:0x0617] A[DONT_GENERATE, DONT_INLINE]
      0x0638: PHI (r2v3 java.lang.Object) = (r2v9 java.lang.Object), (r2v10 java.lang.Object) binds: [B:346:0x0635, B:341:0x0617] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {all -> 0x0609, blocks: (B:334:0x0605, B:343:0x0621, B:345:0x062b, B:348:0x0638, B:340:0x0614), top: B:423:0x05fb }] */
    /* JADX WARN: Code duplicated, block: B:387:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:406:0x072e A[PHI: r0 r1
      0x072e: PHI (r0v8 com.metrolist.music.App$onCreate$1) = (r0v14 com.metrolist.music.App$onCreate$1), (r0v21 com.metrolist.music.App$onCreate$1) binds: [B:404:0x072b, B:400:0x06f5] A[DONT_GENERATE, DONT_INLINE]
      0x072e: PHI (r1v1 java.lang.Object) = (r1v4 java.lang.Object), (r1v5 java.lang.Object) binds: [B:404:0x072b, B:400:0x06f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x0368 -> B:155:0x0322). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:294:0x0566 -> B:296:0x0569). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:349:0x0654 -> B:343:0x0621). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:407:0x0736 -> B:409:0x073a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleActor$offer$2(Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
    }
}
