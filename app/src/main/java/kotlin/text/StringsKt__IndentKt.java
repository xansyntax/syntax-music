package kotlin.text;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda35;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.emoji2.text.flatbuffer.Table;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import com.github.ajalt.colormath.Color;
import com.github.ajalt.colormath.model.LAB;
import com.github.ajalt.colormath.model.LABColorSpaceImpl;
import com.github.ajalt.colormath.model.LABColorSpaces;
import com.github.ajalt.colormath.model.RGB;
import com.github.ajalt.colormath.model.RGBColorSpaceImpl;
import com.github.ajalt.colormath.model.RGBColorSpaces;
import com.github.ajalt.colormath.model.SRGB;
import com.github.ajalt.colormath.model.XYZ;
import com.github.ajalt.colormath.model.XYZColorSpaceImpl;
import com.github.ajalt.colormath.model.XYZColorSpaces;
import com.google.common.primitives.Ints$IntArrayAsList;
import com.google.common.primitives.Longs$AsciiDigits;
import com.metrolist.music.betterlyrics.TTMLParser$ParsedLine;
import com.metrolist.music.betterlyrics.TTMLParser$ParsedWord;
import com.metrolist.music.betterlyrics.TTMLParser$SpanInfo;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import io.ktor.http.ContentType;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.MapBuilderValues;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.DispatchException;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.PrimitivesKt;
import okhttp3.CipherSuite;
import okhttp3.ConnectionPool;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.InputStreamSource;
import okio.Okio__OkioKt;
import okio.Path$$ExternalSyntheticBUOutline0;
import okio.Timeout;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringsKt__IndentKt {
    public static final void ButtonPlaceholder(Modifier modifier, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1360353462);
        byte b = 1;
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            OffsetKt.Spacer(gapComposer, ImageKt.m39backgroundbw27NRU(Format$$ExternalSyntheticOutline0.m(50.0f, 8.0f, gapComposer, SizeKt.m145height3ABfNKs(modifier, ButtonDefaults.m250getMinHeightD9Ej5fM())), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda35(modifier, i, b);
        }
    }

    public static final PrimitiveSerialDescriptor PrimitiveSerialDescriptor(String str) {
        PrimitiveKind$INT primitiveKind$INT = PrimitiveKind$INT.INSTANCE$8;
        if (StringsKt.isBlank(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
            return null;
        }
        Object it = ((MapBuilderValues) PrimitivesKt.BUILTIN_SERIALIZERS.values()).iterator();
        while (((Table) it).hasNext()) {
            KSerializer kSerializer = (KSerializer) ((MapBuilder.KeysItr) it).next();
            if (str.equals(kSerializer.getDescriptor().getSerialName())) {
                StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                sbM4m.append(Reflection.getOrCreateKotlinClass(kSerializer.getClass()).getSimpleName());
                sbM4m.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(trimIndent(sbM4m.toString()));
                return null;
            }
        }
        return new PrimitiveSerialDescriptor(str, primitiveKind$INT);
    }

    public static void appendElement(Appendable appendable, Object obj, Function1 function1) {
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }

    public static List asList(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new Ints$IntArrayAsList(0, iArr.length, iArr);
    }

    public static String buildLineText(List list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            TTMLParser$ParsedWord tTMLParser$ParsedWord = (TTMLParser$ParsedWord) obj;
            sb.append(tTMLParser$ParsedWord.text);
            if (tTMLParser$ParsedWord.hasTrailingSpace && !StringsKt.endsWith$default((CharSequence) tTMLParser$ParsedWord.text, '-') && i < list.size() - 1) {
                sb.append(ServerSentEventKt.SPACE);
            }
            i = i2;
        }
        return StringsKt.trim(sb.toString()).toString();
    }

    public static final SerialDescriptorImpl buildSerialDescriptor(String str, Okio__OkioKt okio__OkioKt, SerialDescriptor[] serialDescriptorArr, Function1 function1) {
        if (StringsKt.isBlank(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
            return null;
        }
        if (okio__OkioKt.equals(StructureKind$MAP.INSTANCE$1)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
        function1.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(str, okio__OkioKt, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
    }

    public static SerialDescriptorImpl buildSerialDescriptor$default(String str, Okio__OkioKt okio__OkioKt, SerialDescriptor[] serialDescriptorArr) {
        if (StringsKt.isBlank(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
            return null;
        }
        if (okio__OkioKt.equals(StructureKind$MAP.INSTANCE$1)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
        return new SerialDescriptorImpl(str, okio__OkioKt, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
    }

    public static void checkBoundsIndexes$kotlin_stdlib(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m3m(i, "startIndex: ", ", endIndex: ", i2, ", size: "), i3);
        } else {
            if (i <= i2) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "startIndex: ", " > endIndex: "));
        }
    }

    public static void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m3m(i, "fromIndex: ", ", toIndex: ", i2, ", size: "), i3);
        } else {
            if (i <= i2) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int checkedCast(long j) {
        int i = (int) j;
        UtilsKt.checkArgument(j, "Out of range: %s", ((long) i) == j);
        return i;
    }

    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) {
        boolean zIsTerminated;
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    Fragment$5$$ExternalSyntheticOutline0.m(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    ResultKt.addSuppressed(th, th2);
                    return;
                }
            }
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
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055 A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:12:0x002c, B:28:0x007b, B:19:0x0055, B:21:0x005b, B:23:0x0061, B:29:0x008a, B:30:0x0091, B:31:0x0092, B:32:0x0099, B:33:0x009a, B:17:0x0040), top: B:38:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:12:0x002c, B:28:0x007b, B:19:0x0055, B:21:0x005b, B:23:0x0061, B:29:0x008a, B:30:0x0091, B:31:0x0092, B:32:0x0099, B:33:0x009a, B:17:0x0040), top: B:38:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0061 A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #0 {all -> 0x00a4, blocks: (B:12:0x002c, B:28:0x007b, B:19:0x0055, B:21:0x005b, B:23:0x0061, B:29:0x008a, B:30:0x0091, B:31:0x0092, B:32:0x0099, B:33:0x009a, B:17:0x0040), top: B:38:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0079  */
    /* JADX WARN: Code duplicated, block: B:31:0x0092 A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:12:0x002c, B:28:0x007b, B:19:0x0055, B:21:0x005b, B:23:0x0061, B:29:0x008a, B:30:0x0091, B:31:0x0092, B:32:0x0099, B:33:0x009a, B:17:0x0040), top: B:38:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:28:0x007b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object completedLibrary(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof com.metrolist.innertube.utils.UtilsKt$completed$1
            if (r0 == 0) goto L13
            r0 = r9
            com.metrolist.innertube.utils.UtilsKt$completed$1 r0 = (com.metrolist.innertube.utils.UtilsKt$completed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.metrolist.innertube.utils.UtilsKt$completed$1 r0 = new com.metrolist.innertube.utils.UtilsKt$completed$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L37
            int r8 = r0.I$0
            java.util.Set r1 = r0.L$5
            java.util.Set r1 = (java.util.Set) r1
            com.metrolist.innertube.pages.PlaylistPage r4 = r0.L$3
            java.util.List r5 = r0.L$2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> La4
            kotlin.Result r9 = (kotlin.Result) r9     // Catch: java.lang.Throwable -> La4
            java.lang.Object r9 = r9.value     // Catch: java.lang.Throwable -> La4
            r6 = r8
            r8 = r4
            r4 = r1
            goto L7b
        L37:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r8)
            return r3
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> La4
            com.metrolist.innertube.pages.PlaylistPage r8 = (com.metrolist.innertube.pages.PlaylistPage) r8     // Catch: java.lang.Throwable -> La4
            java.util.List r9 = r8.songs     // Catch: java.lang.Throwable -> La4
            java.util.ArrayList r9 = kotlin.collections.CollectionsKt.toMutableList(r9)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r8.songsContinuation     // Catch: java.lang.Throwable -> La4
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet     // Catch: java.lang.Throwable -> La4
            r4.<init>()     // Catch: java.lang.Throwable -> La4
            r5 = 0
        L53:
            if (r1 == 0) goto L9a
            int r6 = r5 + 1
            r7 = 50
            if (r5 >= r7) goto L92
            boolean r5 = r4.add(r1)     // Catch: java.lang.Throwable -> La4
            if (r5 == 0) goto L8a
            com.metrolist.innertube.YouTube r5 = com.metrolist.innertube.YouTube.INSTANCE     // Catch: java.lang.Throwable -> La4
            r0.L$2 = r9     // Catch: java.lang.Throwable -> La4
            r0.L$3 = r8     // Catch: java.lang.Throwable -> La4
            r7 = r4
            java.util.Set r7 = (java.util.Set) r7     // Catch: java.lang.Throwable -> La4
            r0.L$5 = r7     // Catch: java.lang.Throwable -> La4
            r0.I$0 = r6     // Catch: java.lang.Throwable -> La4
            r0.label = r2     // Catch: java.lang.Throwable -> La4
            java.lang.Object r1 = r5.m1026playlistContinuationgIAlus(r1, r0)     // Catch: java.lang.Throwable -> La4
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r5) goto L79
            return r5
        L79:
            r5 = r9
            r9 = r1
        L7b:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> La4
            com.metrolist.innertube.pages.PlaylistContinuationPage r9 = (com.metrolist.innertube.pages.PlaylistContinuationPage) r9     // Catch: java.lang.Throwable -> La4
            java.util.ArrayList r1 = r9.songs     // Catch: java.lang.Throwable -> La4
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r1, r5)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r9.continuation     // Catch: java.lang.Throwable -> La4
            r9 = r5
            r5 = r6
            goto L53
        L8a:
            java.lang.String r8 = "Playlist pagination repeated a continuation"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La4
            r9.<init>(r8)     // Catch: java.lang.Throwable -> La4
            throw r9     // Catch: java.lang.Throwable -> La4
        L92:
            java.lang.String r8 = "Playlist pagination exceeded 50 requests"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La4
            r9.<init>(r8)     // Catch: java.lang.Throwable -> La4
            throw r9     // Catch: java.lang.Throwable -> La4
        L9a:
            com.metrolist.innertube.pages.PlaylistPage r0 = new com.metrolist.innertube.pages.PlaylistPage     // Catch: java.lang.Throwable -> La4
            com.metrolist.innertube.models.PlaylistItem r1 = r8.playlist     // Catch: java.lang.Throwable -> La4
            java.lang.String r8 = r8.continuation     // Catch: java.lang.Throwable -> La4
            r0.<init>(r1, r9, r3, r8)     // Catch: java.lang.Throwable -> La4
            return r0
        La4:
            r8 = move-exception
            kotlin.Result$Failure r9 = new kotlin.Result$Failure
            r9.<init>(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__IndentKt.completedLibrary(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057 A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:12:0x002c, B:27:0x007d, B:19:0x0057, B:21:0x005d, B:23:0x0063, B:28:0x008b, B:29:0x0092, B:30:0x0093, B:31:0x009a, B:32:0x009b, B:17:0x0041), top: B:37:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:12:0x002c, B:27:0x007d, B:19:0x0057, B:21:0x005d, B:23:0x0063, B:28:0x008b, B:29:0x0092, B:30:0x0093, B:31:0x009a, B:32:0x009b, B:17:0x0041), top: B:37:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:12:0x002c, B:27:0x007d, B:19:0x0057, B:21:0x005d, B:23:0x0063, B:28:0x008b, B:29:0x0092, B:30:0x0093, B:31:0x009a, B:32:0x009b, B:17:0x0041), top: B:37:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:26:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0093 A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:12:0x002c, B:27:0x007d, B:19:0x0057, B:21:0x005d, B:23:0x0063, B:28:0x008b, B:29:0x0092, B:30:0x0093, B:31:0x009a, B:32:0x009b, B:17:0x0041), top: B:37:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007a -> B:27:0x007d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object completedPlaylist(java.lang.Object r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            boolean r0 = r10 instanceof com.metrolist.innertube.utils.UtilsKt$completed$3
            if (r0 == 0) goto L13
            r0 = r10
            com.metrolist.innertube.utils.UtilsKt$completed$3 r0 = (com.metrolist.innertube.utils.UtilsKt$completed$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.metrolist.innertube.utils.UtilsKt$completed$3 r0 = new com.metrolist.innertube.utils.UtilsKt$completed$3
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 != r3) goto L37
            int r9 = r0.I$0
            java.util.Set r1 = r0.L$5
            java.util.Set r1 = (java.util.Set) r1
            com.metrolist.innertube.pages.LibraryPage r4 = r0.L$3
            java.util.List r5 = r0.L$2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> La1
            kotlin.Result r10 = (kotlin.Result) r10     // Catch: java.lang.Throwable -> La1
            java.lang.Object r10 = r10.value     // Catch: java.lang.Throwable -> La1
            r6 = r9
            r9 = r4
            r4 = r1
            goto L7d
        L37:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r9)
            r9 = 0
            return r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> La1
            com.metrolist.innertube.pages.LibraryPage r9 = (com.metrolist.innertube.pages.LibraryPage) r9     // Catch: java.lang.Throwable -> La1
            java.util.List r10 = r9.items     // Catch: java.lang.Throwable -> La1
            java.util.ArrayList r10 = kotlin.collections.CollectionsKt.toMutableList(r10)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = r9.continuation     // Catch: java.lang.Throwable -> La1
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet     // Catch: java.lang.Throwable -> La1
            r4.<init>()     // Catch: java.lang.Throwable -> La1
            r5 = r10
            r10 = r2
        L55:
            if (r1 == 0) goto L9b
            int r6 = r10 + 1
            r7 = 50
            if (r10 >= r7) goto L93
            boolean r10 = r4.add(r1)     // Catch: java.lang.Throwable -> La1
            if (r10 == 0) goto L8b
            com.metrolist.innertube.YouTube r10 = com.metrolist.innertube.YouTube.INSTANCE     // Catch: java.lang.Throwable -> La1
            boolean r7 = r9.isUploaded     // Catch: java.lang.Throwable -> La1
            r0.L$2 = r5     // Catch: java.lang.Throwable -> La1
            r0.L$3 = r9     // Catch: java.lang.Throwable -> La1
            r8 = r4
            java.util.Set r8 = (java.util.Set) r8     // Catch: java.lang.Throwable -> La1
            r0.L$5 = r8     // Catch: java.lang.Throwable -> La1
            r0.I$0 = r6     // Catch: java.lang.Throwable -> La1
            r0.label = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r10 = r10.m1012libraryContinuation0E7RQCE(r1, r7, r0)     // Catch: java.lang.Throwable -> La1
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r10 != r1) goto L7d
            return r1
        L7d:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> La1
            com.metrolist.innertube.pages.LibraryContinuationPage r10 = (com.metrolist.innertube.pages.LibraryContinuationPage) r10     // Catch: java.lang.Throwable -> La1
            java.util.ArrayList r1 = r10.items     // Catch: java.lang.Throwable -> La1
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r1, r5)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = r10.continuation     // Catch: java.lang.Throwable -> La1
            r10 = r6
            goto L55
        L8b:
            java.lang.String r9 = "Library pagination repeated a continuation"
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La1
            r10.<init>(r9)     // Catch: java.lang.Throwable -> La1
            throw r10     // Catch: java.lang.Throwable -> La1
        L93:
            java.lang.String r9 = "Library pagination exceeded 50 requests"
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La1
            r10.<init>(r9)     // Catch: java.lang.Throwable -> La1
            throw r10     // Catch: java.lang.Throwable -> La1
        L9b:
            r10 = 4
            com.metrolist.innertube.pages.LibraryPage r9 = com.metrolist.innertube.pages.LibraryPage.copy$default(r9, r5, r2, r10)     // Catch: java.lang.Throwable -> La1
            return r9
        La1:
            r9 = move-exception
            kotlin.Result$Failure r10 = new kotlin.Result$Failure
            r10.<init>(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__IndentKt.completedPlaylist(java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static int constrainToRange(int i, int i2) {
        UtilsKt.checkArgument("min (%s) must be less than or equal to max (%s)", i2, 1073741823, i2 <= 1073741823);
        return Math.min(Math.max(i, i2), 1073741823);
    }

    public static final void dispatcherFailure(Throwable th, Continuation continuation) throws Throwable {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).cause;
        }
        continuation.resumeWith(new Result.Failure(th));
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0077 A[PHI: r0
      0x0077: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v7 java.lang.String) binds: [B:9:0x002c, B:32:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    public static final Pair fileNameAndSize(ContentResolver contentResolver, Uri uri) throws IOException {
        long j;
        String string;
        uri.getClass();
        String lastPathSegment = uri.getLastPathSegment();
        String strSubstringAfterLast = lastPathSegment != null ? StringsKt.substringAfterLast('/', lastPathSegment, lastPathSegment) : "unknown";
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        long length = -1;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    int columnIndex = cursorQuery.getColumnIndex("_display_name");
                    Integer numValueOf = Integer.valueOf(columnIndex);
                    Integer num = null;
                    if (columnIndex < 0 || cursorQuery.isNull(columnIndex)) {
                        numValueOf = null;
                    }
                    if (numValueOf != null && (string = cursorQuery.getString(numValueOf.intValue())) != null) {
                        if (StringsKt.isBlank(string)) {
                            string = null;
                        }
                        if (string != null) {
                            strSubstringAfterLast = string;
                        }
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex("_size");
                    Integer numValueOf2 = Integer.valueOf(columnIndex2);
                    if (columnIndex2 >= 0 && !cursorQuery.isNull(columnIndex2)) {
                        num = numValueOf2;
                    }
                    if (num != null) {
                        j = cursorQuery.getLong(num.intValue());
                    } else {
                        j = -1;
                    }
                } else {
                    j = -1;
                }
                cursorQuery.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        } else {
            j = -1;
        }
        if (j <= 0) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                try {
                    length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CharsKt.closeFinally(assetFileDescriptorOpenAssetFileDescriptor, th3);
                        throw th4;
                    }
                }
            }
            j = length;
        }
        return new Pair(strSubstringAfterLast, Long.valueOf(j));
    }

    public static Element findChild(Element element, String str) {
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild instanceof Element) {
                Element element2 = (Element) firstChild;
                String localName = element2.getLocalName();
                if (localName == null) {
                    String nodeName = element2.getNodeName();
                    nodeName.getClass();
                    localName = StringsKt.substringAfterLast(':', nodeName, nodeName);
                }
                if (localName.equals(str)) {
                    return element2;
                }
            }
        }
        return null;
    }

    public static Object fold(CoroutineContext.Element element, Object obj, Function2 function2) {
        function2.getClass();
        return function2.invoke(obj, element);
    }

    public static String formatLrcTime(double d) {
        long j = (long) (d * 1000.0d);
        long j2 = j / 60000;
        long j3 = (j % 60000) / 1000;
        long j4 = (j % 1000) / 10;
        StringBuilder sb = new StringBuilder(10);
        sb.append('[');
        if (j2 < 10) {
            sb.append('0');
        }
        sb.append(j2);
        sb.append(':');
        if (j3 < 10) {
            sb.append('0');
        }
        sb.append(j3);
        sb.append('.');
        if (j4 < 10) {
            sb.append('0');
        }
        sb.append(j4);
        sb.append(']');
        return sb.toString();
    }

    public static int fromBytes(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        List immutableList;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("cipherSuite == null");
            return null;
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") || cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("cipherSuite == ".concat(cipherSuite));
            return null;
        }
        CipherSuite cipherSuiteM1909forJavaName = CipherSuite.Companion.m1909forJavaName(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("tlsVersion == null");
            return null;
        }
        if ("NONE".equals(protocol)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("tlsVersion == NONE");
            return null;
        }
        TlsVersion.Companion.getClass();
        TlsVersion tlsVersionForJavaName = Protocol.Companion.forJavaName(protocol);
        try {
            immutableList = _UtilJvmKt.toImmutableList(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            immutableList = EmptyList.INSTANCE;
        }
        return new Handshake(tlsVersionForJavaName, cipherSuiteM1909forJavaName, _UtilJvmKt.toImmutableList(sSLSession.getLocalCertificates()), new Url$$ExternalSyntheticLambda0(immutableList, (byte) 7));
    }

    public static String getAttr(Element element, String str) {
        String attribute = element.getAttribute("ttm:".concat(str));
        attribute.getClass();
        if (attribute.length() > 0) {
            return attribute;
        }
        String attribute2 = element.getAttribute(str);
        attribute2.getClass();
        if (attribute2.length() > 0) {
            return attribute2;
        }
        String attributeNS = element.getAttributeNS("http://www.w3.org/ns/ttml#metadata", str);
        attributeNS.getClass();
        return attributeNS;
    }

    public static String getDirectText(Element element) {
        StringBuilder sb = new StringBuilder();
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 3) {
                sb.append(firstChild.getTextContent());
            } else if (firstChild instanceof Element) {
                Element element2 = (Element) firstChild;
                String localName = element2.getLocalName();
                if (localName == null) {
                    String nodeName = element2.getNodeName();
                    nodeName.getClass();
                    localName = StringsKt.substringAfterLast(':', nodeName, nodeName);
                }
                String attr = getAttr(element2, "role");
                if (localName.equals("span") && !attr.equals("x-bg") && !attr.equals("x-translation") && !attr.equals("x-roman")) {
                    sb.append(element2.getTextContent());
                }
            }
        }
        return sb.toString();
    }

    public static List mergeSpansIntoWords(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        StringBuilder sb = new StringBuilder(((TTMLParser$SpanInfo) arrayList.get(0)).text);
        double d = ((TTMLParser$SpanInfo) arrayList.get(0)).startTime;
        double d2 = ((TTMLParser$SpanInfo) arrayList.get(0)).endTime;
        int size = arrayList.size();
        double d3 = d;
        double d4 = d2;
        for (int i2 = 1; i2 < size; i2++) {
            TTMLParser$SpanInfo tTMLParser$SpanInfo = (TTMLParser$SpanInfo) arrayList.get(i2 - 1);
            TTMLParser$SpanInfo tTMLParser$SpanInfo2 = (TTMLParser$SpanInfo) arrayList.get(i2);
            if (!tTMLParser$SpanInfo.hasTrailingSpace || StringsKt.endsWith$default((CharSequence) tTMLParser$SpanInfo.text, '-')) {
                sb.append(tTMLParser$SpanInfo2.text);
            } else {
                arrayList2.add(new TTMLParser$ParsedWord(sb.toString(), d3, d4, true));
                sb = new StringBuilder(tTMLParser$SpanInfo2.text);
                d3 = tTMLParser$SpanInfo2.startTime;
            }
            d4 = tTMLParser$SpanInfo2.endTime;
        }
        arrayList2.add(new TTMLParser$ParsedWord(sb.toString(), d3, d4, ((TTMLParser$SpanInfo) CollectionsKt.last(arrayList)).hasTrailingSpace));
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj = arrayList2.get(i3);
            i3++;
            TTMLParser$ParsedWord tTMLParser$ParsedWord = (TTMLParser$ParsedWord) obj;
            String string = StringsKt.trim(tTMLParser$ParsedWord.text).toString();
            double d5 = tTMLParser$ParsedWord.startTime;
            double d6 = tTMLParser$ParsedWord.endTime;
            boolean z = tTMLParser$ParsedWord.hasTrailingSpace;
            string.getClass();
            arrayList3.add(new TTMLParser$ParsedWord(string, d5, d6, z));
        }
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        while (i < size3) {
            Object obj2 = arrayList3.get(i);
            i++;
            if (((TTMLParser$ParsedWord) obj2).text.length() > 0) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    public static CoroutineContext minusKey(CoroutineContext.Element element, CoroutineContext.Key key) {
        key.getClass();
        return Intrinsics.areEqual(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
    }

    public static final Map parseCookieString(String str) {
        str.getClass();
        List listSplit$default = StringsKt.split$default(str, new String[]{"; "}, 0, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            String str2 = (String) obj2;
            int iIndexOf$default = StringsKt.indexOf$default(str2, '=', 0, 6);
            Pair pair = iIndexOf$default == -1 ? null : new Pair(str2.substring(0, iIndexOf$default), str2.substring(iIndexOf$default + 1));
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList2);
    }

    public static List parseTTML(String str) {
        Element elementFindChild;
        Element elementFindChild2;
        str.getClass();
        ArrayList arrayList = new ArrayList();
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setNamespaceAware(true);
            try {
                documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            } catch (Exception unused) {
            }
            try {
                documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            } catch (Exception unused2) {
            }
            try {
                documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            } catch (Exception unused3) {
            }
            try {
                documentBuilderFactoryNewInstance.setXIncludeAware(false);
            } catch (Exception unused4) {
            }
            try {
                documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
            } catch (Exception unused5) {
            }
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            bytes.getClass();
            Element documentElement = documentBuilderNewDocumentBuilder.parse(new ByteArrayInputStream(bytes)).getDocumentElement();
            documentElement.getClass();
            Element elementFindChild3 = findChild(documentElement, "head");
            double dDoubleValue = 0.0d;
            if (elementFindChild3 != null && (elementFindChild = findChild(elementFindChild3, "metadata")) != null && (elementFindChild2 = findChild(elementFindChild, ContentType.Audio.TYPE)) != null) {
                String attribute = elementFindChild2.getAttribute("lyricOffset");
                attribute.getClass();
                Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(attribute);
                if (doubleOrNull != null) {
                    dDoubleValue = doubleOrNull.doubleValue();
                }
            }
            Element elementFindChild4 = findChild(documentElement, "body");
            if (elementFindChild4 != null) {
                walk(elementFindChild4, arrayList, dDoubleValue, null);
            }
            return arrayList;
        } catch (Exception unused6) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
            return EmptyList.INSTANCE;
        }
    }

    public static double parseTime(String str) {
        String string = StringsKt.trim(str).toString();
        int iIndexOf$default = StringsKt.indexOf$default(string, ':', 0, 6);
        if (iIndexOf$default == -1) {
            if (StringsKt__StringsJVMKt.endsWith(string, "ms", false)) {
                Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(string.substring(0, string.length() - 2));
                return (doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d) / 1000.0d;
            }
            Double doubleOrNull2 = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull((StringsKt__StringsJVMKt.endsWith(string, "s", false) || StringsKt__StringsJVMKt.endsWith(string, "m", false) || StringsKt__StringsJVMKt.endsWith(string, "h", false)) ? string.substring(0, string.length() - 1) : string);
            double dDoubleValue = doubleOrNull2 != null ? doubleOrNull2.doubleValue() : 0.0d;
            if (StringsKt__StringsJVMKt.endsWith(string, "m", false)) {
                return dDoubleValue * 60.0d;
            }
            return StringsKt__StringsJVMKt.endsWith(string, "h", false) ? dDoubleValue * 3600.0d : dDoubleValue;
        }
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(string, ':', 0, 6);
        if (iIndexOf$default == iLastIndexOf$default) {
            Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, string.substring(0, iIndexOf$default));
            double dIntValue = ((double) (intOrNull != null ? intOrNull.intValue() : 0)) * 60.0d;
            Double doubleOrNull3 = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(string.substring(iIndexOf$default + 1));
            return dIntValue + (doubleOrNull3 != null ? doubleOrNull3.doubleValue() : 0.0d);
        }
        Integer intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull(10, string.substring(0, iIndexOf$default));
        double dIntValue2 = ((double) (intOrNull2 != null ? intOrNull2.intValue() : 0)) * 3600.0d;
        Integer intOrNull3 = StringsKt__StringsJVMKt.toIntOrNull(10, string.substring(iIndexOf$default + 1, iLastIndexOf$default));
        double dIntValue3 = (((double) (intOrNull3 != null ? intOrNull3.intValue() : 0)) * 60.0d) + dIntValue2;
        Double doubleOrNull4 = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(string.substring(iLastIndexOf$default + 1));
        return dIntValue3 + (doubleOrNull4 != null ? doubleOrNull4.doubleValue() : 0.0d);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    public static void parseWordSpan(Element element, double d, ArrayList arrayList, Node node) {
        boolean z;
        String textContent;
        String strTimingAttr = timingAttr(element, "begin");
        String strTimingAttr2 = timingAttr(element, "end");
        String textContent2 = element.getTextContent();
        if (textContent2 == null) {
            textContent2 = "";
        }
        String str = textContent2;
        if (strTimingAttr.length() <= 0 || strTimingAttr2.length() <= 0) {
            return;
        }
        Node nextSibling = node.getNextSibling();
        if (str.length() <= 0 || !CharsKt.isWhitespace(StringsKt.last(str))) {
            if (nextSibling != null && nextSibling.getNodeType() == 3 && (textContent = nextSibling.getTextContent()) != null) {
                Character chValueOf = textContent.length() == 0 ? null : Character.valueOf(textContent.charAt(0));
                if (chValueOf != null && CharsKt.isWhitespace(chValueOf.charValue())) {
                    z = true;
                }
            }
            z = false;
        } else {
            z = true;
        }
        arrayList.add(new TTMLParser$SpanInfo(str, parseTime(strTimingAttr) + d, parseTime(strTimingAttr2) + d, z));
    }

    public static CoroutineContext plus(CoroutineContext.Element element, CoroutineContext coroutineContext) {
        coroutineContext.getClass();
        return coroutineContext == EmptyCoroutineContext.INSTANCE ? element : (CoroutineContext) coroutineContext.fold(element, new CombinedContext$$ExternalSyntheticLambda0((byte) 8));
    }

    public static int saturatedCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static final InputStreamSource source(InputStream inputStream) {
        inputStream.getClass();
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static String timingAttr(Element element, String str) {
        String attribute = element.getAttribute(str);
        attribute.getClass();
        if (attribute.length() > 0) {
            return attribute;
        }
        String attributeNS = element.getAttributeNS("http://www.w3.org/ns/ttml#parameter", str);
        attributeNS.getClass();
        return attributeNS.length() > 0 ? attributeNS : "";
    }

    public static int[] toArray(Collection collection) {
        if (collection instanceof Ints$IntArrayAsList) {
            Ints$IntArrayAsList ints$IntArrayAsList = (Ints$IntArrayAsList) collection;
            return Arrays.copyOfRange(ints$IntArrayAsList.array, ints$IntArrayAsList.start, ints$IntArrayAsList.end);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    /* JADX INFO: renamed from: toColormathColor-8_81llA, reason: not valid java name */
    public static final Color m1882toColormathColor8_81llA(long j) {
        ColorSpace colorSpaceM483getColorSpaceimpl = androidx.compose.ui.graphics.Color.m483getColorSpaceimpl(j);
        Rgb rgb = ColorSpaces.Srgb;
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, rgb)) {
            return SRGB.INSTANCE.invoke(androidx.compose.ui.graphics.Color.m485getRedimpl(j), androidx.compose.ui.graphics.Color.m484getGreenimpl(j), androidx.compose.ui.graphics.Color.m482getBlueimpl(j), androidx.compose.ui.graphics.Color.m481getAlphaimpl(j));
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.Aces)) {
            RGBColorSpaceImpl rGBColorSpaceImpl = RGBColorSpaces.ACES;
            float fM485getRedimpl = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl.getClass();
            return new RGB(fM485getRedimpl, fM484getGreenimpl, fM482getBlueimpl, fM481getAlphaimpl, rGBColorSpaceImpl);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.Acescg)) {
            RGBColorSpaceImpl rGBColorSpaceImpl2 = RGBColorSpaces.ACEScg;
            float fM485getRedimpl2 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl2 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl2 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl2 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl2.getClass();
            return new RGB(fM485getRedimpl2, fM484getGreenimpl2, fM482getBlueimpl2, fM481getAlphaimpl2, rGBColorSpaceImpl2);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.AdobeRgb)) {
            RGBColorSpaceImpl rGBColorSpaceImpl3 = RGBColorSpaces.AdobeRGB;
            float fM485getRedimpl3 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl3 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl3 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl3 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl3.getClass();
            return new RGB(fM485getRedimpl3, fM484getGreenimpl3, fM482getBlueimpl3, fM481getAlphaimpl3, rGBColorSpaceImpl3);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.Bt2020)) {
            RGBColorSpaceImpl rGBColorSpaceImpl4 = RGBColorSpaces.BT2020;
            float fM485getRedimpl4 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl4 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl4 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl4 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl4.getClass();
            return new RGB(fM485getRedimpl4, fM484getGreenimpl4, fM482getBlueimpl4, fM481getAlphaimpl4, rGBColorSpaceImpl4);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.Bt709)) {
            RGBColorSpaceImpl rGBColorSpaceImpl5 = RGBColorSpaces.BT709;
            float fM485getRedimpl5 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl5 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl5 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl5 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl5.getClass();
            return new RGB(fM485getRedimpl5, fM484getGreenimpl5, fM482getBlueimpl5, fM481getAlphaimpl5, rGBColorSpaceImpl5);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.CieLab)) {
            LABColorSpaceImpl lABColorSpaceImpl = LABColorSpaces.LAB50;
            float fM485getRedimpl6 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl6 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl6 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl6 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            lABColorSpaceImpl.getClass();
            return new LAB(fM485getRedimpl6, fM484getGreenimpl6, fM482getBlueimpl6, fM481getAlphaimpl6, lABColorSpaceImpl);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.CieXyz)) {
            XYZColorSpaceImpl xYZColorSpaceImpl = XYZColorSpaces.XYZ50;
            float fM485getRedimpl7 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl7 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl7 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl7 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            xYZColorSpaceImpl.getClass();
            return new XYZ(fM485getRedimpl7, fM484getGreenimpl7, fM482getBlueimpl7, fM481getAlphaimpl7, xYZColorSpaceImpl);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.DciP3)) {
            RGBColorSpaceImpl rGBColorSpaceImpl6 = RGBColorSpaces.DCI_P3;
            float fM485getRedimpl8 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl8 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl8 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl8 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl6.getClass();
            return new RGB(fM485getRedimpl8, fM484getGreenimpl8, fM482getBlueimpl8, fM481getAlphaimpl8, rGBColorSpaceImpl6);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.DisplayP3)) {
            RGBColorSpaceImpl rGBColorSpaceImpl7 = RGBColorSpaces.DisplayP3;
            float fM485getRedimpl9 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl9 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl9 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl9 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl7.getClass();
            return new RGB(fM485getRedimpl9, fM484getGreenimpl9, fM482getBlueimpl9, fM481getAlphaimpl9, rGBColorSpaceImpl7);
        }
        if (Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.LinearSrgb)) {
            RGBColorSpaceImpl rGBColorSpaceImpl8 = RGBColorSpaces.LinearSRGB;
            float fM485getRedimpl10 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
            float fM484getGreenimpl10 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
            float fM482getBlueimpl10 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
            float fM481getAlphaimpl10 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
            rGBColorSpaceImpl8.getClass();
            return new RGB(fM485getRedimpl10, fM484getGreenimpl10, fM482getBlueimpl10, fM481getAlphaimpl10, rGBColorSpaceImpl8);
        }
        if (!Intrinsics.areEqual(colorSpaceM483getColorSpaceimpl, ColorSpaces.ProPhotoRgb)) {
            long jM479convertvNxB06k = androidx.compose.ui.graphics.Color.m479convertvNxB06k(j, rgb);
            return SRGB.INSTANCE.invoke(androidx.compose.ui.graphics.Color.m485getRedimpl(jM479convertvNxB06k), androidx.compose.ui.graphics.Color.m484getGreenimpl(jM479convertvNxB06k), androidx.compose.ui.graphics.Color.m482getBlueimpl(jM479convertvNxB06k), androidx.compose.ui.graphics.Color.m481getAlphaimpl(jM479convertvNxB06k));
        }
        RGBColorSpaceImpl rGBColorSpaceImpl9 = RGBColorSpaces.ROMM_RGB;
        float fM485getRedimpl11 = androidx.compose.ui.graphics.Color.m485getRedimpl(j);
        float fM484getGreenimpl11 = androidx.compose.ui.graphics.Color.m484getGreenimpl(j);
        float fM482getBlueimpl11 = androidx.compose.ui.graphics.Color.m482getBlueimpl(j);
        float fM481getAlphaimpl11 = androidx.compose.ui.graphics.Color.m481getAlphaimpl(j);
        rGBColorSpaceImpl9.getClass();
        return new RGB(fM485getRedimpl11, fM484getGreenimpl11, fM482getBlueimpl11, fM481getAlphaimpl11, rGBColorSpaceImpl9);
    }

    public static String toLRC(List list) throws Throwable {
        boolean z;
        String lowerCase;
        boolean z2;
        String strM;
        Throwable th;
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = ((TTMLParser$ParsedLine) it.next()).agent;
            if (str2 != null) {
                String lowerCase2 = str2.toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                int iHashCode = lowerCase2.hashCode();
                if (iHashCode != 3707) {
                    if (iHashCode != 3708) {
                        if (iHashCode == 110482901 && lowerCase2.equals("v1000")) {
                            linkedHashMap.put(lowerCase2, lowerCase2);
                        }
                    } else if (lowerCase2.equals("v2")) {
                        linkedHashMap.put(lowerCase2, lowerCase2);
                    }
                } else if (lowerCase2.equals("v1")) {
                    linkedHashMap.put(lowerCase2, lowerCase2);
                }
            }
        }
        Iterator it2 = list.iterator();
        boolean z3 = true;
        int i = 1;
        while (it2.hasNext()) {
            String str3 = ((TTMLParser$ParsedLine) it2.next()).agent;
            if (str3 != null) {
                String lowerCase3 = str3.toLowerCase(Locale.ROOT);
                lowerCase3.getClass();
                if (!linkedHashMap.containsKey(lowerCase3)) {
                    while (i <= 2) {
                        if (!linkedHashMap.containsKey("v" + i)) {
                            if (!linkedHashMap.values().contains("v" + i)) {
                                break;
                            }
                        }
                        i++;
                    }
                    linkedHashMap.put(lowerCase3, i <= 2 ? IntIntPair$$ExternalSyntheticOutline0.m(i, "v") : "v1");
                }
            }
        }
        if (linkedHashMap.containsKey("v1000") && linkedHashMap.containsKey("v1")) {
            linkedHashMap.put("v1000", "v2");
        }
        if (list.isEmpty()) {
            z = false;
            break;
        }
        Iterator it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z = false;
                break;
            }
            if (((TTMLParser$ParsedLine) it3.next()).isBackground) {
                z = true;
                break;
            }
        }
        boolean z4 = linkedHashMap.size() > 1 || (linkedHashMap.size() == 1 && !linkedHashMap.containsKey("v1")) || (z && linkedHashMap.size() == 1 && linkedHashMap.containsKey("v1"));
        StringBuilder sb = new StringBuilder(list.size() * 128);
        Iterator it4 = list.iterator();
        boolean z5 = false;
        while (it4.hasNext()) {
            TTMLParser$ParsedLine tTMLParser$ParsedLine = (TTMLParser$ParsedLine) it4.next();
            double d = tTMLParser$ParsedLine.startTime;
            List list2 = tTMLParser$ParsedLine.words;
            String lrcTime = formatLrcTime(d);
            boolean z6 = tTMLParser$ParsedLine.isBackground;
            if (!z6) {
                z5 = false;
            }
            String str4 = tTMLParser$ParsedLine.agent;
            if (str4 != null) {
                lowerCase = str4.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            String str5 = (String) linkedHashMap.get(lowerCase);
            if (z6) {
                z2 = z3;
                strM = z5 ? "" : "{bg}";
            } else if (!z4 || str5 == null) {
                z2 = z3;
            } else {
                z2 = z3;
                strM = IntIntPair$$ExternalSyntheticOutline0.m("{agent:", str5, "}");
            }
            if (z6) {
                z5 = z2;
            }
            sb.append(lrcTime);
            sb.append(strM);
            sb.append(tTMLParser$ParsedLine.text);
            sb.append('\n');
            String str6 = ">\n";
            if (list2.isEmpty()) {
                th = null;
            } else {
                sb.append('<');
                th = null;
                int i2 = 0;
                for (Object obj : list2) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    TTMLParser$ParsedWord tTMLParser$ParsedWord = (TTMLParser$ParsedWord) obj;
                    sb.append(tTMLParser$ParsedWord.text);
                    sb.append(':');
                    int i4 = i2;
                    sb.append(tTMLParser$ParsedWord.startTime);
                    sb.append(':');
                    sb.append(tTMLParser$ParsedWord.endTime);
                    if (i4 < list2.size() - 1) {
                        sb.append('|');
                    }
                    i2 = i3;
                }
                sb.append(">\n");
            }
            for (TTMLParser$ParsedLine tTMLParser$ParsedLine2 : tTMLParser$ParsedLine.backgroundLines) {
                String str7 = z5 ? "" : "{bg}";
                double d2 = tTMLParser$ParsedLine2.startTime;
                List list3 = tTMLParser$ParsedLine2.words;
                sb.append(formatLrcTime(d2));
                sb.append(str7);
                sb.append(tTMLParser$ParsedLine2.text);
                sb.append('\n');
                if (list3.isEmpty()) {
                    str = str6;
                } else {
                    sb.append('<');
                    int i5 = 0;
                    for (Object obj2 : list3) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw th;
                        }
                        TTMLParser$ParsedWord tTMLParser$ParsedWord2 = (TTMLParser$ParsedWord) obj2;
                        sb.append(tTMLParser$ParsedWord2.text);
                        sb.append(':');
                        String str8 = str6;
                        sb.append(tTMLParser$ParsedWord2.startTime);
                        sb.append(':');
                        sb.append(tTMLParser$ParsedWord2.endTime);
                        if (i5 < list3.size() - 1) {
                            sb.append('|');
                        }
                        str6 = str8;
                        i5 = i6;
                    }
                    str = str6;
                    sb.append(str);
                }
                str6 = str;
                z5 = z2;
            }
            z3 = z2;
        }
        return sb.toString();
    }

    public static String trimIndent(String str) throws IOException {
        Comparable comparable;
        List listLines = StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!CharsKt.isWhitespace(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listLines.size();
        int size2 = listLines.size() - 1;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listLines) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str3 = (String) obj3;
            String strDrop = ((i == 0 || i == size2) && StringsKt.isBlank(str3)) ? null : StringsKt.drop(iIntValue, str3);
            if (strDrop != null) {
                arrayList3.add(strDrop);
            }
            i = i3;
        }
        StringBuilder sb = new StringBuilder(length3);
        CollectionsKt.joinTo$default(arrayList3, sb, "\n", null, 124);
        return sb.toString();
    }

    public static String trimMargin$default(String str) throws IOException {
        if (StringsKt.isBlank("|")) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("marginPrefix must be non-blank string.");
            return null;
        }
        List listLines = StringsKt.lines(str);
        int length = str.length();
        listLines.size();
        int size = listLines.size() - 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listLines) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) obj;
            if ((i == 0 || i == size) && StringsKt.isBlank(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!CharsKt.isWhitespace(str2.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                String strSubstring = (i3 != -1 && StringsKt__StringsJVMKt.startsWith(i3, str2, "|", false)) ? str2.substring("|".length() + i3) : null;
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        CollectionsKt.joinTo$default(arrayList, sb, "\n", null, 124);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    public static Integer tryParse(String str) {
        byte b;
        Long lValueOf;
        byte b2;
        str.getClass();
        if (!str.isEmpty()) {
            int i = str.charAt(0) == '-' ? 1 : 0;
            if (i != str.length()) {
                int i2 = i + 1;
                char cCharAt = str.charAt(i);
                if (cCharAt < 128) {
                    b = Longs$AsciiDigits.asciiDigits[cCharAt];
                } else {
                    byte[] bArr = Longs$AsciiDigits.asciiDigits;
                    b = -1;
                }
                if (b >= 0 && b < 10) {
                    long j = -b;
                    while (true) {
                        if (i2 >= str.length()) {
                            if (i == 0) {
                                if (j != Long.MIN_VALUE) {
                                    lValueOf = Long.valueOf(-j);
                                    break;
                                }
                                break;
                            }
                            lValueOf = Long.valueOf(j);
                            break;
                        }
                        int i3 = i2 + 1;
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 < 128) {
                            b2 = Longs$AsciiDigits.asciiDigits[cCharAt2];
                        } else {
                            byte[] bArr2 = Longs$AsciiDigits.asciiDigits;
                            b2 = -1;
                        }
                        if (b2 >= 0 && b2 < 10 && j >= -922337203685477580L) {
                            long j2 = j * 10;
                            long j3 = b2;
                            if (j2 >= Long.MIN_VALUE + j3) {
                                j = j2 - j3;
                                i2 = i3;
                            }
                        }
                        lValueOf = null;
                        break;
                    }
                }
                lValueOf = null;
                break;
            }
            lValueOf = null;
            break;
        }
        lValueOf = null;
        break;
        if (lValueOf == null || lValueOf.longValue() != lValueOf.intValue()) {
            return null;
        }
        return Integer.valueOf(lValueOf.intValue());
    }

    public static final Url validatedPlayerScriptUrl(String str) {
        str.getClass();
        Url Url = URLUtilsKt.Url(str);
        boolean z = Intrinsics.areEqual(Url.getHost(), "youtube.com") || StringsKt__StringsJVMKt.endsWith(Url.getHost(), ".youtube.com", false) || Intrinsics.areEqual(Url.getHost(), "youtube-nocookie.com") || StringsKt__StringsJVMKt.endsWith(Url.getHost(), ".youtube-nocookie.com", false);
        if (Intrinsics.areEqual(Url.getProtocol().getName(), "https") && z && StringsKt__StringsJVMKt.startsWith(Url.getEncodedPath(), "/s/player/", false) && StringsKt__StringsJVMKt.endsWith(Url.getEncodedPath(), ".js", false)) {
            return Url;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player script URL must use an approved YouTube HTTPS endpoint");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x036a  */
    /* JADX WARN: Code duplicated, block: B:157:0x036e  */
    /* JADX WARN: Code duplicated, block: B:162:0x0374 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0125, code lost:
    
        if (r0.equals("x-roman") == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void walk(Element element, ArrayList arrayList, double d, String str) throws IOException {
        List listListOf;
        boolean z;
        double d2;
        char c;
        TTMLParser$ParsedLine tTMLParser$ParsedLine;
        String string;
        String str2;
        String attr;
        Node firstChild;
        String localName = element.getLocalName();
        if (localName == null) {
            String nodeName = element.getNodeName();
            nodeName.getClass();
            localName = StringsKt.substringAfterLast(':', nodeName, nodeName);
        }
        if (localName.equals("div")) {
            attr = getAttr(element, "agent");
            if (attr.length() <= 0) {
            }
            for (firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild instanceof Element) {
                    walk((Element) firstChild, arrayList, d, attr);
                }
            }
        }
        if (localName.equals("p")) {
            String str3 = "begin";
            String attribute = element.getAttribute("begin");
            attribute.getClass();
            if (attribute.length() == 0) {
                attribute = element.getAttributeNS("http://www.w3.org/ns/ttml#parameter", "begin");
            }
            attribute.getClass();
            if (attribute.length() == 0) {
                String str4 = null;
                double d3 = Double.POSITIVE_INFINITY;
                for (Node firstChild2 = element.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                    if (firstChild2 instanceof Element) {
                        Element element2 = (Element) firstChild2;
                        String localName2 = element2.getLocalName();
                        if (localName2 == null) {
                            String nodeName2 = element2.getNodeName();
                            nodeName2.getClass();
                            localName2 = StringsKt.substringAfterLast(':', nodeName2, nodeName2);
                        }
                        if (localName2.equals("span")) {
                            String strTimingAttr = timingAttr(element2, "begin");
                            if (strTimingAttr.length() > 0) {
                                double time = parseTime(strTimingAttr);
                                if (time < d3) {
                                    str4 = strTimingAttr;
                                    d3 = time;
                                }
                            }
                        }
                    }
                }
                if (str4 == null) {
                    return;
                } else {
                    attribute = str4;
                }
            }
            double time2 = parseTime(attribute) + d;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            String attr2 = getAttr(element, "agent");
            if (attr2.length() == 0) {
                attr2 = str;
            }
            String str5 = "x-bg";
            boolean zEquals = getAttr(element, "role").equals("x-bg");
            Node firstChild3 = element.getFirstChild();
            while (true) {
                listListOf = EmptyList.INSTANCE;
                boolean z2 = false;
                if (firstChild3 == null) {
                    break;
                }
                if (firstChild3 instanceof Element) {
                    Element element3 = (Element) firstChild3;
                    String localName3 = element3.getLocalName();
                    if (localName3 == null) {
                        String nodeName3 = element3.getNodeName();
                        nodeName3.getClass();
                        localName3 = StringsKt.substringAfterLast(':', nodeName3, nodeName3);
                    }
                    if (localName3.equals("span")) {
                        String attr3 = getAttr(element3, "role");
                        int iHashCode = attr3.hashCode();
                        z = zEquals;
                        d2 = time2;
                        if (iHashCode == -1175514916) {
                            str3 = str3;
                            str5 = str5;
                            c = ':';
                            if (!attr3.equals("x-translation")) {
                                parseWordSpan(element3, d, arrayList2, firstChild3);
                            }
                        } else if (iHashCode != 3621306) {
                            if (iHashCode == 523267176) {
                            }
                            str3 = str3;
                            str5 = str5;
                            c = ':';
                            parseWordSpan(element3, d, arrayList2, firstChild3);
                        } else if (!attr3.equals(str5)) {
                            str3 = str3;
                            str5 = str5;
                            c = ':';
                            parseWordSpan(element3, d, arrayList2, firstChild3);
                        } else if (z) {
                            parseWordSpan(element3, d, arrayList2, firstChild3);
                            str3 = str3;
                            c = ':';
                        } else {
                            String strTimingAttr2 = timingAttr(element3, str3);
                            double time3 = strTimingAttr2.length() > 0 ? parseTime(strTimingAttr2) + d : d2;
                            ArrayList arrayList4 = new ArrayList();
                            Node firstChild4 = element3.getFirstChild();
                            while (firstChild4 != null) {
                                if (firstChild4 instanceof Element) {
                                    Element element4 = (Element) firstChild4;
                                    String localName4 = element4.getLocalName();
                                    str2 = str3;
                                    if (localName4 == null) {
                                        String nodeName4 = element4.getNodeName();
                                        nodeName4.getClass();
                                        localName4 = StringsKt.substringAfterLast(':', nodeName4, nodeName4);
                                    }
                                    if (localName4.equals("span")) {
                                        String attr4 = getAttr(element4, "role");
                                        if (!attr4.equals("x-translation") && !attr4.equals("x-roman")) {
                                            parseWordSpan(element4, d, arrayList4, firstChild4);
                                        }
                                        z2 = true;
                                    }
                                } else {
                                    str2 = str3;
                                    str5 = str5;
                                }
                                firstChild4 = firstChild4.getNextSibling();
                                str3 = str2;
                                str5 = str5;
                            }
                            str3 = str3;
                            str5 = str5;
                            c = ':';
                            if (z2) {
                                List listMergeSpansIntoWords = mergeSpansIntoWords(arrayList4);
                                tTMLParser$ParsedLine = new TTMLParser$ParsedLine(listMergeSpansIntoWords.isEmpty() ? StringsKt.trim(getDirectText(element3)).toString() : buildLineText(listMergeSpansIntoWords), time3, listMergeSpansIntoWords, null, true, EmptyList.INSTANCE);
                            } else {
                                String textContent = element3.getTextContent();
                                if (textContent == null || (string = StringsKt.trim(textContent).toString()) == null) {
                                    string = "";
                                }
                                tTMLParser$ParsedLine = new TTMLParser$ParsedLine(string, time3, listListOf, null, true, listListOf);
                            }
                            arrayList3.add(tTMLParser$ParsedLine);
                        }
                    }
                    firstChild3 = firstChild3.getNextSibling();
                    attr2 = attr2;
                    zEquals = z;
                    time2 = d2;
                    str3 = str3;
                    str5 = str5;
                } else {
                    attr2 = attr2;
                }
                z = zEquals;
                d2 = time2;
                c = ':';
                firstChild3 = firstChild3.getNextSibling();
                attr2 = attr2;
                zEquals = z;
                time2 = d2;
                str3 = str3;
                str5 = str5;
            }
            String str6 = attr2;
            boolean z3 = zEquals;
            double d4 = time2;
            List listMergeSpansIntoWords2 = mergeSpansIntoWords(arrayList2);
            String string2 = listMergeSpansIntoWords2.isEmpty() ? StringsKt.trim(getDirectText(element)).toString() : buildLineText(listMergeSpansIntoWords2);
            if (string2.length() > 0) {
                if (!arrayList3.isEmpty()) {
                    String strJoinToString$default = CollectionsKt.joinToString$default(arrayList3, ServerSentEventKt.SPACE, null, null, new DatabaseDao$$ExternalSyntheticLambda0((byte) 6), 30);
                    Iterator it = arrayList3.iterator();
                    if (!it.hasNext()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                        return;
                    }
                    double dMin = ((TTMLParser$ParsedLine) it.next()).startTime;
                    while (it.hasNext()) {
                        dMin = Math.min(dMin, ((TTMLParser$ParsedLine) it.next()).startTime);
                    }
                    ArrayList arrayList5 = new ArrayList();
                    int size = arrayList3.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList3.get(i);
                        i++;
                        CollectionsKt__MutableCollectionsKt.addAll(((TTMLParser$ParsedLine) obj).words, arrayList5);
                    }
                    listListOf = CollectionsKt__IterablesKt.listOf(new TTMLParser$ParsedLine(strJoinToString$default, dMin, arrayList5, null, true, listListOf));
                }
                arrayList.add(new TTMLParser$ParsedLine(string2, d4, listMergeSpansIntoWords2, str6, z3, listListOf));
                return;
            }
            if (arrayList3.isEmpty()) {
                return;
            }
            String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList3, ServerSentEventKt.SPACE, null, null, new DatabaseDao$$ExternalSyntheticLambda0((byte) 7), 30);
            Iterator it2 = arrayList3.iterator();
            if (!it2.hasNext()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return;
            }
            double dMin2 = ((TTMLParser$ParsedLine) it2.next()).startTime;
            while (it2.hasNext()) {
                dMin2 = Math.min(dMin2, ((TTMLParser$ParsedLine) it2.next()).startTime);
            }
            ArrayList arrayList6 = new ArrayList();
            int size2 = arrayList3.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList3.get(i2);
                i2++;
                CollectionsKt__MutableCollectionsKt.addAll(((TTMLParser$ParsedLine) obj2).words, arrayList6);
            }
            arrayList.add(new TTMLParser$ParsedLine(strJoinToString$default2, dMin2, arrayList6, null, true, listListOf));
            return;
        }
        attr = str;
        while (firstChild != null) {
            if (firstChild instanceof Element) {
                walk((Element) firstChild, arrayList, d, attr);
            }
        }
    }

    public abstract void complete(IOException iOException);

    public static CoroutineContext.Element get(CoroutineContext.Element element, CoroutineContext.Key key) {
        key.getClass();
        if (Intrinsics.areEqual(element.getKey(), key)) {
            return element;
        }
        return null;
    }

    /* JADX INFO: renamed from: parseTime, reason: collision with other method in class */
    public static final Integer m1883parseTime(String str) {
        List listListOf;
        str.getClass();
        try {
            Pattern patternCompile = Pattern.compile("[:.,]");
            patternCompile.getClass();
            StringsKt.requireNonNegativeLimit(0);
            Matcher matcher = patternCompile.matcher(str);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(str.subSequence(iEnd, str.length()).toString());
                listListOf = arrayList;
            } else {
                listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(Integer.parseInt((String) it.next())));
            }
            if (arrayList2.size() == 2) {
                return Integer.valueOf((((Number) arrayList2.get(0)).intValue() * 60) + ((Number) arrayList2.get(1)).intValue());
            }
            if (arrayList2.size() != 3) {
                return null;
            }
            return Integer.valueOf((((Number) arrayList2.get(1)).intValue() * 60) + (((Number) arrayList2.get(0)).intValue() * 3600) + ((Number) arrayList2.get(2)).intValue());
        } catch (Exception unused) {
            return null;
        }
    }
}
