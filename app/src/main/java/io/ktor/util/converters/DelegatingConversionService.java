package io.ktor.util.converters;

import io.ktor.http.LinkHeader;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0016BO\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u001c\u0010\b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004\u0012\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R*\u0010\b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R*\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/util/converters/DelegatingConversionService;", "Lio/ktor/util/converters/ConversionService;", "Lkotlin/reflect/KClass;", "klass", "Lkotlin/Function1;", "", "", "", "decoder", "encoder", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "values", "Lio/ktor/util/reflect/TypeInfo;", LinkHeader.Parameters.Type, "fromValues", "(Ljava/util/List;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "value", "toValues", "(Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/reflect/KClass;", "Lkotlin/jvm/functions/Function1;", "Configuration", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DelegatingConversionService implements ConversionService {
    private final Function1 decoder;
    private final Function1 encoder;
    private final KClass<?> klass;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\b\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\u000e\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\rR6\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lio/ktor/util/converters/DelegatingConversionService$Configuration;", "", "T", "Lkotlin/reflect/KClass;", "klass", "<init>", "(Lkotlin/reflect/KClass;)V", "Lkotlin/Function1;", "", "", "converter", "", "decode", "(Lkotlin/jvm/functions/Function1;)V", "encode", "Lkotlin/reflect/KClass;", "getKlass$ktor_utils", "()Lkotlin/reflect/KClass;", "decoder", "Lkotlin/jvm/functions/Function1;", "getDecoder$ktor_utils", "()Lkotlin/jvm/functions/Function1;", "setDecoder$ktor_utils", "encoder", "getEncoder$ktor_utils", "setEncoder$ktor_utils", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Configuration<T> {
        private Function1 decoder;
        private Function1 encoder;
        private final KClass<T> klass;

        public Configuration(KClass<T> kClass) {
            kClass.getClass();
            this.klass = kClass;
        }

        public final void decode(Function1 converter) {
            converter.getClass();
            if (this.decoder == null) {
                this.decoder = converter;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m(this.klass, "Decoder has already been set for type '");
            }
        }

        public final void encode(Function1 converter) {
            converter.getClass();
            if (this.encoder == null) {
                this.encoder = converter;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m(this.klass, "Encoder has already been set for type '");
            }
        }

        /* JADX INFO: renamed from: getDecoder$ktor_utils, reason: from getter */
        public final Function1 getDecoder() {
            return this.decoder;
        }

        /* JADX INFO: renamed from: getEncoder$ktor_utils, reason: from getter */
        public final Function1 getEncoder() {
            return this.encoder;
        }

        public final KClass<T> getKlass$ktor_utils() {
            return this.klass;
        }

        public final void setDecoder$ktor_utils(Function1 function1) {
            this.decoder = function1;
        }

        public final void setEncoder$ktor_utils(Function1 function1) {
            this.encoder = function1;
        }
    }

    public DelegatingConversionService(KClass<?> kClass, Function1 function1, Function1 function2) {
        kClass.getClass();
        this.klass = kClass;
        this.decoder = function1;
        this.encoder = function2;
    }

    @Override // io.ktor.util.converters.ConversionService
    public Object fromValues(List<String> values, TypeInfo type) {
        values.getClass();
        type.getClass();
        Function1 function1 = this.decoder;
        if (function1 != null) {
            return function1.invoke(values);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(this.klass, "Decoder was not specified for type '");
        return null;
    }

    @Override // io.ktor.util.converters.ConversionService
    public List<String> toValues(Object value) {
        Function1 function1 = this.encoder;
        if (function1 != null) {
            return (List) function1.invoke(value);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(this.klass, "Encoder was not specified for type '");
        return null;
    }
}
