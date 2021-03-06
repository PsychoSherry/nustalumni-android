package com.impsycho.nustalumni;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class NewsRowAdapter extends ArrayAdapter<String>{
	private final Context context;
	private final String[] order_data;
	
	public NewsRowAdapter(Context context, String[] order_data) {
		super(context, R.layout.row_news, order_data);
		this.context = context;
		this.order_data = order_data;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView;
		rowView = inflater.inflate(R.layout.row_news, parent, false);

		final TextView  title = (TextView)  rowView.findViewById (R.id.row_news_title);
		final TextView  date  = (TextView)  rowView.findViewById (R.id.row_news_date);
		final ImageView image = (ImageView) rowView.findViewById (R.id.row_news_image);
		
		title.setText(order_data[position]);
		date.setText(ParseValues.news_dates.get(position));
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
	        .cacheInMemory(true)
	        .cacheOnDisc(true)
	        .build();
		ImageLoader.getInstance().displayImage(ParseValues.news_images.get(position), image, options);

		return rowView;
	}

}