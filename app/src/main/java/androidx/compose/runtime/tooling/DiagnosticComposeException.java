package androidx.compose.runtime.tooling;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.websocket.ControlFramesKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticComposeException extends RuntimeException {
    public final ComposeStackTrace trace;

    public DiagnosticComposeException(ComposeStackTrace composeStackTrace) {
        this.trace = composeStackTrace;
        if (composeStackTrace.hasSourceInformation) {
            return;
        }
        int[] iArr = {201, 202, 204, 206, 207, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, -127, 126665345, 200};
        List list = composeStackTrace.frames;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) list.get(i);
            int i3 = composeStackTraceFrame.groupKey;
            int i4 = 0;
            while (true) {
                if (i4 >= 9) {
                    i4 = -1;
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 < 0) {
                if (composeStackTraceFrame.groupKey == 100) {
                    int i5 = i + 2;
                    if (i5 < size && ((ComposeStackTraceFrame) list.get(i5)).groupKey == 1000) {
                        break;
                    } else {
                        CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                    }
                } else {
                    arrayList.add(composeStackTraceFrame);
                }
            }
            i = i2;
        }
        int size2 = arrayList.size();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[size2];
        for (int i6 = 0; i6 < size2; i6++) {
            stackTraceElementArr[i6] = new StackTraceElement("$$compose", IntIntPair$$ExternalSyntheticOutline0.m(((ComposeStackTraceFrame) arrayList.get(i6)).groupKey, "m$"), "SourceFile", 1);
        }
        setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        ComposeStackTrace composeStackTrace = this.trace;
        if (!composeStackTrace.hasSourceInformation) {
            return "Composition stack when thrown:";
        }
        StringBuilder sb = new StringBuilder("Composition stack when thrown:\n");
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        List list = composeStackTrace.frames;
        list.getClass();
        ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(list);
        int size = reversedListReadOnly.getSize();
        String str = null;
        String str2 = null;
        for (int i = 0; i < size; i++) {
            ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) reversedListReadOnly.get(i);
            Cache.RealCacheRequest realCacheRequest = composeStackTraceFrame.sourceInfo;
            Integer num = composeStackTraceFrame.groupOffset;
            if (realCacheRequest != null) {
                boolean z = realCacheRequest.done;
                String str3 = (String) realCacheRequest.editor;
                if (str3 == null) {
                    String str4 = z ? "<lambda>" : null;
                    if (str4 != null) {
                        str = str4;
                    } else if (str == null) {
                        str = "<unknown function>";
                    }
                } else {
                    str = str3;
                }
                String str5 = (String) realCacheRequest.cacheOut;
                if (str5 != null) {
                    str2 = str5;
                } else if (str2 == null) {
                    str2 = "<unknown file>";
                }
                List list2 = (List) realCacheRequest.this$0;
                String str6 = str + '(' + str2 + ':' + ((num == null || num.intValue() >= list2.size()) ? "<unknown line>" : String.valueOf(((LocationSourceInformation) list2.get(num.intValue())).lineNumber)) + ')';
                if (!z) {
                }
                if (!Intrinsics.areEqual(str3, "rememberCompositionContext") || !Intrinsics.areEqual((String) realCacheRequest.body, "9igjgp")) {
                    listBuilderCreateListBuilder.add(str6);
                }
            }
        }
        ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
        listBuilderBuild.getClass();
        ReversedListReadOnly reversedListReadOnly2 = new ReversedListReadOnly(listBuilderBuild);
        int size2 = reversedListReadOnly2.getSize();
        for (int i2 = 0; i2 < size2; i2++) {
            String str7 = (String) reversedListReadOnly2.get(i2);
            sb.append("\tat ");
            sb.append(str7);
            sb.append('\n');
        }
        return sb.toString();
    }
}
