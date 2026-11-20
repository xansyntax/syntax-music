package com.metrolist.music.api;

import java.io.BufferedReader;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OpenRouterStreamingService$streamTranslation$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $apiKey;
    public final /* synthetic */ String $baseUrl;
    public final /* synthetic */ String $customSystemPrompt;
    public final /* synthetic */ String $mode;
    public final /* synthetic */ String $model;
    public final /* synthetic */ String $targetLanguage;
    public final /* synthetic */ String $text;
    public /* synthetic */ Object L$0;
    public Closeable L$3;
    public String L$4;
    public Object L$6;
    public Closeable L$7;
    public BufferedReader L$8;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenRouterStreamingService$streamTranslation$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, Continuation continuation) {
        super(2, continuation);
        this.$text = str;
        this.$targetLanguage = str2;
        this.$model = str3;
        this.$mode = str4;
        this.$customSystemPrompt = str5;
        this.$baseUrl = str6;
        this.$apiKey = str7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OpenRouterStreamingService$streamTranslation$1 openRouterStreamingService$streamTranslation$1 = new OpenRouterStreamingService$streamTranslation$1(this.$text, this.$targetLanguage, this.$model, this.$mode, this.$customSystemPrompt, this.$baseUrl, this.$apiKey, continuation);
        openRouterStreamingService$streamTranslation$1.L$0 = obj;
        return openRouterStreamingService$streamTranslation$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OpenRouterStreamingService$streamTranslation$1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x017b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0175 A[Catch: all -> 0x020d, TryCatch #8 {all -> 0x020d, blocks: (B:58:0x016d, B:61:0x0175, B:63:0x017b, B:79:0x01d6, B:82:0x01dc, B:84:0x01e0, B:78:0x01d0, B:65:0x0187, B:67:0x019b, B:69:0x01a7, B:71:0x01b5, B:73:0x01c3), top: B:137:0x016d, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x019b A[Catch: all -> 0x01cc, TryCatch #6 {all -> 0x01cc, blocks: (B:65:0x0187, B:67:0x019b, B:69:0x01a7, B:71:0x01b5, B:73:0x01c3), top: B:133:0x0187, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01db  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ff  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x01ff -> B:88:0x0205). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.api.OpenRouterStreamingService$streamTranslation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
