package com.metrolist.lastfm;

import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.input.TextFieldValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.PoTokenBinding;
import com.metrolist.innertubex.models.Thumbnail$$serializer;
import com.metrolist.innertubex.models.Thumbnails;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.CreatePlaylistBody;
import com.metrolist.innertubex.models.body.EditPlaylistBody;
import com.metrolist.innertubex.models.body.FeedbackBody;
import com.metrolist.innertubex.models.body.GetQueueBody;
import com.metrolist.innertubex.models.body.SubscribeBody;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.innertubex.models.response.PlayerResponse$StreamingData$Format$$serializer;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.kugou.models.SearchLyricsResponse;
import com.metrolist.kugou.models.SearchLyricsResponse$Candidate$$serializer;
import com.metrolist.kugou.models.SearchSongResponse;
import com.metrolist.kugou.models.SearchSongResponse$Data$Info$$serializer;
import com.metrolist.music.MainActivity;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LastFM$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LastFM$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = 7;
        switch (this.$r8$classId) {
            case 0:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new KuGouKt$$ExternalSyntheticLambda0(b));
            case 1:
                Context.Request.Companion companion = Context.Request.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 2:
                PoTokenBinding[] poTokenBindingArrValues = PoTokenBinding.values();
                poTokenBindingArrValues.getClass();
                return new EnumSerializer("com.metrolist.innertubex.models.PoTokenBinding", poTokenBindingArrValues);
            case 3:
                Thumbnails.Companion companion2 = Thumbnails.INSTANCE;
                return new HashSetSerializer(Thumbnail$$serializer.INSTANCE, (byte) 1);
            case 4:
                YouTubeClient.Companion companion3 = YouTubeClient.INSTANCE;
                return PoTokenBinding.INSTANCE.serializer();
            case 5:
                CreatePlaylistBody.Companion companion4 = CreatePlaylistBody.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 6:
                EditPlaylistBody.Companion companion5 = EditPlaylistBody.Companion;
                return new HashSetSerializer(JsonObjectSerializer.INSTANCE, (byte) 1);
            case 7:
                FeedbackBody.Companion companion6 = FeedbackBody.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 8:
                GetQueueBody.Companion companion7 = GetQueueBody.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 9:
                SubscribeBody.Companion companion8 = SubscribeBody.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 10:
                PlayerResponse.PlaybackTracking.Companion companion9 = PlayerResponse.PlaybackTracking.INSTANCE;
                return new HashSetSerializer(IntSerializer.INSTANCE, (byte) 1);
            case 11:
                PlayerResponse.StreamingData.Companion companion10 = PlayerResponse.StreamingData.INSTANCE;
                return new HashSetSerializer(PlayerResponse$StreamingData$Format$$serializer.INSTANCE, (byte) 1);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                PlayerResponse.StreamingData.Companion companion11 = PlayerResponse.StreamingData.INSTANCE;
                return new HashSetSerializer(PlayerResponse$StreamingData$Format$$serializer.INSTANCE, (byte) 1);
            case 13:
                SearchLyricsResponse.Companion companion12 = SearchLyricsResponse.Companion;
                return new HashSetSerializer(SearchLyricsResponse$Candidate$$serializer.INSTANCE, (byte) 1);
            case 14:
                SearchSongResponse.Data.Companion companion13 = SearchSongResponse.Data.Companion;
                return new HashSetSerializer(SearchSongResponse$Data$Info$$serializer.INSTANCE, (byte) 1);
            case 15:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new KuGouKt$$ExternalSyntheticLambda0((byte) 12));
            case 16:
                int i = MainActivity.$r8$clinit;
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 17:
                int i2 = MainActivity.$r8$clinit;
                return Stack.mutableStateOf$default("home");
            case 18:
                int i3 = MainActivity.$r8$clinit;
                return Stack.mutableStateOf$default(new TextFieldValue(7, 0L, (String) null));
            case 19:
                int i4 = MainActivity.$r8$clinit;
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 20:
                throw new IllegalStateException("No database provided");
            case 21:
                throw new IllegalStateException("No NavController provided");
            case 22:
                throw new IllegalStateException("No PlayerConnection provided");
            case 23:
                throw new IllegalStateException("No WindowInsets provided");
            case 24:
                throw new IllegalStateException("No DownloadUtil provided");
            case 25:
                throw new IllegalStateException("No SyncUtils provided");
            case 26:
                return null;
            case 27:
                throw new IllegalStateException("No LocalChangelogState provided");
            case 28:
                return EmptyMap.INSTANCE;
            default:
                return Boolean.FALSE;
        }
    }
}
