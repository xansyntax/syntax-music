package com.metrolist.music.ui.menu;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.lifecycle.Lifecycle;
import coil3.ImageLoader$Builder;
import com.metrolist.innertubex.extraction.YtConfigParserImpl;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.audio.VolumeNormalizationAudioProcessor;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueMenuKt$QueueMenu$7$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $context;
    public Object $database;
    public Object $librarySong$delegate;
    public Object $mediaMetadata;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $syncUtils;
    public Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(RealWebSocket$$ExternalSyntheticLambda2 realWebSocket$$ExternalSyntheticLambda2, MusicService musicService, VolumeNormalizationAudioProcessor volumeNormalizationAudioProcessor, String str, boolean z, Double d, Double d2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 4;
        this.L$0 = realWebSocket$$ExternalSyntheticLambda2;
        this.$database = musicService;
        this.$mediaMetadata = volumeNormalizationAudioProcessor;
        this.$librarySong$delegate = str;
        this.label = z;
        this.$syncUtils = d;
        this.$context = d2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$context;
        Object obj3 = this.$syncUtils;
        switch (b) {
            case 0:
                QueueMenuKt$QueueMenu$7$1$1$1 queueMenuKt$QueueMenu$7$1$1$1 = new QueueMenuKt$QueueMenu$7$1$1$1(this.$database, this.$mediaMetadata, this.$librarySong$delegate, obj3, obj2, continuation, (byte) 0);
                queueMenuKt$QueueMenu$7$1$1$1.L$0 = obj;
                return queueMenuKt$QueueMenu$7$1$1$1;
            case 1:
                return new QueueMenuKt$QueueMenu$7$1$1$1((Lifecycle) this.$librarySong$delegate, (CoroutineScope) obj3, (SimpleActor$offer$2) obj2, continuation);
            case 2:
                QueueMenuKt$QueueMenu$7$1$1$1 queueMenuKt$QueueMenu$7$1$1$2 = new QueueMenuKt$QueueMenu$7$1$1$1((YtConfigParserImpl) this.$mediaMetadata, (String) this.$librarySong$delegate, (Ref$ObjectRef) obj3, (Ref$ObjectRef) obj2, continuation);
                queueMenuKt$QueueMenu$7$1$1$2.L$0 = obj;
                return queueMenuKt$QueueMenu$7$1$1$2;
            case 3:
                return new QueueMenuKt$QueueMenu$7$1$1$1((MediaMetadata) this.$mediaMetadata, (List) obj3, (ImageLoader$Builder) obj2, continuation);
            case 4:
                return new QueueMenuKt$QueueMenu$7$1$1$1((RealWebSocket$$ExternalSyntheticLambda2) this.L$0, (MusicService) this.$database, (VolumeNormalizationAudioProcessor) this.$mediaMetadata, (String) this.$librarySong$delegate, this.label, (Double) obj3, (Double) obj2, continuation);
            case 5:
                return new QueueMenuKt$QueueMenu$7$1$1$1((MusicDatabase) this.$database, (AddToPlaylistPosition) this.L$0, (Function0) this.$mediaMetadata, (MutableState) this.$librarySong$delegate, (MutableState) obj3, (MutableState) obj2, continuation);
            case 6:
                return new QueueMenuKt$QueueMenu$7$1$1$1((SnackbarHostState) this.L$0, (String) this.$database, (String) this.$mediaMetadata, (PlayerConnection) obj3, (SnapshotStateList) obj2, (MutableState) this.$librarySong$delegate, continuation);
            case 7:
                return new QueueMenuKt$QueueMenu$7$1$1$1(this.$database, this.$mediaMetadata, this.$librarySong$delegate, obj3, obj2, continuation, (byte) 7);
            default:
                return new QueueMenuKt$QueueMenu$7$1$1$1((MutableState) this.$librarySong$delegate, (MutableState) this.L$0, (MutableState) this.$database, (MutableState) this.$mediaMetadata, (MutableState) obj3, (String) obj2, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((String) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 5:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 6:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 7:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((QueueMenuKt$QueueMenu$7$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0363  */
    /* JADX WARN: Code duplicated, block: B:139:0x039f  */
    /* JADX WARN: Code duplicated, block: B:150:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:158:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:205:0x04db  */
    /* JADX WARN: Code duplicated, block: B:228:0x0564  */
    /* JADX WARN: Code duplicated, block: B:231:0x056d  */
    /* JADX WARN: Code duplicated, block: B:313:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x039d -> B:272:0x03a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x03b2 -> B:141:0x03a3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, String str, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 8;
        this.$librarySong$delegate = mutableState;
        this.L$0 = mutableState2;
        this.$database = mutableState3;
        this.$mediaMetadata = mutableState4;
        this.$syncUtils = mutableState5;
        this.$context = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(Lifecycle lifecycle, CoroutineScope coroutineScope, SimpleActor$offer$2 simpleActor$offer$2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.$librarySong$delegate = lifecycle;
        this.$syncUtils = coroutineScope;
        this.$context = simpleActor$offer$2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(YtConfigParserImpl ytConfigParserImpl, String str, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 2;
        this.$mediaMetadata = ytConfigParserImpl;
        this.$librarySong$delegate = str;
        this.$syncUtils = ref$ObjectRef;
        this.$context = ref$ObjectRef2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(MusicDatabase musicDatabase, AddToPlaylistPosition addToPlaylistPosition, Function0 function0, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 5;
        this.$database = musicDatabase;
        this.L$0 = addToPlaylistPosition;
        this.$mediaMetadata = function0;
        this.$librarySong$delegate = mutableState;
        this.$syncUtils = mutableState2;
        this.$context = mutableState3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(MediaMetadata mediaMetadata, List list, ImageLoader$Builder imageLoader$Builder, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 3;
        this.$mediaMetadata = mediaMetadata;
        this.$syncUtils = list;
        this.$context = imageLoader$Builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueMenuKt$QueueMenu$7$1$1$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$database = obj;
        this.$mediaMetadata = obj2;
        this.$librarySong$delegate = obj3;
        this.$syncUtils = obj4;
        this.$context = obj5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueMenuKt$QueueMenu$7$1$1$1(SnackbarHostState snackbarHostState, String str, String str2, PlayerConnection playerConnection, SnapshotStateList snapshotStateList, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 6;
        this.L$0 = snackbarHostState;
        this.$database = str;
        this.$mediaMetadata = str2;
        this.$syncUtils = playerConnection;
        this.$context = snapshotStateList;
        this.$librarySong$delegate = mutableState;
    }
}
