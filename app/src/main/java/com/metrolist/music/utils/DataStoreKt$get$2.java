package com.metrolist.music.utils;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import coil3.disk.RealDiskCache;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.viewmodels.OnlinePlaylistViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreKt$get$2 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object $defaultValue;
    public final /* synthetic */ Object $key;
    public final /* synthetic */ byte $r8$classId;
    public Object $this_get;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreKt$get$2(Object obj, boolean z, MutableState mutableState, MutableState mutableState2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_get = obj;
        this.label = z;
        this.$key = mutableState;
        this.$defaultValue = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$key;
        switch (b) {
            case 0:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 0);
            case 1:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 1);
            case 2:
                return new DataStoreKt$get$2((List) this.$this_get, this.label, (MutableState) obj2, (MutableState) this.$defaultValue, continuation, (byte) 2);
            case 3:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 3);
            case 4:
                DataStoreKt$get$2 dataStoreKt$get$2 = new DataStoreKt$get$2((MusicService) this.$this_get, (ListQueue) obj2, continuation, (byte) 4);
                dataStoreKt$get$2.$defaultValue = obj;
                return dataStoreKt$get$2;
            case 5:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 5);
            case 6:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 6);
            case 7:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 7);
            case 8:
                return new DataStoreKt$get$2((CoroutineScope) this.$this_get, this.label, (MutableState) obj2, (ParcelableSnapshotMutableFloatState) this.$defaultValue, continuation, (byte) 8);
            case 9:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 9);
            case 10:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 10);
            case 11:
                DataStoreKt$get$2 dataStoreKt$get$3 = new DataStoreKt$get$2((Song) this.$this_get, (MusicDatabase) obj2, continuation, (byte) 11);
                dataStoreKt$get$3.$defaultValue = obj;
                return dataStoreKt$get$3;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 12);
            case 13:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 13);
            case 14:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 14);
            case 15:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 15);
            case 16:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 16);
            case 17:
                return new DataStoreKt$get$2((byte) 17, obj2, this.$defaultValue, continuation, false);
            case 18:
                return new DataStoreKt$get$2((byte) 18, obj2, this.$defaultValue, continuation, false);
            case 19:
                DataStoreKt$get$2 dataStoreKt$get$4 = new DataStoreKt$get$2((RealDiskCache) this.$this_get, (ParcelableSnapshotMutableLongState) obj2, continuation, (byte) 19);
                dataStoreKt$get$4.$defaultValue = obj;
                return dataStoreKt$get$4;
            case 20:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 20);
            case 21:
                return new DataStoreKt$get$2((byte) 21, obj2, this.$defaultValue, continuation, false);
            case 22:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 22);
            case 23:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 23);
            case 24:
                return new DataStoreKt$get$2((byte) 24, obj2, this.$defaultValue, continuation, false);
            case 25:
                DataStoreKt$get$2 dataStoreKt$get$5 = new DataStoreKt$get$2((OnlinePlaylistViewModel) obj2, continuation);
                dataStoreKt$get$5.$defaultValue = obj;
                return dataStoreKt$get$5;
            case 26:
                DataStoreKt$get$2 dataStoreKt$get$6 = new DataStoreKt$get$2((FlowCollector) this.$this_get, (ChannelFlow) obj2, continuation, (byte) 26);
                dataStoreKt$get$6.$defaultValue = obj;
                return dataStoreKt$get$6;
            case 27:
                DataStoreKt$get$2 dataStoreKt$get$7 = new DataStoreKt$get$2((FlowKt__DelayKt$debounceInternal$1) this.$this_get, (FlowCollector) obj2, continuation, (byte) 27);
                dataStoreKt$get$7.$defaultValue = obj;
                return dataStoreKt$get$7;
            default:
                return new DataStoreKt$get$2(this.$this_get, obj2, this.$defaultValue, continuation, (byte) 28);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 3:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 5:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 6:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 7:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 8:
                ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 9:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 10:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 11:
                return ((DataStoreKt$get$2) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 13:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 14:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 15:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 16:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 17:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 18:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 19:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 20:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 21:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 22:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 23:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 24:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 25:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 26:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 27:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((DataStoreKt$get$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:156:0x0358  */
    /* JADX WARN: Code duplicated, block: B:158:0x0364  */
    /* JADX WARN: Code duplicated, block: B:384:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:485:0x0373 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.coroutines.Continuation, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r8v82 */
    /* JADX WARN: Type inference failed for: r8v86 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:157:0x0362 -> B:159:0x0366). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0143 -> B:53:0x0147). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 2582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.DataStoreKt$get$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreKt$get$2(OnlinePlaylistViewModel onlinePlaylistViewModel, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 25;
        this.$key = onlinePlaylistViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreKt$get$2(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_get = obj;
        this.$key = obj2;
        this.$defaultValue = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreKt$get$2(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_get = obj;
        this.$key = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreKt$get$2(byte b, Object obj, Object obj2, Continuation continuation, boolean z) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$key = obj;
        this.$defaultValue = obj2;
    }
}
