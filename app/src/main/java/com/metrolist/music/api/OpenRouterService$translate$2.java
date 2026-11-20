package com.metrolist.music.api;

import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OpenRouterService$translate$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $apiKey;
    public final /* synthetic */ String $baseUrl;
    public final /* synthetic */ String $customSystemPrompt;
    public final /* synthetic */ byte $maxRetries;
    public final /* synthetic */ String $mode;
    public final /* synthetic */ String $model;
    public final /* synthetic */ String $targetLanguage;
    public final /* synthetic */ String $text;
    public int I$0;
    public int I$1;
    public int I$2;
    public String L$0;
    public String L$1;
    public String L$2;
    public String L$3;
    public String L$4;
    public String L$5;
    public String L$6;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OpenRouterService$translate$2(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, Continuation continuation) {
        super(2, continuation);
        this.$text = str;
        this.$maxRetries = i;
        this.$targetLanguage = str2;
        this.$model = str3;
        this.$mode = str4;
        this.$customSystemPrompt = str5;
        this.$baseUrl = str6;
        this.$apiKey = str7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OpenRouterService$translate$2(this.$text, this.$maxRetries, this.$targetLanguage, this.$model, this.$mode, this.$customSystemPrompt, this.$baseUrl, this.$apiKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OpenRouterService$translate$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:98|14|15|(1:17)(1:18)|19|99|20|(1:22)(1:23)|24|(1:26)|29|30|104|31|97|32|(3:108|33|(3:102|35|(3:37|38|39)(2:43|44))(10:45|46|(1:48)|49|(9:51|52|106|53|(0)(1:59)|(1:67)(1:68)|69|70|71)(1:64)|65|(1:67)(1:68)|69|70|71))|61|95|74) */
    /* JADX WARN: Code duplicated, block: B:102:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0074  */
    /* JADX WARN: Code duplicated, block: B:18:0x0077  */
    /* JADX WARN: Code duplicated, block: B:22:0x008b  */
    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0099 A[Catch: Exception -> 0x00b8, CancellationException -> 0x01fe, TryCatch #2 {CancellationException -> 0x01fe, blocks: (B:14:0x006a, B:20:0x007c, B:24:0x0090, B:26:0x0099, B:29:0x00bc, B:31:0x00f2, B:32:0x00f5, B:38:0x0131, B:70:0x01a9, B:76:0x01b1, B:77:0x01b4), top: B:98:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0111 A[Catch: all -> 0x0139, TRY_LEAVE, TryCatch #5 {all -> 0x0139, blocks: (B:35:0x0103, B:37:0x0111, B:43:0x013b, B:44:0x0140), top: B:102:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x013b A[Catch: all -> 0x0139, TRY_ENTER, TryCatch #5 {all -> 0x0139, blocks: (B:35:0x0103, B:37:0x0111, B:43:0x013b, B:44:0x0140), top: B:102:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0141 A[Catch: all -> 0x018f, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x018f, blocks: (B:33:0x00f9, B:45:0x0141, B:49:0x0148, B:51:0x015a), top: B:108:0x00f9 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0147  */
    /* JADX WARN: Code duplicated, block: B:51:0x015a A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #8 {all -> 0x018f, blocks: (B:33:0x00f9, B:45:0x0141, B:49:0x0148, B:51:0x015a), top: B:108:0x00f9 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0167 A[Catch: all -> 0x018c, TryCatch #7 {all -> 0x018c, blocks: (B:53:0x015f, B:55:0x0167, B:57:0x0175, B:59:0x0183, B:69:0x0198), top: B:106:0x015f }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0192  */
    /* JADX WARN: Code duplicated, block: B:67:0x0196  */
    /* JADX WARN: Code duplicated, block: B:68:0x0197  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:93:0x0200  */
    /* JADX WARN: Code duplicated, block: B:98:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ad, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01b5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b9, code lost:
    
        r20 = r10;
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c0, code lost:
    
        if (r5 == (r13 - 1)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01cc, code lost:
    
        return new kotlin.Result(new kotlin.Result.Failure(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01cd, code lost:
    
        r19.L$0 = r6;
        r19.L$1 = r7;
        r19.L$2 = r8;
        r19.L$3 = r9;
        r19.L$4 = r10;
        r2 = r20;
        r19.L$5 = r2;
        r19.L$6 = r15;
        r19.I$0 = r14;
        r19.I$1 = r13;
        r19.I$2 = r5;
        r19.label = true;
        r0 = kotlinx.coroutines.AwaitKt.delay(((long) (r5 + 1)) * 1000, r19);
        r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01f3, code lost:
    
        if (r0 == r11) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01f5, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f6, code lost:
    
        r0 = r5;
        r11 = r10;
        r10 = r2;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0099, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x0111, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x01f6 -> B:90:0x01f9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        int i;
        int i2;
        String str2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Throwable th;
        String contentOrNull;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            String str10 = this.$text;
            if (StringsKt.isBlank(str10)) {
                return new Result(new Result.Failure(new Exception("Input text is empty")));
            }
            byte b = this.$maxRetries;
            String str11 = this.$targetLanguage;
            String str12 = this.$model;
            String str13 = this.$mode;
            String str14 = this.$customSystemPrompt;
            str = this.$baseUrl;
            i = b;
            i2 = i;
            str2 = this.$apiKey;
            i3 = 0;
            str3 = str14;
            str4 = str13;
            str5 = str12;
            str6 = str11;
            str7 = str10;
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i4 = this.I$2;
            int i5 = this.I$1;
            int i6 = this.I$0;
            String str15 = this.L$6;
            String str16 = this.L$5;
            String str17 = this.L$4;
            String str18 = this.L$3;
            String str19 = this.L$2;
            String str20 = this.L$1;
            String str21 = this.L$0;
            ResultKt.throwOnFailure(obj);
            str = str16;
            str5 = str19;
            str3 = str17;
            str4 = str18;
            i2 = i6;
            str2 = str15;
            str6 = str20;
            str7 = str21;
            i = i5;
            i3 = i4 + 1;
        }
        if (i3 >= i2) {
            return new Result(new Result.Failure(new Exception("Max retries exceeded")));
        }
        try {
            boolean zIsBlank = StringsKt.isBlank(str);
            String str22 = str;
            String str23 = str3;
            if (zIsBlank) {
                str8 = "https://openrouter.ai/api/v1/chat/completions";
            } else {
                str8 = str22;
            }
            String str24 = str22;
            JsonObject jsonObjectBuildTranslationRequest = OpenRouterServiceKt.buildTranslationRequest(str7, str6, str5, str4, str23, str8, false);
            Request.Builder builder = new Request.Builder();
            if (StringsKt.isBlank(str24)) {
                str9 = "https://openrouter.ai/api/v1/chat/completions";
            } else {
                str9 = str24;
            }
            builder.url(str9);
            if (!StringsKt.isBlank(str2)) {
                builder.addHeader(HttpHeaders.Authorization, "Bearer " + StringsKt.trim(str2).toString());
            }
            builder.addHeader(HttpHeaders.ContentType, "application/json");
            builder.addHeader("HTTP-Referer", "https://github.com/MetrolistGroup/Metrolist");
            builder.addHeader("X-Title", "Auralys");
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObjectBuildTranslationRequest.toString();
            MediaType mediaType = OpenRouterService.jsonMediaType;
            companion.getClass();
            builder.method("POST", RequestBody.Companion.create(string, mediaType));
            Request request = new Request(builder);
            OkHttpClient okHttpClient = OpenRouterService.client;
            okHttpClient.getClass();
            Response responseExecute = new RealCall(okHttpClient, request, false).execute();
            try {
                String strString = responseExecute.body.string();
                if (responseExecute.isSuccessful) {
                    JsonImpl jsonImpl = OpenRouterServiceKt.translationJson;
                    String str25 = "";
                    if (strString == null) {
                        strString = "";
                    }
                    JsonElement jsonElement3 = (JsonElement) JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(strString)).get("choices");
                    if (jsonElement3 != null) {
                        try {
                            JsonElement jsonElement4 = (JsonElement) CollectionsKt.getOrNull(0, JsonElementKt.getJsonArray(jsonElement3));
                            if (jsonElement4 == null && (jsonElement = (JsonElement) JsonElementKt.getJsonObject(jsonElement4).get(ContentType.Message.TYPE)) != null && (jsonElement2 = (JsonElement) JsonElementKt.getJsonObject(jsonElement).get("content")) != null) {
                                contentOrNull = JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement2));
                            }
                            if (contentOrNull == null) {
                                str25 = contentOrNull;
                            }
                            Result result = new Result(OpenRouterServiceKt.parseTranslationContent(StringsKt.lines(str7).size(), str25));
                            responseExecute.close();
                            return result;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    contentOrNull = null;
                    if (contentOrNull == null) {
                        str25 = contentOrNull;
                    }
                    Result result2 = new Result(OpenRouterServiceKt.parseTranslationContent(StringsKt.lines(str7).size(), str25));
                    responseExecute.close();
                    return result2;
                }
                try {
                    String strApiErrorMessage = OpenRouterServiceKt.apiErrorMessage(responseExecute.code, strString, responseExecute.message);
                    if (responseExecute.code >= 500) {
                        throw new Exception(strApiErrorMessage);
                    }
                    Result result3 = new Result(new Result.Failure(new Exception("Translation failed: " + strApiErrorMessage)));
                    responseExecute.close();
                    return result3;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
            th = th;
            try {
                throw th;
            } catch (Throwable th5) {
                CharsKt.closeFinally(responseExecute, th);
                throw th5;
            }
        } catch (CancellationException e) {
            throw e;
        }
    }
}
