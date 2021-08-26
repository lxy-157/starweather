package com.example.coolweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coolweather.R;
import com.example.coolweather.bean.DayWeatherBean;
import com.example.coolweather.bean.WeatherBean;

import java.util.List;

public class FutureWeatherAdapter extends RecyclerView.Adapter<FutureWeatherAdapter.WeatherViewHolder> {

    private Context mContext;
    private List<DayWeatherBean> mWeatherBeans;

    public FutureWeatherAdapter(Context mContext, List<DayWeatherBean> mWeatherBeans) {
        this.mContext = mContext;
        this.mWeatherBeans = mWeatherBeans;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.weather_item_layout, parent, false);
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(view);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        DayWeatherBean weatherBean = mWeatherBeans.get(position);
        holder.tvWeather.setText(weatherBean.getWea());
        //   + "\n" + weatherBean.getDate()
        holder.tvdate.setText(weatherBean.getDate());
        holder.tvTem.setText(weatherBean.getTem());
        holder.tvTemLowHigh.setText(weatherBean.getTem2() + "~" + weatherBean.getTem1());
        holder.tvWin.setText(weatherBean.getWin()[0] + weatherBean.getWin_speed());
        holder.tvAir.setText("空气:" + weatherBean.getAir() + weatherBean.getAir_level());
        holder.ivWeather.setImageResource(getImgResOfWeather(weatherBean.getWea_img()));


    }

    private int getImgResOfWeather(String weaStr){
        int result = 0;
        switch (weaStr) {
            case "qing":
                result = R.drawable.biz_plugin_weather_qing;
                break;
            case "yin":
                result = R.drawable.biz_plugin_weather_yin;
                break;
            case "yu":
                result = R.drawable.biz_plugin_weather_dayu;
                break;
            case "yun":
                result = R.drawable.biz_plugin_weather_duoyun;
                break;
            case "bingbao":
                result = R.drawable.biz_plugin_weather_leizhenyubingbao;
                break;
            case "wu":
                result = R.drawable.biz_plugin_weather_wu;
                break;
            case "shachen":
                result = R.drawable.biz_plugin_weather_shachenbao;
                break;
            case "lei":
                result = R.drawable.biz_plugin_weather_leizhenyu;
                break;
            case "xue":
                result = R.drawable.biz_plugin_weather_daxue;
                break;
            default:
                result = R.drawable.biz_plugin_weather_qing;
                break;
        }

        return result;
    }

    @Override
    public int getItemCount() {
        if (mWeatherBeans == null){
            return 0;
        }
        return mWeatherBeans.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{

        TextView tvWeather,tvTem,tvTemLowHigh,tvWin,tvAir,tvdate;
        ImageView ivWeather;


        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWeather = itemView.findViewById(R.id.tv_weather);
            tvAir = itemView.findViewById(R.id.tv_air);
            tvdate = itemView.findViewById(R.id.tv_date);
            tvTem = itemView.findViewById(R.id.tv_tem);
            tvTemLowHigh = itemView.findViewById(R.id.tv_tem_low_high);
            tvWin = itemView.findViewById(R.id.tv_win);
            ivWeather = itemView.findViewById(R.id.iv_weather);
        }
    }
}
