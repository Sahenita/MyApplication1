package com.example.accenture_nevigation_app.Utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.*;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.example.accenture_nevigation_app.R;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils 
{

	//To check email is valid or not
	public final static boolean isValidEmail(CharSequence target) {
		  if (TextUtils.isEmpty(target)) {
		    return false;
		  } else {
		    return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
		  }
		}
	
	
	 public  void setupUI(View view, final Activity activity) {


	        //Set up touch listener for non-text box views to hide keyboard.
	        if(!(view instanceof EditText)) {

	           view.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					hideKeyboard(activity);
                    return false;
				}
			  });
	        }

	        //If a layout container, iterate over children and seed recursion.

	    }

	//To hide keyboard pass parent view and activity
    public  void hideCheck(ViewGroup viewGroup, Activity activity)
    {

        if (viewGroup instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) viewGroup).getChildCount(); i++) {

                View innerView = ((ViewGroup) viewGroup).getChildAt(i);

                setupUI(innerView,activity);
            }
            
            setupUI(viewGroup,activity);
        }
    }
    
    
    public  void hideKeyboard(Activity activity) {
		try {
			InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
		    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    
	}



	public boolean isNetworkConnected(Activity activity) {
		ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		return ni != null;
	}

	public String getDeviceName() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer)) {
			return capitalize(model);
		} else {
			return capitalize(manufacturer) + " " + model;
		}
	}

	private String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }


	public String getCurrentDateInSpecificFormat(Calendar currentCalDate) {
		String dayNumberSuffix = getDayNumberSuffix(currentCalDate.get(Calendar.DAY_OF_MONTH));
		SimpleDateFormat dateFormat = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMMM" +" yyyy");
		return dateFormat.format(currentCalDate.getTime());
	}

	public String getCurrentDateInSpecificFormatSubscription(Calendar currentCalDate) {
		String dayNumberSuffix = getDayNumberSuffix(currentCalDate.get(Calendar.DAY_OF_MONTH));
		SimpleDateFormat dateFormat = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMMM" +", yyyy");
		return dateFormat.format(currentCalDate.getTime());
	}

	private String getDayNumberSuffix(int day) {
		if (day >= 11 && day <= 13) {
			return "th";
		}
		switch (day % 10) {
			case 1:
				return "st";
			case 2:
				return "nd";
			case 3:
				return "rd";
			default:
				return "th";
		}
	}


	private final static long MILLISECS_PER_DAY = 24 * 60 * 60 * 1000;

	private static long getDateToLong(Date date) {
		return Date.UTC(date.getYear(), date.getMonth(), date.getDate(), 0, 0, 0);
	}

	//To get difference of two dates
	public static int getSignedDiffInDays(Date beginDate, Date endDate) {
		long beginMS = getDateToLong(beginDate);
		long endMS = getDateToLong(endDate);
		long diff = (endMS - beginMS) / (MILLISECS_PER_DAY);
		return (int)diff;
	}

	public static int getUnsignedDiffInDays(Date beginDate, Date endDate) {
		return Math.abs(getSignedDiffInDays(beginDate, endDate));
	}


	//To convert string to date value
	public static Date getDateFromString(String str_date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = (Date)formatter.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}

	//To convert string to date value
	public static Date getDateFromStringDob(String str_date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = (Date)formatter.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}

	//To convert string to date value
	public static Date getDateFromStringDobfb(String str_date) {

		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date date = null;
		try {
			date = (Date)formatter.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}

	//To convert date to string value
	public  static Date getDateTimeFromString(String str_date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss");
		Date date = null;
		try {
			date = (Date)formatter.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}

	public Date feedDateTimeFromString(String str_date) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh.mm");
		Date date = null;
		try {
			date = (Date)formatter.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}
	public static  boolean fileExistance(String fname, Activity activity){
//		File file = activity.getFileStreamPath(fname);
		File file = new File(fname);
		return file.exists();

	}

	public int getDeviceScreenWidth(Activity activity)
	{
		int width = 0;
		WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		width  = display.getWidth();
		return  width;
	}
	public int getDeviceScreenHeight(Activity activity)
	{
		int height = 0;
		WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		height  = display.getHeight();
		return  height;
	}
	public String getTimeZone()
	{
		TimeZone tz = TimeZone.getDefault();
		return tz.getID();
	}

	public static void showDialog(final Activity activity, String message) {
		AlertDialog.Builder builder =
				new AlertDialog.Builder(activity, R.style.AppCompatAlertDialogStyle);
		builder.setTitle("Attention!");
		builder.setMessage(message);
		builder.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				openSettingsApp(activity);
			}
		});
		builder.setNegativeButton("Cancel", null);
		builder.show();
	}

	public static void openSettingsApp(Context context) {

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
			intent.setData(Uri.parse("package:" + context.getPackageName()));
			context.startActivity(intent);
		}
	}
}
