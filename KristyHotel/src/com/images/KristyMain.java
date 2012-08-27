package com.images;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class KristyMain extends ListActivity{
    /** Called when the activity is first created. */
	private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Weather weather_data[] = new Weather[]
        {
            new Weather(R.drawable.home_icon, "Home"),
            new Weather(R.drawable.menu_icon, "Menu"),
            new Weather(R.drawable.call_icon, "Call"),
            new Weather(R.drawable.place_icon, "Find Us"),
           
        };
        
        WeatherAdapter adapter = new WeatherAdapter(this, 
                R.layout.listview_item_row, weather_data);
        
        
        listView = getListView();
         
        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        
       
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), position, Toast.LENGTH_SHORT).show();
				if(position == 1){
					Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
					startActivity(new Intent(getApplicationContext(), Home.class));
				}else if(position == 2){
//					onCreateOptionsMenu(n);
				
					Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
				}else if(position == 3){
		
	        		Intent call = new Intent (Intent.ACTION_DIAL);
	        		call.setData(Uri.parse("tel: 0714019079"));
	        		startActivity(call);
				}else if(position == 4){
					startActivity(new Intent(getApplicationContext(), Mapper.class));				
				}
			}				
		});          	
    }

	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();//
        inflater.inflate(R.menu.menu, menu);//Access menu folder which contains menu.xml file.
		
		return true;
	}   
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.branch:
			Toast.makeText(getApplicationContext(), "Branches", Toast.LENGTH_SHORT).show();
			break;
		case R.id.cities:
			Toast.makeText(getApplicationContext(), "Cities", Toast.LENGTH_SHORT).show();
			break;
		case R.id.drinks:
			Toast.makeText(getApplicationContext(), "Drinks", Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}
}