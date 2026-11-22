package com.metrolist.music.ui.component

import android.graphics.RenderEffect
import android.graphics.RuntimeShader
import android.os.Build
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitHorizontalTouchSlopOrCancellation
import androidx.compose.foundation.gestures.horizontalDrag
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.AwaitPointerEventScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.metrolist.music.ui.screens.Screens
import com.metrolist.music.ui.theme.LocalUiStyle
import com.metrolist.music.ui.theme.UiStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

private const val LENS_SHADER_AGSL = """
uniform shader content;
uniform float4 lens;
uniform float radius;
uniform float amount;

float sdRoundBox(float2 p, float2 b, float r) {
    float2 q = abs(p) - b + r;
    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r;
}

half4 main(float2 fc) {
    float2 p = fc - lens.xy;
    float d = sdRoundBox(p, lens.zw, radius);
    if (d > 0.0) return content.eval(fc);
    float w = 0.50 * min(lens.z, lens.w);
    float t = clamp(-d / w, 0.0, 1.0);
    float bend = pow(1.0 - t, 2.0);
    float e = 1.0;
    float2 n = normalize(float2(
        sdRoundBox(p + float2(e, 0.0), lens.zw, radius) - sdRoundBox(p - float2(e, 0.0), lens.zw, radius),
        sdRoundBox(p + float2(0.0, e), lens.zw, radius) - sdRoundBox(p - float2(0.0, e), lens.zw, radius)
    ) + float2(0.0001));
    float zoom = 1.0 + 0.20 * amount;
    float2 base = lens.xy + p / zoom;
    float2 s = base + n * (bend * w * 2.6 * amount);
    float disp = bend * 6.0 * amount;
    half4 cr = content.eval(s + n * disp);
    half4 cg = content.eval(s);
    half4 cb = content.eval(s - n * disp);
    return half4(cr.r, cg.g, cb.b, max(cr.a, max(cg.a, cb.a)));
}
"""

@Composable
fun AppNavigationBar(
    navigationItems: List<Screens>,
    currentRoute: String?,
    onItemClick: (Screens, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    pureBlack: Boolean = false,
    slimNav: Boolean = false,
    onSearchLongClick: (() -> Unit)? = null,
    onHomeLongClick: (() -> Unit)? = null,
) {
    LensNavigationBar(
        navigationItems = navigationItems,
        currentRoute = currentRoute,
        onItemClick = onItemClick,
        modifier = modifier,
        pureBlack = pureBlack,
        slimNav = slimNav,
        onSearchLongClick = onSearchLongClick,
        onHomeLongClick = onHomeLongClick,
    )
}

@Composable
fun AppNavigationRail(
    navigationItems: List<Screens>,
    currentRoute: String?,
    onItemClick: (Screens, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    pureBlack: Boolean = false,
    onSearchLongClick: (() -> Unit)? = null,
    onHomeLongClick: (() -> Unit)? = null,
) {
    val containerColor = if (pureBlack) Color.Black else MaterialTheme.colorScheme.surfaceContainer
    NavigationRail(
        modifier = modifier,
        containerColor = containerColor,
    ) {
        navigationItems.forEach { screen ->
            val selected = isRouteSelected(currentRoute, screen.route, navigationItems)
            NavigationRailItem(
                selected = selected,
                onClick = { onItemClick(screen, selected) },
                icon = {
                    Icon(
                        painter = painterResource(if (selected) screen.iconIdActive else screen.iconIdInactive),
                        contentDescription = stringResource(screen.titleId),
                    )
                },
                label = {
                    Text(
                        text = stringResource(screen.titleId),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
            )
        }
    }
}

@Composable
fun LensNavigationBar(
    navigationItems: List<Screens>,
    currentRoute: String?,
    onItemClick: (Screens, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    pureBlack: Boolean = false,
    slimNav: Boolean = false,
    onSearchLongClick: (() -> Unit)? = null,
    onHomeLongClick: (() -> Unit)? = null,
) {
    val count = navigationItems.size.coerceAtLeast(1)
    val selectedIndex = remember(navigationItems, currentRoute) {
        navigationItems.indexOfFirst { isRouteSelected(currentRoute, it.route, navigationItems) }
            .coerceAtLeast(0)
    }

    val currentItems by rememberUpdatedState(navigationItems)
    val currentOnClick by rememberUpdatedState(onItemClick)
    val onSelect: (Int) -> Unit = remember {
        { idx ->
            currentItems.getOrNull(idx)?.let { screen ->
                currentOnClick(screen, idx == selectedIndex)
            }
        }
    }

    val scope = rememberCoroutineScope()
    val haptics = LocalHapticFeedback.current
    val controller = remember(count) {
        LensController(count, scope, haptics, selectedIndex)
    }
    controller.selected = selectedIndex
    controller.onSelect = onSelect

    LaunchedEffect(selectedIndex) {
        if (!controller.dragging) {
            controller.pos.animateTo(
                targetValue = selectedIndex.toFloat(),
                animationSpec = spring(dampingRatio = 0.72f, stiffness = 520f)
            )
        }
    }

    LaunchedEffect(controller.nearest, controller.dragging) {
        if (controller.dragging) {
            haptics.performHapticFeedback(HapticFeedbackType.TextHandleMove)
        }
    }

    Box(
        modifier = modifier.background(if (pureBlack) Color.Black else Color.Transparent),
        contentAlignment = Alignment.TopCenter,
    ) {
        if (LocalUiStyle.current == UiStyle.GLASS) {
            GlassLensBar(
                navigationItems = navigationItems,
                selectedIndex = selectedIndex,
                controller = controller,
                onItemClick = onItemClick,
                pureBlack = pureBlack,
                slimNav = slimNav,
                onSearchLongClick = onSearchLongClick,
                onHomeLongClick = onHomeLongClick,
            )
        } else {
            PillNavBar(
                navigationItems = navigationItems,
                selectedIndex = selectedIndex,
                controller = controller,
                onItemClick = onItemClick,
                pureBlack = pureBlack,
                slimNav = slimNav,
                onSearchLongClick = onSearchLongClick,
                onHomeLongClick = onHomeLongClick,
            )
        }
    }
}

@Composable
private fun GlassLensBar(
    navigationItems: List<Screens>,
    selectedIndex: Int,
    controller: LensController,
    onItemClick: (Screens, Boolean) -> Unit,
    pureBlack: Boolean,
    slimNav: Boolean,
    onSearchLongClick: (() -> Unit)?,
    onHomeLongClick: (() -> Unit)?,
) {
    val n = controller.n
    val colorScheme = MaterialTheme.colorScheme
    val outerShape = remember { RoundedCornerShape(36.dp) }
    val pillShape = remember { RoundedCornerShape(30.dp) }
    val barHeight = if (slimNav) 58.dp else 68.dp
    val primary = colorScheme.primary

    val shader = remember {
        if (Build.VERSION.SDK_INT >= 33) {
            runCatching { RuntimeShader(LENS_SHADER_AGSL) }.getOrNull()
        } else {
            null
        }
    }

    Box(
        modifier = Modifier
            .padding(horizontal = 22.dp)
            .padding(top = 6.dp)
            .fillMaxWidth()
            .height(barHeight)
            .graphicsLayer {
                val p = controller.press.value
                scaleX = 1f - 0.015f * p
                scaleY = 1f - 0.015f * p
            }
            .glassBlur(outerShape)
            .padding(4.dp)
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val density = LocalDensity.current
            val totalWidthPx = constraints.maxWidth.toFloat()
            val totalHeightPx = constraints.maxHeight.toFloat()
            val slotWidthPx = totalWidthPx / n
            val slotWidthDp = with(density) { slotWidthPx.toDp() }

            Box(
                modifier = Modifier
                    .offset { IntOffset((controller.pos.value * slotWidthPx).roundToInt(), 0) }
                    .width(slotWidthDp)
                    .fillMaxHeight()
                    .graphicsLayer {
                        val p = controller.press.value
                        val s = controller.stretch.value
                        scaleX = 1f + 0.08f * p + 0.14f * s
                        scaleY = 1f + 0.06f * p - 0.04f * s
                    }
                    .glass(shape = pillShape, elevated = true)
                    .background(primary.copy(alpha = 0.14f))
                    .drawWithContent { drawContent() }
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        val amount = controller.press.value
                        if (shader == null || amount < 0.01f) {
                            renderEffect = null
                        } else if (Build.VERSION.SDK_INT >= 33) {
                            val halfW = (slotWidthPx / 2f) * (1f + 0.16f * amount + 0.22f * controller.stretch.value)
                            val halfH = (totalHeightPx / 2f) * (1f + 0.10f * amount - 0.05f * controller.stretch.value)
                            val cx = (controller.pos.value + 0.5f) * slotWidthPx
                            val cy = totalHeightPx / 2f
                            shader.setFloatUniform("lens", cx, cy, halfW, halfH)
                            shader.setFloatUniform("radius", halfH * 0.96f)
                            shader.setFloatUniform("amount", amount)
                            renderEffect = RenderEffect.createRuntimeShaderEffect(shader, "content")
                                .asComposeRenderEffect()
                        }
                    }
                    .pointerInput(n, slotWidthPx) {
                        awaitPointerEventScope {
                            while (true) {
                                lensGesture(controller, slotWidthPx)
                            }
                        }
                    },
                horizontalArrangement = Arrangement.Start,
            ) {
                navigationItems.forEachIndexed { index, screen ->
                    val isHovered = controller.dragging && controller.nearest == index
                    val isSelected = if (controller.dragging) controller.nearest == index else selectedIndex == index
                    val iconRes = if (isSelected) screen.iconIdActive else screen.iconIdInactive
                    val isSearchWithLong = screen == Screens.Search && onSearchLongClick != null
                    val isHomeWithLong = screen == Screens.Home && onHomeLongClick != null
                    val interactionSource = remember { MutableInteractionSource() }

                    NavLongPress(
                        screen = screen,
                        interactionSource = interactionSource,
                        isSelected = selectedIndex == index,
                        onItemClick = onItemClick,
                        onSearchLongClick = onSearchLongClick,
                        onHomeLongClick = onHomeLongClick,
                    )

                    val contentColor by animateColorAsState(
                        targetValue = if (isSelected) primary else colorScheme.onSurfaceVariant,
                        animationSpec = tween(160),
                        label = "glassNavContent",
                    )
                    val targetScale = when {
                        isHovered && shader == null -> 1.32f
                        isSelected -> 1.12f
                        else -> 1f
                    }
                    val iconScale by animateFloatAsState(
                        targetValue = targetScale,
                        animationSpec = spring(dampingRatio = 0.42f, stiffness = 1500f),
                        label = "glassNavIcon",
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                role = Role.Tab,
                                onClick = {
                                    onItemClick(screen, selectedIndex == index)
                                }
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(iconRes),
                            contentDescription = stringResource(screen.titleId),
                            modifier = Modifier
                                .size(if (slimNav) 24.dp else 25.dp)
                                .graphicsLayer {
                                    scaleX = iconScale
                                    scaleY = iconScale
                                },
                            tint = contentColor,
                        )
                        if (!slimNav) {
                            Text(
                                text = stringResource(screen.titleId),
                                modifier = Modifier.padding(top = 2.dp),
                                color = contentColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.labelSmall,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PillNavBar(
    navigationItems: List<Screens>,
    selectedIndex: Int,
    controller: LensController,
    onItemClick: (Screens, Boolean) -> Unit,
    pureBlack: Boolean,
    slimNav: Boolean,
    onSearchLongClick: (() -> Unit)?,
    onHomeLongClick: (() -> Unit)?,
) {
    val n = controller.n
    val colorScheme = MaterialTheme.colorScheme
    val outerShape = remember { RoundedCornerShape(22.dp) }
    val pillShape = remember { RoundedCornerShape(17.dp) }
    val primary = colorScheme.primary
    val textMeasurer = rememberTextMeasurer()
    val labelStyle = MaterialTheme.typography.labelLarge
    val titles = navigationItems.map { stringResource(it.titleId) }
    val labelWidths = remember(titles, labelStyle) {
        titles.map { textMeasurer.measure(AnnotatedString(it), labelStyle).size.width.toFloat() }
    }
    val density = LocalDensity.current
    val gapPx = with(density) { 8.dp.toPx() }
    val basePillPx = with(density) { 46.dp.toPx() }

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 6.dp)
            .fillMaxWidth()
            .height(if (slimNav) 52.dp else 62.dp)
            .graphicsLayer {
                val p = controller.press.value
                scaleX = 1f - 0.012f * p
                scaleY = 1f - 0.012f * p
            }
            .clip(outerShape)
            .background(if (pureBlack) Color(0xFF121212) else colorScheme.surfaceContainer)
            .border(1.dp, colorScheme.outlineVariant, outerShape)
            .padding(5.dp)
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val slotWidthPx = constraints.maxWidth.toFloat() / n

            Box(
                modifier = Modifier
                    .layout { measurable, constraints ->
                        val pos = controller.pos.value
                        var pillW = basePillPx
                        for (i in 0 until n) {
                            val weight = (1f - abs(pos - i)).coerceIn(0f, 1f)
                            pillW += (labelWidths[i] + gapPx) * weight
                        }
                        val w = pillW.roundToInt().coerceAtMost(constraints.maxWidth)
                        val h = constraints.maxHeight
                        val placeable = measurable.measure(
                            constraints.copy(minWidth = w, maxWidth = w, minHeight = h, maxHeight = h)
                        )
                        layout(constraints.maxWidth, h) {
                            val x = (((pos + 0.5f) * slotWidthPx) - (w / 2f)).roundToInt()
                            placeable.place(x, 0)
                        }
                    }
                    .clip(pillShape)
                    .background(primary.copy(alpha = 0.14f))
                    .border(1.dp, primary.copy(alpha = 0.34f), pillShape)
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(n, slotWidthPx) {
                        awaitPointerEventScope {
                            while (true) {
                                lensGesture(controller, slotWidthPx)
                            }
                        }
                    },
                horizontalArrangement = Arrangement.Start,
            ) {
                navigationItems.forEachIndexed { index, screen ->
                    val isSelected = if (controller.dragging) controller.nearest == index else selectedIndex == index
                    val iconRes = if (isSelected) screen.iconIdActive else screen.iconIdInactive
                    val isSearchWithLong = screen == Screens.Search && onSearchLongClick != null
                    val isHomeWithLong = screen == Screens.Home && onHomeLongClick != null
                    val interactionSource = remember { MutableInteractionSource() }

                    NavLongPress(
                        screen = screen,
                        interactionSource = interactionSource,
                        isSelected = selectedIndex == index,
                        onItemClick = onItemClick,
                        onSearchLongClick = onSearchLongClick,
                        onHomeLongClick = onHomeLongClick,
                    )

                    val contentColor by animateColorAsState(
                        targetValue = if (isSelected) primary else colorScheme.onSurfaceVariant,
                        animationSpec = tween(180),
                        label = "pillNavContent",
                    )
                    val iconScale by animateFloatAsState(
                        targetValue = if (isSelected) 1.12f else 1f,
                        animationSpec = spring(dampingRatio = 0.45f, stiffness = 1500f),
                        label = "pillNavIcon",
                    )

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                role = Role.Tab,
                                onClick = {
                                    onItemClick(screen, selectedIndex == index)
                                }
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(iconRes),
                                contentDescription = titles[index],
                                modifier = Modifier
                                    .size(24.dp)
                                    .graphicsLayer {
                                        scaleX = iconScale
                                        scaleY = iconScale
                                    },
                                tint = contentColor,
                            )
                            if (!slimNav) {
                                val factor = (1f - abs(controller.pos.value - index)).coerceIn(0f, 1f)
                                Box(
                                    modifier = Modifier
                                        .layout { measurable, constraints ->
                                            val placeable = measurable.measure(constraints.copy(minWidth = 0))
                                            val width = ((placeable.width + gapPx) * factor).roundToInt()
                                            layout(width, placeable.height) {
                                                placeable.place(gapPx.roundToInt(), 0)
                                            }
                                        }
                                        .graphicsLayer { alpha = factor }
                                ) {
                                    Text(
                                        text = titles[index],
                                        color = contentColor,
                                        maxLines = 1,
                                        softWrap = false,
                                        overflow = TextOverflow.Clip,
                                        style = labelStyle,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun NavLongPress(
    screen: Screens,
    interactionSource: MutableInteractionSource,
    isSelected: Boolean,
    onItemClick: (Screens, Boolean) -> Unit,
    onSearchLongClick: (() -> Unit)?,
    onHomeLongClick: (() -> Unit)?,
) {
    val haptics = LocalHapticFeedback.current
    val viewConfig = LocalViewConfiguration.current
    val isSearch = screen == Screens.Search && onSearchLongClick != null
    val isHome = screen == Screens.Home && onHomeLongClick != null
    val currentSelected by rememberUpdatedState(isSelected)

    if (isSearch || isHome) {
        LaunchedEffect(interactionSource) {
            interactionSource.interactions.collectLatest { interaction ->
                if (interaction is PressInteraction.Press) {
                    delay(viewConfig.longPressTimeoutMillis)
                    haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                    if (isHome) {
                        onHomeLongClick?.invoke()
                    } else if (isSearch) {
                        onSearchLongClick?.invoke()
                    }
                }
            }
        }
    }
}

fun isRouteSelected(currentRoute: String?, route: String, items: List<Screens>): Boolean {
    if (currentRoute == null) return false
    if (currentRoute == route) return true
    if (items.any { it.route == route } && currentRoute.startsWith("$route/")) return true
    if (route == "search_input" && (currentRoute.startsWith("search/") || currentRoute == "search/{query}")) {
        return true
    }
    return false
}

private suspend fun AwaitPointerEventScope.lensGesture(
    controller: LensController,
    slotWidthPx: Float
) {
    val down = awaitFirstDown(requireUnconsumed = false)
    controller.scope.launch {
        controller.press.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 700f))
    }

    val velocityTracker = VelocityTracker()
    velocityTracker.addPosition(down.uptimeMillis, down.position)
    var currentPos = controller.pos.value

    val dragStart = awaitHorizontalTouchSlopOrCancellation(down.id) { change, overSlop ->
        change.consume()
        controller.dragging = true
        currentPos = (currentPos + overSlop / slotWidthPx).coerceIn(0f, (controller.n - 1).toFloat())
        controller.scope.launch {
            controller.pos.snapTo(currentPos)
            controller.stretch.snapTo((abs(overSlop) / slotWidthPx).coerceIn(0f, 1f))
        }
    }

    if (dragStart != null) {
        horizontalDrag(dragStart.id) { change ->
            val dx = change.positionChange().x
            change.consume()
            velocityTracker.addPosition(change.uptimeMillis, change.position)
            currentPos = (currentPos + dx / slotWidthPx).coerceIn(0f, (controller.n - 1).toFloat())
            controller.scope.launch {
                controller.pos.snapTo(currentPos)
                controller.stretch.snapTo((abs(dx) / (slotWidthPx * 0.25f)).coerceIn(0f, 1f))
            }
        }
    }

    val velocityX = if (dragStart != null) velocityTracker.calculateVelocity().x else 0f
    val wasDragging = controller.dragging
    controller.dragging = false

    controller.scope.launch {
        controller.press.animateTo(0f, spring(dampingRatio = 0.55f, stiffness = 520f))
    }
    controller.scope.launch {
        controller.stretch.animateTo(0f, spring(dampingRatio = 0.5f, stiffness = 500f))
    }

    if (wasDragging) {
        val target = ((controller.pos.value + (velocityX / slotWidthPx) * 0.18f).roundToInt())
            .coerceIn(0, controller.n - 1)
        controller.scope.launch {
            controller.pos.animateTo(
                targetValue = target.toFloat(),
                animationSpec = spring(dampingRatio = 0.72f, stiffness = 520f)
            )
        }
        if (target != controller.selected) {
            controller.haptics.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            controller.onSelect(target)
        }
    }
}
