package kotlin.text;

import android.net.Uri;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.datasource.DataSpec;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.innertubex.cipher.RestrictedHttpFetchKt$getTextWithoutRedirects$1;
import com.metrolist.innertubex.cipher.RestrictedHttpFetchKt$getTextWithoutRedirects$3;
import com.metrolist.innertubex.cipher.RestrictedTextResponse;
import com.metrolist.lrclib.models.Track;
import com.metrolist.music.eq.data.FilterType;
import com.metrolist.music.eq.data.ParametricEQ;
import com.metrolist.music.eq.data.ParametricEQBand;
import com.metrolist.music.playback.CachedStreamUrl;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.LinesSequence;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.guava.JobListenableFuture;
import kotlinx.coroutines.guava.ListenableFutureCoroutine;
import kotlinx.serialization.descriptors.ContextDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.ConnectionPool;
import okhttp3.Cookie;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okio.AsyncTimeout;
import okio.PriorityQueue;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RegexKt {
    public static AsyncTimeout awaitTimeout() throws InterruptedException {
        PriorityQueue priorityQueue = AsyncTimeout.queue;
        AsyncTimeout asyncTimeout = ((AsyncTimeout[]) priorityQueue.array)[1];
        if (asyncTimeout == null) {
            long jNanoTime = System.nanoTime();
            AsyncTimeout.condition.await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            if (((AsyncTimeout[]) priorityQueue.array)[1] != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return AsyncTimeout.idleSentinel;
        }
        long jNanoTime2 = asyncTimeout.timeoutAt - System.nanoTime();
        if (jNanoTime2 > 0) {
            AsyncTimeout.condition.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        priorityQueue.remove(asyncTimeout);
        asyncTimeout.state = (byte) 2;
        return asyncTimeout;
    }

    public static final Track bestMatchingFor(int i, String str, String str2, List list) {
        Object next;
        Locale locale = Locale.ROOT;
        list.getClass();
        Object obj = null;
        if (list.isEmpty()) {
            return null;
        }
        if (i != -1) {
            return bestMatchingForRelaxed(i, list);
        }
        if (str == null || str2 == null) {
            for (Object obj2 : list) {
                if (((Track) obj2).syncedLyrics != null) {
                    obj = obj2;
                    break;
                }
            }
            Track track = (Track) obj;
            return track == null ? (Track) CollectionsKt.firstOrNull(list) : track;
        }
        String lowerCase = StringsKt.trim(str).toString().toLowerCase(locale);
        lowerCase.getClass();
        String lowerCase2 = StringsKt.trim(str2).toString().toLowerCase(locale);
        lowerCase2.getClass();
        Iterator it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Track track2 = (Track) next;
                String lowerCase3 = StringsKt.trim(track2.trackName).toString().toLowerCase(locale);
                lowerCase3.getClass();
                double dCalculateSimilarity = calculateSimilarity(lowerCase, lowerCase3);
                String lowerCase4 = StringsKt.trim(track2.artistName).toString().toLowerCase(locale);
                lowerCase4.getClass();
                double dCalculateSimilarity2 = (calculateSimilarity(lowerCase2, lowerCase4) + dCalculateSimilarity) / 2.0d;
                if (track2.syncedLyrics != null) {
                    dCalculateSimilarity2 += 0.1d;
                }
                do {
                    Object next2 = it.next();
                    Track track3 = (Track) next2;
                    String string = StringsKt.trim(track3.trackName).toString();
                    Locale locale2 = Locale.ROOT;
                    String lowerCase5 = string.toLowerCase(locale2);
                    lowerCase5.getClass();
                    double dCalculateSimilarity3 = calculateSimilarity(lowerCase, lowerCase5);
                    String lowerCase6 = StringsKt.trim(track3.artistName).toString().toLowerCase(locale2);
                    lowerCase6.getClass();
                    double dCalculateSimilarity4 = (calculateSimilarity(lowerCase2, lowerCase6) + dCalculateSimilarity3) / 2.0d;
                    if (track3.syncedLyrics != null) {
                        dCalculateSimilarity4 += 0.1d;
                    }
                    if (Double.compare(dCalculateSimilarity2, dCalculateSimilarity4) < 0) {
                        next = next2;
                        dCalculateSimilarity2 = dCalculateSimilarity4;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Track track4 = (Track) next;
        if (track4 != null) {
            String lowerCase7 = StringsKt.trim(track4.trackName).toString().toLowerCase(locale);
            lowerCase7.getClass();
            double dCalculateSimilarity5 = calculateSimilarity(lowerCase, lowerCase7);
            String lowerCase8 = StringsKt.trim(track4.artistName).toString().toLowerCase(locale);
            lowerCase8.getClass();
            if ((calculateSimilarity(lowerCase2, lowerCase8) + dCalculateSimilarity5) / 2.0d > 0.6d) {
                return track4;
            }
        }
        return null;
    }

    public static final Track bestMatchingForRelaxed(int i, List list) {
        Object next;
        Object next2;
        list.getClass();
        Object obj = null;
        if (list.isEmpty()) {
            return null;
        }
        if (i == -1) {
            for (Object obj2 : list) {
                if (((Track) obj2).syncedLyrics != null) {
                    obj = obj2;
                    break;
                }
            }
            Track track = (Track) obj;
            return track == null ? (Track) CollectionsKt.firstOrNull(list) : track;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            if (((Track) obj3).syncedLyrics != null) {
                arrayList.add(obj3);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int iAbs = Math.abs(((int) ((Track) next).duration) - i);
                do {
                    Object next3 = it.next();
                    int iAbs2 = Math.abs(((int) ((Track) next3).duration) - i);
                    if (iAbs > iAbs2) {
                        next = next3;
                        iAbs = iAbs2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Track track2 = (Track) next;
        if (track2 == null || Math.abs(((int) track2.duration) - i) > 5) {
            track2 = null;
        }
        if (track2 != null) {
            return track2;
        }
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                int iAbs3 = Math.abs(((int) ((Track) next2).duration) - i);
                do {
                    Object next4 = it2.next();
                    int iAbs4 = Math.abs(((int) ((Track) next4).duration) - i);
                    if (iAbs3 > iAbs4) {
                        next2 = next4;
                        iAbs3 = iAbs4;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        Track track3 = (Track) next2;
        if (track3 == null || Math.abs(((int) track3.duration) - i) > 5) {
            return null;
        }
        return track3;
    }

    public static final double calculateSimilarity(String str, String str2) {
        double d;
        int i;
        double d2 = 1.0d;
        if (str.equals(str2)) {
            return 1.0d;
        }
        if (str.length() == 0 || str2.length() == 0) {
            return 0.0d;
        }
        double d3 = (StringsKt.contains(str, str2, false) || StringsKt.contains(str2, str, false)) ? 0.8d : 0.0d;
        int iMax = Math.max(str.length(), str2.length());
        int length = str.length();
        int length2 = str2.length();
        int i2 = length + 1;
        int[][] iArr = new int[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = new int[length2 + 1];
        }
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                iArr[i4][0] = i4;
                if (i4 == length) {
                    break;
                }
                i4++;
            }
        }
        if (length2 >= 0) {
            int i5 = 0;
            while (true) {
                iArr[0][i5] = i5;
                if (i5 == length2) {
                    break;
                }
                i5++;
            }
        }
        int i6 = 1;
        if (1 <= length) {
            int i7 = 1;
            while (true) {
                if (i6 <= length2) {
                    int i8 = i6;
                    while (true) {
                        int i9 = i7 - 1;
                        int i10 = i8 - 1;
                        d = d2;
                        int i11 = str.charAt(i9) == str2.charAt(i10) ? 0 : i6;
                        int[] iArr2 = iArr[i7];
                        int[] iArr3 = iArr[i9];
                        i = i6;
                        iArr2[i8] = Math.min(iArr3[i8] + i6, Math.min(iArr2[i10] + 1, iArr3[i10] + i11));
                        if (i8 == length2) {
                            break;
                        }
                        i8++;
                        d2 = d;
                        i6 = i;
                    }
                } else {
                    d = d2;
                    i = i6;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                d2 = d;
                i6 = i;
            }
        } else {
            d = 1.0d;
        }
        return Math.max(d3, d - (((double) iArr[length][length2]) / ((double) iMax)));
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void collectAccountItems(JsonElement jsonElement, ArrayList arrayList) {
        String contentOrNull;
        Boolean booleanOrNull;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        if (jsonElement == 0) {
            return;
        }
        if (!(jsonElement instanceof JsonObject)) {
            if (jsonElement instanceof JsonArray) {
                Iterator it = ((Iterable) jsonElement).iterator();
                while (it.hasNext()) {
                    collectAccountItems((JsonElement) it.next(), arrayList);
                }
                return;
            }
            return;
        }
        JsonObject jsonObject = (JsonObject) jsonElement;
        JsonElement jsonElement4 = (JsonElement) jsonObject.get("accountItem");
        if (jsonElement4 == null) {
            jsonElement4 = (JsonElement) jsonObject.get("accountItemRenderer");
        }
        Object youTubeAccount = null;
        JsonObject jsonObject2 = jsonElement4 instanceof JsonObject ? (JsonObject) jsonElement4 : null;
        if (jsonObject2 != null) {
            String strTextFromRuns = textFromRuns(jsonObject2, "accountName");
            if (strTextFromRuns != null) {
                JsonObject jsonObjectFindObject = findObject(jsonObject2);
                String strTextFromRuns2 = textFromRuns(jsonObject2, "accountByline");
                String strTextFromRuns3 = textFromRuns(jsonObject2, "channelHandle");
                Object obj = jsonObject2.get("accountPhoto");
                JsonObject jsonObject3 = obj instanceof JsonObject ? (JsonObject) obj : null;
                JsonElement jsonElement5 = jsonObject3 != null ? (JsonElement) jsonObject3.get("thumbnails") : null;
                JsonArray jsonArray = jsonElement5 instanceof JsonArray ? (JsonArray) jsonElement5 : null;
                if (jsonArray == null || (jsonElement2 = (JsonElement) CollectionsKt.lastOrNull(jsonArray)) == null) {
                    contentOrNull = null;
                } else {
                    JsonObject jsonObject4 = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
                    if (jsonObject4 == null || (jsonElement3 = (JsonElement) jsonObject4.get("url")) == null) {
                        contentOrNull = null;
                    } else {
                        JsonPrimitive jsonPrimitive = jsonElement3 instanceof JsonPrimitive ? (JsonPrimitive) jsonElement3 : null;
                        if (jsonPrimitive != null) {
                            contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive);
                        } else {
                            contentOrNull = null;
                        }
                    }
                }
                Object obj2 = jsonObject2.get("isSelected");
                JsonPrimitive jsonPrimitive2 = obj2 instanceof JsonPrimitive ? (JsonPrimitive) obj2 : null;
                youTubeAccount = new YouTubeAccount(strTextFromRuns, strTextFromRuns2, strTextFromRuns3, contentOrNull, (jsonPrimitive2 == null || (booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive2)) == null) ? false : booleanOrNull.booleanValue(), jsonObjectFindObject != null ? tokenValue(jsonObjectFindObject, "accountSigninToken", "signinUrl") : null, jsonObjectFindObject != null ? tokenValue(jsonObjectFindObject, "pageIdToken", "pageId") : null, jsonObjectFindObject != null ? tokenValue(jsonObjectFindObject, "datasyncIdToken", "datasyncIdToken") : null);
            }
            if (youTubeAccount != null) {
                arrayList.add(youTubeAccount);
            }
        }
        Iterator it2 = jsonObject.content.values().iterator();
        while (it2.hasNext()) {
            collectAccountItems((JsonElement) it2.next(), arrayList);
        }
    }

    public static ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0 compareBy(Function1... function1Arr) {
        if (function1Arr.length > 0) {
            return new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0((byte) 0, function1Arr);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
        return null;
    }

    public static int compareValues(Comparable comparable, Comparable comparable2) {
        if (comparable == null) {
            return comparable2 == null ? 0 : -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final ArrayList extractYouTubeAccounts(JsonElement jsonElement) {
        jsonElement.getClass();
        ArrayList arrayList = new ArrayList();
        collectAccountItems(jsonElement, arrayList);
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            YouTubeAccount youTubeAccount = (YouTubeAccount) obj;
            String str = youTubeAccount.pageId;
            if (str == null && (str = youTubeAccount.dataSyncId) == null && (str = youTubeAccount.signinUrl) == null && (str = youTubeAccount.channelHandle) == null) {
                str = youTubeAccount.name;
            }
            if (hashSet.add(str)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final MatcherMatchResult findNext(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final JsonObject findObject(JsonElement jsonElement) {
        if (jsonElement != 0) {
            if (jsonElement instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) jsonElement;
                Object obj = jsonObject.get("selectActiveIdentityEndpoint");
                JsonObject jsonObjectFindObject = obj instanceof JsonObject ? (JsonObject) obj : null;
                if (jsonObjectFindObject == null) {
                    Iterator it = jsonObject.content.values().iterator();
                    while (it.hasNext()) {
                        jsonObjectFindObject = findObject((JsonElement) it.next());
                        if (jsonObjectFindObject != null) {
                        }
                    }
                }
                return jsonObjectFindObject;
            }
            if (jsonElement instanceof JsonArray) {
                Iterator it2 = ((Iterable) jsonElement).iterator();
                while (it2.hasNext()) {
                    JsonObject jsonObjectFindObject2 = findObject((JsonElement) it2.next());
                    if (jsonObjectFindObject2 != null) {
                        return jsonObjectFindObject2;
                    }
                }
            }
        }
        return null;
    }

    public static Hct fixIfDisliked(Hct hct) {
        hct.getClass();
        double dRint = Math.rint(hct.hue);
        return (((90.0d > dRint ? 1 : (90.0d == dRint ? 0 : -1)) <= 0 && (dRint > 111.0d ? 1 : (dRint == 111.0d ? 0 : -1)) <= 0) && ((Math.rint(hct.chroma) > 16.0d ? 1 : (Math.rint(hct.chroma) == 16.0d ? 0 : -1)) > 0) && (Math.rint(hct.tone) < 65.0d)) ? new Hct(HctSolver.solveToInt(hct.hue, hct.chroma, 70.0d)) : hct;
    }

    public static final void forEachLine(BufferedReader bufferedReader, Function1 function1) throws IOException {
        try {
            Iterator it = ((ConstrainedOnceSequence) SequencesKt.constrainOnce(new LinesSequence((byte) 0, bufferedReader))).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            bufferedReader.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static final String formatDuration(long j) {
        String strM;
        if (j <= -999500000) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), (j - 500000000) / 1000000000, " s ");
        } else if (j <= -999500) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), (j - 500000) / 1000000, " ms");
        } else if (j <= 0) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), (j - 500) / 1000, " µs");
        } else if (j < 999500) {
            strM = IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), (j + 500) / 1000, " µs");
        } else {
            strM = j < 999500000 ? IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), (j + 500000) / 1000000, " ms") : IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), (j + 500000000) / 1000000000, " s ");
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{strM}, 1));
    }

    public static JobListenableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        ListenableFutureCoroutine listenableFutureCoroutine = new ListenableFutureCoroutine(AwaitKt.newCoroutineContext(coroutineScope, coroutineContext));
        listenableFutureCoroutine.start(CoroutineStart.DEFAULT, listenableFutureCoroutine, function2);
        return listenableFutureCoroutine.future;
    }

    public static final KClass getCapturedKClass(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).kClass;
        }
        if (serialDescriptor instanceof SerialDescriptorForNullable) {
            return getCapturedKClass(((SerialDescriptorForNullable) serialDescriptor).original);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object getTextWithoutRedirects(HttpClient httpClient, Url url, int i, Function2 function2, Function1 function1, ContinuationImpl continuationImpl) throws Exception {
        RestrictedHttpFetchKt$getTextWithoutRedirects$1 restrictedHttpFetchKt$getTextWithoutRedirects$1;
        if (continuationImpl instanceof RestrictedHttpFetchKt$getTextWithoutRedirects$1) {
            restrictedHttpFetchKt$getTextWithoutRedirects$1 = (RestrictedHttpFetchKt$getTextWithoutRedirects$1) continuationImpl;
            int i2 = restrictedHttpFetchKt$getTextWithoutRedirects$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                restrictedHttpFetchKt$getTextWithoutRedirects$1.label = i2 - Integer.MIN_VALUE;
            } else {
                restrictedHttpFetchKt$getTextWithoutRedirects$1 = new RestrictedHttpFetchKt$getTextWithoutRedirects$1(continuationImpl);
            }
        } else {
            restrictedHttpFetchKt$getTextWithoutRedirects$1 = new RestrictedHttpFetchKt$getTextWithoutRedirects$1(continuationImpl);
        }
        Object objExecute = restrictedHttpFetchKt$getTextWithoutRedirects$1.result;
        int i3 = restrictedHttpFetchKt$getTextWithoutRedirects$1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objExecute);
                httpClient = HttpClientKt.HttpClient(httpClient.getEngine(), new YouTube$$ExternalSyntheticLambda2((byte) 18));
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
                function1.invoke(httpRequestBuilder);
                httpRequestBuilder.setMethod(HttpMethod.Get);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                RestrictedHttpFetchKt$getTextWithoutRedirects$3 restrictedHttpFetchKt$getTextWithoutRedirects$3 = new RestrictedHttpFetchKt$getTextWithoutRedirects$3(i, function2, null);
                restrictedHttpFetchKt$getTextWithoutRedirects$1.L$4 = httpClient;
                restrictedHttpFetchKt$getTextWithoutRedirects$1.label = 1;
                objExecute = httpStatement.execute(restrictedHttpFetchKt$getTextWithoutRedirects$3, restrictedHttpFetchKt$getTextWithoutRedirects$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                httpClient = restrictedHttpFetchKt$getTextWithoutRedirects$1.L$4;
                ResultKt.throwOnFailure(objExecute);
            }
            RestrictedTextResponse restrictedTextResponse = (RestrictedTextResponse) objExecute;
            httpClient.close();
            return restrictedTextResponse;
        } catch (Throwable th) {
            httpClient.close();
            throw th;
        }
    }

    public static void insertIntoQueue(AsyncTimeout asyncTimeout) {
        if (AsyncTimeout.idleSentinel == null) {
            AsyncTimeout.idleSentinel = new AsyncTimeout();
            AsyncTimeout.Watchdog watchdog = new AsyncTimeout.Watchdog("Okio Watchdog");
            watchdog.setDaemon(true);
            watchdog.start();
        }
        long jNanoTime = System.nanoTime();
        long j = asyncTimeout.timeoutNanos;
        boolean z = asyncTimeout.hasDeadline;
        if (j != 0 && z) {
            asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            asyncTimeout.timeoutAt = jNanoTime + j;
        } else {
            if (!z) {
                throw new AssertionError();
            }
            asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
        }
        PriorityQueue priorityQueue = AsyncTimeout.queue;
        int i = priorityQueue.size + 1;
        priorityQueue.size = i;
        AsyncTimeout[] asyncTimeoutArr = (AsyncTimeout[]) priorityQueue.array;
        if (i == asyncTimeoutArr.length) {
            AsyncTimeout[] asyncTimeoutArr2 = new AsyncTimeout[i * 2];
            ArraysKt.copyInto$default(0, 0, 14, asyncTimeoutArr, asyncTimeoutArr2);
            priorityQueue.array = asyncTimeoutArr2;
        }
        priorityQueue.heapifyUp(i, asyncTimeout);
        if (asyncTimeout.index == 1) {
            AsyncTimeout.condition.signal();
        }
    }

    public static final void log(Logger logger, Task task, TaskQueue taskQueue, String str) {
        logger.fine(taskQueue.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.name);
    }

    public static int maxOf(int i, int... iArr) {
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x009a  */
    public static long parseExpires(int i, String str) {
        int iDateCharacterOffset = dateCharacterOffset(str, 0, i, false);
        Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int iIndexOf$default = -1;
        int i5 = -1;
        int i6 = -1;
        while (iDateCharacterOffset < i) {
            int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i, true);
            matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
            if (i3 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                String strGroup = matcher.group(1);
                strGroup.getClass();
                i3 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                strGroup2.getClass();
                i5 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                strGroup3.getClass();
                i6 = Integer.parseInt(strGroup3);
            } else if (i4 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                String strGroup4 = matcher.group(1);
                strGroup4.getClass();
                i4 = Integer.parseInt(strGroup4);
            } else if (iIndexOf$default == -1) {
                Pattern pattern = Cookie.MONTH_PATTERN;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    strGroup5.getClass();
                    Locale locale = Locale.US;
                    locale.getClass();
                    String lowerCase = strGroup5.toLowerCase(locale);
                    lowerCase.getClass();
                    String strPattern = pattern.pattern();
                    strPattern.getClass();
                    iIndexOf$default = StringsKt.indexOf$default(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i2 != -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    strGroup6.getClass();
                    i2 = Integer.parseInt(strGroup6);
                }
            } else if (i2 != -1) {
            }
            iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i, false);
        }
        if (70 <= i2 && i2 < 100) {
            i2 += 1900;
        }
        if (i2 >= 0 && i2 < 70) {
            i2 += 2000;
        }
        if (i2 < 1601) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0L;
        }
        if (iIndexOf$default == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0L;
        }
        if (1 > i4 || i4 >= 32) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0L;
        }
        if (i3 < 0 || i3 >= 24) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0L;
        }
        if (i5 < 0 || i5 >= 60) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0L;
        }
        if (i6 < 0 || i6 >= 60) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0L;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i2);
        gregorianCalendar.set(2, iIndexOf$default - 1);
        gregorianCalendar.set(5, i4);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i5);
        gregorianCalendar.set(13, i6);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public static FilterType parseFilterType(String str) {
        if (StringsKt.contains(str, "LSC", true)) {
            return FilterType.LSC;
        }
        if (StringsKt.contains(str, "HSC", true)) {
            return FilterType.HSC;
        }
        if (StringsKt.contains(str, "PK", true)) {
            return FilterType.PK;
        }
        if (StringsKt.contains(str, "LPQ", true)) {
            return FilterType.LPQ;
        }
        if (StringsKt.contains(str, "HPQ", true)) {
            return FilterType.HPQ;
        }
        return null;
    }

    public static ParametricEQ parseText(String str) {
        String str2;
        Double doubleOrNull;
        FilterType filterType;
        Double value;
        List listLines = StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = listLines.iterator();
        while (true) {
            double dDoubleValue = 0.0d;
            while (it.hasNext()) {
                String string = StringsKt.trim((String) it.next()).toString();
                if (string.length() != 0) {
                    if (StringsKt__StringsJVMKt.startsWith(string, "Preamp:", true)) {
                        Pattern patternCompile = Pattern.compile("Preamp:\\s*([-+]?\\d+\\.?\\d*)\\s*dB", 66);
                        patternCompile.getClass();
                        Matcher matcher = patternCompile.matcher(string);
                        matcher.getClass();
                        MatcherMatchResult matcherMatchResultFindNext = findNext(matcher, 0, string);
                        if (matcherMatchResultFindNext != null && (str2 = (String) ((ReversedListReadOnly) matcherMatchResultFindNext.getGroupValues()).get(1)) != null && (doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str2)) != null) {
                            dDoubleValue = doubleOrNull.doubleValue();
                        }
                    } else if (StringsKt__StringsJVMKt.startsWith(string, "Filter", true)) {
                        ParametricEQBand parametricEQBand = null;
                        try {
                            if (StringsKt.contains(string, "ON", true) && (filterType = parseFilterType(string)) != null && (value = parseValue(string, "Fc", "Hz")) != null) {
                                double dDoubleValue2 = value.doubleValue();
                                Double value2 = parseValue(string, "Gain", "dB");
                                if (value2 != null) {
                                    double dDoubleValue3 = value2.doubleValue();
                                    Double value3 = parseValue(string, "Q", null);
                                    if (value3 != null) {
                                        parametricEQBand = new ParametricEQBand(dDoubleValue2, dDoubleValue3, value3.doubleValue(), filterType);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            Timber.Forest.tag("ParametricEQParser");
                            ConnectionPool.w$1(string);
                        }
                        if (parametricEQBand != null) {
                            arrayList.add(parametricEQBand);
                        }
                    } else {
                        List listSplit$default = StringsKt.split$default(string, new String[]{ServerSentEventKt.COLON}, 2, 2);
                        if (listSplit$default.size() == 2) {
                            linkedHashMap.put(StringsKt.trim((String) listSplit$default.get(0)).toString(), StringsKt.trim((String) listSplit$default.get(1)).toString());
                        }
                    }
                }
            }
            return new ParametricEQ(dDoubleValue, arrayList, linkedHashMap);
        }
    }

    public static Double parseValue(String str, String str2, String str3) {
        String str4;
        Pattern patternCompile = Pattern.compile(str2 + "\\s+([-+]?\\d+\\.?\\d*)" + (str3 != null ? "\\s*".concat(str3) : ""), 66);
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(str);
        matcher.getClass();
        MatcherMatchResult matcherMatchResultFindNext = findNext(matcher, 0, str);
        if (matcherMatchResultFindNext == null || (str4 = (String) ((ReversedListReadOnly) matcherMatchResultFindNext.getGroupValues()).get(1)) == null) {
            return null;
        }
        return StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str4);
    }

    public static final ArrayList readLines(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        forEachLine(bufferedReader, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 0));
        return arrayList;
    }

    public static final String readText(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i = reader.read(cArr);
        while (i >= 0) {
            stringWriter.write(cArr, 0, i);
            i = reader.read(cArr);
        }
        String string = stringWriter.toString();
        string.getClass();
        return string;
    }

    public static final String textFromRuns(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        String contentOrNull;
        Object obj = jsonObject.get(str);
        JsonObject jsonObject2 = obj instanceof JsonObject ? (JsonObject) obj : null;
        if (jsonObject2 != null) {
            Object obj2 = jsonObject2.get("runs");
            JsonArray jsonArray = obj2 instanceof JsonArray ? (JsonArray) obj2 : null;
            JsonElement jsonElement2 = jsonArray != null ? (JsonElement) CollectionsKt.firstOrNull((List) jsonArray) : null;
            JsonObject jsonObject3 = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
            if (jsonObject3 != null && (jsonElement = (JsonElement) jsonObject3.get(ContentType.Text.TYPE)) != null) {
                JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
                if (jsonPrimitive != null && (contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive)) != null) {
                    return contentOrNull;
                }
            }
            Object obj3 = jsonObject2.get("simpleText");
            JsonPrimitive jsonPrimitive2 = obj3 instanceof JsonPrimitive ? (JsonPrimitive) obj3 : null;
            if (jsonPrimitive2 != null) {
                return JsonElementKt.getContentOrNull(jsonPrimitive2);
            }
        }
        return null;
    }

    public static final String tokenValue(JsonObject jsonObject, String str, String str2) {
        Object obj = jsonObject.get("supportedTokens");
        JsonArray jsonArray = obj instanceof JsonArray ? (JsonArray) obj : null;
        if (jsonArray != null) {
            for (JsonElement jsonElement : jsonArray.content) {
                JsonObject jsonObject2 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
                JsonElement jsonElement2 = jsonObject2 != null ? (JsonElement) jsonObject2.get(str) : null;
                JsonObject jsonObject3 = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
                JsonElement jsonElement3 = jsonObject3 != null ? (JsonElement) jsonObject3.get(str2) : null;
                JsonPrimitive jsonPrimitive = jsonElement3 instanceof JsonPrimitive ? (JsonPrimitive) jsonElement3 : null;
                String contentOrNull = jsonPrimitive != null ? JsonElementKt.getContentOrNull(jsonPrimitive) : null;
                if (contentOrNull != null) {
                    return contentOrNull;
                }
            }
        }
        return null;
    }

    public static ArrayList validate(ParametricEQ parametricEQ) {
        List list = parametricEQ.bands;
        ArrayList arrayList = new ArrayList();
        double d = parametricEQ.preamp;
        if (d < -50.0d || d > 50.0d) {
            arrayList.add("Preamp value " + d + " dB is out of range (-50 to +50 dB)");
        }
        if (list.isEmpty()) {
            arrayList.add("EQ profile must have at least one band");
        }
        if (list.size() > 20) {
            arrayList.add("EQ profile has " + list.size() + " bands, maximum is 20");
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            ParametricEQBand parametricEQBand = (ParametricEQBand) obj;
            double d2 = parametricEQBand.frequency;
            if (d2 <= 0.0d || d2 > 100000.0d) {
                arrayList.add("Band " + i2 + ": Frequency " + d2 + " Hz is out of range (1 to 100000 Hz)");
            }
            double d3 = parametricEQBand.gain;
            if (d3 < -30.0d || d3 > 30.0d) {
                arrayList.add("Band " + i2 + ": Gain " + d3 + " dB is out of range (-30 to +30 dB)");
            }
            double d4 = parametricEQBand.q;
            if (d4 <= 0.0d || d4 > 20.0d) {
                arrayList.add("Band " + i2 + ": Q factor " + d4 + " is out of range (0.01 to 20)");
            }
            i = i2;
        }
        return arrayList;
    }

    public static final DataSpec withResolvedStream(DataSpec dataSpec, CachedStreamUrl cachedStreamUrl) {
        dataSpec.getClass();
        DataSpec dataSpec2 = new DataSpec(Uri.parse(cachedStreamUrl.url), dataSpec.uriPositionOffset, dataSpec.httpMethod, dataSpec.httpBody, dataSpec.httpRequestHeaders, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags);
        Map map = dataSpec.httpRequestHeaders;
        map.getClass();
        DataSpec dataSpec3 = new DataSpec(dataSpec2.uri, dataSpec2.uriPositionOffset, dataSpec2.httpMethod, dataSpec2.httpBody, MapsKt__MapsKt.plus(map, cachedStreamUrl.requestHeaders), dataSpec2.position, dataSpec2.length, dataSpec2.key, dataSpec2.flags);
        if (cachedStreamUrl.requireBoundedRange || cachedStreamUrl.useRangeChunks) {
            long jMin = cachedStreamUrl.rangeChunkSizeBytes;
            if (jMin > 0) {
                long j = dataSpec.length;
                if (j != -1) {
                    jMin = Math.min(j, jMin);
                }
                return dataSpec3.subrange(jMin);
            }
        }
        return dataSpec3;
    }
}
