package com.example.perritosapk.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.perritosapk.databinding.FragmentFirstBinding
import com.example.perritosapk.databinding.ItemDogBinding
import com.example.perritosapk.pojo.BreedEntity
import java.util.concurrent.Delayed

class DogAdapter : RecyclerView.Adapter<DogAdapter.DogVH>() {

private var mlistDog = listOf<BreedEntity>()
    private val selectedDogBreed = MutableLiveData<BreedEntity>()
    fun selectedDogItem() :LiveData<BreedEntity> = selectedDogBreed

    fun update(listDog : List<BreedEntity>){
        mlistDog = listDog
        notifyDataSetChanged()
    }

    inner class DogVH(private val binding: ItemDogBinding) :RecyclerView.ViewHolder(binding.root),
    View.OnClickListener{

    fun bind (breedEntity: BreedEntity){
    binding.btnBreed.text = breedEntity.breed
        itemView.setOnClickListener(this)
}


    override fun onClick(p0: View?) {

       selectedDogBreed.value = mlistDog[adapterPosition]
        Log.d("click","perros")
    }


}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogVH {
       return DogVH(ItemDogBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DogVH, position: Int) {
    val dog = mlistDog[position]
        holder.bind(dog)
    }

    override fun getItemCount(): Int = mlistDog.size


}