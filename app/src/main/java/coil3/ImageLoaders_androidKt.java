package coil3;

import coil3.decode.ExifOrientationStrategy$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageLoaders_androidKt {
    public static final Extras.Key bitmapFactoryMaxParallelismKey = new Extras.Key(4);
    public static final Extras.Key bitmapFactoryExifOrientationStrategyKey = new Extras.Key(ExifOrientationStrategy$$ExternalSyntheticLambda0.RESPECT_PERFORMANCE);
    public static final Extras.Key imageDecoderEnabledKey = new Extras.Key(Boolean.TRUE);
    public static final Extras.Key memoryCacheMaxSizePercentWhileInBackgroundKey = new Extras.Key(Double.valueOf(1.0d));
}
