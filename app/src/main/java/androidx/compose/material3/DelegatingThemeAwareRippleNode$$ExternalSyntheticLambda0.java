package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.ripple.AndroidRippleNode;
import androidx.compose.material3.ripple.RippleModifierNode;
import androidx.compose.material3.ripple.RippleNode$BorderLogicLayerDelegate;
import androidx.compose.material3.ripple.RippleNodeConfiguration;
import androidx.compose.ui.node.HitTestResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DelegatingThemeAwareRippleNode f$0;

    public /* synthetic */ DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = delegatingThemeAwareRippleNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        RippleNodeConfiguration.FocusConfiguration opacity;
        byte b = this.$r8$classId;
        DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode = this.f$0;
        switch (b) {
            case 0:
                RippleConfiguration rippleConfiguration = (RippleConfiguration) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.LocalRippleConfiguration);
                RippleModifierNode rippleModifierNode = delegatingThemeAwareRippleNode.rippleNode;
                if (rippleConfiguration == null) {
                    if (rippleModifierNode != null) {
                        delegatingThemeAwareRippleNode.undelegate(rippleModifierNode);
                    }
                    delegatingThemeAwareRippleNode.rippleNode = null;
                } else if (rippleModifierNode == null) {
                    InteractionSource interactionSource = delegatingThemeAwareRippleNode.interactionSource;
                    DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0 delegatingThemeAwareRippleNode$$ExternalSyntheticLambda0 = delegatingThemeAwareRippleNode.calculateRippleNodeConfiguration;
                    TweenSpec tweenSpec = androidx.compose.material3.ripple.RippleKt.DefaultTweenSpec;
                    RippleModifierNode rippleModifierNode2 = new RippleModifierNode();
                    rippleModifierNode2.delegate(new AndroidRippleNode(interactionSource, delegatingThemeAwareRippleNode$$ExternalSyntheticLambda0));
                    delegatingThemeAwareRippleNode.delegate(rippleModifierNode2);
                    delegatingThemeAwareRippleNode.rippleNode = rippleModifierNode2;
                }
                return Unit.INSTANCE;
            default:
                MotionScheme motionScheme = ((MaterialTheme$Values) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, MaterialThemeKt._localMaterialTheme)).motionScheme;
                RippleThemeConfiguration rippleThemeConfiguration = (RippleThemeConfiguration) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.LocalRippleThemeConfiguration);
                RippleConfiguration rippleConfiguration2 = (RippleConfiguration) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.LocalRippleConfiguration);
                RippleNodeConfiguration rippleNodeConfiguration = delegatingThemeAwareRippleNode.cachedRippleNodeConfiguration;
                if (rippleNodeConfiguration != null && Intrinsics.areEqual(delegatingThemeAwareRippleNode.cachedRippleThemeConfiguration, rippleThemeConfiguration) && Intrinsics.areEqual(delegatingThemeAwareRippleNode.cachedRippleConfiguration, rippleConfiguration2) && Intrinsics.areEqual(delegatingThemeAwareRippleNode.cachedMotionScheme, motionScheme)) {
                    return rippleNodeConfiguration;
                }
                RippleNodeConfiguration.PressConfiguration opacity2 = delegatingThemeAwareRippleNode.enablePressIndication ? new RippleNodeConfiguration.PressConfiguration.Opacity() : RippleNode$BorderLogicLayerDelegate.INSTANCE$3;
                if (delegatingThemeAwareRippleNode.enableFocusIndication) {
                    rippleThemeConfiguration.getClass();
                    opacity = new RippleNodeConfiguration.FocusConfiguration.Opacity();
                } else {
                    opacity = RippleNode$BorderLogicLayerDelegate.INSTANCE$1;
                }
                RippleNodeConfiguration rippleNodeConfiguration2 = new RippleNodeConfiguration(delegatingThemeAwareRippleNode.bounded, delegatingThemeAwareRippleNode.radius, delegatingThemeAwareRippleNode.calculateColor, opacity2, opacity, delegatingThemeAwareRippleNode.enableHoverIndication ? new RippleNodeConfiguration.HoverConfiguration.Opacity() : RippleNode$BorderLogicLayerDelegate.INSTANCE$2, delegatingThemeAwareRippleNode.enableDragIndication ? new RippleNodeConfiguration.DragConfiguration.Opacity() : RippleNode$BorderLogicLayerDelegate.INSTANCE);
                delegatingThemeAwareRippleNode.cachedRippleNodeConfiguration = rippleNodeConfiguration2;
                delegatingThemeAwareRippleNode.cachedRippleThemeConfiguration = rippleThemeConfiguration;
                delegatingThemeAwareRippleNode.cachedRippleConfiguration = rippleConfiguration2;
                delegatingThemeAwareRippleNode.cachedMotionScheme = motionScheme;
                return rippleNodeConfiguration2;
        }
    }
}
