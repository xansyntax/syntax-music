package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class AccountMenuResponse(
    val actions: List<Action>? = null,
) {

    @Serializable
    data class Action(
        val openPopupAction: OpenPopupAction? = null,
    ) {

        @Serializable
        data class OpenPopupAction(
            val popup: Popup? = null,
        ) {

            @Serializable
            data class Popup(
                val multiPageMenuRenderer: MultiPageMenuRenderer? = null,
            ) {

                @Serializable
                data class MultiPageMenuRenderer(
                    val header: Header? = null,
                ) {

                    @Serializable
                    data class Header(
                        val activeAccountHeaderRenderer: ActiveAccountHeaderRenderer? = null,
                    ) {

                        @Serializable
                        data class ActiveAccountHeaderRenderer(
                            val accountName: Runs? = null,
                            val accountPhoto: Thumbnails? = null,
                            val channelHandle: Runs? = null,
                            val email: Runs? = null,
                        ) {
                            fun toAccountInfo(): AccountInfo {
                                val name = accountName?.runs?.firstOrNull()?.text.orEmpty()
                                val emailStr = email?.runs?.firstOrNull()?.text
                                val handle = channelHandle?.runs?.firstOrNull()?.text
                                val photoUrl = accountPhoto?.thumbnails?.lastOrNull()?.url
                                return AccountInfo(name = name, email = emailStr, channelHandle = handle, thumbnailUrl = photoUrl)
                            }
                        }
                    }
                }
            }
        }
    }
}
