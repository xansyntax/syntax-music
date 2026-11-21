package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    val menuRenderer: MenuRenderer? = null,
) {

    @Serializable
    data class MenuRenderer(
        val items: List<Item>? = null,
        val topLevelButtons: List<TopLevelButton>? = null,
    ) {

        @Serializable
        data class Item(
            val menuNavigationItemRenderer: MenuNavigationItemRenderer? = null,
            val menuServiceItemRenderer: MenuServiceItemRenderer? = null,
            val toggleMenuServiceItemRenderer: ToggleMenuServiceRenderer? = null,
        ) {

            @Serializable
            data class MenuNavigationItemRenderer(
                val icon: Icon? = null,
                val navigationEndpoint: NavigationEndpoint? = null,
                val text: Runs? = null,
            )

            @Serializable
            data class MenuServiceItemRenderer(
                val icon: Icon? = null,
                val serviceEndpoint: NavigationEndpoint? = null,
                val text: Runs? = null,
            )

            @Serializable
            data class ToggleMenuServiceRenderer(
                val defaultIcon: Icon? = null,
                val defaultServiceEndpoint: DefaultServiceEndpoint? = null,
                val isSelected: Boolean = false,
                val toggledServiceEndpoint: ToggledServiceEndpoint? = null,
            )
        }

        @Serializable
        data class TopLevelButton(
            val buttonRenderer: ButtonRenderer? = null,
        ) {

            @Serializable
            data class ButtonRenderer(
                val icon: Icon? = null,
                val navigationEndpoint: NavigationEndpoint? = null,
            )
        }
    }
}
