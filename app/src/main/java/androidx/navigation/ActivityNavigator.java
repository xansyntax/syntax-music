package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("activity")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", HttpHeaders.Destination, "navigation-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ActivityNavigator extends Navigator {
    public final Activity hostActivity;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Destination extends NavDestination {
        @Override // androidx.navigation.NavDestination
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && (obj instanceof Destination) && super.equals(obj);
        }

        @Override // androidx.navigation.NavDestination
        public final int hashCode() {
            return super.hashCode() * 961;
        }

        @Override // androidx.navigation.NavDestination
        public final String toString() {
            return super.toString();
        }
    }

    public ActivityNavigator(Context context) {
        context.getClass();
        for (Object obj : SequencesKt.generateSequence(context, new RoomDatabase$$ExternalSyntheticLambda2((byte) 4))) {
            if (((Context) obj) instanceof Activity) {
                this.hostActivity = (Activity) obj;
            }
        }
        obj = null;
        this.hostActivity = (Activity) obj;
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination navigate(NavDestination navDestination) {
        throw new IllegalStateException(Fragment$5$$ExternalSyntheticOutline0.m(new StringBuilder("Destination "), ((Destination) navDestination).impl.size, " does not have an Intent set.").toString());
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
