package io.ktor.util;

import android.graphics.RuntimeShader;
import android.view.View;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.mkv.DefaultEbmlReader;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaLibraryService;
import coil3.network.HttpException;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertubex.InnerTubeLogEvent;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.UCropActivity;
import io.ktor.client.plugins.contentnegotiation.ContentTypeMergeStrategy;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;
import kotlinx.serialization.UnknownFieldException;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PathKt$$ExternalSyntheticBUOutline0 implements Authenticator, ExtractorsFactory, DefaultMediaNotificationProvider.NotificationIdProvider, OnApplyWindowInsetsListener, ContentTypeMergeStrategy {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ PathKt$$ExternalSyntheticBUOutline0(byte b) {
        this.$r8$classId = b;
    }

    public static /* synthetic */ void m(int i, Object obj) {
        throw new IllegalStateException("Source subfield " + i + ((Object) " is present but null: ") + obj);
    }

    public static /* synthetic */ void m$1(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m$2(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void m$3(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        switch (this.$r8$classId) {
            case 14:
                String str = YouTube.innerTube.configuredProxyAuth;
                Request request = response.request;
                if (str == null) {
                    return request;
                }
                Request.Builder builderNewBuilder = request.newBuilder();
                builderNewBuilder.header(HttpHeaders.ProxyAuthorization, str);
                return new Request(builderNewBuilder);
            default:
                boolean z = MusicService.isRunning;
                String str2 = YouTube.innerTube.configuredProxyAuth;
                Request request2 = response.request;
                if (str2 == null) {
                    return request2;
                }
                Request.Builder builderNewBuilder2 = request2.newBuilder();
                builderNewBuilder2.header(HttpHeaders.ProxyAuthorization, str2);
                return new Request(builderNewBuilder2);
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        boolean z = MusicService.isRunning;
        DefaultEbmlReader defaultEbmlReader = new DefaultEbmlReader();
        CueDecoder cueDecoder = CueDecoder.UNSUPPORTED;
        MatroskaExtractor matroskaExtractor = new MatroskaExtractor(defaultEbmlReader, 2, cueDecoder);
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return new Extractor[]{matroskaExtractor, new FragmentedMp4Extractor(cueDecoder, 32, RegularImmutableList.EMPTY), new Mp4Extractor(16, cueDecoder)};
    }

    @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
    public int getNotificationId(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        boolean z = MusicService.isRunning;
        mediaLibrarySession.getClass();
        return 888;
    }

    public void log(InnerTubeLogEvent innerTubeLogEvent) throws IOException {
        switch (this.$r8$classId) {
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                break;
            default:
                String str = innerTubeLogEvent.tag;
                Map map = innerTubeLogEvent.details;
                kotlin.collections.CollectionsKt.joinToString$default(map.entrySet(), null, " [", "]", new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 0), 25);
                map.isEmpty();
                int iOrdinal = innerTubeLogEvent.level.ordinal();
                if (iOrdinal == 0) {
                    Timber.Forest.tag(str);
                    ConnectionPool.d(new Object[0]);
                } else if (iOrdinal == 1) {
                    Timber.Forest.tag(str);
                    ConnectionPool.i(new Object[0]);
                } else if (iOrdinal == 2) {
                    Timber.Forest.tag(str);
                    ConnectionPool.w(new Object[0]);
                } else if (iOrdinal != 3) {
                    m$1();
                } else {
                    Timber.Forest.tag(str);
                    ConnectionPool.e(new Object[0]);
                }
                break;
        }
    }

    @Override // io.ktor.client.plugins.contentnegotiation.ContentTypeMergeStrategy
    public Sequence mergeContentTypes(List list, List list2) {
        switch (this.$r8$classId) {
            case 21:
                return ContentTypeMergeStrategy.Companion.Default$lambda$0(list, list2);
            default:
                return ContentTypeMergeStrategy.Companion.SkipIfPresent$lambda$0(list, list2);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return UCropActivity.lambda$setupAppBar$1(view, windowInsetsCompat);
    }

    public static /* synthetic */ void m$2(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void m$1(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void m$1(String str) {
        throw new NoSuchElementException(str);
    }

    private final void log$com$metrolist$innertubex$InnerTubeLogger$Companion$$ExternalSyntheticLambda0(InnerTubeLogEvent innerTubeLogEvent) {
    }

    public static /* synthetic */ void m$1() {
        throw new HttpException();
    }

    public static /* synthetic */ void m() {
        throw new ClassCastException();
    }

    public static /* bridge */ /* synthetic */ RuntimeShader m(Object obj) {
        return (RuntimeShader) obj;
    }

    public static /* synthetic */ void m(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void m(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalStateException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException((str + obj + obj2 + obj3).toString());
    }

    public static /* synthetic */ void m(String str, Throwable th) {
        throw new RuntimeException(str, th);
    }

    public static /* synthetic */ void m(StringBuilder sb, int i) {
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void m(StringBuilder sb, Object obj, Object obj2) {
        sb.append(obj);
        sb.append(obj2);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static void m(int i) {
        throw new UnknownFieldException(IntIntPair$$ExternalSyntheticOutline0.m(i, "An unknown field for index "));
    }
}
