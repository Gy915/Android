package com.bytedance.android.lesson.restapi.solution;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>
{


    public List<Fruit> mFruitList;
    //把布局文件中所有内容加到viewholder中
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView fruitName;
        View fruitView;
        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitName=(TextView)view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList)
    {
        mFruitList=fruitList;
    }
    @NonNull
@Override
    //加载一个布局，将布局中所有view传到viewholder
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);//这里的view是最外层布局
        return holder;
}

    @Override
    //子项滚动到屏幕上时执行这个语句
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit=mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    //返回子项数量
    public int getItemCount() {
        return mFruitList.size();
    }
}