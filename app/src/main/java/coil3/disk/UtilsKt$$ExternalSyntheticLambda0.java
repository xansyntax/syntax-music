package coil3.disk;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil3.compose.AsyncImageModelEqualityDelegate$Companion$Default$1;
import coil3.compose.AsyncImagePreviewHandler$Companion$Default$1;
import coil3.network.CacheStrategy;
import coil3.network.NetworkHeaders;
import coil3.network.UncoordinatedConcurrentRequestStrategy;
import coil3.network.okhttp.internal.CallFactoryNetworkClient;
import coil3.network.okhttp.internal.OkHttpNetworkFetcherServiceLoaderTarget;
import coil3.util.DecoderServiceLoaderTarget;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.AvatarStackViewModel;
import com.metrolist.innertube.models.AvatarStackViewModel$Avatar$$serializer;
import com.metrolist.innertube.models.AvatarStackViewModel$ImageSource$$serializer;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.BrowseEndpoint$$serializer;
import com.metrolist.innertube.models.DefaultServiceEndpoint;
import com.metrolist.innertube.models.DefaultServiceEndpoint$$serializer;
import com.metrolist.innertube.models.DefaultServiceEndpoint$SubscribeEndpoint$$serializer;
import com.metrolist.innertube.models.Endpoint;
import com.metrolist.innertube.models.FeedbackEndpoint;
import com.metrolist.innertube.models.FeedbackEndpoint$$serializer;
import com.metrolist.innertube.models.QueueAddEndpoint;
import com.metrolist.innertube.models.QueueAddEndpoint$$serializer;
import com.metrolist.innertube.models.SearchEndpoint;
import com.metrolist.innertube.models.SearchEndpoint$$serializer;
import com.metrolist.innertube.models.ShareEntityEndpoint;
import com.metrolist.innertube.models.ShareEntityEndpoint$$serializer;
import com.metrolist.innertube.models.ToggledServiceEndpoint;
import com.metrolist.innertube.models.ToggledServiceEndpoint$$serializer;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.WatchEndpoint$$serializer;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.ServiceConfigurationError;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.OkHttpClient;
import okio.FileSystem;
import okio.JvmSystemFileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UtilsKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Class<?> returnType;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
                Path pathResolve = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.resolve("coil3_disk_cache");
                long jCoerceIn = 10485760;
                try {
                    File file = pathResolve.toFile();
                    file.mkdir();
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    jCoerceIn = UuidKt.coerceIn((long) (0.02d * statFs.getBlockSizeLong() * statFs.getBlockCountLong()), 10485760L, 262144000L);
                    break;
                } catch (Exception unused) {
                }
                return new RealDiskCache(jCoerceIn, jvmSystemFileSystem, pathResolve);
            case 1:
                return null;
            case 2:
            case 3:
            case 4:
                return unit;
            case 5:
                return UUID.randomUUID();
            case 6:
                return UUID.randomUUID();
            case 7:
                return "DEFAULT_TEST_TAG";
            case 8:
                throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present");
            case 9:
                return new SavedStateViewModelFactory();
            case 10:
                NetworkHeaders.Builder builder = new NetworkHeaders.Builder((byte) 2);
                builder.addInitializer(Reflection.getOrCreateKotlinClass(NavBackStackEntryImpl.SavedStateViewModel.class), new RoomDatabase$$ExternalSyntheticLambda2((byte) 14));
                return builder.build();
            case 11:
                return null;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
            case 13:
                return unit;
            case 14:
                return Boolean.TRUE;
            case 15:
                throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
            case 16:
                try {
                    Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Throwable unused2) {
                    return null;
                }
            case 17:
                try {
                    Method method = (Method) FrameworkSQLiteDatabase.getThreadSessionMethod$delegate.getValue();
                    if (method == null || (returnType = method.getReturnType()) == null) {
                        return null;
                    }
                    Class cls = Integer.TYPE;
                    return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
                } catch (Throwable unused3) {
                    return null;
                }
            case 18:
                return AsyncImageModelEqualityDelegate$Companion$Default$1.Default;
            case 19:
                return AsyncImagePreviewHandler$Companion$Default$1.INSTANCE;
            case 20:
                return CacheStrategy.DEFAULT;
            case 21:
                return UncoordinatedConcurrentRequestStrategy.UNCOORDINATED;
            case 22:
                return new CallFactoryNetworkClient(new OkHttpClient());
            case 23:
                try {
                    return IntMath.toImmutableList(SequencesKt.toList(SequencesKt.asSequence(Arrays.asList(new OkHttpNetworkFetcherServiceLoaderTarget()).iterator())));
                } catch (Throwable th) {
                    throw new ServiceConfigurationError(th.getMessage(), th);
                }
            case 24:
                try {
                    return IntMath.toImmutableList(SequencesKt.toList(SequencesKt.asSequence(Arrays.asList(new DecoderServiceLoaderTarget[0]).iterator())));
                } catch (Throwable th2) {
                    throw new ServiceConfigurationError(th2.getMessage(), th2);
                }
            case 25:
                return new Handler(Looper.getMainLooper());
            case 26:
                AvatarStackViewModel.Companion companion = AvatarStackViewModel.Companion;
                return new HashSetSerializer(AvatarStackViewModel$Avatar$$serializer.INSTANCE, (byte) 1);
            case 27:
                AvatarStackViewModel.AvatarImage.Companion companion2 = AvatarStackViewModel.AvatarImage.Companion;
                return new HashSetSerializer(AvatarStackViewModel$ImageSource$$serializer.INSTANCE, (byte) 1);
            case 28:
                DefaultServiceEndpoint.SubscribeEndpoint.Companion companion3 = DefaultServiceEndpoint.SubscribeEndpoint.Companion;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            default:
                Endpoint.Companion companion4 = Endpoint.INSTANCE;
                return new SealedClassSerializer("com.metrolist.innertube.models.Endpoint", Reflection.getOrCreateKotlinClass(Endpoint.class), new KClass[]{Reflection.getOrCreateKotlinClass(BrowseEndpoint.class), Reflection.getOrCreateKotlinClass(DefaultServiceEndpoint.class), Reflection.getOrCreateKotlinClass(DefaultServiceEndpoint.SubscribeEndpoint.class), Reflection.getOrCreateKotlinClass(FeedbackEndpoint.class), Reflection.getOrCreateKotlinClass(QueueAddEndpoint.class), Reflection.getOrCreateKotlinClass(SearchEndpoint.class), Reflection.getOrCreateKotlinClass(ShareEntityEndpoint.class), Reflection.getOrCreateKotlinClass(ToggledServiceEndpoint.class), Reflection.getOrCreateKotlinClass(WatchEndpoint.class)}, new KSerializer[]{BrowseEndpoint$$serializer.INSTANCE, DefaultServiceEndpoint$$serializer.INSTANCE, DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE, FeedbackEndpoint$$serializer.INSTANCE, QueueAddEndpoint$$serializer.INSTANCE, SearchEndpoint$$serializer.INSTANCE, ShareEntityEndpoint$$serializer.INSTANCE, ToggledServiceEndpoint$$serializer.INSTANCE, WatchEndpoint$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(InvalidationTracker invalidationTracker, byte b) {
        this.$r8$classId = b;
    }
}
