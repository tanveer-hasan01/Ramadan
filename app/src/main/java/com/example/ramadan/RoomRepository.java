package com.example.ramadan;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomRepository {

    private RoomDao roomDao;
    private MyRoomDataBase roomDataBase;
    private LiveData<java.util.List<Model_Room>> allData;
    private Context context;

    public RoomRepository(Context context) {
        this.context = context;
        roomDataBase = MyRoomDataBase.getInstance(context);
        roomDao = roomDataBase.roomDao();
        allData = roomDao.getAllData();
    }

    public LiveData<List<Model_Room>> getAllData(){
        return  this.allData;
    }

    public void insertSingleData(Model_Room cartdb)
    {
        new InsetData(roomDao).execute(cartdb);
    }

    public void update(Model_Room cartdb)
    {
        new UpdateData(roomDao).execute(cartdb);
    }

    public void delete(Model_Room cartdb)
    {
        new DeleteData(roomDao).execute(cartdb);
    }


    private class InsetData extends AsyncTask<Model_Room, Void, Void> {
        RoomDao roomDao;
        public InsetData(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Model_Room... modelCartRooms) {
            roomDao.insertSingleData(modelCartRooms[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Add to Cart", Toast.LENGTH_SHORT).show();
        }
    }


    private class UpdateData extends AsyncTask<Model_Room, Void, Void> {
        RoomDao roomDao;


        public  UpdateData(RoomDao roomDao) {
            this.roomDao = roomDao;

        }

        @Override
        protected Void doInBackground(Model_Room... modelCartRooms) {
            roomDao.updateSingleData(modelCartRooms[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //  Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
        }
    }

    private class DeleteData extends AsyncTask<Model_Room, Void, Void> {
        RoomDao roomDao;
        public DeleteData(RoomDao roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Model_Room... modelCartRooms) {
            roomDao.DeleteSingleData(modelCartRooms[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Toast.makeText(context, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
    }



}
