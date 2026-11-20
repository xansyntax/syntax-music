package androidx.compose.material3.ripple;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.RippleNodeFactory$create$colorProducer$1;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeConfiguration {
    public final ColorProducer color;
    public final DragConfiguration dragConfiguration;
    public final FocusConfiguration focusConfiguration;
    public final HoverConfiguration hoverConfiguration;
    public final boolean isBounded;
    public final PressConfiguration pressConfiguration;
    public final float radius;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface DragConfiguration {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Opacity implements DragConfiguration {
            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Opacity);
            }

            public final int hashCode() {
                return Float.hashCode(0.16f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface FocusConfiguration {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Opacity implements FocusConfiguration {
            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Opacity);
            }

            public final int hashCode() {
                return Float.hashCode(0.1f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface HoverConfiguration {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Opacity implements HoverConfiguration {
            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Opacity);
            }

            public final int hashCode() {
                return Float.hashCode(0.08f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PressConfiguration {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Opacity implements PressConfiguration {
            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Opacity);
            }

            public final int hashCode() {
                return Float.hashCode(0.1f);
            }
        }
    }

    public RippleNodeConfiguration(boolean z, float f, RippleNodeFactory$create$colorProducer$1 rippleNodeFactory$create$colorProducer$1, PressConfiguration pressConfiguration, FocusConfiguration focusConfiguration, HoverConfiguration hoverConfiguration, DragConfiguration dragConfiguration) {
        this.isBounded = z;
        this.radius = f;
        this.color = rippleNodeFactory$create$colorProducer$1;
        this.pressConfiguration = pressConfiguration;
        this.focusConfiguration = focusConfiguration;
        this.hoverConfiguration = hoverConfiguration;
        this.dragConfiguration = dragConfiguration;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeConfiguration)) {
            return false;
        }
        RippleNodeConfiguration rippleNodeConfiguration = (RippleNodeConfiguration) obj;
        return this.isBounded == rippleNodeConfiguration.isBounded && Dp.m796equalsimpl0(this.radius, rippleNodeConfiguration.radius) && Intrinsics.areEqual(this.color, rippleNodeConfiguration.color) && this.pressConfiguration.equals(rippleNodeConfiguration.pressConfiguration) && this.focusConfiguration.equals(rippleNodeConfiguration.focusConfiguration) && this.hoverConfiguration.equals(rippleNodeConfiguration.hoverConfiguration) && this.dragConfiguration.equals(rippleNodeConfiguration.dragConfiguration);
    }

    public final int hashCode() {
        return this.dragConfiguration.hashCode() + ((this.hoverConfiguration.hashCode() + ((this.focusConfiguration.hashCode() + ((this.pressConfiguration.hashCode() + ((this.color.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.radius, Boolean.hashCode(this.isBounded) * 31, 31)) * 31)) * 31)) * 31)) * 31);
    }
}
