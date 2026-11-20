package io.ktor.client.request.forms;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticLambda1;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000b\u001aK\u0010\u0014\u001a\u00020\t*\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\b\u0004\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aM\u0010\u0014\u001a\u00020\t*\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0014\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\f*\u00020\fH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"", "Lio/ktor/client/request/forms/FormPart;", "values", "", "Lio/ktor/http/content/PartData;", "formData", "([Lio/ktor/client/request/forms/FormPart;)Ljava/util/List;", "Lkotlin/Function1;", "Lio/ktor/client/request/forms/FormBuilder;", "", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "key", "Lio/ktor/http/Headers;", "headers", "", ContentDisposition.Parameters.Size, "Lkotlinx/io/Sink;", "bodyBuilder", "append", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", ContentDisposition.Parameters.FileName, "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/ContentType;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "quoteForMultipart", "(Ljava/lang/String;)Ljava/lang/String;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FormDslKt {

    /* JADX INFO: renamed from: io.ktor.client.request.forms.FormDslKt$append$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    public static final class AnonymousClass1 implements Function0 {
        final /* synthetic */ Function1 $bodyBuilder;

        public AnonymousClass1(Function1 function1) {
            this.$bodyBuilder = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Source invoke() {
            Function1 function1 = this.$bodyBuilder;
            Buffer buffer = new Buffer();
            function1.invoke(buffer);
            return buffer;
        }
    }

    public static final void append(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l, Function1 function1) {
        formBuilder.getClass();
        str.getClass();
        str2.getClass();
        function1.getClass();
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.set(HttpHeaders.ContentDisposition, "filename=" + quoteForMultipart(str2));
        if (contentType != null) {
            headersBuilder.set(HttpHeaders.ContentType, contentType.toString());
        }
        formBuilder.append(new FormPart(str, new InputProvider(l, new AnonymousClass1(function1)), headersBuilder.build()));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Headers headers, Long l, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i & 4) != 0) {
            l = null;
        }
        formBuilder.getClass();
        str.getClass();
        headers.getClass();
        function1.getClass();
        formBuilder.append(new FormPart(str, new InputProvider(l, new AnonymousClass1(function1)), headers));
    }

    public static final List<PartData> formData(FormPart<?>... formPartArr) {
        PartData binaryChannelItem;
        PartData binaryItem;
        formPartArr.getClass();
        ArrayList arrayList = new ArrayList();
        final byte b = 0;
        for (FormPart<?> formPart : formPartArr) {
            String strComponent1 = formPart.getKey();
            Object objComponent2 = formPart.component2();
            Headers headersComponent3 = formPart.getHeaders();
            final byte b2 = 1;
            HeadersBuilder headersBuilder = new HeadersBuilder(b, b2, null);
            headersBuilder.append(HttpHeaders.ContentDisposition, "form-data; name=" + quoteForMultipart(strComponent1));
            headersBuilder.appendAll(headersComponent3);
            if (objComponent2 instanceof String) {
                binaryChannelItem = new PartData.FormItem((String) objComponent2, new Cookie$$ExternalSyntheticLambda1((byte) 2), headersBuilder.build(), null, 8, null);
            } else if (objComponent2 instanceof Number) {
                binaryChannelItem = new PartData.FormItem(objComponent2.toString(), new Cookie$$ExternalSyntheticLambda1((byte) 3), headersBuilder.build(), null, 8, null);
            } else if (objComponent2 instanceof Boolean) {
                binaryChannelItem = new PartData.FormItem(String.valueOf(((Boolean) objComponent2).booleanValue()), new Cookie$$ExternalSyntheticLambda1((byte) 4), headersBuilder.build(), null, 8, null);
            } else {
                if (objComponent2 instanceof byte[]) {
                    headersBuilder.append(HttpHeaders.ContentLength, String.valueOf(((byte[]) objComponent2).length));
                    binaryItem = new PartData.BinaryItem(new FormDslKt$$ExternalSyntheticLambda3(objComponent2), new Cookie$$ExternalSyntheticLambda1((byte) 5), headersBuilder.build(), null, 8, null);
                } else if (objComponent2 instanceof Source) {
                    if (objComponent2 instanceof Buffer) {
                        headersBuilder.append(HttpHeaders.ContentLength, String.valueOf(ByteReadPacketKt.getRemaining((Source) objComponent2)));
                    }
                    final Source source = (Source) objComponent2;
                    binaryChannelItem = new PartData.BinaryItem(new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b3 = b;
                            Source source2 = source;
                            switch (b3) {
                                case 0:
                                    return FormDslKt.formData$lambda$0$6(source2);
                                default:
                                    return FormDslKt.formData$lambda$0$7(source2);
                            }
                        }
                    }, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b3 = b2;
                            Source source2 = source;
                            switch (b3) {
                                case 0:
                                    return FormDslKt.formData$lambda$0$6(source2);
                                default:
                                    return FormDslKt.formData$lambda$0$7(source2);
                            }
                        }
                    }, headersBuilder.build(), null, 8, null);
                } else if (objComponent2 instanceof InputProvider) {
                    InputProvider inputProvider = (InputProvider) objComponent2;
                    Long size = inputProvider.getSize();
                    if (size != null) {
                        headersBuilder.append(HttpHeaders.ContentLength, String.valueOf(size.longValue()));
                    }
                    binaryItem = new PartData.BinaryItem(inputProvider.getBlock(), new Cookie$$ExternalSyntheticLambda1((byte) 6), headersBuilder.build(), null, 8, null);
                } else {
                    if (!(objComponent2 instanceof ChannelProvider)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objComponent2, "Unknown form content type: ");
                        return null;
                    }
                    ChannelProvider channelProvider = (ChannelProvider) objComponent2;
                    Long size2 = channelProvider.getSize();
                    if (size2 != null) {
                        headersBuilder.append(HttpHeaders.ContentLength, String.valueOf(size2.longValue()));
                    }
                    binaryChannelItem = new PartData.BinaryChannelItem(channelProvider.getBlock(), headersBuilder.build());
                }
                binaryChannelItem = binaryItem;
            }
            arrayList.add(binaryChannelItem);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source formData$lambda$0$4(Object obj) {
        return ByteReadPacketKt.ByteReadPacket$default((byte[]) obj, 0, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source formData$lambda$0$6(Object obj) {
        return ((Source) obj).peek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit formData$lambda$0$7(Object obj) throws Exception {
        ((Source) obj).close();
        return Unit.INSTANCE;
    }

    public static final String quoteForMultipart(String str) {
        str.getClass();
        return HeaderValueWithParametersKt.isQuoted(str) ? str : HeaderValueWithParametersKt.quote(str);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            contentType = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        append(formBuilder, str, str2, contentType, l, function1);
    }

    public static final void append(FormBuilder formBuilder, String str, Headers headers, Long l, Function1 function1) {
        formBuilder.getClass();
        str.getClass();
        headers.getClass();
        function1.getClass();
        formBuilder.append(new FormPart(str, new InputProvider(l, new AnonymousClass1(function1)), headers));
    }

    public static final List<PartData> formData(Function1 function1) {
        function1.getClass();
        FormBuilder formBuilder = new FormBuilder();
        function1.invoke(formBuilder);
        FormPart[] formPartArr = (FormPart[]) formBuilder.build().toArray(new FormPart[0]);
        return formData((FormPart<?>[]) Arrays.copyOf(formPartArr, formPartArr.length));
    }
}
