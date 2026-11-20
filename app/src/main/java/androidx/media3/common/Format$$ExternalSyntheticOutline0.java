package androidx.media3.common;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.media3.common.util.Log;
import androidx.media3.extractor.TrackOutput;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import coil3.network.HttpException;
import com.materialkolor.dynamiccolor.DynamicColor;
import com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder;
import com.materialkolor.ktx.DynamicColorKt;
import com.materialkolor.scheme.DynamicScheme;
import com.metrolist.music.ui.theme.UiStyleKt;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.util.reflect.TypeInfo;
import java.text.Collator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.math.MathKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.Response;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class Format$$ExternalSyntheticOutline0 {
    public static /* synthetic */ void m(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
                return;
            } else {
                Path$$ExternalSyntheticBUOutline0.m();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static String m$1(Modifier.Companion companion, float f, GapComposer gapComposer, int i, GapComposer gapComposer2) {
        OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, f));
        return MathKt.stringResource(i, gapComposer2);
    }

    public static ParcelableSnapshotMutableFloatState m(float f, GapComposer gapComposer) {
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = new ParcelableSnapshotMutableFloatState(f);
        gapComposer.updateRememberedValue(parcelableSnapshotMutableFloatState);
        return parcelableSnapshotMutableFloatState;
    }

    public static Modifier m(float f, float f2, GapComposer gapComposer, Modifier modifier) {
        return ClipKt.clip(modifier, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(f, f2, gapComposer)));
    }

    public static HttpException m(GapComposer gapComposer, int i, boolean z) {
        gapComposer.startReplaceGroup(i);
        gapComposer.end(z);
        return new HttpException();
    }

    public static HttpStatement m(HttpRequestBuilder httpRequestBuilder, HttpMethod httpMethod, HttpRequestBuilder httpRequestBuilder2, HttpClient httpClient) {
        httpRequestBuilder.setMethod(httpMethod);
        return new HttpStatement(httpRequestBuilder2, httpClient);
    }

    public static Object m(GapComposer gapComposer, int i, TransitionInstance transitionInstance) {
        gapComposer.startReplaceGroup(i);
        gapComposer.end(false);
        return transitionInstance.transitionState.getCurrentState();
    }

    public static Object m(HttpRequestBuilder httpRequestBuilder, HttpMethod httpMethod, HttpRequestBuilder httpRequestBuilder2, HttpClient httpClient, Continuation continuation) {
        httpRequestBuilder.setMethod(httpMethod);
        return new HttpStatement(httpRequestBuilder2, httpClient).execute(continuation);
    }

    public static Object m(String str, LinkedHashMap linkedHashMap, String str2) {
        JsonPrimitive JsonPrimitive = JsonElementKt.JsonPrimitive(str);
        JsonPrimitive.getClass();
        return linkedHashMap.put(str2, JsonPrimitive);
    }

    public static String m(char c, String str, String str2) {
        return str + str2 + c;
    }

    public static String m(long j, String str) {
        return str + j;
    }

    public static String m(GapComposer gapComposer, int i, int i2, GapComposer gapComposer2, boolean z) {
        gapComposer.startReplaceGroup(i);
        String strStringResource = MathKt.stringResource(i2, gapComposer2);
        gapComposer.end(z);
        return strStringResource;
    }

    public static String m(Modifier.Companion companion, float f, GapComposer gapComposer, int i, GapComposer gapComposer2) {
        OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, f));
        return MathKt.stringResource(i, gapComposer2);
    }

    public static String m(Exception exc) {
        return Reflection.getOrCreateKotlinClass(exc.getClass()).getSimpleName();
    }

    public static String m(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static StringBuilder m(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static Collator m(int i) {
        Collator collator = Collator.getInstance(Locale.getDefault());
        collator.setStrength(i);
        return collator;
    }

    public static void m(int i, String str, String str2) {
        Log.w(str2, str + i);
    }

    public static void m(int i, HashMap map, String str, int i2, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
    }

    public static void m(Format.Builder builder, TrackOutput trackOutput) {
        trackOutput.format(new Format(builder));
    }

    public static void m(SQLiteConnection sQLiteConnection, SQLiteConnection sQLiteConnection2, String str, SQLiteConnection sQLiteConnection3, String str2) {
        sQLiteConnection.getClass();
        SQLite.execSQL(sQLiteConnection2, str);
        SQLite.execSQL(sQLiteConnection3, str2);
    }

    public static long m(DynamicColor$Companion$Builder dynamicColor$Companion$Builder, DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        return DynamicColorKt.getColor(dynamicColor$Companion$Builder.build().toBuilder().extendSpecVersion(dynamicColor).build(), dynamicScheme);
    }

    public static void m(Integer num, AnimatedContentScopeImpl animatedContentScopeImpl, NavBackStackEntry navBackStackEntry) {
        num.getClass();
        animatedContentScopeImpl.getClass();
        navBackStackEntry.getClass();
    }

    public static void m(String str, String str2, NavHostController navHostController) {
        NavHostController.navigate$default(navHostController, str + str2);
    }

    public static void m(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static void m(ClassReference classReference, boolean z, TypeReference typeReference, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.setBodyType(new TypeInfo(classReference, z, typeReference));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(Response response) throws Exception {
        boolean zIsTerminated;
        if (response instanceof AutoCloseable) {
            response.close();
            return;
        }
        if (!(response instanceof ExecutorService)) {
            Path$$ExternalSyntheticBUOutline0.m();
            return;
        }
        ExecutorService executorService = (ExecutorService) response;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static int m(int i, int i2, int i3, int i4, int i5) {
        return Math.max(((i * i2) / i3) + i4, i5);
    }
}
