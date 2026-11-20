package kotlinx.serialization.json.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveScopeImpl;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeReader {
    public boolean isLenient;
    public final Object lexer;
    public int stackDepth;

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readObject$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ContinuationImpl {
        public int I$0;
        public DeepRecursiveScopeImpl L$0;
        public JsonTreeReader L$1;
        public LinkedHashMap L$2;
        public String L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass2(BaseContinuationImpl baseContinuationImpl) {
            super(baseContinuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JsonTreeReader.this.readObject(null, this);
        }
    }

    public JsonTreeReader(JsonConfiguration jsonConfiguration, AbstractJsonLexer abstractJsonLexer) {
        this.lexer = abstractJsonLexer;
        this.isLenient = jsonConfiguration.isLenient;
    }

    public JsonElement read() {
        JsonElement jsonObject;
        Object obj;
        AbstractJsonLexer abstractJsonLexer = (AbstractJsonLexer) this.lexer;
        byte bPeekNextToken = abstractJsonLexer.peekNextToken();
        if (bPeekNextToken == 1) {
            return readValue(true);
        }
        if (bPeekNextToken == 0) {
            return readValue(false);
        }
        if (bPeekNextToken != 6) {
            if (bPeekNextToken == 8) {
                return readArray();
            }
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Cannot read Json element because of unexpected ".concat(WriteModeKt.tokenDescription(bPeekNextToken)), 0, null, 6);
            throw null;
        }
        int i = this.stackDepth + 1;
        this.stackDepth = i;
        if (i == 200) {
            JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this, null);
            DeepRecursiveScopeImpl deepRecursiveScopeImpl = new DeepRecursiveScopeImpl();
            deepRecursiveScopeImpl.function = jsonTreeReader$readDeepRecursive$1;
            deepRecursiveScopeImpl.cont = deepRecursiveScopeImpl;
            CoroutineSingletons coroutineSingletons = ResultKt.UNDEFINED_RESULT;
            deepRecursiveScopeImpl.result = coroutineSingletons;
            while (true) {
                obj = deepRecursiveScopeImpl.result;
                Continuation continuation = deepRecursiveScopeImpl.cont;
                if (continuation == null) {
                    break;
                }
                if (Intrinsics.areEqual(coroutineSingletons, obj)) {
                    try {
                        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$2 = deepRecursiveScopeImpl.function;
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, jsonTreeReader$readDeepRecursive$2);
                        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$3 = new JsonTreeReader$readDeepRecursive$1(jsonTreeReader$readDeepRecursive$2.this$0, continuation);
                        jsonTreeReader$readDeepRecursive$3.L$0 = deepRecursiveScopeImpl;
                        Object objInvokeSuspend = jsonTreeReader$readDeepRecursive$3.invokeSuspend(Unit.INSTANCE);
                        if (objInvokeSuspend != CoroutineSingletons.COROUTINE_SUSPENDED) {
                            continuation.resumeWith(objInvokeSuspend);
                        }
                    } catch (Throwable th) {
                        continuation.resumeWith(new Result.Failure(th));
                    }
                } else {
                    deepRecursiveScopeImpl.result = coroutineSingletons;
                    continuation.resumeWith(obj);
                }
            }
            ResultKt.throwOnFailure(obj);
            jsonObject = (JsonElement) obj;
        } else {
            byte bConsumeNextToken = abstractJsonLexer.consumeNextToken((byte) 6);
            if (abstractJsonLexer.peekNextToken() == 4) {
                AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (abstractJsonLexer.canConsumeValue()) {
                String strConsumeStringLenient = this.isLenient ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
                abstractJsonLexer.consumeNextToken((byte) 5);
                linkedHashMap.put(strConsumeStringLenient, read());
                bConsumeNextToken = abstractJsonLexer.consumeNextToken();
                if (bConsumeNextToken != 4) {
                    if (bConsumeNextToken == 7) {
                        break;
                    }
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the object or comma", 0, null, 6);
                    throw null;
                }
            }
            if (bConsumeNextToken == 6) {
                abstractJsonLexer.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken == 4) {
                WriteModeKt.invalidTrailingComma(abstractJsonLexer, "object");
                throw null;
            }
            jsonObject = new JsonObject(linkedHashMap);
        }
        this.stackDepth--;
        return jsonObject;
    }

    public JsonArray readArray() {
        AbstractJsonLexer abstractJsonLexer = (AbstractJsonLexer) this.lexer;
        byte bConsumeNextToken = abstractJsonLexer.consumeNextToken();
        if (abstractJsonLexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (abstractJsonLexer.canConsumeValue()) {
            arrayList.add(read());
            bConsumeNextToken = abstractJsonLexer.consumeNextToken();
            if (bConsumeNextToken != 4) {
                boolean z = bConsumeNextToken == 9;
                int i = abstractJsonLexer.currentPosition;
                if (!z) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", i, null, 4);
                    throw null;
                }
            }
        }
        if (bConsumeNextToken == 8) {
            abstractJsonLexer.consumeNextToken((byte) 9);
        } else if (bConsumeNextToken == 4) {
            WriteModeKt.invalidTrailingComma(abstractJsonLexer, "array");
            throw null;
        }
        return new JsonArray(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public Object readObject(DeepRecursiveScopeImpl deepRecursiveScopeImpl, BaseContinuationImpl baseContinuationImpl) {
        AnonymousClass2 anonymousClass2;
        LinkedHashMap linkedHashMap;
        DeepRecursiveScopeImpl deepRecursiveScopeImpl2;
        byte bConsumeNextToken;
        JsonTreeReader jsonTreeReader;
        AbstractJsonLexer abstractJsonLexer;
        AbstractJsonLexer abstractJsonLexer2 = (AbstractJsonLexer) this.lexer;
        if (baseContinuationImpl instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) baseContinuationImpl;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(baseContinuationImpl);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(baseContinuationImpl);
        }
        Object obj = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i4 = anonymousClass2.I$0;
            String str = anonymousClass2.L$3;
            linkedHashMap = anonymousClass2.L$2;
            jsonTreeReader = anonymousClass2.L$1;
            deepRecursiveScopeImpl2 = anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashMap.put(str, (JsonElement) obj);
            bConsumeNextToken = ((AbstractJsonLexer) jsonTreeReader.lexer).consumeNextToken();
            if (bConsumeNextToken == 4) {
                i3 = i4;
                this = jsonTreeReader;
            } else if (bConsumeNextToken != 7) {
                AbstractJsonLexer.fail$default((AbstractJsonLexer) jsonTreeReader.lexer, "Expected end of the object or comma", 0, null, 6);
                throw null;
            }
            abstractJsonLexer = (AbstractJsonLexer) jsonTreeReader.lexer;
            if (bConsumeNextToken == 6) {
                abstractJsonLexer.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken == 4) {
                WriteModeKt.invalidTrailingComma(abstractJsonLexer, "object");
                throw null;
            }
            return new JsonObject(linkedHashMap);
        }
        ResultKt.throwOnFailure(obj);
        byte bConsumeNextToken2 = abstractJsonLexer2.consumeNextToken((byte) 6);
        if (abstractJsonLexer2.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(abstractJsonLexer2, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        linkedHashMap = new LinkedHashMap();
        deepRecursiveScopeImpl2 = deepRecursiveScopeImpl;
        bConsumeNextToken = bConsumeNextToken2;
        AbstractJsonLexer abstractJsonLexer3 = (AbstractJsonLexer) this.lexer;
        if (!abstractJsonLexer3.canConsumeValue()) {
            jsonTreeReader = this;
            abstractJsonLexer = (AbstractJsonLexer) jsonTreeReader.lexer;
            if (bConsumeNextToken == 6) {
                abstractJsonLexer.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken == 4) {
                WriteModeKt.invalidTrailingComma(abstractJsonLexer, "object");
                throw null;
            }
            return new JsonObject(linkedHashMap);
        }
        String strConsumeStringLenient = this.isLenient ? abstractJsonLexer3.consumeStringLenient() : abstractJsonLexer3.consumeString();
        abstractJsonLexer3.consumeNextToken((byte) 5);
        anonymousClass2.L$0 = deepRecursiveScopeImpl2;
        anonymousClass2.L$1 = this;
        anonymousClass2.L$2 = linkedHashMap;
        anonymousClass2.L$3 = strConsumeStringLenient;
        anonymousClass2.I$0 = i3;
        anonymousClass2.label = 1;
        deepRecursiveScopeImpl2.getClass();
        deepRecursiveScopeImpl2.cont = anonymousClass2;
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    public JsonPrimitive readValue(boolean z) {
        AbstractJsonLexer abstractJsonLexer = (AbstractJsonLexer) this.lexer;
        String strConsumeStringLenient = (this.isLenient || !z) ? abstractJsonLexer.consumeStringLenient() : abstractJsonLexer.consumeString();
        return (z || !Intrinsics.areEqual(strConsumeStringLenient, "null")) ? new JsonLiteral(strConsumeStringLenient, z, null) : JsonNull.INSTANCE;
    }

    public JsonTreeReader(Context context) {
        this.lexer = context;
        this.stackDepth = -1;
    }
}
