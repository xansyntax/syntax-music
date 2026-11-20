package com.metrolist.innertubex.cipher;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlin.time.InstantJvmKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeCipherService$processCanonicalFormats$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $cipherFormats;
    public final /* synthetic */ ArrayList $directNValues;
    public final /* synthetic */ List $formats;
    public final /* synthetic */ int $nFormats;
    public final /* synthetic */ String $playerUrl;
    public int I$0;
    public int I$1;
    public long J$0;
    public long J$1;
    public Mutex L$0;
    public YouTubeCipherService L$1;
    public List L$12;
    public Ref$ObjectRef L$13;
    public YouTubeCipherService.RemoteSolveResult L$14;
    public Map L$17;
    public Object L$18;
    public List L$19;
    public List L$2;
    public Object L$20;
    public Object L$21;
    public Object L$22;
    public List L$23;
    public List L$24;
    public YouTubeCipherService.CachedSolver L$25;
    public Iterator L$26;
    public String L$3;
    public List L$4;
    public Object L$5;
    public Ref$ObjectRef L$6;
    public List L$7;
    public List L$8;
    public byte label;
    public final /* synthetic */ YouTubeCipherService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTubeCipherService$processCanonicalFormats$2(YouTubeCipherService youTubeCipherService, List list, int i, int i2, String str, ArrayList arrayList, Continuation continuation) {
        super(2, continuation);
        this.this$0 = youTubeCipherService;
        this.$formats = list;
        this.$cipherFormats = i;
        this.$nFormats = i2;
        this.$playerUrl = str;
        this.$directNValues = arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object invokeSuspend$lambda$0$playerCode(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, YouTubeCipherService youTubeCipherService, String str, ContinuationImpl continuationImpl) throws IOException {
        YouTubeCipherService$processCanonicalFormats$2$1$playerCode$1 youTubeCipherService$processCanonicalFormats$2$1$playerCode$1;
        long epochMilliseconds;
        Exception e;
        String strM;
        if (continuationImpl instanceof YouTubeCipherService$processCanonicalFormats$2$1$playerCode$1) {
            youTubeCipherService$processCanonicalFormats$2$1$playerCode$1 = (YouTubeCipherService$processCanonicalFormats$2$1$playerCode$1) continuationImpl;
            int i = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.label = i - Integer.MIN_VALUE;
            } else {
                youTubeCipherService$processCanonicalFormats$2$1$playerCode$1 = new YouTubeCipherService$processCanonicalFormats$2$1$playerCode$1(continuationImpl);
            }
        } else {
            youTubeCipherService$processCanonicalFormats$2$1$playerCode$1 = new YouTubeCipherService$processCanonicalFormats$2$1$playerCode$1(continuationImpl);
        }
        Object orDownloadPlayerCode = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.result;
        int i2 = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(orDownloadPlayerCode);
                YouTubeCipherService.PlayerCodeResult playerCodeResult = (YouTubeCipherService.PlayerCodeResult) ref$ObjectRef.element;
                if (playerCodeResult != null) {
                    return playerCodeResult.code;
                }
                if (((Throwable) ref$ObjectRef2.element) != null) {
                    return null;
                }
                try {
                    epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
                    youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$0 = ref$ObjectRef;
                    youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$1 = ref$ObjectRef2;
                    youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$2 = youTubeCipherService;
                    youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$3 = str;
                    youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.J$0 = epochMilliseconds;
                    youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.label = 1;
                    Regex regex = YouTubeCipherService.N_PARAMETER_REGEX;
                    orDownloadPlayerCode = youTubeCipherService.getOrDownloadPlayerCode(str, youTubeCipherService$processCanonicalFormats$2$1$playerCode$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (orDownloadPlayerCode == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Exception e2) {
                    e = e2;
                    ref$ObjectRef2.element = e;
                    PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = youTubeCipherService.logger;
                    String strLogId = YouTubeCipherService.logId(str);
                    strM = Format$$ExternalSyntheticOutline0.m(e);
                    if (strM == null) {
                        strM = "Exception";
                    }
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "YouTubeCipherService", "player JS unavailable, challenges unsolvable player=" + strLogId + " type=" + strM, null, 12);
                    return null;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                long j = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.J$0;
                str = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$3;
                youTubeCipherService = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$2;
                Ref$ObjectRef ref$ObjectRef3 = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$1;
                Ref$ObjectRef ref$ObjectRef4 = youTubeCipherService$processCanonicalFormats$2$1$playerCode$1.L$0;
                try {
                    ResultKt.throwOnFailure(orDownloadPlayerCode);
                    epochMilliseconds = j;
                    ref$ObjectRef = ref$ObjectRef4;
                    ref$ObjectRef2 = ref$ObjectRef3;
                } catch (Exception e3) {
                    e = e3;
                    ref$ObjectRef2 = ref$ObjectRef3;
                    ref$ObjectRef2.element = e;
                    PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = youTubeCipherService.logger;
                    String strLogId2 = YouTubeCipherService.logId(str);
                    strM = Format$$ExternalSyntheticOutline0.m(e);
                    if (strM == null) {
                        strM = "Exception";
                    }
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "YouTubeCipherService", "player JS unavailable, challenges unsolvable player=" + strLogId2 + " type=" + strM, null, 12);
                    return null;
                }
            }
            YouTubeCipherService.PlayerCodeResult playerCodeResult2 = (YouTubeCipherService.PlayerCodeResult) orDownloadPlayerCode;
            ref$ObjectRef.element = playerCodeResult2;
            PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline2 = youTubeCipherService.logger;
            String str2 = playerCodeResult2.source;
            String str3 = playerCodeResult2.code;
            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline2, "YouTubeCipherService", "player JS ready source=" + str2 + " size=" + str3.length() + " elapsed=" + (InstantJvmKt.systemClock.now().toEpochMilliseconds() - epochMilliseconds) + "ms player=" + YouTubeCipherService.logId(str), null, 12);
            return str3;
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new YouTubeCipherService$processCanonicalFormats$2(this.this$0, this.$formats, this.$cipherFormats, this.$nFormats, this.$playerUrl, this.$directNValues, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((YouTubeCipherService$processCanonicalFormats$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:316:0x0df0 A[Catch: all -> 0x0e94, TRY_LEAVE, TryCatch #22 {all -> 0x0e94, blocks: (B:314:0x0dea, B:316:0x0df0), top: B:610:0x0dea }] */
    /* JADX WARN: Code duplicated, block: B:321:0x0e5d  */
    /* JADX WARN: Code duplicated, block: B:322:0x0e60  */
    /* JADX WARN: Code duplicated, block: B:89:0x06c3 A[Catch: all -> 0x06cd, TryCatch #15 {all -> 0x06cd, blocks: (B:474:0x14d7, B:477:0x14df, B:468:0x1494, B:470:0x1498, B:70:0x066e, B:72:0x067e, B:75:0x068b, B:77:0x0695, B:79:0x069d, B:81:0x06a6, B:83:0x06b0, B:89:0x06c3, B:96:0x06da, B:98:0x06de, B:101:0x06e5, B:103:0x06ef, B:105:0x06f7, B:107:0x06fe, B:109:0x0706, B:114:0x0713, B:120:0x073b, B:122:0x074f, B:127:0x0764, B:129:0x077a, B:132:0x0782, B:137:0x07af, B:140:0x07b6, B:52:0x05b8), top: B:599:0x05b8 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [com.metrolist.innertubex.cipher.EjsChallengeSolver] */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v294 */
    /* JADX WARN: Type inference failed for: r1v295 */
    /* JADX WARN: Type inference failed for: r41v4, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:322:0x0e60 -> B:597:0x0e72). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:486:0x1555 -> B:572:0x1558). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r50) {
        /*
            Method dump skipped, instruction units count: 6064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.cipher.YouTubeCipherService$processCanonicalFormats$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
