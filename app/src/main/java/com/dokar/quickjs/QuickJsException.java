package com.dokar.quickjs;

import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.LinesIterator;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B#\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/dokar/quickjs/QuickJsException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", ContentType.Message.TYPE, "", "stack", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/jvm/JvmOverloads;", "getMessage", "()Ljava/lang/String;", "getStack", "location", "Lcom/dokar/quickjs/StackLocation;", "fileName", "getFileName", "lineNumber", "", "getLineNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "columnNumber", "getColumnNumber", "quickjs-kt:quickjs_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class QuickJsException extends Exception {
    private final Integer columnNumber;
    private final String fileName;
    private final Integer lineNumber;
    private final StackLocation location;
    private final String message;
    private final String stack;

    public QuickJsException(String str, String str2) throws IOException {
        StackLocation stackLocation;
        int i;
        Integer num;
        this.message = str;
        this.stack = str2;
        if (str2 != null) {
            LinesIterator linesIterator = new LinesIterator(str2);
            stackLocation = null;
            while (linesIterator.hasNext()) {
                String strRemovePrefix = StringsKt.removePrefix(StringsKt.trim((String) linesIterator.next()).toString(), "at ");
                boolean z = StringsKt__StringsJVMKt.endsWith(strRemovePrefix, ")", false) && StringsKt.contains$default(strRemovePrefix, '(');
                if (z) {
                    String strSubstringAfterLast = StringsKt.substringAfterLast('(', strRemovePrefix, strRemovePrefix);
                    int length = strSubstringAfterLast.length() - 1;
                    strRemovePrefix = StringsKt.take(length < 0 ? 0 : length, strSubstringAfterLast);
                }
                if (strRemovePrefix.length() != 0 && !strRemovePrefix.equals("native")) {
                    List listSplit$default = StringsKt.split$default(strRemovePrefix, new char[]{':'});
                    int size = listSplit$default.size();
                    Integer intOrNull = listSplit$default.size() > 1 ? StringsKt__StringsJVMKt.toIntOrNull((String) CollectionsKt.last(listSplit$default)) : null;
                    if (intOrNull != null) {
                        Integer intOrNull2 = listSplit$default.size() > 2 ? StringsKt__StringsJVMKt.toIntOrNull((String) listSplit$default.get(listSplit$default.size() - 2)) : null;
                        if (intOrNull2 != null) {
                            int i2 = size - 2;
                            num = intOrNull;
                            intOrNull = intOrNull2;
                            i = i2;
                        } else {
                            i = size - 1;
                            num = null;
                        }
                    } else {
                        intOrNull = null;
                        i = size;
                        num = null;
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(listSplit$default.subList(0, i), ServerSentEventKt.COLON, null, null, null, 62);
                    if (strJoinToString$default.length() == 0) {
                        continue;
                    } else if (intOrNull != null) {
                        stackLocation = new StackLocation(strJoinToString$default, intOrNull, num);
                        break;
                    } else if (z && stackLocation == null) {
                        stackLocation = new StackLocation(strJoinToString$default, null, null);
                    }
                }
            }
        } else {
            stackLocation = null;
        }
        this.location = stackLocation;
        this.fileName = stackLocation != null ? stackLocation.fileName : null;
        this.lineNumber = stackLocation != null ? stackLocation.lineNumber : null;
        this.columnNumber = stackLocation != null ? stackLocation.columnNumber : null;
    }

    public final Integer getColumnNumber() {
        return this.columnNumber;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Integer getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }

    public final String getStack() {
        return this.stack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuickJsException(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ QuickJsException(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
