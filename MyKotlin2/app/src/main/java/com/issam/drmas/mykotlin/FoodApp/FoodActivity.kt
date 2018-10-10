package com.issam.drmas.mykotlin.FoodApp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.issam.drmas.mykotlin.R
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_food.view.*
import kotlinx.android.synthetic.main.foottacket.view.*
import kotlinx.android.synthetic.main.title_tacket.view.*

class FoodActivity : AppCompatActivity() {

    var listOfFood = ArrayList<Food>()
    var adapter:FoodAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        loadFood()

        adapter=FoodAdapter(listOfFood, this)
        gvFood.adapter = adapter
    }

    fun loadFood(){
      //  listOfFood.add(Food("title_app", "General", R.mipmap.ic_launcher))

        listOfFood.add(Food("Coffee", "This is some Description This is some Description This is some Description This is some Description", R.mipmap.ic_launcher))
        listOfFood.add(Food("Coffee", "This is some Description This is some Description This is some Description This is some Description", R.mipmap.ic_launcher))
        listOfFood.add(Food("Coffee", "This is some Description This is some Description This is some Description This is some Description", R.mipmap.ic_launcher))

     //   listOfFood.add(Food("title_app", "Beverage", R.mipmap.ic_launcher))

        listOfFood.add(Food("Coffee", "This is some Description This is some Description This is some Description This is some Description", R.mipmap.ic_launcher))
        listOfFood.add(Food("Coffee", "This is some Description This is some Description This is some Description This is some Description", R.mipmap.ic_launcher))
        listOfFood.add(Food("Coffee", "This is some Description This is some Description This is some Description This is some Description", R.mipmap.ic_launcher))
    }

  inner class FoodAdapter:BaseAdapter {

        var context:Context?=null
        var listOfFoodLocal = ArrayList<Food>()

        constructor(listOfFoods:ArrayList<Food>, context: Context){
            listOfFoodLocal= listOfFoods
            this.context = context

        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val food = listOfFoodLocal[position]

                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val foodView = inflater.inflate(R.layout.foottacket, null)
                foodView.txtName.text = food.name!!
                foodView.imgFood.setImageResource(food.image!!)

                foodView.imgFood.setOnClickListener {

                    val intent = Intent(context, FoodDetailsActivity::class.java)
                    intent.putExtra("name", food.name!!)
                    intent.putExtra("des", food.des!!)
                    intent.putExtra("image", food.image!!)
                    context!!.startActivity(intent)

                    //    addITem(position)

                }

                return foodView
        }


        override fun getItem(position: Int): Any {
            return listOfFoodLocal[position]
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFoodLocal.size
        }
    }

    fun deleteItem(index: Int) {

        listOfFood.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun addITem(index: Int){
        listOfFood.add(index, listOfFood[index])
        adapter!!.notifyDataSetChanged()
    }

}
