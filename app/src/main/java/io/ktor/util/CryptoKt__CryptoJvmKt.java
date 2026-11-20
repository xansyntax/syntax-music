package io.ktor.util;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.auth.AuthScheme;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\r\u001a\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001a\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a$\u0010\"\u001a\u00020\u00002\n\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b \u0010!¨\u0006#"}, d2 = {"", "algorithm", "Lkotlin/Function1;", "salt", "", "getDigestFunction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", ContentType.Text.TYPE, "getDigest$CryptoKt__CryptoJvmKt", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)[B", "getDigest", "bytes", "sha1", "([B)[B", "sha256", ContentDisposition.Parameters.Name, "Lio/ktor/util/Digest;", AuthScheme.Digest, "(Ljava/lang/String;)Lio/ktor/util/Digest;", "", "length", "generateNonceSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateNonceBlocking", "(I)Ljava/lang/String;", "", "tryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt", "(I)Ljava/lang/Object;", "tryGenerateNonceFromChannel", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "acc", "generateNonceLong$CryptoKt__CryptoJvmKt", "(Ljava/lang/StringBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateNonceLong", "ktor-utils"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
final /* synthetic */ class CryptoKt__CryptoJvmKt {

    /* JADX INFO: renamed from: io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.CryptoKt__CryptoJvmKt", f = "CryptoJvm.kt", l = {79, 81}, m = "generateNonceSuspend", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CryptoKt.generateNonceSuspend(0, this);
        }
    }

    public static final Digest Digest(String str) throws NoSuchAlgorithmException {
        str.getClass();
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.getClass();
        return DigestImpl.m1814boximpl(DigestImpl.m1816constructorimpl(messageDigest));
    }

    public static final String generateNonceBlocking(int i) {
        Object objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt = tryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt(i);
        if (objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt instanceof String) {
            return (String) objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt;
        }
        NonceKt.ensureNonceGeneratorRunning();
        return NonceKt.generateNonceSynchronously(objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt == null ? new StringBuilder(i) : (StringBuilder) objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt, i);
    }

    public static /* synthetic */ String generateNonceBlocking$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 32;
        }
        return CryptoKt.generateNonceBlocking(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004e -> B:20:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object generateNonceLong$CryptoKt__CryptoJvmKt(java.lang.StringBuilder r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceLong$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceLong$1 r0 = (io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceLong$1 r0 = new io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceLong$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$0
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L51
        L2e:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r5)
            r5 = 0
            return r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
        L38:
            int r7 = r5.length()
            if (r6 <= r7) goto L65
            kotlinx.coroutines.channels.Channel r7 = io.ktor.util.NonceKt.getNonceChannel()
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r2
            java.lang.Object r7 = r7.receive(r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r1) goto L51
            return r1
        L51:
            java.lang.String r7 = (java.lang.String) r7
            int r1 = r5.length()
            int r1 = r6 - r1
            int r3 = r7.length()
            if (r1 <= r3) goto L60
            r1 = r3
        L60:
            r3 = 0
            r5.append(r7, r3, r1)
            goto L38
        L65:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.CryptoKt__CryptoJvmKt.generateNonceLong$CryptoKt__CryptoJvmKt(java.lang.StringBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        if (r6 == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object generateNonceSuspend(int i, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objReceive = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objReceive);
            Object objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt = tryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt(i);
            if (objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt instanceof String) {
                return objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt;
            }
            NonceKt.ensureNonceGeneratorRunning();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt == null) {
                Channel nonceChannel = NonceKt.getNonceChannel();
                anonymousClass1.L$0 = null;
                anonymousClass1.I$0 = i;
                anonymousClass1.label = 1;
                objReceive = nonceChannel.receive(anonymousClass1);
            } else {
                anonymousClass1.L$0 = null;
                anonymousClass1.I$0 = i;
                anonymousClass1.label = 2;
                Object objGenerateNonceLong$CryptoKt__CryptoJvmKt = generateNonceLong$CryptoKt__CryptoJvmKt((StringBuilder) objTryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt, i, anonymousClass1);
                if (objGenerateNonceLong$CryptoKt__CryptoJvmKt != coroutineSingletons) {
                    return objGenerateNonceLong$CryptoKt__CryptoJvmKt;
                }
            }
            return coroutineSingletons;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(objReceive);
                return objReceive;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = anonymousClass1.I$0;
        ResultKt.throwOnFailure(objReceive);
        return ((String) objReceive).substring(0, i);
    }

    public static /* synthetic */ Object generateNonceSuspend$default(int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 32;
        }
        return CryptoKt.generateNonceSuspend(i, continuation);
    }

    private static final byte[] getDigest$CryptoKt__CryptoJvmKt(String str, String str2, Function1 function1) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        String str3 = (String) function1.invoke(str);
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str3.getBytes(charset);
        bytes.getClass();
        messageDigest.update(bytes);
        byte[] bytes2 = str.getBytes(charset);
        bytes2.getClass();
        byte[] bArrDigest = messageDigest.digest(bytes2);
        bArrDigest.getClass();
        return bArrDigest;
    }

    public static final Function1 getDigestFunction(String str, Function1 function1) {
        str.getClass();
        function1.getClass();
        return new ByteChannelsKt$$ExternalSyntheticLambda0(str, function1, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDigestFunction$lambda$0$CryptoKt__CryptoJvmKt(String str, Function1 function1, String str2) {
        str2.getClass();
        return getDigest$CryptoKt__CryptoJvmKt(str2, str, function1);
    }

    public static final byte[] sha1(byte[] bArr) {
        bArr.getClass();
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
        bArrDigest.getClass();
        return bArrDigest;
    }

    public static final byte[] sha256(byte[] bArr) {
        bArr.getClass();
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
        bArrDigest.getClass();
        return bArrDigest;
    }

    private static final Object tryGenerateNonceFromChannel$CryptoKt__CryptoJvmKt(int i) {
        if (i == 32) {
            return ChannelResult.m1903getOrNullimpl(NonceKt.getNonceChannel().mo1861tryReceivePtdJZtk());
        }
        StringBuilder sb = new StringBuilder(i);
        do {
            String str = (String) ChannelResult.m1903getOrNullimpl(NonceKt.getNonceChannel().mo1861tryReceivePtdJZtk());
            if (str == null) {
                return sb;
            }
            int length = i - sb.length();
            int length2 = str.length();
            if (length > length2) {
                length = length2;
            }
            sb.append((CharSequence) str, 0, length);
        } while (sb.length() != i);
        return sb.toString();
    }
}
