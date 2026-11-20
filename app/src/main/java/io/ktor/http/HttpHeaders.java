package io.ktor.http;

import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0003\bÏ\u0001\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u0010J\u000f\u0010\u001f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\u0010J\u000f\u0010\"\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010\u0010J\u000f\u0010#\u001a\u00020\u0004H\u0007¢\u0006\u0004\b#\u0010\u0010J\u000f\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010\u0010J\u000f\u0010&\u001a\u00020\u0004H\u0007¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010'\u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010\u0010J\u000f\u0010(\u001a\u00020\u0004H\u0007¢\u0006\u0004\b(\u0010\u0010J\u000f\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b)\u0010\u0010J\u000f\u0010*\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010\u0010J\u000f\u0010+\u001a\u00020\u0004H\u0007¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010,\u001a\u00020\u0004H\u0007¢\u0006\u0004\b,\u0010\u0010J\u000f\u0010-\u001a\u00020\u0004H\u0007¢\u0006\u0004\b-\u0010\u0010J\u000f\u0010.\u001a\u00020\u0004H\u0007¢\u0006\u0004\b.\u0010\u0010J\u000f\u0010/\u001a\u00020\u0004H\u0007¢\u0006\u0004\b/\u0010\u0010J\u000f\u00100\u001a\u00020\u0004H\u0007¢\u0006\u0004\b0\u0010\u0010J\u000f\u00101\u001a\u00020\u0004H\u0007¢\u0006\u0004\b1\u0010\u0010J\u000f\u00102\u001a\u00020\u0004H\u0007¢\u0006\u0004\b2\u0010\u0010J\u000f\u00103\u001a\u00020\u0004H\u0007¢\u0006\u0004\b3\u0010\u0010J\u000f\u00104\u001a\u00020\u0004H\u0007¢\u0006\u0004\b4\u0010\u0010J\u000f\u00105\u001a\u00020\u0004H\u0007¢\u0006\u0004\b5\u0010\u0010J\u000f\u00106\u001a\u00020\u0004H\u0007¢\u0006\u0004\b6\u0010\u0010J\u000f\u00107\u001a\u00020\u0004H\u0007¢\u0006\u0004\b7\u0010\u0010J\u000f\u00108\u001a\u00020\u0004H\u0007¢\u0006\u0004\b8\u0010\u0010J\u000f\u00109\u001a\u00020\u0004H\u0007¢\u0006\u0004\b9\u0010\u0010J\u000f\u0010:\u001a\u00020\u0004H\u0007¢\u0006\u0004\b:\u0010\u0010J\u000f\u0010;\u001a\u00020\u0004H\u0007¢\u0006\u0004\b;\u0010\u0010J\u000f\u0010<\u001a\u00020\u0004H\u0007¢\u0006\u0004\b<\u0010\u0010J\u000f\u0010=\u001a\u00020\u0004H\u0007¢\u0006\u0004\b=\u0010\u0010J\u000f\u0010>\u001a\u00020\u0004H\u0007¢\u0006\u0004\b>\u0010\u0010J\u000f\u0010?\u001a\u00020\u0004H\u0007¢\u0006\u0004\b?\u0010\u0010J\u000f\u0010@\u001a\u00020\u0004H\u0007¢\u0006\u0004\b@\u0010\u0010J\u000f\u0010A\u001a\u00020\u0004H\u0007¢\u0006\u0004\bA\u0010\u0010J\u000f\u0010B\u001a\u00020\u0004H\u0007¢\u0006\u0004\bB\u0010\u0010J\u000f\u0010C\u001a\u00020\u0004H\u0007¢\u0006\u0004\bC\u0010\u0010J\u000f\u0010D\u001a\u00020\u0004H\u0007¢\u0006\u0004\bD\u0010\u0010J\u000f\u0010E\u001a\u00020\u0004H\u0007¢\u0006\u0004\bE\u0010\u0010J\u000f\u0010F\u001a\u00020\u0004H\u0007¢\u0006\u0004\bF\u0010\u0010J\u000f\u0010G\u001a\u00020\u0004H\u0007¢\u0006\u0004\bG\u0010\u0010J\u000f\u0010H\u001a\u00020\u0004H\u0007¢\u0006\u0004\bH\u0010\u0010J\u000f\u0010I\u001a\u00020\u0004H\u0007¢\u0006\u0004\bI\u0010\u0010J\u000f\u0010J\u001a\u00020\u0004H\u0007¢\u0006\u0004\bJ\u0010\u0010J\u000f\u0010K\u001a\u00020\u0004H\u0007¢\u0006\u0004\bK\u0010\u0010J\u000f\u0010L\u001a\u00020\u0004H\u0007¢\u0006\u0004\bL\u0010\u0010J\u000f\u0010M\u001a\u00020\u0004H\u0007¢\u0006\u0004\bM\u0010\u0010J\u000f\u0010N\u001a\u00020\u0004H\u0007¢\u0006\u0004\bN\u0010\u0010J\u000f\u0010O\u001a\u00020\u0004H\u0007¢\u0006\u0004\bO\u0010\u0010J\u000f\u0010P\u001a\u00020\u0004H\u0007¢\u0006\u0004\bP\u0010\u0010J\u000f\u0010Q\u001a\u00020\u0004H\u0007¢\u0006\u0004\bQ\u0010\u0010J\u000f\u0010R\u001a\u00020\u0004H\u0007¢\u0006\u0004\bR\u0010\u0010J\u000f\u0010S\u001a\u00020\u0004H\u0007¢\u0006\u0004\bS\u0010\u0010J\u000f\u0010T\u001a\u00020\u0004H\u0007¢\u0006\u0004\bT\u0010\u0010J\u000f\u0010U\u001a\u00020\u0004H\u0007¢\u0006\u0004\bU\u0010\u0010J\u000f\u0010V\u001a\u00020\u0004H\u0007¢\u0006\u0004\bV\u0010\u0010J\u000f\u0010W\u001a\u00020\u0004H\u0007¢\u0006\u0004\bW\u0010\u0010J\u000f\u0010X\u001a\u00020\u0004H\u0007¢\u0006\u0004\bX\u0010\u0010J\u000f\u0010Y\u001a\u00020\u0004H\u0007¢\u0006\u0004\bY\u0010\u0010J\u000f\u0010Z\u001a\u00020\u0004H\u0007¢\u0006\u0004\bZ\u0010\u0010J\u000f\u0010[\u001a\u00020\u0004H\u0007¢\u0006\u0004\b[\u0010\u0010J\u000f\u0010\\\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\\\u0010\u0010J\u000f\u0010]\u001a\u00020\u0004H\u0007¢\u0006\u0004\b]\u0010\u0010J\u000f\u0010^\u001a\u00020\u0004H\u0007¢\u0006\u0004\b^\u0010\u0010J\u000f\u0010_\u001a\u00020\u0004H\u0007¢\u0006\u0004\b_\u0010\u0010J\u000f\u0010`\u001a\u00020\u0004H\u0007¢\u0006\u0004\b`\u0010\u0010J\u000f\u0010a\u001a\u00020\u0004H\u0007¢\u0006\u0004\ba\u0010\u0010J\u000f\u0010b\u001a\u00020\u0004H\u0007¢\u0006\u0004\bb\u0010\u0010J\u000f\u0010c\u001a\u00020\u0004H\u0007¢\u0006\u0004\bc\u0010\u0010J\u000f\u0010d\u001a\u00020\u0004H\u0007¢\u0006\u0004\bd\u0010\u0010J\u000f\u0010e\u001a\u00020\u0004H\u0007¢\u0006\u0004\be\u0010\u0010J\u000f\u0010f\u001a\u00020\u0004H\u0007¢\u0006\u0004\bf\u0010\u0010J\u000f\u0010g\u001a\u00020\u0004H\u0007¢\u0006\u0004\bg\u0010\u0010J\u000f\u0010h\u001a\u00020\u0004H\u0007¢\u0006\u0004\bh\u0010\u0010J\u000f\u0010i\u001a\u00020\u0004H\u0007¢\u0006\u0004\bi\u0010\u0010J\u000f\u0010j\u001a\u00020\u0004H\u0007¢\u0006\u0004\bj\u0010\u0010J\u000f\u0010k\u001a\u00020\u0004H\u0007¢\u0006\u0004\bk\u0010\u0010J\u000f\u0010l\u001a\u00020\u0004H\u0007¢\u0006\u0004\bl\u0010\u0010J\u000f\u0010m\u001a\u00020\u0004H\u0007¢\u0006\u0004\bm\u0010\u0010J\u000f\u0010n\u001a\u00020\u0004H\u0007¢\u0006\u0004\bn\u0010\u0010J\u000f\u0010o\u001a\u00020\u0004H\u0007¢\u0006\u0004\bo\u0010\u0010J\u000f\u0010p\u001a\u00020\u0004H\u0007¢\u0006\u0004\bp\u0010\u0010J\u000f\u0010q\u001a\u00020\u0004H\u0007¢\u0006\u0004\bq\u0010\u0010J\u000f\u0010r\u001a\u00020\u0004H\u0007¢\u0006\u0004\br\u0010\u0010R\u0014\u0010s\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020\u00048\u0006X\u0087T¢\u0006\f\n\u0004\bu\u0010t\u0012\u0004\bv\u0010\u0003R\u0014\u0010w\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bw\u0010tR\u0014\u0010x\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bx\u0010tR\u0014\u0010y\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\by\u0010tR\u0014\u0010z\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bz\u0010tR\u0014\u0010{\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b{\u0010tR\u0014\u0010|\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b|\u0010tR\u0014\u0010}\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b}\u0010tR\u0014\u0010~\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b~\u0010tR\u0014\u0010\u007f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u007f\u0010tR\u0016\u0010\u0080\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010tR\u0016\u0010\u0081\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010tR\u0016\u0010\u0082\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010tR\u0016\u0010\u0083\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010tR\u0016\u0010\u0084\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010tR\u0016\u0010\u0085\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010tR\u0016\u0010\u0086\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010tR\u0016\u0010\u0087\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010tR\u0016\u0010\u0088\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010tR\u0016\u0010\u0089\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010tR\u0016\u0010\u008a\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010tR\u0016\u0010\u008b\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010tR\u0016\u0010\u008c\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010tR\u0016\u0010\u008d\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010tR\u0016\u0010\u008e\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010tR\u0016\u0010\u008f\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010tR\u0016\u0010\u0090\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010tR\u0016\u0010\u0091\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010tR\u0016\u0010\u0092\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010tR\u0016\u0010\u0093\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010tR\u0016\u0010\u0094\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010tR\u0016\u0010\u0095\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010tR\u0016\u0010\u0096\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010tR\u0016\u0010\u0097\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010tR\u0016\u0010\u0098\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010tR\u0016\u0010\u0099\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010tR\u0016\u0010\u009a\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010tR\u0016\u0010\u009b\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010tR\u0016\u0010\u009c\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010tR\u0016\u0010\u009d\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010tR\u0016\u0010\u009e\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010tR\u0016\u0010\u009f\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010tR\u0016\u0010 \u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b \u0001\u0010tR\u0016\u0010¡\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¡\u0001\u0010tR\u0016\u0010¢\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¢\u0001\u0010tR\u0016\u0010£\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b£\u0001\u0010tR\u0016\u0010¤\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¤\u0001\u0010tR\u0016\u0010¥\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¥\u0001\u0010tR\u0016\u0010¦\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¦\u0001\u0010tR\u0016\u0010§\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b§\u0001\u0010tR\u0016\u0010¨\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¨\u0001\u0010tR\u0016\u0010©\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b©\u0001\u0010tR\u0016\u0010ª\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bª\u0001\u0010tR\u0016\u0010«\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b«\u0001\u0010tR\u0016\u0010¬\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¬\u0001\u0010tR\u0016\u0010\u00ad\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010tR\u0016\u0010®\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b®\u0001\u0010tR\u0016\u0010¯\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¯\u0001\u0010tR\u0016\u0010°\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b°\u0001\u0010tR\u0016\u0010±\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b±\u0001\u0010tR\u0016\u0010²\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b²\u0001\u0010tR\u0016\u0010³\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b³\u0001\u0010tR\u0016\u0010´\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b´\u0001\u0010tR\u0016\u0010µ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bµ\u0001\u0010tR\u0016\u0010¶\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¶\u0001\u0010tR\u0016\u0010·\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b·\u0001\u0010tR\u0016\u0010¸\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¸\u0001\u0010tR\u0016\u0010¹\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¹\u0001\u0010tR\u0016\u0010º\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bº\u0001\u0010tR\u0016\u0010»\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b»\u0001\u0010tR\u0016\u0010¼\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¼\u0001\u0010tR\u0016\u0010½\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b½\u0001\u0010tR\u0016\u0010¾\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¾\u0001\u0010tR\u0016\u0010¿\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¿\u0001\u0010tR\u0016\u0010À\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÀ\u0001\u0010tR\u0016\u0010Á\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÁ\u0001\u0010tR\u0016\u0010Â\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÂ\u0001\u0010tR\u0016\u0010Ã\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÃ\u0001\u0010tR\u0016\u0010Ä\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÄ\u0001\u0010tR\u0016\u0010Å\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÅ\u0001\u0010tR\u0016\u0010Æ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÆ\u0001\u0010tR\u0016\u0010Ç\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÇ\u0001\u0010tR\u0016\u0010È\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÈ\u0001\u0010tR\u0016\u0010É\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÉ\u0001\u0010tR\u0016\u0010Ê\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÊ\u0001\u0010tR\u0016\u0010Ë\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bË\u0001\u0010tR\u0016\u0010Ì\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÌ\u0001\u0010tR\u0016\u0010Í\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÍ\u0001\u0010tR\u0016\u0010Î\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÎ\u0001\u0010tR\u0016\u0010Ï\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÏ\u0001\u0010tR\u0016\u0010Ð\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÐ\u0001\u0010tR\u0016\u0010Ñ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÑ\u0001\u0010tR\u0016\u0010Ò\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÒ\u0001\u0010tR\u0016\u0010Ó\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÓ\u0001\u0010tR\u0016\u0010Ô\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÔ\u0001\u0010tR\u0016\u0010Õ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÕ\u0001\u0010tR\u0016\u0010Ö\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÖ\u0001\u0010tR\u0016\u0010×\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b×\u0001\u0010tR\u0016\u0010Ø\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bØ\u0001\u0010tR\u0016\u0010Ù\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÙ\u0001\u0010tR\u001e\u0010Û\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R%\u0010à\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040Ú\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\bß\u0001\u0010\u0003\u001a\u0006\bÝ\u0001\u0010Þ\u0001R#\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040á\u00018\u0006¢\u0006\u0010\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001¨\u0006æ\u0001"}, d2 = {"Lio/ktor/http/HttpHeaders;", "", "<init>", "()V", "", "header", "", "isUnsafe", "(Ljava/lang/String;)Z", ContentDisposition.Parameters.Name, "", "checkHeaderName", "(Ljava/lang/String;)V", "value", "checkHeaderValue", "getAccept", "()Ljava/lang/String;", "getAcceptCharset", "getAcceptEncoding", "getAcceptLanguage", "getAcceptRanges", "getAge", "getAllow", "getALPN", "getAuthenticationInfo", "getAuthorization", "getCacheControl", "getConnection", "getContentDisposition", "getContentEncoding", "getContentLanguage", "getContentLength", "getContentLocation", "getContentRange", "getContentType", "getCookie", "getDASL", "getDate", "getDAV", "getDepth", "getDestination", "getETag", "getExpect", "getExpires", "getFrom", "getForwarded", "getHost", "getHTTP2Settings", "getIf", "getIfMatch", "getIfModifiedSince", "getIfNoneMatch", "getIfRange", "getIfScheduleTagMatch", "getIfUnmodifiedSince", "getLastModified", "getLocation", "getLockToken", "getLink", "getMaxForwards", "getMIMEVersion", "getOrderingType", "getOrigin", "getOverwrite", "getPosition", "getPragma", "getPrefer", "getPreferenceApplied", "getProxyAuthenticate", "getProxyAuthenticationInfo", "getProxyAuthorization", "getPublicKeyPins", "getPublicKeyPinsReportOnly", "getRange", "getReferrer", "getRetryAfter", "getScheduleReply", "getScheduleTag", "getSecWebSocketAccept", "getSecWebSocketExtensions", "getSecWebSocketKey", "getSecWebSocketProtocol", "getSecWebSocketVersion", "getServer", "getSetCookie", "getSLUG", "getStrictTransportSecurity", "getTE", "getTimeout", "getTrailer", "getTransferEncoding", "getUpgrade", "getUserAgent", "getVary", "getVia", "getWarning", "getWWWAuthenticate", "getAccessControlAllowOrigin", "getAccessControlAllowMethods", "getAccessControlAllowCredentials", "getAccessControlAllowHeaders", "getAccessControlRequestMethod", "getAccessControlRequestHeaders", "getAccessControlExposeHeaders", "getAccessControlMaxAge", "getXHttpMethodOverride", "getXForwardedHost", "getXForwardedServer", "getXForwardedProto", "getXForwardedFor", "getXForwardedPort", "getXRequestId", "getXCorrelationId", "getXTotalCount", "getLastEventID", HttpHeaders.Accept, "Ljava/lang/String;", "AcceptCharset", "getAcceptCharset$annotations", "AcceptEncoding", "AcceptLanguage", "AcceptRanges", HttpHeaders.Age, HttpHeaders.Allow, HttpHeaders.ALPN, "AuthenticationInfo", HttpHeaders.Authorization, "CacheControl", HttpHeaders.Connection, "ContentDisposition", "ContentEncoding", "ContentLanguage", "ContentLength", "ContentLocation", "ContentRange", "ContentType", HttpHeaders.Cookie, HttpHeaders.DASL, HttpHeaders.Date, HttpHeaders.DAV, HttpHeaders.Depth, HttpHeaders.Destination, HttpHeaders.ETag, HttpHeaders.Expect, HttpHeaders.Expires, HttpHeaders.From, HttpHeaders.Forwarded, HttpHeaders.Host, "HTTP2Settings", HttpHeaders.If, "IfMatch", "IfModifiedSince", "IfNoneMatch", "IfRange", "IfScheduleTagMatch", "IfUnmodifiedSince", "LastModified", HttpHeaders.Location, "LockToken", HttpHeaders.Link, "MaxForwards", "MIMEVersion", "OrderingType", HttpHeaders.Origin, HttpHeaders.Overwrite, HttpHeaders.Position, HttpHeaders.Pragma, HttpHeaders.Prefer, "PreferenceApplied", "ProxyAuthenticate", "ProxyAuthenticationInfo", "ProxyAuthorization", "PublicKeyPins", "PublicKeyPinsReportOnly", HttpHeaders.Range, "Referrer", "RetryAfter", "ScheduleReply", "ScheduleTag", "SecWebSocketAccept", "SecWebSocketExtensions", "SecWebSocketKey", "SecWebSocketProtocol", "SecWebSocketVersion", HttpHeaders.Server, "SetCookie", HttpHeaders.SLUG, "StrictTransportSecurity", HttpHeaders.TE, HttpHeaders.Timeout, HttpHeaders.Trailer, "TransferEncoding", HttpHeaders.Upgrade, "UserAgent", HttpHeaders.Vary, HttpHeaders.Via, HttpHeaders.Warning, "WWWAuthenticate", "AccessControlAllowOrigin", "AccessControlAllowMethods", "AccessControlAllowCredentials", "AccessControlAllowHeaders", "AccessControlRequestMethod", "AccessControlRequestHeaders", "AccessControlExposeHeaders", "AccessControlMaxAge", "XHttpMethodOverride", "XForwardedHost", "XForwardedServer", "XForwardedProto", "XForwardedFor", "XForwardedPort", "XRequestId", "XCorrelationId", "XTotalCount", "LastEventID", "TDMReservation", "TDMPolicy", "", "UnsafeHeadersArray", "[Ljava/lang/String;", "getUnsafeHeaders", "()[Ljava/lang/String;", "getUnsafeHeaders$annotations", "UnsafeHeaders", "", "UnsafeHeadersList", "Ljava/util/List;", "getUnsafeHeadersList", "()Ljava/util/List;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpHeaders {
    public static final String ALPN = "ALPN";
    public static final String Accept = "Accept";
    public static final String AcceptCharset = "Accept-Charset";
    public static final String AcceptEncoding = "Accept-Encoding";
    public static final String AcceptLanguage = "Accept-Language";
    public static final String AcceptRanges = "Accept-Ranges";
    public static final String AccessControlAllowCredentials = "Access-Control-Allow-Credentials";
    public static final String AccessControlAllowHeaders = "Access-Control-Allow-Headers";
    public static final String AccessControlAllowMethods = "Access-Control-Allow-Methods";
    public static final String AccessControlAllowOrigin = "Access-Control-Allow-Origin";
    public static final String AccessControlExposeHeaders = "Access-Control-Expose-Headers";
    public static final String AccessControlMaxAge = "Access-Control-Max-Age";
    public static final String AccessControlRequestHeaders = "Access-Control-Request-Headers";
    public static final String AccessControlRequestMethod = "Access-Control-Request-Method";
    public static final String Age = "Age";
    public static final String Allow = "Allow";
    public static final String AuthenticationInfo = "Authentication-Info";
    public static final String Authorization = "Authorization";
    public static final String CacheControl = "Cache-Control";
    public static final String Connection = "Connection";
    public static final String ContentDisposition = "Content-Disposition";
    public static final String ContentEncoding = "Content-Encoding";
    public static final String ContentLanguage = "Content-Language";
    public static final String ContentLength = "Content-Length";
    public static final String ContentLocation = "Content-Location";
    public static final String ContentRange = "Content-Range";
    public static final String ContentType = "Content-Type";
    public static final String Cookie = "Cookie";
    public static final String DASL = "DASL";
    public static final String DAV = "DAV";
    public static final String Date = "Date";
    public static final String Depth = "Depth";
    public static final String Destination = "Destination";
    public static final String ETag = "ETag";
    public static final String Expect = "Expect";
    public static final String Expires = "Expires";
    public static final String Forwarded = "Forwarded";
    public static final String From = "From";
    public static final String HTTP2Settings = "HTTP2-Settings";
    public static final String Host = "Host";
    public static final HttpHeaders INSTANCE = new HttpHeaders();
    public static final String If = "If";
    public static final String IfMatch = "If-Match";
    public static final String IfModifiedSince = "If-Modified-Since";
    public static final String IfNoneMatch = "If-None-Match";
    public static final String IfRange = "If-Range";
    public static final String IfScheduleTagMatch = "If-Schedule-Tag-Match";
    public static final String IfUnmodifiedSince = "If-Unmodified-Since";
    public static final String LastEventID = "Last-Event-ID";
    public static final String LastModified = "Last-Modified";
    public static final String Link = "Link";
    public static final String Location = "Location";
    public static final String LockToken = "Lock-Token";
    public static final String MIMEVersion = "MIME-Version";
    public static final String MaxForwards = "Max-Forwards";
    public static final String OrderingType = "Ordering-Type";
    public static final String Origin = "Origin";
    public static final String Overwrite = "Overwrite";
    public static final String Position = "Position";
    public static final String Pragma = "Pragma";
    public static final String Prefer = "Prefer";
    public static final String PreferenceApplied = "Preference-Applied";
    public static final String ProxyAuthenticate = "Proxy-Authenticate";
    public static final String ProxyAuthenticationInfo = "Proxy-Authentication-Info";
    public static final String ProxyAuthorization = "Proxy-Authorization";
    public static final String PublicKeyPins = "Public-Key-Pins";
    public static final String PublicKeyPinsReportOnly = "Public-Key-Pins-Report-Only";
    public static final String Range = "Range";
    public static final String Referrer = "Referer";
    public static final String RetryAfter = "Retry-After";
    public static final String SLUG = "SLUG";
    public static final String ScheduleReply = "Schedule-Reply";
    public static final String ScheduleTag = "Schedule-Tag";
    public static final String SecWebSocketAccept = "Sec-WebSocket-Accept";
    public static final String SecWebSocketExtensions = "Sec-WebSocket-Extensions";
    public static final String SecWebSocketKey = "Sec-WebSocket-Key";
    public static final String SecWebSocketProtocol = "Sec-WebSocket-Protocol";
    public static final String SecWebSocketVersion = "Sec-WebSocket-Version";
    public static final String Server = "Server";
    public static final String SetCookie = "Set-Cookie";
    public static final String StrictTransportSecurity = "Strict-Transport-Security";
    public static final String TDMPolicy = "TDM-Policy";
    public static final String TDMReservation = "TDM-Reservation";
    public static final String TE = "TE";
    public static final String Timeout = "Timeout";
    public static final String Trailer = "Trailer";
    public static final String TransferEncoding = "Transfer-Encoding";
    private static final String[] UnsafeHeadersArray;
    private static final List<String> UnsafeHeadersList;
    public static final String Upgrade = "Upgrade";
    public static final String UserAgent = "User-Agent";
    public static final String Vary = "Vary";
    public static final String Via = "Via";
    public static final String WWWAuthenticate = "WWW-Authenticate";
    public static final String Warning = "Warning";
    public static final String XCorrelationId = "X-Correlation-ID";
    public static final String XForwardedFor = "X-Forwarded-For";
    public static final String XForwardedHost = "X-Forwarded-Host";
    public static final String XForwardedPort = "X-Forwarded-Port";
    public static final String XForwardedProto = "X-Forwarded-Proto";
    public static final String XForwardedServer = "X-Forwarded-Server";
    public static final String XHttpMethodOverride = "X-Http-Method-Override";
    public static final String XRequestId = "X-Request-ID";
    public static final String XTotalCount = "X-Total-Count";

    static {
        String[] strArr = {TransferEncoding, Upgrade};
        UnsafeHeadersArray = strArr;
        List<String> listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        UnsafeHeadersList = listAsList;
    }

    private HttpHeaders() {
    }

    public final void checkHeaderName(String name) {
        name.getClass();
        int i = 0;
        int i2 = 0;
        while (i < name.length()) {
            int i3 = i2 + 1;
            if (HttpHeadersKt.ILLEGAL_HEADER_NAME_CHARS.contains(name.charAt(i))) {
                throw new IllegalHeaderNameException(name, i2);
            }
            i++;
            i2 = i3;
        }
    }

    public final void checkHeaderValue(String value) {
        value.getClass();
        int i = 0;
        int i2 = 0;
        while (i < value.length()) {
            char cCharAt = value.charAt(i);
            int i3 = i2 + 1;
            if (Intrinsics.compare((int) cCharAt, 32) < 0 && cCharAt != '\t') {
                throw new IllegalHeaderValueException(value, i2);
            }
            i++;
            i2 = i3;
        }
    }

    @Deprecated
    public final String getALPN() {
        return ALPN;
    }

    @Deprecated
    public final String getAccept() {
        return Accept;
    }

    @Deprecated
    public final String getAcceptCharset() {
        return AcceptCharset;
    }

    @Deprecated
    public final String getAcceptEncoding() {
        return AcceptEncoding;
    }

    @Deprecated
    public final String getAcceptLanguage() {
        return AcceptLanguage;
    }

    @Deprecated
    public final String getAcceptRanges() {
        return AcceptRanges;
    }

    @Deprecated
    public final String getAccessControlAllowCredentials() {
        return AccessControlAllowCredentials;
    }

    @Deprecated
    public final String getAccessControlAllowHeaders() {
        return AccessControlAllowHeaders;
    }

    @Deprecated
    public final String getAccessControlAllowMethods() {
        return AccessControlAllowMethods;
    }

    @Deprecated
    public final String getAccessControlAllowOrigin() {
        return AccessControlAllowOrigin;
    }

    @Deprecated
    public final String getAccessControlExposeHeaders() {
        return AccessControlExposeHeaders;
    }

    @Deprecated
    public final String getAccessControlMaxAge() {
        return AccessControlMaxAge;
    }

    @Deprecated
    public final String getAccessControlRequestHeaders() {
        return AccessControlRequestHeaders;
    }

    @Deprecated
    public final String getAccessControlRequestMethod() {
        return AccessControlRequestMethod;
    }

    @Deprecated
    public final String getAge() {
        return Age;
    }

    @Deprecated
    public final String getAllow() {
        return Allow;
    }

    @Deprecated
    public final String getAuthenticationInfo() {
        return AuthenticationInfo;
    }

    @Deprecated
    public final String getAuthorization() {
        return Authorization;
    }

    @Deprecated
    public final String getCacheControl() {
        return CacheControl;
    }

    @Deprecated
    public final String getConnection() {
        return Connection;
    }

    @Deprecated
    public final String getContentDisposition() {
        return ContentDisposition;
    }

    @Deprecated
    public final String getContentEncoding() {
        return ContentEncoding;
    }

    @Deprecated
    public final String getContentLanguage() {
        return ContentLanguage;
    }

    @Deprecated
    public final String getContentLength() {
        return ContentLength;
    }

    @Deprecated
    public final String getContentLocation() {
        return ContentLocation;
    }

    @Deprecated
    public final String getContentRange() {
        return ContentRange;
    }

    @Deprecated
    public final String getContentType() {
        return ContentType;
    }

    @Deprecated
    public final String getCookie() {
        return Cookie;
    }

    @Deprecated
    public final String getDASL() {
        return DASL;
    }

    @Deprecated
    public final String getDAV() {
        return DAV;
    }

    @Deprecated
    public final String getDate() {
        return Date;
    }

    @Deprecated
    public final String getDepth() {
        return Depth;
    }

    @Deprecated
    public final String getDestination() {
        return Destination;
    }

    @Deprecated
    public final String getETag() {
        return ETag;
    }

    @Deprecated
    public final String getExpect() {
        return Expect;
    }

    @Deprecated
    public final String getExpires() {
        return Expires;
    }

    @Deprecated
    public final String getForwarded() {
        return Forwarded;
    }

    @Deprecated
    public final String getFrom() {
        return From;
    }

    @Deprecated
    public final String getHTTP2Settings() {
        return HTTP2Settings;
    }

    @Deprecated
    public final String getHost() {
        return Host;
    }

    @Deprecated
    public final String getIf() {
        return If;
    }

    @Deprecated
    public final String getIfMatch() {
        return IfMatch;
    }

    @Deprecated
    public final String getIfModifiedSince() {
        return IfModifiedSince;
    }

    @Deprecated
    public final String getIfNoneMatch() {
        return IfNoneMatch;
    }

    @Deprecated
    public final String getIfRange() {
        return IfRange;
    }

    @Deprecated
    public final String getIfScheduleTagMatch() {
        return IfScheduleTagMatch;
    }

    @Deprecated
    public final String getIfUnmodifiedSince() {
        return IfUnmodifiedSince;
    }

    @Deprecated
    public final String getLastEventID() {
        return LastEventID;
    }

    @Deprecated
    public final String getLastModified() {
        return LastModified;
    }

    @Deprecated
    public final String getLink() {
        return Link;
    }

    @Deprecated
    public final String getLocation() {
        return Location;
    }

    @Deprecated
    public final String getLockToken() {
        return LockToken;
    }

    @Deprecated
    public final String getMIMEVersion() {
        return MIMEVersion;
    }

    @Deprecated
    public final String getMaxForwards() {
        return MaxForwards;
    }

    @Deprecated
    public final String getOrderingType() {
        return OrderingType;
    }

    @Deprecated
    public final String getOrigin() {
        return Origin;
    }

    @Deprecated
    public final String getOverwrite() {
        return Overwrite;
    }

    @Deprecated
    public final String getPosition() {
        return Position;
    }

    @Deprecated
    public final String getPragma() {
        return Pragma;
    }

    @Deprecated
    public final String getPrefer() {
        return Prefer;
    }

    @Deprecated
    public final String getPreferenceApplied() {
        return PreferenceApplied;
    }

    @Deprecated
    public final String getProxyAuthenticate() {
        return ProxyAuthenticate;
    }

    @Deprecated
    public final String getProxyAuthenticationInfo() {
        return ProxyAuthenticationInfo;
    }

    @Deprecated
    public final String getProxyAuthorization() {
        return ProxyAuthorization;
    }

    @Deprecated
    public final String getPublicKeyPins() {
        return PublicKeyPins;
    }

    @Deprecated
    public final String getPublicKeyPinsReportOnly() {
        return PublicKeyPinsReportOnly;
    }

    @Deprecated
    public final String getRange() {
        return Range;
    }

    @Deprecated
    public final String getReferrer() {
        return Referrer;
    }

    @Deprecated
    public final String getRetryAfter() {
        return RetryAfter;
    }

    @Deprecated
    public final String getSLUG() {
        return SLUG;
    }

    @Deprecated
    public final String getScheduleReply() {
        return ScheduleReply;
    }

    @Deprecated
    public final String getScheduleTag() {
        return ScheduleTag;
    }

    @Deprecated
    public final String getSecWebSocketAccept() {
        return SecWebSocketAccept;
    }

    @Deprecated
    public final String getSecWebSocketExtensions() {
        return SecWebSocketExtensions;
    }

    @Deprecated
    public final String getSecWebSocketKey() {
        return SecWebSocketKey;
    }

    @Deprecated
    public final String getSecWebSocketProtocol() {
        return SecWebSocketProtocol;
    }

    @Deprecated
    public final String getSecWebSocketVersion() {
        return SecWebSocketVersion;
    }

    @Deprecated
    public final String getServer() {
        return Server;
    }

    @Deprecated
    public final String getSetCookie() {
        return SetCookie;
    }

    @Deprecated
    public final String getStrictTransportSecurity() {
        return StrictTransportSecurity;
    }

    @Deprecated
    public final String getTE() {
        return TE;
    }

    @Deprecated
    public final String getTimeout() {
        return Timeout;
    }

    @Deprecated
    public final String getTrailer() {
        return Trailer;
    }

    @Deprecated
    public final String getTransferEncoding() {
        return TransferEncoding;
    }

    public final String[] getUnsafeHeaders() {
        String[] strArr = UnsafeHeadersArray;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public final List<String> getUnsafeHeadersList() {
        return UnsafeHeadersList;
    }

    @Deprecated
    public final String getUpgrade() {
        return Upgrade;
    }

    @Deprecated
    public final String getUserAgent() {
        return UserAgent;
    }

    @Deprecated
    public final String getVary() {
        return Vary;
    }

    @Deprecated
    public final String getVia() {
        return Via;
    }

    @Deprecated
    public final String getWWWAuthenticate() {
        return WWWAuthenticate;
    }

    @Deprecated
    public final String getWarning() {
        return Warning;
    }

    @Deprecated
    public final String getXCorrelationId() {
        return XCorrelationId;
    }

    @Deprecated
    public final String getXForwardedFor() {
        return XForwardedFor;
    }

    @Deprecated
    public final String getXForwardedHost() {
        return XForwardedHost;
    }

    @Deprecated
    public final String getXForwardedPort() {
        return XForwardedPort;
    }

    @Deprecated
    public final String getXForwardedProto() {
        return XForwardedProto;
    }

    @Deprecated
    public final String getXForwardedServer() {
        return XForwardedServer;
    }

    @Deprecated
    public final String getXHttpMethodOverride() {
        return XHttpMethodOverride;
    }

    @Deprecated
    public final String getXRequestId() {
        return XRequestId;
    }

    @Deprecated
    public final String getXTotalCount() {
        return XTotalCount;
    }

    public final boolean isUnsafe(String header) {
        header.getClass();
        for (String str : UnsafeHeadersArray) {
            if (StringsKt__StringsJVMKt.equals(str, header, true)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static /* synthetic */ void getAcceptCharset$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getUnsafeHeaders$annotations() {
    }
}
