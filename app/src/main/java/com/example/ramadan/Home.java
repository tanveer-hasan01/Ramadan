package com.example.ramadan;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ramadan.databinding.FragmentHomeBinding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Home extends Fragment {

    private FragmentHomeBinding binding;
    Date start;

    int count;

    public Home() {

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container!=null)
        {
            container.removeAllViews();
        }

        binding = FragmentHomeBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        binding.currentDate.setText(formattedDate);

        binding.seheriLinearProgress.setMax(100);

        count =1;
        binding.seheriLinearProgress.setVisibility(View.VISIBLE);
        binding.seheriLinearProgress.setProgress(0);

        String currentTime = new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());





        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        Date startDate = null;
        try {
            startDate = simpleDateFormat.parse("06:00:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = null;
        try {
            endDate = simpleDateFormat.parse("09:10:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long difference = endDate.getTime() - startDate.getTime();
        if(difference<0)
        {
            Date dateMax = null;
            try {
                dateMax = simpleDateFormat.parse("24:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date dateMin = null;
            try {
                dateMin = simpleDateFormat.parse("00:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            difference=(dateMax.getTime() -startDate.getTime() )+(endDate.getTime()-dateMin.getTime());
        }
        int days = (int) (difference / (1000*60*60*24));
        int hours = (int) ((difference - (1000*60*60*days)) / (1000*60*60));
        int min = (int) (difference - (1000*60*60*24) - (1000*60*60*hours)) / (1000*60);
        int sec = (int) (difference - (1000*60*60*24) - (1000*60*60*hours) - (1000*60*min)) / (1000);


        Toast.makeText(getContext(), ""+min, Toast.LENGTH_LONG).show();*/


      /*  Duration diff = Duration.between()
        System.out.println(diff);*/



     /*   String t1 = "01:01:00";
        String t2 = "01:02:00";
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

        Date d1 = null;
        try {
            d1 = sdf.parse(t1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d2 = null;
        try {
            d2 = sdf.parse(t2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        if(c2.get(Calendar.HOUR_OF_DAY) < 12) {
            c2.set(Calendar.DAY_OF_YEAR, c2.get(Calendar.DAY_OF_YEAR) + 1);
        }
        long elapsed = c2.getTimeInMillis() - c1.getTimeInMillis();*/

       // binding.seheriEnd.setText(""+elapsed);



        binding.seheriLinearProgress.setMax(100);

        count =1;
        binding.seheriLinearProgress.setProgress(0);
        new MyTask().execute(100);




        return view;
    }

    class MyTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            for (count=1 ; count <= params[0]; count++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Task Completed.";
        }
        @Override
        protected void onPostExecute(String result) {

           // txt.setText(result);
           // btn.setText("Restart");
        }
        @Override
        protected void onPreExecute() {
           // txt.setText("Task Starting...");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            //txt.setText("Running..."+ values[0]);
            binding.seheriLinearProgress.setProgress(values[0]);
        }
    }
}