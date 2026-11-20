package coil3.request;

import android.content.Context;
import coil3.Extras;
import coil3.size.Precision;
import coil3.size.RealSizeResolver;
import coil3.size.Scale;
import coil3.size.SizeResolver;
import coil3.target.Target;
import coil3.util.UtilsKt$EMPTY_IMAGE_FACTORY$1;
import com.google.common.math.IntMath;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.FileSystem;
import okio.JvmSystemFileSystem;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageRequest {
    public final Context context;
    public final Object data;
    public final CoroutineContext decoderCoroutineContext;
    public final Defaults defaults;
    public final Defined defined;
    public final String diskCacheKey;
    public final CachePolicy diskCachePolicy;
    public final Function1 errorFactory;
    public final Extras extras;
    public final Function1 fallbackFactory;
    public final CoroutineContext fetcherCoroutineContext;
    public final FileSystem fileSystem;
    public final CoroutineContext interceptorCoroutineContext;
    public final Map memoryCacheKeyExtras;
    public final CachePolicy memoryCachePolicy;
    public final CachePolicy networkCachePolicy;
    public final Function1 placeholderFactory;
    public final Precision precision;
    public final Scale scale;
    public final SizeResolver sizeResolver;
    public final Target target;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Defaults {
        public static final Defaults DEFAULT;
        public final CoroutineContext decoderCoroutineContext;
        public final CachePolicy diskCachePolicy;
        public final Function1 errorFactory;
        public final Extras extras;
        public final Function1 fallbackFactory;
        public final CoroutineContext fetcherCoroutineContext;
        public final FileSystem fileSystem;
        public final CoroutineContext interceptorCoroutineContext;
        public final CachePolicy memoryCachePolicy;
        public final CachePolicy networkCachePolicy;
        public final Function1 placeholderFactory;
        public final Precision precision;
        public final Scale scale;
        public final SizeResolver sizeResolver;

        static {
            JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            RealSizeResolver realSizeResolver = SizeResolver.ORIGINAL;
            Precision precision = Precision.EXACT;
            Extras extras = Extras.EMPTY;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            CachePolicy cachePolicy = CachePolicy.ENABLED;
            UtilsKt$EMPTY_IMAGE_FACTORY$1 utilsKt$EMPTY_IMAGE_FACTORY$1 = UtilsKt$EMPTY_IMAGE_FACTORY$1.INSTANCE;
            DEFAULT = new Defaults(jvmSystemFileSystem, emptyCoroutineContext, defaultIoScheduler, defaultIoScheduler, cachePolicy, cachePolicy, cachePolicy, utilsKt$EMPTY_IMAGE_FACTORY$1, utilsKt$EMPTY_IMAGE_FACTORY$1, utilsKt$EMPTY_IMAGE_FACTORY$1, realSizeResolver, Scale.FIT, precision, extras);
        }

        public Defaults(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function2, Function1 function3, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras) {
            this.fileSystem = fileSystem;
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.placeholderFactory = function1;
            this.errorFactory = function2;
            this.fallbackFactory = function3;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
            this.extras = extras;
        }

        public static Defaults copy$default(Defaults defaults, Extras extras, int i) {
            FileSystem fileSystem = defaults.fileSystem;
            CoroutineContext coroutineContext = defaults.interceptorCoroutineContext;
            CoroutineContext coroutineContext2 = defaults.fetcherCoroutineContext;
            CoroutineContext coroutineContext3 = defaults.decoderCoroutineContext;
            CachePolicy cachePolicy = defaults.memoryCachePolicy;
            CachePolicy cachePolicy2 = (i & 32) != 0 ? defaults.diskCachePolicy : CachePolicy.DISABLED;
            CachePolicy cachePolicy3 = (i & 64) != 0 ? defaults.networkCachePolicy : CachePolicy.ENABLED;
            Function1 function1 = defaults.placeholderFactory;
            CachePolicy cachePolicy4 = cachePolicy2;
            CachePolicy cachePolicy5 = cachePolicy3;
            Function1 function2 = defaults.errorFactory;
            Function1 function3 = defaults.fallbackFactory;
            SizeResolver sizeResolver = defaults.sizeResolver;
            Scale scale = defaults.scale;
            Precision precision = defaults.precision;
            Extras extras2 = (i & 8192) != 0 ? defaults.extras : extras;
            defaults.getClass();
            return new Defaults(fileSystem, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy4, cachePolicy5, function1, function2, function3, sizeResolver, scale, precision, extras2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defaults)) {
                return false;
            }
            Defaults defaults = (Defaults) obj;
            return Intrinsics.areEqual(this.fileSystem, defaults.fileSystem) && Intrinsics.areEqual(this.interceptorCoroutineContext, defaults.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, defaults.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, defaults.decoderCoroutineContext) && this.memoryCachePolicy == defaults.memoryCachePolicy && this.diskCachePolicy == defaults.diskCachePolicy && this.networkCachePolicy == defaults.networkCachePolicy && Intrinsics.areEqual(this.placeholderFactory, defaults.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, defaults.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, defaults.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, defaults.sizeResolver) && this.scale == defaults.scale && this.precision == defaults.precision && Intrinsics.areEqual(this.extras, defaults.extras);
        }

        public final int hashCode() {
            return this.extras.data.hashCode() + ((this.precision.hashCode() + ((this.scale.hashCode() + ((this.sizeResolver.hashCode() + ((this.fallbackFactory.hashCode() + ((this.errorFactory.hashCode() + ((this.placeholderFactory.hashCode() + ((this.networkCachePolicy.hashCode() + ((this.diskCachePolicy.hashCode() + ((this.memoryCachePolicy.hashCode() + ((this.decoderCoroutineContext.hashCode() + ((this.fetcherCoroutineContext.hashCode() + ((this.interceptorCoroutineContext.hashCode() + (this.fileSystem.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "Defaults(fileSystem=" + this.fileSystem + ", interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ", extras=" + this.extras + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Defined {
        public final CoroutineContext decoderCoroutineContext;
        public final CachePolicy diskCachePolicy;
        public final CoroutineContext fetcherCoroutineContext;
        public final CoroutineContext interceptorCoroutineContext;
        public final CachePolicy memoryCachePolicy;
        public final CachePolicy networkCachePolicy;
        public final Precision precision;
        public final Scale scale;
        public final SizeResolver sizeResolver;

        public Defined(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, SizeResolver sizeResolver, Scale scale, Precision precision) {
            this.interceptorCoroutineContext = coroutineContext;
            this.fetcherCoroutineContext = coroutineContext2;
            this.decoderCoroutineContext = coroutineContext3;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy2;
            this.networkCachePolicy = cachePolicy3;
            this.sizeResolver = sizeResolver;
            this.scale = scale;
            this.precision = precision;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defined)) {
                return false;
            }
            Defined defined = (Defined) obj;
            return Intrinsics.areEqual(this.interceptorCoroutineContext, defined.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, defined.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, defined.decoderCoroutineContext) && this.memoryCachePolicy == defined.memoryCachePolicy && this.diskCachePolicy == defined.diskCachePolicy && this.networkCachePolicy == defined.networkCachePolicy && Intrinsics.areEqual(this.sizeResolver, defined.sizeResolver) && this.scale == defined.scale && this.precision == defined.precision;
        }

        public final int hashCode() {
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            int iHashCode = (coroutineContext == null ? 0 : coroutineContext.hashCode()) * 31;
            CoroutineContext coroutineContext2 = this.fetcherCoroutineContext;
            int iHashCode2 = (iHashCode + (coroutineContext2 == null ? 0 : coroutineContext2.hashCode())) * 31;
            CoroutineContext coroutineContext3 = this.decoderCoroutineContext;
            int iHashCode3 = (iHashCode2 + (coroutineContext3 == null ? 0 : coroutineContext3.hashCode())) * 31;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            int iHashCode4 = (iHashCode3 + (cachePolicy == null ? 0 : cachePolicy.hashCode())) * 31;
            CachePolicy cachePolicy2 = this.diskCachePolicy;
            int iHashCode5 = (iHashCode4 + (cachePolicy2 == null ? 0 : cachePolicy2.hashCode())) * 31;
            CachePolicy cachePolicy3 = this.networkCachePolicy;
            int iHashCode6 = (iHashCode5 + (cachePolicy3 == null ? 0 : cachePolicy3.hashCode())) * 31;
            UtilsKt$EMPTY_IMAGE_FACTORY$1 utilsKt$EMPTY_IMAGE_FACTORY$1 = UtilsKt$EMPTY_IMAGE_FACTORY$1.INSTANCE;
            int iHashCode7 = (utilsKt$EMPTY_IMAGE_FACTORY$1.hashCode() + ((utilsKt$EMPTY_IMAGE_FACTORY$1.hashCode() + ((utilsKt$EMPTY_IMAGE_FACTORY$1.hashCode() + iHashCode6) * 31)) * 31)) * 31;
            SizeResolver sizeResolver = this.sizeResolver;
            int iHashCode8 = (iHashCode7 + (sizeResolver == null ? 0 : sizeResolver.hashCode())) * 31;
            Scale scale = this.scale;
            int iHashCode9 = (iHashCode8 + (scale == null ? 0 : scale.hashCode())) * 31;
            Precision precision = this.precision;
            return iHashCode9 + (precision != null ? precision.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Defined(fileSystem=null, interceptorCoroutineContext=");
            sb.append(this.interceptorCoroutineContext);
            sb.append(", fetcherCoroutineContext=");
            sb.append(this.fetcherCoroutineContext);
            sb.append(", decoderCoroutineContext=");
            sb.append(this.decoderCoroutineContext);
            sb.append(", memoryCachePolicy=");
            sb.append(this.memoryCachePolicy);
            sb.append(", diskCachePolicy=");
            sb.append(this.diskCachePolicy);
            sb.append(", networkCachePolicy=");
            sb.append(this.networkCachePolicy);
            sb.append(", placeholderFactory=");
            UtilsKt$EMPTY_IMAGE_FACTORY$1 utilsKt$EMPTY_IMAGE_FACTORY$1 = UtilsKt$EMPTY_IMAGE_FACTORY$1.INSTANCE;
            sb.append(utilsKt$EMPTY_IMAGE_FACTORY$1);
            sb.append(", errorFactory=");
            sb.append(utilsKt$EMPTY_IMAGE_FACTORY$1);
            sb.append(", fallbackFactory=");
            sb.append(utilsKt$EMPTY_IMAGE_FACTORY$1);
            sb.append(", sizeResolver=");
            sb.append(this.sizeResolver);
            sb.append(", scale=");
            sb.append(this.scale);
            sb.append(", precision=");
            sb.append(this.precision);
            sb.append(")");
            return sb.toString();
        }
    }

    public ImageRequest(Context context, Object obj, Target target, Map map, String str, FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function2, Function1 function3, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.memoryCacheKeyExtras = map;
        this.diskCacheKey = str;
        this.fileSystem = fileSystem;
        this.interceptorCoroutineContext = coroutineContext;
        this.fetcherCoroutineContext = coroutineContext2;
        this.decoderCoroutineContext = coroutineContext3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderFactory = function1;
        this.errorFactory = function2;
        this.fallbackFactory = function3;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.precision = precision;
        this.extras = extras;
        this.defined = defined;
        this.defaults = defaults;
    }

    public static Builder newBuilder$default(ImageRequest imageRequest) {
        Context context = imageRequest.context;
        imageRequest.getClass();
        return new Builder(imageRequest, context);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.areEqual(this.context, imageRequest.context) && this.data.equals(imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && this.memoryCacheKeyExtras.equals(imageRequest.memoryCacheKeyExtras) && Intrinsics.areEqual(this.diskCacheKey, imageRequest.diskCacheKey) && Intrinsics.areEqual(this.fileSystem, imageRequest.fileSystem) && Intrinsics.areEqual(this.interceptorCoroutineContext, imageRequest.interceptorCoroutineContext) && Intrinsics.areEqual(this.fetcherCoroutineContext, imageRequest.fetcherCoroutineContext) && Intrinsics.areEqual(this.decoderCoroutineContext, imageRequest.decoderCoroutineContext) && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.placeholderFactory, imageRequest.placeholderFactory) && Intrinsics.areEqual(this.errorFactory, imageRequest.errorFactory) && Intrinsics.areEqual(this.fallbackFactory, imageRequest.fallbackFactory) && Intrinsics.areEqual(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && this.precision == imageRequest.precision && this.extras.equals(imageRequest.extras) && this.defined.equals(imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults);
    }

    public final int hashCode() {
        int iHashCode = (this.data.hashCode() + (this.context.hashCode() * 31)) * 31;
        Target target = this.target;
        int iHashCode2 = (this.memoryCacheKeyExtras.hashCode() + ((iHashCode + (target == null ? 0 : target.hashCode())) * 29791)) * 31;
        String str = this.diskCacheKey;
        return this.defaults.hashCode() + ((this.defined.hashCode() + ((this.extras.data.hashCode() + ((this.precision.hashCode() + ((this.scale.hashCode() + ((this.sizeResolver.hashCode() + ((this.fallbackFactory.hashCode() + ((this.errorFactory.hashCode() + ((this.placeholderFactory.hashCode() + ((this.networkCachePolicy.hashCode() + ((this.diskCachePolicy.hashCode() + ((this.memoryCachePolicy.hashCode() + ((this.decoderCoroutineContext.hashCode() + ((this.fetcherCoroutineContext.hashCode() + ((this.interceptorCoroutineContext.hashCode() + ((this.fileSystem.hashCode() + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31)) * 29791)) * 31)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ImageRequest(context=" + this.context + ", data=" + this.data + ", target=" + this.target + ", listener=null, memoryCacheKey=null, memoryCacheKeyExtras=" + this.memoryCacheKeyExtras + ", diskCacheKey=" + this.diskCacheKey + ", fileSystem=" + this.fileSystem + ", fetcherFactory=null, decoderFactory=null, interceptorCoroutineContext=" + this.interceptorCoroutineContext + ", fetcherCoroutineContext=" + this.fetcherCoroutineContext + ", decoderCoroutineContext=" + this.decoderCoroutineContext + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderMemoryCacheKey=null, placeholderFactory=" + this.placeholderFactory + ", errorFactory=" + this.errorFactory + ", fallbackFactory=" + this.fallbackFactory + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", precision=" + this.precision + ", extras=" + this.extras + ", defined=" + this.defined + ", defaults=" + this.defaults + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public final Context context;
        public Object data;
        public CoroutineContext decoderCoroutineContext;
        public Defaults defaults;
        public String diskCacheKey;
        public CachePolicy diskCachePolicy;
        public CoroutineContext fetcherCoroutineContext;
        public CoroutineContext interceptorCoroutineContext;
        public Object lazyExtras;
        public final Map lazyMemoryCacheKeyExtras;
        public CachePolicy memoryCachePolicy;
        public CachePolicy networkCachePolicy;
        public Precision precision;
        public Scale scale;
        public SizeResolver sizeResolver;
        public Target target;

        public Builder(ImageRequest imageRequest, Context context) {
            this.context = context;
            this.defaults = imageRequest.defaults;
            this.data = imageRequest.data;
            this.target = imageRequest.target;
            this.lazyMemoryCacheKeyExtras = imageRequest.memoryCacheKeyExtras;
            this.diskCacheKey = imageRequest.diskCacheKey;
            Defined defined = imageRequest.defined;
            this.interceptorCoroutineContext = defined.interceptorCoroutineContext;
            this.fetcherCoroutineContext = defined.fetcherCoroutineContext;
            this.decoderCoroutineContext = defined.decoderCoroutineContext;
            this.memoryCachePolicy = defined.memoryCachePolicy;
            this.diskCachePolicy = defined.diskCachePolicy;
            this.networkCachePolicy = defined.networkCachePolicy;
            this.sizeResolver = defined.sizeResolver;
            this.scale = defined.scale;
            this.precision = defined.precision;
            this.lazyExtras = imageRequest.extras;
        }

        public final ImageRequest build() {
            Extras extras;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Boolean bool = Boolean.FALSE;
            Map immutableMap = this.lazyMemoryCacheKeyExtras;
            if (Intrinsics.areEqual(immutableMap, bool)) {
                immutableMap.getClass();
                immutableMap = IntMath.toImmutableMap(TypeIntrinsics.asMutableMap(immutableMap));
            } else if (immutableMap == null) {
                throw new AssertionError();
            }
            Map map = immutableMap;
            map.getClass();
            String str = this.diskCacheKey;
            Defaults defaults = this.defaults;
            FileSystem fileSystem = defaults.fileSystem;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = defaults.memoryCachePolicy;
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = defaults.diskCachePolicy;
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = defaults.networkCachePolicy;
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            CoroutineContext coroutineContext = this.interceptorCoroutineContext;
            if (coroutineContext == null) {
                coroutineContext = defaults.interceptorCoroutineContext;
            }
            CoroutineContext coroutineContext2 = coroutineContext;
            CoroutineContext coroutineContext3 = this.fetcherCoroutineContext;
            if (coroutineContext3 == null) {
                coroutineContext3 = defaults.fetcherCoroutineContext;
            }
            CoroutineContext coroutineContext4 = coroutineContext3;
            CoroutineContext coroutineContext5 = this.decoderCoroutineContext;
            if (coroutineContext5 == null) {
                coroutineContext5 = defaults.decoderCoroutineContext;
            }
            CoroutineContext coroutineContext6 = coroutineContext5;
            SizeResolver sizeResolver = this.sizeResolver;
            if (sizeResolver == null) {
                sizeResolver = defaults.sizeResolver;
            }
            SizeResolver sizeResolver2 = sizeResolver;
            Scale scale = this.scale;
            if (scale == null) {
                scale = defaults.scale;
            }
            Scale scale2 = scale;
            Precision precision = this.precision;
            if (precision == null) {
                precision = defaults.precision;
            }
            Precision precision2 = precision;
            Object obj3 = this.lazyExtras;
            if (obj3 instanceof Extras.Builder) {
                extras = new Extras(IntMath.toImmutableMap(((Extras.Builder) obj3).data));
            } else {
                if (!(obj3 instanceof Extras)) {
                    throw new AssertionError();
                }
                extras = (Extras) obj3;
            }
            Extras extras2 = extras;
            Defined defined = new Defined(this.interceptorCoroutineContext, this.fetcherCoroutineContext, this.decoderCoroutineContext, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy, this.sizeResolver, this.scale, this.precision);
            Defaults defaults2 = this.defaults;
            Context context = this.context;
            UtilsKt$EMPTY_IMAGE_FACTORY$1 utilsKt$EMPTY_IMAGE_FACTORY$1 = UtilsKt$EMPTY_IMAGE_FACTORY$1.INSTANCE;
            return new ImageRequest(context, obj2, target, map, str, fileSystem, coroutineContext2, coroutineContext4, coroutineContext6, cachePolicy2, cachePolicy4, cachePolicy6, utilsKt$EMPTY_IMAGE_FACTORY$1, utilsKt$EMPTY_IMAGE_FACTORY$1, utilsKt$EMPTY_IMAGE_FACTORY$1, sizeResolver2, scale2, precision2, extras2, defined, defaults2);
        }

        public final Extras.Builder getExtras() {
            Object obj = this.lazyExtras;
            if (obj instanceof Extras.Builder) {
                return (Extras.Builder) obj;
            }
            if (!(obj instanceof Extras)) {
                throw new AssertionError();
            }
            Extras.Builder builder = new Extras.Builder((Extras) obj);
            this.lazyExtras = builder;
            return builder;
        }

        public Builder(Context context) {
            this.context = context;
            this.defaults = Defaults.DEFAULT;
            this.data = null;
            this.target = null;
            this.lazyMemoryCacheKeyExtras = EmptyMap.INSTANCE;
            this.diskCacheKey = null;
            this.interceptorCoroutineContext = null;
            this.fetcherCoroutineContext = null;
            this.decoderCoroutineContext = null;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.sizeResolver = null;
            this.scale = null;
            this.precision = null;
            this.lazyExtras = Extras.EMPTY;
        }
    }
}
