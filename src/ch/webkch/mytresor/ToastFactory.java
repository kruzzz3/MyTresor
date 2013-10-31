package ch.webkch.mytresor;

import android.content.Context;
import android.widget.Toast;

public class ToastFactory {

	public static Toast getToast(Context context, String text)
	{
		int duration = Toast.LENGTH_SHORT;

		return Toast.makeText(context, text, duration);
	}
}
