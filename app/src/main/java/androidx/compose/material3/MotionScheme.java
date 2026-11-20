package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MotionScheme {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExpressiveMotionSchemeImpl implements MotionScheme {
        public static final ExpressiveMotionSchemeImpl INSTANCE = new ExpressiveMotionSchemeImpl();
        public static final SpringSpec defaultSpatialSpec = ArcSplineKt.spring$default(0.8f, 380.0f, null, 4);
        public static final SpringSpec fastSpatialSpec = ArcSplineKt.spring$default(0.6f, 800.0f, null, 4);
        public static final SpringSpec slowSpatialSpec = ArcSplineKt.spring$default(0.8f, 200.0f, null, 4);
        public static final SpringSpec defaultEffectsSpec = ArcSplineKt.spring$default(1.0f, 1600.0f, null, 4);
        public static final SpringSpec fastEffectsSpec = ArcSplineKt.spring$default(1.0f, 3800.0f, null, 4);
        public static final SpringSpec slowEffectsSpec = ArcSplineKt.spring$default(1.0f, 800.0f, null, 4);

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultEffectsSpec() {
            SpringSpec springSpec = defaultEffectsSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultSpatialSpec() {
            SpringSpec springSpec = defaultSpatialSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastEffectsSpec() {
            SpringSpec springSpec = fastEffectsSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastSpatialSpec() {
            SpringSpec springSpec = fastSpatialSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowEffectsSpec() {
            SpringSpec springSpec = slowEffectsSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowSpatialSpec() {
            SpringSpec springSpec = slowSpatialSpec;
            springSpec.getClass();
            return springSpec;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StandardMotionSchemeImpl implements MotionScheme {
        public static final StandardMotionSchemeImpl INSTANCE = new StandardMotionSchemeImpl();
        public static final SpringSpec defaultSpatialSpec = ArcSplineKt.spring$default(0.9f, 700.0f, null, 4);
        public static final SpringSpec fastSpatialSpec = ArcSplineKt.spring$default(0.9f, 1400.0f, null, 4);
        public static final SpringSpec slowSpatialSpec = ArcSplineKt.spring$default(0.9f, 300.0f, null, 4);
        public static final SpringSpec defaultEffectsSpec = ArcSplineKt.spring$default(1.0f, 1600.0f, null, 4);
        public static final SpringSpec fastEffectsSpec = ArcSplineKt.spring$default(1.0f, 3800.0f, null, 4);
        public static final SpringSpec slowEffectsSpec = ArcSplineKt.spring$default(1.0f, 800.0f, null, 4);

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultEffectsSpec() {
            SpringSpec springSpec = defaultEffectsSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultSpatialSpec() {
            SpringSpec springSpec = defaultSpatialSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastEffectsSpec() {
            SpringSpec springSpec = fastEffectsSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastSpatialSpec() {
            SpringSpec springSpec = fastSpatialSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowEffectsSpec() {
            SpringSpec springSpec = slowEffectsSpec;
            springSpec.getClass();
            return springSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowSpatialSpec() {
            SpringSpec springSpec = slowSpatialSpec;
            springSpec.getClass();
            return springSpec;
        }
    }

    SpringSpec defaultEffectsSpec();

    SpringSpec defaultSpatialSpec();

    SpringSpec fastEffectsSpec();

    SpringSpec fastSpatialSpec();

    SpringSpec slowEffectsSpec();

    SpringSpec slowSpatialSpec();
}
