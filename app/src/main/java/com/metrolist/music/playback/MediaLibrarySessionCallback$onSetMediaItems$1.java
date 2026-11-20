package com.metrolist.music.playback;

import androidx.media3.session.MediaSession$MediaItemsWithStartPosition;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionCallback$onSetMediaItems$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $mediaItems;
    public final /* synthetic */ int $startIndex;
    public final /* synthetic */ long $startPositionMs;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public MediaSession$MediaItemsWithStartPosition L$1;
    public Object L$10;
    public Iterator L$11;
    public String L$4;
    public String L$5;
    public List L$6;
    public List L$7;
    public Song L$8;
    public Object L$9;
    public byte label;
    public final /* synthetic */ MediaLibrarySessionCallback this$0;

    /* JADX INFO: renamed from: com.metrolist.music.playback.MediaLibrarySessionCallback$onSetMediaItems$1$20, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass20 extends SuspendLambda implements Function2 {
        public final /* synthetic */ YouTubeQueue $radioQueue;
        public final /* synthetic */ Queue.Status $radioStatus;
        public final /* synthetic */ MediaLibrarySessionCallback this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass20(MediaLibrarySessionCallback mediaLibrarySessionCallback, YouTubeQueue youTubeQueue, Queue.Status status, Continuation continuation) {
            super(2, continuation);
            this.this$0 = mediaLibrarySessionCallback;
            this.$radioQueue = youTubeQueue;
            this.$radioStatus = status;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass20(this.this$0, this.$radioQueue, this.$radioStatus, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            AnonymousClass20 anonymousClass20 = (AnonymousClass20) create((CoroutineScope) obj, (Continuation) obj2);
            Unit unit = Unit.INSTANCE;
            anonymousClass20.invokeSuspend(unit);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            MusicService musicService = this.this$0.service;
            if (musicService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("service");
                throw null;
            }
            Queue.Status status = this.$radioStatus;
            String title = status.getTitle();
            int size = status.getItems().size();
            YouTubeQueue youTubeQueue = this.$radioQueue;
            youTubeQueue.getClass();
            musicService.currentQueue = youTubeQueue;
            musicService.queueTitle = title;
            musicService.originalQueueSize = size;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibrarySessionCallback$onSetMediaItems$1(int i, long j, List list, MediaLibrarySessionCallback mediaLibrarySessionCallback, Continuation continuation) {
        super(2, continuation);
        this.$startIndex = i;
        this.$startPositionMs = j;
        this.$mediaItems = list;
        this.this$0 = mediaLibrarySessionCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MediaLibrarySessionCallback$onSetMediaItems$1 mediaLibrarySessionCallback$onSetMediaItems$1 = new MediaLibrarySessionCallback$onSetMediaItems$1(this.$startIndex, this.$startPositionMs, this.$mediaItems, this.this$0, continuation);
        mediaLibrarySessionCallback$onSetMediaItems$1.L$0 = obj;
        return mediaLibrarySessionCallback$onSetMediaItems$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MediaLibrarySessionCallback$onSetMediaItems$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:354:0x07a9 -> B:356:0x07ad). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 25621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instruction units count: 2562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.playback.MediaLibrarySessionCallback$onSetMediaItems$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
