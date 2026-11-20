package com.metrolist.music.ui.screens;

import android.content.Context;
import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import com.metrolist.innertube.models.YouTubeAccount;
import com.yalantis.ucrop.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoginScreenKt$LoginScreen$handleAuthenticatedPage$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $accounts$delegate;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MutableState $errorMessage$delegate;
    public final /* synthetic */ boolean $isSwitchingChannel;
    public final /* synthetic */ LoginJsInterface $jsInterface;
    public final /* synthetic */ MutableState $loginStage$delegate;
    public final /* synthetic */ MutableState $selectedAccount$delegate;
    public final /* synthetic */ LoginStage $stage;
    public final /* synthetic */ MutableState $webViewRef$delegate;
    public /* synthetic */ Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginScreenKt$LoginScreen$handleAuthenticatedPage$1(LoginStage loginStage, MutableState mutableState, LoginJsInterface loginJsInterface, Context context, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, boolean z, MutableState mutableState5, Continuation continuation) {
        super(2, continuation);
        this.$stage = loginStage;
        this.$webViewRef$delegate = mutableState;
        this.$jsInterface = loginJsInterface;
        this.$context = context;
        this.$errorMessage$delegate = mutableState2;
        this.$loginStage$delegate = mutableState3;
        this.$selectedAccount$delegate = mutableState4;
        this.$isSwitchingChannel = z;
        this.$accounts$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LoginScreenKt$LoginScreen$handleAuthenticatedPage$1 loginScreenKt$LoginScreen$handleAuthenticatedPage$1 = new LoginScreenKt$LoginScreen$handleAuthenticatedPage$1(this.$stage, this.$webViewRef$delegate, this.$jsInterface, this.$context, this.$errorMessage$delegate, this.$loginStage$delegate, this.$selectedAccount$delegate, this.$isSwitchingChannel, this.$accounts$delegate, continuation);
        loginScreenKt$LoginScreen$handleAuthenticatedPage$1.L$0 = obj;
        return loginScreenKt$LoginScreen$handleAuthenticatedPage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LoginScreenKt$LoginScreen$handleAuthenticatedPage$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0084  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c8 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objLoginScreen$extractAuthData;
        String str;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        byte b = this.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            WebView webView = (WebView) this.$webViewRef$delegate.getValue();
            this.L$0 = coroutineScope;
            this.label = (byte) 1;
            objLoginScreen$extractAuthData = AlbumScreenKt.LoginScreen$extractAuthData(this.$jsInterface, webView, this);
            if (objLoginScreen$extractAuthData != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            if (b == 3) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        objLoginScreen$extractAuthData = obj;
        AuthData authData = (AuthData) objLoginScreen$extractAuthData;
        LoginStage loginStage = this.$stage;
        if (authData == null) {
            this.$errorMessage$delegate.setValue(this.$context.getString(R.string.authentication_data_extraction_failed));
            this.$loginStage$delegate.setValue(loginStage);
            return unit;
        }
        if (loginStage != LoginStage.SwitchingAccount) {
            this.L$0 = null;
            this.label = (byte) 3;
            if (AlbumScreenKt.LoginScreen$checkAvailableAccounts(this.$isSwitchingChannel, this.$context, this.$loginStage$delegate, this.$errorMessage$delegate, this.$accounts$delegate, this.$selectedAccount$delegate, this.$webViewRef$delegate, authData, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            return unit;
        }
        YouTubeAccount youTubeAccount = (YouTubeAccount) this.$selectedAccount$delegate.getValue();
        String strSubstringBefore$default = (youTubeAccount == null || (str = youTubeAccount.dataSyncId) == null) ? null : StringsKt.substringBefore$default(str, "||");
        if (strSubstringBefore$default == null) {
            strSubstringBefore$default = authData.dataSyncId;
        } else {
            if (StringsKt.isBlank(strSubstringBefore$default)) {
                strSubstringBefore$default = null;
            }
            if (strSubstringBefore$default == null) {
                strSubstringBefore$default = authData.dataSyncId;
            }
        }
        String str2 = authData.cookie;
        String str3 = authData.visitorData;
        String str4 = authData.authUser;
        str2.getClass();
        str3.getClass();
        AuthData authData2 = new AuthData(str2, str3, strSubstringBefore$default, str4);
        this.L$0 = null;
        this.label = (byte) 2;
        if (AlbumScreenKt.LoginScreen$finalizeLogin(this.$context, this.$loginStage$delegate, this.$webViewRef$delegate, this.$errorMessage$delegate, authData2, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return unit;
    }
}
