package com.metrolist.music.playback;

import androidx.media3.exoplayer.offline.Download;
import androidx.palette.graphics.ColorCutQuantizer;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2 implements FlowCollector {
    public final /* synthetic */ Map $downloads$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ FlowCollector $this_unsafeFlow;

    /* JADX INFO: renamed from: com.metrolist.music.playback.MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2.this.emit(null, this);
        }
    }

    public /* synthetic */ MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2(FlowCollector flowCollector, Map map, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeFlow = flowCollector;
        this.$downloads$inlined = map;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Map map = this.$downloads$inlined;
        FlowCollector flowCollector = this.$this_unsafeFlow;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj2 = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : (List) obj) {
                    Download download = (Download) map.get(((Song) obj3).song.id);
                    if (download != null && download.state == 3) {
                        arrayList.add(obj3);
                    }
                }
                anonymousClass1.label = 1;
                return flowCollector.emit(arrayList, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                if (continuation instanceof MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1) {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1 = (MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1) continuation;
                    int i3 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1(this, continuation);
                    }
                } else {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1(this, continuation);
                }
                Object obj4 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1.result;
                int i4 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj4);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj4);
                List<Song> list = (List) obj;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (Song song : list) {
                    arrayList2.add(new Pair(song, map.get(song.song.id)));
                }
                List listSortedWith = CollectionsKt.sortedWith(arrayList2, new ColorCutQuantizer.AnonymousClass1((byte) 11));
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith, 10));
                Iterator it = listSortedWith.iterator();
                while (it.hasNext()) {
                    arrayList3.add((Song) ((Pair) it.next()).first);
                }
                mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1.label = 1;
                return flowCollector.emit(arrayList3, mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
