package com.metrolist.kugou;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.navigation.NavOptionsBuilder;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.lastfm.LastFM;
import com.metrolist.music.MainActivity;
import com.metrolist.music.api.OpenRouterServiceKt;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.DefaultRequestKt;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.compression.ContentEncodingConfig;
import io.ktor.client.plugins.compression.ContentEncodingKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.http.ContentType;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class KuGouKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ KuGouKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object failure;
        byte b = this.$r8$classId;
        byte b2 = 3;
        byte b3 = 2;
        byte b4 = 1;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                HttpClientConfig httpClientConfig = (HttpClientConfig) obj;
                httpClientConfig.getClass();
                httpClientConfig.setExpectSuccess(true);
                httpClientConfig.install(ContentNegotiationKt.getContentNegotiation(), new KuGouKt$$ExternalSyntheticLambda0(b2));
                httpClientConfig.install(ContentEncodingKt.getContentEncoding(), new KuGouKt$$ExternalSyntheticLambda0((byte) 4));
                return unit;
            case 1:
                PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) obj;
                format.getClass();
                return format.height;
            case 2:
                PlayerResponse.StreamingData.Format format2 = (PlayerResponse.StreamingData.Format) obj;
                format2.getClass();
                return Integer.valueOf(format2.bitrate);
            case 3:
                ContentNegotiationConfig contentNegotiationConfig = (ContentNegotiationConfig) obj;
                contentNegotiationConfig.getClass();
                JsonImpl jsonImplJson$default = UuidKt.Json$default(new KuGouKt$$ExternalSyntheticLambda0((byte) 5));
                JsonSupportKt.json$default(contentNegotiationConfig, jsonImplJson$default, null, 2, null);
                ContentType.Text text = ContentType.Text.INSTANCE;
                JsonSupportKt.json(contentNegotiationConfig, jsonImplJson$default, text.getHtml());
                JsonSupportKt.json(contentNegotiationConfig, jsonImplJson$default, text.getPlain());
                return unit;
            case 4:
                ContentEncodingConfig contentEncodingConfig = (ContentEncodingConfig) obj;
                contentEncodingConfig.getClass();
                ContentEncodingConfig.gzip$default(contentEncodingConfig, null, 1, null);
                ContentEncodingConfig.deflate$default(contentEncodingConfig, null, 1, null);
                return unit;
            case 5:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.ignoreUnknownKeys = true;
                jsonBuilder.explicitNulls = false;
                jsonBuilder.encodeDefaults = true;
                return unit;
            case 6:
                JsonBuilder jsonBuilder2 = (JsonBuilder) obj;
                jsonBuilder2.getClass();
                jsonBuilder2.isLenient = true;
                jsonBuilder2.ignoreUnknownKeys = true;
                return unit;
            case 7:
                HttpClientConfig httpClientConfig2 = (HttpClientConfig) obj;
                httpClientConfig2.getClass();
                httpClientConfig2.install(ContentNegotiationKt.getContentNegotiation(), new KuGouKt$$ExternalSyntheticLambda0((byte) 8));
                DefaultRequestKt.defaultRequest(httpClientConfig2, new KuGouKt$$ExternalSyntheticLambda0((byte) 9));
                httpClientConfig2.setExpectSuccess(false);
                return unit;
            case 8:
                ContentNegotiationConfig contentNegotiationConfig2 = (ContentNegotiationConfig) obj;
                contentNegotiationConfig2.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig2, LastFM.json, null, 2, null);
                return unit;
            case 9:
                DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = (DefaultRequest.DefaultRequestBuilder) obj;
                defaultRequestBuilder.getClass();
                defaultRequestBuilder.url("https://ws.audioscrobbler.com/2.0/");
                return unit;
            case 10:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                Object key = entry.getKey();
                Object value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(value);
                return sb.toString();
            case 11:
                Byte b5 = (Byte) obj;
                b5.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b5}, 1));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                HttpClientConfig httpClientConfig3 = (HttpClientConfig) obj;
                httpClientConfig3.getClass();
                httpClientConfig3.install(ContentNegotiationKt.getContentNegotiation(), new KuGouKt$$ExternalSyntheticLambda0((byte) 13));
                DefaultRequestKt.defaultRequest(httpClientConfig3, new KuGouKt$$ExternalSyntheticLambda0((byte) 14));
                httpClientConfig3.setExpectSuccess(true);
                return unit;
            case 13:
                ContentNegotiationConfig contentNegotiationConfig3 = (ContentNegotiationConfig) obj;
                contentNegotiationConfig3.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig3, UuidKt.Json$default(new KuGouKt$$ExternalSyntheticLambda0((byte) 15)), null, 2, null);
                return unit;
            case 14:
                DefaultRequest.DefaultRequestBuilder defaultRequestBuilder2 = (DefaultRequest.DefaultRequestBuilder) obj;
                defaultRequestBuilder2.getClass();
                defaultRequestBuilder2.url("https://lrclib.net");
                return unit;
            case 15:
                JsonBuilder jsonBuilder3 = (JsonBuilder) obj;
                jsonBuilder3.getClass();
                jsonBuilder3.isLenient = true;
                jsonBuilder3.ignoreUnknownKeys = true;
                return unit;
            case 16:
                NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
                int i = MainActivity.$r8$clinit;
                navOptionsBuilder.getClass();
                navOptionsBuilder.launchSingleTop = true;
                return unit;
            case 17:
                int i2 = MainActivity.$r8$clinit;
                ((AnimatedContentTransitionScope) obj).getClass();
                return EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(160, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 18:
                int i3 = MainActivity.$r8$clinit;
                ((AnimatedContentTransitionScope) obj).getClass();
                return EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(100, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 19:
                int i4 = MainActivity.$r8$clinit;
                ((AnimatedContentTransitionScope) obj).getClass();
                return EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(160, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 20:
                int i5 = MainActivity.$r8$clinit;
                ((AnimatedContentTransitionScope) obj).getClass();
                return EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(100, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 21:
                NavOptionsBuilder navOptionsBuilder2 = (NavOptionsBuilder) obj;
                int i6 = MainActivity.$r8$clinit;
                navOptionsBuilder2.getClass();
                navOptionsBuilder2.launchSingleTop = true;
                return unit;
            case 22:
                NavOptionsBuilder navOptionsBuilder3 = (NavOptionsBuilder) obj;
                int i7 = MainActivity.$r8$clinit;
                navOptionsBuilder3.getClass();
                navOptionsBuilder3.launchSingleTop = true;
                return unit;
            case 23:
                ((Long) obj).getClass();
                return unit;
            case 24:
                ((Long) obj).getClass();
                return unit;
            case 25:
                ((Long) obj).getClass();
                return unit;
            case 26:
                JsonBuilder jsonBuilder4 = (JsonBuilder) obj;
                jsonBuilder4.getClass();
                jsonBuilder4.ignoreUnknownKeys = true;
                return unit;
            case 27:
                String str = (String) obj;
                str.getClass();
                try {
                    failure = OpenRouterServiceKt.extractLines(OpenRouterServiceKt.translationJson.parseToJsonElement(str));
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                return (List) (failure instanceof Result.Failure ? null : failure);
            case 28:
                JsonBuilder jsonBuilder5 = (JsonBuilder) obj;
                jsonBuilder5.getClass();
                jsonBuilder5.ignoreUnknownKeys = true;
                return unit;
            default:
                HttpClientConfig httpClientConfig4 = (HttpClientConfig) obj;
                httpClientConfig4.getClass();
                httpClientConfig4.install(ContentNegotiationKt.getContentNegotiation(), new DatabaseDao$$ExternalSyntheticLambda0(b4));
                httpClientConfig4.install(HttpTimeoutKt.getHttpTimeout(), new DatabaseDao$$ExternalSyntheticLambda0(b3));
                DefaultRequestKt.defaultRequest(httpClientConfig4, new DatabaseDao$$ExternalSyntheticLambda0(b2));
                httpClientConfig4.setExpectSuccess(false);
                return unit;
        }
    }
}
