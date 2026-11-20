package com.metrolist.music.utils.potoken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
@DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1", f = "PoTokenWebView.kt", l = {}, m = "invokeSuspend", v = 2)
public final class PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ PoTokenWebView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1(PoTokenWebView poTokenWebView, Continuation continuation) {
        super(2, continuation);
        this.this$0 = poTokenWebView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        InputStream inputStreamOpen = this.this$0.webView.getContext().getAssets().open("po_token.html");
        inputStreamOpen.getClass();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
        try {
            String text = RegexKt.readText(bufferedReader);
            bufferedReader.close();
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }
}
