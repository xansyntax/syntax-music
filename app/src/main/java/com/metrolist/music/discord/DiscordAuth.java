package com.metrolist.music.discord;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Base64;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.decoder.DecoderException;
import androidx.navigationevent.NavigationEvent_androidKt;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.request.forms.FormBuildersKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import j$.net.URLEncoder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.TimeoutCancellationException;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAuth {
    public final HttpClient httpClient;

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordAuth$authorize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public PkcePair L$1;
        public String L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordAuth.this.authorize(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordAuth$performTokenExchange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01401 extends ContinuationImpl {
        public String L$0;
        public HttpStatusCode L$3;
        public int label;
        public /* synthetic */ Object result;

        public C01401(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordAuth.this.performTokenExchange(null, null, this);
        }
    }

    public DiscordAuth() {
        HttpClient HttpClient = HttpClientKt.HttpClient(OkHttp.INSTANCE, new DiscordAuth$Companion$$ExternalSyntheticLambda0((byte) 0));
        HttpClient.getClass();
        this.httpClient = HttpClient;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    public final Object authorize(Activity activity, ContinuationImpl continuationImpl) throws JSONException, NoSuchAlgorithmException, DecoderException {
        AnonymousClass1 anonymousClass1;
        ActivityOptions activityOptionsMakeBasic;
        String str;
        PkcePair pkcePair;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    byte[] bArr = new byte[64];
                    new SecureRandom().nextBytes(bArr);
                    String strEncodeToString = Base64.encodeToString(bArr, 11);
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    strEncodeToString.getClass();
                    Charset charset = StandardCharsets.UTF_8;
                    charset.getClass();
                    byte[] bytes = strEncodeToString.getBytes(charset);
                    bytes.getClass();
                    String strEncodeToString2 = Base64.encodeToString(messageDigest.digest(bytes), 11);
                    strEncodeToString2.getClass();
                    PkcePair pkcePair2 = new PkcePair(strEncodeToString, strEncodeToString2);
                    byte[] bArr2 = new byte[16];
                    new SecureRandom().nextBytes(bArr2);
                    String strEncodeToString3 = Base64.encodeToString(bArr2, 11);
                    strEncodeToString3.getClass();
                    CompletableDeferredImpl completableDeferredImpl = DiscordOAuthActivity.deferred;
                    DiscordOAuthActivity.deferred = AwaitKt.CompletableDeferred$default();
                    StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("https://discord.com/oauth2/authorize?client_id=1447278780795064401&response_type=code&redirect_uri=", URLEncoder.encode("metrolistdiscord://oauth2/callback", charset.name()), "&scope=", URLEncoder.encode("openid sdk.social_layer_presence", charset.name()), "&state=");
                    sbM.append(strEncodeToString3);
                    sbM.append("&code_challenge_method=S256&code_challenge=");
                    sbM.append(strEncodeToString2);
                    String string = sbM.toString();
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.i(StringsKt.take(8, String.valueOf((Object) 1447278780795064401L)));
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                        Bundle bundle = new Bundle();
                        bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                        intent.putExtras(bundle);
                    }
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.putExtras(new Bundle());
                    intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
                    LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
                    String languageTag = adjustedDefault.size() > 0 ? adjustedDefault.get(0).toLanguageTag() : null;
                    if (!TextUtils.isEmpty(languageTag)) {
                        Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
                        if (!bundleExtra.containsKey(HttpHeaders.AcceptLanguage)) {
                            bundleExtra.putString(HttpHeaders.AcceptLanguage, languageTag);
                            intent.putExtra("com.android.browser.headers", bundleExtra);
                        }
                    }
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 34) {
                        activityOptionsMakeBasic = ActivityOptions.makeBasic();
                        TextViewCompat$Api34Impl.setShareIdentityEnabled(activityOptionsMakeBasic);
                    } else {
                        activityOptionsMakeBasic = null;
                    }
                    if (i3 >= 36) {
                        if (activityOptionsMakeBasic == null) {
                            activityOptionsMakeBasic = ActivityOptions.makeBasic();
                        }
                        NavigationEvent_androidKt.setAllowPassThroughOnTouchOutside(activityOptionsMakeBasic, !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
                    }
                    if (activityOptionsMakeBasic != null) {
                        activityOptionsMakeBasic.toBundle();
                    }
                    intent.setData(Uri.parse(string));
                    intent.addFlags(1073741824);
                    intent.addFlags(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
                    try {
                        activity.startActivity(intent);
                        anonymousClass1.L$1 = pkcePair2;
                        anonymousClass1.L$2 = strEncodeToString3;
                        anonymousClass1.label = 1;
                        Object objAwaitCode = CharsKt.awaitCode(anonymousClass1);
                        if (objAwaitCode != obj2) {
                            str = strEncodeToString3;
                            obj = objAwaitCode;
                            pkcePair = pkcePair2;
                        }
                    } catch (ActivityNotFoundException unused) {
                        Timber.Forest.tag("DiscordSvc");
                        ConnectionPool.w$1(new Object[0]);
                        throw new DiscordAuthException$NoBrowser("No browser available", null);
                    }
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = anonymousClass1.L$2;
                pkcePair = anonymousClass1.L$1;
                ResultKt.throwOnFailure(obj);
                AuthCodeResult authCodeResult = (AuthCodeResult) obj;
                if (!authCodeResult.state.equals(str)) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.w(StringsKt.take(8, str), StringsKt.take(8, authCodeResult.state));
                    throw new DiscordAuthException$StateMismatch("OAuth state mismatch", null);
                }
                String str2 = authCodeResult.code;
                String str3 = pkcePair.verifier;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.label = 2;
                Object objPerformTokenExchange = performTokenExchange("authorization_code", ParametersKt.parameters(new DiscordAuth$$ExternalSyntheticLambda1(str2, str3, (byte) 0)), anonymousClass1);
                return objPerformTokenExchange == obj2 ? obj2 : objPerformTokenExchange;
            } catch (Throwable th) {
                throw th;
            }
        } catch (TimeoutCancellationException unused2) {
            final int i4 = 0;
            throw new DecoderException(i4) { // from class: com.metrolist.music.discord.DiscordAuthException$UserCancelled
                {
                    super("User cancelled authorization", null);
                }
            };
        } catch (CancellationException unused3) {
            Timber.Forest.tag("DiscordSvc");
            final int i5 = 0;
            ConnectionPool.i(new Object[0]);
            throw new DecoderException(i5) { // from class: com.metrolist.music.discord.DiscordAuthException$UserCancelled
                {
                    super("User cancelled authorization", null);
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object performTokenExchange(String str, Parameters parameters, ContinuationImpl continuationImpl) throws JSONException, DiscordAuthException$NetworkFailure, DiscordAuthException$InvalidGrant {
        C01401 c01401;
        String str2;
        HttpStatusCode status;
        String str3;
        Object obj;
        String str4;
        int value;
        Object failure;
        String str5;
        if (continuationImpl instanceof C01401) {
            c01401 = (C01401) continuationImpl;
            int i = c01401.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01401.label = i - Integer.MIN_VALUE;
            } else {
                c01401 = new C01401(continuationImpl);
            }
        } else {
            c01401 = new C01401(continuationImpl);
        }
        C01401 c01402 = c01401;
        Object objSubmitForm$default = c01402.result;
        int i2 = c01402.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSubmitForm$default);
            Parameters parameters2 = ParametersKt.parameters(new QuickJs$$ExternalSyntheticLambda1(str, parameters, (byte) 21));
            c01402.L$0 = str;
            c01402.label = 1;
            objSubmitForm$default = FormBuildersKt.submitForm$default(this.httpClient, "https://discord.com/api/v10/oauth2/token", parameters2, false, null, c01402, 12, null);
            if (objSubmitForm$default != coroutineSingletons) {
                str2 = str;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            str2 = c01402.L$0;
            ResultKt.throwOnFailure(objSubmitForm$default);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            HttpStatusCode httpStatusCode = c01402.L$3;
            String str6 = c01402.L$0;
            ResultKt.throwOnFailure(objSubmitForm$default);
            status = httpStatusCode;
            obj = objSubmitForm$default;
            str3 = str6;
        }
        str4 = (String) obj;
        value = status.getValue();
        if (200 > value && value < 300) {
            JSONObject jSONObject = new JSONObject(str4);
            String string = jSONObject.getString("access_token");
            String strOptString = jSONObject.optString("refresh_token", "");
            long jOptLong = jSONObject.optLong("expires_in", 0L);
            String strOptString2 = jSONObject.optString("scope", "openid sdk.social_layer_presence");
            Timber.Forest.tag("DiscordSvc");
            Integer num = new Integer(string.length());
            strOptString.getClass();
            ConnectionPool.i(num, Boolean.valueOf(strOptString.length() > 0), new Long(jOptLong));
            strOptString2.getClass();
            return new DiscordAuthResult(string, strOptString, jOptLong, strOptString2);
        }
        try {
            failure = new JSONObject(str4).optString("error", "");
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        str5 = (String) (failure instanceof Result.Failure ? "" : failure);
        if (!status.equals(HttpStatusCode.INSTANCE.getBadRequest()) && Intrinsics.areEqual(str5, "invalid_grant")) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(str3);
            throw new DiscordAuthException$InvalidGrant("Invalid or expired grant", null);
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.w(new Integer(status.getValue()), str3, str5, StringsKt.take(200, str4));
        IOException iOException = new IOException("HTTP " + status.getValue() + ": " + str4);
        throw new DiscordAuthException$NetworkFailure(Fragment$5$$ExternalSyntheticOutline0.m("Network failure: ", iOException.getMessage()), iOException);
        HttpResponse httpResponse = (HttpResponse) objSubmitForm$default;
        status = httpResponse.getStatus();
        c01402.L$0 = str2;
        c01402.L$3 = status;
        c01402.label = 2;
        Object objBodyAsText$default = HttpResponseKt.bodyAsText$default(httpResponse, null, c01402, 1, null);
        if (objBodyAsText$default != coroutineSingletons) {
            str3 = str2;
            obj = objBodyAsText$default;
            str4 = (String) obj;
            value = status.getValue();
            if (200 > value) {
            }
            failure = new JSONObject(str4).optString("error", "");
            str5 = (String) (failure instanceof Result.Failure ? "" : failure);
            if (!status.equals(HttpStatusCode.INSTANCE.getBadRequest())) {
            }
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(new Integer(status.getValue()), str3, str5, StringsKt.take(200, str4));
            IOException iOException2 = new IOException("HTTP " + status.getValue() + ": " + str4);
            throw new DiscordAuthException$NetworkFailure(Fragment$5$$ExternalSyntheticOutline0.m("Network failure: ", iOException2.getMessage()), iOException2);
        }
        return coroutineSingletons;
    }
}
