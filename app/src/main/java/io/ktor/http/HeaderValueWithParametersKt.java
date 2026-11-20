package io.ktor.http;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.StringValuesBuilder;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a \u0010\r\u001a\u00020\u0005*\u00020\u00012\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0082\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0011\u0010\u0013\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\u0013\u0010\t\u001a\u001f\u0010\u0014\u001a\u00020\u0005*\u00020\u00012\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u000e\"\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/util/StringValuesBuilder;", "", ContentDisposition.Parameters.Name, "Lio/ktor/http/HeaderValueWithParameters;", "value", "", "append", "(Lio/ktor/util/StringValuesBuilder;Ljava/lang/String;Lio/ktor/http/HeaderValueWithParameters;)V", "escapeIfNeeded", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "escapeIfNeededTo", "(Ljava/lang/String;Ljava/lang/StringBuilder;)V", "", "needQuotes", "(Ljava/lang/String;)Z", "isQuoted", "quote", "quoteTo", "Lio/ktor/http/AsciiBitSet;", "HeaderFieldValueSeparators", "Lio/ktor/http/AsciiBitSet;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HeaderValueWithParametersKt {
    private static final AsciiBitSet HeaderFieldValueSeparators = AsciiBitSet.INSTANCE.of("()<>@,;:\\\"/[]?={} \t\n\r");

    public static final void append(StringValuesBuilder stringValuesBuilder, String str, HeaderValueWithParameters headerValueWithParameters) {
        stringValuesBuilder.getClass();
        str.getClass();
        headerValueWithParameters.getClass();
        stringValuesBuilder.append(str, headerValueWithParameters.toString());
    }

    public static final String escapeIfNeeded(String str) {
        str.getClass();
        return needQuotes(str) ? quote(str) : str;
    }

    private static final void escapeIfNeededTo(String str, StringBuilder sb) {
        if (needQuotes(str)) {
            sb.append(quote(str));
        } else {
            sb.append(str);
        }
    }

    public static final boolean isQuoted(String str) {
        str.getClass();
        if (str.length() >= 2) {
            if (str.length() == 0) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("Char sequence is empty.");
                return false;
            }
            if (str.charAt(0) == '\"' && StringsKt.last(str) == '\"') {
                int i = 1;
                do {
                    int iIndexOf$default = StringsKt.indexOf$default(str, '\"', i, 4);
                    if (iIndexOf$default == str.length() - 1) {
                        break;
                    }
                    int i2 = 0;
                    for (int i3 = iIndexOf$default - 1; str.charAt(i3) == '\\'; i3--) {
                        i2++;
                    }
                    if (i2 % 2 != 0) {
                        i = iIndexOf$default + 1;
                    }
                } while (i < str.length());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean needQuotes(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (isQuoted(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (HeaderFieldValueSeparators.contains(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static final String quote(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder();
        quoteTo(str, sb);
        return sb.toString();
    }

    private static final void quoteTo(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                sb.append(cCharAt);
            } else {
                sb.append("\\\\");
            }
        }
        sb.append("\"");
    }
}
