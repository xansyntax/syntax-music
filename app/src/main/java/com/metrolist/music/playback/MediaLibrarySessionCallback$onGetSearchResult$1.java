package com.metrolist.music.playback;

import android.net.Uri;
import android.os.Bundle;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.session.LibraryResult;
import androidx.media3.session.MediaLibraryService;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.SearchResult;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda51;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionCallback$onGetSearchResult$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MediaLibraryService.LibraryParams $params;
    public final /* synthetic */ String $query;
    public int I$0;
    public List L$0;
    public List L$1;
    public byte label;
    public final /* synthetic */ MediaLibrarySessionCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibrarySessionCallback$onGetSearchResult$1(String str, MediaLibraryService.LibraryParams libraryParams, MediaLibrarySessionCallback mediaLibrarySessionCallback, Continuation continuation) {
        super(2, continuation);
        this.$query = str;
        this.$params = libraryParams;
        this.this$0 = mediaLibrarySessionCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MediaLibrarySessionCallback$onGetSearchResult$1(this.$query, this.$params, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MediaLibrarySessionCallback$onGetSearchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x01c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x01be A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x01be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x022d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e0 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0129 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:55:0x013e A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0148 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x015a A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0166 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:70:0x017b A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0185 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0190 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:78:0x019a A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01b2 A[LOOP:4: B:76:0x0194->B:81:0x01b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e3 A[Catch: Exception -> 0x0028, TRY_LEAVE, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0226 A[Catch: Exception -> 0x0028, TryCatch #1 {Exception -> 0x0028, blocks: (B:7:0x001d, B:35:0x00c5, B:39:0x00cb, B:41:0x00cf, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00ec, B:48:0x0123, B:50:0x0129, B:52:0x0132, B:86:0x01d4, B:55:0x013e, B:56:0x0142, B:58:0x0148, B:60:0x015a, B:62:0x0166, B:64:0x016a, B:67:0x0171, B:68:0x0175, B:70:0x017b, B:72:0x0185, B:75:0x0190, B:76:0x0194, B:78:0x019a, B:88:0x01d9, B:89:0x01dd, B:91:0x01e3, B:93:0x01f4, B:95:0x0226, B:96:0x022d), top: B:108:0x001d }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Iterable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objFirst;
        List list;
        int i;
        List list2;
        List list3;
        Object objM1039searchMVsJJCw;
        List list4;
        SearchResult searchResult;
        ?? arrayList;
        Bundle bundle;
        ArrayList arrayList2;
        Iterator it;
        Object next;
        SongItem songItem;
        Iterator it2;
        Song song;
        Iterator it3;
        List list5;
        List list6;
        Iterator it4;
        ArtistEntity artistEntity;
        List list7;
        Iterator it5;
        byte b = this.label;
        Object obj2 = null;
        MediaLibraryService.LibraryParams libraryParams = this.$params;
        EmptyList emptyList = EmptyList.INSTANCE;
        String str = this.$query;
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.this$0;
        boolean z = true;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (str.length() == 0) {
                        return LibraryResult.ofItemList(emptyList, libraryParams);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int iIntValue = ((Number) UtilsKt.get(UtilsKt.getDataStore(mediaLibrarySessionCallback.context), PreferenceKeysKt.AndroidAutoSearchLocalLimitKey, new Integer(75))).intValue();
                    MusicDatabase musicDatabase = mediaLibrarySessionCallback.database;
                    musicDatabase.getClass();
                    Flow flowSearchSongsExtended = musicDatabase.$$delegate_0.searchSongsExtended(iIntValue, str);
                    this.L$0 = arrayList3;
                    this.I$0 = iIntValue;
                    this.label = (byte) 1;
                    objFirst = StateFlowKt.first(flowSearchSongsExtended, this);
                    if (objFirst != coroutineSingletons) {
                        list = arrayList3;
                        i = iIntValue;
                    }
                    return coroutineSingletons;
                }
                if (b != 1) {
                    if (b != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    list4 = this.L$1;
                    list3 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objM1039searchMVsJJCw = ((Result) obj).value;
                        if (objM1039searchMVsJJCw instanceof Result.Failure) {
                            obj2 = objM1039searchMVsJJCw;
                        }
                        searchResult = (SearchResult) obj2;
                        if (searchResult != null) {
                            List list8 = searchResult.items;
                            arrayList2 = new ArrayList();
                            for (Object obj3 : list8) {
                                if (obj3 instanceof SongItem) {
                                    arrayList2.add(obj3);
                                }
                            }
                            DataStore dataStore = UtilsKt.getDataStore(mediaLibrarySessionCallback.context);
                            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                            Boolean bool = Boolean.FALSE;
                            List listFilterVideoSongs = HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList2, ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue()), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(mediaLibrarySessionCallback.context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue());
                            arrayList = new ArrayList();
                            it = listFilterVideoSongs.iterator();
                            while (it.hasNext()) {
                                next = it.next();
                                songItem = (SongItem) next;
                                if (list4 == null && list4.isEmpty()) {
                                    it3 = it;
                                    list5 = list4;
                                    arrayList.add(next);
                                } else {
                                    it2 = list4.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            song = (Song) it2.next();
                                            if (Intrinsics.areEqual(song.song.id, songItem.id)) {
                                                it3 = it;
                                                list5 = list4;
                                            } else {
                                                if (!StringsKt__StringsJVMKt.equals(song.song.title, songItem.title, z) && ((list6 = song.artists) == null || !list6.isEmpty())) {
                                                    it4 = list6.iterator();
                                                    while (true) {
                                                        if (it4.hasNext()) {
                                                            artistEntity = (ArtistEntity) it4.next();
                                                            list7 = songItem.artists;
                                                            if (list7 != null || !list7.isEmpty()) {
                                                                it5 = list7.iterator();
                                                                while (true) {
                                                                    if (it5.hasNext()) {
                                                                        it3 = it;
                                                                        list5 = list4;
                                                                        if (!StringsKt__StringsJVMKt.equals(((Artist) it5.next()).name, artistEntity.name, true)) {
                                                                            it = it3;
                                                                            list4 = list5;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            it = it;
                                                            list4 = list4;
                                                        } else {
                                                            continue;
                                                        }
                                                    }
                                                }
                                                it = it;
                                                list4 = list4;
                                                z = true;
                                            }
                                        } else {
                                            it3 = it;
                                            list5 = list4;
                                            arrayList.add(next);
                                        }
                                    }
                                }
                                it = it3;
                                list4 = list5;
                                z = true;
                            }
                        } else {
                            arrayList = emptyList;
                        }
                        for (SongItem songItem2 : arrayList) {
                            try {
                                mediaLibrarySessionCallback.database.query(new YouTubeSongMenuKt$$ExternalSyntheticLambda51(songItem2, (byte) 1));
                            } catch (Exception unused) {
                            }
                            MediaItem.Builder builder = new MediaItem.Builder();
                            builder.mediaId = "search/" + str + "/" + songItem2.id;
                            MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
                            builder2.title = songItem2.title;
                            bundle = new Bundle();
                            if (songItem2.explicit) {
                                bundle.putLong("android.media.IS_EXPLICIT", 1L);
                            }
                            builder2.extras = bundle;
                            builder2.subtitle = UtilsKt.joinToArtistString(songItem2.artists, UtilsKt.getArtistSeparator(mediaLibrarySessionCallback.context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 26));
                            builder2.artist = UtilsKt.joinToArtistString(songItem2.artists, UtilsKt.getArtistSeparator(mediaLibrarySessionCallback.context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 27));
                            builder2.artworkUri = Uri.parse(songItem2.thumbnail);
                            builder2.isPlayable = Boolean.TRUE;
                            builder2.isBrowsable = Boolean.FALSE;
                            builder2.mediaType = new Integer(1);
                            builder.mediaMetadata = new MediaMetadata(builder2);
                            list3.add(builder.build());
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                    return LibraryResult.ofItemList(list3, libraryParams);
                }
                i = this.I$0;
                list = this.L$0;
                ResultKt.throwOnFailure(obj);
                objFirst = obj;
                YouTube youTube = YouTube.INSTANCE;
                this.L$0 = list;
                this.L$1 = list2;
                this.I$0 = i;
                this.label = (byte) 2;
                objM1039searchMVsJJCw = YouTube.INSTANCE.m1039searchMVsJJCw(str, "EgWKAQIIAWoKEAkQBRAKEAMQBA%3D%3D", false, this);
                if (objM1039searchMVsJJCw != coroutineSingletons) {
                    list3 = list;
                    list4 = list2;
                    if (objM1039searchMVsJJCw instanceof Result.Failure) {
                        obj2 = objM1039searchMVsJJCw;
                    }
                    searchResult = (SearchResult) obj2;
                    if (searchResult != null) {
                        List list9 = searchResult.items;
                        arrayList2 = new ArrayList();
                        while (r0.hasNext()) {
                            if (obj3 instanceof SongItem) {
                                arrayList2.add(obj3);
                            }
                        }
                        DataStore dataStore2 = UtilsKt.getDataStore(mediaLibrarySessionCallback.context);
                        Preferences$Key preferences$Key2 = PreferenceKeysKt.HideExplicitKey;
                        Boolean bool2 = Boolean.FALSE;
                        List listFilterVideoSongs2 = HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList2, ((Boolean) UtilsKt.get(dataStore2, preferences$Key2, bool2)).booleanValue()), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(mediaLibrarySessionCallback.context), PreferenceKeysKt.HideVideoSongsKey, bool2)).booleanValue());
                        arrayList = new ArrayList();
                        it = listFilterVideoSongs2.iterator();
                        while (it.hasNext()) {
                            next = it.next();
                            songItem = (SongItem) next;
                            if (list4 == null) {
                                it2 = list4.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        song = (Song) it2.next();
                                        if (Intrinsics.areEqual(song.song.id, songItem.id)) {
                                            if (!StringsKt__StringsJVMKt.equals(song.song.title, songItem.title, z)) {
                                                it4 = list6.iterator();
                                                while (true) {
                                                    if (it4.hasNext()) {
                                                        artistEntity = (ArtistEntity) it4.next();
                                                        list7 = songItem.artists;
                                                        if (list7 != null) {
                                                            it5 = list7.iterator();
                                                            while (true) {
                                                                if (it5.hasNext()) {
                                                                    it3 = it;
                                                                    list5 = list4;
                                                                    if (!StringsKt__StringsJVMKt.equals(((Artist) it5.next()).name, artistEntity.name, true)) {
                                                                        it = it3;
                                                                        list4 = list5;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            it5 = list7.iterator();
                                                            while (true) {
                                                                if (it5.hasNext()) {
                                                                    it3 = it;
                                                                    list5 = list4;
                                                                    if (!StringsKt__StringsJVMKt.equals(((Artist) it5.next()).name, artistEntity.name, true)) {
                                                                        it = it3;
                                                                        list4 = list5;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        it = it;
                                                        list4 = list4;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }
                                            it = it;
                                            list4 = list4;
                                            z = true;
                                        } else {
                                            it3 = it;
                                            list5 = list4;
                                        }
                                    } else {
                                        it3 = it;
                                        list5 = list4;
                                        arrayList.add(next);
                                    }
                                }
                            } else {
                                it2 = list4.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        song = (Song) it2.next();
                                        if (Intrinsics.areEqual(song.song.id, songItem.id)) {
                                            if (!StringsKt__StringsJVMKt.equals(song.song.title, songItem.title, z)) {
                                                it4 = list6.iterator();
                                                while (true) {
                                                    if (it4.hasNext()) {
                                                        artistEntity = (ArtistEntity) it4.next();
                                                        list7 = songItem.artists;
                                                        if (list7 != null) {
                                                            it5 = list7.iterator();
                                                            while (true) {
                                                                if (it5.hasNext()) {
                                                                    it3 = it;
                                                                    list5 = list4;
                                                                    if (!StringsKt__StringsJVMKt.equals(((Artist) it5.next()).name, artistEntity.name, true)) {
                                                                        it = it3;
                                                                        list4 = list5;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            it5 = list7.iterator();
                                                            while (true) {
                                                                if (it5.hasNext()) {
                                                                    it3 = it;
                                                                    list5 = list4;
                                                                    if (!StringsKt__StringsJVMKt.equals(((Artist) it5.next()).name, artistEntity.name, true)) {
                                                                        it = it3;
                                                                        list4 = list5;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        it = it;
                                                        list4 = list4;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }
                                            it = it;
                                            list4 = list4;
                                            z = true;
                                        } else {
                                            it3 = it;
                                            list5 = list4;
                                        }
                                    } else {
                                        it3 = it;
                                        list5 = list4;
                                        arrayList.add(next);
                                    }
                                }
                            }
                            it = it3;
                            list4 = list5;
                            z = true;
                        }
                    } else {
                        arrayList = emptyList;
                    }
                    while (r0.hasNext()) {
                        mediaLibrarySessionCallback.database.query(new YouTubeSongMenuKt$$ExternalSyntheticLambda51(songItem2, (byte) 1));
                        MediaItem.Builder builder3 = new MediaItem.Builder();
                        builder3.mediaId = "search/" + str + "/" + songItem2.id;
                        MediaMetadata.Builder builder4 = new MediaMetadata.Builder();
                        builder4.title = songItem2.title;
                        bundle = new Bundle();
                        if (songItem2.explicit) {
                            bundle.putLong("android.media.IS_EXPLICIT", 1L);
                        }
                        builder4.extras = bundle;
                        builder4.subtitle = UtilsKt.joinToArtistString(songItem2.artists, UtilsKt.getArtistSeparator(mediaLibrarySessionCallback.context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 26));
                        builder4.artist = UtilsKt.joinToArtistString(songItem2.artists, UtilsKt.getArtistSeparator(mediaLibrarySessionCallback.context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 27));
                        builder4.artworkUri = Uri.parse(songItem2.thumbnail);
                        builder4.isPlayable = Boolean.TRUE;
                        builder4.isBrowsable = Boolean.FALSE;
                        builder4.mediaType = new Integer(1);
                        builder3.mediaMetadata = new MediaMetadata(builder4);
                        list3.add(builder3.build());
                    }
                    return LibraryResult.ofItemList(list3, libraryParams);
                }
                return coroutineSingletons;
            } catch (Exception e2) {
                e = e2;
                list3 = list;
                e.printStackTrace();
            }
            list2 = (List) objFirst;
            Iterator it6 = list2.iterator();
            while (it6.hasNext()) {
                list.add(mediaLibrarySessionCallback.toMediaItem((Song) it6.next(), "search/" + str));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return LibraryResult.ofItemList(emptyList, libraryParams);
        }
    }
}
