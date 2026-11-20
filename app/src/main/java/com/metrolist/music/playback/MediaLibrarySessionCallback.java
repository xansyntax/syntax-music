package com.metrolist.music.playback;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.palette.graphics.ColorCutQuantizer;
import coil3.network.NetworkFetcher;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.CachedItem$$ExternalSyntheticLambda0;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionCallback {
    public Function0 addToTargetPlaylist;
    public final Context context;
    public final MusicDatabase database;
    public final DownloadUtil downloadUtil;
    public final ContextScope scope;
    public MusicService service;
    public Function0 toggleLibrary;
    public Function0 toggleLike;
    public Function0 toggleStartRadio;

    /* JADX INFO: renamed from: com.metrolist.music.playback.MediaLibrarySessionCallback$loadLocalChildren$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public String L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaLibrarySessionCallback.this.loadLocalChildren(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MediaLibrarySessionCallback$loadPlaylistChildren$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01641 extends ContinuationImpl {
        public int I$0;
        public String L$0;
        public AndroidAutoPageRequest L$3;
        public List L$5;
        public Collection L$7;
        public Iterator L$8;
        public int label;
        public /* synthetic */ Object result;

        public C01641(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaLibrarySessionCallback.this.loadPlaylistChildren(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MediaLibrarySessionCallback$loadPlaylistContainers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01651 extends ContinuationImpl {
        public AndroidAutoPageRequest L$0;
        public List L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01651(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaLibrarySessionCallback.this.loadPlaylistContainers(null, this);
        }
    }

    public MediaLibrarySessionCallback(Context context, MusicDatabase musicDatabase, DownloadUtil downloadUtil) {
        musicDatabase.getClass();
        downloadUtil.getClass();
        this.context = context;
        this.database = musicDatabase;
        this.downloadUtil = downloadUtil;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher);
        this.scope = new ContextScope(contextScopeCoroutineScope.coroutineContext.plus(AwaitKt.Job$default()));
        this.toggleLike = new CachedItem$$ExternalSyntheticLambda0((byte) 7);
        this.toggleStartRadio = new CachedItem$$ExternalSyntheticLambda0((byte) 8);
        this.toggleLibrary = new CachedItem$$ExternalSyntheticLambda0((byte) 9);
        this.addToTargetPlaylist = new CachedItem$$ExternalSyntheticLambda0((byte) 10);
    }

    public static MediaItem browsableMediaItem(String str, String str2, String str3, Uri uri, int i) {
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.mediaId = str;
        MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
        builder2.title = str2;
        builder2.subtitle = str3;
        builder2.artist = str3;
        builder2.artworkUri = uri;
        builder2.isPlayable = Boolean.FALSE;
        builder2.isBrowsable = Boolean.TRUE;
        builder2.mediaType = Integer.valueOf(i);
        builder.mediaMetadata = new MediaMetadata(builder2);
        return builder.build();
    }

    public final Uri drawableUri(int i) {
        Uri.Builder builderScheme = new Uri.Builder().scheme("android.resource");
        Context context = this.context;
        return builderScheme.authority(context.getResources().getResourcePackageName(i)).appendPath(context.getResources().getResourceTypeName(i)).appendPath(context.getResources().getResourceEntryName(i)).build();
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0198 A[LOOP:2: B:74:0x0192->B:76:0x0198, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code duplicated, block: B:87:0x01d6 A[LOOP:1: B:85:0x01d0->B:87:0x01d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x0213 A[LOOP:0: B:96:0x020d->B:98:0x0213, LOOP_END] */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0233, code lost:
    
        if (r1 == r12) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
    
        if (r1 == r12) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0104, code lost:
    
        if (r1 == r12) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0163, code lost:
    
        if (r1 == r12) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadLocalChildren(String str, int i, int i2, ContinuationImpl continuationImpl) throws IOException {
        AnonymousClass1 anonymousClass1;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        Iterator it;
        ArrayList arrayList2;
        Iterator it2;
        ArrayList arrayList3;
        Iterator it3;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objLoadPlaylistChildren = anonymousClass1.result;
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                int i4 = i < 0 ? 0 : i;
                int i5 = i2 < 0 ? 0 : i2;
                if (i5 > 500) {
                    i5 = 500;
                }
                long j = ((long) i4) * ((long) i5);
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                int i6 = (int) j;
                AndroidAutoPageRequest androidAutoPageRequest = new AndroidAutoPageRequest(i6, i5);
                boolean zAreEqual = Intrinsics.areEqual(str, "artist");
                MusicDatabase musicDatabase = this.database;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zAreEqual) {
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 1;
                    objLoadPlaylistChildren = musicDatabase.$$delegate_0.artistsByCreateDateAsc(i5, i6, anonymousClass1);
                    break;
                } else {
                    if (Intrinsics.areEqual(str, "album")) {
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        objLoadPlaylistChildren = musicDatabase.$$delegate_0.albumsByCreateDateAsc(i5, i6, anonymousClass1);
                    } else if (Intrinsics.areEqual(str, "playlist")) {
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 3;
                        objLoadPlaylistChildren = loadPlaylistContainers(androidAutoPageRequest, anonymousClass1);
                    } else if (Intrinsics.areEqual(str, "song")) {
                        anonymousClass1.L$0 = str;
                        anonymousClass1.label = 4;
                        objLoadPlaylistChildren = musicDatabase.$$delegate_0.songsByCreateDateAsc(i5, i6, anonymousClass1);
                        if (objLoadPlaylistChildren != coroutineSingletons) {
                            str4 = str;
                            Iterable iterable = (Iterable) objLoadPlaylistChildren;
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                            it = iterable.iterator();
                            while (it.hasNext()) {
                                arrayList.add(toMediaItem((Song) it.next(), str4));
                            }
                            return arrayList;
                        }
                    } else if (StringsKt__StringsJVMKt.startsWith(str, "artist/", false)) {
                        String strRemovePrefix = StringsKt.removePrefix(str, "artist/");
                        anonymousClass1.L$0 = str;
                        anonymousClass1.label = 5;
                        objLoadPlaylistChildren = musicDatabase.$$delegate_0.artistSongsByCreateDateAsc(strRemovePrefix, i5, i6, anonymousClass1);
                        if (objLoadPlaylistChildren != coroutineSingletons) {
                            str3 = str;
                            Iterable iterable2 = (Iterable) objLoadPlaylistChildren;
                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                            it2 = iterable2.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(toMediaItem((Song) it2.next(), str3));
                            }
                            return arrayList2;
                        }
                    } else if (!StringsKt__StringsJVMKt.startsWith(str, "album/", false)) {
                        if (!StringsKt__StringsJVMKt.startsWith(str, "playlist/", false)) {
                            return null;
                        }
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 7;
                        objLoadPlaylistChildren = loadPlaylistChildren(str, androidAutoPageRequest, anonymousClass1);
                    } else {
                        String strRemovePrefix2 = StringsKt.removePrefix(str, "album/");
                        anonymousClass1.L$0 = str;
                        anonymousClass1.label = 6;
                        objLoadPlaylistChildren = musicDatabase.$$delegate_0.albumSongs(strRemovePrefix2, i5, i6, anonymousClass1);
                        if (objLoadPlaylistChildren != coroutineSingletons) {
                            str2 = str;
                            Iterable iterable3 = (Iterable) objLoadPlaylistChildren;
                            arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
                            it3 = iterable3.iterator();
                            while (it3.hasNext()) {
                                arrayList3.add(toMediaItem((Song) it3.next(), str2));
                            }
                            return arrayList3;
                        }
                    }
                    break;
                }
                return coroutineSingletons;
            case 1:
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                Iterable<Artist> iterable4 = (Iterable) objLoadPlaylistChildren;
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable4, 10));
                for (Artist artist : iterable4) {
                    ArtistEntity artistEntity = artist.artist;
                    String strM = Fragment$5$$ExternalSyntheticOutline0.m("artist/", artistEntity.id);
                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                    String strResolve = ArtistNameAliases.resolve(artistEntity.id, artistEntity.name);
                    Resources resources = this.context.getResources();
                    int i7 = artist.songCount;
                    String quantityString = resources.getQuantityString(R.plurals.n_song, i7, new Integer(i7));
                    String str5 = artistEntity.thumbnailUrl;
                    arrayList4.add(browsableMediaItem(strM, strResolve, quantityString, str5 != null ? Uri.parse(str5) : null, 11));
                }
                return arrayList4;
            case 2:
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                Iterable<Album> iterable5 = (Iterable) objLoadPlaylistChildren;
                ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable5, 10));
                for (Album album : iterable5) {
                    AlbumEntity albumEntity = album.album;
                    String strM2 = Fragment$5$$ExternalSyntheticOutline0.m("album/", albumEntity.id);
                    String str6 = albumEntity.title;
                    String strJoinToString$default = CollectionsKt.joinToString$default(album.artists, null, null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 19), 31);
                    String str7 = albumEntity.thumbnailUrl;
                    arrayList5.add(browsableMediaItem(strM2, str6, strJoinToString$default, str7 != null ? Uri.parse(str7) : null, 10));
                }
                return arrayList5;
            case 3:
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                return (List) objLoadPlaylistChildren;
            case 4:
                str4 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                Iterable iterable6 = (Iterable) objLoadPlaylistChildren;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable6, 10));
                it = iterable6.iterator();
                while (it.hasNext()) {
                    arrayList.add(toMediaItem((Song) it.next(), str4));
                }
                return arrayList;
            case 5:
                str3 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                Iterable iterable7 = (Iterable) objLoadPlaylistChildren;
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable7, 10));
                it2 = iterable7.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(toMediaItem((Song) it2.next(), str3));
                }
                return arrayList2;
            case 6:
                str2 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                Iterable iterable8 = (Iterable) objLoadPlaylistChildren;
                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable8, 10));
                it3 = iterable8.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(toMediaItem((Song) it3.next(), str2));
                }
                return arrayList3;
            case 7:
                ResultKt.throwOnFailure(objLoadPlaylistChildren);
                return (List) objLoadPlaylistChildren;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x011e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0147  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
    
        if (r3 == r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x013b, code lost:
    
        if (r3 == r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x018b, code lost:
    
        if (r3 == r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ef, code lost:
    
        if (r3 == r13) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x013b -> B:45:0x013f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable loadPlaylistChildren(String str, AndroidAutoPageRequest androidAutoPageRequest, ContinuationImpl continuationImpl) {
        C01641 c01641;
        int i;
        AndroidAutoPageRequest androidAutoPageRequest2;
        Collection linkedHashSet;
        List list;
        Iterator it;
        ?? arrayList;
        List list2;
        String str2 = str;
        if (continuationImpl instanceof C01641) {
            c01641 = (C01641) continuationImpl;
            int i2 = c01641.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c01641.label = i2 - Integer.MIN_VALUE;
            } else {
                c01641 = new C01641(continuationImpl);
            }
        } else {
            c01641 = new C01641(continuationImpl);
        }
        Object objPlaylistSongs = c01641.result;
        int i3 = c01641.label;
        byte b = 10;
        MusicDatabase musicDatabase = this.database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objPlaylistSongs);
            String strRemovePrefix = StringsKt.removePrefix(str2, "playlist/");
            int i4 = androidAutoPageRequest.offset;
            int i5 = androidAutoPageRequest.limit;
            i = (i4 != 0 || i5 <= 0) ? 0 : 1;
            int iCoerceIn = UuidKt.coerceIn(1 - i4, 0, i5);
            int i6 = i4 - 1;
            if (i6 < 0) {
                i6 = 0;
            }
            int i7 = i5 - iCoerceIn;
            androidAutoPageRequest2 = new AndroidAutoPageRequest(i6, i7);
            if (i7 != 0) {
                if (strRemovePrefix.equals("LP_LIKED")) {
                    c01641.L$0 = str2;
                    c01641.L$3 = null;
                    c01641.I$0 = i;
                    c01641.label = 1;
                    objPlaylistSongs = musicDatabase.$$delegate_0.likedSongsByCreateDateDesc(i7, i6, c01641);
                } else if (strRemovePrefix.equals("LP_DOWNLOADED")) {
                    List list3 = SequencesKt.toList(new TransformingSequence(new GeneratorSequence(new FilteringSequence(CollectionsKt.asSequence(((Map) this.downloadUtil.downloads.getValue()).entrySet()), true, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 22)), new ColorCutQuantizer.AnonymousClass1(b)), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 23)));
                    ArrayList arrayListChunked = CollectionsKt.chunked(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, list3);
                    linkedHashSet = new LinkedHashSet();
                    list = list3;
                    it = arrayListChunked.iterator();
                    if (it.hasNext()) {
                        List list4 = (List) it.next();
                        c01641.L$0 = str2;
                        c01641.L$3 = androidAutoPageRequest2;
                        c01641.L$5 = list;
                        c01641.L$7 = linkedHashSet;
                        c01641.L$8 = it;
                        c01641.I$0 = i;
                        c01641.label = 2;
                        objPlaylistSongs = musicDatabase.$$delegate_0.existingSongIds(list4, c01641);
                    } else {
                        list2 = SequencesKt.toList(SequencesKt.take(SequencesKt.drop(new FilteringSequence(CollectionsKt.asSequence(list), true, new NetworkFetcher.AnonymousClass2(1, (Set) linkedHashSet, Set.class, "contains", "contains(Ljava/lang/Object;)Z", 0, (byte) 27)), androidAutoPageRequest2.offset), androidAutoPageRequest2.limit));
                        c01641.L$0 = str2;
                        c01641.L$3 = null;
                        c01641.L$5 = null;
                        c01641.L$7 = list2;
                        c01641.L$8 = null;
                        c01641.I$0 = i;
                        c01641.label = 3;
                        objPlaylistSongs = musicDatabase.$$delegate_0.getSongsByIds(list2, c01641);
                    }
                } else {
                    c01641.L$0 = str2;
                    c01641.L$3 = null;
                    c01641.I$0 = i;
                    c01641.label = 4;
                    objPlaylistSongs = musicDatabase.$$delegate_0.playlistSongs(strRemovePrefix, i7, i6, c01641);
                }
                return coroutineSingletons;
            }
            arrayList = EmptyList.INSTANCE;
        } else if (i3 != 1) {
            if (i3 == 2) {
                int i8 = c01641.I$0;
                it = c01641.L$8;
                linkedHashSet = c01641.L$7;
                list = c01641.L$5;
                androidAutoPageRequest2 = c01641.L$3;
                String str3 = c01641.L$0;
                ResultKt.throwOnFailure(objPlaylistSongs);
                i = i8;
                str2 = str3;
                CollectionsKt__MutableCollectionsKt.addAll((Iterable) objPlaylistSongs, linkedHashSet);
                if (it.hasNext()) {
                    List list5 = (List) it.next();
                    c01641.L$0 = str2;
                    c01641.L$3 = androidAutoPageRequest2;
                    c01641.L$5 = list;
                    c01641.L$7 = linkedHashSet;
                    c01641.L$8 = it;
                    c01641.I$0 = i;
                    c01641.label = 2;
                    objPlaylistSongs = musicDatabase.$$delegate_0.existingSongIds(list5, c01641);
                } else {
                    list2 = SequencesKt.toList(SequencesKt.take(SequencesKt.drop(new FilteringSequence(CollectionsKt.asSequence(list), true, new NetworkFetcher.AnonymousClass2(1, (Set) linkedHashSet, Set.class, "contains", "contains(Ljava/lang/Object;)Z", 0, (byte) 27)), androidAutoPageRequest2.offset), androidAutoPageRequest2.limit));
                    c01641.L$0 = str2;
                    c01641.L$3 = null;
                    c01641.L$5 = null;
                    c01641.L$7 = list2;
                    c01641.L$8 = null;
                    c01641.I$0 = i;
                    c01641.label = 3;
                    objPlaylistSongs = musicDatabase.$$delegate_0.getSongsByIds(list2, c01641);
                }
                return coroutineSingletons;
            }
            if (i3 == 3) {
                int i9 = c01641.I$0;
                list2 = (List) c01641.L$7;
                String str4 = c01641.L$0;
                ResultKt.throwOnFailure(objPlaylistSongs);
                i = i9;
                str2 = str4;
            } else {
                if (i3 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i10 = c01641.I$0;
                String str5 = c01641.L$0;
                ResultKt.throwOnFailure(objPlaylistSongs);
                i = i10;
                str2 = str5;
                Iterable iterable = (Iterable) objPlaylistSongs;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((PlaylistSong) it2.next()).song);
                }
            }
            Iterable iterable2 = (Iterable) objPlaylistSongs;
            int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
            if (iMapCapacity < 16) {
                iMapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
            for (Object obj : iterable2) {
                linkedHashMap.put(((Song) obj).song.id, obj);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                Song song = (Song) linkedHashMap.get((String) it3.next());
                if (song != null) {
                    arrayList2.add(song);
                }
            }
            arrayList = arrayList2;
        } else {
            int i11 = c01641.I$0;
            String str6 = c01641.L$0;
            ResultKt.throwOnFailure(objPlaylistSongs);
            i = i11;
            str2 = str6;
            arrayList = (List) objPlaylistSongs;
        }
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        if (i != 0) {
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.mediaId = str2 + "/__shuffle__";
            MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
            builder2.title = this.context.getString(R.string.shuffle);
            builder2.artworkUri = drawableUri(R.drawable.shuffle);
            builder2.isPlayable = Boolean.TRUE;
            builder2.isBrowsable = Boolean.FALSE;
            builder2.mediaType = new Integer(1);
            builder.mediaMetadata = new MediaMetadata(builder2);
            listBuilderCreateListBuilder.add(builder.build());
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList3.add(toMediaItem((Song) it4.next(), str2));
        }
        listBuilderCreateListBuilder.addAll(arrayList3);
        return CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:39:0x0117  */
    /* JADX WARN: Code duplicated, block: B:41:0x014a  */
    /* JADX WARN: Code duplicated, block: B:42:0x014f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r15 == r10) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fc, code lost:
    
        if (r15 == r10) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable loadPlaylistContainers(AndroidAutoPageRequest androidAutoPageRequest, ContinuationImpl continuationImpl) {
        C01651 c01651;
        List listTake;
        int i;
        int i2;
        ArrayList arrayList;
        String str;
        Uri uri;
        if (continuationImpl instanceof C01651) {
            c01651 = (C01651) continuationImpl;
            int i3 = c01651.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c01651.label = i3 - Integer.MIN_VALUE;
            } else {
                c01651 = new C01651(continuationImpl);
            }
        } else {
            c01651 = new C01651(continuationImpl);
        }
        Object objFirst = c01651.result;
        int i4 = c01651.label;
        List<Playlist> list = EmptyList.INSTANCE;
        MusicDatabase musicDatabase = this.database;
        Context context = this.context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i4 != 0) {
            if (i4 == 1) {
                androidAutoPageRequest = c01651.L$0;
                ResultKt.throwOnFailure(objFirst);
            } else {
                if (i4 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                listTake = c01651.L$1;
                ResultKt.throwOnFailure(objFirst);
            }
            list = (List) objFirst;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (Playlist playlist : list) {
                String strM = Fragment$5$$ExternalSyntheticOutline0.m("playlist/", playlist.playlist.id);
                String str2 = playlist.playlist.name;
                Resources resources = context.getResources();
                int i5 = playlist.songCount;
                String quantityString = resources.getQuantityString(R.plurals.n_song, i5, new Integer(i5));
                str = (String) CollectionsKt.firstOrNull(playlist.getThumbnails());
                if (str != null) {
                    uri = Uri.parse(str);
                } else {
                    uri = null;
                }
                arrayList.add(browsableMediaItem(strM, str2, quantityString, uri, 13));
            }
            return CollectionsKt.plus((Iterable) arrayList, (Collection) listTake);
        }
        ResultKt.throwOnFailure(objFirst);
        if (androidAutoPageRequest.offset >= 2 || androidAutoPageRequest.limit <= 0) {
            listTake = list;
            int i6 = androidAutoPageRequest.offset;
            int i7 = androidAutoPageRequest.limit;
            int iCoerceIn = UuidKt.coerceIn(2 - i6, 0, i7);
            int i8 = i6 - 2;
            i = i8 >= 0 ? i8 : 0;
            i2 = i7 - iCoerceIn;
            if (i2 != 0) {
                c01651.L$0 = null;
                c01651.L$1 = listTake;
                c01651.label = 2;
                objFirst = musicDatabase.$$delegate_0.playlistsByCreateDateAsc(i2, i, c01651);
            }
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            while (r15.hasNext()) {
                String strM2 = Fragment$5$$ExternalSyntheticOutline0.m("playlist/", playlist.playlist.id);
                String str3 = playlist.playlist.name;
                Resources resources2 = context.getResources();
                int i9 = playlist.songCount;
                String quantityString2 = resources2.getQuantityString(R.plurals.n_song, i9, new Integer(i9));
                str = (String) CollectionsKt.firstOrNull(playlist.getThumbnails());
                if (str != null) {
                    uri = Uri.parse(str);
                } else {
                    uri = null;
                }
                arrayList.add(browsableMediaItem(strM2, str3, quantityString2, uri, 13));
            }
            return CollectionsKt.plus((Iterable) arrayList, (Collection) listTake);
        }
        Flow flowLikedSongsCount = musicDatabase.$$delegate_0.likedSongsCount();
        c01651.L$0 = androidAutoPageRequest;
        c01651.label = 1;
        objFirst = StateFlowKt.first(flowLikedSongsCount, c01651);
        return coroutineSingletons;
        int iIntValue = ((Number) objFirst).intValue();
        int size = ((Map) this.downloadUtil.downloads.getValue()).size();
        String string = context.getString(R.string.liked_songs);
        string.getClass();
        MediaItem mediaItemBrowsableMediaItem = browsableMediaItem("playlist/LP_LIKED", string, context.getResources().getQuantityString(R.plurals.n_song, iIntValue, new Integer(iIntValue)), drawableUri(R.drawable.favorite), 13);
        String string2 = context.getString(R.string.downloaded_songs);
        string2.getClass();
        listTake = CollectionsKt.take(CollectionsKt.drop(CollectionsKt__IterablesKt.listOf((Object[]) new MediaItem[]{mediaItemBrowsableMediaItem, browsableMediaItem("playlist/LP_DOWNLOADED", string2, context.getResources().getQuantityString(R.plurals.n_song, size, new Integer(size)), drawableUri(R.drawable.download), 13)}), androidAutoPageRequest.offset), androidAutoPageRequest.limit);
        int i10 = androidAutoPageRequest.offset;
        int i11 = androidAutoPageRequest.limit;
        int iCoerceIn2 = UuidKt.coerceIn(2 - i10, 0, i11);
        int i12 = i10 - 2;
        if (i12 >= 0) {
        }
        i2 = i11 - iCoerceIn2;
        if (i2 != 0) {
            c01651.L$0 = null;
            c01651.L$1 = listTake;
            c01651.label = 2;
            objFirst = musicDatabase.$$delegate_0.playlistsByCreateDateAsc(i2, i, c01651);
        }
        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        while (r15.hasNext()) {
            String strM3 = Fragment$5$$ExternalSyntheticOutline0.m("playlist/", playlist.playlist.id);
            String str4 = playlist.playlist.name;
            Resources resources3 = context.getResources();
            int i13 = playlist.songCount;
            String quantityString3 = resources3.getQuantityString(R.plurals.n_song, i13, new Integer(i13));
            str = (String) CollectionsKt.firstOrNull(playlist.getThumbnails());
            if (str != null) {
                uri = Uri.parse(str);
            } else {
                uri = null;
            }
            arrayList.add(browsableMediaItem(strM3, str4, quantityString3, uri, 13));
        }
        return CollectionsKt.plus((Iterable) arrayList, (Collection) listTake);
    }

    public final MediaItem toMediaItem(Song song, String str) {
        MediaItem.Builder builder = new MediaItem.Builder();
        SongEntity songEntity = song.song;
        List list = song.artists;
        builder.mediaId = Fragment$5$$ExternalSyntheticOutline0.m(str, "/", songEntity.id);
        MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
        SongEntity songEntity2 = song.song;
        builder2.title = songEntity2.title;
        Bundle bundle = new Bundle();
        if (songEntity2.explicit) {
            bundle.putLong("android.media.IS_EXPLICIT", 1L);
        }
        builder2.extras = bundle;
        Context context = this.context;
        builder2.subtitle = UtilsKt.joinToArtistString(list, UtilsKt.getArtistSeparator(context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 20));
        builder2.artist = UtilsKt.joinToArtistString(list, UtilsKt.getArtistSeparator(context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 21));
        String str2 = songEntity2.thumbnailUrl;
        builder2.artworkUri = str2 != null ? Uri.parse(str2) : null;
        builder2.isPlayable = Boolean.TRUE;
        builder2.isBrowsable = Boolean.FALSE;
        builder2.mediaType = 1;
        builder.mediaMetadata = new MediaMetadata(builder2);
        return builder.build();
    }
}
