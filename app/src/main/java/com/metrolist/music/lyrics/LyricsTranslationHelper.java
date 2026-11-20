package com.metrolist.music.lyrics;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.api.DeepLService;
import com.metrolist.music.api.OpenRouterService;
import com.metrolist.music.api.OpenRouterStreamingService;
import com.metrolist.music.api.OpenRouterStreamingService$streamTranslation$1;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$8$1;
import com.yalantis.ucrop.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LyricsTranslationHelper {
    public static final Map LanguageCodeToName;
    public static final SharedFlowImpl _clearTranslationsTrigger;
    public static final StateFlowImpl _hasActiveTranslations;
    public static final SharedFlowImpl _manualTrigger;
    public static final StateFlowImpl _status;
    public static final ReadonlySharedFlow clearTranslationsTrigger;
    public static final ReadonlyStateFlow hasActiveTranslations;
    public static boolean isCompositionActive;
    public static final ReadonlySharedFlow manualTrigger;
    public static final ReadonlyStateFlow status;
    public static final ConcurrentHashMap translationCache;
    public static StandaloneCoroutine translationJob;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class TranslationStatus {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Error extends TranslationStatus {
            public final String message;

            public Error(String str) {
                this.message = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && this.message.equals(((Error) obj).message);
            }

            public final int hashCode() {
                return this.message.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("Error(message=", this.message, ")");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Idle extends TranslationStatus {
            public static final Idle INSTANCE = new Idle();

            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Idle);
            }

            public final int hashCode() {
                return 1904275887;
            }

            public final String toString() {
                return "Idle";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Success extends TranslationStatus {
            public static final Success INSTANCE = new Success();

            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Success);
            }

            public final int hashCode() {
                return -1176535992;
            }

            public final String toString() {
                return "Success";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Translating extends TranslationStatus {
            public static final Translating INSTANCE = new Translating();

            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Translating);
            }

            public final int hashCode() {
                return 1740801104;
            }

            public final String toString() {
                return "Translating";
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsTranslationHelper$translateLyrics$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $apiKey;
        public final /* synthetic */ String $baseUrl;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MusicDatabase $database;
        public final /* synthetic */ String $deeplApiKey;
        public final /* synthetic */ String $deeplFormality;
        public final /* synthetic */ List $lyrics;
        public final /* synthetic */ String $mode;
        public final /* synthetic */ String $model;
        public final /* synthetic */ String $provider;
        public final /* synthetic */ String $songId;
        public final /* synthetic */ String $systemPrompt;
        public final /* synthetic */ String $targetLanguage;
        public List L$1;
        public MusicDatabase L$10;
        public List L$11;
        public List L$12;
        public String L$2;
        public List L$4;
        public Ref$ObjectRef L$6;
        public Object L$7;
        public Serializable L$8;
        public String L$9;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, String str3, Context context, List list, String str4, String str5, String str6, MusicDatabase musicDatabase, String str7, String str8, String str9, String str10, Continuation continuation) {
            super(2, continuation);
            this.$provider = str;
            this.$deeplApiKey = str2;
            this.$apiKey = str3;
            this.$context = context;
            this.$lyrics = list;
            this.$mode = str4;
            this.$targetLanguage = str5;
            this.$songId = str6;
            this.$database = musicDatabase;
            this.$deeplFormality = str7;
            this.$baseUrl = str8;
            this.$model = str9;
            this.$systemPrompt = str10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$provider, this.$deeplApiKey, this.$apiKey, this.$context, this.$lyrics, this.$mode, this.$targetLanguage, this.$songId, this.$database, this.$deeplFormality, this.$baseUrl, this.$model, this.$systemPrompt, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:115:0x02a8 A[PHI: r4
          0x02a8: PHI (r4v15 java.lang.String) = (r4v4 java.lang.String), (r4v6 java.lang.String) binds: [B:106:0x0288, B:113:0x02a3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:131:0x03a8 A[Catch: Exception -> 0x0035, TryCatch #5 {Exception -> 0x0035, blocks: (B:7:0x002c, B:16:0x006b, B:19:0x0096, B:129:0x039e, B:131:0x03a8, B:132:0x03af, B:134:0x03bc, B:136:0x03d8, B:139:0x03dd, B:22:0x00a6, B:23:0x00b6, B:93:0x024c, B:95:0x0256, B:97:0x025a, B:90:0x0239, B:89:0x022d, B:29:0x00cb, B:34:0x00d7, B:36:0x00dd, B:38:0x00f2, B:40:0x00f8, B:42:0x010d, B:43:0x0118, B:45:0x011e, B:47:0x0128, B:49:0x0136, B:52:0x0143, B:54:0x014d, B:55:0x0150, B:56:0x0151, B:58:0x015b, B:60:0x0170, B:62:0x0197, B:64:0x01a3, B:66:0x01ab, B:68:0x01b5, B:70:0x01c7, B:72:0x01dc, B:73:0x01df, B:74:0x01e0, B:101:0x0265, B:103:0x026b, B:105:0x0280, B:116:0x02aa, B:118:0x02b0, B:123:0x02f1, B:125:0x02fc, B:140:0x03e9, B:33:0x00d5, B:26:0x00bd, B:81:0x020d, B:83:0x0211, B:85:0x0215, B:87:0x021b, B:77:0x01f4), top: B:235:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:134:0x03bc A[Catch: Exception -> 0x0035, TryCatch #5 {Exception -> 0x0035, blocks: (B:7:0x002c, B:16:0x006b, B:19:0x0096, B:129:0x039e, B:131:0x03a8, B:132:0x03af, B:134:0x03bc, B:136:0x03d8, B:139:0x03dd, B:22:0x00a6, B:23:0x00b6, B:93:0x024c, B:95:0x0256, B:97:0x025a, B:90:0x0239, B:89:0x022d, B:29:0x00cb, B:34:0x00d7, B:36:0x00dd, B:38:0x00f2, B:40:0x00f8, B:42:0x010d, B:43:0x0118, B:45:0x011e, B:47:0x0128, B:49:0x0136, B:52:0x0143, B:54:0x014d, B:55:0x0150, B:56:0x0151, B:58:0x015b, B:60:0x0170, B:62:0x0197, B:64:0x01a3, B:66:0x01ab, B:68:0x01b5, B:70:0x01c7, B:72:0x01dc, B:73:0x01df, B:74:0x01e0, B:101:0x0265, B:103:0x026b, B:105:0x0280, B:116:0x02aa, B:118:0x02b0, B:123:0x02f1, B:125:0x02fc, B:140:0x03e9, B:33:0x00d5, B:26:0x00bd, B:81:0x020d, B:83:0x0211, B:85:0x0215, B:87:0x021b, B:77:0x01f4), top: B:235:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:136:0x03d8 A[Catch: Exception -> 0x0035, TryCatch #5 {Exception -> 0x0035, blocks: (B:7:0x002c, B:16:0x006b, B:19:0x0096, B:129:0x039e, B:131:0x03a8, B:132:0x03af, B:134:0x03bc, B:136:0x03d8, B:139:0x03dd, B:22:0x00a6, B:23:0x00b6, B:93:0x024c, B:95:0x0256, B:97:0x025a, B:90:0x0239, B:89:0x022d, B:29:0x00cb, B:34:0x00d7, B:36:0x00dd, B:38:0x00f2, B:40:0x00f8, B:42:0x010d, B:43:0x0118, B:45:0x011e, B:47:0x0128, B:49:0x0136, B:52:0x0143, B:54:0x014d, B:55:0x0150, B:56:0x0151, B:58:0x015b, B:60:0x0170, B:62:0x0197, B:64:0x01a3, B:66:0x01ab, B:68:0x01b5, B:70:0x01c7, B:72:0x01dc, B:73:0x01df, B:74:0x01e0, B:101:0x0265, B:103:0x026b, B:105:0x0280, B:116:0x02aa, B:118:0x02b0, B:123:0x02f1, B:125:0x02fc, B:140:0x03e9, B:33:0x00d5, B:26:0x00bd, B:81:0x020d, B:83:0x0211, B:85:0x0215, B:87:0x021b, B:77:0x01f4), top: B:235:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:138:0x03dc  */
        /* JADX WARN: Code duplicated, block: B:139:0x03dd A[Catch: Exception -> 0x0035, TryCatch #5 {Exception -> 0x0035, blocks: (B:7:0x002c, B:16:0x006b, B:19:0x0096, B:129:0x039e, B:131:0x03a8, B:132:0x03af, B:134:0x03bc, B:136:0x03d8, B:139:0x03dd, B:22:0x00a6, B:23:0x00b6, B:93:0x024c, B:95:0x0256, B:97:0x025a, B:90:0x0239, B:89:0x022d, B:29:0x00cb, B:34:0x00d7, B:36:0x00dd, B:38:0x00f2, B:40:0x00f8, B:42:0x010d, B:43:0x0118, B:45:0x011e, B:47:0x0128, B:49:0x0136, B:52:0x0143, B:54:0x014d, B:55:0x0150, B:56:0x0151, B:58:0x015b, B:60:0x0170, B:62:0x0197, B:64:0x01a3, B:66:0x01ab, B:68:0x01b5, B:70:0x01c7, B:72:0x01dc, B:73:0x01df, B:74:0x01e0, B:101:0x0265, B:103:0x026b, B:105:0x0280, B:116:0x02aa, B:118:0x02b0, B:123:0x02f1, B:125:0x02fc, B:140:0x03e9, B:33:0x00d5, B:26:0x00bd, B:81:0x020d, B:83:0x0211, B:85:0x0215, B:87:0x021b, B:77:0x01f4), top: B:235:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:150:0x0438 A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:152:0x043f  */
        /* JADX WARN: Code duplicated, block: B:153:0x0441 A[Catch: Exception -> 0x04b1, TRY_LEAVE, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:155:0x0450 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:164:0x0484 A[Catch: Exception -> 0x0491, TRY_LEAVE, TryCatch #7 {Exception -> 0x0491, blocks: (B:162:0x047e, B:164:0x0484), top: B:245:0x047e }] */
        /* JADX WARN: Code duplicated, block: B:177:0x04c2 A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:180:0x04cd A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:182:0x04d5 A[Catch: Exception -> 0x04b1, LOOP:0: B:178:0x04c7->B:182:0x04d5, LOOP_END, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:186:0x0505 A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:188:0x050d A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:191:0x0518 A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:193:0x0520 A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:210:0x058e A[Catch: Exception -> 0x04b1, TryCatch #8 {Exception -> 0x04b1, blocks: (B:202:0x0574, B:204:0x057e, B:206:0x0582, B:208:0x0588, B:210:0x058e, B:213:0x0593, B:175:0x04b8, B:177:0x04c2, B:178:0x04c7, B:180:0x04cd, B:182:0x04d5, B:183:0x04f2, B:184:0x04f5, B:185:0x04f6, B:199:0x0554, B:186:0x0505, B:188:0x050d, B:189:0x0511, B:191:0x0518, B:193:0x0520, B:195:0x0528, B:196:0x0544, B:197:0x0547, B:198:0x0548, B:170:0x049f, B:148:0x0432, B:150:0x0438, B:153:0x0441, B:144:0x0424), top: B:247:0x0424 }] */
        /* JADX WARN: Code duplicated, block: B:215:0x0599  */
        /* JADX WARN: Code duplicated, block: B:219:0x05a8  */
        /* JADX WARN: Code duplicated, block: B:249:0x04f2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:250:0x0544 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:251:0x0528 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:252:0x0548 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:254:0x0511 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:92:0x024a  */
        /* JADX WARN: Code duplicated, block: B:95:0x0256 A[Catch: Exception -> 0x0035, TryCatch #5 {Exception -> 0x0035, blocks: (B:7:0x002c, B:16:0x006b, B:19:0x0096, B:129:0x039e, B:131:0x03a8, B:132:0x03af, B:134:0x03bc, B:136:0x03d8, B:139:0x03dd, B:22:0x00a6, B:23:0x00b6, B:93:0x024c, B:95:0x0256, B:97:0x025a, B:90:0x0239, B:89:0x022d, B:29:0x00cb, B:34:0x00d7, B:36:0x00dd, B:38:0x00f2, B:40:0x00f8, B:42:0x010d, B:43:0x0118, B:45:0x011e, B:47:0x0128, B:49:0x0136, B:52:0x0143, B:54:0x014d, B:55:0x0150, B:56:0x0151, B:58:0x015b, B:60:0x0170, B:62:0x0197, B:64:0x01a3, B:66:0x01ab, B:68:0x01b5, B:70:0x01c7, B:72:0x01dc, B:73:0x01df, B:74:0x01e0, B:101:0x0265, B:103:0x026b, B:105:0x0280, B:116:0x02aa, B:118:0x02b0, B:123:0x02f1, B:125:0x02fc, B:140:0x03e9, B:33:0x00d5, B:26:0x00bd, B:81:0x020d, B:83:0x0211, B:85:0x0215, B:87:0x021b, B:77:0x01f4), top: B:235:0x001d, inners: #1 }] */
        /* JADX WARN: Code restructure failed: missing block: B:200:0x0571, code lost:
        
            if (kotlinx.coroutines.AwaitKt.delay(3000, r6) == r11) goto L201;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v16 */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.String, java.util.List, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v7, types: [com.metrolist.music.db.MusicDatabase, java.io.Serializable, java.lang.String, java.lang.Throwable, java.util.List, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r23v0, types: [java.lang.String, java.lang.Throwable, java.util.List] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Context context;
            StateFlowImpl stateFlowImpl;
            String strJoinToString$default;
            String str;
            String str2;
            String str3;
            List list;
            Context context2;
            List list2;
            ?? r10;
            String str4;
            Object obj2;
            String str5;
            List list3;
            Ref$ObjectRef ref$ObjectRef;
            String str6;
            Ref$ObjectRef ref$ObjectRef2;
            Ref$BooleanRef ref$BooleanRef;
            List list4;
            Object obj3;
            Object obj4;
            List list5;
            final String str7;
            Object objFirst;
            final List list6;
            final LyricsEntity lyricsEntity;
            String str8;
            List list7;
            Object objCreateFailure;
            List list8;
            int i;
            Object obj5;
            List list9;
            List list10;
            List list11;
            Object objFirst2;
            final List list12;
            final String str9;
            final String str10;
            ?? r11;
            ?? r12;
            int size;
            TranslationStatus.Success success;
            Iterator it;
            int i2;
            Object next;
            String str11;
            int i3;
            int i4;
            ?? r13;
            final LyricsEntity lyricsEntity2;
            Throwable thM1866exceptionOrNullimpl;
            String message;
            AnonymousClass2 anonymousClass2 = this;
            String str12 = anonymousClass2.$provider;
            byte b = anonymousClass2.label;
            TranslationStatus.Idle idle = TranslationStatus.Idle.INSTANCE;
            MusicDatabase musicDatabase = anonymousClass2.$database;
            String str13 = anonymousClass2.$songId;
            TranslationStatus.Success success2 = TranslationStatus.Success.INSTANCE;
            String str14 = anonymousClass2.$mode;
            List list13 = anonymousClass2.$lyrics;
            Unit unit = Unit.INSTANCE;
            Context context3 = anonymousClass2.$context;
            final String str15 = anonymousClass2.$targetLanguage;
            Throwable th = null;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    switch (b) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            boolean zAreEqual = Intrinsics.areEqual(str12, "DeepL");
                            String str16 = anonymousClass2.$deeplApiKey;
                            if (StringsKt.isBlank(zAreEqual ? str16 : anonymousClass2.$apiKey)) {
                                StateFlowImpl stateFlowImpl2 = LyricsTranslationHelper._status;
                                String string = context3.getString(R.string.ai_error_api_key_required);
                                string.getClass();
                                stateFlowImpl2.setValue(new TranslationStatus.Error(string));
                                return unit;
                            }
                            if (list13.isEmpty()) {
                                StateFlowImpl stateFlowImpl3 = LyricsTranslationHelper._status;
                                String string2 = context3.getString(R.string.ai_error_no_lyrics);
                                string2.getClass();
                                stateFlowImpl3.setValue(new TranslationStatus.Error(string2));
                                return unit;
                            }
                            ArrayList arrayList = new ArrayList();
                            int i5 = 0;
                            for (Object obj6 : list13) {
                                int i6 = i5 + 1;
                                Throwable th2 = th;
                                if (i5 < 0) {
                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                    throw th2;
                                }
                                LyricsEntry lyricsEntry = (LyricsEntry) obj6;
                                String str17 = str16;
                                Object obj7 = !StringsKt.isBlank(lyricsEntry.text) ? ResultKt.to(Boxing.boxInt(i5), lyricsEntry) : th2;
                                if (obj7 != null) {
                                    arrayList.add(obj7);
                                }
                                i5 = i6;
                                th = th2;
                                str16 = str17;
                            }
                            ?? r23 = th;
                            String str18 = str16;
                            if (arrayList.isEmpty()) {
                                StateFlowImpl stateFlowImpl4 = LyricsTranslationHelper._status;
                                String string3 = context3.getString(R.string.ai_error_lyrics_empty);
                                string3.getClass();
                                stateFlowImpl4.setValue(new TranslationStatus.Error(string3));
                                return unit;
                            }
                            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "\n", null, null, new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 11), 30);
                            List list14 = (List) LyricsTranslationHelper.translationCache.get(LyricsTranslationHelper.getCacheKey(strJoinToString$default, str14, str15));
                            if (list14 != null) {
                                str7 = str14;
                                if (list14.size() >= arrayList.size()) {
                                    int size2 = arrayList.size();
                                    int i7 = 0;
                                    int i8 = 0;
                                    while (i8 < size2) {
                                        Object obj8 = arrayList.get(i8);
                                        i8++;
                                        int i9 = i7 + 1;
                                        if (i7 < 0) {
                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                            throw r23;
                                        }
                                        int iIntValue = ((Number) ((Pair) obj8).first).intValue();
                                        int i10 = size2;
                                        if (i7 < list14.size()) {
                                            ((StateFlowImpl) ((LyricsEntry) list13.get(iIntValue)).translatedTextFlow).setValue(list14.get(i7));
                                        }
                                        size2 = i10;
                                        i7 = i9;
                                    }
                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                    LyricsTranslationHelper._status.setValue(success2);
                                    if (StringsKt.isBlank(str13) || musicDatabase == null) {
                                        anonymousClass2.L$1 = null;
                                        anonymousClass2.L$2 = null;
                                        anonymousClass2.L$4 = null;
                                        anonymousClass2.label = (byte) 2;
                                        if (AwaitKt.delay(3000L, anonymousClass2) == coroutineSingletons) {
                                        }
                                        stateFlowImpl = LyricsTranslationHelper._status;
                                        if ((stateFlowImpl.getValue() instanceof TranslationStatus.Success) && LyricsTranslationHelper.isCompositionActive) {
                                            stateFlowImpl.setValue(idle);
                                        }
                                        return unit;
                                    }
                                    Flow flowLyrics = musicDatabase.lyrics(str13);
                                    anonymousClass2.L$1 = r23;
                                    anonymousClass2.L$2 = r23;
                                    anonymousClass2.L$4 = list14;
                                    anonymousClass2.label = (byte) 1;
                                    objFirst = StateFlowKt.first(flowLyrics, anonymousClass2);
                                    if (objFirst != coroutineSingletons) {
                                        list6 = list14;
                                        lyricsEntity = (LyricsEntity) objFirst;
                                        if (lyricsEntity != null && ((str8 = lyricsEntity.translatedLyrics) == null || StringsKt.isBlank(str8))) {
                                            final byte b2 = 0;
                                            musicDatabase.query(new Function1() { // from class: com.metrolist.music.lyrics.LyricsTranslationHelper$translateLyrics$2$$ExternalSyntheticLambda1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj9) {
                                                    byte b3 = b2;
                                                    Unit unit2 = Unit.INSTANCE;
                                                    String str19 = str7;
                                                    String str20 = str15;
                                                    LyricsEntity lyricsEntity3 = lyricsEntity;
                                                    MusicDatabase musicDatabase2 = (MusicDatabase) obj9;
                                                    switch (b3) {
                                                        case 0:
                                                            LyricsEntity lyricsEntityCopy$default = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list6, "\n", null, null, null, 62), str20, str19);
                                                            musicDatabase2.getClass();
                                                            musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default);
                                                            break;
                                                        default:
                                                            LyricsEntity lyricsEntityCopy$default2 = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list6, "\n", null, null, null, 62), str20, str19);
                                                            musicDatabase2.getClass();
                                                            musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default2);
                                                            break;
                                                    }
                                                    return unit2;
                                                }
                                            });
                                            break;
                                        }
                                        anonymousClass2.L$1 = null;
                                        anonymousClass2.L$2 = null;
                                        anonymousClass2.L$4 = null;
                                        anonymousClass2.label = (byte) 2;
                                        if (AwaitKt.delay(3000L, anonymousClass2) == coroutineSingletons) {
                                        }
                                        stateFlowImpl = LyricsTranslationHelper._status;
                                        if (stateFlowImpl.getValue() instanceof TranslationStatus.Success) {
                                            stateFlowImpl.setValue(idle);
                                        }
                                        return unit;
                                    }
                                } else {
                                    str = str7;
                                }
                                return coroutineSingletons;
                            }
                            str = str14;
                            str2 = str15;
                            if (StringsKt.isBlank(str2)) {
                                StateFlowImpl stateFlowImpl5 = LyricsTranslationHelper._status;
                                String string4 = context3.getString(R.string.ai_error_language_required);
                                string4.getClass();
                                stateFlowImpl5.setValue(new TranslationStatus.Error(string4));
                                return unit;
                            }
                            String displayLanguage = (String) LyricsTranslationHelper.LanguageCodeToName.get(str2);
                            if (displayLanguage == null) {
                                try {
                                    displayLanguage = Locale.forLanguageTag(str2).getDisplayLanguage();
                                    displayLanguage.getClass();
                                    if (StringsKt.isBlank(displayLanguage) || Intrinsics.areEqual(displayLanguage, str2)) {
                                        displayLanguage = null;
                                    }
                                } catch (Exception unused) {
                                }
                                if (displayLanguage == null) {
                                    str3 = str2;
                                } else {
                                    str3 = displayLanguage;
                                }
                            } else {
                                str3 = displayLanguage;
                            }
                            if (Intrinsics.areEqual(str12, "DeepL")) {
                                Timber.Forest.getClass();
                                ConnectionPool.d(new Object[0]);
                                DeepLService deepLService = DeepLService.INSTANCE;
                                String str19 = anonymousClass2.$deeplFormality;
                                anonymousClass2.L$1 = arrayList;
                                anonymousClass2.L$2 = strJoinToString$default;
                                anonymousClass2.L$4 = null;
                                anonymousClass2.label = (byte) 3;
                                obj3 = null;
                                Object objM1055translatehUnOzRk = DeepLService.INSTANCE.m1055translatehUnOzRk(3, strJoinToString$default, str2, str18, str19, anonymousClass2);
                                if (objM1055translatehUnOzRk != coroutineSingletons) {
                                    obj4 = objM1055translatehUnOzRk;
                                    str5 = strJoinToString$default;
                                    list5 = arrayList;
                                    Object obj9 = obj4;
                                    list3 = list5;
                                    obj2 = obj9;
                                    context2 = context3;
                                    list2 = list13;
                                    r10 = obj3;
                                    str4 = str2;
                                    if (Result.m1867isSuccessimpl(obj2)) {
                                        list8 = (List) obj2;
                                        if (!LyricsTranslationHelper.isCompositionActive) {
                                            LyricsTranslationHelper.translationCache.put(LyricsTranslationHelper.getCacheKey(str5, str, str4), list8);
                                            if (!StringsKt.isBlank(str13) || musicDatabase == null) {
                                                i = 0;
                                                obj5 = obj2;
                                                list9 = list2;
                                                r12 = r10;
                                                size = list3.size();
                                                if (list8.size() >= size) {
                                                    i3 = i;
                                                    for (Object obj10 : list3) {
                                                        i4 = i3 + 1;
                                                        if (i3 >= 0) {
                                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                                            throw r12;
                                                        }
                                                        ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                                        i3 = i4;
                                                    }
                                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                    LyricsTranslationHelper._status.setValue(success2);
                                                } else {
                                                    success = success2;
                                                    if (list8.size() < size) {
                                                        it = list8.iterator();
                                                        while (true) {
                                                            i2 = i;
                                                            if (it.hasNext()) {
                                                                next = it.next();
                                                                i = i2 + 1;
                                                                if (i2 >= 0) {
                                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                    throw r12;
                                                                }
                                                                str11 = (String) next;
                                                                if (i2 < list3.size()) {
                                                                    ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                                }
                                                            } else {
                                                                LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                                LyricsTranslationHelper._status.setValue(success);
                                                            }
                                                        }
                                                    }
                                                }
                                                anonymousClass2.L$1 = r12;
                                                anonymousClass2.L$2 = r12;
                                                anonymousClass2.L$4 = r12;
                                                anonymousClass2.L$6 = r12;
                                                anonymousClass2.L$7 = obj5;
                                                anonymousClass2.L$8 = r12;
                                                anonymousClass2.L$9 = r12;
                                                anonymousClass2.L$10 = r12;
                                                anonymousClass2.L$11 = r12;
                                                anonymousClass2.L$12 = r12;
                                                anonymousClass2.label = (byte) 7;
                                            } else {
                                                try {
                                                    Flow flowLyrics2 = musicDatabase.lyrics(str13);
                                                    anonymousClass2.L$1 = list3;
                                                    anonymousClass2.L$2 = r10;
                                                    anonymousClass2.L$4 = r10;
                                                    anonymousClass2.L$6 = r10;
                                                    anonymousClass2.L$7 = obj2;
                                                    anonymousClass2.L$8 = str;
                                                    anonymousClass2.L$9 = str4;
                                                    anonymousClass2.L$10 = musicDatabase;
                                                    list10 = list2;
                                                    try {
                                                        anonymousClass2.L$11 = list10;
                                                        anonymousClass2.L$12 = list8;
                                                        anonymousClass2.label = (byte) 6;
                                                        objFirst2 = StateFlowKt.first(flowLyrics2, anonymousClass2);
                                                        if (objFirst2 != coroutineSingletons) {
                                                            list12 = list8;
                                                            list9 = list10;
                                                            str9 = str;
                                                            str10 = str4;
                                                            r13 = r10;
                                                            try {
                                                                lyricsEntity2 = (LyricsEntity) objFirst2;
                                                                if (lyricsEntity2 != null) {
                                                                    final byte b3 = 1;
                                                                    musicDatabase.query(new Function1() { // from class: com.metrolist.music.lyrics.LyricsTranslationHelper$translateLyrics$2$$ExternalSyntheticLambda1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj11) {
                                                                            byte b4 = b3;
                                                                            Unit unit2 = Unit.INSTANCE;
                                                                            String str110 = str9;
                                                                            String str20 = str10;
                                                                            LyricsEntity lyricsEntity3 = lyricsEntity2;
                                                                            MusicDatabase musicDatabase2 = (MusicDatabase) obj11;
                                                                            switch (b4) {
                                                                                case 0:
                                                                                    LyricsEntity lyricsEntityCopy$default = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list12, "\n", null, null, null, 62), str20, str110);
                                                                                    musicDatabase2.getClass();
                                                                                    musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default);
                                                                                    break;
                                                                                default:
                                                                                    LyricsEntity lyricsEntityCopy$default2 = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list12, "\n", null, null, null, 62), str20, str110);
                                                                                    musicDatabase2.getClass();
                                                                                    musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default2);
                                                                                    break;
                                                                            }
                                                                            return unit2;
                                                                        }
                                                                    });
                                                                }
                                                                obj5 = obj2;
                                                                list8 = list12;
                                                                i = 0;
                                                                r12 = r13;
                                                            } catch (Exception unused2) {
                                                                list11 = list12;
                                                                r11 = r13;
                                                                i = 0;
                                                                Timber.Forest.getClass();
                                                                ConnectionPool.e$1(new Object[0]);
                                                                list8 = list11;
                                                                obj5 = obj2;
                                                                r12 = r11;
                                                            }
                                                            size = list3.size();
                                                            if (list8.size() >= size) {
                                                                i3 = i;
                                                                while (r1.hasNext()) {
                                                                    i4 = i3 + 1;
                                                                    if (i3 >= 0) {
                                                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                        throw r12;
                                                                    }
                                                                    ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                                                    i3 = i4;
                                                                }
                                                                LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                                LyricsTranslationHelper._status.setValue(success2);
                                                            } else {
                                                                success = success2;
                                                                if (list8.size() < size) {
                                                                    it = list8.iterator();
                                                                    while (true) {
                                                                        i2 = i;
                                                                        if (it.hasNext()) {
                                                                            next = it.next();
                                                                            i = i2 + 1;
                                                                            if (i2 >= 0) {
                                                                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                                throw r12;
                                                                            }
                                                                            str11 = (String) next;
                                                                            if (i2 < list3.size()) {
                                                                                ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                                            }
                                                                        } else {
                                                                            LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                                            LyricsTranslationHelper._status.setValue(success);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            anonymousClass2.L$1 = r12;
                                                            anonymousClass2.L$2 = r12;
                                                            anonymousClass2.L$4 = r12;
                                                            anonymousClass2.L$6 = r12;
                                                            anonymousClass2.L$7 = obj5;
                                                            anonymousClass2.L$8 = r12;
                                                            anonymousClass2.L$9 = r12;
                                                            anonymousClass2.L$10 = r12;
                                                            anonymousClass2.L$11 = r12;
                                                            anonymousClass2.L$12 = r12;
                                                            anonymousClass2.label = (byte) 7;
                                                        }
                                                    } catch (Exception unused3) {
                                                        list11 = list8;
                                                        list9 = list10;
                                                        r11 = r10;
                                                        i = 0;
                                                        Timber.Forest.getClass();
                                                        ConnectionPool.e$1(new Object[0]);
                                                        list8 = list11;
                                                        obj5 = obj2;
                                                        r12 = r11;
                                                        size = list3.size();
                                                        if (list8.size() >= size) {
                                                            i3 = i;
                                                            while (r1.hasNext()) {
                                                                i4 = i3 + 1;
                                                                if (i3 >= 0) {
                                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                    throw r12;
                                                                }
                                                                ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                                                i3 = i4;
                                                            }
                                                            LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                            LyricsTranslationHelper._status.setValue(success2);
                                                        } else {
                                                            success = success2;
                                                            if (list8.size() < size) {
                                                                it = list8.iterator();
                                                                while (true) {
                                                                    i2 = i;
                                                                    if (it.hasNext()) {
                                                                        next = it.next();
                                                                        i = i2 + 1;
                                                                        if (i2 >= 0) {
                                                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                            throw r12;
                                                                        }
                                                                        str11 = (String) next;
                                                                        if (i2 < list3.size()) {
                                                                            ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                                        }
                                                                    } else {
                                                                        LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                                        LyricsTranslationHelper._status.setValue(success);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        anonymousClass2.L$1 = r12;
                                                        anonymousClass2.L$2 = r12;
                                                        anonymousClass2.L$4 = r12;
                                                        anonymousClass2.L$6 = r12;
                                                        anonymousClass2.L$7 = obj5;
                                                        anonymousClass2.L$8 = r12;
                                                        anonymousClass2.L$9 = r12;
                                                        anonymousClass2.L$10 = r12;
                                                        anonymousClass2.L$11 = r12;
                                                        anonymousClass2.L$12 = r12;
                                                        anonymousClass2.label = (byte) 7;
                                                    }
                                                } catch (Exception unused4) {
                                                    list10 = list2;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                    if (thM1866exceptionOrNullimpl != null && LyricsTranslationHelper.isCompositionActive) {
                                        message = thM1866exceptionOrNullimpl.getMessage();
                                        if (message == null) {
                                            context = context2;
                                            message = context.getString(R.string.ai_error_unknown);
                                            message.getClass();
                                        } else {
                                            context = context2;
                                        }
                                        LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                        break;
                                    }
                                    return unit;
                                }
                            } else {
                                list = list13;
                                if (Intrinsics.areEqual(str12, "Custom")) {
                                    Timber.Forest.getClass();
                                    ConnectionPool.d(new Object[0]);
                                    OpenRouterService openRouterService = OpenRouterService.INSTANCE;
                                    String str20 = anonymousClass2.$apiKey;
                                    String str21 = anonymousClass2.$baseUrl;
                                    String str22 = anonymousClass2.$model;
                                    String str23 = anonymousClass2.$mode;
                                    context = context3;
                                    try {
                                        String str24 = anonymousClass2.$systemPrompt;
                                        anonymousClass2.L$1 = arrayList;
                                        anonymousClass2.L$2 = strJoinToString$default;
                                        anonymousClass2.L$4 = null;
                                        anonymousClass2.label = (byte) 5;
                                        context2 = context;
                                        list2 = list;
                                        r10 = 0;
                                        str4 = str2;
                                        try {
                                            Object objM1056translatetZkwj4A = OpenRouterService.INSTANCE.m1056translatetZkwj4A(strJoinToString$default, str3, str20, str21, str22, str23, 3, str24, this);
                                            anonymousClass2 = this;
                                            if (objM1056translatetZkwj4A != coroutineSingletons) {
                                                obj2 = objM1056translatetZkwj4A;
                                                str5 = strJoinToString$default;
                                                list3 = arrayList;
                                                if (Result.m1867isSuccessimpl(obj2)) {
                                                    list8 = (List) obj2;
                                                    if (!LyricsTranslationHelper.isCompositionActive) {
                                                        LyricsTranslationHelper.translationCache.put(LyricsTranslationHelper.getCacheKey(str5, str, str4), list8);
                                                        if (StringsKt.isBlank(str13)) {
                                                        }
                                                        i = 0;
                                                        obj5 = obj2;
                                                        list9 = list2;
                                                        r12 = r10;
                                                        size = list3.size();
                                                        if (list8.size() >= size) {
                                                            i3 = i;
                                                            while (r1.hasNext()) {
                                                                i4 = i3 + 1;
                                                                if (i3 >= 0) {
                                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                    throw r12;
                                                                }
                                                                ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                                                i3 = i4;
                                                            }
                                                            LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                            LyricsTranslationHelper._status.setValue(success2);
                                                        } else {
                                                            success = success2;
                                                            if (list8.size() < size) {
                                                                it = list8.iterator();
                                                                while (true) {
                                                                    i2 = i;
                                                                    if (it.hasNext()) {
                                                                        next = it.next();
                                                                        i = i2 + 1;
                                                                        if (i2 >= 0) {
                                                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                            throw r12;
                                                                        }
                                                                        str11 = (String) next;
                                                                        if (i2 < list3.size()) {
                                                                            ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                                        }
                                                                    } else {
                                                                        LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                                        LyricsTranslationHelper._status.setValue(success);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        anonymousClass2.L$1 = r12;
                                                        anonymousClass2.L$2 = r12;
                                                        anonymousClass2.L$4 = r12;
                                                        anonymousClass2.L$6 = r12;
                                                        anonymousClass2.L$7 = obj5;
                                                        anonymousClass2.L$8 = r12;
                                                        anonymousClass2.L$9 = r12;
                                                        anonymousClass2.L$10 = r12;
                                                        anonymousClass2.L$11 = r12;
                                                        anonymousClass2.L$12 = r12;
                                                        anonymousClass2.label = (byte) 7;
                                                        break;
                                                    }
                                                }
                                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                                if (thM1866exceptionOrNullimpl != null) {
                                                    message = thM1866exceptionOrNullimpl.getMessage();
                                                    if (message == null) {
                                                        context = context2;
                                                        message = context.getString(R.string.ai_error_unknown);
                                                        message.getClass();
                                                    } else {
                                                        context = context2;
                                                    }
                                                    LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                                    break;
                                                }
                                                return unit;
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            context = context2;
                                            if (!(e instanceof CancellationException) && LyricsTranslationHelper.isCompositionActive) {
                                                String message2 = e.getMessage();
                                                if (message2 == null) {
                                                    message2 = context.getString(R.string.ai_error_translation_failed);
                                                    message2.getClass();
                                                }
                                                LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message2));
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } else {
                                    Timber.Forest.getClass();
                                    ConnectionPool.d(new Object[0]);
                                    Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                                    Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                                    Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                                    ref$ObjectRef4.element = "";
                                    StringBuilder sb = new StringBuilder();
                                    OkHttpClient okHttpClient = OpenRouterStreamingService.client;
                                    String str25 = anonymousClass2.$apiKey;
                                    String str26 = anonymousClass2.$baseUrl;
                                    String str27 = anonymousClass2.$model;
                                    String str28 = anonymousClass2.$mode;
                                    String str29 = anonymousClass2.$systemPrompt;
                                    str3.getClass();
                                    str25.getClass();
                                    str26.getClass();
                                    str27.getClass();
                                    str28.getClass();
                                    str29.getClass();
                                    SafeFlow safeFlow = new SafeFlow((byte) 0, new OpenRouterStreamingService$streamTranslation$1(strJoinToString$default, str3, str27, str28, str29, str26, str25, null));
                                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                                    Flow flowFlowOn = StateFlowKt.flowOn(safeFlow, DefaultIoScheduler.INSTANCE);
                                    PlayerMenuKt$ListenTogetherDialog$8$1.AnonymousClass1 anonymousClass1 = new PlayerMenuKt$ListenTogetherDialog$8$1.AnonymousClass1(sb, arrayList, ref$ObjectRef3, ref$BooleanRef2, ref$ObjectRef4, anonymousClass2.$lyrics, (byte) 2);
                                    ref$ObjectRef = ref$ObjectRef3;
                                    anonymousClass2.L$1 = arrayList;
                                    anonymousClass2.L$2 = strJoinToString$default;
                                    str6 = str2;
                                    anonymousClass2.L$4 = null;
                                    anonymousClass2.L$6 = ref$ObjectRef;
                                    anonymousClass2.L$7 = ref$BooleanRef2;
                                    anonymousClass2.L$8 = ref$ObjectRef4;
                                    anonymousClass2.L$9 = null;
                                    anonymousClass2.label = (byte) 4;
                                    if (flowFlowOn.collect(anonymousClass1, anonymousClass2) != coroutineSingletons) {
                                        ref$ObjectRef2 = ref$ObjectRef4;
                                        ref$BooleanRef = ref$BooleanRef2;
                                        list4 = arrayList;
                                        ConnectionPool connectionPool = Timber.Forest;
                                        boolean z = ref$BooleanRef.element;
                                        list7 = (List) ref$ObjectRef.element;
                                        if (list7 != null) {
                                            Boxing.boxInt(list7.size());
                                        }
                                        connectionPool.getClass();
                                        ConnectionPool.d(new Object[0]);
                                        if (ref$BooleanRef.element) {
                                            objCreateFailure = ResultKt.createFailure(new Exception((String) ref$ObjectRef2.element));
                                        } else {
                                            objCreateFailure = ref$ObjectRef.element;
                                            if (objCreateFailure != null) {
                                                objCreateFailure = ResultKt.createFailure(new Exception("No translation received"));
                                            }
                                        }
                                        obj2 = objCreateFailure;
                                        str5 = strJoinToString$default;
                                        context2 = context3;
                                        list3 = list4;
                                        list2 = list;
                                        r10 = 0;
                                        str4 = str6;
                                        if (Result.m1867isSuccessimpl(obj2)) {
                                            list8 = (List) obj2;
                                            if (!LyricsTranslationHelper.isCompositionActive) {
                                                LyricsTranslationHelper.translationCache.put(LyricsTranslationHelper.getCacheKey(str5, str, str4), list8);
                                                if (StringsKt.isBlank(str13)) {
                                                }
                                                i = 0;
                                                obj5 = obj2;
                                                list9 = list2;
                                                r12 = r10;
                                                size = list3.size();
                                                if (list8.size() >= size) {
                                                    i3 = i;
                                                    while (r1.hasNext()) {
                                                        i4 = i3 + 1;
                                                        if (i3 >= 0) {
                                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                                            throw r12;
                                                        }
                                                        ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                                        i3 = i4;
                                                    }
                                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                    LyricsTranslationHelper._status.setValue(success2);
                                                } else {
                                                    success = success2;
                                                    if (list8.size() < size) {
                                                        it = list8.iterator();
                                                        while (true) {
                                                            i2 = i;
                                                            if (it.hasNext()) {
                                                                next = it.next();
                                                                i = i2 + 1;
                                                                if (i2 >= 0) {
                                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                                    throw r12;
                                                                }
                                                                str11 = (String) next;
                                                                if (i2 < list3.size()) {
                                                                    ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                                }
                                                            } else {
                                                                LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                                LyricsTranslationHelper._status.setValue(success);
                                                            }
                                                        }
                                                    }
                                                }
                                                anonymousClass2.L$1 = r12;
                                                anonymousClass2.L$2 = r12;
                                                anonymousClass2.L$4 = r12;
                                                anonymousClass2.L$6 = r12;
                                                anonymousClass2.L$7 = obj5;
                                                anonymousClass2.L$8 = r12;
                                                anonymousClass2.L$9 = r12;
                                                anonymousClass2.L$10 = r12;
                                                anonymousClass2.L$11 = r12;
                                                anonymousClass2.L$12 = r12;
                                                anonymousClass2.label = (byte) 7;
                                                break;
                                            }
                                        }
                                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                        if (thM1866exceptionOrNullimpl != null) {
                                            message = thM1866exceptionOrNullimpl.getMessage();
                                            if (message == null) {
                                                context = context2;
                                                message = context.getString(R.string.ai_error_unknown);
                                                message.getClass();
                                            } else {
                                                context = context2;
                                            }
                                            LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                            break;
                                        }
                                        return unit;
                                    }
                                }
                            }
                            return coroutineSingletons;
                        case 1:
                            List list15 = anonymousClass2.L$4;
                            ResultKt.throwOnFailure(obj);
                            list6 = list15;
                            str7 = str14;
                            objFirst = obj;
                            lyricsEntity = (LyricsEntity) objFirst;
                            if (lyricsEntity != null) {
                                final byte b4 = 0;
                                musicDatabase.query(new Function1() { // from class: com.metrolist.music.lyrics.LyricsTranslationHelper$translateLyrics$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj11) {
                                        byte b5 = b4;
                                        Unit unit2 = Unit.INSTANCE;
                                        String str110 = str7;
                                        String str210 = str15;
                                        LyricsEntity lyricsEntity3 = lyricsEntity;
                                        MusicDatabase musicDatabase2 = (MusicDatabase) obj11;
                                        switch (b5) {
                                            case 0:
                                                LyricsEntity lyricsEntityCopy$default = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list6, "\n", null, null, null, 62), str210, str110);
                                                musicDatabase2.getClass();
                                                musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default);
                                                break;
                                            default:
                                                LyricsEntity lyricsEntityCopy$default2 = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list6, "\n", null, null, null, 62), str210, str110);
                                                musicDatabase2.getClass();
                                                musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default2);
                                                break;
                                        }
                                        return unit2;
                                    }
                                });
                                break;
                            }
                            anonymousClass2.L$1 = null;
                            anonymousClass2.L$2 = null;
                            anonymousClass2.L$4 = null;
                            anonymousClass2.label = (byte) 2;
                            if (AwaitKt.delay(3000L, anonymousClass2) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            stateFlowImpl = LyricsTranslationHelper._status;
                            if (stateFlowImpl.getValue() instanceof TranslationStatus.Success) {
                                stateFlowImpl.setValue(idle);
                            }
                            return unit;
                        case 2:
                            ResultKt.throwOnFailure(obj);
                            stateFlowImpl = LyricsTranslationHelper._status;
                            if (stateFlowImpl.getValue() instanceof TranslationStatus.Success) {
                                stateFlowImpl.setValue(idle);
                            }
                            return unit;
                        case 3:
                            str5 = anonymousClass2.L$2;
                            list5 = anonymousClass2.L$1;
                            ResultKt.throwOnFailure(obj);
                            obj4 = ((Result) obj).value;
                            str = str14;
                            str2 = str15;
                            obj3 = null;
                            Object obj11 = obj4;
                            list3 = list5;
                            obj2 = obj11;
                            context2 = context3;
                            list2 = list13;
                            r10 = obj3;
                            str4 = str2;
                            if (Result.m1867isSuccessimpl(obj2)) {
                                list8 = (List) obj2;
                                if (!LyricsTranslationHelper.isCompositionActive) {
                                    LyricsTranslationHelper.translationCache.put(LyricsTranslationHelper.getCacheKey(str5, str, str4), list8);
                                    if (StringsKt.isBlank(str13)) {
                                    }
                                    i = 0;
                                    obj5 = obj2;
                                    list9 = list2;
                                    r12 = r10;
                                    size = list3.size();
                                    if (list8.size() >= size) {
                                        i3 = i;
                                        while (r1.hasNext()) {
                                            i4 = i3 + 1;
                                            if (i3 >= 0) {
                                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                                throw r12;
                                            }
                                            ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                            i3 = i4;
                                        }
                                        LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                        LyricsTranslationHelper._status.setValue(success2);
                                    } else {
                                        success = success2;
                                        if (list8.size() < size) {
                                            it = list8.iterator();
                                            while (true) {
                                                i2 = i;
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    i = i2 + 1;
                                                    if (i2 >= 0) {
                                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                                        throw r12;
                                                    }
                                                    str11 = (String) next;
                                                    if (i2 < list3.size()) {
                                                        ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                    }
                                                } else {
                                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                    LyricsTranslationHelper._status.setValue(success);
                                                }
                                            }
                                        }
                                    }
                                    anonymousClass2.L$1 = r12;
                                    anonymousClass2.L$2 = r12;
                                    anonymousClass2.L$4 = r12;
                                    anonymousClass2.L$6 = r12;
                                    anonymousClass2.L$7 = obj5;
                                    anonymousClass2.L$8 = r12;
                                    anonymousClass2.L$9 = r12;
                                    anonymousClass2.L$10 = r12;
                                    anonymousClass2.L$11 = r12;
                                    anonymousClass2.L$12 = r12;
                                    anonymousClass2.label = (byte) 7;
                                    break;
                                }
                            }
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                            if (thM1866exceptionOrNullimpl != null) {
                                message = thM1866exceptionOrNullimpl.getMessage();
                                if (message == null) {
                                    context = context2;
                                    message = context.getString(R.string.ai_error_unknown);
                                    message.getClass();
                                } else {
                                    context = context2;
                                }
                                LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                break;
                            }
                            return unit;
                        case 4:
                            ref$ObjectRef2 = (Ref$ObjectRef) anonymousClass2.L$8;
                            ref$BooleanRef = (Ref$BooleanRef) anonymousClass2.L$7;
                            Ref$ObjectRef ref$ObjectRef5 = anonymousClass2.L$6;
                            String str30 = anonymousClass2.L$2;
                            list4 = anonymousClass2.L$1;
                            ResultKt.throwOnFailure(obj);
                            ref$ObjectRef = ref$ObjectRef5;
                            str6 = str15;
                            list = list13;
                            strJoinToString$default = str30;
                            str = str14;
                            ConnectionPool connectionPool2 = Timber.Forest;
                            boolean z2 = ref$BooleanRef.element;
                            list7 = (List) ref$ObjectRef.element;
                            if (list7 != null) {
                                Boxing.boxInt(list7.size());
                            }
                            connectionPool2.getClass();
                            ConnectionPool.d(new Object[0]);
                            if (ref$BooleanRef.element) {
                                objCreateFailure = ResultKt.createFailure(new Exception((String) ref$ObjectRef2.element));
                            } else {
                                objCreateFailure = ref$ObjectRef.element;
                                if (objCreateFailure != null) {
                                    objCreateFailure = ResultKt.createFailure(new Exception("No translation received"));
                                }
                            }
                            obj2 = objCreateFailure;
                            str5 = strJoinToString$default;
                            context2 = context3;
                            list3 = list4;
                            list2 = list;
                            r10 = 0;
                            str4 = str6;
                            if (Result.m1867isSuccessimpl(obj2)) {
                                list8 = (List) obj2;
                                if (!LyricsTranslationHelper.isCompositionActive) {
                                    LyricsTranslationHelper.translationCache.put(LyricsTranslationHelper.getCacheKey(str5, str, str4), list8);
                                    if (StringsKt.isBlank(str13)) {
                                    }
                                    i = 0;
                                    obj5 = obj2;
                                    list9 = list2;
                                    r12 = r10;
                                    size = list3.size();
                                    if (list8.size() >= size) {
                                        i3 = i;
                                        while (r1.hasNext()) {
                                            i4 = i3 + 1;
                                            if (i3 >= 0) {
                                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                                throw r12;
                                            }
                                            ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                            i3 = i4;
                                        }
                                        LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                        LyricsTranslationHelper._status.setValue(success2);
                                    } else {
                                        success = success2;
                                        if (list8.size() < size) {
                                            it = list8.iterator();
                                            while (true) {
                                                i2 = i;
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    i = i2 + 1;
                                                    if (i2 >= 0) {
                                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                                        throw r12;
                                                    }
                                                    str11 = (String) next;
                                                    if (i2 < list3.size()) {
                                                        ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                    }
                                                } else {
                                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                    LyricsTranslationHelper._status.setValue(success);
                                                }
                                            }
                                        }
                                    }
                                    anonymousClass2.L$1 = r12;
                                    anonymousClass2.L$2 = r12;
                                    anonymousClass2.L$4 = r12;
                                    anonymousClass2.L$6 = r12;
                                    anonymousClass2.L$7 = obj5;
                                    anonymousClass2.L$8 = r12;
                                    anonymousClass2.L$9 = r12;
                                    anonymousClass2.L$10 = r12;
                                    anonymousClass2.L$11 = r12;
                                    anonymousClass2.L$12 = r12;
                                    anonymousClass2.label = (byte) 7;
                                    break;
                                }
                            }
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                            if (thM1866exceptionOrNullimpl != null) {
                                message = thM1866exceptionOrNullimpl.getMessage();
                                if (message == null) {
                                    context = context2;
                                    message = context.getString(R.string.ai_error_unknown);
                                    message.getClass();
                                } else {
                                    context = context2;
                                }
                                LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                break;
                            }
                            return unit;
                        case 5:
                            str5 = anonymousClass2.L$2;
                            List list16 = anonymousClass2.L$1;
                            ResultKt.throwOnFailure(obj);
                            list3 = list16;
                            obj2 = ((Result) obj).value;
                            str = str14;
                            list2 = list13;
                            context2 = context3;
                            str4 = str15;
                            r10 = 0;
                            if (Result.m1867isSuccessimpl(obj2)) {
                                list8 = (List) obj2;
                                if (!LyricsTranslationHelper.isCompositionActive) {
                                    LyricsTranslationHelper.translationCache.put(LyricsTranslationHelper.getCacheKey(str5, str, str4), list8);
                                    if (StringsKt.isBlank(str13)) {
                                    }
                                    i = 0;
                                    obj5 = obj2;
                                    list9 = list2;
                                    r12 = r10;
                                    size = list3.size();
                                    if (list8.size() >= size) {
                                        i3 = i;
                                        while (r1.hasNext()) {
                                            i4 = i3 + 1;
                                            if (i3 >= 0) {
                                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                                throw r12;
                                            }
                                            ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                            i3 = i4;
                                        }
                                        LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                        LyricsTranslationHelper._status.setValue(success2);
                                    } else {
                                        success = success2;
                                        if (list8.size() < size) {
                                            it = list8.iterator();
                                            while (true) {
                                                i2 = i;
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    i = i2 + 1;
                                                    if (i2 >= 0) {
                                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                                        throw r12;
                                                    }
                                                    str11 = (String) next;
                                                    if (i2 < list3.size()) {
                                                        ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                    }
                                                } else {
                                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                    LyricsTranslationHelper._status.setValue(success);
                                                }
                                            }
                                        }
                                    }
                                    anonymousClass2.L$1 = r12;
                                    anonymousClass2.L$2 = r12;
                                    anonymousClass2.L$4 = r12;
                                    anonymousClass2.L$6 = r12;
                                    anonymousClass2.L$7 = obj5;
                                    anonymousClass2.L$8 = r12;
                                    anonymousClass2.L$9 = r12;
                                    anonymousClass2.L$10 = r12;
                                    anonymousClass2.L$11 = r12;
                                    anonymousClass2.L$12 = r12;
                                    anonymousClass2.label = (byte) 7;
                                    break;
                                }
                            }
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                            if (thM1866exceptionOrNullimpl != null) {
                                message = thM1866exceptionOrNullimpl.getMessage();
                                if (message == null) {
                                    context = context2;
                                    message = context.getString(R.string.ai_error_unknown);
                                    message.getClass();
                                } else {
                                    context = context2;
                                }
                                LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                break;
                            }
                            return unit;
                        case 6:
                            list11 = anonymousClass2.L$12;
                            list9 = anonymousClass2.L$11;
                            musicDatabase = anonymousClass2.L$10;
                            String str31 = anonymousClass2.L$9;
                            String str32 = (String) anonymousClass2.L$8;
                            obj2 = anonymousClass2.L$7;
                            list3 = anonymousClass2.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                list12 = list11;
                                str9 = str32;
                                str10 = str31;
                                context2 = context3;
                                idle = idle;
                                success2 = success2;
                                objFirst2 = obj;
                                r13 = 0;
                                lyricsEntity2 = (LyricsEntity) objFirst2;
                                if (lyricsEntity2 != null) {
                                    final byte b5 = 1;
                                    musicDatabase.query(new Function1() { // from class: com.metrolist.music.lyrics.LyricsTranslationHelper$translateLyrics$2$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj12) {
                                            byte b6 = b5;
                                            Unit unit2 = Unit.INSTANCE;
                                            String str110 = str9;
                                            String str210 = str10;
                                            LyricsEntity lyricsEntity3 = lyricsEntity2;
                                            MusicDatabase musicDatabase2 = (MusicDatabase) obj12;
                                            switch (b6) {
                                                case 0:
                                                    LyricsEntity lyricsEntityCopy$default = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list12, "\n", null, null, null, 62), str210, str110);
                                                    musicDatabase2.getClass();
                                                    musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default);
                                                    break;
                                                default:
                                                    LyricsEntity lyricsEntityCopy$default2 = LyricsEntity.copy$default(lyricsEntity3, CollectionsKt.joinToString$default(list12, "\n", null, null, null, 62), str210, str110);
                                                    musicDatabase2.getClass();
                                                    musicDatabase2.$$delegate_0.upsert(lyricsEntityCopy$default2);
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    });
                                }
                                obj5 = obj2;
                                list8 = list12;
                                i = 0;
                                r12 = r13;
                            } catch (Exception unused5) {
                                context2 = context3;
                                idle = idle;
                                success2 = success2;
                                r11 = 0;
                                i = 0;
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                                list8 = list11;
                                obj5 = obj2;
                                r12 = r11;
                                size = list3.size();
                                if (list8.size() >= size) {
                                    i3 = i;
                                    while (r1.hasNext()) {
                                        i4 = i3 + 1;
                                        if (i3 >= 0) {
                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                            throw r12;
                                        }
                                        ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                        i3 = i4;
                                    }
                                    LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                    LyricsTranslationHelper._status.setValue(success2);
                                } else {
                                    success = success2;
                                    if (list8.size() < size) {
                                        it = list8.iterator();
                                        while (true) {
                                            i2 = i;
                                            if (it.hasNext()) {
                                                next = it.next();
                                                i = i2 + 1;
                                                if (i2 >= 0) {
                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                    throw r12;
                                                }
                                                str11 = (String) next;
                                                if (i2 < list3.size()) {
                                                    ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                                }
                                            } else {
                                                LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                                LyricsTranslationHelper._status.setValue(success);
                                            }
                                        }
                                    }
                                }
                                anonymousClass2.L$1 = r12;
                                anonymousClass2.L$2 = r12;
                                anonymousClass2.L$4 = r12;
                                anonymousClass2.L$6 = r12;
                                anonymousClass2.L$7 = obj5;
                                anonymousClass2.L$8 = r12;
                                anonymousClass2.L$9 = r12;
                                anonymousClass2.L$10 = r12;
                                anonymousClass2.L$11 = r12;
                                anonymousClass2.L$12 = r12;
                                anonymousClass2.label = (byte) 7;
                            }
                            size = list3.size();
                            if (list8.size() >= size) {
                                i3 = i;
                                while (r1.hasNext()) {
                                    i4 = i3 + 1;
                                    if (i3 >= 0) {
                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                        throw r12;
                                    }
                                    ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) obj10).first).intValue())).translatedTextFlow).setValue(list8.get(i3));
                                    i3 = i4;
                                }
                                LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                LyricsTranslationHelper._status.setValue(success2);
                            } else {
                                success = success2;
                                if (list8.size() < size) {
                                    it = list8.iterator();
                                    while (true) {
                                        i2 = i;
                                        if (it.hasNext()) {
                                            next = it.next();
                                            i = i2 + 1;
                                            if (i2 >= 0) {
                                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                                throw r12;
                                            }
                                            str11 = (String) next;
                                            if (i2 < list3.size()) {
                                                ((StateFlowImpl) ((LyricsEntry) list9.get(((Number) ((Pair) list3.get(i2)).first).intValue())).translatedTextFlow).setValue(str11);
                                            }
                                        } else {
                                            LyricsTranslationHelper._hasActiveTranslations.setValue(Boolean.TRUE);
                                            LyricsTranslationHelper._status.setValue(success);
                                        }
                                    }
                                }
                            }
                            anonymousClass2.L$1 = r12;
                            anonymousClass2.L$2 = r12;
                            anonymousClass2.L$4 = r12;
                            anonymousClass2.L$6 = r12;
                            anonymousClass2.L$7 = obj5;
                            anonymousClass2.L$8 = r12;
                            anonymousClass2.L$9 = r12;
                            anonymousClass2.L$10 = r12;
                            anonymousClass2.L$11 = r12;
                            anonymousClass2.L$12 = r12;
                            anonymousClass2.label = (byte) 7;
                            break;
                        case 7:
                            obj5 = anonymousClass2.L$7;
                            ResultKt.throwOnFailure(obj);
                            context2 = context3;
                            idle = idle;
                            StateFlowImpl stateFlowImpl6 = LyricsTranslationHelper._status;
                            if ((stateFlowImpl6.getValue() instanceof TranslationStatus.Success) && LyricsTranslationHelper.isCompositionActive) {
                                stateFlowImpl6.setValue(idle);
                            }
                            obj2 = obj5;
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                            if (thM1866exceptionOrNullimpl != null) {
                                message = thM1866exceptionOrNullimpl.getMessage();
                                if (message == null) {
                                    context = context2;
                                    message = context.getString(R.string.ai_error_unknown);
                                    message.getClass();
                                } else {
                                    context = context2;
                                }
                                LyricsTranslationHelper._status.setValue(new TranslationStatus.Error(message));
                                break;
                            }
                            return unit;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (Exception unused6) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
                context = context3;
            }
        }
    }

    static {
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(TranslationStatus.Idle.INSTANCE);
        _status = stateFlowImplMutableStateFlow;
        status = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        _hasActiveTranslations = stateFlowImplMutableStateFlow2;
        hasActiveTranslations = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default = StateFlowKt.MutableSharedFlow$default(1, 5, null);
        _manualTrigger = sharedFlowImplMutableSharedFlow$default;
        manualTrigger = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow$default);
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default2 = StateFlowKt.MutableSharedFlow$default(1, 5, null);
        _clearTranslationsTrigger = sharedFlowImplMutableSharedFlow$default2;
        clearTranslationsTrigger = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow$default2);
        isCompositionActive = true;
        translationCache = new ConcurrentHashMap();
        LanguageCodeToName = MapsKt__MapsKt.mapOf(new Pair("en", "English"), new Pair("es", "Spanish"), new Pair("fr", "French"), new Pair("de", "German"), new Pair("it", "Italian"), new Pair("pt", "Portuguese"), new Pair("ru", "Russian"), new Pair("ja", "Japanese"), new Pair("ko", "Korean"), new Pair("zh", "Chinese"), new Pair("ar", "Arabic"), new Pair("hi", "Hindi"), new Pair("bn", "Bengali"), new Pair("pa", "Punjabi"), new Pair("tr", "Turkish"), new Pair("vi", "Vietnamese"), new Pair("th", "Thai"), new Pair("id", "Indonesian"), new Pair("pl", "Polish"), new Pair("nl", "Dutch"), new Pair("sv", "Swedish"), new Pair("uk", "Ukrainian"));
    }

    public static void cancelTranslation() {
        StandaloneCoroutine standaloneCoroutine = translationJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        StateFlowImpl stateFlowImpl = _status;
        if (stateFlowImpl.getValue() instanceof TranslationStatus.Translating) {
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, TranslationStatus.Idle.INSTANCE);
        }
    }

    public static String getCacheKey(String str, String str2, String str3) {
        return str.hashCode() + "_" + str2 + "_" + str3;
    }

    public static void loadTranslationsFromDatabase(List list, LyricsEntity lyricsEntity, String str, String str2) {
        String str3;
        list.getClass();
        str.getClass();
        str2.getClass();
        StateFlowImpl stateFlowImpl = _hasActiveTranslations;
        if (lyricsEntity == null || (str3 = lyricsEntity.translatedLyrics) == null || StringsKt.isBlank(str3)) {
            Boolean bool = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((StateFlowImpl) ((LyricsEntry) it.next()).translatedTextFlow).setValue(null);
            }
            return;
        }
        if (!Intrinsics.areEqual(lyricsEntity.translationLanguage, str) || !Intrinsics.areEqual(lyricsEntity.translationMode, str2)) {
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool2);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((StateFlowImpl) ((LyricsEntry) it2.next()).translatedTextFlow).setValue(null);
            }
            return;
        }
        int i = 0;
        List listSplit$default = StringsKt.split$default(str3, new String[]{"\n"}, 0, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.isBlank(((LyricsEntry) obj).text)) {
                arrayList.add(obj);
            }
        }
        if (listSplit$default.size() >= arrayList.size()) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                LyricsEntry lyricsEntry = (LyricsEntry) it3.next();
                if (!StringsKt.isBlank(lyricsEntry.text) && i < listSplit$default.size()) {
                    ((StateFlowImpl) lyricsEntry.translatedTextFlow).setValue(listSplit$default.get(i));
                    i++;
                }
            }
            translationCache.put(getCacheKey(CollectionsKt.joinToString$default(arrayList, "\n", null, null, new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 10), 30), str2, str), listSplit$default);
            Boolean bool3 = Boolean.TRUE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool3);
        }
    }

    public static void translateLyrics(List list, String str, String str2, String str3, String str4, String str5, CoroutineScope coroutineScope, Context context, String str6, String str7, String str8, String str9, MusicDatabase musicDatabase, String str10) {
        list.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        coroutineScope.getClass();
        context.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str10.getClass();
        StandaloneCoroutine standaloneCoroutine = translationJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        StateFlowImpl stateFlowImpl = _status;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, TranslationStatus.Translating.INSTANCE);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((StateFlowImpl) ((LyricsEntry) it.next()).translatedTextFlow).setValue(null);
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        translationJob = AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new AnonymousClass2(str6, str7, str2, context, list, str5, str, str9, musicDatabase, str8, str3, str4, str10, null), 2);
    }
}
