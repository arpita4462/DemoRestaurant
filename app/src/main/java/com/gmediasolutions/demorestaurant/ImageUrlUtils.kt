package com.gmediasolutions.demorestaurant

import java.util.ArrayList

open class ImageUrlUtils {
    companion object {

        var cartListImageUrijvm = ArrayList<String>()
        var orderListImageUrijvm = ArrayList<String>()

        val imageUrls: Array<String>
            get() = arrayOf("https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350")
        val offersUrls: Array<String>
            get() = arrayOf( "https://images.pexels.com/photos/1028637/pexels-photo-1028637.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1154756/pexels-photo-1154756.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1153211/pexels-photo-1153211.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/169391/pexels-photo-169391.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1028637/pexels-photo-1028637.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/687824/pexels-photo-687824.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/62097/pexels-photo-62097.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/958547/pexels-photo-958547.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/374052/pexels-photo-374052.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/670705/pexels-photo-670705.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1268558/pexels-photo-1268558.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/724216/pexels-photo-724216.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350",
               "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350")
        val StarterUrls: Array<String>
            get() = arrayOf("https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/718742/pexels-photo-718742.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/718742/pexels-photo-718742.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/718742/pexels-photo-718742.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/718742/pexels-photo-718742.jpeg?auto=compress&cs=tinysrgb&h=350")
        val southIndianUrls: Array<String>
            get() = arrayOf("https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/263173/pexels-photo-263173.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/236795/pexels-photo-236795.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/209540/pexels-photo-209540.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/263173/pexels-photo-263173.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/236795/pexels-photo-236795.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/209540/pexels-photo-209540.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350")
        val northIndianUrls: Array<String>
            get() = arrayOf("https://images.pexels.com/photos/263173/pexels-photo-263173.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/236795/pexels-photo-236795.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/209540/pexels-photo-209540.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/263173/pexels-photo-263173.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/236795/pexels-photo-236795.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/209540/pexels-photo-209540.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350")
        val dessertsUrls: Array<String>
            get() = arrayOf("https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461431/pexels-photo-461431.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461175/pexels-photo-461175.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461430/pexels-photo-461430.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&h=350", "https://images.pexels.com/photos/434258/pexels-photo-434258.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461431/pexels-photo-461431.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461175/pexels-photo-461175.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461430/pexels-photo-461430.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461431/pexels-photo-461431.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461175/pexels-photo-461175.jpeg?auto=compress&cs=tinysrgb&h=350","https://images.pexels.com/photos/461430/pexels-photo-461430.jpeg?auto=compress&cs=tinysrgb&h=350")
        val drinksUrls: Array<String>
            get() = arrayOf("https://images.pexels.com/photos/1028637/pexels-photo-1028637.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1154756/pexels-photo-1154756.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1153211/pexels-photo-1153211.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/169391/pexels-photo-169391.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1028637/pexels-photo-1028637.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1154756/pexels-photo-1154756.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1153211/pexels-photo-1153211.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/169391/pexels-photo-169391.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1028637/pexels-photo-1028637.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1154756/pexels-photo-1154756.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1153211/pexels-photo-1153211.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/169391/pexels-photo-169391.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1028637/pexels-photo-1028637.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1154756/pexels-photo-1154756.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/1153211/pexels-photo-1153211.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://images.pexels.com/photos/169391/pexels-photo-169391.jpeg?auto=compress&cs=tinysrgb&h=350")



        // Methods for Cart List
        fun addCartListImageUri(cardlistImageUri: String) {
            this.cartListImageUrijvm.add(0, cardlistImageUri)
        }

        fun removeCartListImageUri(position: Int) {
            this.cartListImageUrijvm.removeAt(position)
        }
        fun clearCartListImageUri() {
            this.cartListImageUrijvm.clear()
        }

        fun getCartListImageUri(): ArrayList<String> {
            return this.cartListImageUrijvm
        }

        // Methods for Order List
        fun addOrderListImageUri(orderlistImageUri: String) {
            this.orderListImageUrijvm.add(0, orderlistImageUri)
        }
        
        fun removeorderListImageUri(position: Int) {
            this.orderListImageUrijvm.removeAt(position)
        }

        fun getorderListImageUri(): ArrayList<String> {
            return this.orderListImageUrijvm
        }

    }

}
