package com.metrolist.music.playback.alarm;

import android.content.Context;
import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicAlarmStore {
    public static final MusicAlarmStore INSTANCE = new MusicAlarmStore();

    /* JADX INFO: renamed from: com.metrolist.music.playback.alarm.MusicAlarmStore$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Context L$0;
        public MusicAlarmStore L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MusicAlarmStore.this.load(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.alarm.MusicAlarmStore$save$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01781 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01781(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MusicAlarmStore.this.save(null, null, this);
        }
    }

    public static ListBuilder parse(String str) {
        Object failure;
        Object failure2;
        try {
            failure = new JSONArray(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) failure;
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                try {
                    String strOptString = jSONObjectOptJSONObject.optString("id");
                    if (StringsKt.isBlank(strOptString)) {
                        strOptString = UUID.randomUUID().toString();
                    }
                    String str2 = strOptString;
                    str2.getClass();
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enabled", true);
                    int iCoerceIn = UuidKt.coerceIn(jSONObjectOptJSONObject.optInt("hour", 7), 0, 23);
                    int iCoerceIn2 = UuidKt.coerceIn(jSONObjectOptJSONObject.optInt("minute", 0), 0, 59);
                    String strOptString2 = jSONObjectOptJSONObject.optString("playlistId");
                    strOptString2.getClass();
                    failure2 = new MusicAlarmEntry(str2, zOptBoolean, iCoerceIn, iCoerceIn2, strOptString2, jSONObjectOptJSONObject.optBoolean("randomSong", false), jSONObjectOptJSONObject.optLong("nextTriggerAt", -1L));
                } catch (Throwable th2) {
                    failure2 = new Result.Failure(th2);
                }
                if (failure2 instanceof Result.Failure) {
                    failure2 = null;
                }
                MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) failure2;
                if (musicAlarmEntry != null) {
                    listBuilderCreateListBuilder.add(musicAlarmEntry);
                }
            }
        }
        return CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
    }

    public static String serialize(List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) it.next();
            jSONArray.put(new JSONObject().put("id", musicAlarmEntry.id).put("enabled", musicAlarmEntry.enabled).put("hour", musicAlarmEntry.hour).put("minute", musicAlarmEntry.minute).put("playlistId", musicAlarmEntry.playlistId).put("randomSong", musicAlarmEntry.randomSong).put("nextTriggerAt", musicAlarmEntry.nextTriggerAt));
        }
        String string = jSONArray.toString();
        string.getClass();
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x0092 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009b A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a5 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b6 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c5 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e5 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f8 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0104  */
    /* JADX WARN: Code duplicated, block: B:65:0x0107 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0114 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x011e A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0124  */
    /* JADX WARN: Code duplicated, block: B:72:0x012f A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x013e A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0144  */
    /* JADX WARN: Code duplicated, block: B:79:0x014f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:80:0x0152  */
    /* JADX WARN: Code duplicated, block: B:83:0x015e A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0165  */
    /* JADX WARN: Code duplicated, block: B:87:0x0171 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0180  */
    /* JADX WARN: Code duplicated, block: B:91:0x0181 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:33:0x007c, B:36:0x0089, B:38:0x0092, B:40:0x009b, B:42:0x00a5, B:44:0x00ac, B:46:0x00b6, B:47:0x00ba, B:49:0x00c5, B:51:0x00cc, B:55:0x00db, B:57:0x00e5, B:59:0x00ee, B:61:0x00f8, B:62:0x00fc, B:65:0x0107, B:66:0x0114, B:68:0x011e, B:70:0x0125, B:72:0x012f, B:73:0x0133, B:75:0x013e, B:77:0x0145, B:81:0x0154, B:83:0x015e, B:85:0x0167, B:87:0x0171, B:88:0x0175, B:91:0x0181), top: B:107:0x0033 }] */
    public final Object load(Context context, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Context context2;
        Context context3;
        ListBuilder listBuilder;
        Object failure;
        MutablePreferences mutablePreferences;
        String str;
        Boolean bool;
        boolean zBooleanValue;
        int iIntValue;
        Integer num;
        int iIntValue2;
        String str2;
        String str3;
        Boolean bool2;
        boolean zBooleanValue2;
        long jLongValue;
        Boolean bool3;
        boolean zBooleanValue3;
        int iIntValue3;
        Integer num2;
        int iIntValue4;
        String str4;
        String str5;
        Boolean bool4;
        boolean zBooleanValue4;
        long jLongValue2;
        MusicAlarmStore musicAlarmStore = this;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = musicAlarmStore.new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = musicAlarmStore.new AnonymousClass1(continuationImpl);
        }
        Object objFirst = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Object obj = EmptyList.INSTANCE;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            contextCreateDeviceProtectedStorageContext.getClass();
            String string = contextCreateDeviceProtectedStorageContext.getSharedPreferences("alarm_store", 0).getString("alarm_entries", null);
            if (string == null) {
                string = "";
            }
            if (!StringsKt.isBlank(string) && (listBuilder = parse(string)) != null) {
                return listBuilder;
            }
            try {
                Flow data = UtilsKt.getDataStore(context).getData();
                context2 = context;
                try {
                    anonymousClass1.L$0 = context2;
                    anonymousClass1.L$2 = musicAlarmStore;
                    anonymousClass1.label = 1;
                    objFirst = StateFlowKt.first(data, anonymousClass1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objFirst == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    context3 = context2;
                    mutablePreferences = (MutablePreferences) objFirst;
                    str = (String) mutablePreferences.get(PreferenceKeysKt.AlarmEntriesKey);
                    if (str == null) {
                        str = "";
                    }
                    if (StringsKt.isBlank(str)) {
                        bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmEnabledKey);
                        if (bool != null) {
                            zBooleanValue = bool.booleanValue();
                        } else {
                            zBooleanValue = false;
                        }
                        Integer num3 = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmHourKey);
                        iIntValue = num3 != null ? num3.intValue() : 7;
                        num = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmMinuteKey);
                        if (num != null) {
                            iIntValue2 = num.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        str2 = (String) mutablePreferences.get(PreferenceKeysKt.AlarmPlaylistIdKey);
                        if (str2 == null) {
                            str3 = "";
                        } else {
                            str3 = str2;
                        }
                        bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmRandomSongKey);
                        if (bool2 != null) {
                            zBooleanValue2 = bool2.booleanValue();
                        } else {
                            zBooleanValue2 = false;
                        }
                        Long l = (Long) mutablePreferences.get(PreferenceKeysKt.AlarmNextTriggerAtKey);
                        jLongValue = l != null ? l.longValue() : -1L;
                        musicAlarmStore.getClass();
                        if (StringsKt.isBlank(str3)) {
                            failure = obj;
                        } else {
                            failure = CollectionsKt__IterablesKt.listOf(new MusicAlarmEntry("legacy-main-alarm", zBooleanValue, iIntValue, iIntValue2, str3, zBooleanValue2, jLongValue));
                        }
                    } else {
                        musicAlarmStore.getClass();
                        failure = parse(str);
                        if (failure == null) {
                            bool3 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmEnabledKey);
                            if (bool3 != null) {
                                zBooleanValue3 = bool3.booleanValue();
                            } else {
                                zBooleanValue3 = false;
                            }
                            Integer num4 = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmHourKey);
                            iIntValue3 = num4 != null ? num4.intValue() : 7;
                            num2 = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmMinuteKey);
                            if (num2 != null) {
                                iIntValue4 = num2.intValue();
                            } else {
                                iIntValue4 = 0;
                            }
                            str4 = (String) mutablePreferences.get(PreferenceKeysKt.AlarmPlaylistIdKey);
                            if (str4 == null) {
                                str5 = "";
                            } else {
                                str5 = str4;
                            }
                            bool4 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmRandomSongKey);
                            if (bool4 != null) {
                                zBooleanValue4 = bool4.booleanValue();
                            } else {
                                zBooleanValue4 = false;
                            }
                            Long l2 = (Long) mutablePreferences.get(PreferenceKeysKt.AlarmNextTriggerAtKey);
                            jLongValue2 = l2 != null ? l2.longValue() : -1L;
                            if (StringsKt.isBlank(str5)) {
                                failure = obj;
                            } else {
                                failure = CollectionsKt__IterablesKt.listOf(new MusicAlarmEntry("legacy-main-alarm", zBooleanValue3, iIntValue3, iIntValue4, str5, zBooleanValue4, jLongValue2));
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    context3 = context2;
                    failure = new Result.Failure(th);
                }
            } catch (Throwable th2) {
                th = th2;
                context2 = context;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            musicAlarmStore = anonymousClass1.L$2;
            context3 = anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objFirst);
                mutablePreferences = (MutablePreferences) objFirst;
                str = (String) mutablePreferences.get(PreferenceKeysKt.AlarmEntriesKey);
                if (str == null) {
                    str = "";
                }
                if (StringsKt.isBlank(str)) {
                    musicAlarmStore.getClass();
                    failure = parse(str);
                    if (failure == null) {
                        bool3 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmEnabledKey);
                        if (bool3 != null) {
                            zBooleanValue3 = bool3.booleanValue();
                        } else {
                            zBooleanValue3 = false;
                        }
                        Integer num5 = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmHourKey);
                        iIntValue3 = num5 != null ? num5.intValue() : 7;
                        num2 = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmMinuteKey);
                        if (num2 != null) {
                            iIntValue4 = num2.intValue();
                        } else {
                            iIntValue4 = 0;
                        }
                        str4 = (String) mutablePreferences.get(PreferenceKeysKt.AlarmPlaylistIdKey);
                        if (str4 == null) {
                            str5 = "";
                        } else {
                            str5 = str4;
                        }
                        bool4 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmRandomSongKey);
                        if (bool4 != null) {
                            zBooleanValue4 = bool4.booleanValue();
                        } else {
                            zBooleanValue4 = false;
                        }
                        Long l3 = (Long) mutablePreferences.get(PreferenceKeysKt.AlarmNextTriggerAtKey);
                        jLongValue2 = l3 != null ? l3.longValue() : -1L;
                        if (StringsKt.isBlank(str5)) {
                            failure = obj;
                        } else {
                            failure = CollectionsKt__IterablesKt.listOf(new MusicAlarmEntry("legacy-main-alarm", zBooleanValue3, iIntValue3, iIntValue4, str5, zBooleanValue4, jLongValue2));
                        }
                    }
                } else {
                    bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmEnabledKey);
                    if (bool != null) {
                        zBooleanValue = bool.booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                    Integer num6 = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmHourKey);
                    iIntValue = num6 != null ? num6.intValue() : 7;
                    num = (Integer) mutablePreferences.get(PreferenceKeysKt.AlarmMinuteKey);
                    if (num != null) {
                        iIntValue2 = num.intValue();
                    } else {
                        iIntValue2 = 0;
                    }
                    str2 = (String) mutablePreferences.get(PreferenceKeysKt.AlarmPlaylistIdKey);
                    if (str2 == null) {
                        str3 = "";
                    } else {
                        str3 = str2;
                    }
                    bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AlarmRandomSongKey);
                    if (bool2 != null) {
                        zBooleanValue2 = bool2.booleanValue();
                    } else {
                        zBooleanValue2 = false;
                    }
                    Long l4 = (Long) mutablePreferences.get(PreferenceKeysKt.AlarmNextTriggerAtKey);
                    jLongValue = l4 != null ? l4.longValue() : -1L;
                    musicAlarmStore.getClass();
                    if (StringsKt.isBlank(str3)) {
                        failure = obj;
                    } else {
                        failure = CollectionsKt__IterablesKt.listOf(new MusicAlarmEntry("legacy-main-alarm", zBooleanValue, iIntValue, iIntValue2, str3, zBooleanValue2, jLongValue));
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                failure = new Result.Failure(th);
            }
        }
        if (Result.m1866exceptionOrNullimpl(failure) == null) {
            obj = failure;
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            Context contextCreateDeviceProtectedStorageContext2 = context3.createDeviceProtectedStorageContext();
            contextCreateDeviceProtectedStorageContext2.getClass();
            contextCreateDeviceProtectedStorageContext2.getSharedPreferences("alarm_store", 0).edit().putString("alarm_entries", serialize(list)).apply();
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object save(Context context, ArrayList arrayList, ContinuationImpl continuationImpl) {
        C01781 c01781;
        if (continuationImpl instanceof C01781) {
            c01781 = (C01781) continuationImpl;
            int i = c01781.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01781.label = i - Integer.MIN_VALUE;
            } else {
                c01781 = new C01781(continuationImpl);
            }
        } else {
            c01781 = new C01781(continuationImpl);
        }
        Object obj = c01781.result;
        int i2 = c01781.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            contextCreateDeviceProtectedStorageContext.getClass();
            contextCreateDeviceProtectedStorageContext.getSharedPreferences("alarm_store", 0).edit().putString("alarm_entries", serialize(arrayList)).apply();
            DownloadUtil.AnonymousClass2 anonymousClass2 = new DownloadUtil.AnonymousClass2((Object) arrayList, continuation, (byte) 21);
            c01781.label = 1;
            Object objSafeDataStoreEdit = UtilsKt.safeDataStoreEdit(context, anonymousClass2, c01781);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objSafeDataStoreEdit == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
