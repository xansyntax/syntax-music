package com.metrolist.music.db;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongWithStats;
import com.metrolist.music.viewmodels.ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1;
import com.metrolist.music.viewmodels.LibraryMixViewModel$albums$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LibraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.LocalSearchViewModel$result$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LocalSearchViewModel$result$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1;
import com.metrolist.music.viewmodels.TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1;
import com.metrolist.music.viewmodels.TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1;
import java.util.ArrayList;
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
public final class DatabaseDao$songs$$inlined$map$3 implements Flow {
    public final /* synthetic */ boolean $descending$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3$1, reason: invalid class name */
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
            return DatabaseDao$songs$$inlined$map$3.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ boolean $descending$inlined;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3$2$1, reason: invalid class name */
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

        public /* synthetic */ AnonymousClass2(FlowCollector flowCollector, boolean z, byte b) {
            this.$r8$classId = b;
            this.$this_unsafeFlow = flowCollector;
            this.$descending$inlined = z;
        }

        /* JADX WARN: Code duplicated, block: B:105:0x0186  */
        /* JADX WARN: Code duplicated, block: B:120:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:135:0x01fa  */
        /* JADX WARN: Code duplicated, block: B:150:0x0234  */
        /* JADX WARN: Code duplicated, block: B:165:0x026e  */
        /* JADX WARN: Code duplicated, block: B:180:0x02a8  */
        /* JADX WARN: Code duplicated, block: B:195:0x02e2  */
        /* JADX WARN: Code duplicated, block: B:210:0x031c  */
        /* JADX WARN: Code duplicated, block: B:225:0x0356  */
        /* JADX WARN: Code duplicated, block: B:240:0x0390  */
        /* JADX WARN: Code duplicated, block: B:255:0x03ca  */
        /* JADX WARN: Code duplicated, block: B:270:0x0404  */
        /* JADX WARN: Code duplicated, block: B:285:0x043e  */
        /* JADX WARN: Code duplicated, block: B:300:0x0478  */
        /* JADX WARN: Code duplicated, block: B:315:0x04b2  */
        /* JADX WARN: Code duplicated, block: B:330:0x04ec  */
        /* JADX WARN: Code duplicated, block: B:33:0x007d  */
        /* JADX WARN: Code duplicated, block: B:353:0x054e  */
        /* JADX WARN: Code duplicated, block: B:376:0x05b0  */
        /* JADX WARN: Code duplicated, block: B:391:0x05ea  */
        /* JADX WARN: Code duplicated, block: B:406:0x0624  */
        /* JADX WARN: Code duplicated, block: B:421:0x065e  */
        /* JADX WARN: Code duplicated, block: B:436:0x0698  */
        /* JADX WARN: Code duplicated, block: B:57:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:81:0x012d  */
        /* JADX WARN: Code duplicated, block: B:9:0x0024  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            DatabaseDao$albums$$inlined$map$3$2$1 databaseDao$albums$$inlined$map$3$2$1;
            DatabaseDao$albumsLiked$$inlined$map$3$2$1 databaseDao$albumsLiked$$inlined$map$3$2$1;
            DatabaseDao$albumsUploaded$$inlined$map$3$2$1 databaseDao$albumsUploaded$$inlined$map$3$2$1;
            DatabaseDao$artistSongs$$inlined$map$2$2$1 databaseDao$artistSongs$$inlined$map$2$2$1;
            DatabaseDao$artists$$inlined$map$1$2$1 databaseDao$artists$$inlined$map$1$2$1;
            DatabaseDao$artistsBookmarked$$inlined$map$1$2$1 databaseDao$artistsBookmarked$$inlined$map$1$2$1;
            DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1 databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1;
            DatabaseDao$downloadedSongs$$inlined$map$3$2$1 databaseDao$downloadedSongs$$inlined$map$3$2$1;
            DatabaseDao$likedSongs$$inlined$map$3$2$1 databaseDao$likedSongs$$inlined$map$3$2$1;
            DatabaseDao$playlists$$inlined$map$2$2$1 databaseDao$playlists$$inlined$map$2$2$1;
            DatabaseDao$savedPodcastEpisodes$$inlined$map$3$2$1 databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1;
            DatabaseDao$uploadedSongs$$inlined$map$3$2$1 databaseDao$uploadedSongs$$inlined$map$3$2$1;
            ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1 artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1;
            LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1 libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1;
            LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1 libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1;
            LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1 libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1;
            LibraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1 libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1;
            LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1 libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1;
            LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1 libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1;
            LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1 libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1;
            LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1 libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1;
            LocalSearchViewModel$result$lambda$1$$inlined$map$1$2$1 localSearchViewModel$result$lambda$1$$inlined$map$1$2$1;
            StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1 statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1;
            StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1 statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1;
            TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1 topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            boolean z = this.$descending$inlined;
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
                        List listReversed = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        anonymousClass1.label = 1;
                        return flowCollector.emit(listReversed, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    if (continuation instanceof DatabaseDao$albums$$inlined$map$3$2$1) {
                        databaseDao$albums$$inlined$map$3$2$1 = (DatabaseDao$albums$$inlined$map$3$2$1) continuation;
                        int i3 = databaseDao$albums$$inlined$map$3$2$1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albums$$inlined$map$3$2$1.label = i3 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albums$$inlined$map$3$2$1 = new DatabaseDao$albums$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albums$$inlined$map$3$2$1 = new DatabaseDao$albums$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj3 = databaseDao$albums$$inlined$map$3$2$1.result;
                    int i4 = databaseDao$albums$$inlined$map$3$2$1.label;
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        List listReversed2 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$albums$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed2, databaseDao$albums$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj3);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 2:
                    if (continuation instanceof DatabaseDao$albumsLiked$$inlined$map$3$2$1) {
                        databaseDao$albumsLiked$$inlined$map$3$2$1 = (DatabaseDao$albumsLiked$$inlined$map$3$2$1) continuation;
                        int i5 = databaseDao$albumsLiked$$inlined$map$3$2$1.label;
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albumsLiked$$inlined$map$3$2$1.label = i5 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albumsLiked$$inlined$map$3$2$1 = new DatabaseDao$albumsLiked$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albumsLiked$$inlined$map$3$2$1 = new DatabaseDao$albumsLiked$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj4 = databaseDao$albumsLiked$$inlined$map$3$2$1.result;
                    int i6 = databaseDao$albumsLiked$$inlined$map$3$2$1.label;
                    if (i6 == 0) {
                        ResultKt.throwOnFailure(obj4);
                        List listReversed3 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$albumsLiked$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed3, databaseDao$albumsLiked$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i6 == 1) {
                        ResultKt.throwOnFailure(obj4);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    if (continuation instanceof DatabaseDao$albumsUploaded$$inlined$map$3$2$1) {
                        databaseDao$albumsUploaded$$inlined$map$3$2$1 = (DatabaseDao$albumsUploaded$$inlined$map$3$2$1) continuation;
                        int i7 = databaseDao$albumsUploaded$$inlined$map$3$2$1.label;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            databaseDao$albumsUploaded$$inlined$map$3$2$1.label = i7 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$albumsUploaded$$inlined$map$3$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$albumsUploaded$$inlined$map$3$2$1 = new DatabaseDao$albumsUploaded$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj5 = databaseDao$albumsUploaded$$inlined$map$3$2$1.result;
                    int i8 = databaseDao$albumsUploaded$$inlined$map$3$2$1.label;
                    if (i8 == 0) {
                        ResultKt.throwOnFailure(obj5);
                        List listReversed4 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$albumsUploaded$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed4, databaseDao$albumsUploaded$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i8 == 1) {
                        ResultKt.throwOnFailure(obj5);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    if (continuation instanceof DatabaseDao$artistSongs$$inlined$map$2$2$1) {
                        databaseDao$artistSongs$$inlined$map$2$2$1 = (DatabaseDao$artistSongs$$inlined$map$2$2$1) continuation;
                        int i9 = databaseDao$artistSongs$$inlined$map$2$2$1.label;
                        if ((i9 & Integer.MIN_VALUE) != 0) {
                            databaseDao$artistSongs$$inlined$map$2$2$1.label = i9 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$artistSongs$$inlined$map$2$2$1 = new DatabaseDao$artistSongs$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$artistSongs$$inlined$map$2$2$1 = new DatabaseDao$artistSongs$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj6 = databaseDao$artistSongs$$inlined$map$2$2$1.result;
                    int i10 = databaseDao$artistSongs$$inlined$map$2$2$1.label;
                    if (i10 == 0) {
                        ResultKt.throwOnFailure(obj6);
                        List listReversed5 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$artistSongs$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(listReversed5, databaseDao$artistSongs$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj6);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 5:
                    if (continuation instanceof DatabaseDao$artists$$inlined$map$1$2$1) {
                        databaseDao$artists$$inlined$map$1$2$1 = (DatabaseDao$artists$$inlined$map$1$2$1) continuation;
                        int i11 = databaseDao$artists$$inlined$map$1$2$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            databaseDao$artists$$inlined$map$1$2$1.label = i11 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$artists$$inlined$map$1$2$1 = new DatabaseDao$artists$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$artists$$inlined$map$1$2$1 = new DatabaseDao$artists$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj7 = databaseDao$artists$$inlined$map$1$2$1.result;
                    int i12 = databaseDao$artists$$inlined$map$1$2$1.label;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            ResultKt.throwOnFailure(obj7);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj7);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj8 : (List) obj) {
                        Artist artist = (Artist) obj8;
                        if (artist.artist.isYouTubeArtist() || artist.artist.isLocal) {
                            arrayList.add(obj8);
                        }
                    }
                    List listReversed6 = CollectionsKt__IterablesKt.reversed(arrayList, z);
                    databaseDao$artists$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(listReversed6, databaseDao$artists$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 6:
                    if (continuation instanceof DatabaseDao$artistsBookmarked$$inlined$map$1$2$1) {
                        databaseDao$artistsBookmarked$$inlined$map$1$2$1 = (DatabaseDao$artistsBookmarked$$inlined$map$1$2$1) continuation;
                        int i13 = databaseDao$artistsBookmarked$$inlined$map$1$2$1.label;
                        if ((i13 & Integer.MIN_VALUE) != 0) {
                            databaseDao$artistsBookmarked$$inlined$map$1$2$1.label = i13 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$artistsBookmarked$$inlined$map$1$2$1 = new DatabaseDao$artistsBookmarked$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$artistsBookmarked$$inlined$map$1$2$1 = new DatabaseDao$artistsBookmarked$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj9 = databaseDao$artistsBookmarked$$inlined$map$1$2$1.result;
                    int i14 = databaseDao$artistsBookmarked$$inlined$map$1$2$1.label;
                    if (i14 != 0) {
                        if (i14 == 1) {
                            ResultKt.throwOnFailure(obj9);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj9);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj10 : (List) obj) {
                        Artist artist2 = (Artist) obj10;
                        if (artist2.artist.isYouTubeArtist() || artist2.artist.isLocal) {
                            arrayList2.add(obj10);
                        }
                    }
                    List listReversed7 = CollectionsKt__IterablesKt.reversed(arrayList2, z);
                    databaseDao$artistsBookmarked$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(listReversed7, databaseDao$artistsBookmarked$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    if (continuation instanceof DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1) {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1 = (DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1) continuation;
                        int i15 = databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1.label;
                        if ((i15 & Integer.MIN_VALUE) != 0) {
                            databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1.label = i15 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj11 = databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1.result;
                    int i16 = databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1.label;
                    if (i16 == 0) {
                        ResultKt.throwOnFailure(obj11);
                        List listReversed8 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed8, databaseDao$downloadedPodcastEpisodes$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj11);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 8:
                    if (continuation instanceof DatabaseDao$downloadedSongs$$inlined$map$3$2$1) {
                        databaseDao$downloadedSongs$$inlined$map$3$2$1 = (DatabaseDao$downloadedSongs$$inlined$map$3$2$1) continuation;
                        int i17 = databaseDao$downloadedSongs$$inlined$map$3$2$1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            databaseDao$downloadedSongs$$inlined$map$3$2$1.label = i17 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$downloadedSongs$$inlined$map$3$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$downloadedSongs$$inlined$map$3$2$1 = new DatabaseDao$downloadedSongs$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj12 = databaseDao$downloadedSongs$$inlined$map$3$2$1.result;
                    int i18 = databaseDao$downloadedSongs$$inlined$map$3$2$1.label;
                    if (i18 == 0) {
                        ResultKt.throwOnFailure(obj12);
                        List listReversed9 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$downloadedSongs$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed9, databaseDao$downloadedSongs$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i18 == 1) {
                        ResultKt.throwOnFailure(obj12);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 9:
                    if (continuation instanceof DatabaseDao$likedSongs$$inlined$map$3$2$1) {
                        databaseDao$likedSongs$$inlined$map$3$2$1 = (DatabaseDao$likedSongs$$inlined$map$3$2$1) continuation;
                        int i19 = databaseDao$likedSongs$$inlined$map$3$2$1.label;
                        if ((i19 & Integer.MIN_VALUE) != 0) {
                            databaseDao$likedSongs$$inlined$map$3$2$1.label = i19 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$likedSongs$$inlined$map$3$2$1 = new DatabaseDao$likedSongs$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$likedSongs$$inlined$map$3$2$1 = new DatabaseDao$likedSongs$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj13 = databaseDao$likedSongs$$inlined$map$3$2$1.result;
                    int i20 = databaseDao$likedSongs$$inlined$map$3$2$1.label;
                    if (i20 == 0) {
                        ResultKt.throwOnFailure(obj13);
                        List listReversed10 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$likedSongs$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed10, databaseDao$likedSongs$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i20 == 1) {
                        ResultKt.throwOnFailure(obj13);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 10:
                    if (continuation instanceof DatabaseDao$playlists$$inlined$map$2$2$1) {
                        databaseDao$playlists$$inlined$map$2$2$1 = (DatabaseDao$playlists$$inlined$map$2$2$1) continuation;
                        int i21 = databaseDao$playlists$$inlined$map$2$2$1.label;
                        if ((i21 & Integer.MIN_VALUE) != 0) {
                            databaseDao$playlists$$inlined$map$2$2$1.label = i21 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$playlists$$inlined$map$2$2$1 = new DatabaseDao$playlists$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$playlists$$inlined$map$2$2$1 = new DatabaseDao$playlists$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj14 = databaseDao$playlists$$inlined$map$2$2$1.result;
                    int i22 = databaseDao$playlists$$inlined$map$2$2$1.label;
                    if (i22 == 0) {
                        ResultKt.throwOnFailure(obj14);
                        List listReversed11 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$playlists$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(listReversed11, databaseDao$playlists$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i22 == 1) {
                        ResultKt.throwOnFailure(obj14);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 11:
                    if (continuation instanceof DatabaseDao$savedPodcastEpisodes$$inlined$map$3$2$1) {
                        databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1 = (DatabaseDao$savedPodcastEpisodes$$inlined$map$3$2$1) continuation;
                        int i23 = databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1.label;
                        if ((i23 & Integer.MIN_VALUE) != 0) {
                            databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1.label = i23 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj15 = databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1.result;
                    int i24 = databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1.label;
                    if (i24 == 0) {
                        ResultKt.throwOnFailure(obj15);
                        List listReversed12 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed12, databaseDao$savedPodcastEpisodes$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i24 == 1) {
                        ResultKt.throwOnFailure(obj15);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (continuation instanceof DatabaseDao$uploadedSongs$$inlined$map$3$2$1) {
                        databaseDao$uploadedSongs$$inlined$map$3$2$1 = (DatabaseDao$uploadedSongs$$inlined$map$3$2$1) continuation;
                        int i25 = databaseDao$uploadedSongs$$inlined$map$3$2$1.label;
                        if ((i25 & Integer.MIN_VALUE) != 0) {
                            databaseDao$uploadedSongs$$inlined$map$3$2$1.label = i25 - Integer.MIN_VALUE;
                        } else {
                            databaseDao$uploadedSongs$$inlined$map$3$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        databaseDao$uploadedSongs$$inlined$map$3$2$1 = new DatabaseDao$uploadedSongs$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj16 = databaseDao$uploadedSongs$$inlined$map$3$2$1.result;
                    int i26 = databaseDao$uploadedSongs$$inlined$map$3$2$1.label;
                    if (i26 == 0) {
                        ResultKt.throwOnFailure(obj16);
                        List listReversed13 = CollectionsKt__IterablesKt.reversed((List) obj, z);
                        databaseDao$uploadedSongs$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listReversed13, databaseDao$uploadedSongs$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i26 == 1) {
                        ResultKt.throwOnFailure(obj16);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 13:
                    if (continuation instanceof ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1) {
                        artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1 = (ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1) continuation;
                        int i27 = artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1.label;
                        if ((i27 & Integer.MIN_VALUE) != 0) {
                            artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1.label = i27 - Integer.MIN_VALUE;
                        } else {
                            artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1 = new ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1 = new ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj17 = artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1.result;
                    int i28 = artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1.label;
                    if (i28 == 0) {
                        ResultKt.throwOnFailure(obj17);
                        List listFilterExplicitAlbums = CollectionsKt__IterablesKt.filterExplicitAlbums((List) obj, z);
                        artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicitAlbums, artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i28 == 1) {
                        ResultKt.throwOnFailure(obj17);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 14:
                    if (continuation instanceof LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1) {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1 = (LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1) continuation;
                        int i29 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1.label;
                        if ((i29 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1.label = i29 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj18 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1.result;
                    int i30 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1.label;
                    if (i30 == 0) {
                        ResultKt.throwOnFailure(obj18);
                        List listFilterExplicitAlbums2 = CollectionsKt__IterablesKt.filterExplicitAlbums((List) obj, z);
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicitAlbums2, libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i30 == 1) {
                        ResultKt.throwOnFailure(obj18);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 15:
                    if (continuation instanceof LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1) {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1 = (LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1) continuation;
                        int i31 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1.label;
                        if ((i31 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1.label = i31 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1(this, continuation);
                    }
                    Object obj19 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1.result;
                    int i32 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1.label;
                    if (i32 == 0) {
                        ResultKt.throwOnFailure(obj19);
                        List listFilterExplicitAlbums3 = CollectionsKt__IterablesKt.filterExplicitAlbums((List) obj, z);
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicitAlbums3, libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i32 == 1) {
                        ResultKt.throwOnFailure(obj19);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 16:
                    if (continuation instanceof LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1) {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1 = (LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1) continuation;
                        int i33 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1.label;
                        if ((i33 & Integer.MIN_VALUE) != 0) {
                            libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1.label = i33 - Integer.MIN_VALUE;
                        } else {
                            libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1(this, continuation);
                        }
                    } else {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1(this, continuation);
                    }
                    Object obj20 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1.result;
                    int i34 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1.label;
                    if (i34 == 0) {
                        ResultKt.throwOnFailure(obj20);
                        List listFilterExplicitAlbums4 = CollectionsKt__IterablesKt.filterExplicitAlbums((List) obj, z);
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicitAlbums4, libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i34 == 1) {
                        ResultKt.throwOnFailure(obj20);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 17:
                    if (continuation instanceof LibraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1) {
                        libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1 = (LibraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1) continuation;
                        int i35 = libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1.label;
                        if ((i35 & Integer.MIN_VALUE) != 0) {
                            libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1.label = i35 - Integer.MIN_VALUE;
                        } else {
                            libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1 = new LibraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1 = new LibraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj21 = libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1.result;
                    int i36 = libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1.label;
                    if (i36 == 0) {
                        ResultKt.throwOnFailure(obj21);
                        List listFilterExplicitAlbums5 = CollectionsKt__IterablesKt.filterExplicitAlbums((List) obj, z);
                        libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicitAlbums5, libraryMixViewModel$albums$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i36 == 1) {
                        ResultKt.throwOnFailure(obj21);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 18:
                    if (continuation instanceof LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1) {
                        libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1 = (LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1) continuation;
                        int i37 = libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1.label;
                        if ((i37 & Integer.MIN_VALUE) != 0) {
                            libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1.label = i37 - Integer.MIN_VALUE;
                        } else {
                            libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1 = new LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1 = new LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj22 = libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1.result;
                    int i38 = libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1.label;
                    if (i38 == 0) {
                        ResultKt.throwOnFailure(obj22);
                        List listFilterYoutubeShorts = CollectionsKt__IterablesKt.filterYoutubeShorts((List) obj, z);
                        libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterYoutubeShorts, libraryMixViewModel$playlists$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i38 == 1) {
                        ResultKt.throwOnFailure(obj22);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 19:
                    if (continuation instanceof LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1) {
                        libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1 = (LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1) continuation;
                        int i39 = libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1.label;
                        if ((i39 & Integer.MIN_VALUE) != 0) {
                            libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1.label = i39 - Integer.MIN_VALUE;
                        } else {
                            libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1 = new LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1 = new LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj23 = libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1.result;
                    int i40 = libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1.label;
                    if (i40 == 0) {
                        ResultKt.throwOnFailure(obj23);
                        List listFilterYoutubeShorts2 = CollectionsKt__IterablesKt.filterYoutubeShorts((List) obj, z);
                        libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterYoutubeShorts2, libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i40 == 1) {
                        ResultKt.throwOnFailure(obj23);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 20:
                    if (continuation instanceof LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1) {
                        libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1 = (LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1) continuation;
                        int i41 = libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1.label;
                        if ((i41 & Integer.MIN_VALUE) != 0) {
                            libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1.label = i41 - Integer.MIN_VALUE;
                        } else {
                            libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1 = new LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1 = new LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj24 = libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1.result;
                    int i42 = libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1.label;
                    if (i42 == 0) {
                        ResultKt.throwOnFailure(obj24);
                        List listFilterExplicit = CollectionsKt__IterablesKt.filterExplicit((List) obj, z);
                        libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicit, libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i42 == 1) {
                        ResultKt.throwOnFailure(obj24);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 21:
                    if (continuation instanceof LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1) {
                        libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1 = (LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1) continuation;
                        int i43 = libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1.label;
                        if ((i43 & Integer.MIN_VALUE) != 0) {
                            libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1.label = i43 - Integer.MIN_VALUE;
                        } else {
                            libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1 = new LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1 = new LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj25 = libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1.result;
                    int i44 = libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1.label;
                    if (i44 == 0) {
                        ResultKt.throwOnFailure(obj25);
                        List listFilterExplicit2 = CollectionsKt__IterablesKt.filterExplicit((List) obj, z);
                        libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1.label = 1;
                        return flowCollector.emit(listFilterExplicit2, libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (i44 == 1) {
                        ResultKt.throwOnFailure(obj25);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 22:
                    if (continuation instanceof LocalSearchViewModel$result$lambda$1$$inlined$map$1$2$1) {
                        localSearchViewModel$result$lambda$1$$inlined$map$1$2$1 = (LocalSearchViewModel$result$lambda$1$$inlined$map$1$2$1) continuation;
                        int i45 = localSearchViewModel$result$lambda$1$$inlined$map$1$2$1.label;
                        if ((i45 & Integer.MIN_VALUE) != 0) {
                            localSearchViewModel$result$lambda$1$$inlined$map$1$2$1.label = i45 - Integer.MIN_VALUE;
                        } else {
                            localSearchViewModel$result$lambda$1$$inlined$map$1$2$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        localSearchViewModel$result$lambda$1$$inlined$map$1$2$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj26 = localSearchViewModel$result$lambda$1$$inlined$map$1$2$1.result;
                    int i46 = localSearchViewModel$result$lambda$1$$inlined$map$1$2$1.label;
                    if (i46 != 0) {
                        if (i46 == 1) {
                            ResultKt.throwOnFailure(obj26);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj26);
                    List list = (List) obj;
                    if (z) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj27 : list) {
                            if (!((Song) obj27).song.isVideo) {
                                arrayList3.add(obj27);
                            }
                        }
                        list = arrayList3;
                    }
                    localSearchViewModel$result$lambda$1$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(list, localSearchViewModel$result$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 23:
                    if (continuation instanceof StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1) {
                        statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1 = (StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1) continuation;
                        int i47 = statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1.label;
                        if ((i47 & Integer.MIN_VALUE) != 0) {
                            statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1.label = i47 - Integer.MIN_VALUE;
                        } else {
                            statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1 = new StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1 = new StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj28 = statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1.result;
                    int i48 = statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1.label;
                    if (i48 != 0) {
                        if (i48 == 1) {
                            ResultKt.throwOnFailure(obj28);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj28);
                    List list2 = (List) obj;
                    if (z) {
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj29 : list2) {
                            if (!((Song) obj29).song.isVideo) {
                                arrayList4.add(obj29);
                            }
                        }
                        list2 = arrayList4;
                    }
                    statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(list2, statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                case 24:
                    if (continuation instanceof StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1) {
                        statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1 = (StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1) continuation;
                        int i49 = statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1.label;
                        if ((i49 & Integer.MIN_VALUE) != 0) {
                            statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1.label = i49 - Integer.MIN_VALUE;
                        } else {
                            statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1 = new StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1 = new StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj30 = statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1.result;
                    int i50 = statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1.label;
                    if (i50 != 0) {
                        if (i50 == 1) {
                            ResultKt.throwOnFailure(obj30);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj30);
                    List list3 = (List) obj;
                    if (z) {
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj31 : list3) {
                            if (!((SongWithStats) obj31).isVideo) {
                                arrayList5.add(obj31);
                            }
                        }
                        list3 = arrayList5;
                    }
                    statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(list3, statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    if (continuation instanceof TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1) {
                        topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1 = (TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1) continuation;
                        int i51 = topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1.label;
                        if ((i51 & Integer.MIN_VALUE) != 0) {
                            topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1.label = i51 - Integer.MIN_VALUE;
                        } else {
                            topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1 = new TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                        }
                    } else {
                        topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1 = new TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1(this, continuation);
                    }
                    Object obj32 = topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1.result;
                    int i52 = topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1.label;
                    if (i52 != 0) {
                        if (i52 == 1) {
                            ResultKt.throwOnFailure(obj32);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj32);
                    List list4 = (List) obj;
                    if (z) {
                        ArrayList arrayList6 = new ArrayList();
                        for (Object obj33 : list4) {
                            if (!((Song) obj33).song.isVideo) {
                                arrayList6.add(obj33);
                            }
                        }
                        list4 = arrayList6;
                    }
                    topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1.label = 1;
                    return flowCollector.emit(list4, topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public /* synthetic */ DatabaseDao$songs$$inlined$map$3(Flow flow, boolean z, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeTransform$inlined = flow;
        this.$descending$inlined = z;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:144:0x0237  */
    /* JADX WARN: Code duplicated, block: B:159:0x0272  */
    /* JADX WARN: Code duplicated, block: B:174:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:189:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:204:0x0323  */
    /* JADX WARN: Code duplicated, block: B:219:0x035e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0399  */
    /* JADX WARN: Code duplicated, block: B:249:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:264:0x040f  */
    /* JADX WARN: Code duplicated, block: B:279:0x044a  */
    /* JADX WARN: Code duplicated, block: B:294:0x0484  */
    /* JADX WARN: Code duplicated, block: B:309:0x04be  */
    /* JADX WARN: Code duplicated, block: B:324:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:339:0x0532  */
    /* JADX WARN: Code duplicated, block: B:354:0x056c  */
    /* JADX WARN: Code duplicated, block: B:369:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:384:0x05df  */
    /* JADX WARN: Code duplicated, block: B:39:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:69:0x0110  */
    /* JADX WARN: Code duplicated, block: B:84:0x014b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0186  */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        DatabaseDao$albums$$inlined$map$3$1 databaseDao$albums$$inlined$map$3$1;
        DatabaseDao$albumsLiked$$inlined$map$3$1 databaseDao$albumsLiked$$inlined$map$3$1;
        DatabaseDao$albumsUploaded$$inlined$map$3$1 databaseDao$albumsUploaded$$inlined$map$3$1;
        DatabaseDao$artistSongs$$inlined$map$2$1 databaseDao$artistSongs$$inlined$map$2$1;
        DatabaseDao$artists$$inlined$map$1$1 databaseDao$artists$$inlined$map$1$1;
        DatabaseDao$artistsBookmarked$$inlined$map$1$1 databaseDao$artistsBookmarked$$inlined$map$1$1;
        DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$1 databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1;
        DatabaseDao$downloadedSongs$$inlined$map$3$1 databaseDao$downloadedSongs$$inlined$map$3$1;
        DatabaseDao$likedSongs$$inlined$map$3$1 databaseDao$likedSongs$$inlined$map$3$1;
        DatabaseDao$playlists$$inlined$map$2$1 databaseDao$playlists$$inlined$map$2$1;
        DatabaseDao$savedPodcastEpisodes$$inlined$map$3$1 databaseDao$savedPodcastEpisodes$$inlined$map$3$1;
        DatabaseDao$uploadedSongs$$inlined$map$3$1 databaseDao$uploadedSongs$$inlined$map$3$1;
        ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1 artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1;
        LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1 libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1;
        LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1 libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1;
        LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1 libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1;
        LibraryMixViewModel$albums$lambda$1$$inlined$map$1$1 libraryMixViewModel$albums$lambda$1$$inlined$map$1$1;
        LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$1 libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1;
        LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1 libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1;
        LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1 libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1;
        LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1 libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1;
        LocalSearchViewModel$result$lambda$1$$inlined$map$1$1 localSearchViewModel$result$lambda$1$$inlined$map$1$1;
        StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1 statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1;
        StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1 statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1;
        TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1 topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.$descending$inlined;
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
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, z, (byte) 0);
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
                if (continuation instanceof DatabaseDao$albums$$inlined$map$3$1) {
                    databaseDao$albums$$inlined$map$3$1 = (DatabaseDao$albums$$inlined$map$3$1) continuation;
                    int i3 = databaseDao$albums$$inlined$map$3$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albums$$inlined$map$3$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albums$$inlined$map$3$1 = new DatabaseDao$albums$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$albums$$inlined$map$3$1 = new DatabaseDao$albums$$inlined$map$3$1(this, continuation);
                }
                Object obj2 = databaseDao$albums$$inlined$map$3$1.result;
                int i4 = databaseDao$albums$$inlined$map$3$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(flowCollector, z, b2);
                    databaseDao$albums$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass3, databaseDao$albums$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof DatabaseDao$albumsLiked$$inlined$map$3$1) {
                    databaseDao$albumsLiked$$inlined$map$3$1 = (DatabaseDao$albumsLiked$$inlined$map$3$1) continuation;
                    int i5 = databaseDao$albumsLiked$$inlined$map$3$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albumsLiked$$inlined$map$3$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albumsLiked$$inlined$map$3$1 = new DatabaseDao$albumsLiked$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$albumsLiked$$inlined$map$3$1 = new DatabaseDao$albumsLiked$$inlined$map$3$1(this, continuation);
                }
                Object obj3 = databaseDao$albumsLiked$$inlined$map$3$1.result;
                int i6 = databaseDao$albumsLiked$$inlined$map$3$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(flowCollector, z, (byte) 2);
                    databaseDao$albumsLiked$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass4, databaseDao$albumsLiked$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof DatabaseDao$albumsUploaded$$inlined$map$3$1) {
                    databaseDao$albumsUploaded$$inlined$map$3$1 = (DatabaseDao$albumsUploaded$$inlined$map$3$1) continuation;
                    int i7 = databaseDao$albumsUploaded$$inlined$map$3$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        databaseDao$albumsUploaded$$inlined$map$3$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$albumsUploaded$$inlined$map$3$1 = new DatabaseDao$albumsUploaded$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$albumsUploaded$$inlined$map$3$1 = new DatabaseDao$albumsUploaded$$inlined$map$3$1(this, continuation);
                }
                Object obj4 = databaseDao$albumsUploaded$$inlined$map$3$1.result;
                int i8 = databaseDao$albumsUploaded$$inlined$map$3$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(flowCollector, z, (byte) 3);
                    databaseDao$albumsUploaded$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass5, databaseDao$albumsUploaded$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof DatabaseDao$artistSongs$$inlined$map$2$1) {
                    databaseDao$artistSongs$$inlined$map$2$1 = (DatabaseDao$artistSongs$$inlined$map$2$1) continuation;
                    int i9 = databaseDao$artistSongs$$inlined$map$2$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        databaseDao$artistSongs$$inlined$map$2$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$artistSongs$$inlined$map$2$1 = new DatabaseDao$artistSongs$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$artistSongs$$inlined$map$2$1 = new DatabaseDao$artistSongs$$inlined$map$2$1(this, continuation);
                }
                Object obj5 = databaseDao$artistSongs$$inlined$map$2$1.result;
                int i10 = databaseDao$artistSongs$$inlined$map$2$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(flowCollector, z, (byte) 4);
                    databaseDao$artistSongs$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass6, databaseDao$artistSongs$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                if (continuation instanceof DatabaseDao$artists$$inlined$map$1$1) {
                    databaseDao$artists$$inlined$map$1$1 = (DatabaseDao$artists$$inlined$map$1$1) continuation;
                    int i11 = databaseDao$artists$$inlined$map$1$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        databaseDao$artists$$inlined$map$1$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$artists$$inlined$map$1$1 = new DatabaseDao$artists$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$artists$$inlined$map$1$1 = new DatabaseDao$artists$$inlined$map$1$1(this, continuation);
                }
                Object obj6 = databaseDao$artists$$inlined$map$1$1.result;
                int i12 = databaseDao$artists$$inlined$map$1$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(flowCollector, z, (byte) 5);
                    databaseDao$artists$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass7, databaseDao$artists$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i12 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                if (continuation instanceof DatabaseDao$artistsBookmarked$$inlined$map$1$1) {
                    databaseDao$artistsBookmarked$$inlined$map$1$1 = (DatabaseDao$artistsBookmarked$$inlined$map$1$1) continuation;
                    int i13 = databaseDao$artistsBookmarked$$inlined$map$1$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        databaseDao$artistsBookmarked$$inlined$map$1$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$artistsBookmarked$$inlined$map$1$1 = new DatabaseDao$artistsBookmarked$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    databaseDao$artistsBookmarked$$inlined$map$1$1 = new DatabaseDao$artistsBookmarked$$inlined$map$1$1(this, continuation);
                }
                Object obj7 = databaseDao$artistsBookmarked$$inlined$map$1$1.result;
                int i14 = databaseDao$artistsBookmarked$$inlined$map$1$1.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2(flowCollector, z, (byte) 6);
                    databaseDao$artistsBookmarked$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass8, databaseDao$artistsBookmarked$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i14 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                if (continuation instanceof DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$1) {
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1 = (DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$1) continuation;
                    int i15 = databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1 = new DatabaseDao$downloadedPodcastEpisodes$$inlined$map$3$1(this, continuation);
                }
                Object obj8 = databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1.result;
                int i16 = databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(flowCollector, z, (byte) 7);
                    databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass9, databaseDao$downloadedPodcastEpisodes$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i16 == 1) {
                    ResultKt.throwOnFailure(obj8);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                if (continuation instanceof DatabaseDao$downloadedSongs$$inlined$map$3$1) {
                    databaseDao$downloadedSongs$$inlined$map$3$1 = (DatabaseDao$downloadedSongs$$inlined$map$3$1) continuation;
                    int i17 = databaseDao$downloadedSongs$$inlined$map$3$1.label;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        databaseDao$downloadedSongs$$inlined$map$3$1.label = i17 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$downloadedSongs$$inlined$map$3$1 = new DatabaseDao$downloadedSongs$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$downloadedSongs$$inlined$map$3$1 = new DatabaseDao$downloadedSongs$$inlined$map$3$1(this, continuation);
                }
                Object obj9 = databaseDao$downloadedSongs$$inlined$map$3$1.result;
                int i18 = databaseDao$downloadedSongs$$inlined$map$3$1.label;
                if (i18 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(flowCollector, z, (byte) 8);
                    databaseDao$downloadedSongs$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass10, databaseDao$downloadedSongs$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i18 == 1) {
                    ResultKt.throwOnFailure(obj9);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                if (continuation instanceof DatabaseDao$likedSongs$$inlined$map$3$1) {
                    databaseDao$likedSongs$$inlined$map$3$1 = (DatabaseDao$likedSongs$$inlined$map$3$1) continuation;
                    int i19 = databaseDao$likedSongs$$inlined$map$3$1.label;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        databaseDao$likedSongs$$inlined$map$3$1.label = i19 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$likedSongs$$inlined$map$3$1 = new DatabaseDao$likedSongs$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$likedSongs$$inlined$map$3$1 = new DatabaseDao$likedSongs$$inlined$map$3$1(this, continuation);
                }
                Object obj10 = databaseDao$likedSongs$$inlined$map$3$1.result;
                int i20 = databaseDao$likedSongs$$inlined$map$3$1.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj10);
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2(flowCollector, z, (byte) 9);
                    databaseDao$likedSongs$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass11, databaseDao$likedSongs$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i20 == 1) {
                    ResultKt.throwOnFailure(obj10);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 10:
                if (continuation instanceof DatabaseDao$playlists$$inlined$map$2$1) {
                    databaseDao$playlists$$inlined$map$2$1 = (DatabaseDao$playlists$$inlined$map$2$1) continuation;
                    int i21 = databaseDao$playlists$$inlined$map$2$1.label;
                    if ((i21 & Integer.MIN_VALUE) != 0) {
                        databaseDao$playlists$$inlined$map$2$1.label = i21 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$playlists$$inlined$map$2$1 = new DatabaseDao$playlists$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    databaseDao$playlists$$inlined$map$2$1 = new DatabaseDao$playlists$$inlined$map$2$1(this, continuation);
                }
                Object obj11 = databaseDao$playlists$$inlined$map$2$1.result;
                int i22 = databaseDao$playlists$$inlined$map$2$1.label;
                if (i22 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2(flowCollector, z, (byte) 10);
                    databaseDao$playlists$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass12, databaseDao$playlists$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i22 == 1) {
                    ResultKt.throwOnFailure(obj11);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                if (continuation instanceof DatabaseDao$savedPodcastEpisodes$$inlined$map$3$1) {
                    databaseDao$savedPodcastEpisodes$$inlined$map$3$1 = (DatabaseDao$savedPodcastEpisodes$$inlined$map$3$1) continuation;
                    int i23 = databaseDao$savedPodcastEpisodes$$inlined$map$3$1.label;
                    if ((i23 & Integer.MIN_VALUE) != 0) {
                        databaseDao$savedPodcastEpisodes$$inlined$map$3$1.label = i23 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$savedPodcastEpisodes$$inlined$map$3$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$savedPodcastEpisodes$$inlined$map$3$1 = new DatabaseDao$savedPodcastEpisodes$$inlined$map$3$1(this, continuation);
                }
                Object obj12 = databaseDao$savedPodcastEpisodes$$inlined$map$3$1.result;
                int i24 = databaseDao$savedPodcastEpisodes$$inlined$map$3$1.label;
                if (i24 == 0) {
                    ResultKt.throwOnFailure(obj12);
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2(flowCollector, z, (byte) 11);
                    databaseDao$savedPodcastEpisodes$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass13, databaseDao$savedPodcastEpisodes$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i24 == 1) {
                    ResultKt.throwOnFailure(obj12);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof DatabaseDao$uploadedSongs$$inlined$map$3$1) {
                    databaseDao$uploadedSongs$$inlined$map$3$1 = (DatabaseDao$uploadedSongs$$inlined$map$3$1) continuation;
                    int i25 = databaseDao$uploadedSongs$$inlined$map$3$1.label;
                    if ((i25 & Integer.MIN_VALUE) != 0) {
                        databaseDao$uploadedSongs$$inlined$map$3$1.label = i25 - Integer.MIN_VALUE;
                    } else {
                        databaseDao$uploadedSongs$$inlined$map$3$1 = new DatabaseDao$uploadedSongs$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    databaseDao$uploadedSongs$$inlined$map$3$1 = new DatabaseDao$uploadedSongs$$inlined$map$3$1(this, continuation);
                }
                Object obj13 = databaseDao$uploadedSongs$$inlined$map$3$1.result;
                int i26 = databaseDao$uploadedSongs$$inlined$map$3$1.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj13);
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2(flowCollector, z, (byte) 12);
                    databaseDao$uploadedSongs$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass14, databaseDao$uploadedSongs$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i26 == 1) {
                    ResultKt.throwOnFailure(obj13);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 13:
                if (continuation instanceof ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1) {
                    artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1 = (ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1) continuation;
                    int i27 = artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1.label;
                    if ((i27 & Integer.MIN_VALUE) != 0) {
                        artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1.label = i27 - Integer.MIN_VALUE;
                    } else {
                        artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1 = new ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1 = new ArtistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj14 = artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1.result;
                int i28 = artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj14);
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2(flowCollector, z, (byte) 13);
                    artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass15, artistViewModel$libraryAlbums$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i28 == 1) {
                    ResultKt.throwOnFailure(obj14);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                if (continuation instanceof LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1) {
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1 = (LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1) continuation;
                    int i29 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1.label;
                    if ((i29 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1.label = i29 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj15 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1.result;
                int i30 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1.label;
                if (i30 == 0) {
                    ResultKt.throwOnFailure(obj15);
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2(flowCollector, z, (byte) 14);
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass16, libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i30 == 1) {
                    ResultKt.throwOnFailure(obj15);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 15:
                if (continuation instanceof LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1) {
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1 = (LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1) continuation;
                    int i31 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1.label;
                    if ((i31 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1.label = i31 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1(this, continuation);
                }
                Object obj16 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1.result;
                int i32 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj16);
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2(flowCollector, z, (byte) 15);
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1.label = 1;
                    return flow.collect(anonymousClass17, libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i32 == 1) {
                    ResultKt.throwOnFailure(obj16);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 16:
                if (continuation instanceof LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1) {
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1 = (LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1) continuation;
                    int i33 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1.label;
                    if ((i33 & Integer.MIN_VALUE) != 0) {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1.label = i33 - Integer.MIN_VALUE;
                    } else {
                        libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1 = new LibraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1(this, continuation);
                }
                Object obj17 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1.result;
                int i34 = libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj17);
                    AnonymousClass2 anonymousClass18 = new AnonymousClass2(flowCollector, z, (byte) 16);
                    libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1.label = 1;
                    return flow.collect(anonymousClass18, libraryAlbumsViewModel$allAlbums$lambda$1$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i34 == 1) {
                    ResultKt.throwOnFailure(obj17);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 17:
                if (continuation instanceof LibraryMixViewModel$albums$lambda$1$$inlined$map$1$1) {
                    libraryMixViewModel$albums$lambda$1$$inlined$map$1$1 = (LibraryMixViewModel$albums$lambda$1$$inlined$map$1$1) continuation;
                    int i35 = libraryMixViewModel$albums$lambda$1$$inlined$map$1$1.label;
                    if ((i35 & Integer.MIN_VALUE) != 0) {
                        libraryMixViewModel$albums$lambda$1$$inlined$map$1$1.label = i35 - Integer.MIN_VALUE;
                    } else {
                        libraryMixViewModel$albums$lambda$1$$inlined$map$1$1 = new LibraryMixViewModel$albums$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryMixViewModel$albums$lambda$1$$inlined$map$1$1 = new LibraryMixViewModel$albums$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj18 = libraryMixViewModel$albums$lambda$1$$inlined$map$1$1.result;
                int i36 = libraryMixViewModel$albums$lambda$1$$inlined$map$1$1.label;
                if (i36 == 0) {
                    ResultKt.throwOnFailure(obj18);
                    AnonymousClass2 anonymousClass19 = new AnonymousClass2(flowCollector, z, (byte) 17);
                    libraryMixViewModel$albums$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass19, libraryMixViewModel$albums$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i36 == 1) {
                    ResultKt.throwOnFailure(obj18);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 18:
                if (continuation instanceof LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$1) {
                    libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1 = (LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$1) continuation;
                    int i37 = libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1.label;
                    if ((i37 & Integer.MIN_VALUE) != 0) {
                        libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1.label = i37 - Integer.MIN_VALUE;
                    } else {
                        libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1 = new LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1 = new LibraryMixViewModel$playlists$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj19 = libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1.result;
                int i38 = libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1.label;
                if (i38 == 0) {
                    ResultKt.throwOnFailure(obj19);
                    AnonymousClass2 anonymousClass20 = new AnonymousClass2(flowCollector, z, (byte) 18);
                    libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass20, libraryMixViewModel$playlists$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i38 == 1) {
                    ResultKt.throwOnFailure(obj19);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 19:
                if (continuation instanceof LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1) {
                    libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1 = (LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1) continuation;
                    int i39 = libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1.label;
                    if ((i39 & Integer.MIN_VALUE) != 0) {
                        libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1.label = i39 - Integer.MIN_VALUE;
                    } else {
                        libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1 = new LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1 = new LibraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj20 = libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1.result;
                int i40 = libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1.label;
                if (i40 == 0) {
                    ResultKt.throwOnFailure(obj20);
                    AnonymousClass2 anonymousClass21 = new AnonymousClass2(flowCollector, z, (byte) 19);
                    libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass21, libraryPlaylistsViewModel$allPlaylists$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i40 == 1) {
                    ResultKt.throwOnFailure(obj20);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 20:
                if (continuation instanceof LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1) {
                    libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1 = (LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1) continuation;
                    int i41 = libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1.label;
                    if ((i41 & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1.label = i41 - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1 = new LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1 = new LibraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj21 = libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1.result;
                int i42 = libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1.label;
                if (i42 == 0) {
                    ResultKt.throwOnFailure(obj21);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(flowCollector, z, (byte) 20);
                    libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass22, libraryPodcastsViewModel$downloadedEpisodes$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i42 == 1) {
                    ResultKt.throwOnFailure(obj21);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 21:
                if (continuation instanceof LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1) {
                    libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1 = (LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1) continuation;
                    int i43 = libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1.label;
                    if ((i43 & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1.label = i43 - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1 = new LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1 = new LibraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj22 = libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1.result;
                int i44 = libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1.label;
                if (i44 == 0) {
                    ResultKt.throwOnFailure(obj22);
                    AnonymousClass2 anonymousClass23 = new AnonymousClass2(flowCollector, z, (byte) 21);
                    libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass23, libraryPodcastsViewModel$savedEpisodes$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i44 == 1) {
                    ResultKt.throwOnFailure(obj22);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 22:
                if (continuation instanceof LocalSearchViewModel$result$lambda$1$$inlined$map$1$1) {
                    localSearchViewModel$result$lambda$1$$inlined$map$1$1 = (LocalSearchViewModel$result$lambda$1$$inlined$map$1$1) continuation;
                    int i45 = localSearchViewModel$result$lambda$1$$inlined$map$1$1.label;
                    if ((i45 & Integer.MIN_VALUE) != 0) {
                        localSearchViewModel$result$lambda$1$$inlined$map$1$1.label = i45 - Integer.MIN_VALUE;
                    } else {
                        localSearchViewModel$result$lambda$1$$inlined$map$1$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    localSearchViewModel$result$lambda$1$$inlined$map$1$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj23 = localSearchViewModel$result$lambda$1$$inlined$map$1$1.result;
                int i46 = localSearchViewModel$result$lambda$1$$inlined$map$1$1.label;
                if (i46 == 0) {
                    ResultKt.throwOnFailure(obj23);
                    AnonymousClass2 anonymousClass24 = new AnonymousClass2(flowCollector, z, (byte) 22);
                    localSearchViewModel$result$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass24, localSearchViewModel$result$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i46 == 1) {
                    ResultKt.throwOnFailure(obj23);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 23:
                if (continuation instanceof StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1) {
                    statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1 = (StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1) continuation;
                    int i47 = statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1.label;
                    if ((i47 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1.label = i47 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1 = new StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1 = new StatsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj24 = statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1.result;
                int i48 = statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1.label;
                if (i48 == 0) {
                    ResultKt.throwOnFailure(obj24);
                    AnonymousClass2 anonymousClass25 = new AnonymousClass2(flowCollector, z, (byte) 23);
                    statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass25, statsViewModel$mostPlayedSongs$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i48 == 1) {
                    ResultKt.throwOnFailure(obj24);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 24:
                if (continuation instanceof StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1) {
                    statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1 = (StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1) continuation;
                    int i49 = statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1.label;
                    if ((i49 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1.label = i49 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1 = new StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1 = new StatsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj25 = statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1.result;
                int i50 = statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1.label;
                if (i50 == 0) {
                    ResultKt.throwOnFailure(obj25);
                    AnonymousClass2 anonymousClass26 = new AnonymousClass2(flowCollector, z, (byte) 24);
                    statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass26, statsViewModel$mostPlayedSongsStats$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i50 == 1) {
                    ResultKt.throwOnFailure(obj25);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1) {
                    topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1 = (TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1) continuation;
                    int i51 = topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1.label;
                    if ((i51 & Integer.MIN_VALUE) != 0) {
                        topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1.label = i51 - Integer.MIN_VALUE;
                    } else {
                        topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1 = new TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1 = new TopPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1(this, continuation);
                }
                Object obj26 = topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1.result;
                int i52 = topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1.label;
                if (i52 == 0) {
                    ResultKt.throwOnFailure(obj26);
                    AnonymousClass2 anonymousClass27 = new AnonymousClass2(flowCollector, z, (byte) 25);
                    topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass27, topPlaylistViewModel$topSongs$lambda$1$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i52 == 1) {
                    ResultKt.throwOnFailure(obj26);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
