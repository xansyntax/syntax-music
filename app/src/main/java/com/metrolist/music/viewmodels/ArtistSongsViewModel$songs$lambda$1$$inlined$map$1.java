package com.metrolist.music.viewmodels;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistSongsViewModel$songs$lambda$1$$inlined$map$1 implements Flow {
    public final /* synthetic */ boolean $hideExplicit$inlined;
    public final /* synthetic */ boolean $hideVideoSongs$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistSongsViewModel$songs$lambda$1$$inlined$map$1$1, reason: invalid class name */
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
            return ArtistSongsViewModel$songs$lambda$1$$inlined$map$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistSongsViewModel$songs$lambda$1$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ boolean $hideExplicit$inlined;
        public final /* synthetic */ boolean $hideVideoSongs$inlined;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistSongsViewModel$songs$lambda$1$$inlined$map$1$2$1, reason: invalid class name */
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
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public /* synthetic */ AnonymousClass2(FlowCollector flowCollector, boolean z, boolean z2, byte b) {
            this.$r8$classId = b;
            this.$this_unsafeFlow = flowCollector;
            this.$hideExplicit$inlined = z;
            this.$hideVideoSongs$inlined = z2;
        }

        /* JADX WARN: Code duplicated, block: B:114:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:129:0x0216  */
        /* JADX WARN: Code duplicated, block: B:24:0x0064  */
        /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:54:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:69:0x011e  */
        /* JADX WARN: Code duplicated, block: B:84:0x015c  */
        /* JADX WARN: Code duplicated, block: B:99:0x019a  */
        /* JADX WARN: Code duplicated, block: B:9:0x0026  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1 artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1;
            AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1 autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1;
            AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1 autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1;
            AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1 autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1;
            LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1;
            LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1;
            LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1;
            LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            boolean z = this.$hideVideoSongs$inlined;
            boolean z2 = this.$hideExplicit$inlined;
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
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        List listFilterVideoSongs = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        anonymousClass1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    if (continuation instanceof ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1) {
                        artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1 = (ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1) continuation;
                        int i3 = artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1 = new ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1 = new ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj3 = artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1.result;
                    int i4 = artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1.label;
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        List listFilterVideoSongs2 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs2, artistViewModel$librarySongs$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj3);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 2:
                    if (continuation instanceof AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1) {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1 = (AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1) continuation;
                        int i5 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj4 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1.result;
                    int i6 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1.label;
                    if (i6 == 0) {
                        ResultKt.throwOnFailure(obj4);
                        List listFilterVideoSongs3 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs3, autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i6 == 1) {
                        ResultKt.throwOnFailure(obj4);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    if (continuation instanceof AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1) {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1 = (AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1) continuation;
                        int i7 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj5 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1.result;
                    int i8 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1.label;
                    if (i8 == 0) {
                        ResultKt.throwOnFailure(obj5);
                        List listFilterVideoSongs4 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs4, autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i8 == 1) {
                        ResultKt.throwOnFailure(obj5);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    if (continuation instanceof AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1) {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1 = (AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1) continuation;
                        int i9 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj6 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1.result;
                    int i10 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1.label;
                    if (i10 == 0) {
                        ResultKt.throwOnFailure(obj6);
                        List listFilterVideoSongs5 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs5, autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj6);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 5:
                    if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1) continuation;
                        int i11 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj7 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1.result;
                    int i12 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1.label;
                    if (i12 == 0) {
                        ResultKt.throwOnFailure(obj7);
                        List listFilterVideoSongs6 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs6, librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i12 == 1) {
                        ResultKt.throwOnFailure(obj7);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 6:
                    if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1) continuation;
                        int i13 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj8 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1.result;
                    int i14 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1.label;
                    if (i14 == 0) {
                        ResultKt.throwOnFailure(obj8);
                        List listFilterVideoSongs7 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs7, librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i14 == 1) {
                        ResultKt.throwOnFailure(obj8);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 7:
                    if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1) continuation;
                        int i15 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj9 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1.result;
                    int i16 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1.label;
                    if (i16 == 0) {
                        ResultKt.throwOnFailure(obj9);
                        List listFilterVideoSongs8 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs8, librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj9);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1) continuation;
                        int i17 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1(this, continuation);
                        }
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1(this, continuation);
                    }
                    Object obj10 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1.result;
                    int i18 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1.label;
                    if (i18 == 0) {
                        ResultKt.throwOnFailure(obj10);
                        List listFilterVideoSongs9 = CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit((List) obj, z2), z);
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1.label = 1;
                        return flowCollector.emit(listFilterVideoSongs9, librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i18 == 1) {
                        ResultKt.throwOnFailure(obj10);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public /* synthetic */ ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(Flow flow, boolean z, boolean z2, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeTransform$inlined = flow;
        this.$hideExplicit$inlined = z;
        this.$hideVideoSongs$inlined = z2;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:24:0x0061  */
    /* JADX WARN: Code duplicated, block: B:39:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:69:0x010f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0149  */
    /* JADX WARN: Code duplicated, block: B:99:0x0183  */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$1 artistViewModel$librarySongs$lambda$1$$inlined$map$1$1;
        AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1 autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1;
        AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1 autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1;
        AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1 autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1;
        LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1;
        LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1;
        LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1;
        LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1 librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.$hideVideoSongs$inlined;
        boolean z2 = this.$hideExplicit$inlined;
        Flow flow = this.$this_unsafeTransform$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
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
                Object obj = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, z2, z, (byte) 0);
                    anonymousClass1.label = 1;
                    return flow.collect(anonymousClass2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                if (continuation instanceof ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$1) {
                    artistViewModel$librarySongs$lambda$1$$inlined$map$1$1 = (ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$1) continuation;
                    int i3 = artistViewModel$librarySongs$lambda$1$$inlined$map$1$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        artistViewModel$librarySongs$lambda$1$$inlined$map$1$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        artistViewModel$librarySongs$lambda$1$$inlined$map$1$1 = new ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    artistViewModel$librarySongs$lambda$1$$inlined$map$1$1 = new ArtistViewModel$librarySongs$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj2 = artistViewModel$librarySongs$lambda$1$$inlined$map$1$1.result;
                int i4 = artistViewModel$librarySongs$lambda$1$$inlined$map$1$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, z2, z, b2);
                    artistViewModel$librarySongs$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass3, artistViewModel$librarySongs$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1) {
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1 = (AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1) continuation;
                    int i5 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj3 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1.result;
                int i6 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, z2, z, (byte) 2);
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass4, autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1) {
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1 = (AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1) continuation;
                    int i7 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1(this, continuation);
                }
                Object obj4 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1.result;
                int i8 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, z2, z, (byte) 3);
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass5, autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1) {
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1 = (AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1) continuation;
                    int i9 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1 = new AutoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1(this, continuation);
                }
                Object obj5 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1.result;
                int i10 = autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, z2, z, (byte) 4);
                    autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass6, autoPlaylistViewModel$likedSongs$lambda$1$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1) {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1) continuation;
                    int i11 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj6 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1.result;
                int i12 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, z2, z, (byte) 5);
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass7, librarySongsViewModel$allSongs$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1) {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1) continuation;
                    int i13 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1(this, continuation);
                }
                Object obj7 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1.result;
                int i14 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, z2, z, (byte) 6);
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass8, librarySongsViewModel$allSongs$lambda$1$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1) {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1) continuation;
                    int i15 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1(this, continuation);
                }
                Object obj8 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1.result;
                int i16 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, z2, z, (byte) 7);
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass9, librarySongsViewModel$allSongs$lambda$1$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1) {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1 = (LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1) continuation;
                    int i17 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1(this, continuation);
                    }
                } else {
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1 = new LibrarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1(this, continuation);
                }
                Object obj9 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1.result;
                int i18 = librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, z2, z, (byte) 8);
                    librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1.label = 1;
                    return flow.collect(anonymousClass10, librarySongsViewModel$allSongs$lambda$1$$inlined$map$4$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
