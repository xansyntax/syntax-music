package androidx.navigation.compose;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestinationBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeNavigatorDestinationBuilder extends NavDestinationBuilder {
    public final ComposeNavigator composeNavigator;
    public final ComposableLambdaImpl content;
    public Function1 enterTransition;
    public Function1 exitTransition;
    public Function1 popEnterTransition;
    public Function1 popExitTransition;

    public ComposeNavigatorDestinationBuilder(ComposeNavigator composeNavigator, String str, ComposableLambdaImpl composableLambdaImpl) {
        super(composeNavigator, str);
        this.composeNavigator = composeNavigator;
        this.content = composableLambdaImpl;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavDestination build() {
        ComposeNavigator.Destination destination = (ComposeNavigator.Destination) super.build();
        destination.enterTransition = this.enterTransition;
        destination.exitTransition = this.exitTransition;
        destination.popEnterTransition = this.popEnterTransition;
        destination.popExitTransition = this.popExitTransition;
        return destination;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavDestination instantiateDestination() {
        return new ComposeNavigator.Destination(this.composeNavigator, this.content);
    }
}
