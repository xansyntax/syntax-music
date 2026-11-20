package io.ktor.client.request.forms;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexingIterable;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\rJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u000fJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00102\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0013J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0015J=\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00192\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u001eJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010!J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\"2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010#J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020$2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010%J%\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0004\b\u000b\u0010(J\u0019\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0)H\u0001¢\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lio/ktor/client/request/forms/FormBuilder;", "", "<init>", "()V", "T", "", "key", "value", "Lio/ktor/http/Headers;", "headers", "", "append", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/Headers;)V", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/Headers;)V", "", "(Ljava/lang/String;Ljava/lang/Number;Lio/ktor/http/Headers;)V", "", "(Ljava/lang/String;ZLio/ktor/http/Headers;)V", "", "(Ljava/lang/String;[BLio/ktor/http/Headers;)V", "Lio/ktor/client/request/forms/InputProvider;", "(Ljava/lang/String;Lio/ktor/client/request/forms/InputProvider;Lio/ktor/http/Headers;)V", "", ContentDisposition.Parameters.Size, "Lkotlin/Function0;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "block", "appendInput", "(Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;Lkotlinx/io/Source;Lio/ktor/http/Headers;)V", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;Lio/ktor/http/Headers;)V", "", "(Ljava/lang/String;[Ljava/lang/String;Lio/ktor/http/Headers;)V", "Lio/ktor/client/request/forms/ChannelProvider;", "(Ljava/lang/String;Lio/ktor/client/request/forms/ChannelProvider;Lio/ktor/http/Headers;)V", "Lio/ktor/client/request/forms/FormPart;", "part", "(Lio/ktor/client/request/forms/FormPart;)V", "", "build", "()Ljava/util/List;", "", "parts", "Ljava/util/List;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormBuilder {
    private final List<FormPart<?>> parts = new ArrayList();

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Object obj, Headers headers, int i, Object obj2) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, obj, headers);
    }

    public static /* synthetic */ void appendInput$default(FormBuilder formBuilder, String str, Headers headers, Long l, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i & 4) != 0) {
            l = null;
        }
        formBuilder.appendInput(str, headers, l, function0);
    }

    public final void append(String key, Iterable<String> values, Headers headers) {
        key.getClass();
        values.getClass();
        headers.getClass();
        if (!StringsKt__StringsJVMKt.endsWith(key, "[]", false)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Array parameter must be suffixed with square brackets ie `", key, "[]`"));
            return;
        }
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            this.parts.add(new FormPart<>(key, it.next(), headers));
        }
    }

    public final void appendInput(String key, Headers headers, Long size, Function0 block) {
        key.getClass();
        headers.getClass();
        block.getClass();
        this.parts.add(new FormPart<>(key, new InputProvider(size, block), headers));
    }

    public final List<FormPart<?>> build() {
        return this.parts;
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, str2, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Number number, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, number, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, boolean z, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, z, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, byte[] bArr, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, bArr, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, InputProvider inputProvider, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, inputProvider, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Source source, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, source, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Iterable iterable, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, (Iterable<String>) iterable, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String[] strArr, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, strArr, headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, ChannelProvider channelProvider, Headers headers, int i, Object obj) {
        if ((i & 4) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        formBuilder.append(str, channelProvider, headers);
    }

    public final void append(String key, String value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final void append(String key, Number value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final void append(String key, boolean value, Headers headers) {
        key.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, Boolean.valueOf(value), headers));
    }

    public final void append(String key, byte[] value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final void append(String key, InputProvider value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final void append(String key, Source value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final <T> void append(String key, T value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final void append(String key, ChannelProvider value, Headers headers) {
        key.getClass();
        value.getClass();
        headers.getClass();
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final <T> void append(FormPart<T> part) {
        part.getClass();
        this.parts.add(part);
    }

    public final void append(String key, String[] values, Headers headers) {
        key.getClass();
        values.getClass();
        headers.getClass();
        append(key, values.length == 0 ? EmptyList.INSTANCE : new IndexingIterable((byte) 1, values), headers);
    }
}
