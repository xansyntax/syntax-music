package kotlin.coroutines;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import io.ktor.openapi.Operation;
import io.ktor.openapi.Parameter;
import io.ktor.openapi.PathItem;
import io.ktor.openapi.RequestBody;
import io.ktor.openapi.Response;
import io.ktor.openapi.Server;
import io.ktor.openapi.Xml;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.ThreadState;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModuleKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CombinedContext$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ CombinedContext$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CombinedContext combinedContext;
        byte b = this.$r8$classId;
        SerialModuleImpl serialModuleImpl = SerializersModuleKt.EmptySerializersModule;
        switch (b) {
            case 0:
                String str = (String) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                str.getClass();
                element.getClass();
                if (str.length() == 0) {
                    return element.toString();
                }
                return str + ", " + element;
            case 1:
                return Operation.Companion.Serializer._init_$lambda$0((Operation) obj, (Map) obj2);
            case 2:
                return Parameter.Companion.Serializer._init_$lambda$0((Parameter) obj, (Map) obj2);
            case 3:
                return PathItem.Companion.Serializer._init_$lambda$0((PathItem) obj, (Map) obj2);
            case 4:
                return RequestBody.Companion.Serializer._init_$lambda$0((RequestBody) obj, (Map) obj2);
            case 5:
                return Response.Companion.Serializer._init_$lambda$0((Response) obj, (Map) obj2);
            case 6:
                return Server.Companion.Serializer._init_$lambda$0((Server) obj, (Map) obj2);
            case 7:
                return Xml.Companion.Serializer._init_$lambda$0((Xml) obj, (Map) obj2);
            case 8:
                CoroutineContext coroutineContext = (CoroutineContext) obj;
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                coroutineContext.getClass();
                element2.getClass();
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element2.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (coroutineContextMinusKey == emptyCoroutineContext) {
                    return element2;
                }
                ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
                CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) coroutineContextMinusKey.get(continuationInterceptor$Key);
                if (coroutineDispatcher == null) {
                    combinedContext = new CombinedContext(element2, coroutineContextMinusKey);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(continuationInterceptor$Key);
                    if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(coroutineDispatcher, element2);
                    }
                    combinedContext = new CombinedContext(coroutineDispatcher, new CombinedContext(element2, coroutineContextMinusKey2));
                }
                return combinedContext;
            case 9:
                return Boolean.valueOf(((Boolean) obj).booleanValue());
            case 10:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case 11:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
            case 13:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 14:
                CoroutineContext.Element element3 = (CoroutineContext.Element) obj2;
                if (!(element3 instanceof ThreadContextElement)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? element3 : Integer.valueOf(iIntValue + 1);
            case 15:
                ThreadContextElement threadContextElement = (ThreadContextElement) obj;
                CoroutineContext.Element element4 = (CoroutineContext.Element) obj2;
                if (threadContextElement != null) {
                    return threadContextElement;
                }
                if (element4 instanceof ThreadContextElement) {
                    return (ThreadContextElement) element4;
                }
                return null;
            case 16:
                ThreadState threadState = (ThreadState) obj;
                CoroutineContext.Element element5 = (CoroutineContext.Element) obj2;
                if (element5 instanceof ThreadContextElement) {
                    ThreadContextElement threadContextElement2 = (ThreadContextElement) element5;
                    CoroutineContext coroutineContext2 = threadState.context;
                    Object objUpdateThreadContext = threadContextElement2.updateThreadContext();
                    Object[] objArr = threadState.values;
                    int i = threadState.i;
                    objArr[i] = objUpdateThreadContext;
                    ThreadContextElement[] threadContextElementArr = threadState.elements;
                    threadState.i = i + 1;
                    threadContextElementArr[i] = threadContextElement2;
                }
                return threadState;
            case 17:
                KClass kClass = (KClass) obj;
                List list = (List) obj2;
                kClass.getClass();
                list.getClass();
                ArrayList arrayListSerializersForParameters = CharsKt.serializersForParameters(serialModuleImpl, list, true);
                arrayListSerializersForParameters.getClass();
                return CharsKt.parametrizedSerializerOrNull(kClass, arrayListSerializersForParameters, new Url$$ExternalSyntheticLambda0(list, (byte) 5));
            default:
                KClass kClass2 = (KClass) obj;
                List list2 = (List) obj2;
                kClass2.getClass();
                list2.getClass();
                ArrayList arrayListSerializersForParameters2 = CharsKt.serializersForParameters(serialModuleImpl, list2, true);
                arrayListSerializersForParameters2.getClass();
                KSerializer kSerializerParametrizedSerializerOrNull = CharsKt.parametrizedSerializerOrNull(kClass2, arrayListSerializersForParameters2, new Url$$ExternalSyntheticLambda0(list2, (byte) 6));
                if (kSerializerParametrizedSerializerOrNull != null) {
                    return HexFormatKt.getNullable(kSerializerParametrizedSerializerOrNull);
                }
                return null;
        }
    }
}
