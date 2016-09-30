package org.thoughtcrime.securesms.components.reminder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import org.thoughtcrime.securesms.R;
import org.thoughtcrime.securesms.util.Util;

public class OutdatedBuildReminder extends Reminder {

  public OutdatedBuildReminder(final Context context) {
    super(context.getString(R.string.reminder_header_outdated_build, context.getString(R.string.app_name)),
          getPluralsText(context));
    setOkListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName())));
        } catch (android.content.ActivityNotFoundException anfe) {
          context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
      }
    });
  }

  private static CharSequence getPluralsText(final Context context) {
    int days = Util.getDaysTillBuildExpiry() - 1;
    if (days == 0) {
      return context.getString(R.string.reminder_header_outdated_build_details_today, context.getString(R.string.app_name));
    }
    return context.getResources().getQuantityString(R.plurals.reminder_header_outdated_build_details, days, days);
  }

  @Override
  public boolean isDismissable() {
    return false;
  }

  public static boolean isEligible() {
    return Util.getDaysTillBuildExpiry() <= 10;
  }

}
