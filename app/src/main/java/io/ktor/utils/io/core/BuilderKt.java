package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lkotlinx/io/Sink;", "", "block", "Lkotlinx/io/Source;", "buildPacket", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/io/Source;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuilderKt {
    public static final Source buildPacket(Function1 function1) {
        function1.getClass();
        Buffer buffer = new Buffer();
        function1.invoke(buffer);
        return buffer;
    }
}
