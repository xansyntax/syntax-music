package com.metrolist.music.viewmodels;

import androidx.datastore.preferences.core.MutablePreferences;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.AlbumFilter;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistFilter;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.QuickPicks;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.entities.Artist;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$special$$inlined$map$1 implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$special$$inlined$map$1$1, reason: invalid class name */
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
            return HomeViewModel$special$$inlined$map$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$special$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
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

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        private final Object emit$com$metrolist$music$viewmodels$StatsViewModel$special$$inlined$map$1$2(Object obj, Continuation continuation) {
            StatsViewModel$special$$inlined$map$1$2$1 statsViewModel$special$$inlined$map$1$2$1;
            if (continuation instanceof StatsViewModel$special$$inlined$map$1$2$1) {
                statsViewModel$special$$inlined$map$1$2$1 = (StatsViewModel$special$$inlined$map$1$2$1) continuation;
                int i = statsViewModel$special$$inlined$map$1$2$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    statsViewModel$special$$inlined$map$1$2$1.label = i - Integer.MIN_VALUE;
                } else {
                    statsViewModel$special$$inlined$map$1$2$1 = new StatsViewModel$special$$inlined$map$1$2$1(this, continuation);
                }
            } else {
                statsViewModel$special$$inlined$map$1$2$1 = new StatsViewModel$special$$inlined$map$1$2$1(this, continuation);
            }
            Object obj2 = statsViewModel$special$$inlined$map$1$2$1.result;
            int i2 = statsViewModel$special$$inlined$map$1$2$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                Boolean bool = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.ShowMostStatsPlaylistsKey);
                Boolean boolValueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : true);
                statsViewModel$special$$inlined$map$1$2$1.label = 1;
                Object objEmit = this.$this_unsafeFlow.emit(boolValueOf, statsViewModel$special$$inlined$map$1$2$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objEmit == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:103:0x01a1  */
        /* JADX WARN: Code duplicated, block: B:118:0x01de  */
        /* JADX WARN: Code duplicated, block: B:136:0x0226  */
        /* JADX WARN: Code duplicated, block: B:162:0x0298  */
        /* JADX WARN: Code duplicated, block: B:196:0x0334  */
        /* JADX WARN: Code duplicated, block: B:222:0x03a9  */
        /* JADX WARN: Code duplicated, block: B:248:0x041e  */
        /* JADX WARN: Code duplicated, block: B:267:0x0460  */
        /* JADX WARN: Code duplicated, block: B:293:0x04d0  */
        /* JADX WARN: Code duplicated, block: B:29:0x0077  */
        /* JADX WARN: Code duplicated, block: B:311:0x0518  */
        /* JADX WARN: Code duplicated, block: B:337:0x058d  */
        /* JADX WARN: Code duplicated, block: B:355:0x05d5  */
        /* JADX WARN: Code duplicated, block: B:374:0x0617  */
        /* JADX WARN: Code duplicated, block: B:401:0x0688  */
        /* JADX WARN: Code duplicated, block: B:431:0x0710  */
        /* JADX WARN: Code duplicated, block: B:446:0x074c  */
        /* JADX WARN: Code duplicated, block: B:464:0x0794  */
        /* JADX WARN: Code duplicated, block: B:479:0x07db  */
        /* JADX WARN: Code duplicated, block: B:497:0x0823  */
        /* JADX WARN: Code duplicated, block: B:50:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:515:0x086b  */
        /* JADX WARN: Code duplicated, block: B:533:0x08b3  */
        /* JADX WARN: Code duplicated, block: B:563:0x093c  */
        /* JADX WARN: Code duplicated, block: B:581:0x0984  */
        /* JADX WARN: Code duplicated, block: B:603:0x09e5  */
        /* JADX WARN: Code duplicated, block: B:73:0x012d  */
        /* JADX WARN: Code duplicated, block: B:88:0x0167  */
        /* JADX WARN: Code duplicated, block: B:9:0x002a  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            ArtistViewModel$special$$inlined$map$1$2$1 artistViewModel$special$$inlined$map$1$2$1;
            ArtistViewModel$special$$inlined$map$2$2$1 artistViewModel$special$$inlined$map$2$2$1;
            AutoPlaylistViewModel$special$$inlined$map$1$2$1 autoPlaylistViewModel$special$$inlined$map$1$2$1;
            CachePlaylistViewModel$special$$inlined$map$1$2$1 cachePlaylistViewModel$special$$inlined$map$1$2$1;
            CachePlaylistViewModel$special$$inlined$map$2$2$1 cachePlaylistViewModel$special$$inlined$map$2$2$1;
            HistoryViewModel$special$$inlined$map$1$2$1 historyViewModel$special$$inlined$map$1$2$1;
            HomeViewModel$3$invokeSuspend$$inlined$map$1$2$1 homeViewModel$3$invokeSuspend$$inlined$map$1$2$1;
            HomeViewModel$4$invokeSuspend$$inlined$map$1$2$1 homeViewModel$4$invokeSuspend$$inlined$map$1$2$1;
            HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1 homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1;
            LibraryAlbumsViewModel$special$$inlined$map$1$2$1 libraryAlbumsViewModel$special$$inlined$map$1$2$1;
            LibraryArtistsViewModel$special$$inlined$map$1$2$1 libraryArtistsViewModel$special$$inlined$map$1$2$1;
            LibraryMixViewModel$special$$inlined$map$1$2$1 libraryMixViewModel$special$$inlined$map$1$2$1;
            String str;
            LibraryMixViewModel$special$$inlined$map$2$2$1 libraryMixViewModel$special$$inlined$map$2$2$1;
            LibraryMixViewModel$special$$inlined$map$3$2$1 libraryMixViewModel$special$$inlined$map$3$2$1;
            LibraryMixViewModel$special$$inlined$map$4$2$1 libraryMixViewModel$special$$inlined$map$4$2$1;
            LibraryPlaylistsViewModel$special$$inlined$map$1$2$1 libraryPlaylistsViewModel$special$$inlined$map$1$2$1;
            LibraryPlaylistsViewModel$special$$inlined$map$2$2$1 libraryPlaylistsViewModel$special$$inlined$map$2$2$1;
            LibraryPodcastsViewModel$special$$inlined$map$1$2$1 libraryPodcastsViewModel$special$$inlined$map$1$2$1;
            LibraryPodcastsViewModel$special$$inlined$map$2$2$1 libraryPodcastsViewModel$special$$inlined$map$2$2$1;
            LibrarySongsViewModel$special$$inlined$map$1$2$1 librarySongsViewModel$special$$inlined$map$1$2$1;
            LocalPlaylistViewModel$special$$inlined$map$1$2$1 localPlaylistViewModel$special$$inlined$map$1$2$1;
            LocalSearchViewModel$special$$inlined$map$1$2$1 localSearchViewModel$special$$inlined$map$1$2$1;
            OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1;
            OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1;
            OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1;
            PlaylistsViewModel$special$$inlined$map$1$2$1 playlistsViewModel$special$$inlined$map$1$2$1;
            StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1 statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1;
            StatsViewModel$special$$inlined$map$2$2$1 statsViewModel$special$$inlined$map$2$2$1;
            byte b = this.$r8$classId;
            PlaylistSortType playlistSortTypeValueOf = PlaylistSortType.CREATE_DATE;
            SongSortType songSortTypeValueOf = SongSortType.CREATE_DATE;
            Unit unit = Unit.INSTANCE;
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
                    String str2 = (String) ((MutablePreferences) obj).get(PreferenceKeysKt.QuickPicksKey);
                    QuickPicks quickPicksValueOf = QuickPicks.QUICK_PICKS;
                    if (str2 != null) {
                        try {
                            quickPicksValueOf = QuickPicks.valueOf(str2);
                            break;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    anonymousClass1.label = 1;
                    return flowCollector.emit(quickPicksValueOf, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    if (continuation instanceof ArtistViewModel$special$$inlined$map$1$2$1) {
                        artistViewModel$special$$inlined$map$1$2$1 = (ArtistViewModel$special$$inlined$map$1$2$1) continuation;
                        int i3 = artistViewModel$special$$inlined$map$1$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            artistViewModel$special$$inlined$map$1$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            artistViewModel$special$$inlined$map$1$2$1 = new ArtistViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        artistViewModel$special$$inlined$map$1$2$1 = new ArtistViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj3 = artistViewModel$special$$inlined$map$1$2$1.result;
                    int i4 = artistViewModel$special$$inlined$map$1$2$1.label;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            ResultKt.throwOnFailure(obj3);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj3);
                    MutablePreferences mutablePreferences = (MutablePreferences) obj;
                    Boolean bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
                    Boolean bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.HideVideoSongsKey);
                    Pair pair = new Pair(boolValueOf, Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false));
                    artistViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(pair, artistViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    if (continuation instanceof ArtistViewModel$special$$inlined$map$2$2$1) {
                        artistViewModel$special$$inlined$map$2$2$1 = (ArtistViewModel$special$$inlined$map$2$2$1) continuation;
                        int i5 = artistViewModel$special$$inlined$map$2$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            artistViewModel$special$$inlined$map$2$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            artistViewModel$special$$inlined$map$2$2$1 = new ArtistViewModel$special$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        artistViewModel$special$$inlined$map$2$2$1 = new ArtistViewModel$special$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj4 = artistViewModel$special$$inlined$map$2$2$1.result;
                    int i6 = artistViewModel$special$$inlined$map$2$2$1.label;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            ResultKt.throwOnFailure(obj4);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj4);
                    Boolean bool3 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf2 = Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false);
                    artistViewModel$special$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(boolValueOf2, artistViewModel$special$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 3:
                    if (continuation instanceof AutoPlaylistViewModel$special$$inlined$map$1$2$1) {
                        autoPlaylistViewModel$special$$inlined$map$1$2$1 = (AutoPlaylistViewModel$special$$inlined$map$1$2$1) continuation;
                        int i7 = autoPlaylistViewModel$special$$inlined$map$1$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            autoPlaylistViewModel$special$$inlined$map$1$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            autoPlaylistViewModel$special$$inlined$map$1$2$1 = new AutoPlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        autoPlaylistViewModel$special$$inlined$map$1$2$1 = new AutoPlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj5 = autoPlaylistViewModel$special$$inlined$map$1$2$1.result;
                    int i8 = autoPlaylistViewModel$special$$inlined$map$1$2$1.label;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            ResultKt.throwOnFailure(obj5);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj5);
                    MutablePreferences mutablePreferences2 = (MutablePreferences) obj;
                    String str3 = (String) mutablePreferences2.get(PreferenceKeysKt.SongSortTypeKey);
                    if (str3 != null) {
                        try {
                            songSortTypeValueOf = SongSortType.valueOf(str3);
                            break;
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    Boolean bool4 = (Boolean) mutablePreferences2.get(PreferenceKeysKt.SongSortDescendingKey);
                    Pair pair2 = new Pair(songSortTypeValueOf, Boolean.valueOf(bool4 != null ? bool4.booleanValue() : true));
                    Boolean bool5 = (Boolean) mutablePreferences2.get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf3 = Boolean.valueOf(bool5 != null ? bool5.booleanValue() : false);
                    Boolean bool6 = (Boolean) mutablePreferences2.get(PreferenceKeysKt.HideVideoSongsKey);
                    Triple triple = new Triple(pair2, boolValueOf3, Boolean.valueOf(bool6 != null ? bool6.booleanValue() : false));
                    autoPlaylistViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple, autoPlaylistViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 4:
                    if (continuation instanceof CachePlaylistViewModel$special$$inlined$map$1$2$1) {
                        cachePlaylistViewModel$special$$inlined$map$1$2$1 = (CachePlaylistViewModel$special$$inlined$map$1$2$1) continuation;
                        int i9 = cachePlaylistViewModel$special$$inlined$map$1$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            cachePlaylistViewModel$special$$inlined$map$1$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            cachePlaylistViewModel$special$$inlined$map$1$2$1 = new CachePlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        cachePlaylistViewModel$special$$inlined$map$1$2$1 = new CachePlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj6 = cachePlaylistViewModel$special$$inlined$map$1$2$1.result;
                    int i10 = cachePlaylistViewModel$special$$inlined$map$1$2$1.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            ResultKt.throwOnFailure(obj6);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj6);
                    Boolean bool7 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf4 = Boolean.valueOf(bool7 != null ? bool7.booleanValue() : false);
                    cachePlaylistViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf4, cachePlaylistViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    if (continuation instanceof CachePlaylistViewModel$special$$inlined$map$2$2$1) {
                        cachePlaylistViewModel$special$$inlined$map$2$2$1 = (CachePlaylistViewModel$special$$inlined$map$2$2$1) continuation;
                        int i11 = cachePlaylistViewModel$special$$inlined$map$2$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            cachePlaylistViewModel$special$$inlined$map$2$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            cachePlaylistViewModel$special$$inlined$map$2$2$1 = new CachePlaylistViewModel$special$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        cachePlaylistViewModel$special$$inlined$map$2$2$1 = new CachePlaylistViewModel$special$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj7 = cachePlaylistViewModel$special$$inlined$map$2$2$1.result;
                    int i12 = cachePlaylistViewModel$special$$inlined$map$2$2$1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            ResultKt.throwOnFailure(obj7);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj7);
                    Boolean bool8 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf5 = Boolean.valueOf(bool8 != null ? bool8.booleanValue() : false);
                    cachePlaylistViewModel$special$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(boolValueOf5, cachePlaylistViewModel$special$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 6:
                    if (continuation instanceof HistoryViewModel$special$$inlined$map$1$2$1) {
                        historyViewModel$special$$inlined$map$1$2$1 = (HistoryViewModel$special$$inlined$map$1$2$1) continuation;
                        int i13 = historyViewModel$special$$inlined$map$1$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            historyViewModel$special$$inlined$map$1$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            historyViewModel$special$$inlined$map$1$2$1 = new HistoryViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        historyViewModel$special$$inlined$map$1$2$1 = new HistoryViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj8 = historyViewModel$special$$inlined$map$1$2$1.result;
                    int i14 = historyViewModel$special$$inlined$map$1$2$1.label;
                    if (i14 != 0) {
                        if (i14 == 1) {
                            ResultKt.throwOnFailure(obj8);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj8);
                    Boolean bool9 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf6 = Boolean.valueOf(bool9 != null ? bool9.booleanValue() : false);
                    historyViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf6, historyViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    if (continuation instanceof HomeViewModel$3$invokeSuspend$$inlined$map$1$2$1) {
                        homeViewModel$3$invokeSuspend$$inlined$map$1$2$1 = (HomeViewModel$3$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i15 = homeViewModel$3$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            homeViewModel$3$invokeSuspend$$inlined$map$1$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            homeViewModel$3$invokeSuspend$$inlined$map$1$2$1 = new HomeViewModel$3$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        homeViewModel$3$invokeSuspend$$inlined$map$1$2$1 = new HomeViewModel$3$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj9 = homeViewModel$3$invokeSuspend$$inlined$map$1$2$1.result;
                    int i16 = homeViewModel$3$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            ResultKt.throwOnFailure(obj9);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj9);
                    MutablePreferences mutablePreferences3 = (MutablePreferences) obj;
                    Pair pair3 = new Pair(mutablePreferences3.get(PreferenceKeysKt.InnerTubeCookieKey), mutablePreferences3.get(PreferenceKeysKt.AccountNameKey));
                    homeViewModel$3$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(pair3, homeViewModel$3$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    if (continuation instanceof HomeViewModel$4$invokeSuspend$$inlined$map$1$2$1) {
                        homeViewModel$4$invokeSuspend$$inlined$map$1$2$1 = (HomeViewModel$4$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i17 = homeViewModel$4$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            homeViewModel$4$invokeSuspend$$inlined$map$1$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            homeViewModel$4$invokeSuspend$$inlined$map$1$2$1 = new HomeViewModel$4$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        homeViewModel$4$invokeSuspend$$inlined$map$1$2$1 = new HomeViewModel$4$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj10 = homeViewModel$4$invokeSuspend$$inlined$map$1$2$1.result;
                    int i18 = homeViewModel$4$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            ResultKt.throwOnFailure(obj10);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj10);
                    Boolean bool10 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideYoutubeShortsKey);
                    Boolean boolValueOf7 = Boolean.valueOf(bool10 != null ? bool10.booleanValue() : false);
                    homeViewModel$4$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf7, homeViewModel$4$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 9:
                    if (continuation instanceof HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1) {
                        homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1 = (HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1) continuation;
                        int i19 = homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1 = new HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1 = new HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj11 = homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1.result;
                    int i20 = homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1.label;
                    if (i20 == 0) {
                        ResultKt.throwOnFailure(obj11);
                        Object obj12 = ((MutablePreferences) obj).get(PreferenceKeysKt.InnerTubeCookieKey);
                        homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(obj12, homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i20 == 1) {
                        ResultKt.throwOnFailure(obj11);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 10:
                    if (continuation instanceof LibraryAlbumsViewModel$special$$inlined$map$1$2$1) {
                        libraryAlbumsViewModel$special$$inlined$map$1$2$1 = (LibraryAlbumsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i21 = libraryAlbumsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i21 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsViewModel$special$$inlined$map$1$2$1.label = i21 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsViewModel$special$$inlined$map$1$2$1 = new LibraryAlbumsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsViewModel$special$$inlined$map$1$2$1 = new LibraryAlbumsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj13 = libraryAlbumsViewModel$special$$inlined$map$1$2$1.result;
                    int i22 = libraryAlbumsViewModel$special$$inlined$map$1$2$1.label;
                    if (i22 != 0) {
                        if (i22 == 1) {
                            ResultKt.throwOnFailure(obj13);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj13);
                    MutablePreferences mutablePreferences4 = (MutablePreferences) obj;
                    String str4 = (String) mutablePreferences4.get(PreferenceKeysKt.AlbumFilterKey);
                    AlbumFilter albumFilterValueOf = AlbumFilter.LIKED;
                    if (str4 != null) {
                        try {
                            albumFilterValueOf = AlbumFilter.valueOf(str4);
                            break;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    String str5 = (String) mutablePreferences4.get(PreferenceKeysKt.AlbumSortTypeKey);
                    AlbumSortType albumSortTypeValueOf = AlbumSortType.CREATE_DATE;
                    if (str5 != null) {
                        try {
                            albumSortTypeValueOf = AlbumSortType.valueOf(str5);
                            break;
                        } catch (IllegalArgumentException unused4) {
                        }
                    }
                    Boolean bool11 = (Boolean) mutablePreferences4.get(PreferenceKeysKt.AlbumSortDescendingKey);
                    Triple triple2 = new Triple(albumFilterValueOf, albumSortTypeValueOf, Boolean.valueOf(bool11 != null ? bool11.booleanValue() : true));
                    Boolean bool12 = (Boolean) mutablePreferences4.get(PreferenceKeysKt.HideExplicitKey);
                    Pair pair4 = new Pair(triple2, Boolean.valueOf(bool12 != null ? bool12.booleanValue() : false));
                    libraryAlbumsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(pair4, libraryAlbumsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 11:
                    if (continuation instanceof LibraryArtistsViewModel$special$$inlined$map$1$2$1) {
                        libraryArtistsViewModel$special$$inlined$map$1$2$1 = (LibraryArtistsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i23 = libraryArtistsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i23 & Integer.MIN_VALUE) != 0) {
                            libraryArtistsViewModel$special$$inlined$map$1$2$1.label = i23 - Integer.MIN_VALUE;
                        } else {
                            libraryArtistsViewModel$special$$inlined$map$1$2$1 = new LibraryArtistsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryArtistsViewModel$special$$inlined$map$1$2$1 = new LibraryArtistsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj14 = libraryArtistsViewModel$special$$inlined$map$1$2$1.result;
                    int i24 = libraryArtistsViewModel$special$$inlined$map$1$2$1.label;
                    if (i24 != 0) {
                        if (i24 == 1) {
                            ResultKt.throwOnFailure(obj14);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj14);
                    MutablePreferences mutablePreferences5 = (MutablePreferences) obj;
                    String str6 = (String) mutablePreferences5.get(PreferenceKeysKt.ArtistFilterKey);
                    ArtistFilter artistFilterValueOf = ArtistFilter.LIKED;
                    if (str6 != null) {
                        try {
                            artistFilterValueOf = ArtistFilter.valueOf(str6);
                            break;
                        } catch (IllegalArgumentException unused5) {
                        }
                    }
                    String str7 = (String) mutablePreferences5.get(PreferenceKeysKt.ArtistSortTypeKey);
                    ArtistSortType artistSortTypeValueOf = ArtistSortType.CREATE_DATE;
                    if (str7 != null) {
                        try {
                            artistSortTypeValueOf = ArtistSortType.valueOf(str7);
                            break;
                        } catch (IllegalArgumentException unused6) {
                        }
                    }
                    Boolean bool13 = (Boolean) mutablePreferences5.get(PreferenceKeysKt.ArtistSortDescendingKey);
                    Triple triple3 = new Triple(artistFilterValueOf, artistSortTypeValueOf, Boolean.valueOf(bool13 != null ? bool13.booleanValue() : true));
                    libraryArtistsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple3, libraryArtistsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (continuation instanceof LibraryMixViewModel$special$$inlined$map$1$2$1) {
                        libraryMixViewModel$special$$inlined$map$1$2$1 = (LibraryMixViewModel$special$$inlined$map$1$2$1) continuation;
                        int i25 = libraryMixViewModel$special$$inlined$map$1$2$1.label;
                        if ((i25 & Integer.MIN_VALUE) != 0) {
                            libraryMixViewModel$special$$inlined$map$1$2$1.label = i25 - Integer.MIN_VALUE;
                        } else {
                            libraryMixViewModel$special$$inlined$map$1$2$1 = new LibraryMixViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryMixViewModel$special$$inlined$map$1$2$1 = new LibraryMixViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj15 = libraryMixViewModel$special$$inlined$map$1$2$1.result;
                    int i26 = libraryMixViewModel$special$$inlined$map$1$2$1.label;
                    if (i26 != 0) {
                        if (i26 == 1) {
                            ResultKt.throwOnFailure(obj15);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj15);
                    String str8 = (String) ((MutablePreferences) obj).get(PreferenceKeysKt.TopSize);
                    str = str8 != null ? str8 : "50";
                    libraryMixViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(str, libraryMixViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 13:
                    if (continuation instanceof LibraryMixViewModel$special$$inlined$map$2$2$1) {
                        libraryMixViewModel$special$$inlined$map$2$2$1 = (LibraryMixViewModel$special$$inlined$map$2$2$1) continuation;
                        int i27 = libraryMixViewModel$special$$inlined$map$2$2$1.label;
                        if ((i27 & Integer.MIN_VALUE) != 0) {
                            libraryMixViewModel$special$$inlined$map$2$2$1.label = i27 - Integer.MIN_VALUE;
                        } else {
                            libraryMixViewModel$special$$inlined$map$2$2$1 = new LibraryMixViewModel$special$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        libraryMixViewModel$special$$inlined$map$2$2$1 = new LibraryMixViewModel$special$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj16 = libraryMixViewModel$special$$inlined$map$2$2$1.result;
                    int i28 = libraryMixViewModel$special$$inlined$map$2$2$1.label;
                    if (i28 != 0) {
                        if (i28 == 1) {
                            ResultKt.throwOnFailure(obj16);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj16);
                    Boolean bool14 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf8 = Boolean.valueOf(bool14 != null ? bool14.booleanValue() : false);
                    libraryMixViewModel$special$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(boolValueOf8, libraryMixViewModel$special$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 14:
                    if (continuation instanceof LibraryMixViewModel$special$$inlined$map$3$2$1) {
                        libraryMixViewModel$special$$inlined$map$3$2$1 = (LibraryMixViewModel$special$$inlined$map$3$2$1) continuation;
                        int i29 = libraryMixViewModel$special$$inlined$map$3$2$1.label;
                        if ((i29 & Integer.MIN_VALUE) != 0) {
                            libraryMixViewModel$special$$inlined$map$3$2$1.label = i29 - Integer.MIN_VALUE;
                        } else {
                            libraryMixViewModel$special$$inlined$map$3$2$1 = new LibraryMixViewModel$special$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        libraryMixViewModel$special$$inlined$map$3$2$1 = new LibraryMixViewModel$special$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj17 = libraryMixViewModel$special$$inlined$map$3$2$1.result;
                    int i30 = libraryMixViewModel$special$$inlined$map$3$2$1.label;
                    if (i30 != 0) {
                        if (i30 == 1) {
                            ResultKt.throwOnFailure(obj17);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj17);
                    MutablePreferences mutablePreferences6 = (MutablePreferences) obj;
                    Boolean bool15 = (Boolean) mutablePreferences6.get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf9 = Boolean.valueOf(bool15 != null ? bool15.booleanValue() : false);
                    Boolean bool16 = (Boolean) mutablePreferences6.get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf10 = Boolean.valueOf(bool16 != null ? bool16.booleanValue() : false);
                    Boolean bool17 = (Boolean) mutablePreferences6.get(PreferenceKeysKt.HideYoutubeShortsKey);
                    Triple triple4 = new Triple(boolValueOf9, boolValueOf10, Boolean.valueOf(bool17 != null ? bool17.booleanValue() : false));
                    libraryMixViewModel$special$$inlined$map$3$2$1.label = 1;
                    return flowCollector.emit(triple4, libraryMixViewModel$special$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 15:
                    if (continuation instanceof LibraryMixViewModel$special$$inlined$map$4$2$1) {
                        libraryMixViewModel$special$$inlined$map$4$2$1 = (LibraryMixViewModel$special$$inlined$map$4$2$1) continuation;
                        int i31 = libraryMixViewModel$special$$inlined$map$4$2$1.label;
                        if ((i31 & Integer.MIN_VALUE) != 0) {
                            libraryMixViewModel$special$$inlined$map$4$2$1.label = i31 - Integer.MIN_VALUE;
                        } else {
                            libraryMixViewModel$special$$inlined$map$4$2$1 = new LibraryMixViewModel$special$$inlined$map$4$2$1(this, continuation);
                        }
                    } else {
                        libraryMixViewModel$special$$inlined$map$4$2$1 = new LibraryMixViewModel$special$$inlined$map$4$2$1(this, continuation);
                    }
                    Object obj18 = libraryMixViewModel$special$$inlined$map$4$2$1.result;
                    int i32 = libraryMixViewModel$special$$inlined$map$4$2$1.label;
                    if (i32 != 0) {
                        if (i32 == 1) {
                            ResultKt.throwOnFailure(obj18);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj18);
                    Boolean bool18 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideYoutubeShortsKey);
                    Boolean boolValueOf11 = Boolean.valueOf(bool18 != null ? bool18.booleanValue() : false);
                    libraryMixViewModel$special$$inlined$map$4$2$1.label = 1;
                    return flowCollector.emit(boolValueOf11, libraryMixViewModel$special$$inlined$map$4$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 16:
                    if (continuation instanceof LibraryPlaylistsViewModel$special$$inlined$map$1$2$1) {
                        libraryPlaylistsViewModel$special$$inlined$map$1$2$1 = (LibraryPlaylistsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i33 = libraryPlaylistsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i33 & Integer.MIN_VALUE) != 0) {
                            libraryPlaylistsViewModel$special$$inlined$map$1$2$1.label = i33 - Integer.MIN_VALUE;
                        } else {
                            libraryPlaylistsViewModel$special$$inlined$map$1$2$1 = new LibraryPlaylistsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPlaylistsViewModel$special$$inlined$map$1$2$1 = new LibraryPlaylistsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj19 = libraryPlaylistsViewModel$special$$inlined$map$1$2$1.result;
                    int i34 = libraryPlaylistsViewModel$special$$inlined$map$1$2$1.label;
                    if (i34 != 0) {
                        if (i34 == 1) {
                            ResultKt.throwOnFailure(obj19);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj19);
                    MutablePreferences mutablePreferences7 = (MutablePreferences) obj;
                    String str9 = (String) mutablePreferences7.get(PreferenceKeysKt.PlaylistSortTypeKey);
                    if (str9 != null) {
                        try {
                            playlistSortTypeValueOf = PlaylistSortType.valueOf(str9);
                            break;
                        } catch (IllegalArgumentException unused7) {
                        }
                    }
                    Boolean bool19 = (Boolean) mutablePreferences7.get(PreferenceKeysKt.PlaylistSortDescendingKey);
                    Boolean boolValueOf12 = Boolean.valueOf(bool19 != null ? bool19.booleanValue() : true);
                    Boolean bool20 = (Boolean) mutablePreferences7.get(PreferenceKeysKt.HideYoutubeShortsKey);
                    Triple triple5 = new Triple(playlistSortTypeValueOf, boolValueOf12, Boolean.valueOf(bool20 != null ? bool20.booleanValue() : false));
                    libraryPlaylistsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple5, libraryPlaylistsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 17:
                    if (continuation instanceof LibraryPlaylistsViewModel$special$$inlined$map$2$2$1) {
                        libraryPlaylistsViewModel$special$$inlined$map$2$2$1 = (LibraryPlaylistsViewModel$special$$inlined$map$2$2$1) continuation;
                        int i35 = libraryPlaylistsViewModel$special$$inlined$map$2$2$1.label;
                        if ((i35 & Integer.MIN_VALUE) != 0) {
                            libraryPlaylistsViewModel$special$$inlined$map$2$2$1.label = i35 - Integer.MIN_VALUE;
                        } else {
                            libraryPlaylistsViewModel$special$$inlined$map$2$2$1 = new LibraryPlaylistsViewModel$special$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        libraryPlaylistsViewModel$special$$inlined$map$2$2$1 = new LibraryPlaylistsViewModel$special$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj20 = libraryPlaylistsViewModel$special$$inlined$map$2$2$1.result;
                    int i36 = libraryPlaylistsViewModel$special$$inlined$map$2$2$1.label;
                    if (i36 != 0) {
                        if (i36 == 1) {
                            ResultKt.throwOnFailure(obj20);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj20);
                    String str10 = (String) ((MutablePreferences) obj).get(PreferenceKeysKt.TopSize);
                    str = str10 != null ? str10 : "50";
                    libraryPlaylistsViewModel$special$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(str, libraryPlaylistsViewModel$special$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 18:
                    if (continuation instanceof LibraryPodcastsViewModel$special$$inlined$map$1$2$1) {
                        libraryPodcastsViewModel$special$$inlined$map$1$2$1 = (LibraryPodcastsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i37 = libraryPodcastsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i37 & Integer.MIN_VALUE) != 0) {
                            libraryPodcastsViewModel$special$$inlined$map$1$2$1.label = i37 - Integer.MIN_VALUE;
                        } else {
                            libraryPodcastsViewModel$special$$inlined$map$1$2$1 = new LibraryPodcastsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPodcastsViewModel$special$$inlined$map$1$2$1 = new LibraryPodcastsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj21 = libraryPodcastsViewModel$special$$inlined$map$1$2$1.result;
                    int i38 = libraryPodcastsViewModel$special$$inlined$map$1$2$1.label;
                    if (i38 != 0) {
                        if (i38 == 1) {
                            ResultKt.throwOnFailure(obj21);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj21);
                    MutablePreferences mutablePreferences8 = (MutablePreferences) obj;
                    String str11 = (String) mutablePreferences8.get(PreferenceKeysKt.SongSortTypeKey);
                    if (str11 != null) {
                        try {
                            songSortTypeValueOf = SongSortType.valueOf(str11);
                            break;
                        } catch (IllegalArgumentException unused8) {
                        }
                    }
                    Boolean bool21 = (Boolean) mutablePreferences8.get(PreferenceKeysKt.SongSortDescendingKey);
                    Pair pair5 = new Pair(songSortTypeValueOf, Boolean.valueOf(bool21 != null ? bool21.booleanValue() : true));
                    Boolean bool22 = (Boolean) mutablePreferences8.get(PreferenceKeysKt.HideExplicitKey);
                    Pair pair6 = new Pair(pair5, Boolean.valueOf(bool22 != null ? bool22.booleanValue() : false));
                    libraryPodcastsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(pair6, libraryPodcastsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 19:
                    if (continuation instanceof LibraryPodcastsViewModel$special$$inlined$map$2$2$1) {
                        libraryPodcastsViewModel$special$$inlined$map$2$2$1 = (LibraryPodcastsViewModel$special$$inlined$map$2$2$1) continuation;
                        int i39 = libraryPodcastsViewModel$special$$inlined$map$2$2$1.label;
                        if ((i39 & Integer.MIN_VALUE) != 0) {
                            libraryPodcastsViewModel$special$$inlined$map$2$2$1.label = i39 - Integer.MIN_VALUE;
                        } else {
                            libraryPodcastsViewModel$special$$inlined$map$2$2$1 = new LibraryPodcastsViewModel$special$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        libraryPodcastsViewModel$special$$inlined$map$2$2$1 = new LibraryPodcastsViewModel$special$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj22 = libraryPodcastsViewModel$special$$inlined$map$2$2$1.result;
                    int i40 = libraryPodcastsViewModel$special$$inlined$map$2$2$1.label;
                    if (i40 != 0) {
                        if (i40 == 1) {
                            ResultKt.throwOnFailure(obj22);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj22);
                    MutablePreferences mutablePreferences9 = (MutablePreferences) obj;
                    String str12 = (String) mutablePreferences9.get(PreferenceKeysKt.SongSortTypeKey);
                    if (str12 != null) {
                        try {
                            songSortTypeValueOf = SongSortType.valueOf(str12);
                            break;
                        } catch (IllegalArgumentException unused9) {
                        }
                    }
                    Boolean bool23 = (Boolean) mutablePreferences9.get(PreferenceKeysKt.SongSortDescendingKey);
                    Pair pair7 = new Pair(songSortTypeValueOf, Boolean.valueOf(bool23 != null ? bool23.booleanValue() : true));
                    Boolean bool24 = (Boolean) mutablePreferences9.get(PreferenceKeysKt.HideExplicitKey);
                    Pair pair8 = new Pair(pair7, Boolean.valueOf(bool24 != null ? bool24.booleanValue() : false));
                    libraryPodcastsViewModel$special$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(pair8, libraryPodcastsViewModel$special$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 20:
                    if (continuation instanceof LibrarySongsViewModel$special$$inlined$map$1$2$1) {
                        librarySongsViewModel$special$$inlined$map$1$2$1 = (LibrarySongsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i41 = librarySongsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i41 & Integer.MIN_VALUE) != 0) {
                            librarySongsViewModel$special$$inlined$map$1$2$1.label = i41 - Integer.MIN_VALUE;
                        } else {
                            librarySongsViewModel$special$$inlined$map$1$2$1 = new LibrarySongsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        librarySongsViewModel$special$$inlined$map$1$2$1 = new LibrarySongsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj23 = librarySongsViewModel$special$$inlined$map$1$2$1.result;
                    int i42 = librarySongsViewModel$special$$inlined$map$1$2$1.label;
                    if (i42 != 0) {
                        if (i42 == 1) {
                            ResultKt.throwOnFailure(obj23);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj23);
                    MutablePreferences mutablePreferences10 = (MutablePreferences) obj;
                    String str13 = (String) mutablePreferences10.get(PreferenceKeysKt.SongFilterKey);
                    SongFilter songFilterValueOf = SongFilter.LIKED;
                    if (str13 != null) {
                        try {
                            songFilterValueOf = SongFilter.valueOf(str13);
                            break;
                        } catch (IllegalArgumentException unused10) {
                        }
                    }
                    String str14 = (String) mutablePreferences10.get(PreferenceKeysKt.SongSortTypeKey);
                    if (str14 != null) {
                        try {
                            songSortTypeValueOf = SongSortType.valueOf(str14);
                            break;
                        } catch (IllegalArgumentException unused11) {
                        }
                    }
                    Boolean bool25 = (Boolean) mutablePreferences10.get(PreferenceKeysKt.SongSortDescendingKey);
                    Triple triple6 = new Triple(songFilterValueOf, songSortTypeValueOf, Boolean.valueOf(bool25 != null ? bool25.booleanValue() : true));
                    Boolean bool26 = (Boolean) mutablePreferences10.get(PreferenceKeysKt.HideExplicitKey);
                    Boolean boolValueOf13 = Boolean.valueOf(bool26 != null ? bool26.booleanValue() : false);
                    Boolean bool27 = (Boolean) mutablePreferences10.get(PreferenceKeysKt.HideVideoSongsKey);
                    Triple triple7 = new Triple(triple6, boolValueOf13, Boolean.valueOf(bool27 != null ? bool27.booleanValue() : false));
                    librarySongsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple7, librarySongsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 21:
                    if (continuation instanceof LocalPlaylistViewModel$special$$inlined$map$1$2$1) {
                        localPlaylistViewModel$special$$inlined$map$1$2$1 = (LocalPlaylistViewModel$special$$inlined$map$1$2$1) continuation;
                        int i43 = localPlaylistViewModel$special$$inlined$map$1$2$1.label;
                        if ((i43 & Integer.MIN_VALUE) != 0) {
                            localPlaylistViewModel$special$$inlined$map$1$2$1.label = i43 - Integer.MIN_VALUE;
                        } else {
                            localPlaylistViewModel$special$$inlined$map$1$2$1 = new LocalPlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        localPlaylistViewModel$special$$inlined$map$1$2$1 = new LocalPlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj24 = localPlaylistViewModel$special$$inlined$map$1$2$1.result;
                    int i44 = localPlaylistViewModel$special$$inlined$map$1$2$1.label;
                    if (i44 != 0) {
                        if (i44 == 1) {
                            ResultKt.throwOnFailure(obj24);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj24);
                    MutablePreferences mutablePreferences11 = (MutablePreferences) obj;
                    String str15 = (String) mutablePreferences11.get(PreferenceKeysKt.PlaylistSongSortTypeKey);
                    PlaylistSongSortType playlistSongSortTypeValueOf = PlaylistSongSortType.CUSTOM;
                    if (str15 != null) {
                        try {
                            playlistSongSortTypeValueOf = PlaylistSongSortType.valueOf(str15);
                            break;
                        } catch (IllegalArgumentException unused12) {
                        }
                    }
                    Boolean bool28 = (Boolean) mutablePreferences11.get(PreferenceKeysKt.PlaylistSongSortDescendingKey);
                    Boolean boolValueOf14 = Boolean.valueOf(bool28 != null ? bool28.booleanValue() : true);
                    Boolean bool29 = (Boolean) mutablePreferences11.get(PreferenceKeysKt.HideVideoSongsKey);
                    Triple triple8 = new Triple(playlistSongSortTypeValueOf, boolValueOf14, Boolean.valueOf(bool29 != null ? bool29.booleanValue() : false));
                    localPlaylistViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(triple8, localPlaylistViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 22:
                    if (continuation instanceof LocalSearchViewModel$special$$inlined$map$1$2$1) {
                        localSearchViewModel$special$$inlined$map$1$2$1 = (LocalSearchViewModel$special$$inlined$map$1$2$1) continuation;
                        int i45 = localSearchViewModel$special$$inlined$map$1$2$1.label;
                        if ((i45 & Integer.MIN_VALUE) != 0) {
                            localSearchViewModel$special$$inlined$map$1$2$1.label = i45 - Integer.MIN_VALUE;
                        } else {
                            localSearchViewModel$special$$inlined$map$1$2$1 = new LocalSearchViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        localSearchViewModel$special$$inlined$map$1$2$1 = new LocalSearchViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj25 = localSearchViewModel$special$$inlined$map$1$2$1.result;
                    int i46 = localSearchViewModel$special$$inlined$map$1$2$1.label;
                    if (i46 != 0) {
                        if (i46 == 1) {
                            ResultKt.throwOnFailure(obj25);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj25);
                    Boolean bool30 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf15 = Boolean.valueOf(bool30 != null ? bool30.booleanValue() : false);
                    localSearchViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(boolValueOf15, localSearchViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 23:
                    if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1) continuation;
                        int i47 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1.label;
                        if ((i47 & Integer.MIN_VALUE) != 0) {
                            onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1.label = i47 - Integer.MIN_VALUE;
                        } else {
                            onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj26 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1.result;
                    int i48 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1.label;
                    if (i48 == 0) {
                        ResultKt.throwOnFailure(obj26);
                        SearchSuggestionViewState searchSuggestionViewState = new SearchSuggestionViewState((List) obj, null, null, 30);
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(searchSuggestionViewState, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i48 == 1) {
                        ResultKt.throwOnFailure(obj26);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 24:
                    if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1) continuation;
                        int i49 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1.label;
                        if ((i49 & Integer.MIN_VALUE) != 0) {
                            onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1.label = i49 - Integer.MIN_VALUE;
                        } else {
                            onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj27 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1.result;
                    int i50 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1.label;
                    if (i50 == 0) {
                        ResultKt.throwOnFailure(obj27);
                        List listTake = CollectionsKt.take((List) obj, 3);
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(listTake, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i50 == 1) {
                        ResultKt.throwOnFailure(obj27);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 25:
                    if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1) continuation;
                        int i51 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1.label;
                        if ((i51 & Integer.MIN_VALUE) != 0) {
                            onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1.label = i51 - Integer.MIN_VALUE;
                        } else {
                            onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1(this, continuation);
                        }
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1(this, continuation);
                    }
                    Object obj28 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1.result;
                    int i52 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1.label;
                    if (i52 == 0) {
                        ResultKt.throwOnFailure(obj28);
                        List listTake2 = CollectionsKt.take((List) obj, 3);
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1.label = 1;
                        return flowCollector.emit(listTake2, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i52 == 1) {
                        ResultKt.throwOnFailure(obj28);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 26:
                    if (continuation instanceof PlaylistsViewModel$special$$inlined$map$1$2$1) {
                        playlistsViewModel$special$$inlined$map$1$2$1 = (PlaylistsViewModel$special$$inlined$map$1$2$1) continuation;
                        int i53 = playlistsViewModel$special$$inlined$map$1$2$1.label;
                        if ((i53 & Integer.MIN_VALUE) != 0) {
                            playlistsViewModel$special$$inlined$map$1$2$1.label = i53 - Integer.MIN_VALUE;
                        } else {
                            playlistsViewModel$special$$inlined$map$1$2$1 = new PlaylistsViewModel$special$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        playlistsViewModel$special$$inlined$map$1$2$1 = new PlaylistsViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj29 = playlistsViewModel$special$$inlined$map$1$2$1.result;
                    int i54 = playlistsViewModel$special$$inlined$map$1$2$1.label;
                    if (i54 != 0) {
                        if (i54 == 1) {
                            ResultKt.throwOnFailure(obj29);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj29);
                    MutablePreferences mutablePreferences12 = (MutablePreferences) obj;
                    String str16 = (String) mutablePreferences12.get(PreferenceKeysKt.AddToPlaylistSortTypeKey);
                    if (str16 != null) {
                        try {
                            playlistSortTypeValueOf = PlaylistSortType.valueOf(str16);
                            break;
                        } catch (IllegalArgumentException unused13) {
                        }
                    }
                    Boolean bool31 = (Boolean) mutablePreferences12.get(PreferenceKeysKt.AddToPlaylistSortDescendingKey);
                    Pair pair9 = new Pair(playlistSortTypeValueOf, Boolean.valueOf(bool31 != null ? bool31.booleanValue() : true));
                    playlistsViewModel$special$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(pair9, playlistsViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 27:
                    if (continuation instanceof StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1) {
                        statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1 = (StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1) continuation;
                        int i55 = statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1.label;
                        if ((i55 & Integer.MIN_VALUE) != 0) {
                            statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1.label = i55 - Integer.MIN_VALUE;
                        } else {
                            statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1 = new StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1 = new StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj30 = statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1.result;
                    int i56 = statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1.label;
                    if (i56 != 0) {
                        if (i56 == 1) {
                            ResultKt.throwOnFailure(obj30);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj30);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj31 : (List) obj) {
                        if (((Artist) obj31).artist.isYouTubeArtist()) {
                            arrayList.add(obj31);
                        }
                    }
                    statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(arrayList, statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 28:
                    return emit$com$metrolist$music$viewmodels$StatsViewModel$special$$inlined$map$1$2(obj, continuation);
                default:
                    if (continuation instanceof StatsViewModel$special$$inlined$map$2$2$1) {
                        statsViewModel$special$$inlined$map$2$2$1 = (StatsViewModel$special$$inlined$map$2$2$1) continuation;
                        int i57 = statsViewModel$special$$inlined$map$2$2$1.label;
                        if ((i57 & Integer.MIN_VALUE) != 0) {
                            statsViewModel$special$$inlined$map$2$2$1.label = i57 - Integer.MIN_VALUE;
                        } else {
                            statsViewModel$special$$inlined$map$2$2$1 = new StatsViewModel$special$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        statsViewModel$special$$inlined$map$2$2$1 = new StatsViewModel$special$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj32 = statsViewModel$special$$inlined$map$2$2$1.result;
                    int i58 = statsViewModel$special$$inlined$map$2$2$1.label;
                    if (i58 != 0) {
                        if (i58 == 1) {
                            ResultKt.throwOnFailure(obj32);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj32);
                    Boolean bool32 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                    Boolean boolValueOf16 = Boolean.valueOf(bool32 != null ? bool32.booleanValue() : false);
                    statsViewModel$special$$inlined$map$2$2$1.label = 1;
                    return flowCollector.emit(boolValueOf16, statsViewModel$special$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public /* synthetic */ HomeViewModel$special$$inlined$map$1(Flow flow, byte b) {
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
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:264:0x0409  */
    /* JADX WARN: Code duplicated, block: B:279:0x0444  */
    /* JADX WARN: Code duplicated, block: B:294:0x047f  */
    /* JADX WARN: Code duplicated, block: B:309:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:324:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:339:0x0530  */
    /* JADX WARN: Code duplicated, block: B:354:0x056b  */
    /* JADX WARN: Code duplicated, block: B:369:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:384:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:399:0x061b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0096  */
    /* JADX WARN: Code duplicated, block: B:414:0x0655  */
    /* JADX WARN: Code duplicated, block: B:429:0x068f  */
    /* JADX WARN: Code duplicated, block: B:444:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x010a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0145  */
    /* JADX WARN: Code duplicated, block: B:99:0x0180  */
    /* JADX WARN: Code duplicated, block: B:9:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        CachePlaylistViewModel$special$$inlined$map$1$1 cachePlaylistViewModel$special$$inlined$map$1$1;
        CachePlaylistViewModel$special$$inlined$map$2$1 cachePlaylistViewModel$special$$inlined$map$2$1;
        HistoryViewModel$special$$inlined$map$1$1 historyViewModel$special$$inlined$map$1$1;
        HomeViewModel$3$invokeSuspend$$inlined$map$1$1 homeViewModel$3$invokeSuspend$$inlined$map$1$1;
        HomeViewModel$4$invokeSuspend$$inlined$map$1$1 homeViewModel$4$invokeSuspend$$inlined$map$1$1;
        HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1 homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1;
        LibraryAlbumsViewModel$special$$inlined$map$1$1 libraryAlbumsViewModel$special$$inlined$map$1$1;
        LibraryArtistsViewModel$special$$inlined$map$1$1 libraryArtistsViewModel$special$$inlined$map$1$1;
        LibraryMixViewModel$special$$inlined$map$1$1 libraryMixViewModel$special$$inlined$map$1$1;
        LibraryMixViewModel$special$$inlined$map$2$1 libraryMixViewModel$special$$inlined$map$2$1;
        LibraryMixViewModel$special$$inlined$map$3$1 libraryMixViewModel$special$$inlined$map$3$1;
        LibraryMixViewModel$special$$inlined$map$4$1 libraryMixViewModel$special$$inlined$map$4$1;
        LibraryPlaylistsViewModel$special$$inlined$map$1$1 libraryPlaylistsViewModel$special$$inlined$map$1$1;
        LibraryPlaylistsViewModel$special$$inlined$map$2$1 libraryPlaylistsViewModel$special$$inlined$map$2$1;
        LibraryPodcastsViewModel$special$$inlined$map$1$1 libraryPodcastsViewModel$special$$inlined$map$1$1;
        LibraryPodcastsViewModel$special$$inlined$map$2$1 libraryPodcastsViewModel$special$$inlined$map$2$1;
        LibrarySongsViewModel$special$$inlined$map$1$1 librarySongsViewModel$special$$inlined$map$1$1;
        LocalPlaylistViewModel$special$$inlined$map$1$1 localPlaylistViewModel$special$$inlined$map$1$1;
        LocalSearchViewModel$special$$inlined$map$1$1 localSearchViewModel$special$$inlined$map$1$1;
        OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1;
        OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1;
        OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1;
        PlaylistsViewModel$special$$inlined$map$1$1 playlistsViewModel$special$$inlined$map$1$1;
        StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1 statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1;
        StatsViewModel$special$$inlined$map$1$1 statsViewModel$special$$inlined$map$1$1;
        StatsViewModel$special$$inlined$map$2$1 statsViewModel$special$$inlined$map$2$1;
        StatsViewModel$special$$inlined$map$3$1 statsViewModel$special$$inlined$map$3$1;
        StatsViewModel$special$$inlined$map$4$1 statsViewModel$special$$inlined$map$4$1;
        TopPlaylistViewModel$special$$inlined$map$1$1 topPlaylistViewModel$special$$inlined$map$1$1;
        byte b = this.$r8$classId;
        byte b2 = 0;
        Unit unit = Unit.INSTANCE;
        Flow flow = this.$this_unsafeTransform$inlined;
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
                Object obj = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, b2);
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
                if (continuation instanceof CachePlaylistViewModel$special$$inlined$map$1$1) {
                    cachePlaylistViewModel$special$$inlined$map$1$1 = (CachePlaylistViewModel$special$$inlined$map$1$1) continuation;
                    int i3 = cachePlaylistViewModel$special$$inlined$map$1$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        cachePlaylistViewModel$special$$inlined$map$1$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        cachePlaylistViewModel$special$$inlined$map$1$1 = new CachePlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    cachePlaylistViewModel$special$$inlined$map$1$1 = new CachePlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj2 = cachePlaylistViewModel$special$$inlined$map$1$1.result;
                int i4 = cachePlaylistViewModel$special$$inlined$map$1$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, (byte) 4);
                    cachePlaylistViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass3, cachePlaylistViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof CachePlaylistViewModel$special$$inlined$map$2$1) {
                    cachePlaylistViewModel$special$$inlined$map$2$1 = (CachePlaylistViewModel$special$$inlined$map$2$1) continuation;
                    int i5 = cachePlaylistViewModel$special$$inlined$map$2$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        cachePlaylistViewModel$special$$inlined$map$2$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        cachePlaylistViewModel$special$$inlined$map$2$1 = new CachePlaylistViewModel$special$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    cachePlaylistViewModel$special$$inlined$map$2$1 = new CachePlaylistViewModel$special$$inlined$map$2$1(this, continuation);
                }
                Object obj3 = cachePlaylistViewModel$special$$inlined$map$2$1.result;
                int i6 = cachePlaylistViewModel$special$$inlined$map$2$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, (byte) 5);
                    cachePlaylistViewModel$special$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass4, cachePlaylistViewModel$special$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof HistoryViewModel$special$$inlined$map$1$1) {
                    historyViewModel$special$$inlined$map$1$1 = (HistoryViewModel$special$$inlined$map$1$1) continuation;
                    int i7 = historyViewModel$special$$inlined$map$1$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        historyViewModel$special$$inlined$map$1$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        historyViewModel$special$$inlined$map$1$1 = new HistoryViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    historyViewModel$special$$inlined$map$1$1 = new HistoryViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj4 = historyViewModel$special$$inlined$map$1$1.result;
                int i8 = historyViewModel$special$$inlined$map$1$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, (byte) 6);
                    historyViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass5, historyViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof HomeViewModel$3$invokeSuspend$$inlined$map$1$1) {
                    homeViewModel$3$invokeSuspend$$inlined$map$1$1 = (HomeViewModel$3$invokeSuspend$$inlined$map$1$1) continuation;
                    int i9 = homeViewModel$3$invokeSuspend$$inlined$map$1$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        homeViewModel$3$invokeSuspend$$inlined$map$1$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        homeViewModel$3$invokeSuspend$$inlined$map$1$1 = new HomeViewModel$3$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    homeViewModel$3$invokeSuspend$$inlined$map$1$1 = new HomeViewModel$3$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj5 = homeViewModel$3$invokeSuspend$$inlined$map$1$1.result;
                int i10 = homeViewModel$3$invokeSuspend$$inlined$map$1$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, (byte) 7);
                    homeViewModel$3$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass6, homeViewModel$3$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof HomeViewModel$4$invokeSuspend$$inlined$map$1$1) {
                    homeViewModel$4$invokeSuspend$$inlined$map$1$1 = (HomeViewModel$4$invokeSuspend$$inlined$map$1$1) continuation;
                    int i11 = homeViewModel$4$invokeSuspend$$inlined$map$1$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        homeViewModel$4$invokeSuspend$$inlined$map$1$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        homeViewModel$4$invokeSuspend$$inlined$map$1$1 = new HomeViewModel$4$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    homeViewModel$4$invokeSuspend$$inlined$map$1$1 = new HomeViewModel$4$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj6 = homeViewModel$4$invokeSuspend$$inlined$map$1$1.result;
                int i12 = homeViewModel$4$invokeSuspend$$inlined$map$1$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, (byte) 8);
                    homeViewModel$4$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass7, homeViewModel$4$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1) {
                    homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1 = (HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i13 = homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1 = new HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1 = new HomeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj7 = homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1.result;
                int i14 = homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, (byte) 9);
                    homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass8, homeViewModel$loadHomeData$1$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof LibraryAlbumsViewModel$special$$inlined$map$1$1) {
                    libraryAlbumsViewModel$special$$inlined$map$1$1 = (LibraryAlbumsViewModel$special$$inlined$map$1$1) continuation;
                    int i15 = libraryAlbumsViewModel$special$$inlined$map$1$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsViewModel$special$$inlined$map$1$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsViewModel$special$$inlined$map$1$1 = new LibraryAlbumsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryAlbumsViewModel$special$$inlined$map$1$1 = new LibraryAlbumsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj8 = libraryAlbumsViewModel$special$$inlined$map$1$1.result;
                int i16 = libraryAlbumsViewModel$special$$inlined$map$1$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, (byte) 10);
                    libraryAlbumsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass9, libraryAlbumsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof LibraryArtistsViewModel$special$$inlined$map$1$1) {
                    libraryArtistsViewModel$special$$inlined$map$1$1 = (LibraryArtistsViewModel$special$$inlined$map$1$1) continuation;
                    int i17 = libraryArtistsViewModel$special$$inlined$map$1$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        libraryArtistsViewModel$special$$inlined$map$1$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        libraryArtistsViewModel$special$$inlined$map$1$1 = new LibraryArtistsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryArtistsViewModel$special$$inlined$map$1$1 = new LibraryArtistsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj9 = libraryArtistsViewModel$special$$inlined$map$1$1.result;
                int i18 = libraryArtistsViewModel$special$$inlined$map$1$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, (byte) 11);
                    libraryArtistsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass10, libraryArtistsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                if (continuation instanceof LibraryMixViewModel$special$$inlined$map$1$1) {
                    libraryMixViewModel$special$$inlined$map$1$1 = (LibraryMixViewModel$special$$inlined$map$1$1) continuation;
                    int i19 = libraryMixViewModel$special$$inlined$map$1$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        libraryMixViewModel$special$$inlined$map$1$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        libraryMixViewModel$special$$inlined$map$1$1 = new LibraryMixViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryMixViewModel$special$$inlined$map$1$1 = new LibraryMixViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj10 = libraryMixViewModel$special$$inlined$map$1$1.result;
                int i20 = libraryMixViewModel$special$$inlined$map$1$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, (byte) 12);
                    libraryMixViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass11, libraryMixViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 10:
                if (continuation instanceof LibraryMixViewModel$special$$inlined$map$2$1) {
                    libraryMixViewModel$special$$inlined$map$2$1 = (LibraryMixViewModel$special$$inlined$map$2$1) continuation;
                    int i21 = libraryMixViewModel$special$$inlined$map$2$1.label;
                    if ((i21 & Integer.MIN_VALUE) != 0) {
                        libraryMixViewModel$special$$inlined$map$2$1.label = i21 - Integer.MIN_VALUE;
                    } else {
                        libraryMixViewModel$special$$inlined$map$2$1 = new LibraryMixViewModel$special$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    libraryMixViewModel$special$$inlined$map$2$1 = new LibraryMixViewModel$special$$inlined$map$2$1(this, continuation);
                }
                Object obj11 = libraryMixViewModel$special$$inlined$map$2$1.result;
                int i22 = libraryMixViewModel$special$$inlined$map$2$1.label;
                if (i22 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2(flowCollector, (byte) 13);
                    libraryMixViewModel$special$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass12, libraryMixViewModel$special$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i22 == 1) {
                    ResultKt.throwOnFailure(obj11);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                if (continuation instanceof LibraryMixViewModel$special$$inlined$map$3$1) {
                    libraryMixViewModel$special$$inlined$map$3$1 = (LibraryMixViewModel$special$$inlined$map$3$1) continuation;
                    int i23 = libraryMixViewModel$special$$inlined$map$3$1.label;
                    if ((i23 & Integer.MIN_VALUE) != 0) {
                        libraryMixViewModel$special$$inlined$map$3$1.label = i23 - Integer.MIN_VALUE;
                    } else {
                        libraryMixViewModel$special$$inlined$map$3$1 = new LibraryMixViewModel$special$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    libraryMixViewModel$special$$inlined$map$3$1 = new LibraryMixViewModel$special$$inlined$map$3$1(this, continuation);
                }
                Object obj12 = libraryMixViewModel$special$$inlined$map$3$1.result;
                int i24 = libraryMixViewModel$special$$inlined$map$3$1.label;
                if (i24 == 0) {
                    ResultKt.throwOnFailure(obj12);
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2(flowCollector, (byte) 14);
                    libraryMixViewModel$special$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass13, libraryMixViewModel$special$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i24 == 1) {
                    ResultKt.throwOnFailure(obj12);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof LibraryMixViewModel$special$$inlined$map$4$1) {
                    libraryMixViewModel$special$$inlined$map$4$1 = (LibraryMixViewModel$special$$inlined$map$4$1) continuation;
                    int i25 = libraryMixViewModel$special$$inlined$map$4$1.label;
                    if ((i25 & Integer.MIN_VALUE) != 0) {
                        libraryMixViewModel$special$$inlined$map$4$1.label = i25 - Integer.MIN_VALUE;
                    } else {
                        libraryMixViewModel$special$$inlined$map$4$1 = new LibraryMixViewModel$special$$inlined$map$4$1(this, continuation);
                    }
                } else {
                    libraryMixViewModel$special$$inlined$map$4$1 = new LibraryMixViewModel$special$$inlined$map$4$1(this, continuation);
                }
                Object obj13 = libraryMixViewModel$special$$inlined$map$4$1.result;
                int i26 = libraryMixViewModel$special$$inlined$map$4$1.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj13);
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2(flowCollector, (byte) 15);
                    libraryMixViewModel$special$$inlined$map$4$1.label = 1;
                    return flow.collect(anonymousClass14, libraryMixViewModel$special$$inlined$map$4$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i26 == 1) {
                    ResultKt.throwOnFailure(obj13);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 13:
                if (continuation instanceof LibraryPlaylistsViewModel$special$$inlined$map$1$1) {
                    libraryPlaylistsViewModel$special$$inlined$map$1$1 = (LibraryPlaylistsViewModel$special$$inlined$map$1$1) continuation;
                    int i27 = libraryPlaylistsViewModel$special$$inlined$map$1$1.label;
                    if ((i27 & Integer.MIN_VALUE) != 0) {
                        libraryPlaylistsViewModel$special$$inlined$map$1$1.label = i27 - Integer.MIN_VALUE;
                    } else {
                        libraryPlaylistsViewModel$special$$inlined$map$1$1 = new LibraryPlaylistsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryPlaylistsViewModel$special$$inlined$map$1$1 = new LibraryPlaylistsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj14 = libraryPlaylistsViewModel$special$$inlined$map$1$1.result;
                int i28 = libraryPlaylistsViewModel$special$$inlined$map$1$1.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj14);
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2(flowCollector, (byte) 16);
                    libraryPlaylistsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass15, libraryPlaylistsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i28 == 1) {
                    ResultKt.throwOnFailure(obj14);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                if (continuation instanceof LibraryPlaylistsViewModel$special$$inlined$map$2$1) {
                    libraryPlaylistsViewModel$special$$inlined$map$2$1 = (LibraryPlaylistsViewModel$special$$inlined$map$2$1) continuation;
                    int i29 = libraryPlaylistsViewModel$special$$inlined$map$2$1.label;
                    if ((i29 & Integer.MIN_VALUE) != 0) {
                        libraryPlaylistsViewModel$special$$inlined$map$2$1.label = i29 - Integer.MIN_VALUE;
                    } else {
                        libraryPlaylistsViewModel$special$$inlined$map$2$1 = new LibraryPlaylistsViewModel$special$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    libraryPlaylistsViewModel$special$$inlined$map$2$1 = new LibraryPlaylistsViewModel$special$$inlined$map$2$1(this, continuation);
                }
                Object obj15 = libraryPlaylistsViewModel$special$$inlined$map$2$1.result;
                int i30 = libraryPlaylistsViewModel$special$$inlined$map$2$1.label;
                if (i30 == 0) {
                    ResultKt.throwOnFailure(obj15);
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2(flowCollector, (byte) 17);
                    libraryPlaylistsViewModel$special$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass16, libraryPlaylistsViewModel$special$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i30 == 1) {
                    ResultKt.throwOnFailure(obj15);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 15:
                if (continuation instanceof LibraryPodcastsViewModel$special$$inlined$map$1$1) {
                    libraryPodcastsViewModel$special$$inlined$map$1$1 = (LibraryPodcastsViewModel$special$$inlined$map$1$1) continuation;
                    int i31 = libraryPodcastsViewModel$special$$inlined$map$1$1.label;
                    if ((i31 & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsViewModel$special$$inlined$map$1$1.label = i31 - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsViewModel$special$$inlined$map$1$1 = new LibraryPodcastsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryPodcastsViewModel$special$$inlined$map$1$1 = new LibraryPodcastsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj16 = libraryPodcastsViewModel$special$$inlined$map$1$1.result;
                int i32 = libraryPodcastsViewModel$special$$inlined$map$1$1.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj16);
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2(flowCollector, (byte) 18);
                    libraryPodcastsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass17, libraryPodcastsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i32 == 1) {
                    ResultKt.throwOnFailure(obj16);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 16:
                if (continuation instanceof LibraryPodcastsViewModel$special$$inlined$map$2$1) {
                    libraryPodcastsViewModel$special$$inlined$map$2$1 = (LibraryPodcastsViewModel$special$$inlined$map$2$1) continuation;
                    int i33 = libraryPodcastsViewModel$special$$inlined$map$2$1.label;
                    if ((i33 & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsViewModel$special$$inlined$map$2$1.label = i33 - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsViewModel$special$$inlined$map$2$1 = new LibraryPodcastsViewModel$special$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    libraryPodcastsViewModel$special$$inlined$map$2$1 = new LibraryPodcastsViewModel$special$$inlined$map$2$1(this, continuation);
                }
                Object obj17 = libraryPodcastsViewModel$special$$inlined$map$2$1.result;
                int i34 = libraryPodcastsViewModel$special$$inlined$map$2$1.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj17);
                    AnonymousClass2 anonymousClass18 = new AnonymousClass2(flowCollector, (byte) 19);
                    libraryPodcastsViewModel$special$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass18, libraryPodcastsViewModel$special$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i34 == 1) {
                    ResultKt.throwOnFailure(obj17);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 17:
                if (continuation instanceof LibrarySongsViewModel$special$$inlined$map$1$1) {
                    librarySongsViewModel$special$$inlined$map$1$1 = (LibrarySongsViewModel$special$$inlined$map$1$1) continuation;
                    int i35 = librarySongsViewModel$special$$inlined$map$1$1.label;
                    if ((i35 & Integer.MIN_VALUE) != 0) {
                        librarySongsViewModel$special$$inlined$map$1$1.label = i35 - Integer.MIN_VALUE;
                    } else {
                        librarySongsViewModel$special$$inlined$map$1$1 = new LibrarySongsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    librarySongsViewModel$special$$inlined$map$1$1 = new LibrarySongsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj18 = librarySongsViewModel$special$$inlined$map$1$1.result;
                int i36 = librarySongsViewModel$special$$inlined$map$1$1.label;
                if (i36 == 0) {
                    ResultKt.throwOnFailure(obj18);
                    AnonymousClass2 anonymousClass19 = new AnonymousClass2(flowCollector, (byte) 20);
                    librarySongsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass19, librarySongsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i36 == 1) {
                    ResultKt.throwOnFailure(obj18);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 18:
                if (continuation instanceof LocalPlaylistViewModel$special$$inlined$map$1$1) {
                    localPlaylistViewModel$special$$inlined$map$1$1 = (LocalPlaylistViewModel$special$$inlined$map$1$1) continuation;
                    int i37 = localPlaylistViewModel$special$$inlined$map$1$1.label;
                    if ((i37 & Integer.MIN_VALUE) != 0) {
                        localPlaylistViewModel$special$$inlined$map$1$1.label = i37 - Integer.MIN_VALUE;
                    } else {
                        localPlaylistViewModel$special$$inlined$map$1$1 = new LocalPlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    localPlaylistViewModel$special$$inlined$map$1$1 = new LocalPlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj19 = localPlaylistViewModel$special$$inlined$map$1$1.result;
                int i38 = localPlaylistViewModel$special$$inlined$map$1$1.label;
                if (i38 == 0) {
                    ResultKt.throwOnFailure(obj19);
                    AnonymousClass2 anonymousClass20 = new AnonymousClass2(flowCollector, (byte) 21);
                    localPlaylistViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass20, localPlaylistViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i38 == 1) {
                    ResultKt.throwOnFailure(obj19);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 19:
                if (continuation instanceof LocalSearchViewModel$special$$inlined$map$1$1) {
                    localSearchViewModel$special$$inlined$map$1$1 = (LocalSearchViewModel$special$$inlined$map$1$1) continuation;
                    int i39 = localSearchViewModel$special$$inlined$map$1$1.label;
                    if ((i39 & Integer.MIN_VALUE) != 0) {
                        localSearchViewModel$special$$inlined$map$1$1.label = i39 - Integer.MIN_VALUE;
                    } else {
                        localSearchViewModel$special$$inlined$map$1$1 = new LocalSearchViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    localSearchViewModel$special$$inlined$map$1$1 = new LocalSearchViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj20 = localSearchViewModel$special$$inlined$map$1$1.result;
                int i40 = localSearchViewModel$special$$inlined$map$1$1.label;
                if (i40 == 0) {
                    ResultKt.throwOnFailure(obj20);
                    AnonymousClass2 anonymousClass21 = new AnonymousClass2(flowCollector, (byte) 22);
                    localSearchViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass21, localSearchViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i40 == 1) {
                    ResultKt.throwOnFailure(obj20);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 20:
                if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1) {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1) continuation;
                    int i41 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1.label;
                    if ((i41 & Integer.MIN_VALUE) != 0) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1.label = i41 - Integer.MIN_VALUE;
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1(this, continuation);
                }
                Object obj21 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1.result;
                int i42 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1.label;
                if (i42 == 0) {
                    ResultKt.throwOnFailure(obj21);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(flowCollector, (byte) 23);
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass22, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i42 == 1) {
                    ResultKt.throwOnFailure(obj21);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 21:
                if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1) {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1) continuation;
                    int i43 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1.label;
                    if ((i43 & Integer.MIN_VALUE) != 0) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1.label = i43 - Integer.MIN_VALUE;
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1(this, continuation);
                }
                Object obj22 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1.result;
                int i44 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1.label;
                if (i44 == 0) {
                    ResultKt.throwOnFailure(obj22);
                    AnonymousClass2 anonymousClass23 = new AnonymousClass2(flowCollector, (byte) 24);
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass23, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i44 == 1) {
                    ResultKt.throwOnFailure(obj22);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 22:
                if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1) {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1) continuation;
                    int i45 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1.label;
                    if ((i45 & Integer.MIN_VALUE) != 0) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1.label = i45 - Integer.MIN_VALUE;
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1(this, continuation);
                    }
                } else {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1(this, continuation);
                }
                Object obj23 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1.result;
                int i46 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1.label;
                if (i46 == 0) {
                    ResultKt.throwOnFailure(obj23);
                    AnonymousClass2 anonymousClass24 = new AnonymousClass2(flowCollector, (byte) 25);
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1.label = 1;
                    return flow.collect(anonymousClass24, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$4$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i46 == 1) {
                    ResultKt.throwOnFailure(obj23);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 23:
                if (continuation instanceof PlaylistsViewModel$special$$inlined$map$1$1) {
                    playlistsViewModel$special$$inlined$map$1$1 = (PlaylistsViewModel$special$$inlined$map$1$1) continuation;
                    int i47 = playlistsViewModel$special$$inlined$map$1$1.label;
                    if ((i47 & Integer.MIN_VALUE) != 0) {
                        playlistsViewModel$special$$inlined$map$1$1.label = i47 - Integer.MIN_VALUE;
                    } else {
                        playlistsViewModel$special$$inlined$map$1$1 = new PlaylistsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    playlistsViewModel$special$$inlined$map$1$1 = new PlaylistsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj24 = playlistsViewModel$special$$inlined$map$1$1.result;
                int i48 = playlistsViewModel$special$$inlined$map$1$1.label;
                if (i48 == 0) {
                    ResultKt.throwOnFailure(obj24);
                    AnonymousClass2 anonymousClass25 = new AnonymousClass2(flowCollector, (byte) 26);
                    playlistsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass25, playlistsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i48 == 1) {
                    ResultKt.throwOnFailure(obj24);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 24:
                if (continuation instanceof StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1) {
                    statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1 = (StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1) continuation;
                    int i49 = statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1.label;
                    if ((i49 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1.label = i49 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1 = new StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1 = new StatsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1(this, continuation);
                }
                Object obj25 = statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1.result;
                int i50 = statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1.label;
                if (i50 == 0) {
                    ResultKt.throwOnFailure(obj25);
                    AnonymousClass2 anonymousClass26 = new AnonymousClass2(flowCollector, (byte) 27);
                    statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass26, statsViewModel$mostPlayedArtists$lambda$0$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i50 == 1) {
                    ResultKt.throwOnFailure(obj25);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 25:
                if (continuation instanceof StatsViewModel$special$$inlined$map$1$1) {
                    statsViewModel$special$$inlined$map$1$1 = (StatsViewModel$special$$inlined$map$1$1) continuation;
                    int i51 = statsViewModel$special$$inlined$map$1$1.label;
                    if ((i51 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$special$$inlined$map$1$1.label = i51 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$special$$inlined$map$1$1 = new StatsViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    statsViewModel$special$$inlined$map$1$1 = new StatsViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj26 = statsViewModel$special$$inlined$map$1$1.result;
                int i52 = statsViewModel$special$$inlined$map$1$1.label;
                if (i52 == 0) {
                    ResultKt.throwOnFailure(obj26);
                    AnonymousClass2 anonymousClass27 = new AnonymousClass2(flowCollector, (byte) 28);
                    statsViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass27, statsViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i52 == 1) {
                    ResultKt.throwOnFailure(obj26);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 26:
                if (continuation instanceof StatsViewModel$special$$inlined$map$2$1) {
                    statsViewModel$special$$inlined$map$2$1 = (StatsViewModel$special$$inlined$map$2$1) continuation;
                    int i53 = statsViewModel$special$$inlined$map$2$1.label;
                    if ((i53 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$special$$inlined$map$2$1.label = i53 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$special$$inlined$map$2$1 = new StatsViewModel$special$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    statsViewModel$special$$inlined$map$2$1 = new StatsViewModel$special$$inlined$map$2$1(this, continuation);
                }
                Object obj27 = statsViewModel$special$$inlined$map$2$1.result;
                int i54 = statsViewModel$special$$inlined$map$2$1.label;
                if (i54 == 0) {
                    ResultKt.throwOnFailure(obj27);
                    AnonymousClass2 anonymousClass28 = new AnonymousClass2(flowCollector, (byte) 29);
                    statsViewModel$special$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass28, statsViewModel$special$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i54 == 1) {
                    ResultKt.throwOnFailure(obj27);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 27:
                if (continuation instanceof StatsViewModel$special$$inlined$map$3$1) {
                    statsViewModel$special$$inlined$map$3$1 = (StatsViewModel$special$$inlined$map$3$1) continuation;
                    int i55 = statsViewModel$special$$inlined$map$3$1.label;
                    if ((i55 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$special$$inlined$map$3$1.label = i55 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$special$$inlined$map$3$1 = new StatsViewModel$special$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    statsViewModel$special$$inlined$map$3$1 = new StatsViewModel$special$$inlined$map$3$1(this, continuation);
                }
                Object obj28 = statsViewModel$special$$inlined$map$3$1.result;
                int i56 = statsViewModel$special$$inlined$map$3$1.label;
                if (i56 == 0) {
                    ResultKt.throwOnFailure(obj28);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$2 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 0);
                    statsViewModel$special$$inlined$map$3$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$2, statsViewModel$special$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i56 == 1) {
                    ResultKt.throwOnFailure(obj28);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 28:
                if (continuation instanceof StatsViewModel$special$$inlined$map$4$1) {
                    statsViewModel$special$$inlined$map$4$1 = (StatsViewModel$special$$inlined$map$4$1) continuation;
                    int i57 = statsViewModel$special$$inlined$map$4$1.label;
                    if ((i57 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$special$$inlined$map$4$1.label = i57 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$special$$inlined$map$4$1 = new StatsViewModel$special$$inlined$map$4$1(this, continuation);
                    }
                } else {
                    statsViewModel$special$$inlined$map$4$1 = new StatsViewModel$special$$inlined$map$4$1(this, continuation);
                }
                Object obj29 = statsViewModel$special$$inlined$map$4$1.result;
                int i58 = statsViewModel$special$$inlined$map$4$1.label;
                if (i58 == 0) {
                    ResultKt.throwOnFailure(obj29);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$3 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 1);
                    statsViewModel$special$$inlined$map$4$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$3, statsViewModel$special$$inlined$map$4$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i58 == 1) {
                    ResultKt.throwOnFailure(obj29);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof TopPlaylistViewModel$special$$inlined$map$1$1) {
                    topPlaylistViewModel$special$$inlined$map$1$1 = (TopPlaylistViewModel$special$$inlined$map$1$1) continuation;
                    int i59 = topPlaylistViewModel$special$$inlined$map$1$1.label;
                    if ((i59 & Integer.MIN_VALUE) != 0) {
                        topPlaylistViewModel$special$$inlined$map$1$1.label = i59 - Integer.MIN_VALUE;
                    } else {
                        topPlaylistViewModel$special$$inlined$map$1$1 = new TopPlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    topPlaylistViewModel$special$$inlined$map$1$1 = new TopPlaylistViewModel$special$$inlined$map$1$1(this, continuation);
                }
                Object obj30 = topPlaylistViewModel$special$$inlined$map$1$1.result;
                int i60 = topPlaylistViewModel$special$$inlined$map$1$1.label;
                if (i60 == 0) {
                    ResultKt.throwOnFailure(obj30);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$4 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 2);
                    topPlaylistViewModel$special$$inlined$map$1$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$4, topPlaylistViewModel$special$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i60 == 1) {
                    ResultKt.throwOnFailure(obj30);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
