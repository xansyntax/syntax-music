package com.metrolist.music.utils;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Updater {
    public static ReleaseInfo cachedReleaseInfo;
    public static final Updater INSTANCE = new Updater();
    public static final HttpClient client = HttpClientJvmKt.HttpClient$default(null, 1, null);
    public static long lastCheckTime = -1;
    public static List cachedAllReleases = EmptyList.INSTANCE;

    public static int compareVersions(String str, String str2) {
        List listSplit$default = StringsKt.split$default(StringsKt.removePrefix(str, "v"), new String[]{"."}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull((String) it.next());
            arrayList.add(Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0));
        }
        List listSplit$default2 = StringsKt.split$default(StringsKt.removePrefix(str2, "v"), new String[]{"."}, 0, 6);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default2, 10));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            Integer intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull((String) it2.next());
            arrayList2.add(Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0));
        }
        int iMax = Math.max(arrayList.size(), arrayList2.size());
        for (int i = 0; i < iMax; i++) {
            Integer num = (Integer) CollectionsKt.getOrNull(i, arrayList);
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) CollectionsKt.getOrNull(i, arrayList2);
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue > iIntValue2) {
                return 1;
            }
            if (iIntValue < iIntValue2) {
                return -1;
            }
        }
        return 0;
    }

    public static ArrayList parseAssets(JSONArray jSONArray) throws JSONException {
        Pair pair;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString(ContentDisposition.Parameters.Name);
            string.getClass();
            if (StringsKt__StringsJVMKt.endsWith(string, ".apk", false)) {
                String string2 = jSONObject.getString("browser_download_url");
                long j = jSONObject.getLong(ContentDisposition.Parameters.Size);
                if (string.equals("Metrolist.apk")) {
                    pair = new Pair("universal", "foss");
                } else if (string.equals("Metrolist-with-Google-Cast.apk")) {
                    pair = new Pair("universal", "gms");
                } else if (StringsKt__StringsJVMKt.startsWith(string, "app-", false) && StringsKt__StringsJVMKt.endsWith(string, "-release.apk", false)) {
                    pair = new Pair(StringsKt.removeSuffix(StringsKt.removePrefix(string, "app-"), "-release.apk"), "foss");
                } else {
                    pair = (StringsKt__StringsJVMKt.startsWith(string, "app-", false) && StringsKt__StringsJVMKt.endsWith(string, "-with-Google-Cast.apk", false)) ? new Pair(StringsKt.removeSuffix(StringsKt.removePrefix(string, "app-"), "-with-Google-Cast.apk"), "gms") : new Pair(null, null);
                }
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                if (str != null && str2 != null) {
                    string2.getClass();
                    arrayList.add(new ReleaseAsset(string, string2, j, str, str2));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: checkForUpdate-gIAlu-s, reason: not valid java name */
    public final Object m1523checkForUpdategIAlus(boolean z, ContinuationImpl continuationImpl) {
        Updater$checkForUpdate$1 updater$checkForUpdate$1;
        if (continuationImpl instanceof Updater$checkForUpdate$1) {
            updater$checkForUpdate$1 = (Updater$checkForUpdate$1) continuationImpl;
            int i = updater$checkForUpdate$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                updater$checkForUpdate$1.label = i - Integer.MIN_VALUE;
            } else {
                updater$checkForUpdate$1 = new Updater$checkForUpdate$1(this, continuationImpl);
            }
        } else {
            updater$checkForUpdate$1 = new Updater$checkForUpdate$1(this, continuationImpl);
        }
        Object objWithContext = updater$checkForUpdate$1.result;
        int i2 = updater$checkForUpdate$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            Updater$checkForUpdate$2 updater$checkForUpdate$2 = new Updater$checkForUpdate$2(z, null);
            updater$checkForUpdate$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, updater$checkForUpdate$2, updater$checkForUpdate$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).value;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getAllReleases-gIAlu-s, reason: not valid java name */
    public final Object m1524getAllReleasesgIAlus(ContinuationImpl continuationImpl) {
        Updater$getAllReleases$1 updater$getAllReleases$1;
        if (continuationImpl instanceof Updater$getAllReleases$1) {
            updater$getAllReleases$1 = (Updater$getAllReleases$1) continuationImpl;
            int i = updater$getAllReleases$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                updater$getAllReleases$1.label = i - Integer.MIN_VALUE;
            } else {
                updater$getAllReleases$1 = new Updater$getAllReleases$1(this, continuationImpl);
            }
        } else {
            updater$getAllReleases$1 = new Updater$getAllReleases$1(this, continuationImpl);
        }
        Object objWithContext = updater$getAllReleases$1.result;
        int i2 = updater$getAllReleases$1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            Updater$getAllReleases$2 updater$getAllReleases$2 = new Updater$getAllReleases$2(2, continuation);
            updater$getAllReleases$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, updater$getAllReleases$2, updater$getAllReleases$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).value;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getLatestRelease-gIAlu-s, reason: not valid java name */
    public final Object m1525getLatestReleasegIAlus(boolean z, ContinuationImpl continuationImpl) {
        Updater$getLatestRelease$1 updater$getLatestRelease$1;
        if (continuationImpl instanceof Updater$getLatestRelease$1) {
            updater$getLatestRelease$1 = (Updater$getLatestRelease$1) continuationImpl;
            int i = updater$getLatestRelease$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                updater$getLatestRelease$1.label = i - Integer.MIN_VALUE;
            } else {
                updater$getLatestRelease$1 = new Updater$getLatestRelease$1(this, continuationImpl);
            }
        } else {
            updater$getLatestRelease$1 = new Updater$getLatestRelease$1(this, continuationImpl);
        }
        Object objWithContext = updater$getLatestRelease$1.result;
        int i2 = updater$getLatestRelease$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            Updater$getLatestRelease$2 updater$getLatestRelease$2 = new Updater$getLatestRelease$2(z, (Continuation) null);
            updater$getLatestRelease$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, updater$getLatestRelease$2, updater$getLatestRelease$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).value;
    }
}
