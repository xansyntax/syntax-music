package com.metrolist.shazamkit;

import androidx.collection.LruCache;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.paxsenix.models.AppleMusicSongData$$serializer;
import com.metrolist.paxsenix.models.AppleMusicSongsResult;
import com.metrolist.paxsenix.models.LyricText$$serializer;
import com.metrolist.paxsenix.models.LyricsContent;
import com.metrolist.paxsenix.models.LyricsContent$$serializer;
import com.metrolist.paxsenix.models.LyricsMetadata;
import com.metrolist.paxsenix.models.LyricsResponse;
import com.metrolist.shazamkit.models.ShazamResponseJson;
import com.valentinilk.shimmer.ShimmerThemeKt;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeArea;
import dev.chrisbanes.haze.HazeStyle;
import dev.chrisbanes.haze.HazeTint;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpEngine;
import io.ktor.client.plugins.cache.HttpCacheEntryKt;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.util.date.DateJvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Shazam$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Shazam$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new HttpClient$$ExternalSyntheticLambda1((byte) 14));
            case 1:
                AppleMusicSongsResult.Companion companion = AppleMusicSongsResult.INSTANCE;
                return new HashSetSerializer(AppleMusicSongData$$serializer.INSTANCE, (byte) 1);
            case 2:
                LyricsContent.Companion companion2 = LyricsContent.Companion;
                return new HashSetSerializer(LyricText$$serializer.INSTANCE, (byte) 1);
            case 3:
                LyricsContent.Companion companion3 = LyricsContent.Companion;
                return new HashSetSerializer(LyricText$$serializer.INSTANCE, (byte) 1);
            case 4:
                LyricsMetadata.Companion companion4 = LyricsMetadata.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 5:
                LyricsResponse.Companion companion5 = LyricsResponse.Companion;
                return new HashSetSerializer(LyricsContent$$serializer.INSTANCE, (byte) 1);
            case 6:
                return ShazamResponseJson._childSerializers$_anonymous_();
            case 7:
                return ShazamResponseJson.Track._childSerializers$_anonymous_();
            case 8:
                return ShazamResponseJson.Track._childSerializers$_anonymous_$0();
            case 9:
                return ShazamResponseJson.Track.Hub._childSerializers$_anonymous_();
            case 10:
                return ShazamResponseJson.Track.Hub._childSerializers$_anonymous_$0();
            case 11:
                return ShazamResponseJson.Track.Hub._childSerializers$_anonymous_$1();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ShazamResponseJson.Track.Hub.Option._childSerializers$_anonymous_();
            case 13:
                return ShazamResponseJson.Track.Hub.Provider._childSerializers$_anonymous_();
            case 14:
                return ShazamResponseJson.Track.Section._childSerializers$_anonymous_();
            case 15:
                return ShazamResponseJson.Track.Section._childSerializers$_anonymous_$0();
            case 16:
                return ShazamResponseJson.Track.Section._childSerializers$_anonymous_$1();
            case 17:
                return ShimmerThemeKt.defaultShimmerTheme;
            case 18:
                return new HazeArea();
            case 19:
                return new LruCache(50);
            case 20:
                long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                return new HazeStyle(jColor, new HazeTint(jColor != 16 ? ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), Color.m481getAlphaimpl(jColor) * 0.7f, Color.m483getColorSpaceimpl(jColor)) : jColor), 20.0f, 0.15f);
            case 21:
                return HttpClientConfig.installPlugin$lambda$0$0();
            case 22:
                return HttpClientJvmKt.FACTORY_delegate$lambda$0();
            case 23:
                return OkHttpEngine.okHttpClientPrototype_delegate$lambda$0();
            case 24:
                return Unit.INSTANCE;
            case 25:
                return Unit.INSTANCE;
            case 26:
                return Unit.INSTANCE;
            case 27:
                return HttpCacheEntryKt.cacheExpires$lambda$0();
            case 28:
                return Long.valueOf(DateJvmKt.getTimeMillis());
            default:
                return ClientUpgradeContent.content_delegate$lambda$0();
        }
    }
}
