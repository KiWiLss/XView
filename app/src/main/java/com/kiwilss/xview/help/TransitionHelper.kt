/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kiwilss.xview.help

import android.R
import android.app.Activity
import android.view.View
import androidx.core.util.Pair
import java.util.*

/**
 * Helper class for creating content transitions used with [android.app.ActivityOptions].
 */
internal object TransitionHelper {
    /**
     * Create the transition participants required during a activity transition while
     * avoiding glitches with the system UI.
     *
     * @param activity The activity used as start for the transition.
     * @param includeStatusBar If false, the status bar will not be added as the transition
     * participant.
     * @return All transition participants.
     */
    fun createSafeTransitionParticipants(
        activity: Activity,
        includeStatusBar: Boolean, vararg otherParticipants: Pair<View, String>
    ): Array<Pair<View, String>> {
        // Avoid system UI glitches as described here:
        // https://plus.google.com/+AlexLockwood/posts/RPtwZ5nNebb
        val decor = activity.window.decorView
        var statusBar: View? = null
        if (includeStatusBar) {
            statusBar = decor.findViewById(R.id.statusBarBackground)
        }
        val navBar =
            decor.findViewById<View>(R.id.navigationBarBackground)

        // Create pair of transition participants.
        val participants: MutableList<Pair<View, String>> =
            ArrayList(3)
        addNonNullViewToTransitionParticipants(statusBar, participants)
        addNonNullViewToTransitionParticipants(navBar, participants)
        // only add transition participants if there's at least one none-null element
        if (!(otherParticipants.size == 1
                    && otherParticipants[0] == null)
        ) {
            participants.addAll(listOf(*otherParticipants))
        }
        return participants.toTypedArray()
    }

    private fun addNonNullViewToTransitionParticipants(
        view: View?,
        participants: MutableList<Pair<View, String>>
    ) {
        if (view == null) {
            return
        }
        participants.add(
            Pair(
                view,
                view.transitionName
            )
        )
    }
}