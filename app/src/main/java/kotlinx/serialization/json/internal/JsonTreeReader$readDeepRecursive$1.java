package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScopeImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3 {
    public /* synthetic */ DeepRecursiveScopeImpl L$0;
    public boolean label;
    public final /* synthetic */ JsonTreeReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation continuation) {
        super(3, continuation);
        this.this$0 = jsonTreeReader;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.this$0, (Continuation) obj3);
        jsonTreeReader$readDeepRecursive$1.L$0 = (DeepRecursiveScopeImpl) obj;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JsonTreeReader jsonTreeReader = this.this$0;
        AbstractJsonLexer abstractJsonLexer = (AbstractJsonLexer) jsonTreeReader.lexer;
        DeepRecursiveScopeImpl deepRecursiveScopeImpl = this.L$0;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            byte bPeekNextToken = abstractJsonLexer.peekNextToken();
            if (bPeekNextToken == 1) {
                return jsonTreeReader.readValue(true);
            }
            if (bPeekNextToken == 0) {
                return jsonTreeReader.readValue(false);
            }
            if (bPeekNextToken != 6) {
                if (bPeekNextToken == 8) {
                    return jsonTreeReader.readArray();
                }
                AbstractJsonLexer.fail$default(abstractJsonLexer, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.L$0 = null;
            this.label = true;
            obj = jsonTreeReader.readObject(deepRecursiveScopeImpl, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return (JsonElement) obj;
    }
}
