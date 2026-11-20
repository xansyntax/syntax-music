package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.charsets.MalformedInputException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", l = {41, 47}, m = "invokeSuspend", v = 1)
public final class DefaultResponseValidationKt$addDefaultResponseValidation$1$1 extends SuspendLambda implements Function2 {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;

    public DefaultResponseValidationKt$addDefaultResponseValidation$1$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultResponseValidationKt$addDefaultResponseValidation$1$1 defaultResponseValidationKt$addDefaultResponseValidation$1$1 = new DefaultResponseValidationKt$addDefaultResponseValidation$1$1(continuation);
        defaultResponseValidationKt$addDefaultResponseValidation$1$1.L$0 = obj;
        return defaultResponseValidationKt$addDefaultResponseValidation$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation continuation) {
        return ((DefaultResponseValidationKt$addDefaultResponseValidation$1$1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:48:0x0102  */
    /* JADX WARN: Code duplicated, block: B:51:0x0111  */
    /* JADX WARN: Code duplicated, block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x0111, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean zBooleanValue;
        int i;
        HttpResponse response;
        HttpResponse httpResponse;
        String str;
        Throwable responseException;
        Logger logger;
        HttpResponse httpResponse2 = (HttpResponse) this.L$0;
        int i2 = this.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) httpResponse2.getCall().getAttributes().get(HttpCallValidatorKt.getExpectSuccessAttributeKey())).booleanValue();
                if (!zBooleanValue) {
                    Logger logger2 = DefaultResponseValidationKt.LOGGER;
                    if (LoggerJvmKt.isTraceEnabled(logger2)) {
                        logger2.trace("Skipping default response validation for " + httpResponse2.getCall().getRequest().getUrl());
                    }
                    return unit;
                }
                int value = httpResponse2.getStatus().getValue();
                HttpClientCall call = httpResponse2.getCall();
                if (value < 300 || call.getAttributes().contains(DefaultResponseValidationKt.ValidateMark)) {
                    return unit;
                }
                this.L$0 = httpResponse2;
                this.L$1 = null;
                this.Z$0 = zBooleanValue;
                this.I$0 = value;
                this.label = 1;
                Object objSave = SavedCallKt.save(call, this);
                if (objSave != coroutineSingletons) {
                    i = value;
                    obj = objSave;
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = this.I$0;
                httpResponse = (HttpResponse) this.L$3;
                try {
                    ResultKt.throwOnFailure(obj);
                    str = (String) obj;
                } catch (MalformedInputException unused) {
                    str = "<body failed decoding>";
                }
                if (300 > i && i < 400) {
                    responseException = new RedirectResponseException(httpResponse, str);
                } else if (400 > i && i < 500) {
                    responseException = new ClientRequestException(httpResponse, str);
                } else if (500 <= i || i >= 600) {
                    responseException = new ResponseException(httpResponse, str);
                } else {
                    responseException = new ServerResponseException(httpResponse, str);
                }
                logger = DefaultResponseValidationKt.LOGGER;
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    throw responseException;
                }
                logger.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with exception", responseException);
                throw responseException;
            }
            i = this.I$0;
            zBooleanValue = this.Z$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = httpResponse2;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = response;
            this.Z$0 = zBooleanValue;
            this.I$0 = i;
            this.label = 2;
            Object objBodyAsText$default = HttpResponseKt.bodyAsText$default(response, null, this, 1, null);
            if (objBodyAsText$default != coroutineSingletons) {
                httpResponse = response;
                obj = objBodyAsText$default;
                str = (String) obj;
                if (300 > i) {
                    if (400 > i) {
                        if (500 <= i) {
                            responseException = new ResponseException(httpResponse, str);
                        } else {
                            responseException = new ResponseException(httpResponse, str);
                        }
                    } else if (500 <= i) {
                        responseException = new ResponseException(httpResponse, str);
                    } else {
                        responseException = new ResponseException(httpResponse, str);
                    }
                } else if (400 > i) {
                    if (500 <= i) {
                        responseException = new ResponseException(httpResponse, str);
                    } else {
                        responseException = new ResponseException(httpResponse, str);
                    }
                } else if (500 <= i) {
                    responseException = new ResponseException(httpResponse, str);
                } else {
                    responseException = new ResponseException(httpResponse, str);
                }
                logger = DefaultResponseValidationKt.LOGGER;
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    throw responseException;
                }
                logger.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with exception", responseException);
                throw responseException;
            }
            return coroutineSingletons;
        } catch (MalformedInputException unused2) {
            httpResponse = response;
            str = "<body failed decoding>";
        }
        HttpClientCall httpClientCall = (HttpClientCall) obj;
        httpClientCall.getAttributes().put(DefaultResponseValidationKt.ValidateMark, unit);
        response = httpClientCall.getResponse();
    }
}
