package org.thoughtcrime.securesms;

import android.content.Context;

/**
 * Format a string resource with this application name.
 */
public final class AppStringFormat {

    private AppStringFormat() {}

    /**
     * Format a resource string with the application name.
     * @param context Context object to get the resource from.
     * @param resourceId Resource ID.
     * @return formatted string.
     */
    public static final String format(Context context, int resourceId) {
        return String.format(context.getString(resourceId), context.getString(R.string.app_name));
    }

}
