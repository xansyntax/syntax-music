package com.metrolist.music.db.entities;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Stack;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.listentogether.ListenTogetherServers;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.MenuState;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachedItem$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ CachedItem$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                CachedItem.Companion companion = CachedItem.Companion;
                return new SealedClassSerializer("com.metrolist.music.db.entities.CachedItem", Reflection.getOrCreateKotlinClass(CachedItem.class), new KClass[]{Reflection.getOrCreateKotlinClass(CachedItem.Album.class), Reflection.getOrCreateKotlinClass(CachedItem.Artist.class), Reflection.getOrCreateKotlinClass(CachedItem.Episode.class), Reflection.getOrCreateKotlinClass(CachedItem.Playlist.class), Reflection.getOrCreateKotlinClass(CachedItem.Podcast.class), Reflection.getOrCreateKotlinClass(CachedItem.Song.class)}, new KSerializer[]{CachedItem$Album$$serializer.INSTANCE, CachedItem$Artist$$serializer.INSTANCE, CachedItem$Episode$$serializer.INSTANCE, CachedItem$Playlist$$serializer.INSTANCE, CachedItem$Podcast$$serializer.INSTANCE, CachedItem$Song$$serializer.INSTANCE}, new Annotation[0]);
            case 1:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new KuGouKt$$ExternalSyntheticLambda0((byte) 29));
            case 2:
                CachedArtistPage.Companion companion2 = CachedArtistPage.Companion;
                return new HashSetSerializer(CachedSection$$serializer.INSTANCE, (byte) 1);
            case 3:
                CachedItem.Album.Companion companion3 = CachedItem.Album.Companion;
                return new HashSetSerializer(CachedArtist$$serializer.INSTANCE, (byte) 1);
            case 4:
                CachedItem.Song.Companion companion4 = CachedItem.Song.Companion;
                return new HashSetSerializer(CachedArtist$$serializer.INSTANCE, (byte) 1);
            case 5:
                CachedSection.Companion companion5 = CachedSection.Companion;
                return new HashSetSerializer(CachedItem.Companion.serializer(), (byte) 1);
            case 6:
                JsonImpl jsonImpl = ListenTogetherServers.json;
                jsonImpl.getClass();
                return (List) jsonImpl.decodeFromString(new HashSetSerializer(ListenTogetherServer.INSTANCE.serializer(), (byte) 1), "\n        [\n          {\n            \"name\": \"The Meowery\",\n            \"url\": \"wss://metroserverx.meowery.eu/ws\",\n            \"location\": \"Poland\",\n            \"operator\": \"Nyx\"\n          }\n        ]\n    ");
            case 7:
            case 8:
            case 9:
            case 10:
                return unit;
            case 11:
                return new MenuState();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new BottomSheetPageState();
            case 13:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 14:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 15:
                return new ParcelableSnapshotMutableLongState(0L);
            case 16:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 17:
                return Stack.mutableStateOf$default(Boolean.TRUE);
            case 18:
                return unit;
            case 19:
                return new ParcelableSnapshotMutableIntState(-1);
            case 20:
                return new ParcelableSnapshotMutableIntState(0);
            case 21:
                return null;
            case 22:
                return Boolean.TRUE;
            case 23:
                return new ParcelableSnapshotMutableLongState(0L);
            case 24:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 25:
                return Stack.mutableStateOf$default(Boolean.TRUE);
            case 26:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 27:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 28:
                return Stack.mutableStateOf$default(Boolean.TRUE);
            default:
                return unit;
        }
    }
}
