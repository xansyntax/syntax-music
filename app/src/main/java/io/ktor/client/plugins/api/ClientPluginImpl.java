package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.http.ContentDisposition;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R&\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginImpl;", "", "PluginConfigT", "Lio/ktor/client/plugins/api/ClientPlugin;", "", ContentDisposition.Parameters.Name, "Lkotlin/Function0;", "createConfiguration", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "body", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "block", "Lio/ktor/client/plugins/api/ClientPluginInstance;", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPluginInstance;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/api/ClientPluginInstance;Lio/ktor/client/HttpClient;)V", "Lkotlin/jvm/functions/Function0;", "Lkotlin/jvm/functions/Function1;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ClientPluginImpl<PluginConfigT> implements ClientPlugin<PluginConfigT> {
    private final Function1 body;
    private final Function0 createConfiguration;
    private final AttributeKey<ClientPluginInstance<PluginConfigT>> key;

    public ClientPluginImpl(String str, Function0 function0, Function1 function1) {
        TypeReference typeReferenceTypeOf;
        str.getClass();
        function0.getClass();
        function1.getClass();
        this.createConfiguration = function0;
        this.body = function1;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClientPluginInstance.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ClientPluginImpl.class);
            KVariance kVariance = KVariance.INVARIANT;
            Reflection.factory.getClass();
            TypeParameterReference typeParameterReference = new TypeParameterReference(orCreateKotlinClass2, kVariance);
            TypeReference typeReferenceTypeOf2 = Reflection.typeOf(Object.class);
            ReflectionFactory reflectionFactory = Reflection.factory;
            List listSingletonList = Collections.singletonList(typeReferenceTypeOf2);
            reflectionFactory.getClass();
            listSingletonList.getClass();
            if (typeParameterReference.bounds == null) {
                typeParameterReference.bounds = listSingletonList;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Upper bounds of type parameter '", typeParameterReference, "' have already been initialized.");
            }
            List list = Collections.EMPTY_LIST;
            list.getClass();
            typeReferenceTypeOf = Reflection.typeOf(ClientPluginInstance.class, companion.invariant(new TypeReference(typeParameterReference, list, 0)));
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        this.key = new AttributeKey<>(str, new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public AttributeKey<ClientPluginInstance<PluginConfigT>> getKey() {
        return this.key;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public void install(ClientPluginInstance<PluginConfigT> plugin, HttpClient scope) {
        plugin.getClass();
        scope.getClass();
        plugin.install(scope);
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public ClientPluginInstance<PluginConfigT> prepare(Function1 block) {
        block.getClass();
        Object objInvoke = this.createConfiguration.invoke();
        block.invoke(objInvoke);
        return new ClientPluginInstance<>(getKey(), objInvoke, this.body);
    }
}
