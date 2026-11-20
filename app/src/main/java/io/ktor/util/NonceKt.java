package io.ktor.util;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import dagger.hilt.EntryPoints;
import io.ktor.http.ContentDisposition;
import io.ktor.openapi.Xml$$ExternalSyntheticLambda0;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.HexExtensionsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a#\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\"\u001c\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a\"\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 \"\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 \"\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010 \" \u0010%\u001a\b\u0012\u0004\u0012\u00020\b0$8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\"\u001a\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b0\u00101\u0012\u0004\b2\u0010\u0002\"\u001b\u00106\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\r¨\u00067"}, d2 = {"", "ensureNonceGeneratorRunning", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "acc", "", "length", "", "generateNonceSynchronously", "(Ljava/lang/StringBuilder;I)Ljava/lang/String;", "Ljava/security/SecureRandom;", "lookupSecureRandom", "()Ljava/security/SecureRandom;", ContentDisposition.Parameters.Name, "getInstanceOrNull", "(Ljava/lang/String;)Ljava/security/SecureRandom;", "key", "default", "getSystemPropertyInt", "(Ljava/lang/String;I)I", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "logger", "Lorg/slf4j/Logger;", NonceKt.SHA1PRNG, "Ljava/lang/String;", "", "SECURE_RANDOM_PROVIDERS", "Ljava/util/List;", "SYSTEM_PROPERTY_PREFIX", "SECURE_RESEED_PERIOD", "I", "SECURE_NONCE_COUNT", "SECURE_RESEED_BYTES", "INSECURE_NONCE_COUNT_FACTOR", "Lkotlinx/coroutines/channels/Channel;", "nonceChannel", "Lkotlinx/coroutines/channels/Channel;", "getNonceChannel", "()Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/CoroutineName;", "NonceGeneratorCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nonceGeneratorDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Job;", "nonceGeneratorJob", "Lkotlinx/coroutines/Job;", "getNonceGeneratorJob$annotations", "secureRandom$delegate", "Lkotlin/Lazy;", "getSecureRandom", "secureRandom", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NonceKt {
    private static final CoroutineName NonceGeneratorCoroutineName;
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final String SYSTEM_PROPERTY_PREFIX = "io.ktor.random.secure";
    private static final ExecutorCoroutineDispatcher nonceGeneratorDispatcher;
    private static final Job nonceGeneratorJob;
    private static final Lazy secureRandom$delegate;
    private static final Logger logger = LoggerFactory.getLogger("io.ktor.util.random");
    private static final List<String> SECURE_RANDOM_PROVIDERS = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG"});
    private static final int SECURE_RESEED_PERIOD = getSystemPropertyInt("reseed-period", 30000);
    private static final int SECURE_NONCE_COUNT = getSystemPropertyInt("nonce.buffer-size", 64);
    private static final int SECURE_RESEED_BYTES = getSystemPropertyInt("reseed-bytes", 256);
    private static final int INSECURE_NONCE_COUNT_FACTOR = getSystemPropertyInt("insecure-factor", 4);
    private static final Channel nonceChannel = EntryPoints.Channel$default(getSystemPropertyInt("nonce.channel-size", 128), 6, null);

    static {
        CoroutineName coroutineName = new CoroutineName("nonce-generator");
        NonceGeneratorCoroutineName = coroutineName;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new NonceKt$$ExternalSyntheticLambda0((byte) 0));
        executorServiceNewSingleThreadExecutor.getClass();
        ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl = new ExecutorCoroutineDispatcherImpl(executorServiceNewSingleThreadExecutor);
        nonceGeneratorDispatcher = executorCoroutineDispatcherImpl;
        nonceGeneratorJob = AwaitKt.launch(GlobalScope.INSTANCE, executorCoroutineDispatcherImpl.plus(NonCancellable.INSTANCE).plus(coroutineName), CoroutineStart.LAZY, new NonceKt$nonceGeneratorJob$1(null));
        secureRandom$delegate = new SynchronizedLazyImpl(new Xml$$ExternalSyntheticLambda0((byte) 28));
    }

    public static final void ensureNonceGeneratorRunning() {
        nonceGeneratorJob.start();
    }

    public static final String generateNonceSynchronously(StringBuilder sb, int i) {
        sb.getClass();
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = getSecureRandom();
        while (sb.length() < i) {
            secureRandom.nextBytes(bArr);
            String hexString$default = HexExtensionsKt.toHexString$default(bArr);
            int length = i - sb.length();
            int length2 = hexString$default.length();
            if (length > length2) {
                length = length2;
            }
            sb.append((CharSequence) hexString$default, 0, length);
        }
        return sb.toString();
    }

    private static final SecureRandom getInstanceOrNull(String str) {
        try {
            return str != null ? SecureRandom.getInstance(str) : new SecureRandom();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static /* synthetic */ SecureRandom getInstanceOrNull$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return getInstanceOrNull(str);
    }

    public static final Channel getNonceChannel() {
        return nonceChannel;
    }

    private static final SecureRandom getSecureRandom() {
        return (SecureRandom) secureRandom$delegate.getValue();
    }

    private static final int getSystemPropertyInt(String str, int i) {
        String property = System.getProperty("io.ktor.random.secure." + str, null);
        if (property != null) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                logger.warn(Fragment$5$$ExternalSyntheticOutline0.m("Invalid integer '", property, "' for property io.ktor.random.secure.", str, ", falling back to default"));
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecureRandom lookupSecureRandom() {
        SecureRandom instanceOrNull;
        String property = System.getProperty("io.ktor.random.secure.random.provider");
        if (property != null && (instanceOrNull = getInstanceOrNull(property)) != null) {
            return instanceOrNull;
        }
        Iterator<String> it = SECURE_RANDOM_PROVIDERS.iterator();
        while (it.hasNext()) {
            SecureRandom instanceOrNull2 = getInstanceOrNull(it.next());
            if (instanceOrNull2 != null) {
                return instanceOrNull2;
            }
        }
        logger.warn("None of the " + kotlin.collections.CollectionsKt.joinToString$default(SECURE_RANDOM_PROVIDERS, null, null, null, null, 63) + " found, falling back to the JDK strong default");
        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            instanceStrong.getClass();
            return instanceStrong;
        } catch (NoSuchMethodError | NoSuchAlgorithmException unused) {
            logger.warn("None of the JDK determined strong SecureRandom providers were available, falling back to the default");
            SecureRandom instanceOrNull$default = getInstanceOrNull$default(null, 1, null);
            if (instanceOrNull$default != null) {
                return instanceOrNull$default;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No SecureRandom implementation found");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread nonceGeneratorDispatcher$lambda$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "ktor-nonce-generator");
        thread.setDaemon(true);
        return thread;
    }

    private static /* synthetic */ void getNonceGeneratorJob$annotations() {
    }
}
