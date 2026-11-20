package com.metrolist.innertube;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.dynamiccolor.ColorSpec2025;
import com.materialkolor.dynamiccolor.MaterialDynamicColors;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import com.metrolist.innertube.models.Run;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.compression.ContentEncodingConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.utils.CacheControl;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonBuilder;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTube$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ YouTube$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double dTMaxC$default;
        byte b = this.$r8$classId;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        Variant variant = Variant.NEUTRAL;
        double dTMaxC$default2 = 90.0d;
        DynamicScheme.Platform platform = DynamicScheme.Platform.WATCH;
        Variant variant2 = Variant.TONAL_SPOT;
        Variant variant3 = Variant.EXPRESSIVE;
        Unit unit = Unit.INSTANCE;
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        switch (b) {
            case 0:
                Run run = (Run) obj;
                run.getClass();
                return run.text;
            case 1:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.errorContainer();
            case 2:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? Path.Companion.getContrastCurve(4.5d) : Path.Companion.getContrastCurve(7.0d);
            case 3:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                return dynamicScheme2.secondaryPalette;
            case 4:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                TonalPalette tonalPalette = dynamicScheme3.secondaryPalette;
                boolean z = dynamicScheme3.isDark;
                if (dynamicScheme3.platform == platform) {
                    dTMaxC$default2 = 30.0d;
                } else {
                    Variant variant4 = dynamicScheme3.variant;
                    if (variant4 == Variant.VIBRANT) {
                        dTMaxC$default2 = z ? Path.Companion.tMinC(tonalPalette, 30.0d, 40.0d) : Path.Companion.tMaxC$default(tonalPalette, 84.0d, 90.0d);
                    } else if (variant4 == variant3) {
                        dTMaxC$default2 = z ? 15.0d : Path.Companion.tMaxC$default(tonalPalette, 90.0d, 95.0d);
                    } else if (z) {
                        dTMaxC$default2 = 25.0d;
                    }
                }
                return Double.valueOf(dTMaxC$default2);
            case 5:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                return dynamicScheme4.platform == platform2 ? Path.Companion.getContrastCurve(4.5d) : Path.Companion.getContrastCurve(7.0d);
            case 6:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                if (dynamicScheme5.platform != platform2 || dynamicScheme5.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
            case 7:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                return dynamicScheme6.neutralPalette;
            case 8:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                if (dynamicScheme7.platform != platform2) {
                    return Double.valueOf(1.0d);
                }
                Variant variant5 = dynamicScheme7.variant;
                if (variant5 == variant) {
                    d = 2.2d;
                } else if (variant5 == variant2) {
                    d = 1.7d;
                } else if (variant5 != variant3) {
                    d = 1.0d;
                } else if (dynamicScheme7.neutralPalette.keyColor.isYellow()) {
                    d = dynamicScheme7.isDark ? 3.0d : 2.3d;
                } else {
                    d = 1.6d;
                }
                return Double.valueOf(d);
            case 9:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                if (dynamicScheme8.platform == platform2) {
                    return dynamicScheme8.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 10:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                return dynamicScheme9.platform == platform2 ? Path.Companion.getContrastCurve(3.0d) : Path.Companion.getContrastCurve(4.5d);
            case 11:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                return dynamicScheme10.tertiaryPalette;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                dynamicScheme11.getClass();
                TonalPalette tonalPalette2 = dynamicScheme11.tertiaryPalette;
                boolean z2 = dynamicScheme11.isDark;
                DynamicScheme.Platform platform3 = dynamicScheme11.platform;
                Variant variant6 = dynamicScheme11.variant;
                if (platform3 == platform) {
                    dTMaxC$default = variant6 == variant2 ? Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 90.0d) : Path.Companion.tMaxC(tonalPalette2);
                } else if (variant6 == variant) {
                    dTMaxC$default = z2 ? Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 93.0d) : Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 96.0d);
                } else {
                    int i = 100;
                    if (variant6 == variant2) {
                        dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette2, 0.0d, z2 ? 93 : 100);
                    } else if (variant6 == variant3) {
                        if (tonalPalette2.keyColor.isCyan()) {
                            i = 88;
                        } else if (z2) {
                            i = 93;
                        }
                        dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette2, 75.0d, i);
                    } else {
                        dTMaxC$default = z2 ? Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 93.0d) : Path.Companion.tMaxC$default(tonalPalette2, 72.0d, 100.0d);
                    }
                }
                return Double.valueOf(dTMaxC$default);
            case 13:
                ((DynamicScheme) obj).getClass();
                return Double.valueOf(50.0d);
            case 14:
                ContentNegotiationConfig contentNegotiationConfig = (ContentNegotiationConfig) obj;
                contentNegotiationConfig.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig, UuidKt.Json$default(new YouTube$$ExternalSyntheticLambda0((byte) 18)), null, 2, null);
                return unit;
            case 15:
                ContentEncodingConfig contentEncodingConfig = (ContentEncodingConfig) obj;
                contentEncodingConfig.getClass();
                contentEncodingConfig.gzip(Float.valueOf(0.9f));
                contentEncodingConfig.deflate(Float.valueOf(0.8f));
                return unit;
            case 16:
                HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) obj;
                httpTimeoutConfig.getClass();
                httpTimeoutConfig.setRequestTimeoutMillis(60000L);
                httpTimeoutConfig.setConnectTimeoutMillis(30000L);
                httpTimeoutConfig.setSocketTimeoutMillis(60000L);
                return unit;
            case 17:
                DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = (DefaultRequest.DefaultRequestBuilder) obj;
                defaultRequestBuilder.getClass();
                defaultRequestBuilder.url("https://music.youtube.com/youtubei/v1/");
                UtilsKt.header(defaultRequestBuilder, HttpHeaders.Accept, "application/json");
                UtilsKt.header(defaultRequestBuilder, HttpHeaders.CacheControl, CacheControl.NO_CACHE);
                return unit;
            case 18:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.ignoreUnknownKeys = true;
                jsonBuilder.explicitNulls = false;
                jsonBuilder.encodeDefaults = true;
                return unit;
            case 19:
                Run run2 = (Run) obj;
                run2.getClass();
                return run2.text;
            case 20:
                Run run3 = (Run) obj;
                run3.getClass();
                return run3.text;
            case 21:
                Run run4 = (Run) obj;
                run4.getClass();
                return run4.text;
            case 22:
                Run run5 = (Run) obj;
                run5.getClass();
                return run5.text;
            case 23:
                Run run6 = (Run) obj;
                run6.getClass();
                return run6.text;
            case 24:
                Run run7 = (Run) obj;
                run7.getClass();
                return run7.text;
            case 25:
                Run run8 = (Run) obj;
                run8.getClass();
                return run8.text;
            case 26:
                Run run9 = (Run) obj;
                run9.getClass();
                return run9.text;
            case 27:
                Run run10 = (Run) obj;
                run10.getClass();
                return run10.text;
            case 28:
                Run run11 = (Run) obj;
                run11.getClass();
                return run11.text;
            default:
                Run run12 = (Run) obj;
                run12.getClass();
                return run12.text;
        }
    }
}
