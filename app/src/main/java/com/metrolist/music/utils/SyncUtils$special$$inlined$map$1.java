package com.metrolist.music.utils;

import androidx.datastore.preferences.core.MutablePreferences;
import coil3.ImageLoader$Builder;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.listentogether.ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.lyrics.LyricsHelper$getLyrics$$inlined$map$1$2$1;
import com.metrolist.music.lyrics.LyricsHelper$special$$inlined$map$1$2$1;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$10$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$10$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$11$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$11$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$12$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$12$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$2$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$3$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$3$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$4$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$4$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$5$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$5$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$6$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$6$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$7$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$7$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$8$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$8$2$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$9$1;
import com.metrolist.music.playback.MusicService$onCreate$$inlined$map$9$2$1;
import com.metrolist.music.playback.MusicService$onCreate$11$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$48$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$49$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$50$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$51$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$52$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService$onCreate$53$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.playback.MusicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.ui.screens.settings.AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1;
import com.metrolist.music.ui.screens.settings.AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.AccountViewModel$4$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.viewmodels.AccountViewModel$4$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.ArtistSongsViewModel$special$$inlined$map$1$1;
import com.metrolist.music.viewmodels.ArtistSongsViewModel$special$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.ArtistViewModel$1$invokeSuspend$$inlined$map$1$1;
import com.metrolist.music.viewmodels.ArtistViewModel$1$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.ArtistViewModel$special$$inlined$map$1$1;
import com.metrolist.music.viewmodels.ArtistViewModel$special$$inlined$map$2$1;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel$special$$inlined$map$1$1;
import com.metrolist.music.viewmodels.HomeViewModel$special$$inlined$map$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$special$$inlined$map$1 implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$special$$inlined$map$1$1, reason: invalid class name */
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
            return SyncUtils$special$$inlined$map$1.this.collect(null, this);
        }
    }

    public /* synthetic */ SyncUtils$special$$inlined$map$1(Flow flow, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeTransform$inlined = flow;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:144:0x0231  */
    /* JADX WARN: Code duplicated, block: B:159:0x026c  */
    /* JADX WARN: Code duplicated, block: B:174:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:189:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:204:0x031d  */
    /* JADX WARN: Code duplicated, block: B:219:0x0358  */
    /* JADX WARN: Code duplicated, block: B:234:0x0393  */
    /* JADX WARN: Code duplicated, block: B:249:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:264:0x0409  */
    /* JADX WARN: Code duplicated, block: B:279:0x0444  */
    /* JADX WARN: Code duplicated, block: B:294:0x047f  */
    /* JADX WARN: Code duplicated, block: B:309:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:324:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:339:0x0530  */
    /* JADX WARN: Code duplicated, block: B:354:0x056b  */
    /* JADX WARN: Code duplicated, block: B:369:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:384:0x05e0  */
    /* JADX WARN: Code duplicated, block: B:399:0x061b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0096  */
    /* JADX WARN: Code duplicated, block: B:414:0x0655  */
    /* JADX WARN: Code duplicated, block: B:429:0x068f  */
    /* JADX WARN: Code duplicated, block: B:444:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x010a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0145  */
    /* JADX WARN: Code duplicated, block: B:99:0x0180  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1;
        MusicService$onCreate$$inlined$map$10$1 musicService$onCreate$$inlined$map$10$1;
        MusicService$onCreate$$inlined$map$11$1 musicService$onCreate$$inlined$map$11$1;
        MusicService$onCreate$$inlined$map$12$1 musicService$onCreate$$inlined$map$12$1;
        MusicService$onCreate$$inlined$map$1$1 musicService$onCreate$$inlined$map$1$1;
        MusicService$onCreate$$inlined$map$2$1 musicService$onCreate$$inlined$map$2$1;
        MusicService$onCreate$$inlined$map$3$1 musicService$onCreate$$inlined$map$3$1;
        MusicService$onCreate$$inlined$map$4$1 musicService$onCreate$$inlined$map$4$1;
        MusicService$onCreate$$inlined$map$5$1 musicService$onCreate$$inlined$map$5$1;
        MusicService$onCreate$$inlined$map$6$1 musicService$onCreate$$inlined$map$6$1;
        MusicService$onCreate$$inlined$map$7$1 musicService$onCreate$$inlined$map$7$1;
        MusicService$onCreate$$inlined$map$8$1 musicService$onCreate$$inlined$map$8$1;
        MusicService$onCreate$$inlined$map$9$1 musicService$onCreate$$inlined$map$9$1;
        MusicService$onCreate$11$invokeSuspend$$inlined$map$1$1 musicService$onCreate$11$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1 musicService$onCreate$47$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$48$invokeSuspend$$inlined$map$1$1 musicService$onCreate$48$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$49$invokeSuspend$$inlined$map$1$1 musicService$onCreate$49$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$50$invokeSuspend$$inlined$map$1$1 musicService$onCreate$50$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$51$invokeSuspend$$inlined$map$1$1 musicService$onCreate$51$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$52$invokeSuspend$$inlined$map$1$1 musicService$onCreate$52$invokeSuspend$$inlined$map$1$1;
        MusicService$onCreate$53$invokeSuspend$$inlined$map$1$1 musicService$onCreate$53$invokeSuspend$$inlined$map$1$1;
        AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1 androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1;
        SyncUtils$isLoggedIn$$inlined$map$1$1 syncUtils$isLoggedIn$$inlined$map$1$1;
        AccountViewModel$4$invokeSuspend$$inlined$map$1$1 accountViewModel$4$invokeSuspend$$inlined$map$1$1;
        ArtistSongsViewModel$special$$inlined$map$1$1 artistSongsViewModel$special$$inlined$map$1$1;
        ArtistViewModel$1$invokeSuspend$$inlined$map$1$1 artistViewModel$1$invokeSuspend$$inlined$map$1$1;
        ArtistViewModel$special$$inlined$map$1$1 artistViewModel$special$$inlined$map$1$1;
        ArtistViewModel$special$$inlined$map$2$1 artistViewModel$special$$inlined$map$2$1;
        AutoPlaylistViewModel$special$$inlined$map$1$1 autoPlaylistViewModel$special$$inlined$map$1$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
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
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, (byte) 0);
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
                if (continuation instanceof MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1) {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1 = (MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1) continuation;
                    int i3 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1(this, continuation);
                }
                Object obj2 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1.result;
                int i4 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, (byte) 4);
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass3, mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof MusicService$onCreate$$inlined$map$10$1) {
                    musicService$onCreate$$inlined$map$10$1 = (MusicService$onCreate$$inlined$map$10$1) continuation;
                    int i5 = musicService$onCreate$$inlined$map$10$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$10$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$10$1 = new MusicService$onCreate$$inlined$map$10$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$10$1 = new MusicService$onCreate$$inlined$map$10$1(this, continuation);
                }
                Object obj3 = musicService$onCreate$$inlined$map$10$1.result;
                int i6 = musicService$onCreate$$inlined$map$10$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, (byte) 6);
                    musicService$onCreate$$inlined$map$10$1.label = 1;
                    return flow.collect(anonymousClass4, musicService$onCreate$$inlined$map$10$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof MusicService$onCreate$$inlined$map$11$1) {
                    musicService$onCreate$$inlined$map$11$1 = (MusicService$onCreate$$inlined$map$11$1) continuation;
                    int i7 = musicService$onCreate$$inlined$map$11$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$11$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$11$1 = new MusicService$onCreate$$inlined$map$11$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$11$1 = new MusicService$onCreate$$inlined$map$11$1(this, continuation);
                }
                Object obj4 = musicService$onCreate$$inlined$map$11$1.result;
                int i8 = musicService$onCreate$$inlined$map$11$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, (byte) 7);
                    musicService$onCreate$$inlined$map$11$1.label = 1;
                    return flow.collect(anonymousClass5, musicService$onCreate$$inlined$map$11$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof MusicService$onCreate$$inlined$map$12$1) {
                    musicService$onCreate$$inlined$map$12$1 = (MusicService$onCreate$$inlined$map$12$1) continuation;
                    int i9 = musicService$onCreate$$inlined$map$12$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$12$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$12$1 = new MusicService$onCreate$$inlined$map$12$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$12$1 = new MusicService$onCreate$$inlined$map$12$1(this, continuation);
                }
                Object obj5 = musicService$onCreate$$inlined$map$12$1.result;
                int i10 = musicService$onCreate$$inlined$map$12$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, (byte) 8);
                    musicService$onCreate$$inlined$map$12$1.label = 1;
                    return flow.collect(anonymousClass6, musicService$onCreate$$inlined$map$12$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof MusicService$onCreate$$inlined$map$1$1) {
                    musicService$onCreate$$inlined$map$1$1 = (MusicService$onCreate$$inlined$map$1$1) continuation;
                    int i11 = musicService$onCreate$$inlined$map$1$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$1$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$1$1 = new MusicService$onCreate$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$1$1 = new MusicService$onCreate$$inlined$map$1$1(this, continuation);
                }
                Object obj6 = musicService$onCreate$$inlined$map$1$1.result;
                int i12 = musicService$onCreate$$inlined$map$1$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, (byte) 5);
                    musicService$onCreate$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass7, musicService$onCreate$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof MusicService$onCreate$$inlined$map$2$1) {
                    musicService$onCreate$$inlined$map$2$1 = (MusicService$onCreate$$inlined$map$2$1) continuation;
                    int i13 = musicService$onCreate$$inlined$map$2$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$2$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$2$1 = new MusicService$onCreate$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$2$1 = new MusicService$onCreate$$inlined$map$2$1(this, continuation);
                }
                Object obj7 = musicService$onCreate$$inlined$map$2$1.result;
                int i14 = musicService$onCreate$$inlined$map$2$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, (byte) 9);
                    musicService$onCreate$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass8, musicService$onCreate$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof MusicService$onCreate$$inlined$map$3$1) {
                    musicService$onCreate$$inlined$map$3$1 = (MusicService$onCreate$$inlined$map$3$1) continuation;
                    int i15 = musicService$onCreate$$inlined$map$3$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$3$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$3$1 = new MusicService$onCreate$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$3$1 = new MusicService$onCreate$$inlined$map$3$1(this, continuation);
                }
                Object obj8 = musicService$onCreate$$inlined$map$3$1.result;
                int i16 = musicService$onCreate$$inlined$map$3$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, (byte) 10);
                    musicService$onCreate$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass9, musicService$onCreate$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof MusicService$onCreate$$inlined$map$4$1) {
                    musicService$onCreate$$inlined$map$4$1 = (MusicService$onCreate$$inlined$map$4$1) continuation;
                    int i17 = musicService$onCreate$$inlined$map$4$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$4$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$4$1 = new MusicService$onCreate$$inlined$map$4$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$4$1 = new MusicService$onCreate$$inlined$map$4$1(this, continuation);
                }
                Object obj9 = musicService$onCreate$$inlined$map$4$1.result;
                int i18 = musicService$onCreate$$inlined$map$4$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, (byte) 11);
                    musicService$onCreate$$inlined$map$4$1.label = 1;
                    return flow.collect(anonymousClass10, musicService$onCreate$$inlined$map$4$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                if (continuation instanceof MusicService$onCreate$$inlined$map$5$1) {
                    musicService$onCreate$$inlined$map$5$1 = (MusicService$onCreate$$inlined$map$5$1) continuation;
                    int i19 = musicService$onCreate$$inlined$map$5$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$5$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$5$1 = new MusicService$onCreate$$inlined$map$5$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$5$1 = new MusicService$onCreate$$inlined$map$5$1(this, continuation);
                }
                Object obj10 = musicService$onCreate$$inlined$map$5$1.result;
                int i20 = musicService$onCreate$$inlined$map$5$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, (byte) 12);
                    musicService$onCreate$$inlined$map$5$1.label = 1;
                    return flow.collect(anonymousClass11, musicService$onCreate$$inlined$map$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 10:
                if (continuation instanceof MusicService$onCreate$$inlined$map$6$1) {
                    musicService$onCreate$$inlined$map$6$1 = (MusicService$onCreate$$inlined$map$6$1) continuation;
                    int i21 = musicService$onCreate$$inlined$map$6$1.label;
                    if ((i21 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$6$1.label = i21 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$6$1 = new MusicService$onCreate$$inlined$map$6$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$6$1 = new MusicService$onCreate$$inlined$map$6$1(this, continuation);
                }
                Object obj11 = musicService$onCreate$$inlined$map$6$1.result;
                int i22 = musicService$onCreate$$inlined$map$6$1.label;
                if (i22 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2(flowCollector, (byte) 13);
                    musicService$onCreate$$inlined$map$6$1.label = 1;
                    return flow.collect(anonymousClass12, musicService$onCreate$$inlined$map$6$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i22 == 1) {
                    ResultKt.throwOnFailure(obj11);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                if (continuation instanceof MusicService$onCreate$$inlined$map$7$1) {
                    musicService$onCreate$$inlined$map$7$1 = (MusicService$onCreate$$inlined$map$7$1) continuation;
                    int i23 = musicService$onCreate$$inlined$map$7$1.label;
                    if ((i23 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$7$1.label = i23 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$7$1 = new MusicService$onCreate$$inlined$map$7$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$7$1 = new MusicService$onCreate$$inlined$map$7$1(this, continuation);
                }
                Object obj12 = musicService$onCreate$$inlined$map$7$1.result;
                int i24 = musicService$onCreate$$inlined$map$7$1.label;
                if (i24 == 0) {
                    ResultKt.throwOnFailure(obj12);
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2(flowCollector, (byte) 14);
                    musicService$onCreate$$inlined$map$7$1.label = 1;
                    return flow.collect(anonymousClass13, musicService$onCreate$$inlined$map$7$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i24 == 1) {
                    ResultKt.throwOnFailure(obj12);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof MusicService$onCreate$$inlined$map$8$1) {
                    musicService$onCreate$$inlined$map$8$1 = (MusicService$onCreate$$inlined$map$8$1) continuation;
                    int i25 = musicService$onCreate$$inlined$map$8$1.label;
                    if ((i25 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$8$1.label = i25 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$8$1 = new MusicService$onCreate$$inlined$map$8$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$8$1 = new MusicService$onCreate$$inlined$map$8$1(this, continuation);
                }
                Object obj13 = musicService$onCreate$$inlined$map$8$1.result;
                int i26 = musicService$onCreate$$inlined$map$8$1.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj13);
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2(flowCollector, (byte) 15);
                    musicService$onCreate$$inlined$map$8$1.label = 1;
                    return flow.collect(anonymousClass14, musicService$onCreate$$inlined$map$8$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i26 == 1) {
                    ResultKt.throwOnFailure(obj13);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 13:
                if (continuation instanceof MusicService$onCreate$$inlined$map$9$1) {
                    musicService$onCreate$$inlined$map$9$1 = (MusicService$onCreate$$inlined$map$9$1) continuation;
                    int i27 = musicService$onCreate$$inlined$map$9$1.label;
                    if ((i27 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$$inlined$map$9$1.label = i27 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$$inlined$map$9$1 = new MusicService$onCreate$$inlined$map$9$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$$inlined$map$9$1 = new MusicService$onCreate$$inlined$map$9$1(this, continuation);
                }
                Object obj14 = musicService$onCreate$$inlined$map$9$1.result;
                int i28 = musicService$onCreate$$inlined$map$9$1.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj14);
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2(flowCollector, (byte) 16);
                    musicService$onCreate$$inlined$map$9$1.label = 1;
                    return flow.collect(anonymousClass15, musicService$onCreate$$inlined$map$9$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i28 == 1) {
                    ResultKt.throwOnFailure(obj14);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                if (continuation instanceof MusicService$onCreate$11$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$11$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$11$invokeSuspend$$inlined$map$1$1) continuation;
                    int i29 = musicService$onCreate$11$invokeSuspend$$inlined$map$1$1.label;
                    if ((i29 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$11$invokeSuspend$$inlined$map$1$1.label = i29 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$11$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$11$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$11$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$11$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj15 = musicService$onCreate$11$invokeSuspend$$inlined$map$1$1.result;
                int i30 = musicService$onCreate$11$invokeSuspend$$inlined$map$1$1.label;
                if (i30 == 0) {
                    ResultKt.throwOnFailure(obj15);
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2(flowCollector, (byte) 17);
                    musicService$onCreate$11$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass16, musicService$onCreate$11$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i30 == 1) {
                    ResultKt.throwOnFailure(obj15);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 15:
                if (continuation instanceof MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$47$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1) continuation;
                    int i31 = musicService$onCreate$47$invokeSuspend$$inlined$map$1$1.label;
                    if ((i31 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$47$invokeSuspend$$inlined$map$1$1.label = i31 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$47$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$47$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$47$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj16 = musicService$onCreate$47$invokeSuspend$$inlined$map$1$1.result;
                int i32 = musicService$onCreate$47$invokeSuspend$$inlined$map$1$1.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj16);
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2(flowCollector, (byte) 18);
                    musicService$onCreate$47$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass17, musicService$onCreate$47$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i32 == 1) {
                    ResultKt.throwOnFailure(obj16);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 16:
                if (continuation instanceof MusicService$onCreate$48$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$48$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$48$invokeSuspend$$inlined$map$1$1) continuation;
                    int i33 = musicService$onCreate$48$invokeSuspend$$inlined$map$1$1.label;
                    if ((i33 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$48$invokeSuspend$$inlined$map$1$1.label = i33 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$48$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$48$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$48$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$48$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj17 = musicService$onCreate$48$invokeSuspend$$inlined$map$1$1.result;
                int i34 = musicService$onCreate$48$invokeSuspend$$inlined$map$1$1.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj17);
                    AnonymousClass2 anonymousClass18 = new AnonymousClass2(flowCollector, (byte) 19);
                    musicService$onCreate$48$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass18, musicService$onCreate$48$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i34 == 1) {
                    ResultKt.throwOnFailure(obj17);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 17:
                if (continuation instanceof MusicService$onCreate$49$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$49$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$49$invokeSuspend$$inlined$map$1$1) continuation;
                    int i35 = musicService$onCreate$49$invokeSuspend$$inlined$map$1$1.label;
                    if ((i35 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$49$invokeSuspend$$inlined$map$1$1.label = i35 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$49$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$49$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$49$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$49$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj18 = musicService$onCreate$49$invokeSuspend$$inlined$map$1$1.result;
                int i36 = musicService$onCreate$49$invokeSuspend$$inlined$map$1$1.label;
                if (i36 == 0) {
                    ResultKt.throwOnFailure(obj18);
                    AnonymousClass2 anonymousClass19 = new AnonymousClass2(flowCollector, (byte) 20);
                    musicService$onCreate$49$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass19, musicService$onCreate$49$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i36 == 1) {
                    ResultKt.throwOnFailure(obj18);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 18:
                if (continuation instanceof MusicService$onCreate$50$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$50$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$50$invokeSuspend$$inlined$map$1$1) continuation;
                    int i37 = musicService$onCreate$50$invokeSuspend$$inlined$map$1$1.label;
                    if ((i37 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$50$invokeSuspend$$inlined$map$1$1.label = i37 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$50$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$50$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$50$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$50$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj19 = musicService$onCreate$50$invokeSuspend$$inlined$map$1$1.result;
                int i38 = musicService$onCreate$50$invokeSuspend$$inlined$map$1$1.label;
                if (i38 == 0) {
                    ResultKt.throwOnFailure(obj19);
                    AnonymousClass2 anonymousClass20 = new AnonymousClass2(flowCollector, (byte) 21);
                    musicService$onCreate$50$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass20, musicService$onCreate$50$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i38 == 1) {
                    ResultKt.throwOnFailure(obj19);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 19:
                if (continuation instanceof MusicService$onCreate$51$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$51$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$51$invokeSuspend$$inlined$map$1$1) continuation;
                    int i39 = musicService$onCreate$51$invokeSuspend$$inlined$map$1$1.label;
                    if ((i39 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$51$invokeSuspend$$inlined$map$1$1.label = i39 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$51$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$51$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$51$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$51$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj20 = musicService$onCreate$51$invokeSuspend$$inlined$map$1$1.result;
                int i40 = musicService$onCreate$51$invokeSuspend$$inlined$map$1$1.label;
                if (i40 == 0) {
                    ResultKt.throwOnFailure(obj20);
                    AnonymousClass2 anonymousClass21 = new AnonymousClass2(flowCollector, (byte) 22);
                    musicService$onCreate$51$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass21, musicService$onCreate$51$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i40 == 1) {
                    ResultKt.throwOnFailure(obj20);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 20:
                if (continuation instanceof MusicService$onCreate$52$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$52$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$52$invokeSuspend$$inlined$map$1$1) continuation;
                    int i41 = musicService$onCreate$52$invokeSuspend$$inlined$map$1$1.label;
                    if ((i41 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$52$invokeSuspend$$inlined$map$1$1.label = i41 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$52$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$52$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$52$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$52$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj21 = musicService$onCreate$52$invokeSuspend$$inlined$map$1$1.result;
                int i42 = musicService$onCreate$52$invokeSuspend$$inlined$map$1$1.label;
                if (i42 == 0) {
                    ResultKt.throwOnFailure(obj21);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(flowCollector, (byte) 23);
                    musicService$onCreate$52$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass22, musicService$onCreate$52$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i42 == 1) {
                    ResultKt.throwOnFailure(obj21);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 21:
                if (continuation instanceof MusicService$onCreate$53$invokeSuspend$$inlined$map$1$1) {
                    musicService$onCreate$53$invokeSuspend$$inlined$map$1$1 = (MusicService$onCreate$53$invokeSuspend$$inlined$map$1$1) continuation;
                    int i43 = musicService$onCreate$53$invokeSuspend$$inlined$map$1$1.label;
                    if ((i43 & Integer.MIN_VALUE) != 0) {
                        musicService$onCreate$53$invokeSuspend$$inlined$map$1$1.label = i43 - Integer.MIN_VALUE;
                    } else {
                        musicService$onCreate$53$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$53$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    musicService$onCreate$53$invokeSuspend$$inlined$map$1$1 = new MusicService$onCreate$53$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj22 = musicService$onCreate$53$invokeSuspend$$inlined$map$1$1.result;
                int i44 = musicService$onCreate$53$invokeSuspend$$inlined$map$1$1.label;
                if (i44 == 0) {
                    ResultKt.throwOnFailure(obj22);
                    AnonymousClass2 anonymousClass23 = new AnonymousClass2(flowCollector, (byte) 24);
                    musicService$onCreate$53$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass23, musicService$onCreate$53$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i44 == 1) {
                    ResultKt.throwOnFailure(obj22);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 22:
                if (continuation instanceof AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1) {
                    androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1 = (AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1) continuation;
                    int i45 = androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1.label;
                    if ((i45 & Integer.MIN_VALUE) != 0) {
                        androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1.label = i45 - Integer.MIN_VALUE;
                    } else {
                        androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1 = new AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1 = new AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1(this, continuation);
                }
                Object obj23 = androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1.result;
                int i46 = androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1.label;
                if (i46 == 0) {
                    ResultKt.throwOnFailure(obj23);
                    AnonymousClass2 anonymousClass24 = new AnonymousClass2(flowCollector, (byte) 25);
                    androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass24, androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i46 == 1) {
                    ResultKt.throwOnFailure(obj23);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 23:
                if (continuation instanceof SyncUtils$isLoggedIn$$inlined$map$1$1) {
                    syncUtils$isLoggedIn$$inlined$map$1$1 = (SyncUtils$isLoggedIn$$inlined$map$1$1) continuation;
                    int i47 = syncUtils$isLoggedIn$$inlined$map$1$1.label;
                    if ((i47 & Integer.MIN_VALUE) != 0) {
                        syncUtils$isLoggedIn$$inlined$map$1$1.label = i47 - Integer.MIN_VALUE;
                    } else {
                        syncUtils$isLoggedIn$$inlined$map$1$1 = new SyncUtils$isLoggedIn$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    syncUtils$isLoggedIn$$inlined$map$1$1 = new SyncUtils$isLoggedIn$$inlined$map$1$1(this, continuation);
                }
                Object obj24 = syncUtils$isLoggedIn$$inlined$map$1$1.result;
                int i48 = syncUtils$isLoggedIn$$inlined$map$1$1.label;
                if (i48 == 0) {
                    ResultKt.throwOnFailure(obj24);
                    AnonymousClass2 anonymousClass25 = new AnonymousClass2(flowCollector, (byte) 26);
                    syncUtils$isLoggedIn$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass25, syncUtils$isLoggedIn$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i48 == 1) {
                    ResultKt.throwOnFailure(obj24);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 24:
                if (continuation instanceof AccountViewModel$4$invokeSuspend$$inlined$map$1$1) {
                    accountViewModel$4$invokeSuspend$$inlined$map$1$1 = (AccountViewModel$4$invokeSuspend$$inlined$map$1$1) continuation;
                    int i49 = accountViewModel$4$invokeSuspend$$inlined$map$1$1.label;
                    if ((i49 & Integer.MIN_VALUE) != 0) {
                        accountViewModel$4$invokeSuspend$$inlined$map$1$1.label = i49 - Integer.MIN_VALUE;
                    } else {
                        accountViewModel$4$invokeSuspend$$inlined$map$1$1 = new AccountViewModel$4$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    accountViewModel$4$invokeSuspend$$inlined$map$1$1 = new AccountViewModel$4$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj25 = accountViewModel$4$invokeSuspend$$inlined$map$1$1.result;
                int i50 = accountViewModel$4$invokeSuspend$$inlined$map$1$1.label;
                if (i50 == 0) {
                    ResultKt.throwOnFailure(obj25);
                    AnonymousClass2 anonymousClass26 = new AnonymousClass2(flowCollector, (byte) 27);
                    accountViewModel$4$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass26, accountViewModel$4$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i50 == 1) {
                    ResultKt.throwOnFailure(obj25);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 25:
                if (continuation instanceof ArtistSongsViewModel$special$$inlined$map$1$1) {
                    artistSongsViewModel$special$$inlined$map$1$1 = (ArtistSongsViewModel$special$$inlined$map$1$1) continuation;
                    int i51 = artistSongsViewModel$special$$inlined$map$1$1.label;
                    if ((i51 & Integer.MIN_VALUE) != 0) {
                        artistSongsViewModel$special$$inlined$map$1$1.label = i51 - Integer.MIN_VALUE;
                    } else {
                        artistSongsViewModel$special$$inlined$map$1$1 = new ArtistSongsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    artistSongsViewModel$special$$inlined$map$1$1 = new ArtistSongsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj26 = artistSongsViewModel$special$$inlined$map$1$1.result;
                int i52 = artistSongsViewModel$special$$inlined$map$1$1.label;
                if (i52 == 0) {
                    ResultKt.throwOnFailure(obj26);
                    AnonymousClass2 anonymousClass27 = new AnonymousClass2(flowCollector, (byte) 28);
                    artistSongsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass27, artistSongsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i52 == 1) {
                    ResultKt.throwOnFailure(obj26);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 26:
                if (continuation instanceof ArtistViewModel$1$invokeSuspend$$inlined$map$1$1) {
                    artistViewModel$1$invokeSuspend$$inlined$map$1$1 = (ArtistViewModel$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i53 = artistViewModel$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i53 & Integer.MIN_VALUE) != 0) {
                        artistViewModel$1$invokeSuspend$$inlined$map$1$1.label = i53 - Integer.MIN_VALUE;
                    } else {
                        artistViewModel$1$invokeSuspend$$inlined$map$1$1 = new ArtistViewModel$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    artistViewModel$1$invokeSuspend$$inlined$map$1$1 = new ArtistViewModel$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj27 = artistViewModel$1$invokeSuspend$$inlined$map$1$1.result;
                int i54 = artistViewModel$1$invokeSuspend$$inlined$map$1$1.label;
                if (i54 == 0) {
                    ResultKt.throwOnFailure(obj27);
                    AnonymousClass2 anonymousClass28 = new AnonymousClass2(flowCollector, (byte) 29);
                    artistViewModel$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass28, artistViewModel$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i54 == 1) {
                    ResultKt.throwOnFailure(obj27);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 27:
                if (continuation instanceof ArtistViewModel$special$$inlined$map$1$1) {
                    artistViewModel$special$$inlined$map$1$1 = (ArtistViewModel$special$$inlined$map$1$1) continuation;
                    int i55 = artistViewModel$special$$inlined$map$1$1.label;
                    if ((i55 & Integer.MIN_VALUE) != 0) {
                        artistViewModel$special$$inlined$map$1$1.label = i55 - Integer.MIN_VALUE;
                    } else {
                        artistViewModel$special$$inlined$map$1$1 = new ArtistViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    artistViewModel$special$$inlined$map$1$1 = new ArtistViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj28 = artistViewModel$special$$inlined$map$1$1.result;
                int i56 = artistViewModel$special$$inlined$map$1$1.label;
                if (i56 == 0) {
                    ResultKt.throwOnFailure(obj28);
                    HomeViewModel$special$$inlined$map$1.AnonymousClass2 anonymousClass29 = new HomeViewModel$special$$inlined$map$1.AnonymousClass2(flowCollector, b2);
                    artistViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass29, artistViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i56 == 1) {
                    ResultKt.throwOnFailure(obj28);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 28:
                if (continuation instanceof ArtistViewModel$special$$inlined$map$2$1) {
                    artistViewModel$special$$inlined$map$2$1 = (ArtistViewModel$special$$inlined$map$2$1) continuation;
                    int i57 = artistViewModel$special$$inlined$map$2$1.label;
                    if ((i57 & Integer.MIN_VALUE) != 0) {
                        artistViewModel$special$$inlined$map$2$1.label = i57 - Integer.MIN_VALUE;
                    } else {
                        artistViewModel$special$$inlined$map$2$1 = new ArtistViewModel$special$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    artistViewModel$special$$inlined$map$2$1 = new ArtistViewModel$special$$inlined$map$2$1(this, continuation);
                }
                Object obj29 = artistViewModel$special$$inlined$map$2$1.result;
                int i58 = artistViewModel$special$$inlined$map$2$1.label;
                if (i58 == 0) {
                    ResultKt.throwOnFailure(obj29);
                    HomeViewModel$special$$inlined$map$1.AnonymousClass2 anonymousClass30 = new HomeViewModel$special$$inlined$map$1.AnonymousClass2(flowCollector, (byte) 2);
                    artistViewModel$special$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass30, artistViewModel$special$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i58 == 1) {
                    ResultKt.throwOnFailure(obj29);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof AutoPlaylistViewModel$special$$inlined$map$1$1) {
                    autoPlaylistViewModel$special$$inlined$map$1$1 = (AutoPlaylistViewModel$special$$inlined$map$1$1) continuation;
                    int i59 = autoPlaylistViewModel$special$$inlined$map$1$1.label;
                    if ((i59 & Integer.MIN_VALUE) != 0) {
                        autoPlaylistViewModel$special$$inlined$map$1$1.label = i59 - Integer.MIN_VALUE;
                    } else {
                        autoPlaylistViewModel$special$$inlined$map$1$1 = new AutoPlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    autoPlaylistViewModel$special$$inlined$map$1$1 = new AutoPlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj30 = autoPlaylistViewModel$special$$inlined$map$1$1.result;
                int i60 = autoPlaylistViewModel$special$$inlined$map$1$1.label;
                if (i60 == 0) {
                    ResultKt.throwOnFailure(obj30);
                    HomeViewModel$special$$inlined$map$1.AnonymousClass2 anonymousClass31 = new HomeViewModel$special$$inlined$map$1.AnonymousClass2(flowCollector, (byte) 3);
                    autoPlaylistViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass31, autoPlaylistViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i60 == 1) {
                    ResultKt.throwOnFailure(obj30);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$special$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$special$$inlined$map$1$2$1, reason: invalid class name */
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

        public /* synthetic */ AnonymousClass2(FlowCollector flowCollector, byte b) {
            this.$r8$classId = b;
            this.$this_unsafeFlow = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:117:0x01ff  */
        /* JADX WARN: Code duplicated, block: B:136:0x0249  */
        /* JADX WARN: Code duplicated, block: B:154:0x0291  */
        /* JADX WARN: Code duplicated, block: B:172:0x02d9  */
        /* JADX WARN: Code duplicated, block: B:190:0x0321  */
        /* JADX WARN: Code duplicated, block: B:208:0x0369  */
        /* JADX WARN: Code duplicated, block: B:227:0x03b3  */
        /* JADX WARN: Code duplicated, block: B:246:0x03fd  */
        /* JADX WARN: Code duplicated, block: B:265:0x0455  */
        /* JADX WARN: Code duplicated, block: B:275:0x0472  */
        /* JADX WARN: Code duplicated, block: B:293:0x04ba  */
        /* JADX WARN: Code duplicated, block: B:312:0x0504  */
        /* JADX WARN: Code duplicated, block: B:331:0x054e  */
        /* JADX WARN: Code duplicated, block: B:349:0x0596  */
        /* JADX WARN: Code duplicated, block: B:35:0x009a  */
        /* JADX WARN: Code duplicated, block: B:367:0x05de  */
        /* JADX WARN: Code duplicated, block: B:386:0x0625  */
        /* JADX WARN: Code duplicated, block: B:405:0x066f  */
        /* JADX WARN: Code duplicated, block: B:427:0x06d0  */
        /* JADX WARN: Code duplicated, block: B:453:0x0747  */
        /* JADX WARN: Code duplicated, block: B:480:0x07c4  */
        /* JADX WARN: Code duplicated, block: B:498:0x080c  */
        /* JADX WARN: Code duplicated, block: B:516:0x0854  */
        /* JADX WARN: Code duplicated, block: B:535:0x08a9  */
        /* JADX WARN: Code duplicated, block: B:550:0x08e3  */
        /* JADX WARN: Code duplicated, block: B:565:0x091d  */
        /* JADX WARN: Code duplicated, block: B:584:0x0967  */
        /* JADX WARN: Code duplicated, block: B:65:0x0126  */
        /* JADX WARN: Code duplicated, block: B:83:0x016e  */
        /* JADX WARN: Code duplicated, block: B:98:0x01aa  */
        /* JADX WARN: Code duplicated, block: B:9:0x0025  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1 listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1;
            LyricsHelper$getLyrics$$inlined$map$1$2$1 lyricsHelper$getLyrics$$inlined$map$1$2$1;
            LyricsHelper$special$$inlined$map$1$2$1 lyricsHelper$special$$inlined$map$1$2$1;
            MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1;
            MusicService$onCreate$$inlined$map$1$2$1 musicService$onCreate$$inlined$map$1$2$1;
            MusicService$onCreate$$inlined$map$10$2$1 musicService$onCreate$$inlined$map$10$2$1;
            MusicService$onCreate$$inlined$map$11$2$1 musicService$onCreate$$inlined$map$11$2$1;
            MusicService$onCreate$$inlined$map$12$2$1 musicService$onCreate$$inlined$map$12$2$1;
            MusicService$onCreate$$inlined$map$2$2$1 musicService$onCreate$$inlined$map$2$2$1;
            MusicService$onCreate$$inlined$map$3$2$1 musicService$onCreate$$inlined$map$3$2$1;
            MusicService$onCreate$$inlined$map$4$2$1 musicService$onCreate$$inlined$map$4$2$1;
            MusicService$onCreate$$inlined$map$5$2$1 musicService$onCreate$$inlined$map$5$2$1;
            MusicService$onCreate$$inlined$map$6$2$1 musicService$onCreate$$inlined$map$6$2$1;
            MusicService$onCreate$$inlined$map$7$2$1 musicService$onCreate$$inlined$map$7$2$1;
            MusicService$onCreate$$inlined$map$8$2$1 musicService$onCreate$$inlined$map$8$2$1;
            MusicService$onCreate$$inlined$map$9$2$1 musicService$onCreate$$inlined$map$9$2$1;
            MusicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1;
            AudioQuality audioQuality;
            MusicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1;
            MusicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1;
            MusicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1;
            MusicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1;
            MusicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1;
            MusicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1;
            MusicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1 musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1;
            AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1 androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1;
            SyncUtils$isLoggedIn$$inlined$map$1$2$1 syncUtils$isLoggedIn$$inlined$map$1$2$1;
            AccountViewModel$4$invokeSuspend$$inlined$map$1$2$1 accountViewModel$4$invokeSuspend$$inlined$map$1$2$1;
            ArtistSongsViewModel$special$$inlined$map$1$2$1 artistSongsViewModel$special$$inlined$map$1$2$1;
            ArtistViewModel$1$invokeSuspend$$inlined$map$1$2$1 artistViewModel$1$invokeSuspend$$inlined$map$1$2$1;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            FlowCollector flowCollector = this.$this_unsafeFlow;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Object obj2 = null;
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
                    Object obj3 = anonymousClass1.result;
                    int i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            ResultKt.throwOnFailure(obj3);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj3);
                    Boolean bool = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.LastFMUseSendLikes);
                    Boolean boolValueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
                    anonymousClass1.label = 1;
                    return flowCollector.emit(boolValueOf, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    if (continuation instanceof ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1) {
                        listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1 = (ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i3 = listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1 = new ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1 = new ListenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj4 = listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i4 = listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            ResultKt.throwOnFailure(obj4);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj4);
                    Boolean bool2 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.ListenTogetherSyncVolumeKey);
                    Boolean boolValueOf2 = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : true);
                    listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf2, listenTogetherManager$observePreferences$1$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    if (continuation instanceof LyricsHelper$getLyrics$$inlined$map$1$2$1) {
                        lyricsHelper$getLyrics$$inlined$map$1$2$1 = (LyricsHelper$getLyrics$$inlined$map$1$2$1) continuation;
                        int i5 = lyricsHelper$getLyrics$$inlined$map$1$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            lyricsHelper$getLyrics$$inlined$map$1$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            lyricsHelper$getLyrics$$inlined$map$1$2$1 = new LyricsHelper$getLyrics$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        lyricsHelper$getLyrics$$inlined$map$1$2$1 = new LyricsHelper$getLyrics$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj5 = lyricsHelper$getLyrics$$inlined$map$1$2$1.result;
                    int i6 = lyricsHelper$getLyrics$$inlined$map$1$2$1.label;
                    if (i6 == 0) {
                        ResultKt.throwOnFailure(obj5);
                        ArrayList arrayListResolveLyricsProviders = ImageLoader$Builder.resolveLyricsProviders((MutablePreferences) obj);
                        lyricsHelper$getLyrics$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(arrayListResolveLyricsProviders, lyricsHelper$getLyrics$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i6 == 1) {
                        ResultKt.throwOnFailure(obj5);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    if (continuation instanceof LyricsHelper$special$$inlined$map$1$2$1) {
                        lyricsHelper$special$$inlined$map$1$2$1 = (LyricsHelper$special$$inlined$map$1$2$1) continuation;
                        int i7 = lyricsHelper$special$$inlined$map$1$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            lyricsHelper$special$$inlined$map$1$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            lyricsHelper$special$$inlined$map$1$2$1 = new LyricsHelper$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        lyricsHelper$special$$inlined$map$1$2$1 = new LyricsHelper$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj6 = lyricsHelper$special$$inlined$map$1$2$1.result;
                    int i8 = lyricsHelper$special$$inlined$map$1$2$1.label;
                    if (i8 == 0) {
                        ResultKt.throwOnFailure(obj6);
                        ArrayList arrayListResolveLyricsProviders2 = ImageLoader$Builder.resolveLyricsProviders((MutablePreferences) obj);
                        lyricsHelper$special$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(arrayListResolveLyricsProviders2, lyricsHelper$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i8 == 1) {
                        ResultKt.throwOnFailure(obj6);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    if (continuation instanceof MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1) {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1 = (MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1) continuation;
                        int i9 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj7 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1.result;
                    int i10 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            ResultKt.throwOnFailure(obj7);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj7);
                    List list = (List) obj;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((PlaylistSong) it.next()).song);
                    }
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1.label = 1;
                    return flowCollector.emit(arrayList, mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$1$2$1) {
                        musicService$onCreate$$inlined$map$1$2$1 = (MusicService$onCreate$$inlined$map$1$2$1) continuation;
                        int i11 = musicService$onCreate$$inlined$map$1$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$1$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$1$2$1 = new MusicService$onCreate$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$1$2$1 = new MusicService$onCreate$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj8 = musicService$onCreate$$inlined$map$1$2$1.result;
                    int i12 = musicService$onCreate$$inlined$map$1$2$1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            ResultKt.throwOnFailure(obj8);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj8);
                    Boolean bool3 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.ShowLyricsKey);
                    Boolean boolValueOf3 = Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false);
                    musicService$onCreate$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf3, musicService$onCreate$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 6:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$10$2$1) {
                        musicService$onCreate$$inlined$map$10$2$1 = (MusicService$onCreate$$inlined$map$10$2$1) continuation;
                        int i13 = musicService$onCreate$$inlined$map$10$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$10$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$10$2$1 = new MusicService$onCreate$$inlined$map$10$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$10$2$1 = new MusicService$onCreate$$inlined$map$10$2$1(this, continuation);
                    }
                    Object obj9 = musicService$onCreate$$inlined$map$10$2$1.result;
                    int i14 = musicService$onCreate$$inlined$map$10$2$1.label;
                    if (i14 != 0) {
                        if (i14 == 1) {
                            ResultKt.throwOnFailure(obj9);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj9);
                    Boolean bool4 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.LastFMUseNowPlaying);
                    Boolean boolValueOf4 = Boolean.valueOf(bool4 != null ? bool4.booleanValue() : false);
                    musicService$onCreate$$inlined$map$10$2$1.label = 1;
                    return flowCollector.emit(boolValueOf4, musicService$onCreate$$inlined$map$10$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$11$2$1) {
                        musicService$onCreate$$inlined$map$11$2$1 = (MusicService$onCreate$$inlined$map$11$2$1) continuation;
                        int i15 = musicService$onCreate$$inlined$map$11$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$11$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$11$2$1 = new MusicService$onCreate$$inlined$map$11$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$11$2$1 = new MusicService$onCreate$$inlined$map$11$2$1(this, continuation);
                    }
                    Object obj10 = musicService$onCreate$$inlined$map$11$2$1.result;
                    int i16 = musicService$onCreate$$inlined$map$11$2$1.label;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            ResultKt.throwOnFailure(obj10);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj10);
                    MutablePreferences mutablePreferences = (MutablePreferences) obj;
                    Float f = (Float) mutablePreferences.get(PreferenceKeysKt.ScrobbleDelayPercentKey);
                    Float f2 = new Float(f != null ? f.floatValue() : 0.5f);
                    Integer num = (Integer) mutablePreferences.get(PreferenceKeysKt.ScrobbleMinSongDurationKey);
                    Integer num2 = new Integer(num != null ? num.intValue() : 30);
                    Integer num3 = (Integer) mutablePreferences.get(PreferenceKeysKt.ScrobbleDelaySecondsKey);
                    Triple triple = new Triple(f2, num2, new Integer(num3 != null ? num3.intValue() : 180));
                    musicService$onCreate$$inlined$map$11$2$1.label = 1;
                    return flowCollector.emit(triple, musicService$onCreate$$inlined$map$11$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$12$2$1) {
                        musicService$onCreate$$inlined$map$12$2$1 = (MusicService$onCreate$$inlined$map$12$2$1) continuation;
                        int i17 = musicService$onCreate$$inlined$map$12$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$12$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$12$2$1 = new MusicService$onCreate$$inlined$map$12$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$12$2$1 = new MusicService$onCreate$$inlined$map$12$2$1(this, continuation);
                    }
                    Object obj11 = musicService$onCreate$$inlined$map$12$2$1.result;
                    int i18 = musicService$onCreate$$inlined$map$12$2$1.label;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            ResultKt.throwOnFailure(obj11);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj11);
                    MutablePreferences mutablePreferences2 = (MutablePreferences) obj;
                    Boolean bool5 = (Boolean) mutablePreferences2.get(PreferenceKeysKt.CrossfadeEnabledKey);
                    Boolean boolValueOf5 = Boolean.valueOf(bool5 != null ? bool5.booleanValue() : false);
                    Float f3 = (Float) mutablePreferences2.get(PreferenceKeysKt.CrossfadeDurationKey);
                    Float f4 = new Float(f3 != null ? f3.floatValue() : 5.0f);
                    Boolean bool6 = (Boolean) mutablePreferences2.get(PreferenceKeysKt.CrossfadeGaplessKey);
                    Triple triple2 = new Triple(boolValueOf5, f4, Boolean.valueOf(bool6 != null ? bool6.booleanValue() : true));
                    musicService$onCreate$$inlined$map$12$2$1.label = 1;
                    return flowCollector.emit(triple2, musicService$onCreate$$inlined$map$12$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 9:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$2$2$1) {
                        musicService$onCreate$$inlined$map$2$2$1 = (MusicService$onCreate$$inlined$map$2$2$1) continuation;
                        int i19 = musicService$onCreate$$inlined$map$2$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$2$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$2$2$1 = new MusicService$onCreate$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$2$2$1 = new MusicService$onCreate$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj12 = musicService$onCreate$$inlined$map$2$2$1.result;
                    int i20 = musicService$onCreate$$inlined$map$2$2$1.label;
                    if (i20 != 0) {
                        if (i20 == 1) {
                            ResultKt.throwOnFailure(obj12);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj12);
                    MutablePreferences mutablePreferences3 = (MutablePreferences) obj;
                    Boolean bool7 = (Boolean) mutablePreferences3.get(PreferenceKeysKt.SkipSilenceKey);
                    Boolean boolValueOf6 = Boolean.valueOf(bool7 != null ? bool7.booleanValue() : false);
                    Boolean bool8 = (Boolean) mutablePreferences3.get(PreferenceKeysKt.SkipSilenceInstantKey);
                    Pair pair = new Pair(boolValueOf6, Boolean.valueOf(bool8 != null ? bool8.booleanValue() : false));
                    musicService$onCreate$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(pair, musicService$onCreate$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 10:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$3$2$1) {
                        musicService$onCreate$$inlined$map$3$2$1 = (MusicService$onCreate$$inlined$map$3$2$1) continuation;
                        int i21 = musicService$onCreate$$inlined$map$3$2$1.label;
                        if ((i21 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$3$2$1.label = i21 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$3$2$1 = new MusicService$onCreate$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$3$2$1 = new MusicService$onCreate$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj13 = musicService$onCreate$$inlined$map$3$2$1.result;
                    int i22 = musicService$onCreate$$inlined$map$3$2$1.label;
                    if (i22 != 0) {
                        if (i22 == 1) {
                            ResultKt.throwOnFailure(obj13);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj13);
                    Boolean bool9 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.AudioNormalizationKey);
                    Boolean boolValueOf7 = Boolean.valueOf(bool9 != null ? bool9.booleanValue() : true);
                    musicService$onCreate$$inlined$map$3$2$1.label = 1;
                    return flowCollector.emit(boolValueOf7, musicService$onCreate$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 11:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$4$2$1) {
                        musicService$onCreate$$inlined$map$4$2$1 = (MusicService$onCreate$$inlined$map$4$2$1) continuation;
                        int i23 = musicService$onCreate$$inlined$map$4$2$1.label;
                        if ((i23 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$4$2$1.label = i23 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$4$2$1 = new MusicService$onCreate$$inlined$map$4$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$4$2$1 = new MusicService$onCreate$$inlined$map$4$2$1(this, continuation);
                    }
                    Object obj14 = musicService$onCreate$$inlined$map$4$2$1.result;
                    int i24 = musicService$onCreate$$inlined$map$4$2$1.label;
                    if (i24 != 0) {
                        if (i24 == 1) {
                            ResultKt.throwOnFailure(obj14);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj14);
                    String str = (String) ((MutablePreferences) obj).get(PreferenceKeysKt.LoudnessLevelKey);
                    LoudnessLevel loudnessLevelValueOf = LoudnessLevel.BALANCED;
                    if (str != null) {
                        try {
                            loudnessLevelValueOf = LoudnessLevel.valueOf(str);
                            break;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    musicService$onCreate$$inlined$map$4$2$1.label = 1;
                    return flowCollector.emit(loudnessLevelValueOf, musicService$onCreate$$inlined$map$4$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$5$2$1) {
                        musicService$onCreate$$inlined$map$5$2$1 = (MusicService$onCreate$$inlined$map$5$2$1) continuation;
                        int i25 = musicService$onCreate$$inlined$map$5$2$1.label;
                        if ((i25 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$5$2$1.label = i25 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$5$2$1 = new MusicService$onCreate$$inlined$map$5$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$5$2$1 = new MusicService$onCreate$$inlined$map$5$2$1(this, continuation);
                    }
                    Object obj15 = musicService$onCreate$$inlined$map$5$2$1.result;
                    int i26 = musicService$onCreate$$inlined$map$5$2$1.label;
                    if (i26 != 0) {
                        if (i26 == 1) {
                            ResultKt.throwOnFailure(obj15);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj15);
                    Boolean bool10 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.AudioOffload);
                    Boolean boolValueOf8 = Boolean.valueOf(bool10 != null ? bool10.booleanValue() : false);
                    musicService$onCreate$$inlined$map$5$2$1.label = 1;
                    return flowCollector.emit(boolValueOf8, musicService$onCreate$$inlined$map$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 13:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$6$2$1) {
                        musicService$onCreate$$inlined$map$6$2$1 = (MusicService$onCreate$$inlined$map$6$2$1) continuation;
                        int i27 = musicService$onCreate$$inlined$map$6$2$1.label;
                        if ((i27 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$6$2$1.label = i27 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$6$2$1 = new MusicService$onCreate$$inlined$map$6$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$6$2$1 = new MusicService$onCreate$$inlined$map$6$2$1(this, continuation);
                    }
                    Object obj16 = musicService$onCreate$$inlined$map$6$2$1.result;
                    int i28 = musicService$onCreate$$inlined$map$6$2$1.label;
                    if (i28 != 0) {
                        if (i28 == 1) {
                            ResultKt.throwOnFailure(obj16);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj16);
                    Boolean bool11 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.CrossfadeEnabledKey);
                    Boolean boolValueOf9 = Boolean.valueOf(bool11 != null ? bool11.booleanValue() : false);
                    musicService$onCreate$$inlined$map$6$2$1.label = 1;
                    return flowCollector.emit(boolValueOf9, musicService$onCreate$$inlined$map$6$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 14:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$7$2$1) {
                        musicService$onCreate$$inlined$map$7$2$1 = (MusicService$onCreate$$inlined$map$7$2$1) continuation;
                        int i29 = musicService$onCreate$$inlined$map$7$2$1.label;
                        if ((i29 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$7$2$1.label = i29 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$7$2$1 = new MusicService$onCreate$$inlined$map$7$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$7$2$1 = new MusicService$onCreate$$inlined$map$7$2$1(this, continuation);
                    }
                    Object obj17 = musicService$onCreate$$inlined$map$7$2$1.result;
                    int i30 = musicService$onCreate$$inlined$map$7$2$1.label;
                    if (i30 != 0) {
                        if (i30 == 1) {
                            ResultKt.throwOnFailure(obj17);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj17);
                    Boolean bool12 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.AudioTrackPlaybackParamsKey);
                    Boolean boolValueOf10 = Boolean.valueOf(bool12 != null ? bool12.booleanValue() : true);
                    musicService$onCreate$$inlined$map$7$2$1.label = 1;
                    return flowCollector.emit(boolValueOf10, musicService$onCreate$$inlined$map$7$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 15:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$8$2$1) {
                        musicService$onCreate$$inlined$map$8$2$1 = (MusicService$onCreate$$inlined$map$8$2$1) continuation;
                        int i31 = musicService$onCreate$$inlined$map$8$2$1.label;
                        if ((i31 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$8$2$1.label = i31 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$8$2$1 = new MusicService$onCreate$$inlined$map$8$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$8$2$1 = new MusicService$onCreate$$inlined$map$8$2$1(this, continuation);
                    }
                    Object obj18 = musicService$onCreate$$inlined$map$8$2$1.result;
                    int i32 = musicService$onCreate$$inlined$map$8$2$1.label;
                    if (i32 != 0) {
                        if (i32 == 1) {
                            ResultKt.throwOnFailure(obj18);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj18);
                    Boolean bool13 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.EnableDiscordRPCKey);
                    Boolean boolValueOf11 = Boolean.valueOf(bool13 != null ? bool13.booleanValue() : true);
                    musicService$onCreate$$inlined$map$8$2$1.label = 1;
                    return flowCollector.emit(boolValueOf11, musicService$onCreate$$inlined$map$8$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 16:
                    if (continuation instanceof MusicService$onCreate$$inlined$map$9$2$1) {
                        musicService$onCreate$$inlined$map$9$2$1 = (MusicService$onCreate$$inlined$map$9$2$1) continuation;
                        int i33 = musicService$onCreate$$inlined$map$9$2$1.label;
                        if ((i33 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$$inlined$map$9$2$1.label = i33 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$$inlined$map$9$2$1 = new MusicService$onCreate$$inlined$map$9$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$$inlined$map$9$2$1 = new MusicService$onCreate$$inlined$map$9$2$1(this, continuation);
                    }
                    Object obj19 = musicService$onCreate$$inlined$map$9$2$1.result;
                    int i34 = musicService$onCreate$$inlined$map$9$2$1.label;
                    if (i34 != 0) {
                        if (i34 == 1) {
                            ResultKt.throwOnFailure(obj19);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj19);
                    Boolean bool14 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.EnableLastFMScrobblingKey);
                    Boolean boolValueOf12 = Boolean.valueOf(bool14 != null ? bool14.booleanValue() : false);
                    musicService$onCreate$$inlined$map$9$2$1.label = 1;
                    return flowCollector.emit(boolValueOf12, musicService$onCreate$$inlined$map$9$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 17:
                    if (continuation instanceof MusicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i35 = musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i35 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1.label = i35 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj20 = musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1.result;
                    int i36 = musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i36 != 0) {
                        if (i36 == 1) {
                            ResultKt.throwOnFailure(obj20);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj20);
                    String str2 = (String) ((MutablePreferences) obj).get(PreferenceKeysKt.AudioQualityKey);
                    if (str2 == null) {
                        audioQuality = AudioQuality.AUTO;
                    } else {
                        if (str2.equals("VERY_HIGH")) {
                            audioQuality = AudioQuality.HIGH;
                        } else {
                            EnumEntriesList enumEntriesList = AudioQuality.$ENTRIES;
                            enumEntriesList.getClass();
                            UIntArray.Iterator iterator = new UIntArray.Iterator((byte) 5, enumEntriesList);
                            while (iterator.hasNext()) {
                                Object next = iterator.next();
                                if (Intrinsics.areEqual(((AudioQuality) next).name(), str2)) {
                                    obj2 = next;
                                    audioQuality = (AudioQuality) obj2;
                                }
                            }
                            audioQuality = (AudioQuality) obj2;
                        }
                        if (audioQuality == null) {
                            audioQuality = AudioQuality.AUTO;
                        }
                    }
                    musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(audioQuality, musicService$onCreate$11$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 18:
                    if (continuation instanceof MusicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i37 = musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i37 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1.label = i37 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj21 = musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1.result;
                    int i38 = musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i38 != 0) {
                        if (i38 == 1) {
                            ResultKt.throwOnFailure(obj21);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj21);
                    Boolean bool15 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.PersistentQueueKey);
                    Boolean boolValueOf13 = Boolean.valueOf(bool15 != null ? bool15.booleanValue() : true);
                    musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf13, musicService$onCreate$47$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 19:
                    if (continuation instanceof MusicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i39 = musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i39 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1.label = i39 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj22 = musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1.result;
                    int i40 = musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i40 != 0) {
                        if (i40 == 1) {
                            ResultKt.throwOnFailure(obj22);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj22);
                    Boolean bool16 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.AutoplayKey);
                    Boolean boolValueOf14 = Boolean.valueOf(bool16 != null ? bool16.booleanValue() : true);
                    musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf14, musicService$onCreate$48$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 20:
                    if (continuation instanceof MusicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i41 = musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i41 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1.label = i41 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj23 = musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1.result;
                    int i42 = musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i42 != 0) {
                        if (i42 == 1) {
                            ResultKt.throwOnFailure(obj23);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj23);
                    Boolean bool17 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.DisableLoadMoreWhenRepeatAllKey);
                    Boolean boolValueOf15 = Boolean.valueOf(bool17 != null ? bool17.booleanValue() : false);
                    musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf15, musicService$onCreate$49$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 21:
                    if (continuation instanceof MusicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i43 = musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i43 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1.label = i43 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj24 = musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1.result;
                    int i44 = musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i44 != 0) {
                        if (i44 == 1) {
                            ResultKt.throwOnFailure(obj24);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj24);
                    Boolean bool18 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf16 = Boolean.valueOf(bool18 != null ? bool18.booleanValue() : false);
                    musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf16, musicService$onCreate$50$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 22:
                    if (continuation instanceof MusicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i45 = musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i45 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1.label = i45 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj25 = musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1.result;
                    int i46 = musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i46 != 0) {
                        if (i46 == 1) {
                            ResultKt.throwOnFailure(obj25);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj25);
                    Boolean bool19 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf17 = Boolean.valueOf(bool19 != null ? bool19.booleanValue() : false);
                    musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf17, musicService$onCreate$51$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 23:
                    if (continuation instanceof MusicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i47 = musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i47 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1.label = i47 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj26 = musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1.result;
                    int i48 = musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i48 != 0) {
                        if (i48 == 1) {
                            ResultKt.throwOnFailure(obj26);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj26);
                    Boolean bool20 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.ShufflePlaylistFirstKey);
                    Boolean boolValueOf18 = Boolean.valueOf(bool20 != null ? bool20.booleanValue() : false);
                    musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf18, musicService$onCreate$52$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 24:
                    if (continuation instanceof MusicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1) {
                        musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1 = (MusicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i49 = musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i49 & Integer.MIN_VALUE) != 0) {
                            musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1.label = i49 - Integer.MIN_VALUE;
                        } else {
                            musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1 = new MusicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj27 = musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1.result;
                    int i50 = musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i50 != 0) {
                        if (i50 == 1) {
                            ResultKt.throwOnFailure(obj27);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj27);
                    Boolean bool21 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.AutoLoadMoreKey);
                    Boolean boolValueOf19 = Boolean.valueOf(bool21 != null ? bool21.booleanValue() : true);
                    musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf19, musicService$onCreate$53$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 25:
                    if (continuation instanceof AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1) {
                        androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1 = (AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1) continuation;
                        int i51 = androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1.label;
                        if ((i51 & Integer.MIN_VALUE) != 0) {
                            androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1.label = i51 - Integer.MIN_VALUE;
                        } else {
                            androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1 = new AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1 = new AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj28 = androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1.result;
                    int i52 = androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1.label;
                    if (i52 != 0) {
                        if (i52 == 1) {
                            ResultKt.throwOnFailure(obj28);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj28);
                    List list2 = (List) obj;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Playlist) it2.next()).playlist);
                    }
                    androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(arrayList2, androidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 26:
                    if (continuation instanceof SyncUtils$isLoggedIn$$inlined$map$1$2$1) {
                        syncUtils$isLoggedIn$$inlined$map$1$2$1 = (SyncUtils$isLoggedIn$$inlined$map$1$2$1) continuation;
                        int i53 = syncUtils$isLoggedIn$$inlined$map$1$2$1.label;
                        if ((i53 & Integer.MIN_VALUE) != 0) {
                            syncUtils$isLoggedIn$$inlined$map$1$2$1.label = i53 - Integer.MIN_VALUE;
                        } else {
                            syncUtils$isLoggedIn$$inlined$map$1$2$1 = new SyncUtils$isLoggedIn$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        syncUtils$isLoggedIn$$inlined$map$1$2$1 = new SyncUtils$isLoggedIn$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj29 = syncUtils$isLoggedIn$$inlined$map$1$2$1.result;
                    int i54 = syncUtils$isLoggedIn$$inlined$map$1$2$1.label;
                    if (i54 == 0) {
                        ResultKt.throwOnFailure(obj29);
                        Object obj30 = ((MutablePreferences) obj).get(PreferenceKeysKt.InnerTubeCookieKey);
                        syncUtils$isLoggedIn$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(obj30, syncUtils$isLoggedIn$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i54 == 1) {
                        ResultKt.throwOnFailure(obj29);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 27:
                    if (continuation instanceof AccountViewModel$4$invokeSuspend$$inlined$map$1$2$1) {
                        accountViewModel$4$invokeSuspend$$inlined$map$1$2$1 = (AccountViewModel$4$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i55 = accountViewModel$4$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i55 & Integer.MIN_VALUE) != 0) {
                            accountViewModel$4$invokeSuspend$$inlined$map$1$2$1.label = i55 - Integer.MIN_VALUE;
                        } else {
                            accountViewModel$4$invokeSuspend$$inlined$map$1$2$1 = new AccountViewModel$4$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        accountViewModel$4$invokeSuspend$$inlined$map$1$2$1 = new AccountViewModel$4$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj31 = accountViewModel$4$invokeSuspend$$inlined$map$1$2$1.result;
                    int i56 = accountViewModel$4$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i56 != 0) {
                        if (i56 == 1) {
                            ResultKt.throwOnFailure(obj31);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj31);
                    Boolean bool22 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideYoutubeShortsKey);
                    Boolean boolValueOf20 = Boolean.valueOf(bool22 != null ? bool22.booleanValue() : false);
                    accountViewModel$4$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf20, accountViewModel$4$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 28:
                    if (continuation instanceof ArtistSongsViewModel$special$$inlined$map$1$2$1) {
                        artistSongsViewModel$special$$inlined$map$1$2$1 = (ArtistSongsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i57 = artistSongsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i57 & Integer.MIN_VALUE) != 0) {
                            artistSongsViewModel$special$$inlined$map$1$2$1.label = i57 - Integer.MIN_VALUE;
                        } else {
                            artistSongsViewModel$special$$inlined$map$1$2$1 = new ArtistSongsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        artistSongsViewModel$special$$inlined$map$1$2$1 = new ArtistSongsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj32 = artistSongsViewModel$special$$inlined$map$1$2$1.result;
                    int i58 = artistSongsViewModel$special$$inlined$map$1$2$1.label;
                    if (i58 != 0) {
                        if (i58 == 1) {
                            ResultKt.throwOnFailure(obj32);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj32);
                    MutablePreferences mutablePreferences4 = (MutablePreferences) obj;
                    String str3 = (String) mutablePreferences4.get(PreferenceKeysKt.ArtistSongSortTypeKey);
                    ArtistSongSortType artistSongSortTypeValueOf = ArtistSongSortType.CREATE_DATE;
                    if (str3 != null) {
                        try {
                            artistSongSortTypeValueOf = ArtistSongSortType.valueOf(str3);
                            break;
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    Boolean bool23 = (Boolean) mutablePreferences4.get(PreferenceKeysKt.ArtistSongSortDescendingKey);
                    Pair pair2 = new Pair(artistSongSortTypeValueOf, Boolean.valueOf(bool23 != null ? bool23.booleanValue() : true));
                    Boolean bool24 = (Boolean) mutablePreferences4.get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf21 = Boolean.valueOf(bool24 != null ? bool24.booleanValue() : false);
                    Boolean bool25 = (Boolean) mutablePreferences4.get(PreferenceKeysKt.HideVideoSongsKey);
                    Triple triple3 = new Triple(pair2, boolValueOf21, Boolean.valueOf(bool25 != null ? bool25.booleanValue() : false));
                    artistSongsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple3, artistSongsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    if (continuation instanceof ArtistViewModel$1$invokeSuspend$$inlined$map$1$2$1) {
                        artistViewModel$1$invokeSuspend$$inlined$map$1$2$1 = (ArtistViewModel$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i59 = artistViewModel$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i59 & Integer.MIN_VALUE) != 0) {
                            artistViewModel$1$invokeSuspend$$inlined$map$1$2$1.label = i59 - Integer.MIN_VALUE;
                        } else {
                            artistViewModel$1$invokeSuspend$$inlined$map$1$2$1 = new ArtistViewModel$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        artistViewModel$1$invokeSuspend$$inlined$map$1$2$1 = new ArtistViewModel$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj33 = artistViewModel$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i60 = artistViewModel$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i60 != 0) {
                        if (i60 == 1) {
                            ResultKt.throwOnFailure(obj33);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj33);
                    MutablePreferences mutablePreferences5 = (MutablePreferences) obj;
                    Boolean bool26 = (Boolean) mutablePreferences5.get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf22 = Boolean.valueOf(bool26 != null ? bool26.booleanValue() : false);
                    Boolean bool27 = (Boolean) mutablePreferences5.get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf23 = Boolean.valueOf(bool27 != null ? bool27.booleanValue() : false);
                    Boolean bool28 = (Boolean) mutablePreferences5.get(PreferenceKeysKt.HideYoutubeShortsKey);
                    Triple triple4 = new Triple(boolValueOf22, boolValueOf23, Boolean.valueOf(bool28 != null ? bool28.booleanValue() : false));
                    artistViewModel$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple4, artistViewModel$1$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }

        public /* synthetic */ AnonymousClass2(FlowCollector flowCollector, ImageLoader$Builder imageLoader$Builder, byte b) {
            this.$r8$classId = b;
            this.$this_unsafeFlow = flowCollector;
        }
    }
}
