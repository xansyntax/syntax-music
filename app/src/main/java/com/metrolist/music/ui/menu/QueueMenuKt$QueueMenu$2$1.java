package com.metrolist.music.ui.menu;

import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueMenuKt$QueueMenu$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ MediaMetadata $mediaMetadata;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ MediaMetadata $mediaMetadata;
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(MediaMetadata mediaMetadata, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$mediaMetadata = mediaMetadata;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MediaMetadata mediaMetadata = this.$mediaMetadata;
            switch (b) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(mediaMetadata, continuation, (byte) 0);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(mediaMetadata, continuation, (byte) 1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            MusicDatabase musicDatabase = (MusicDatabase) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create(musicDatabase, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(musicDatabase, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            MediaMetadata mediaMetadata = this.$mediaMetadata;
            MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    musicDatabase.insert(mediaMetadata, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    musicDatabase.insert(mediaMetadata, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                    break;
            }
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueMenuKt$QueueMenu$2$1(MusicDatabase musicDatabase, MediaMetadata mediaMetadata, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$database = musicDatabase;
        this.$mediaMetadata = mediaMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        MediaMetadata mediaMetadata = this.$mediaMetadata;
        MusicDatabase musicDatabase = this.$database;
        switch (b) {
            case 0:
                return new QueueMenuKt$QueueMenu$2$1(musicDatabase, mediaMetadata, continuation, (byte) 0);
            default:
                return new QueueMenuKt$QueueMenu$2$1(musicDatabase, mediaMetadata, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((QueueMenuKt$QueueMenu$2$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        MusicDatabase musicDatabase = this.$database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        MediaMetadata mediaMetadata = this.$mediaMetadata;
        byte b2 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(mediaMetadata, continuation, (byte) 0);
                    this.label = true;
                    if (musicDatabase.withTransaction(anonymousClass1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionsKt__IterablesKt.listOf(mediaMetadata.id);
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(mediaMetadata, continuation, b2);
                    this.label = true;
                    if (musicDatabase.withTransaction(anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionsKt__IterablesKt.listOf(mediaMetadata.id);
        }
    }
}
